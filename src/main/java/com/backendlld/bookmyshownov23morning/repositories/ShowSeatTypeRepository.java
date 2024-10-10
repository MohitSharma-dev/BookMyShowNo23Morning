package com.backendlld.bookmyshownov23morning.repositories;

import com.backendlld.bookmyshownov23morning.models.Show;
import com.backendlld.bookmyshownov23morning.models.ShowSeat;
import com.backendlld.bookmyshownov23morning.models.ShowSeatType;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ShowSeatTypeRepository extends JpaRepository<ShowSeatType, Integer> {
    List<ShowSeatType> findAllByShow(Show show);
}

// select * from showSeatType where show_id = ? ;

