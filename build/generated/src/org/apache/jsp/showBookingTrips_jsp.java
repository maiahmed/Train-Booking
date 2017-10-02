package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.sql.*;

public final class showBookingTrips_jsp extends org.apache.jasper.runtime.HttpJspBase
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
 Class.forName("com.mysql.jdbc.Driver"); 
      out.write(" \n");
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("    <head>\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n");
      out.write("        <title>Booked trips</title>\n");
      out.write("        <style>\n");
      out.write("            table{\n");
      out.write("                border :3px;\n");
      out.write("                width: 100%;\n");
      out.write("            }\n");
      out.write("\n");
      out.write("           .bStyle\n");
      out.write("            {\n");
      out.write("                background-color: #99ff99;\n");
      out.write("                padding: 1px 10px;\n");
      out.write("                border-radius:12px;\n");
      out.write("                text-align: center;\n");
      out.write("/*                position:relative;\n");
      out.write("                left:500px;\n");
      out.write("                top:50px;*/\n");
      out.write("                color: #00cc33;\n");
      out.write("                /*size: 100px 500px;*/\n");
      out.write("                font-size: 30px;  \n");
      out.write("            } \n");
      out.write("        </style>\n");
      out.write("        \n");
      out.write("        <script>\n");
      out.write("          function chooseTrip()  \n");
      out.write("          {\n");
      out.write("            var _trip = document.forms[0];\n");
      out.write("            var txt = \"\";\n");
      out.write("            var i;\n");
      out.write("             for (i = 0; i < _trip.length; i++) {\n");
      out.write("            if (_trip[i].checked) {\n");
      out.write("            document.getElementById(\"hInput\").innerHTML = \"You choosed \"+i  ;\n");
      out.write("            document.getElementById(\"hidInput\").value=i;\n");
      out.write("        }\n");
      out.write("    }\n");
      out.write("    \n");
      out.write("          }\n");
      out.write("        </script>\n");
      out.write("        \n");
      out.write("    </head>\n");
      out.write("    <body>\n");
      out.write("        ");

           /////calculate the user ID ***************************
           int Price;
                String arrivalTime, duration,depatureTime,source,destination;
                int[] tripsIds= new int[1000];
                int [] availableSeats = new int [1000];
                int []bookedSeatsNum = new int [1000];
                int i=-1;
            
                
           Connection connection;
                Statement statment;

                connection = DriverManager.getConnection("jdbc:mysql://localhost/trainbooking", "root", "root");
                statment = connection.createStatement();
                String sql = "SELECT * FROM booking INNER JOIN trip ON booking.BTripID=trip.TripID where booking.BUserID=1";
                ResultSet trips = statment.executeQuery(sql);
                
      out.write("\n");
      out.write("                \n");
      out.write("                <form action=\"ConfirmDeleteBooking.jsp\">\n");
      out.write("                <table>\n");
      out.write("                    <tr>\n");
      out.write("                        <td>Departure Location</td>\n");
      out.write("                        <td>Arrival Location</td>\n");
      out.write("                        <td>Price</td>    \n");
      out.write("                        <td>Departure Time</td> \n");
      out.write("                        <td>Arrival Time</td> \n");
      out.write("                        <td>Duration</td>\n");
      out.write("         \n");
      out.write("                    </tr>\n");
      out.write("                \n");
      out.write("                ");

                    while(trips.next())
                {
                   Price = trips.getInt("Price");
                    arrivalTime = trips.getString("ArrivalTime");
                    depatureTime=trips.getString("DepatureTime");
                    duration = trips.getString("Duration");
                    source=trips.getString("DepatureLocation");
                    destination=trips.getString("ArrivalLocation");
                    i++;
                    tripsIds[i]=trips.getInt("TripID");
                    availableSeats[i]=trips.getInt("availableSeats");
                    bookedSeatsNum[i]=trips.getInt("SeatNum");
                    
                    
      out.write("\n");
      out.write("            \n");
      out.write("    <tr>\n");
      out.write("        <td> ");
      out.print( source);
      out.write(" </td>\n");
      out.write("        <td> ");
      out.print( destination);
      out.write(" </td>   \n");
      out.write("        <td> ");
      out.print(Price);
      out.write(" </td>  \n");
      out.write("        <td>");
      out.print(depatureTime);
      out.write("</td>\n");
      out.write("        <td> ");
      out.print(arrivalTime);
      out.write("   </td>\n");
      out.write("        <td> ");
      out.print(duration);
      out.write("</td>\n");
      out.write("        <td><input type=\"checkbox\" name=\"trip\"  /></td>\n");
      out.write("        \n");
      out.write("    </tr>\n");
      out.write("                    \n");
      out.write("                ");
}
        
      out.write(" \n");
      out.write("                </table>\n");
      out.write("                ");

                 connection.close();   
                 HttpSession _session = request.getSession(true);
                 _session.setAttribute("DtripsIDs",tripsIds );
                 _session.setAttribute("AvailableSeats", availableSeats);
                 _session.setAttribute("BookedSeats", bookedSeatsNum);
                
      out.write("\n");
      out.write("                \n");
      out.write("                 <input class=\"bStyle\" type=\"button\" onclick=\"chooseTrip()\" value=\"Choose\"  />\n");
      out.write("                 <p id=\"hInput\"></p>\n");
      out.write("                 <input type=\"hidden\" id=\"hidInput\" name=\"hidInput\">\n");
      out.write("                 <input  class=\"bStyle\" type=\"submit\" value=\"Confirm\">\n");
      out.write("                </form>\n");
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
