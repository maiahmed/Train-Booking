<%-- 
    Document   : Booking
    Created on : Dec 23, 2016, 9:44:35 PM
    Author     : DELL
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Booking</title>
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
  <li><a class="active"  href="Booking.jsp">Booking</a></li>
  <li><a href="cancelling.jsp">Canceling</a></li>
</ul>
        <form action="AvailableTrips.jsp" method="POST">
        <table>
           <tr>  
               <td id ="pp">From</td><td> <input class="textarea id" type="text"  name="from" /> 
               </td> <td id ="pp">To </td> <td class="shift"><input class="textarea id" type="text" id="to" name="to"/>  </td>  
           </tr>

            <tr> 
                <td id ="pp">Date</td>       
                <td> <input class="textarea id" type="text" id="date" name="date"></td>  
                <td id ="pp">Time</td>         
                <td >  <input class="textarea id" type="text" id="time" name="time"/> </td>
            </tr>

            <tr> 
                <td id ="pp">Number of seats</td>  
                <td><input class="textarea id" type="text" id="numberOfSeats" name="numberOfSeats"></td> 
            <tr>
            
        </table>
       
        
        <input class="in" type="submit" value="Show Available Trips" id="ShowTrips"> 
        </form>
        
    
    </body>
</html>
