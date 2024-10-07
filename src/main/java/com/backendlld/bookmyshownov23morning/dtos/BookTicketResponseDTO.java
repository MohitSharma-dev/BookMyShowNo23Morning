package com.backendlld.bookmyshownov23morning.dtos;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class BookTicketResponseDTO {
    private int bookingId;
    private int amount;
    private ResponseStatus responseStatus;
}
