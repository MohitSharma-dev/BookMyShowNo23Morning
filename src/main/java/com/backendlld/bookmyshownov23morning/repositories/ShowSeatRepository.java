package com.backendlld.bookmyshownov23morning.repositories;

import com.backendlld.bookmyshownov23morning.models.Show;
import com.backendlld.bookmyshownov23morning.models.ShowSeat;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ShowSeatRepository extends JpaRepository<ShowSeat, Integer> {
}
