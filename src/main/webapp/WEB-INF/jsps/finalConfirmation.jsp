<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Ticket Detail</title>
<link href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
    <div class="container mt-5">
        <div class="row justify-content-center">
            <div class="col-md-8">
                <h2 class="text-center mb-4">Your Ticket is Confirmed</h2>
                <h4 class="text-center mb-4">Flight Details</h4>
                <table class="table table-bordered table-striped">
                    <tbody>
                        <tr>
                            <th scope="row">Passenger First Name</th>
                            <td>${firstName}</td>
                        </tr>
                        <tr>
                            <th scope="row">Passenger Middle Name</th>
                            <td>${middleName}</td>
                        </tr>
                        <tr>
                            <th scope="row">Passenger Last Name</th>
                            <td>${lastName}</td>
                        </tr>
                        <tr>
                            <th scope="row">Passenger Email</th>
                            <td>${email}</td>
                        </tr>
                        <tr>
                            <th scope="row">Passenger Phone</th>
                            <td>${phone}</td>
                        </tr>
                        <tr>
                            <th scope="row">Operating Airlines</th>
                            <td>${operatingAirlines}</td>
                        </tr>
                        <tr>
                            <th scope="row">Departure City</th>
                            <td>${departureCity}</td>
                        </tr>
                        <tr>
                            <th scope="row">Arrival City</th>
                            <td>${arrivalCity}</td>
                        </tr>
                        <tr>
                            <th scope="row">Date Of Departure</th>
                            <td>${dateOfDeparture}</td>
                        </tr>
                        <tr>
                            <th scope="row">Estimated Departure Time</th>
                            <td>${estimatedDepartureTime}</td>
                        </tr>
                    </tbody>
                </table>
            </div>
        </div>
    </div>
</body>
</html>
