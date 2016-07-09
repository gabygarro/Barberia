/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package GUI.administracion;

import GUI.Main;
import GUI.funciones.funciones;
import barberia.Cliente;
import java.util.ArrayList;
import javax.swing.DefaultListModel;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Daniel
 */
public class ListaDeEspera extends javax.swing.JFrame {

    private Main main;
    private ArrayList<Cliente> clientes;
    private DefaultListModel modeloLista;
    public ListaDeEspera(Main main) {
        try{
            
        
        this.main = main; 
        this.clientes = main.getBarberia().getClientes();
        modeloLista = new DefaultListModel();
        if (clientes.size()==0){
            throw new Exception("No hay clientes");
        }
        initComponents();
        initTabla();
        refrescarLista();
        this.setTitle("Lista de espera");
        this.setVisible(true);
        }catch(Exception e){
            JOptionPane.showMessageDialog(this, e.getMessage(), "No hay clientes", JOptionPane.ERROR_MESSAGE);
           
        }
    
    }
    
    private void initTabla(){
        DefaultTableModel dtm = new DefaultTableModel(){
                @Override
            public boolean isCellEditable(int row, int column) {
       
                return false;
            }
        };
        
        dtm.addColumn("Nombre");
        dtm.addColumn("Correo");
        
        for (Cliente cliente : clientes){
            dtm.addRow(new Object[] {cliente.getNombre(), cliente.getCorreo()});
        }
        jTable1.setModel(dtm);
    }
    
    private void refrescarLista(){
        try{
            modeloLista.removeAllElements();
            int i=0;
            for (Cliente cliente : main.getBarberia().getListaDeEspera()){
                modeloLista.addElement(++i + ". " + cliente.getNombre());
            }
            listaEspera.setModel(modeloLista);
        }catch(Exception e){
            System.out.println("Error lista");
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        btnAgregar = new javax.swing.JButton();
        btnSalir = new javax.swing.JButton();
        jScrollPane3 = new javax.swing.JScrollPane();
        listaEspera = new javax.swing.JList();
        btnEliminar1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

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

        btnAgregar.setText("Agregar");
        btnAgregar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgregarActionPerformed(evt);
            }
        });

        btnSalir.setText("Salir");
        btnSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalirActionPerformed(evt);
            }
        });

        jScrollPane3.setViewportView(listaEspera);

        btnEliminar1.setText("Elminar");
        btnEliminar1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminar1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(90, 90, 90)
                        .addComponent(btnAgregar)
                        .addGap(91, 91, 91)
                        .addComponent(btnEliminar1)
                        .addGap(0, 81, Short.MAX_VALUE)))
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane3)
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnSalir)
                .addGap(165, 165, 165))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 40, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnAgregar, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(btnEliminar1, javax.swing.GroupLayout.Alignment.TRAILING))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnSalir))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnAgregarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregarActionPerformed
        if (!main.getBarberia().getListaDeEspera().contains(main.getBarberia().getClientes().get(jTable1.getSelectedRow()))){
            
            
            main.getBarberia().getListaDeEspera().add(main.getBarberia().getClientes().get(jTable1.getSelectedRow()));
            refrescarLista();
            System.out.println("agregado");
        }
        
    }//GEN-LAST:event_btnAgregarActionPerformed

    private void btnSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalirActionPerformed
        this.dispose();
    }//GEN-LAST:event_btnSalirActionPerformed

    private void btnEliminar1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminar1ActionPerformed
        try{
            System.out.println(main.getBarberia().getListaDeEspera().remove(listaEspera.getSelectedIndex()).getNombre());
            refrescarLista();
        }catch (Exception e ){
            System.out.println("error lista espera eliminar");
        }
    }//GEN-LAST:event_btnEliminar1ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAgregar;
    private javax.swing.JButton btnEliminar1;
    private javax.swing.JButton btnSalir;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTable jTable1;
    private javax.swing.JList listaEspera;
    // End of variables declaration//GEN-END:variables
}
