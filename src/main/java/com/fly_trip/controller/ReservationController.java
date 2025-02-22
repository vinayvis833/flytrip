package com.fly_trip.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.fly_trip.entities.Flight;
import com.fly_trip.entities.Passenger;
import com.fly_trip.entities.Reservation;
import com.fly_trip.repositories.FlightRepository;
import com.fly_trip.repositories.PassengerRepository;
import com.fly_trip.repositories.ReservationRepository;
import com.fly_trip.services.ReservationService;
import com.fly_trip.util.PDFGenerator;
import com.fly_trip.util.SendEmail;

@Controller
public class ReservationController {
	private static String folderPath ="D:\\PSA2\\psa_projects\\flight_reservation_app_2\\tickets\\";
	@Autowired
    FlightRepository flightRepo;
	
	@Autowired
	PassengerRepository passengerRepo;
	
	@Autowired
	ReservationRepository reservationRepo;
	
	@Autowired
	PDFGenerator pdfGen;
	
	@Autowired
	SendEmail sendEmail;
	
	@Autowired
	ReservationService reservationService;
	
	@RequestMapping("/showCompleteReservation")
	public String showCompleteReservation(@RequestParam("flightId") Long flightId,ModelMap modelMap) {
		Optional<Flight> findById = flightRepo.findById(flightId);
		Flight flight = findById.get();
		System.out.println(flight.getId());
		//System.out.println(flight.getOperatingAirlines());
		System.out.println(flight.getArrivalCity());
		System.out.println(flight.getDepartureCity());
		System.out.println(flight.getEstimatedDepartureTime());
		modelMap.addAttribute("flight", flight);
		flightRepo.save(flight);
		return "completeReservation";
	}
	/*
	@RequestMapping("/confirmRegistration")
	public String confirmRegistration(ReservationRequest request,ModelMap modelMap) {
		Reservation savedReservation = reservationService.bookFlight(request);
		modelMap.addAttribute("msg", "You reservationis confirmed.You Reservation id is "+savedReservation.getId());
		return "finalConfirmation";
	}
	*/
	
	@RequestMapping("/confirmReservation")
	public String confirmReservation(@RequestParam("firstName") String firstName, @RequestParam("middleName") String middleName, @RequestParam("lastName") String lastName, @RequestParam("email") String email,@RequestParam("phone") String phone, @RequestParam("flightId") Long flightId, ModelMap modelMap) {
		System.out.println(firstName);
		System.out.println(middleName);
		System.out.println(lastName);
		System.out.println(email);
		System.out.println(phone);
		System.out.println(flightId);
		Passenger passenger = new Passenger();
		passenger.setFirstName(firstName);
		passenger.setMiddleName(middleName);
		passenger.setLastName(lastName);
		passenger.setEmail(email);
		passenger.setPhone(phone);
		passengerRepo.save(passenger);
		Optional<Flight> findById = flightRepo.findById(flightId);
		Flight flight = findById.get();
		
		Reservation reservation = new Reservation();
		reservation.setCheckedIn(false);
		reservation.setNumberOfBags(0);
		reservation.setPassenger(passenger);
		reservation.setFlight(flight);
		
		reservationRepo.save(reservation);
		modelMap.addAttribute("firstName", firstName);	
		modelMap.addAttribute("middleName", middleName);	
		modelMap.addAttribute("lastName", lastName);		
		modelMap.addAttribute("email", email);	
		modelMap.addAttribute("phone", phone);	
		modelMap.addAttribute("operatingAirlines", flight.getOperatingAirlines());
		modelMap.addAttribute("departureCity", flight.getDepartureCity());
		modelMap.addAttribute("arrivalCity", flight.getArrivalCity());
		modelMap.addAttribute("dateOfDeparture", flight.getDateOfDeparture());
		modelMap.addAttribute("estimatedDepartureTime", flight.getEstimatedDepartureTime());
		
		String estimatedDepartureTime = flight.getEstimatedDepartureTime().toString();
		String dateOfDeparture = flight.getDateOfDeparture().toString();
		pdfGen.generatePDF(folderPath+"ticket"+passenger.getId()+".pdf",passenger.getFirstName(), passenger.getMiddleName(), passenger.getLastName(),passenger.getEmail(), passenger.getPhone(), flight.getOperatingAirlines(), flight.getDepartureCity(),flight.getArrivalCity(), dateOfDeparture, estimatedDepartureTime);
		sendEmail.sendTicket(passenger.getEmail(),"Ticket Details","Please download the ticket",folderPath+"ticket"+passenger.getId()+".pdf");
		
		return "finalConfirmation";
	
	}
}
