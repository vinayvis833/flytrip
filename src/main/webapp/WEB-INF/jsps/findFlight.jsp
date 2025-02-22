<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Find Flights</title>
<link href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" rel="stylesheet">

</head>
<body>
<div class="container">
	<h2 class="mt-4">Find Flights</h2>
	<form action="findFlights" method="post" class="mt-4">
		<div class="form-group">
			<label for="from">From:</label>
			<input type="text" class="form-control" id="from" name="from" placeholder="Enter departure city"/>
		</div>
		<div class="form-group">
			<label for="to">To:</label>
			<input type="text" class="form-control" id="to" name="to" placeholder="Enter destination city"/>
		</div>
		<div class="form-group">
			<label for="departureDate">Departure Date:</label>
			<input type="text" class="form-control" id="departureDate" name="departureDate" placeholder="MM-DD-YYYY"/>
		</div>
		<button type="submit" class="btn btn-primary">Search</button>
	</form>
</div>
</body>
</html>
