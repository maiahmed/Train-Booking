<%-- 
    Document   : ConfirmDeleteBooking
    Created on : Dec 26, 2016, 4:01:01 PM
    Author     : DELL
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.sql.*" %>
<% Class.forName("com.mysql.jdbc.Driver"); %> 
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>confirm cancellation</title>
 <script>
            var xmlHTTP = xmlHTT
            function sendajx() {
                var name = document.getElementById("name").value;
                var xmlhttp = new XMLHttpRequest();
                xmlhttp.open("GET", "sendingMail?name=" + name, true);
                xmlhttp.send();
                xmlhttp.onreadystatechange = function () {
                    if (xmlhttp.readyState == 4 && xmlhttp.status == 200) {
                        document.getElementById("show_response").innerHTML = xmlhttp.responseText;
                    }
                }
            }

        </script>
    </head>
    <body>
        <%
            String hidden = request.getParameter("hidInput");
            HttpSession _session = request.getSession(true);
            int[] trips = (int[]) _session.getAttribute("DtripsIDs");
            int _id = Integer.parseInt(hidden);
            int[] availableSeats = (int[]) _session.getAttribute("AvailableSeats");
            int[] bookedSeats = (int[]) _session.getAttribute("BookedSeats");
            int newAvailableSeats = availableSeats[_id] + bookedSeats[_id];

            String cookieID = "userID";
            Cookie cookies[] = request.getCookies();
            Cookie myCookie = null;
            String id = "";
            int ID = 0;
            if (cookies != null) {
                for (int i = 0; i < cookies.length; i++) {
                    if (cookies[i].getName().equals(cookieID)) {
                        id = cookies[i].getValue();

                        break;
                    }
                }
            }
            ID = Integer.parseInt(id);

            Connection connection;
            Statement statment;

            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/trainbooking", "root", "20130334");
            statment = connection.createStatement();
            String sql = "UPDATE trip SET availableSeats='" + newAvailableSeats + "' WHERE tripID='" + trips[_id] + "';";
            statment.executeUpdate(sql);
            connection.close();

            ///********************delete after lanuch
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/trainbooking", "root", "20130334");
            statment = connection.createStatement();
            ///////////////***********getuser from cookie
            String sql1 = "DELETE FROM booking WHERE BUserID='"+ID+"' and BTripID='" + trips[_id] + "';";
            statment.executeUpdate(sql1);
            connection.close();
            

        %>
        <form action="process" method="get">
             
            <!--<input type="text" name="name" id="name" style="display: none;">-->
            <h3> Enter your mail to send a confirmation mail </h3>
            <input type="text" name="name" id="name">
                    <input type="button" value="Click Here to send a confirmation Mail." onclick="sendajx()"><br/>
                    <div id="show_response"></div>
               
        </form>
        <h1>You are successfully canceled the booking</h1>
    </body>
</html>
