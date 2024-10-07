package com.backendlld.bookmyshownov23morning.dtos;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class BookTicketRequestDTO {
    private List<Integer> ShowSeatIds;
    private Integer showId;
    private Integer userId;
}

// getMovies
// getShows
// getShowSeats
// bookTicket