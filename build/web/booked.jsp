<%-- 
    Document   : booked
    Created on : Dec 26, 2016, 11:22:27 AM
    Author     : DELL
--%>


<%@page import="java.sql.*" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<% Class.forName("com.mysql.jdbc.Driver"); %> 
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>booked</title>
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

        <%
            String price = request.getParameter("payment");
            String hidden = request.getParameter("hidInput");
            HttpSession _session = request.getSession(true);
            int[] trips = (int[]) _session.getAttribute("tripsIds");
            String numOfSeats = (String) _session.getAttribute("numberOfSeats");
            int seats = Integer.parseInt(numOfSeats);
            int _id = Integer.parseInt(hidden);
            int[] avSeats = (int[]) _session.getAttribute("_Available");
            int newAvailableSeats =   avSeats[_id] - seats;
            int[] Price = (int[]) _session.getAttribute("price");
            int enteredPrice = Integer.parseInt(price);

            if (enteredPrice < Price[_id]) {
                RequestDispatcher rd = request.getRequestDispatcher("message.jsp");
                rd.forward(request, response);
            } else {
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
                ///////////**************************getting the user ID
                String sql = "INSERT INTO `booking` (`BUserID`,`BTripID`,`SeatNum`) VALUES ('"+ ID +"',' " + trips[_id] + " ','" + seats + "' );";
                statment.executeUpdate(sql);
                connection.close();

                //////////////////////////////////////////////////////
                connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/trainbooking", "root", "20130334");
                statment = connection.createStatement();
                String sql1 = "UPDATE trip SET availableSeats='" + newAvailableSeats + "' WHERE tripID='" + trips[_id] + "';";
                statment.executeUpdate(sql1);
                connection.close();

/////////////////////////////////////////////Sending mail
%>
 <form action="process" method="get">
             
            <!--<input type="text" name="name" id="name" style="display: none;">-->
            <h3> Enter your mail to send a confirmation mail </h3>
            <input type="text" name="name" id="name">
                    <input type="button" value="Click Here to send a confirmation Mail." onclick="sendajx()"><br/>
                    <p> <div id="show_response"></div> </p>
               
        </form>
<%
            }
        %>
       <br/><br/>
        <h1>You are successfully booked the trip </h1>
        <!--<input type="submit" >-->
    </body>
</html>
