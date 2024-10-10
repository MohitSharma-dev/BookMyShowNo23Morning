package com.backendlld.bookmyshownov23morning.repositories;

import com.backendlld.bookmyshownov23morning.models.Show;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ShowRepository extends JpaRepository<Show, Integer> {
    @Override
    Optional<Show> findById(Integer integer);
}
// select * from show where id = ?
// data -> map the data to corresponding Model (Show)

// Models
// Repositories
// Spring Data JPA : Interface
// Hibernate : ORM

// BankAPI : YesBankAPI