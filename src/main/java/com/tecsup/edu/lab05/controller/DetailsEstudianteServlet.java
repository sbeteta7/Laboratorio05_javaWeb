package com.tecsup.edu.lab05.controller;

import com.tecsup.edu.lab05.dao.EstudianteDao;
import com.tecsup.edu.lab05.model.Estudiante;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.List;

@WebServlet(name = "DetailsEstudianteServlet", value = "/DetailsEstudianteServlet")
public class DetailsEstudianteServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        EstudianteDao estudianteDao = new EstudianteDao();
        String mensaje="";
        String id = request.getParameter("id");

        Estudiante estudiante = new Estudiante();
        try {
            estudiante = estudianteDao.getDetails(id);
        } catch (Exception e) {
            mensaje=e.toString();
            e.printStackTrace();
        }

        RequestDispatcher dispatcher = request.getRequestDispatcher("/edit.jsp");
        request.setAttribute("Estudiante",estudiante );
        dispatcher.forward(request,response);


    }
}
