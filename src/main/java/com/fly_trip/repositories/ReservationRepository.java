package com.fly_trip.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.fly_trip.entities.Reservation;

public interface ReservationRepository extends JpaRepository<Reservation, Long> {

}
