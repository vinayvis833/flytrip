package com.fly_trip.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.fly_trip.entities.Passenger;

public interface PassengerRepository extends JpaRepository<Passenger, Long> {

}
