package com.backendlld.bookmyshownov23morning.controllers;

import com.backendlld.bookmyshownov23morning.dtos.BookTicketRequestDTO;
import com.backendlld.bookmyshownov23morning.dtos.BookTicketResponseDTO;
import com.backendlld.bookmyshownov23morning.dtos.ResponseStatus;
import com.backendlld.bookmyshownov23morning.models.Booking;
import com.backendlld.bookmyshownov23morning.services.BookingService;
import org.springframework.stereotype.Controller;

@Controller
public class BookingController {
    private BookingService bookingService;

    BookTicketResponseDTO bookTicket(BookTicketRequestDTO request){
        BookTicketResponseDTO response = new BookTicketResponseDTO();
        try {
            Booking booking = bookingService.bookTicket();
            response.setBookingId(booking.getId());
            response.setAmount(booking.getAmount());
            response.setResponseStatus(ResponseStatus.SUCCESS);
        } catch (Exception ex){
            response.setResponseStatus(ResponseStatus.FAILURE);
        }
        return response;
    }
}
