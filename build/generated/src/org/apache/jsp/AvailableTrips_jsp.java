package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.awt.Button;
import java.sql.*;

public final class AvailableTrips_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List<String> _jspx_dependants;

  private org.glassfish.jsp.api.ResourceInjector _jspx_resourceInjector;

  public java.util.List<String> getDependants() {
    return _jspx_dependants;
  }

  public void _jspService(HttpServletRequest request, HttpServletResponse response)
        throws java.io.IOException, ServletException {

    PageContext pageContext = null;
    HttpSession session = null;
    ServletContext application = null;
    ServletConfig config = null;
    JspWriter out = null;
    Object page = this;
    JspWriter _jspx_out = null;
    PageContext _jspx_page_context = null;

    try {
      response.setContentType("text/html;charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;
      _jspx_resourceInjector = (org.glassfish.jsp.api.ResourceInjector) application.getAttribute("com.sun.appserv.jsp.resource.injector");

      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
 Class.forName("com.mysql.jdbc.Driver"); 
      out.write(" \n");
      out.write("<!DOCTYPE html>\n");
      out.write("\n");
      out.write("<html>\n");
      out.write("    <head>\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n");
      out.write("        <title>Available Trips</title>\n");
      out.write("            <link rel=\"stylesheet\" href=\"newcss.css\" type=\"text/css\">\n");
      out.write("    <header>\n");
      out.write("       \n");
      out.write("        \n");
      out.write("           <h1>A7GAZLY</h1>\n");
      out.write("            \n");
      out.write("             <div class =\"menu\">\n");
      out.write("                 <ul class=\"list\">\n");
      out.write("                 <ol> <a herf=\"http://localhost:8080/Project/userhome.html\">Home</a></ol>\n");
      out.write("                  <ol> <a herf=\"http://localhost:8080/Project/index.html\">Logout</a></ol>\n");
      out.write("                 </ul>\n");
      out.write("                \n");
      out.write("             </div>\n");
      out.write("    </header>   \n");
      out.write(" \n");
      out.write("         <script>\n");
      out.write("          function chooseTrip()  \n");
      out.write("          {\n");
      out.write("            var _trip = document.forms[0];\n");
      out.write("            var txt = \"\";\n");
      out.write("            var i;\n");
      out.write("            var k;\n");
      out.write("             for (i = 0; i < _trip.length; i++) {\n");
      out.write("            if (_trip[i].checked) {\n");
      out.write("                k=i+1;\n");
      out.write("            document.getElementById(\"hInput\").innerHTML = \"You choosed trip number \"+k  ;\n");
      out.write("            document.getElementById(\"hidInput\").value=i;\n");
      out.write("        }\n");
      out.write("    }\n");
      out.write("    \n");
      out.write("          }\n");
      out.write("        </script>\n");
      out.write("    </head>\n");
      out.write("    \n");
      out.write("    <body>\n");
      out.write("       \n");
      out.write("<ul>\n");
      out.write("    <li><a href=\"upddate.jsp\">Update</a></li>\n");
      out.write("    <li><a class=\"active\"  href=\"Booking.jsp\">Booking</a></li>\n");
      out.write("  <li><a href=\"cancelling.jsp\">Canceling</a></li>\n");
      out.write("</ul>\n");
      out.write("\n");
      out.write("        <h3>The available trips</h3>\n");
      out.write("        \n");
      out.write("        ");

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
                
      out.write("\n");
      out.write("                <form action=\"booked.jsp\">    \n");
      out.write("                <table>\n");
      out.write("                    <tr>\n");
      out.write("                        <td id=\"pp\"> Number </td>\n");
      out.write("                        <td id=\"pp\"> Train Name</td>\n");
      out.write("                        <td id=\"pp\"> Train Type</td>\n");
      out.write("                        <td id=\"pp\">Start Station</td>    \n");
      out.write("                        <td id=\"pp\">Start Station Location</td> \n");
      out.write("                        <td id=\"pp\">End station</td> \n");
      out.write("                        <td id=\"pp\">End station location</td>\n");
      out.write("                        <td id=\"pp\">Price</td> \n");
      out.write("                        <td id=\"pp\">Available Seats</td>\n");
      out.write("                        <td id=\"pp\">Arrival Time</td> \n");
      out.write("                        <td id=\"pp\">Duration</td> \n");
      out.write("                    </tr>\n");
      out.write("                <!--</table>-->  \n");
      out.write("                ");

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

      out.write("\n");
      out.write("<!--<table>-->\n");
      out.write("    <tr>\n");
      out.write("        <td id=\"pp\">");
      out.print(n);
      out.write("</td>\n");
      out.write("        <td id=\"pp\"> ");
      out.print(trainName);
      out.write(" </td>\n");
      out.write("        <td id=\"pp\"> ");
      out.print(trainType);
      out.write(" </td>   \n");
      out.write("        <td id=\"pp\"> ");
      out.print(startStationName);
      out.write(" </td>  \n");
      out.write("        <td id=\"pp\">");
      out.print(startStationLocation);
      out.write("</td>\n");
      out.write("        <td id=\"pp\"> ");
      out.print(endStationName);
      out.write("   </td>\n");
      out.write("        <td  id=\"pp\"> ");
      out.print(endStationLocation);
      out.write("</td>\n");
      out.write("        <td id=\"pp\"> ");
      out.print( Price[id]);
      out.write("</td>\n");
      out.write("        <td id=\"pp\"> ");
      out.print( availableSeats[id]);
      out.write("</td>\n");
      out.write("        <td id=\"pp\"> ");
      out.print( arrivalTime);
      out.write(" </td>\n");
      out.write("        <td id=\"pp\"> ");
      out.print( duration);
      out.write("</td>\n");
      out.write("        <td><input class=\"in\" type=\"checkbox\" name=\"trip\"  /></td>\n");
      out.write("    </tr>\n");
      out.write("    \n");
      out.write("        \n");
      out.write("                \n");
      out.write("        <!--</form>-->\n");
      out.write("       \n");
      out.write("        ");
 } 

      out.write("\n");
      out.write("         </table>\n");
        connection.close();
                   HttpSession _session=request.getSession(true);
                   _session.setAttribute("tripsIds",tripId );
                   _session.setAttribute("numberOfSeats",numberOfSeats );
                   _session.setAttribute("_Available", availableSeats);
                   _session.setAttribute("price", Price);
        
      out.write("\n");
      out.write("        <br>\n");
      out.write("\n");
      out.write("                 <input  type=\"button\" onclick=\"chooseTrip()\" value=\"Choose\"  />\n");
      out.write("                 <p id=\"hInput\"></p>\n");
      out.write("                 <input type=\"hidden\" id=\"hidInput\" name=\"hidInput\">\n");
      out.write("                 <p>Enter the payment , be sure that it's equal to the trip price you chosen <input type=\"text\" name=\"payment\"/></p>\n");
      out.write("                 <input  class=\"in\" type=\"submit\" value=\"Confirm\">\n");
      out.write("                \n");
      out.write("        </form>\n");
      out.write("        ");
}
      out.write("\n");
      out.write("\n");
      out.write("    </body>\n");
      out.write("</html>\n");
    } catch (Throwable t) {
      if (!(t instanceof SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          out.clearBuffer();
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
