/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package GUI.clientes;

import GUI.funciones.funciones;
import Exceptions.ExistingClientException;
import Exceptions.InvalidEmailException;
import Exceptions.InvalidNameException;
import Exceptions.InvalidPhoneException;
import GUI.Main;


import javax.swing.JFrame;
import javax.swing.JOptionPane;

/**
 *
 * @author Daniel
 */
public class CrearClientes extends javax.swing.JFrame {
    private Main main;
   
    
    public CrearClientes(Main main) {
        funciones.setLogo(this);
        this.setLocation(500,250);
        this.main=main;
        
        initComponents();
        this.setResizable(false);
        this.setVisible(true);
        
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        textoCorreo = new javax.swing.JTextField();
        textoNombre = new javax.swing.JTextField();
        textoTelefono = new javax.swing.JTextField();
        btnCrear = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        btnCancelar = new javax.swing.JButton();
        labHint = new javax.swing.JLabel();
        labHint1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jLabel1.setText("Nombre:");

        jLabel2.setText("Correo:");

        jLabel3.setText("Teléfono:");

        btnCrear.setText("Crear Cliente");
        btnCrear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCrearActionPerformed(evt);
            }
        });

        jLabel4.setText("Inserte los datos del nuevo cliente");

        jLabel5.setText("CREACION NUEVO CLIENTE");

        btnCancelar.setText("Cancelar");
        btnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                volver(evt);
            }
        });

        labHint.setForeground(new java.awt.Color(102, 102, 102));
        labHint.setText("Ejemplos de algunos formatos válidos:");
        labHint.setEnabled(false);
        labHint.setFocusable(false);
        labHint.setRequestFocusEnabled(false);
        labHint.setVerifyInputWhenFocusTarget(false);

        labHint1.setForeground(new java.awt.Color(102, 102, 102));
        labHint1.setText("(506)12345678 , 12345678, 1234-5678, (506) 1234 5678");
        labHint1.setEnabled(false);
        labHint1.setFocusable(false);
        labHint1.setRequestFocusEnabled(false);
        labHint1.setVerifyInputWhenFocusTarget(false);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel4)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel3)
                                    .addComponent(jLabel2)
                                    .addComponent(jLabel1))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(btnCrear)
                                        .addGap(18, 18, 18)
                                        .addComponent(btnCancelar))
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(textoNombre, javax.swing.GroupLayout.DEFAULT_SIZE, 225, Short.MAX_VALUE)
                                        .addComponent(textoCorreo)
                                        .addComponent(textoTelefono))))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(85, 85, 85)
                        .addComponent(jLabel5))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(labHint))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(labHint1)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel5)
                .addGap(16, 16, 16)
                .addComponent(jLabel4)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(textoNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(textoCorreo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(textoTelefono, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(labHint)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(labHint1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 13, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnCrear)
                    .addComponent(btnCancelar))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnCrearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCrearActionPerformed
        
        try{
            main.crearCliente(textoNombre.getText(), textoCorreo.getText(), textoTelefono.getText());
            JOptionPane.showMessageDialog(this, "Nuevo cliente creado."
                    + "\nNombre: " + textoNombre.getText() 
                    + "\nCorreo: " + textoCorreo.getText()
                    + "\nTeléfono: " + textoTelefono.getText(), "Se ha agregado un cliente",
                    JOptionPane.PLAIN_MESSAGE);
            volver(evt);
        }catch(ExistingClientException e){
            JOptionPane.showMessageDialog(this, e.getMessage(), "Cliente ya existe", JOptionPane.ERROR_MESSAGE);
            textoCorreo.setText("");
            textoNombre.setText("");
            textoTelefono.setText("");
        }catch (InvalidEmailException e){
            JOptionPane.showMessageDialog(this, e.getMessage(), "eMail inválido", JOptionPane.ERROR_MESSAGE);
            textoCorreo.setText("");
        }catch (InvalidPhoneException e){
            JOptionPane.showMessageDialog(this, e.getMessage(), "Teléfono inválido", JOptionPane.ERROR_MESSAGE);
            textoTelefono.setText("");
        }catch (InvalidNameException e){
            JOptionPane.showMessageDialog(this, e.getMessage(), "Nombre inválido", JOptionPane.ERROR_MESSAGE);
            labHint.setVisible(true);
            labHint1.setVisible(true);
            textoNombre.setText("");
        } 
    }//GEN-LAST:event_btnCrearActionPerformed

    private void volver(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_volver
       this.dispose();
       
    }//GEN-LAST:event_volver

   
  
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCancelar;
    private javax.swing.JButton btnCrear;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel labHint;
    private javax.swing.JLabel labHint1;
    private javax.swing.JTextField textoCorreo;
    private javax.swing.JTextField textoNombre;
    private javax.swing.JTextField textoTelefono;
    // End of variables declaration//GEN-END:variables
}
