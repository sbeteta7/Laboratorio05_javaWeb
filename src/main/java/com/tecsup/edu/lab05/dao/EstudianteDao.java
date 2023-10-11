package com.tecsup.edu.lab05.dao;

import com.tecsup.edu.lab05.dao.mysql.MySqlConnection;
import com.tecsup.edu.lab05.model.Estudiante;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class EstudianteDao {

    public int addEstudiante(Estudiante estudiante) throws Exception {

        MySqlConnection mySQLConnection = new MySqlConnection();
        Connection con = mySQLConnection.getConnection();
        int rowsAffected = 0;

        String queryInsert = "INSERT INTO ESTUDIANTES (nombre,apellido,email,birth_date,universidad,carrera) " +
                "VALUES (?,?,?,?,?,?)";

        PreparedStatement ps = con.prepareStatement(queryInsert);
        ps.setString(1, estudiante.getNombre());
        ps.setString(2, estudiante.getApellido());
        ps.setString(3, estudiante.getEmail());
        // Convierte la cadena de fecha en un objeto Date
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        Date birthDate = (Date) dateFormat.parse(estudiante.getBirth_date());
        ps.setDate(4, new java.sql.Date(birthDate.getTime())); // Utiliza java.sql.Date
        ps.setString(5, estudiante.getUniversidad());
        ps.setString(6, estudiante.getCarrera());

        rowsAffected = ps.executeUpdate();
        return rowsAffected;

    }

    public List<Estudiante> getEstudiantes() throws Exception {

        MySqlConnection mySQLConnection = new MySqlConnection();
        Connection con = mySQLConnection.getConnection();

        String querySelect = "SELECT * FROM ESTUDIANTES";
        Statement st = con.createStatement();
        ResultSet resultSet = st.executeQuery(querySelect);

        List<Estudiante> listEstudiantes = new ArrayList<>();

        while (resultSet.next()) {
            Estudiante estudiante = new Estudiante();
            estudiante.setId(String.valueOf(resultSet.getInt("id")));
            estudiante.setNombre(resultSet.getString("nombre"));
            estudiante.setApellido(resultSet.getString("apellido"));
            estudiante.setEmail(resultSet.getString("email"));
            estudiante.setBirth_date(resultSet.getString("birth_date"));
            estudiante.setUniversidad(resultSet.getString("universidad"));
            estudiante.setCarrera(resultSet.getString("carrera"));
            listEstudiantes.add(estudiante);
        }
        return listEstudiantes;
    }

    public Estudiante getDetails(String id) throws Exception {
        Estudiante estudiante = new Estudiante();
        MySqlConnection mySQLConnection = new MySqlConnection();
        Connection conn = mySQLConnection.getConnection();

        //Primero evaluamos si el usuario existe
        PreparedStatement ps = conn.prepareStatement("SELECT * FROM ESTUDIANTES where id=?");

        ps.setInt(1, Integer.parseInt(id));
        ResultSet rs = ps.executeQuery();

        while (rs.next()) {

            estudiante.setId(String.valueOf(rs.getInt("id")));
            estudiante.setNombre(rs.getString("nombre"));
            estudiante.setApellido(rs.getString("apellido"));
            estudiante.setEmail(rs.getString("email"));
            estudiante.setBirth_date(rs.getString("birth_date"));
            estudiante.setUniversidad(rs.getString("universidad"));
            estudiante.setCarrera(rs.getString("carrera"));

        }
        return estudiante;
    }

    public String updateEstudiante(Estudiante estudiante) throws Exception {

        String message = "";
        MySqlConnection mySQLConnection = new MySqlConnection();
        Connection conn = mySQLConnection.getConnection();
        int rowsAffected = 0;
        int count = 0;
        //Primero evaluamos si el usuario existe
        PreparedStatement ps = conn.prepareStatement("SELECT * FROM ESTUDIANTES where id=?");
        ps.setInt(1, Integer.parseInt(estudiante.getId()));
        ResultSet rs = ps.executeQuery();
        while (rs.next()) {
            count++;
        }

        if (count > 0) {
            String queryUpdate = "UPDATE ESTUDIANTES SET nombre=?, apellido=?,email=?,birth_date=?,universidad=?,carrera=? WHERE id=?";
            PreparedStatement psUpdate = conn.prepareStatement(queryUpdate);
            psUpdate.setString(1, estudiante.getNombre());
            psUpdate.setString(2, estudiante.getApellido());
            psUpdate.setString(3, estudiante.getEmail());
            // Convierte la cadena de fecha en un objeto Date
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
            Date birthDate = dateFormat.parse(estudiante.getBirth_date());
            psUpdate.setDate(4, new java.sql.Date(birthDate.getTime())); // Utiliza java.sql.Date
            psUpdate.setString(5, estudiante.getUniversidad());
            psUpdate.setString(6, estudiante.getCarrera());
            psUpdate.setInt(7, Integer.parseInt(estudiante.getId()));

            rowsAffected = psUpdate.executeUpdate();


            if (rowsAffected > 0) {
                message = "Se actualizo el usuario satisfactoriamente";
            } else {
                message = "Ocurrio un error";
            }
        } else {
            message = "Estudiante no existe";
        }

        return message;

    }


    public String deleteEstudiante(Estudiante estudiante) throws Exception {

        String message = "";
        MySqlConnection mySQLConnection = new MySqlConnection();
        Connection conn = mySQLConnection.getConnection();
        int rowsAffected = 0;
        int count = 0;
        //Primero evaluamos si el usuario existe
        PreparedStatement psDelete = conn.prepareStatement("DELETE FROM ESTUDIANTES WHERE id=?");
        psDelete.setInt(1, Integer.parseInt(estudiante.getId()));
        rowsAffected = psDelete.executeUpdate();

        if (rowsAffected > 0) {
            message = "Se actualizo el usuario satisfactoriamente";
        } else {
            message = "Ocurrio un error";
        }
        return message;
    }
}