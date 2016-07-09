/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package GUI.servicios;

import GUI.Main;
import GUI.funciones.funciones;
import barberia.Servicio;
import javax.swing.DefaultListModel;

/**
 *
 * @author Daniel
 */
public class AdministrarServicios extends javax.swing.JFrame {

    private Main main;
    private DefaultListModel modelo;
    
    public AdministrarServicios(Main main) {
        this.main = main;
        initComponents();
        modelo = new DefaultListModel();
        actualizarLista();
        this.setVisible(true);
        
    
    }
    
    public void actualizarLista(){
        try{
            int i=0;
            modelo.removeAllElements();
            for (Servicio s : main.getBarberia().getServicios()){
                System.out.println(s.getNombre());
                modelo.addElement(++i + ". "+s.getNombre());
            }
            listaServicios.setModel(modelo);
        }catch (IndexOutOfBoundsException e){
            if (main.getBarberia().getServicios().size() ==0){
                modelo.removeAllElements();
            }
        }
    }


    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        listaServicios = new javax.swing.JList();
        editar = new javax.swing.JButton();
        eliminar = new javax.swing.JButton();
        crear = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jScrollPane1.setViewportView(listaServicios);

        editar.setText("Modificar");
        editar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                editarActionPerformed(evt);
            }
        });

        eliminar.setText("Eliminar");
        eliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                eliminarActionPerformed(evt);
            }
        });

        crear.setText("Crear");
        crear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                crearActionPerformed(evt);
            }
        });

        jLabel1.setText("Servicios eistentes: ");

        jButton1.setText("Salir");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(0, 60, Short.MAX_VALUE)
                        .addComponent(crear)
                        .addGap(18, 18, 18)
                        .addComponent(editar)
                        .addGap(18, 18, 18)
                        .addComponent(eliminar)
                        .addGap(95, 95, 95))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addGap(156, 156, 156)
                .addComponent(jButton1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(eliminar)
                    .addComponent(editar)
                    .addComponent(crear))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 30, Short.MAX_VALUE)
                .addComponent(jButton1)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void editarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_editarActionPerformed
        try{
            new EditarServicio(main, this,  listaServicios.getSelectedIndex());
            
        }
        catch(IndexOutOfBoundsException e){
            //---//
        }
    }//GEN-LAST:event_editarActionPerformed

    private void eliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_eliminarActionPerformed
        try{
            System.out.println("va a eliminar");
            main.getBarberia().getServicios().remove(listaServicios.getSelectedIndex());
            System.out.println("eliminado");
            actualizarLista();
        }
        catch(IndexOutOfBoundsException e){
            //---//
            System.out.println("index error");
        }
    }//GEN-LAST:event_eliminarActionPerformed

    private void crearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_crearActionPerformed
        new CrearServicio(main, this);
    }//GEN-LAST:event_crearActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        this.dispose();
    }//GEN-LAST:event_jButton1ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton crear;
    private javax.swing.JButton editar;
    private javax.swing.JButton eliminar;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JList listaServicios;
    // End of variables declaration//GEN-END:variables
}
