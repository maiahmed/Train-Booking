/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import static com.sun.xml.bind.util.CalendarConv.formatter;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Time;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.*;

/**
 *
 * @author DELL
 */
@WebServlet(urlPatterns = {"/ToBook"})
public class ToBook extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, ParseException, ClassNotFoundException, SQLException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            
            String from=request.getParameter("from");
            String to = request.getParameter("to");
            String date = request.getParameter("date");
            String time = request.getParameter("time");
          String numberOfSeats = request.getParameter("numberOfSeats");
          if(from.equals("") || to.equals("") || date.equals("") || time.equals("") || numberOfSeats.equals(""))
          {  
//              out.print("You have to fill all Data");
              RequestDispatcher rd = request.getRequestDispatcher("Booking.jsp");
              rd.forward(request, response);
          }
          else{

              int numOfSeats=Integer.parseInt(numberOfSeats);
              int Price,availableSeats,totalSeats;
              int trainId,startStationId,endStationId,trainStatusId;
              String trainName,trainType,startStationName,startStationLocation,endStationName,endStationLocation;
              Connection connection;
              Statement statment;
              
              Class.forName("com.mysql.jdbc.Driver");
              connection=DriverManager.getConnection("jdbc:mysql://localhost:3306/trainbooking", "root", "20130334");
              statment=connection.createStatement();
              String sql="SELECT * FROM trip where `DepatureLocation`='"+from+"' and `ArrivalLocation`='"+to+"' and `DepatureTime`='"+time+"' and TripDate='"+date+"' ";
              ResultSet trips=statment.executeQuery(sql);
              while(trips.next())
              {
                  Price=trips.getInt("Price");
                  trainId=trips.getInt("TrainID");
                  String sql0="SELECT * FROM train where `TrainID`='"+trainId+"";
                  ResultSet trians=statment.executeQuery(sql0);
                 while(trians.next())
                 {
                     startStationId=trians.getInt("startStationID");
                     endStationId=trians.getInt("endStationID");
                     trainStatusId=trians.getInt("TstatusID");
                     trainName=trians.getString("trainName");
                     trainType=trians.getString("trainType");
                     
                     String sql1= "SELECT * FROM station where `StationID`='"+startStationId+" ";
                     ResultSet startStation=statment.executeQuery(sql1);
                     startStation.first();
                     startStationName=startStation.getString("StationName");
                     startStationLocation=startStation.getString("Location");
            
                     String sql2= "SELECT * FROM station where `StationID`='"+endStationId+" ";
                     ResultSet endStation=statment.executeQuery(sql2);
                     endStation.first();
                     endStationName=endStation.getString("StationName");
                     endStationLocation=endStation.getString("Location");
                     
                     String sql3= "SELECT * FROM trainstatus where `TrainStatusID`='"+trainStatusId+" ";
                     ResultSet trainStatus=statment.executeQuery(sql3);
                     while(trainStatus.next()){
                     availableSeats=trainStatus.getInt("AvailableSeats");
                     totalSeats=trainStatus.getInt("TotalSeats");
                     out.println("Train Name"+trainName+ "   Train Type"+trainType+"   Start Station"+startStationName+"   Start Station Location"+startStationLocation
                     +"   End station"+endStationName+"   End station location"+endStationLocation+"   Available seats"
                     +availableSeats+"   Total seats"+totalSeats+"   price"+Price);
                     }
                     
                 }
                  
              }
              
//              DateFormat format =new SimpleDateFormat("d MMM yyy");
//              Date tripDate = null;
//                try {
//                     tripDate = format.parse(date);
//                } catch (ParseException ex) {
//                    Logger.getLogger(ToBook.class.getName()).log(Level.SEVERE, null, ex);
//                }
//              
////              System.out.println("***************"+tripDate);
//            Time arrivalTime = new java.sql.Time(formatter.parse(time).getTime());
//             System.out.println("***************"+arrivalTime);

          }
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            processRequest(request, response);
        } catch (ParseException ex) {
            Logger.getLogger(ToBook.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ToBook.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(ToBook.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            processRequest(request, response);
        } catch (ParseException ex) {
            Logger.getLogger(ToBook.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ToBook.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(ToBook.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
