package com.fly_trip.services;

import com.fly_trip.dto.ReservationRequest;
import com.fly_trip.entities.Reservation;

public interface ReservationService {
	Reservation bookFlight(ReservationRequest request);
}
