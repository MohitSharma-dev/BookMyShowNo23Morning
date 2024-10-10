package com.backendlld.bookmyshownov23morning.controllers;

import com.backendlld.bookmyshownov23morning.dtos.BookTicketRequestDTO;
import com.backendlld.bookmyshownov23morning.dtos.BookTicketResponseDTO;
import com.backendlld.bookmyshownov23morning.dtos.ResponseStatus;
import com.backendlld.bookmyshownov23morning.models.Booking;
import com.backendlld.bookmyshownov23morning.services.BookingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class BookingController {
//    @Autowired
    private BookingService bookingService;

    @Autowired
    BookingController(BookingService bookingService){
        this.bookingService = bookingService;
    }

    public BookTicketResponseDTO bookTicket(BookTicketRequestDTO request){
        BookTicketResponseDTO response = new BookTicketResponseDTO();
        try {
            Booking booking = bookingService.bookTicket(
                    request.getShowSeatIds(),
                    request.getUserId(),
                    request.getShowId()
            );
            response.setBookingId(booking.getId());
            response.setAmount(booking.getAmount());
            response.setResponseStatus(ResponseStatus.SUCCESS);
        } catch (Exception ex){
            response.setResponseStatus(ResponseStatus.FAILURE);
        }
        return response;
    }
}
