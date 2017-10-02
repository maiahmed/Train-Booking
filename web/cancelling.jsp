<%-- 
    Document   : cancelling
    Created on : Dec 24, 2016, 12:08:17 AM
    Author     : DELL
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    <link rel="stylesheet" href="newcss.css" type="text/css">
    <header>
       
        
           <h1>A7GAZLY</h1>
            
             <div class ="menu">
                 <ul class="list">
                 <ol> <a herf="http://localhost:8080/Project/userhome.html">Home</a></ol>
                  <ol> <a herf="http://localhost:8080/Project/index.html">Logout</a></ol>
                 </ul>
                
             </div>
    </header>   
 
       
    </head>
    
    <body>
       
<ul>
    <li><a href="upddate.jsp">Update</a></li>
    <li><a   href="Booking.jsp">Booking</a></li>
    <li><a class="active" href="cancelling.jsp">Canceling</a></li>
</ul>
        <form action="showBookingTrips.jsp">
            <input class="in" type="submit" value="Show Booking Trips" id="BookingTrips">
        </form>
    </body>
</html>
