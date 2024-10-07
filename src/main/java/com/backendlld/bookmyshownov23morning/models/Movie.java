package com.backendlld.bookmyshownov23morning.models;

import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@Entity
public class Movie extends BaseModel{
    private String title;
    @ElementCollection // This will create a separate table
    private List<String> actors;
    private int releaseYear;
    @Enumerated(EnumType.STRING)
    @ElementCollection
    private List<Language> languages;
    @ElementCollection
    private List<String> genres;
    private int duration;
    @Enumerated(EnumType.STRING)
    @ElementCollection
    private List<Feature> features;
}

// Movie has multiple languages

// KHNH Hindi
// KHNH English
