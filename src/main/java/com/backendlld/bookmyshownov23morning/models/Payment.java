package com.backendlld.bookmyshownov23morning.models;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@Entity
public class Payment extends BaseModel{
    private int amount;
    private Date date;
    private String refNumber;
    @Enumerated(EnumType.ORDINAL)
    private PaymentMode mode;
    @Enumerated(EnumType.ORDINAL)
    private PaymentStatus status;
    @Enumerated(EnumType.ORDINAL)
    private PaymentGateway paymentGateway;
}

// Booking 1 : M Payment
