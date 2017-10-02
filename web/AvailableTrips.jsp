<%-- 
    Document   : AvailableTrips
    Created on : Dec 25, 2016, 12:37:13 PM
    Author     : DELL
--%>

<%@page import="java.awt.Button"%>
<%@page import="java.sql.*" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<% Class.forName("com.mysql.jdbc.Driver"); %> 
<!DOCTYPE html>

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Available Trips</title>
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
 
         <script>
          function chooseTrip()  
          {
            var _trip = document.forms[0];
            var txt = "";
            var i;
            var k;
             for (i = 0; i < _trip.length; i++) {
            if (_trip[i].checked) {
                k=i+1;
            document.getElementById("hInput").innerHTML = "You choosed trip number "+k  ;
            document.getElementById("hidInput").value=i;
        }
    }
    
          }
        </script>
    </head>
    
    <body>
       
<ul>
    <li><a href="upddate.jsp">Update</a></li>
    <li><a class="active"  href="Booking.jsp">Booking</a></li>
  <li><a href="cancelling.jsp">Canceling</a></li>
</ul>

        <h3>The available trips</h3>
        
        <%
            String from = request.getParameter("from");
            String to = request.getParameter("to");
            String date = request.getParameter("date");
            String time = request.getParameter("time");
            String numberOfSeats = request.getParameter("numberOfSeats");
            if (from.equals("") || to.equals("") || date.equals("") || time.equals("") || numberOfSeats.equals("")) {
//              out.print("You have to fill all Data");
                RequestDispatcher rd = request.getRequestDispatcher("Booking.jsp");
                rd.forward(request, response);
            } else {
                int numOfSeats = Integer.parseInt(numberOfSeats),id=-1;
                int []Price = new int[1000];
                int []availableSeats= new int [1000];
                String arrivalTime, duration;
                int trainId, startStationId, endStationId, trainStatusId;
                int [] tripId= new int[1000];
                String trainName, trainType, startStationName, startStationLocation, endStationName, endStationLocation;
                Connection connection;
                Statement statment;

                connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/trainbooking", "root", "20130334");
                statment = connection.createStatement();
                String sql = "SELECT * FROM trip INNER JOIN station ON trip.startStationID=station.StationID or trip.endStationID=station.StationID INNER JOIN train ON trip.TrainID=train.TrainID where `DepatureLocation`='" + from + "' and `ArrivalLocation`='" + to + "' and `DepatureTime`='" + time + "' and TripDate='" + date + "'and availableSeats >= '"+numOfSeats+"' " ;
//                      +"SELECT * FROM trip where `DepatureLocation`='"+from+"' and `ArrivalLocation`='"+to+"' and `DepatureTime`='"+time+"' and TripDate='"+date+"' ";
                ResultSet trips = statment.executeQuery(sql);
                %>
                <form action="booked.jsp">    
                <table>
                    <tr>
                        <td id="pp"> Number </td>
                        <td id="pp"> Train Name</td>
                        <td id="pp"> Train Type</td>
                        <td id="pp">Start Station</td>    
                        <td id="pp">Start Station Location</td> 
                        <td id="pp">End station</td> 
                        <td id="pp">End station location</td>
                        <td id="pp">Price</td> 
                        <td id="pp">Available Seats</td>
                        <td id="pp">Arrival Time</td> 
                        <td id="pp">Duration</td> 
                    </tr>
                <!--</table>-->  
                <%
//                    Button []button = new Button[100];
                    while (trips.next()) {
                    
//              trainId=trips.getInt("TrainID");
                    
                    arrivalTime = trips.getString("ArrivalTime");
                    startStationName = trips.getString("StationName");
                    startStationLocation = trips.getString("Location");
                    duration = trips.getString("Duration");
                    trainName = trips.getString("TrainName");
                    trainType = trips.getString("TrainType");
                    trips.next();
                    endStationName = trips.getString("StationName");
                    endStationLocation = trips.getString("Location");
                    id=id+1;
                   tripId[id]=trips.getInt("TripID");
                   availableSeats[id] = trips.getInt("availableSeats");
                    Price[id] = trips.getInt("Price");
                    int n=id+1 ;
//                    
                    
//            
%>
<!--<table>-->
    <tr>
        <td id="pp"><%=n%></td>
        <td id="pp"> <%=trainName%> </td>
        <td id="pp"> <%=trainType%> </td>   
        <td id="pp"> <%=startStationName%> </td>  
        <td id="pp"><%=startStationLocation%></td>
        <td id="pp"> <%=endStationName%>   </td>
        <td  id="pp"> <%=endStationLocation%></td>
        <td id="pp"> <%= Price[id]%></td>
        <td id="pp"> <%= availableSeats[id]%></td>
        <td id="pp"> <%= arrivalTime%> </td>
        <td id="pp"> <%= duration%></td>
        <td><input class="in" type="checkbox" name="trip"  /></td>
    </tr>
    
        
                
        <!--</form>-->
       
        <% } 
%>
         </table>
<%        connection.close();
                   HttpSession _session=request.getSession(true);
                   _session.setAttribute("tripsIds",tripId );
                   _session.setAttribute("numberOfSeats",numberOfSeats );
                   _session.setAttribute("_Available", availableSeats);
                   _session.setAttribute("price", Price);
        %>
        <br>

                 <input  type="button" onclick="chooseTrip()" value="Choose"  />
                 <p id="hInput"></p>
                 <input type="hidden" id="hidInput" name="hidInput">
                 <p>Enter the payment , be sure that it's equal to the trip price you chosen <input type="text" name="payment"/></p>
                 <input  class="in" type="submit" value="Confirm">
                
        </form>
        <%}%>

    </body>
</html>
