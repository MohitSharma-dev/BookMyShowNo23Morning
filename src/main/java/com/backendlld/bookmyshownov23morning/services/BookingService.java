package com.backendlld.bookmyshownov23morning.services;

import com.backendlld.bookmyshownov23morning.models.*;
import com.backendlld.bookmyshownov23morning.repositories.BookingRepository;
import com.backendlld.bookmyshownov23morning.repositories.ShowRepository;
import com.backendlld.bookmyshownov23morning.repositories.ShowSeatRepository;
import com.backendlld.bookmyshownov23morning.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;

import javax.swing.text.html.Option;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class BookingService {
    private BookingRepository bookingRepository;
    private UserRepository userRepository;
    private ShowSeatRepository showSeatRepository;
    private ShowRepository showRepository;
    private PriceCalculator priceCalculator;

    @Autowired
    BookingService(BookingRepository bookingRepository,
                   UserRepository userRepository,
                   ShowSeatRepository showSeatRepository,
                   ShowRepository showRepository,
                   PriceCalculator priceCalculator
    ){
        this.bookingRepository = bookingRepository;
        this.userRepository = userRepository;
        this.showSeatRepository = showSeatRepository;
        this.showRepository = showRepository;
    }

    @Transactional(isolation = Isolation.SERIALIZABLE)
    public Booking bookTicket(
        List<Integer> showSeatIds,
        Integer userId,
        Integer showId
    ){
//        1. Get the user from the userId
        Optional<User> userOptional =  userRepository.findById(userId);
        if(userOptional.isEmpty()){
            throw new RuntimeException("User not found");
        }
        User user = userOptional.get();
//        2. Get the Show from the showId
        Optional<Show> showOptional = showRepository.findById(showId);
        if(showOptional.isEmpty()){
            throw new RuntimeException("Show not found");
        }
        Show show = showOptional.get();
//         ------------  START TRANSACTION ---------
//        3. Get the ShowSeats from the showSeatIds
        List<ShowSeat> showSeats = showSeatRepository.findAllById(showSeatIds);
//        4. check if all the showSeats are available
        for(ShowSeat showSeat : showSeats){
            if(!showSeat.getSeatStatus().equals(SeatStatus.EMPTY)){
//                6. If not, throw an exception
                throw new RuntimeException("Selected show seats are not available");
            }
        }
//        5. If all are available, block the seats
        for(ShowSeat showSeat : showSeats){
            showSeat.setSeatStatus(SeatStatus.BLOCKED);
            showSeat.setBlockedAt(new Date());
        }
//        7. Save the ShowSeats with updated status in the database
        showSeatRepository.saveAll(showSeats);
//
//
//        ------------ STOP TRANSACTION ---------
//        8. Create Booking Object, save it  and return it
        Booking booking = new Booking();
        booking.setBookedBy(user);
        booking.setDate(new Date());
        booking.setStatus(BookingStatus.PENDING);
        booking.setPayments(new ArrayList<>());
        booking.setShowSeats(showSeats);
        booking.setAmount(priceCalculator.calculatePrice(booking.getShowSeats()));

        return bookingRepository.save(booking);
    }
}

// HW
//PriceCalculator Service : calculatePrice

// selected showSeats
//      find the seatType
//          add the corresponding amount in total