package com.backendlld.bookmyshownov23morning.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@Entity
public class Screen extends BaseModel {
    private String screenName;
    @ManyToOne
    private Theatre theatre;
    @Enumerated(EnumType.ORDINAL)
    @ElementCollection
    private List<Feature> features;
    @OneToMany
    private List<Seat> seats;
}
