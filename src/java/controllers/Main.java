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
                case "addPatient":
                    addPatient(request, response);
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

    private void addPatient(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        //recogemos desde el formulario
        String messages = "";
        Boolean menopause;
        int age = 0;
        age = Integer.parseInt(request.getParameter("age"));
        String grupEdat = request.getParameter("grupedat");
        int weight = 0;
        weight = Integer.parseInt(request.getParameter("weight"));
        int height = 0;
        height = Integer.parseInt(request.getParameter("height"));
        double imc=0;
        if ((weight > 0) && (height > 0)) {
            imc = (weight / ((height/100)^2));
        } else {
            messages += "<br>Los valores peso y altura deben ser mayores de cero.";
        }
        String classification = request.getParameter("classification");
        int manarche = 0;
        manarche = Integer.parseInt(request.getParameter("manarche"));
        if (request.getParameter("menopause")=="YES") {
             menopause = true;
        }else {
             menopause = false;
        }
        
        String menopauseType = request.getParameter("menopauseType");

        if (!Validation.NumEntreValues(age, 1, 120)) {
            messages += "<br>La edad debe estar comprendida entre 1 y 120 años";
        }
        if (!Validation.NumEntreValues(weight, 10, 150)) {
            messages += "<br>El peso debe estar comprendido entre 10 y 150 Kg";
        }
        if (!Validation.NumEntreValues(height, 30, 210)) {
            messages += "<br>La altura debe estar comprendida entre 30 y 210 cm";
        }
        if (!Validation.NumEntreValues(manarche, 8, 15)) {
            messages += "<br>La menarquia debe estar comprendida entre los 8 y 15 años";
        }

        //se podrían hacer mas validaciones
        //por ejemplo:validar que hi hagin lletres i números al username
        //cuando llego a este punto NO HAY errores
        if (messages.equals("")) {
            Patient p = new Patient(0, age, grupEdat, weight, height, imc, classification, manarche, menopause, menopauseType);
            //ACCESO AL ARCHIVO            
            int returned = pdao.addPatient(p);
            if (returned == -1) {
                messages = "Problemas al añadir al fichero";
            } else if (returned == 0) {
                messages = "Problemas con el fichero";
            } else {
                messages = "Usuario insertado correctamente";
            }
        }

        //response.sendRedirect("register.jsp?error="+messages);
        request.setAttribute("error", messages);
        RequestDispatcher rd = request.getRequestDispatcher("index.jsp");
        rd.forward(request, response);

    }
    
}
