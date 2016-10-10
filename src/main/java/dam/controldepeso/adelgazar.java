/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dam.controldepeso;

import java.io.IOException;
import java.io.PrintWriter;
import java.time.Duration;
import java.time.LocalDateTime;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author dam2
 */
@WebServlet(name = "adelgazar", urlPatterns = {"/adelgazar"})
public class adelgazar extends HttpServlet {

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
            throws ServletException, IOException {
        String kilos = (String) request.getSession().getAttribute("peso");
        LocalDateTime ultimavez = (LocalDateTime) request.getSession().getAttribute("fecha");
        if (ultimavez == null) {
            ultimavez = LocalDateTime.now();
        }
        LocalDateTime ahora = LocalDateTime.now();
        String w = request.getParameter("w");
        if (w != null) {
            try {
                int iKilos = Integer.parseInt(kilos);
                iKilos -= (Integer.parseInt(w) / 30);
                String nombre = (String) request.getSession().getAttribute("nombre");
                request.getSession().setAttribute("peso", iKilos + "");
                request.getSession().setAttribute("fecha", ahora);
                Duration segundos = Duration.between(ultimavez, ahora);
                if((int)segundos.getSeconds()<5)
                request.setAttribute("message", segundos.getSeconds() + "  " + nombre + " pesa Kilos " + iKilos);
                int i = 0;
                request.getRequestDispatcher("/principal.jsp").forward(request, response);
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
        request.getRequestDispatcher("/errores.jsp").forward(request, response);
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
        processRequest(request, response);
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
        processRequest(request, response);
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
