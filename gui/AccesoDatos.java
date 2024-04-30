package com.proyectosalud.gui;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import PDFhistoriasclinicas.Imagenes;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;

import historiasclinicas.RutasArchivos;
import java.awt.Desktop;
import java.awt.List;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Time;
import java.util.ArrayList;
import javax.swing.DefaultListModel;
import javax.swing.JList;

import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.text.Document;

public class AccesoDatos {

    private ConexionBD conexionBD;
    private Connection conexion;

    public AccesoDatos() throws SQLException, ClassNotFoundException {
        conexionBD = ConexionBD.obtenerInstancia();
        conexion = conexionBD.conexion();
    }

    public void cerrarConexion() {
        try {
            if (conexion != null && !conexion.isClosed()) {
                conexion.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public boolean AutenticacionUsuarios(String nombre, String contraseña) {

        String sqlSentencia = "SELECT * FROM auntenticacionUsuarios WHERE nombre = ? AND contraseña = ?";

        try {
            Connection con = conexionBD.conexion();

            PreparedStatement pstm = con.prepareStatement(sqlSentencia);

            pstm.setString(1, nombre);
            pstm.setString(2, contraseña);

            try {
                ResultSet resultado = pstm.executeQuery();
                if (resultado.next()) {

                    return true;

                } else {
                    return false;
                }

            } catch (Exception e) {
                System.out.println("Eror en el resultado");
            }

        } catch (SQLException e) {
            System.err.println("Error de conexión a la base de datos: " + e.getMessage());
            return false;
        }
        return false; // Agregar un retorno por defecto para cubrir todos los casos
    }
    public boolean inicioExitoso8(){
    
        if (AutenticacionUsuarios(consultasql, consultasql)) {
            
        }
        
    return false;
    }
      
   
    public boolean validarCitaMedico(Connection conexion, Date fecha, Time hora, String especialista) throws SQLException {
        String consultasql = "SELECT COUNT(*) FROM citas WHERE fecha = ? AND hora = ? AND especialista = ?";

        try {
            PreparedStatement stm = conexion.prepareStatement(consultasql);

            stm.setDate(1, fecha);
            stm.setTime(2, hora);
            stm.setString(3, especialista);

            try (ResultSet resultado = stm.executeQuery()) {
                if (resultado.next()) {
                    int count = resultado.getInt(1);
                    return count == 0; // Si no hay citas para la misma fecha, hora y médico, la cita es válida
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return false;
    }

    public ArrayList<String> obtenerNombresEspecialistas() throws SQLException {
        ArrayList<String> nombresEspecialistas = new ArrayList<>();
        String sql = "SELECT Nombre FROM Especialistas";
        Connection conexion = conexionBD.conexion();
        PreparedStatement pstmt = conexion.prepareStatement(sql);

        try (ResultSet resultSet = pstmt.executeQuery()) {
            while (resultSet.next()) {
                String nombreEspecialista = resultSet.getString("Nombre");
                nombresEspecialistas.add(nombreEspecialista);
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al consultar nombres de especialistas: " + e.toString());

        }

        return nombresEspecialistas;
    }
    String consultasql = "SELECT COUNT(*) FROM baseDatosSalud WHERE fecha = ? AND hora = ? AND especialista = ?";

    public ArrayList<String> obtenerEspecialidades() {

        ArrayList<String> especialidades = new ArrayList<>();
        String sql = "SELECT Especialidad FROM Especialistas";

        Connection conexion = conexionBD.conexion();
        try (PreparedStatement pstm = conexion.prepareStatement(sql)) {;

            try (ResultSet resultSet = pstm.executeQuery()) {

                while (resultSet.next()) {

                    String especialidad = resultSet.getNString("Especialidad");
                    especialidades.add(especialidad);

                }
            }

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al obtener especialidades: " + e.toString());
        } finally {
            if (conexion != null) {
                try {
                    conexion.close();
                } catch (SQLException e) {
                    JOptionPane.showMessageDialog(null, "Error al cerrar la conexión: " + e.toString());
                }
            }
            return especialidades;

        }
    }

    public void guardarCitas(Connection conexion, Date fecha, Time hora, String motivo, String nombre_usuario, String cedula_usuario, String especialista) throws SQLException {
        String sqlInsertCita = "INSERT INTO Citas (fecha, hora, motivo, nombre_usuario, cedula_usuario, especialista) VALUES (?, ?, ?, ?, ?, ?)";

        try (PreparedStatement pstmtInsertCita = conexion.prepareStatement(sqlInsertCita)) {
            pstmtInsertCita.setDate(1, fecha);
            pstmtInsertCita.setTime(2, hora);
            pstmtInsertCita.setString(3, motivo);
            pstmtInsertCita.setString(4, nombre_usuario);
            pstmtInsertCita.setString(5, cedula_usuario);
            pstmtInsertCita.setString(6, especialista);
           
            pstmtInsertCita.executeUpdate();
          //  System.out.println("Cita guardada exitosamente en la base de datos.");
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al guardar la cita: " + e.toString());
        }
    }

    public DefaultListModel<String> consultaCitaMedica(Connection conexion, String nombre, String cedula) throws SQLException {
        DefaultListModel<String> ListaCitas = new DefaultListModel<>();

        // Consulta SQL para obtener las citas, ADICIONAMOS LA CLAUSULA LIKE PARA EVITAR ERRORES AL ESCRBIRI CON ESPACION O MAYUSUCULAS O MINUSCULAS
        String sqlCita = "SELECT id_cita, fecha, hora, motivo, nombre_usuario, cedula_usuario, especialista FROM citas WHERE nombre_usuario LIKE ? AND cedula_usuario LIKE ?";
        // Preparar la declaración SQL y la conexión
        // try (Connection conexion = conexionBD.conexion()) {
        PreparedStatement statement = conexion.prepareStatement(sqlCita);
        statement.setString(1, "%" + nombre + "%");
        statement.setString(2, "%" +cedula+ "%");

        try (ResultSet rs = statement.executeQuery()) {

            // Iterar sobre los resultados obtenidos
            if (rs.next()) {
                // Construir una representación de la cita y agregarla a la lista
                String cita = "CITA AGENDADA:  Usuario: " + rs.getString("nombre_usuario") +  ", Cedula: " + rs.getString("cedula_usuario") + " Fecha: " + rs.getDate("fecha") + ", Hora: " + rs.getTime("hora")
                           + ", Especialista: " + rs.getString("especialista") + ", Motivo: " + rs.getString("motivo");
                    
                ListaCitas.addElement(cita);
            } else {
                JOptionPane.showMessageDialog(null, "Nombre o Cedula incorrectos");
            }
        }
  //String cita = "CITA AGENDADA:  Fecha: " + rs.getDate("fecha") + ", Hora: " + rs.getTime("hora")
    //                    + "\n" + ", Motivo: " + rs.getString("motivo") + ", Usuario: " + rs.getString("nombre_usuario")
      //                  + ", Cedula: " + rs.getString("cedula_usuario") + "\n" + ", Especialista: " + rs.getString("especialista");
        return ListaCitas;
    }

// Otros métodos y propiedades de tu clase AccesoDatos
    public boolean verificarExistenciaCita(int idCita) throws SQLException {
        // SQL para verificar la existencia de la cita con el ID proporcionado
        String sqlVerificarCita = "SELECT COUNT(*) FROM citas WHERE id_cita = ?";

        try (Connection conexion = conexionBD.conexion();
                PreparedStatement pstmt = conexion.prepareStatement(sqlVerificarCita)) {
            pstmt.setInt(1, idCita);

            try (ResultSet rs = pstmt.executeQuery()) {
                if (rs.next()) {
                    int count = rs.getInt(1);
                    // Si count es mayor que 0, la cita existe en la base de datos
                    return count > 0;

                }
            }
        }

        // Si no se encontró ninguna cita con el ID proporcionado, retorna false
        return false;

    }

    public void ModificarCita(Connection conexion, String idCita, Date nuevaFecha, Time nuevaHora, String nuevoMotivo) throws SQLException {
        // SQL para actualizar la cita con el ID proporcionado
        String sqlUpdateCita = "UPDATE Citas SET fecha = ?, hora = ?, motivo = ? WHERE id_cita = ?";

        //  try (Connection conexion = conexionBD.conexion();
        try {
            PreparedStatement pstmtUpdateCita = conexion.prepareStatement(sqlUpdateCita);

            // Establecer los valores de los parámetros
            pstmtUpdateCita.setDate(1, nuevaFecha);
            pstmtUpdateCita.setTime(2, nuevaHora);
            pstmtUpdateCita.setString(3, nuevoMotivo);
            pstmtUpdateCita.setString(4, idCita);

            // Ejecutar la actualización
            int filasActualizadas = pstmtUpdateCita.executeUpdate();

            if (filasActualizadas > 0) {
                System.out.println("Cita con ID " + idCita + " modificada exitosamente.");
            } else {
                System.out.println("No se encontró ninguna cita con ID " + idCita);
            }

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al modificar la cita: " + e.toString());
        }
    }

    public boolean descargarHistoriaClinicaPDF(Connection conexion, String nombre, String cedula) throws IOException {
        PDDocument documento = new PDDocument();
        PDPage pagina = new PDPage();
        documento.addPage(pagina);
        documento.save("historiaClinica01.pdf");

        String sql = "SELECT pdf FROM historia_clinica WHERE nombre = ? AND cedula = ?";
        String nombreArchivo = "historiaClinica01.pdf";
        String rutaDirectorio = RutasArchivos.RutaDirectorio;

        try (
                PreparedStatement pstmt = conexion.prepareStatement(sql)) {
            pstmt.setString(1, nombre);
            pstmt.setString(2, cedula);

            try (ResultSet rs = pstmt.executeQuery()) {

                if (rs.next()) {
                    byte[] pdfBytes = rs.getBytes("pdf");

                    File directorio = new File(rutaDirectorio);
                    if (!directorio.exists()) {
                        directorio.mkdirs();
                    }
                    String rutaCompleta = rutaDirectorio + File.separator + nombreArchivo;

                    try (FileOutputStream fos = new FileOutputStream(rutaCompleta)) {
                        fos.write(pdfBytes);
                        return true; // Descarga exitosa
                    }
                } else {
                   JOptionPane.showMessageDialog(null, "No se encontró la historia clínica para el nombre y cédula proporcionados");
                    return false; // No se encontró la historia clínica
                }
            }
        } catch (SQLException | IOException e) {
            e.printStackTrace();
            return false; // Error durante la descarga
        }
    }

    public boolean agregarHistoriaClinicaPDF(String nombre, String cedula, File archivoPDF) {
        String sql = "INSERT INTO historia_clinica (nombre, cedula, pdf) VALUES (?, ?, ?)";

        try (Connection conexion = conexionBD.conexion();
                PreparedStatement pstmt = conexion.prepareStatement(sql)) {

            pstmt.setString(1, nombre);
            pstmt.setString(2, cedula);

            try (FileInputStream fis = new FileInputStream(archivoPDF)) {
                pstmt.setBinaryStream(3, fis, archivoPDF.length());
                pstmt.executeUpdate();
                return true; // Inserción exitosa
            }
        } catch (SQLException | IOException e) {
            e.printStackTrace();
            return false; // Error durante la inserción
        }

    }

    public boolean mostrarHistoriaClinica(Connection conexion) throws IOException {
        Desktop desktop = Desktop.getDesktop();
        String rutaImagen = Imagenes.rutaImagen;
        // Verificar si Desktop está soportado 
        if (Desktop.isDesktopSupported()) {
            File file = new File(rutaImagen);
            desktop.open(file);
            return true;
        }
        return false;
    }
    public boolean validacionSql (String nombre, String cedula ){
        
        String sql = "SELECT * FROM historia_clinica  WHERE nombre = ? AND cedula = ? ";
        
        try { Connection conexion = conexionBD.conexion();
            PreparedStatement pstm = conexion.prepareStatement(sql);
        
            pstm.setString(1,nombre);
            pstm.setString(2,cedula);
           
            pstm.executeQuery();
             return true;
              
        }catch(SQLException E){
        return false;
        }
        
    }
}

/* public void guardarCitas(Date fecha, Time hora, String motivo, String nombre_usuario, String cedula_usuario, String especialista) throws SQLException {
        String sqlInsertCita = "INSERT INTO Citas (fecha, hora, motivo, nombre_usuario, cedula_usuario, especialista) VALUES (?, ?, ?, ?, ?, ?)";

        Connection conexion = conexionBD.conexion();
            try (PreparedStatement pstmtInsertCita = conexion.prepareStatement(sqlInsertCita)) {
                pstmtInsertCita.setDate(1, fecha);
                pstmtInsertCita.setTime(2, hora);
                pstmtInsertCita.setString(3, motivo);
                pstmtInsertCita.setString(4, nombre_usuario);
                pstmtInsertCita.setString(5, cedula_usuario);
                pstmtInsertCita.setString(6, especialista);
                pstmtInsertCita.executeUpdate();
                System.out.println("Cita guardada exitosamente en la base de datos.");
            }
         catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al guardar la cita: " + e.toString());
           
        }
            finally{
                if (conexion != null) {
                    conexion.close();
                }
            }

    }*/
