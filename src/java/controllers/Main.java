package controllers;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Patient;
import model.User;
import model.persist.PatientDAO;
import utilities.Validation;

/**
 * Usercontroller.java Controlador de paciente
 *
 * @author Oscar Burgos
 * @version marzo/2019
 */
@WebServlet(name = "Main", urlPatterns = {"/Main"})
public class Main extends HttpServlet {

    private String ruta;
    private PatientDAO pdao;

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
        ruta = getServletContext().getRealPath("/WEB-INF");
        pdao = new PatientDAO(ruta);
        if (request.getParameter("action") != null) {
            String action = request.getParameter("action");
            switch (action) {
                case "loadData":
                    loadDataPatients(request, response);
                    break;
                

            }

        } else {
            response.sendRedirect("index.jsp");
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

    /**
     * Lectura inicial de pacientes
     *
     * @param request
     * @param response
     * @throws IOException
     * @throws ServletException
     */
    private void loadDataPatients(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {

        List<Patient> dataPatients = new ArrayList();
        dataPatients = pdao.findAll();
        request.setAttribute("listObjPatients", dataPatients);

        RequestDispatcher rd = request.getRequestDispatcher("viewpatients.jsp");
        rd.forward(request, response);
    }

    
}
