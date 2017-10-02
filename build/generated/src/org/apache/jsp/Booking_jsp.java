package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class Booking_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("    <head>\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n");
      out.write("        <title>Booking</title>\n");
      out.write("           <link rel=\"stylesheet\" href=\"newcss.css\" type=\"text/css\">\n");
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
      out.write("       \n");
      out.write("    </head>\n");
      out.write("    \n");
      out.write("    <body>\n");
      out.write("       \n");
      out.write("<ul>\n");
      out.write("    <li><a href=\"upddate.jsp\">Update</a></li>\n");
      out.write("  <li><a class=\"active\"  href=\"Booking.jsp\">Booking</a></li>\n");
      out.write("  <li><a href=\"cancelling.jsp\">Canceling</a></li>\n");
      out.write("</ul>\n");
      out.write("        <form action=\"AvailableTrips.jsp\" method=\"POST\">\n");
      out.write("        <table>\n");
      out.write("           <tr>  \n");
      out.write("               <td id =\"pp\">From</td><td> <input class=\"textarea id\" type=\"text\"  name=\"from\" /> \n");
      out.write("               </td> <td id =\"pp\">To </td> <td class=\"shift\"><input class=\"textarea id\" type=\"text\" id=\"to\" name=\"to\"/>  </td>  \n");
      out.write("           </tr>\n");
      out.write("\n");
      out.write("            <tr> \n");
      out.write("                <td id =\"pp\">Date</td>       \n");
      out.write("                <td> <input class=\"textarea id\" type=\"text\" id=\"date\" name=\"date\"></td>  \n");
      out.write("                <td id =\"pp\">Time</td>         \n");
      out.write("                <td >  <input class=\"textarea id\" type=\"text\" id=\"time\" name=\"time\"/> </td>\n");
      out.write("            </tr>\n");
      out.write("\n");
      out.write("            <tr> \n");
      out.write("                <td id =\"pp\">Number of seats</td>  \n");
      out.write("                <td><input class=\"textarea id\" type=\"text\" id=\"numberOfSeats\" name=\"numberOfSeats\"></td> \n");
      out.write("            <tr>\n");
      out.write("            \n");
      out.write("        </table>\n");
      out.write("       \n");
      out.write("        \n");
      out.write("        <input class=\"in\" type=\"submit\" value=\"Show Available Trips\" id=\"ShowTrips\"> \n");
      out.write("        </form>\n");
      out.write("        \n");
      out.write("    \n");
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
