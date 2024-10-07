package com.backendlld.bookmyshownov23morning.models;

import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@Entity
public class User extends BaseModel {
    private String name;
    private String email;
    @OneToMany
    private List<Booking> bookings;
}

// User 1 : M Booking

// int 12.32 : 1232

// user booking
// OneToMany : they create a new table
// Explore how to avoid this