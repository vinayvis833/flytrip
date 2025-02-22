package com.fly_trip.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fly_trip.dto.ReservationUpdateRequest;
import com.fly_trip.entities.Reservation;
import com.fly_trip.repositories.ReservationRepository;

@RestController
public class ReservationRestController {
	
	@Autowired
	ReservationRepository reservationRepo;
	
	private Optional<Reservation> findById;
	
	@RequestMapping("/reservation/{id}")
	public Reservation findReservation(@PathVariable("id") Long id) {
		findById = reservationRepo.findById(id);
		Reservation reservation = findById.get();
		return reservation;
	}
	
	@RequestMapping("/reservation")
	public void updateReservation(@RequestBody ReservationUpdateRequest request) {
		long id = request.getId();
		Optional<Reservation> findById = reservationRepo.findById(id);
		Reservation reservation = findById.get();
		reservation.setNumberOfBags(request.getNumberOfBags());
		reservation.setCheckedIn(true);
		reservationRepo.save(reservation);
	}
	
	
}
