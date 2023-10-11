
package com.tecsup.edu.lab05.controller;

import java.io.IOException;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import  com.tecsup.edu.lab05.dao.EstudianteDao;
import  com.tecsup.edu.lab05.model.Estudiante;

/**
 *
 * @author edu
 */
@WebServlet(name = "DeleteEstudianteServlet", urlPatterns = {"/DeleteEstudianteServlet"})
public class DeleteEstudianteServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

    }
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        EstudianteDao estudianteDao = new EstudianteDao();
        String mensaje="";
        String id = request.getParameter("id");
        Estudiante estudiante = new Estudiante();
        estudiante.setId(id);
        try{
            mensaje = estudianteDao.deleteEstudiante(estudiante);
        }catch(Exception e){
            mensaje=e.toString();
            e.printStackTrace();
        }
        RequestDispatcher dispatcher = request.getRequestDispatcher("/success.jsp");
        request.setAttribute("message",mensaje );
        dispatcher.forward(request,response);
    }
}
