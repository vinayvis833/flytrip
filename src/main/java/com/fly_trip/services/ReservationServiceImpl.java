package com.fly_trip.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fly_trip.dto.ReservationRequest;
import com.fly_trip.entities.Flight;
import com.fly_trip.entities.Passenger;
import com.fly_trip.entities.Reservation;
import com.fly_trip.repositories.FlightRepository;
import com.fly_trip.repositories.PassengerRepository;
import com.fly_trip.repositories.ReservationRepository;

@Service
public class ReservationServiceImpl implements ReservationService {

	@Autowired
	FlightRepository flightRepo;
	
	@Autowired
	PassengerRepository PassengerRepo;
	
	@Autowired
	ReservationRepository reservationRepo;

	@Override
	public Reservation bookFlight(ReservationRequest request) {
		long flightId = request.getFlightId();
		Optional<Flight> findById = flightRepo.findById(flightId);
		Flight flight = findById.get();
		
		
		Passenger p = new Passenger();
		p.setFirstName(request.getFirstName());
		p.setLastName(request.getLastName());
		p.setEmail(request.getEmail());
		p.setPhone(request.getPhone());
		Passenger savedPassenger = PassengerRepo.save(p);
		
		Reservation r = new Reservation();
		r.setFlight(flight);
		r.setPassenger(savedPassenger);
		r.setCheckedIn(false);
		Reservation savedReservation = reservationRepo.save(r);
		
		return savedReservation ;
	}

}
