/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package GUI.administracion;

import GUI.Main;
import barberia.Barberia;
import barberia.Cita;
import barberia.mailer.Correo;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Daniel
 */
public class Notificaciones extends javax.swing.JFrame {

    private Main main;
    private ArrayList<Cita> citas;
    
    
    public Notificaciones(Main main) {
        
        try{
        this.main = main;
        this.citas = main.getBarberia().getAgenda().getCitasDia();
        if (citas.size()==0){
            throw  new NullPointerException("No hay citas para notificar por ahora");
        }
        this.setTitle("Enviar notificaciones de correo");
        initComponents();
        initTable();
        this.setVisible(true);
        }
        catch(NullPointerException e){
            JOptionPane.showMessageDialog(this, "No hay citas", "Operación inválida", JOptionPane.WARNING_MESSAGE);
        }
        
    }
    
    private void initTable(){
        DefaultTableModel  tm = new DefaultTableModel(){
            @Override
            public boolean isCellEditable(int row, int column) {
       
                return false;
            }
        };
        tm.addColumn("Fecha");
        tm.addColumn("Cliente");
        tm.addColumn("Correo");
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/YYYY HH:mm");
        for (Cita c: citas){
            tm.addRow(new Object [] {c.getFecha().format(dtf), c.getCliente().getNombre(), c.getCliente().getCorreo()});
        }
        jTable1.setModel(tm);
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btnCorreo = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        btnCorreo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/mail.png"))); // NOI18N
        btnCorreo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCorreoActionPerformed(evt);
            }
        });

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        jScrollPane1.setViewportView(jTable1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 375, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnCorreo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(34, 34, 34))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(23, 23, 23)
                        .addComponent(btnCorreo, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 275, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(14, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnCorreoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCorreoActionPerformed
        Cita cita= null;
        try{
            Barberia b = main.getBarberia();
            if (JOptionPane.showConfirmDialog(this,"¿Desea enviar las notificaiones?", "Confirmacion", JOptionPane.YES_NO_OPTION)==0){
                for (Cita c: citas){
                    cita =c;
                    if (!c.estaNotificada()&&!c.estaConfirmada()){
                        Correo correo = new Correo(c, b);
                        correo.enviar();
                        c.notificacionEnviada();
                    }
                }
                JOptionPane.showMessageDialog(this, "Los correos se han enviadon con éxito",
                        "Operación exitosa", JOptionPane.INFORMATION_MESSAGE);
            }
            
        }catch (Exception e){
            if (JOptionPane.showConfirmDialog(this,"Ha ocurrido un error ¿Desea reintentar el envío del correo a "+cita.getCliente().getCorreo()+"?", 
                    "Error", JOptionPane.YES_NO_OPTION)==0){
                btnCorreoActionPerformed(evt);
            }else if (JOptionPane.showConfirmDialog(this,"¿Desea abortar el envío?", "", JOptionPane.YES_NO_OPTION)==1){
                JOptionPane.showMessageDialog(this,"Se enviarán los demás correos (si los hay) omitiendo el de"
                        + cita.getCliente().getCorreo(), "Continuar", JOptionPane.INFORMATION_MESSAGE);
                this.citas.remove(cita);
                btnCorreoActionPerformed(evt);
            }
        }
            
    }//GEN-LAST:event_btnCorreoActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCorreo;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    // End of variables declaration//GEN-END:variables
}
