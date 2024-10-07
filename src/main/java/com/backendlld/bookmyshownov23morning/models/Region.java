package com.backendlld.bookmyshownov23morning.models;

import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@Entity
public class Region extends BaseModel{
    private String regionName;
//    private List<Theatre> theatres;
}
