package com.tecsup.edu.lab05.controller;

import com.tecsup.edu.lab05.dao.EstudianteDao;
import com.tecsup.edu.lab05.model.Estudiante;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "ListEstudianteServlet", value = "/ListEstudianteServlet")
public class ListEstudianteServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        EstudianteDao estudianteDao = new EstudianteDao();
        try {
            List<Estudiante> listEstudiantes = estudianteDao.getEstudiantes();
            RequestDispatcher dispatcher = request.getRequestDispatcher("/listestudiante.jsp");
            request.setAttribute("list",listEstudiantes);
            dispatcher.forward(request,response);
        } catch (Exception e) {
            String errorMessage = "Hubo un problema al obtener la lista de estudiantes.";
            RequestDispatcher requestDispatcher = request.getRequestDispatcher("/error.jsp");
            request.setAttribute("errorMessage", errorMessage);
            requestDispatcher.forward(request, response);
            e.printStackTrace();
        }

        System.out.println("------ Contenido del objeto request ------");
        System.out.println("URI: " + request.getRequestURI());
        System.out.println("Método: " + request.getMethod());
    }
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


    }
}