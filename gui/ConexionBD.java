package com.proyectosalud.gui;



import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author mac
 */
// Clase conexionBD usanso el patron de arquitectura singleton
    public class ConexionBD {

        private static ConexionBD instancia;
        private Connection conexion;

        private String url = "jdbc:mysql://127.0.0.1:3306/baseDatosSalud";
        private String nombreUsuario = "root";
        private String contraseña = ".KAIRa1014278938.";

        ConexionBD() throws SQLException, ClassNotFoundException {

            Class.forName("com.mysql.cj.jdbc.Driver");
            this.conexion = DriverManager.getConnection(url, nombreUsuario, contraseña);

        }

        private static ConexionBD getInstancia() throws SQLException, ClassNotFoundException {

            if (instancia == null) {
                instancia = new ConexionBD();
            }
            return instancia;
        }

        public static ConexionBD obtenerInstancia() throws SQLException, ClassNotFoundException {

            return getInstancia();
        }

        public Connection conexion() {
            return conexion;
        }

        public void cerrarConexion() throws SQLException {
            if (conexion != null) {
                conexion.close();
                System.out.println("conexion cerrada correctemente");
            }
        }
        

    }
