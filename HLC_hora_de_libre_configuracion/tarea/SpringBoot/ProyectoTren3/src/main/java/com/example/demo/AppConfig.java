package com.example.demo;

import java.util.List;
import java.util.Set;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {

    @Bean
    public Crew crewMember1() {
        return new Crew("Lisa", "Driver");
    }

    @Bean
    public Crew crewMember2() {
        return new Crew("Lucas", "Assistant");
    }

    @Bean
    public Crew crewMember3() {
        return new Crew("Moe", "Waiter");
    }

    @Bean
    public Passenger passenger1() {
        return new Passenger("Pacho", 1);
    }

    @Bean
    public Passenger passenger2() {
        return new Passenger("Gilberto", 1);
    }

    @Bean
    public Passenger passenger3() {
        return new Passenger("Limón", 3);
    }

    @Bean
    public Passenger passenger4() {
        return new Passenger("P. Escobar", 4);
    }

    @Bean
    public Passenger passenger5() {
        return new Passenger("Berna", 5);
    }

    @Bean
    public Passenger passenger6() {
        return new Passenger("Javier Peña", 6);
    }

    @Bean
    public Train superTrain() {
        Train train = new Train("Talgo 747", TrainType.NUCLEAR, 100);
        train.setCrew(List.of(crewMember1(), crewMember2(), crewMember3()));
        return train;
    }

    @Bean
    public Trip trainTrip() {
        Trip trip = new Trip("East Coast Route", "Miami", "New York");
        trip.setTrain(superTrain());
        trip.setPassengers(Set.of(passenger1(), passenger2(), passenger3(), passenger4(), passenger5(), passenger6()));
        return trip;
    }
}
