/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dam.controldepeso;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author dam2
 */
@WebServlet(name = "registro", urlPatterns = {"/registro"}, initParams = {
    @WebInitParam(name = "message", value = "")})
public class registro extends HttpServlet {

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
        if (request.getParameter("nom").isEmpty() || request.getParameter("peso").isEmpty()) {
            request.getSession().setAttribute("message", "Debe rellenar ambos campos");
            request.getRequestDispatcher("/errores.jsp").forward(request, response);
        } else {
            try {
                Integer.parseInt(request.getParameter("peso"));
                request.getSession().setAttribute("peso", request.getParameter("peso"));
                if (request.getSession().getAttribute("nom") == null || request.getSession().getAttribute("nom").toString().equalsIgnoreCase(request.getParameter("nom"))) {
                    request.getSession().setAttribute("nom", request.getParameter("nom"));
                    request.getRequestDispatcher("/principal.jsp").forward(request, response);
                } else {                    
                    request.getSession().setAttribute("message", "Ya se ha registrado como " + request.getSession().getAttribute("nom"));
                    request.getRequestDispatcher("/errores.jsp").forward(request, response);
                }
            } catch (NumberFormatException NumEx) {
                request.getSession().setAttribute("message", "El peso debe ser un número entero");
                request.getRequestDispatcher("/errores.jsp").forward(request, response);
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
