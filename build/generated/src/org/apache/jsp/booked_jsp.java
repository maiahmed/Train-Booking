package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.sql.*;

public final class booked_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("<html>\n");
      out.write("    <head>\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n");
      out.write("        <title>booked</title>\n");
      out.write("        <script>\n");
      out.write("            var xmlHTTP = xmlHTT\n");
      out.write("            function sendajx() {\n");
      out.write("                var name = document.getElementById(\"name\").value;\n");
      out.write("                var xmlhttp = new XMLHttpRequest();\n");
      out.write("                xmlhttp.open(\"GET\", \"sendingMail?name=\" + name, true);\n");
      out.write("                xmlhttp.send();\n");
      out.write("                xmlhttp.onreadystatechange = function () {\n");
      out.write("                    if (xmlhttp.readyState == 4 && xmlhttp.status == 200) {\n");
      out.write("                        document.getElementById(\"show_response\").innerHTML = xmlhttp.responseText;\n");
      out.write("                    }\n");
      out.write("                }\n");
      out.write("            }\n");
      out.write("\n");
      out.write("        </script>\n");
      out.write("        <style>\n");
      out.write("            body{\n");
      out.write("                background-image: url(\"train.jpg\");\n");
      out.write("                background-repeat: no-repeat;\n");
      out.write("                background-size: 1750px 300px;\n");
      out.write("\n");
      out.write("            }\n");
      out.write("            a{\n");
      out.write("                position: relative;\n");
      out.write("                top: 50px;\n");
      out.write("            }\n");
      out.write("            #home{\n");
      out.write("                left :1300px;\n");
      out.write("            }\n");
      out.write("            #logout{\n");
      out.write("                left :1500px;\n");
      out.write("            }\n");
      out.write("            a:link{\n");
      out.write("                color: black;\n");
      out.write("                text-decoration: none;\n");
      out.write("            }\n");
      out.write("            a:visited\n");
      out.write("            {\n");
      out.write("                color:black;\n");
      out.write("                text-decoration: underline;\n");
      out.write("            }\n");
      out.write("            a:hover\n");
      out.write("            {\n");
      out.write("                color:green;\n");
      out.write("            }\n");
      out.write("            a:active\n");
      out.write("            {\n");
      out.write("                color:green;\n");
      out.write("            }\n");
      out.write("            #booking{\n");
      out.write("                font-size: 100px;\n");
      out.write("                position: relative;\n");
      out.write("                bottom: 100px;\n");
      out.write("                left:50px;\n");
      out.write("                color:#00cc33;\n");
      out.write("            } \n");
      out.write("\n");
      out.write("\n");
      out.write("            #update{\n");
      out.write("                padding:5px 223px;\n");
      out.write("                background-color: #99ff99;\n");
      out.write("                position: relative;\n");
      out.write("                bottom: 85px;\n");
      out.write("                right: 10px;\n");
      out.write("                text-align: center;\n");
      out.write("                font-size: 22px;\n");
      out.write("                color: #00cc33;\n");
      out.write("            }\n");
      out.write("            #Bookingbutton{\n");
      out.write("                padding:5px 220px;\n");
      out.write("                background-color: #99ff99;\n");
      out.write("                position: relative;\n");
      out.write("                bottom: 85px;\n");
      out.write("                right: 20px;\n");
      out.write("                text-align: center;\n");
      out.write("                font-size: 22px;\n");
      out.write("                color: #00cc33;  \n");
      out.write("            }\n");
      out.write("            #cancel{\n");
      out.write("                padding:5px 230px;\n");
      out.write("                background-color:green;\n");
      out.write("                position: relative;\n");
      out.write("                bottom: 85px;\n");
      out.write("                right: 30px;\n");
      out.write("                text-align: center;\n");
      out.write("                font-size: 22px;\n");
      out.write("                color: #00cc33;\n");
      out.write("            }\n");
      out.write("\n");
      out.write("        </style>\n");
      out.write("\n");
      out.write("\n");
      out.write("    </head>\n");
      out.write("    <body>\n");
      out.write("        <a href=\"\" id=\"home\">Home</a> \n");
      out.write("        <a href=\"\" id=\"logout\">Logout</a> \n");
      out.write("        <p id=\"booking\">A7gazly</p>\n");
      out.write("        <input type=\"submit\" value=\"Update details\" id=\"update\"/>\n");
      out.write("        <form action=\"Booking.jsp\">\n");
      out.write("            <input type=\"submit\" value=\"Booking\" id=\"Bookingbutton\"/>\n");
      out.write("        </form>\n");
      out.write("        <form action=\"cancelling.jsp\">\n");
      out.write("            <input type=\"submit\" value=\"Cancelling\" id=\"cancel\"/>\n");
      out.write("        </form>\n");
      out.write("\n");
      out.write("        ");

            String price = request.getParameter("payment");
            String hidden = request.getParameter("hidInput");
            HttpSession _session = request.getSession(true);
            int[] trips = (int[]) _session.getAttribute("tripsIds");
            String numOfSeats = (String) _session.getAttribute("numberOfSeats");
            int seats = Integer.parseInt(numOfSeats);
            int _id = Integer.parseInt(hidden);
            int[] avSeats = (int[]) _session.getAttribute("_Available");
            int newAvailableSeats = seats + avSeats[_id];
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
                String sql = "INSERT INTO `booking` (`BUserID`,`BTripID`,`SeatNum`) VALUES ('"+ID+"',' " + trips[_id] + " ','" + seats + "' );";
                statment.executeUpdate(sql);
                connection.close();

                //////////////////////////////////////////////////////
                connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/trainbooking", "root", "20130334");
                statment = connection.createStatement();
                String sql1 = "UPDATE trip SET availableSeats='" + newAvailableSeats + "' WHERE tripID='" + trips[_id] + "';";
                statment.executeUpdate(sql1);
                connection.close();

/////////////////////////////////////////////Sending mail
            }
        
      out.write("\n");
      out.write("        <form action=\"process\" method=\"get\">\n");
      out.write("             \n");
      out.write("            <!--<input type=\"text\" name=\"name\" id=\"name\" style=\"display: none;\">-->\n");
      out.write("            Enter your mail to send a confirmation mail <input type=\"text\" name=\"name\" id=\"name\">\n");
      out.write("                    <input type=\"button\" value=\"Click Here to send a confirmation Mail.\" onclick=\"sendajx()\">\n");
      out.write("                   <div id=\"show_response\"></div>\n");
      out.write("               \n");
      out.write("        </form>\n");
      out.write("        <h1>You are successfully booked the trip </h1>\n");
      out.write("        <!--<input type=\"submit\" >-->\n");
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
