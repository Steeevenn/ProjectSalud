/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.proyectosalud.gui;

import java.awt.Color;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Time;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;

/**
 *
 * @author mac
 */
public class VistaModificar extends javax.swing.JPanel {

    /**
     * Creates new form VistaModificar
     */
  
    
    public VistaModificar() throws SQLException, ClassNotFoundException {
        initComponents();
        llenarHoraComboBoxNueva();
        llenarEspecialistasComboBox();
        initStyles();
    }

    public void initStyles() {

         botonmodificar.putClientProperty("FlatLaf.style", "font: bold $h3.font");
         botonmodificar.setForeground(Color.BLACK);
          botonvolver.putClientProperty("FlatLaf.style", "font: bold $h3.font");
         botonvolver.setForeground(Color.BLACK);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panelprincipal = new javax.swing.JPanel();
        botonmodificar = new javax.swing.JButton();
        especialistafield = new javax.swing.JComboBox<>();
        jLabel1 = new javax.swing.JLabel();
        botonvolver = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        fechafield = new com.toedter.calendar.JDateChooser();
        horafield = new javax.swing.JComboBox<>();
        motivofield = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        idfield = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();

        botonmodificar.setText("MODIFICAR CITA");
        botonmodificar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                botonmodificarMousePressed(evt);
            }
        });
        botonmodificar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonmodificarActionPerformed(evt);
            }
        });

        especialistafield.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jLabel1.setText("Seleccione Fecha");

        botonvolver.setText("VOLVER");
        botonvolver.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                botonvolverMousePressed(evt);
            }
        });
        botonvolver.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonvolverActionPerformed(evt);
            }
        });

        jLabel2.setText("Selecciones Hora");

        jLabel3.setText("Ingrese motivo de consulta");

        horafield.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        horafield.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                horafieldActionPerformed(evt);
            }
        });

        jLabel5.setText("Seleccione un Especialista");

        idfield.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                idfieldActionPerformed(evt);
            }
        });

        jLabel4.setText("Ingrese Id de su cita Agendada");

        jLabel6.setIcon(new javax.swing.ImageIcon("/Users/mac/NetBeansProjects/Programacion/ProyectoSalud/src/main/Recursos/mod.jpg")); // NOI18N

        javax.swing.GroupLayout panelprincipalLayout = new javax.swing.GroupLayout(panelprincipal);
        panelprincipal.setLayout(panelprincipalLayout);
        panelprincipalLayout.setHorizontalGroup(
            panelprincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelprincipalLayout.createSequentialGroup()
                .addGroup(panelprincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(panelprincipalLayout.createSequentialGroup()
                        .addGap(49, 49, 49)
                        .addGroup(panelprincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(panelprincipalLayout.createSequentialGroup()
                                .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGap(44, 44, 44))
                            .addGroup(panelprincipalLayout.createSequentialGroup()
                                .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, 187, Short.MAX_VALUE)
                                .addGap(74, 74, 74))
                            .addGroup(panelprincipalLayout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(panelprincipalLayout.createSequentialGroup()
                                .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED))
                            .addGroup(panelprincipalLayout.createSequentialGroup()
                                .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED))))
                    .addGroup(panelprincipalLayout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(botonmodificar, javax.swing.GroupLayout.PREFERRED_SIZE, 239, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(44, 44, 44)))
                .addGroup(panelprincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(botonvolver, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(panelprincipalLayout.createSequentialGroup()
                        .addGroup(panelprincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(motivofield, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(especialistafield, javax.swing.GroupLayout.Alignment.LEADING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(horafield, javax.swing.GroupLayout.Alignment.LEADING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(idfield, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(fechafield, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 208, Short.MAX_VALUE))
                        .addGap(0, 18, Short.MAX_VALUE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, 367, Short.MAX_VALUE)
                .addContainerGap())
        );
        panelprincipalLayout.setVerticalGroup(
            panelprincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelprincipalLayout.createSequentialGroup()
                .addGap(62, 62, 62)
                .addGroup(panelprincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(idfield, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(panelprincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(horafield, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(19, 19, 19)
                .addGroup(panelprincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addComponent(fechafield, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(23, 23, 23)
                .addGroup(panelprincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel5)
                    .addComponent(especialistafield, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(27, 27, 27)
                .addGroup(panelprincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3)
                    .addComponent(motivofield, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(36, 36, 36)
                .addGroup(panelprincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(botonmodificar, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(botonvolver, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(216, Short.MAX_VALUE))
            .addGroup(panelprincipalLayout.createSequentialGroup()
                .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 394, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelprincipal, javax.swing.GroupLayout.DEFAULT_SIZE, 915, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelprincipal, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 600, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents
  public void llenarEspecialistasComboBox() throws SQLException, ClassNotFoundException {
        AccesoDatos accesoDatos = new AccesoDatos();
        ArrayList<String> nombresEspecialistas = accesoDatos.obtenerNombresEspecialistas();

        String[] nombresArray = nombresEspecialistas.toArray(new String[0]);

        especialistafield.setModel(new DefaultComboBoxModel<>(nombresArray));
    }

    private void llenarHoraComboBoxNueva() {
        horafield.removeAllItems();
        for (int hour = 8; hour < 17; hour++) {
            for (int minute = 0; minute < 45; minute += 15) {
                LocalTime time = LocalTime.of(hour, minute);

                horafield.addItem(time.toString());
            }
        }
    }

    public void initBotonVolver() {

        JFrame frame = (JFrame) SwingUtilities.getWindowAncestor(panelprincipal);
   frame.dispose();
   Dashboard ds = new Dashboard();
      ds.setVisible(true);
      ds.revalidate();
       ds.repaint();

      
//  Dashboard ds = new Dashboard();
  //      ds.setVisible(true);
    //    ds.revalidate();
     //   ds.repaint();

    }

    private void idfieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_idfieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_idfieldActionPerformed

    private void botonmodificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonmodificarActionPerformed

    }//GEN-LAST:event_botonmodificarActionPerformed

    private void botonmodificarMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_botonmodificarMousePressed
        // TODO add your handling code here:
        try {
            // TODO add your handling code here:
            AccesoDatos ac = new AccesoDatos();
            ConexionBD cn = new ConexionBD();
            Connection conexion = cn.conexion();

            String especialistafield1 = (String) especialistafield.getSelectedItem();

            // recibir la fehca como util para luego transformarla a sql
            java.util.Date fechautil = fechafield.getDate();
            //Recibi fecha como sql
            java.sql.Date fechasql = new java.sql.Date(fechautil.getTime());
            //recibir hora del combobox
            String hora = (String) horafield.getSelectedItem();
            //convertir hora a LocalTime
            LocalTime localtime = LocalTime.parse(hora);
            //Convertir locatime a Time
            Time horasql = Time.valueOf(localtime);
            String motivosql = motivofield.getText();
            String idcitasql = idfield.getText();

            if (ac.validarCitaMedico(conexion, fechasql, horasql, especialistafield1)) {

                ac.ModificarCita(conexion, idcitasql, fechasql, horasql, motivosql);
                JOptionPane.showMessageDialog(null, "Cita medica modificada correctamente, dirigase a consultar cita medica para validar datos");
            } else {
                JOptionPane.showMessageDialog(null, "Medico no disponible en esa fecha y hora especifica vuelva a intentarlo");
            }
        } catch (SQLException ex) {
            Logger.getLogger(VistaModificar.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(VistaModificar.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_botonmodificarMousePressed

    private void horafieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_horafieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_horafieldActionPerformed

    private void botonvolverActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonvolverActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_botonvolverActionPerformed

    private void botonvolverMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_botonvolverMousePressed
        // TODO add your handling code here:
     
        initBotonVolver ();
        
               
        
    }//GEN-LAST:event_botonvolverMousePressed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton botonmodificar;
    private javax.swing.JButton botonvolver;
    private javax.swing.JComboBox<String> especialistafield;
    private com.toedter.calendar.JDateChooser fechafield;
    private javax.swing.JComboBox<String> horafield;
    private javax.swing.JTextField idfield;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JTextField motivofield;
    private javax.swing.JPanel panelprincipal;
    // End of variables declaration//GEN-END:variables
}
