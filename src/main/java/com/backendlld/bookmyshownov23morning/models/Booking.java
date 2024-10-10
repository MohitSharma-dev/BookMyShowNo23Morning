package com.backendlld.bookmyshownov23morning.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;
import java.util.List;

@Getter
@Setter
@Entity
public class Booking extends BaseModel{
    @ManyToOne
    private User bookedBy;
    private Date date;
    private int amount;
    @ManyToMany
    private List<ShowSeat> showSeats;
    @OneToMany
    @JoinColumn(name = "booking_id")
    private List<Payment> payments;
    @Enumerated(value = EnumType.STRING)
    private BookingStatus status;
}
// booking M : 1 User
// Booking M : M ShowSeat