/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.proyectosalud.gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultListModel;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.SwingUtilities;
import javax.swing.plaf.DimensionUIResource;

/**
 *
 * @author mac
 */
public class VistaConsultar extends javax.swing.JPanel {

    /**
     * Creates new form VistaConsultar
     */
    public VistaConsultar() {
        initComponents();
        initStyles();
    }

    public void initStyles(){

         textoprincipal.putClientProperty("FlatLaf.style", "font: bold $h1.font");
        textoprincipal.setForeground(Color.BLACK);
     botonconsultar.putClientProperty("FlatLaf.style", "font: bold $h3.font");
        botonconsultar.setForeground(Color.BLACK);
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
        jLabel1 = new javax.swing.JLabel();
        nombrefield = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        cedulafield = new javax.swing.JTextField();
        botonconsultar = new javax.swing.JButton();
        botonvolver = new javax.swing.JButton();
        paneocita = new javax.swing.JScrollPane();
        listaview = new javax.swing.JList<>();
        jPanel1 = new javax.swing.JPanel();
        textoprincipal = new javax.swing.JLabel();

        panelprincipal.setBackground(new java.awt.Color(255, 255, 255));

        jLabel1.setText("Ingrese Nombre");

        nombrefield.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nombrefieldActionPerformed(evt);
            }
        });

        jLabel2.setText("Ingrese Numero Documento");

        cedulafield.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cedulafieldActionPerformed(evt);
            }
        });

        botonconsultar.setText("CONSULTAR");
        botonconsultar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                botonconsultarMousePressed(evt);
            }
        });
        botonconsultar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonconsultarActionPerformed(evt);
            }
        });

        botonvolver.setText("ATRAS");
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

        listaview.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        listaview.setFont(new java.awt.Font("AppleMyungjo", 0, 12)); // NOI18N
        listaview.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = { "CITA AGENDADA:" };
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });
        listaview.setToolTipText("");
        listaview.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        listaview.setLayoutOrientation(javax.swing.JList.HORIZONTAL_WRAP);
        listaview.setVerifyInputWhenFocusTarget(false);
        paneocita.setViewportView(listaview);

        textoprincipal.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        textoprincipal.setText("         Consulta Cita Medica");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(textoprincipal, javax.swing.GroupLayout.DEFAULT_SIZE, 573, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(textoprincipal, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        javax.swing.GroupLayout panelprincipalLayout = new javax.swing.GroupLayout(panelprincipal);
        panelprincipal.setLayout(panelprincipalLayout);
        panelprincipalLayout.setHorizontalGroup(
            panelprincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelprincipalLayout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addGroup(panelprincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelprincipalLayout.createSequentialGroup()
                        .addGroup(panelprincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(380, 380, 380))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelprincipalLayout.createSequentialGroup()
                        .addGroup(panelprincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(paneocita, javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(panelprincipalLayout.createSequentialGroup()
                                .addComponent(botonconsultar, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE)))
                        .addGap(101, 101, 101))))
            .addGroup(panelprincipalLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelprincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(panelprincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(cedulafield, javax.swing.GroupLayout.PREFERRED_SIZE, 305, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(nombrefield, javax.swing.GroupLayout.PREFERRED_SIZE, 305, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(botonvolver, javax.swing.GroupLayout.PREFERRED_SIZE, 203, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(69, Short.MAX_VALUE))
        );
        panelprincipalLayout.setVerticalGroup(
            panelprincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelprincipalLayout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(35, 35, 35)
                .addGroup(panelprincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(nombrefield, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addGap(27, 27, 27)
                .addGroup(panelprincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(cedulafield, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(85, 85, 85)
                .addGroup(panelprincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(botonconsultar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(botonvolver, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(70, 70, 70)
                .addComponent(paneocita, javax.swing.GroupLayout.DEFAULT_SIZE, 36, Short.MAX_VALUE)
                .addGap(146, 146, 146))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(panelprincipal, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(panelprincipal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 16, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void botonconsultarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonconsultarActionPerformed

    }//GEN-LAST:event_botonconsultarActionPerformed

    private void botonconsultarMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_botonconsultarMousePressed
        try {
            // TODO add your handling code here:
            ConexionBD cn = new ConexionBD();
            Connection conexion = cn.conexion();
            AccesoDatos ac = new AccesoDatos();
            String nombre = nombrefield.getText();
            String cedula = cedulafield.getText();

            DefaultListModel<String> citas = ac.consultaCitaMedica(conexion,nombre, cedula);

            listaview.setModel(citas);
        
            paneocita.setViewportView(listaview);

            // panelconsulta.revalidate();
            // panelconsulta.repaint();

        } catch (SQLException ex) {
            Logger.getLogger(VistaConsultar.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(VistaConsultar.class.getName()).log(Level.SEVERE, null, ex);
        }
        // TODO add your handling code here:
    }//GEN-LAST:event_botonconsultarMousePressed
    
    public void initBotonVolver(){
   JFrame frame = (JFrame) SwingUtilities.getWindowAncestor(panelprincipal); 
   frame.dispose();
    
   Dashboard ds = new Dashboard();
   ds.setVisible(true);
   ds.revalidate();
   ds.repaint();
    }
    private void cedulafieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cedulafieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cedulafieldActionPerformed

    private void nombrefieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nombrefieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_nombrefieldActionPerformed

    private void botonvolverActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonvolverActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_botonvolverActionPerformed

    private void botonvolverMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_botonvolverMousePressed
        // TODO add your handling code here:
        initBotonVolver();
    }//GEN-LAST:event_botonvolverMousePressed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton botonconsultar;
    private javax.swing.JButton botonvolver;
    private javax.swing.JTextField cedulafield;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JList<String> listaview;
    private javax.swing.JTextField nombrefield;
    private javax.swing.JPanel panelprincipal;
    private javax.swing.JScrollPane paneocita;
    private javax.swing.JLabel textoprincipal;
    // End of variables declaration//GEN-END:variables
}
