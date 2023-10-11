
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
@WebServlet(name = "EditEstudianteServlet", urlPatterns = {"/EditEstudianteServlet"})
public class EditEstudianteServlet extends HttpServlet {
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
        String nombre = request.getParameter("nombre");
        String apellido = request.getParameter("apellido");
        String email = request.getParameter("email");
        String birth_date = request.getParameter("birth");
        String universidad = request.getParameter("universidad");
        String carrera = request.getParameter("carrera");

        Estudiante estudiante = new Estudiante();
        estudiante.setId(id);
        estudiante.setNombre(nombre);
        estudiante.setApellido(apellido);
        estudiante.setEmail(email);
        estudiante.setBirth_date(birth_date);
        estudiante.setUniversidad(universidad);
        estudiante.setCarrera(carrera);

        try{
            mensaje = estudianteDao.updateEstudiante(estudiante);
        }catch(Exception e){
            mensaje=e.toString();
            e.printStackTrace();
        }

        RequestDispatcher dispatcher = request.getRequestDispatcher("/success.jsp");
        request.setAttribute("message",mensaje );
        dispatcher.forward(request,response);
    }
}
