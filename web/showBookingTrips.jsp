<%-- 
    Document   : showBookingTrips
    Created on : Dec 26, 2016, 3:21:25 PM
    Author     : DELL
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.sql.*" %>
<% Class.forName("com.mysql.jdbc.Driver"); %> 
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Booked trips</title>
        <style>
            table{
                border :3px;
                width: 100%;
            }

            .bStyle
            {
                background-color: #99ff99;
                padding: 1px 10px;
                border-radius:12px;
                text-align: center;
                /*                position:relative;
                                left:500px;
                                top:50px;*/
                color: #00cc33;
                /*size: 100px 500px;*/
                font-size: 30px;  
            } 
        </style>

        <script>
            function chooseTrip()
            {
                var _trip = document.forms[0];
                var txt = "";
                var i;
                for (i = 0; i < _trip.length; i++) {
                    if (_trip[i].checked) {
                        document.getElementById("hInput").innerHTML = "You choosed " + i;
                        document.getElementById("hidInput").value = i;
                    }
                }

            }
        </script>

    </head>
    <body>
        <%
            /////calculate the user ID ***************************
            int Price;
            String arrivalTime, duration, depatureTime, source, destination;
            int[] tripsIds = new int[1000];
            int[] availableSeats = new int[1000];
            int[] bookedSeatsNum = new int[1000];
            int i = -1;

            String cookieID = "userID";
            Cookie cookies[] = request.getCookies();
            Cookie myCookie = null;
            String id = "";
            int ID = 0;
            if (cookies != null) {
                for (int j = 0; j < cookies.length; j++) {
                    if (cookies[j].getName().equals(cookieID)) {
                        id = cookies[j].getValue();

                        break;
                    }
                }
            }
            ID = Integer.parseInt(id);

            Connection connection;
            Statement statment;

            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/trainbooking", "root", "20130334");
            statment = connection.createStatement();
            String sql = "SELECT * FROM booking INNER JOIN trip ON booking.BTripID=trip.TripID where booking.BUserID='"+ ID +"'";
           System.out.println("-------------------------QQQQ: "+sql);
            ResultSet trips = statment.executeQuery(sql);
        %>

        <form action="ConfirmDeleteBooking.jsp">
            <table>
                <tr>
                    <td>Departure Location</td>
                    <td>Arrival Location</td>
                    <td>Price</td>    
                    <td>Departure Time</td> 
                    <td>Arrival Time</td> 
                    <td>Duration</td>

                </tr>

                <%
                    while (trips.next()) {
                        Price = trips.getInt("Price");
                        arrivalTime = trips.getString("ArrivalTime");
                        depatureTime = trips.getString("DepatureTime");
                        duration = trips.getString("Duration");
                        source = trips.getString("DepatureLocation");
                        destination = trips.getString("ArrivalLocation");
                        i++;
                        tripsIds[i] = trips.getInt("TripID");
                        availableSeats[i] = trips.getInt("availableSeats");
                        bookedSeatsNum[i] = trips.getInt("SeatNum");

                %>

                <tr>
                    <td> <%= source%> </td>
                    <td> <%= destination%> </td>   
                    <td> <%=Price%> </td>  
                    <td><%=depatureTime%></td>
                    <td> <%=arrivalTime%>   </td>
                    <td> <%=duration%></td>
                    <td><input type="checkbox" name="trip"  /></td>

                </tr>

                <%}
                %> 
            </table>
            <%
                connection.close();
                HttpSession _session = request.getSession(true);
                _session.setAttribute("DtripsIDs", tripsIds);
                _session.setAttribute("AvailableSeats", availableSeats);
                _session.setAttribute("BookedSeats", bookedSeatsNum);
            %>

            <input class="bStyle" type="button" onclick="chooseTrip()" value="Choose"  />
            <p id="hInput"></p>
            <input type="hidden" id="hidInput" name="hidInput">
            <input  class="bStyle" type="submit" value="Confirm">
        </form>
    </body>
</html>
