package com.example.favoritemoviesapp;

import java.time.LocalDate;

public class Film {
    private String name;
    private String details;
    private LocalDate date;

    public Film(String name, String details, LocalDate date) {
        this.name = name;
        this.details = details;
        this.date = date;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDetails() {
        return details;
    }

    public void setDetails(String details) {
        this.details = details;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return "Film{" +
                "name='" + name + '\'' +
                ", details='" + details + '\'' +
                ", date=" + date +
                '}';
    }
}
