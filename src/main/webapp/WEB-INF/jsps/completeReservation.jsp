<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Show Complete Reservation</title>
<link href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css" rel="stylesheet">
<style>
	
	.centered {
		text-align: center;
	}
</style>
</head>
<body>
	<div class="container mt-5">
		<div class="row justify-content-center">
			<div class="col-md-8">
				<h2 class="mb-4 text-center">Flight Details</h2>
				<p><strong>Operating Airlines:</strong> ${flight.operatingAirlines}</p>
				<p><strong>Departure City:</strong> ${flight.departureCity}</p>
				<p><strong>Arrival City:</strong> ${flight.arrivalCity}</p>
				<p><strong>Estimated Date & Time:</strong> ${flight.estimatedDepartureTime}</p>

				<form action="confirmReservation" method="post">
					<h2 class="mt-5 mb-4 text-center">Enter Passenger Details</h2>
					<div class="form-group">
						<label for="firstName">First Name</label>
						<input type="text" class="form-control custom-width mx-auto" id="firstName" name="firstName" required>
					</div>
					<div class="form-group">
						<label for="middleName">Middle Name</label>
						<input type="text" class="form-control custom-width mx-auto" id="middleName" name="middleName">
					</div>
					<div class="form-group">
						<label for="lastName">Last Name</label>
						<input type="text" class="form-control custom-width mx-auto" id="lastName" name="lastName" required>
					</div>
					<div class="form-group">
						<label for="email">Email Id</label>
						<input type="email" class="form-control custom-width mx-auto" id="email" name="email" required>
					</div>
					<div class="form-group">
						<label for="phone">Mobile Number</label>
						<input type="tel" class="form-control custom-width mx-auto" id="phone" name="phone" required>
					</div>
					<input type="hidden" name="flightId" value="${flight.id}">

					<h2 class="mt-5 mb-4 text-center">Enter Payment Details</h2>
					<div class="form-group">
						<label for="name">Name</label>
						<input type="text" class="form-control custom-width mx-auto" id="name" name="name" required>
					</div>
					<div class="form-group">
						<label for="cardNumber">Card Number</label>
						<input type="text" class="form-control custom-width mx-auto" id="cardNumber" name="cardNumber" required>
					</div>
					<div class="form-group">
						<label for="cvvCode">CVV Code</label>
						<input type="text" class="form-control custom-width mx-auto" id="cvvCode" name="cvvCode" required>
					</div>
					<div class="form-group">
						<label for="expiryDate">Expiry Date</label>
						<input type="text" class="form-control custom-width mx-auto" id="expiryDate" name="expiryDate" required>
					</div>
					<div class="form-group">
						<label for="amount">Amount</label>
						<input type="text" class="form-control custom-width mx-auto" id="amount" name="amount" required>
					</div>
					<button type="submit" class="btn btn-primary d-block mx-auto">Save</button>
				</form>
			</div>
		</div>
	</div>
	</body>
</html>
