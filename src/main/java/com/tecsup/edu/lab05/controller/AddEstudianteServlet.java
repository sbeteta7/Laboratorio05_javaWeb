package com.tecsup.edu.lab05.controller;
import com.tecsup.edu.lab05.model.Estudiante;
import com.tecsup.edu.lab05.dao.EstudianteDao;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;

@WebServlet(name = "EstudianteServlet",value = "/EstudianteServlet")
public class AddEstudianteServlet extends HttpServlet{
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        RequestDispatcher dispatcher = request.getRequestDispatcher("/addestudiante.jsp");
        dispatcher.forward(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        EstudianteDao dao = new EstudianteDao();
        int rowsAffected = 0;

        Estudiante estudiante = new Estudiante();
        estudiante.setNombre(request.getParameter("nombre"));
        estudiante.setApellido(request.getParameter("apellido"));
        estudiante.setEmail(request.getParameter("email"));
        estudiante.setBirth_date(request.getParameter("birth_date"));
        estudiante.setUniversidad(request.getParameter("universidad"));
        estudiante.setCarrera(request.getParameter("carrera"));

        try{
            rowsAffected = dao.addEstudiante(estudiante);
            if(rowsAffected>0) {
                RequestDispatcher requestDispatcher = request.getRequestDispatcher("/success.jsp");
                request.setAttribute("rowsaffected", rowsAffected);
                requestDispatcher.forward(request, response);
            }
        }catch(Exception e){
            RequestDispatcher requestDispatcher = request.getRequestDispatcher("/error.jsp");
            request.setAttribute("message", e );
            requestDispatcher.forward(request,response);
            e.printStackTrace();
        }


    }

}
