package com.backendlld.bookmyshownov23morning.models;

import jakarta.persistence.Entity;
import jakarta.persistence.EntityResult;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@Entity
public class Theatre extends BaseModel{
    private String theatreName;
    private String theatreAddress;
    @ManyToOne
    private Region region;
//    private List<Screen> screens;
}
