<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="ISO-8859-1">
    <title>List of Flights</title>
    <link href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
    <div class="container mt-5">
        <h2 class="mb-4">Available Flights</h2>
        <table class="table table-striped">
            <thead>
                <tr>
                    <th scope="col">Flight Number</th>
                    <th scope="col">Operating Airline</th>
                    <th scope="col">Arrival City</th>
                    <th scope="col">Departure City</th>
                    <th scope="col">Departure Date</th>
                    <th scope="col">Action</th>
                </tr>
            </thead>
            <tbody>
                <c:forEach items="${flight}" var="flight">
                    <tr>
                        <td>${flight.flightNumber}</td>
                        <td>${flight.operatingAirlines}</td>
                        <td>${flight.arrivalCity}</td>
                        <td>${flight.departureCity}</td>
                        <td>${flight.estimatedDepartureTime}</td>
                        <td><a href="showCompleteReservation?flightId=${flight.id}" class="btn btn-primary btn-sm">Select</a></td>
                    </tr>
                </c:forEach>
            </tbody>
        </table>
    </div>
</body>
</html>
