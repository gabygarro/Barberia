

package GUI.citas.modificarCita;

import GUI.Main;
import GUI.funciones.funciones;
import barberia.Cliente;
import java.util.ArrayList;
import javax.swing.table.DefaultTableModel;

public class SeleccionarCliente extends javax.swing.JFrame {
    
    private ModificarCita modificarCita;
    private Main main;
    
    public SeleccionarCliente(Main main, ModificarCita modificarCita){ 
        this.main = main;
        this.modificarCita = modificarCita;
        initComponents();
        DefaultTableModel tm = new DefaultTableModel(){
                @Override
            public boolean isCellEditable(int row, int column) {
       
                return false;
            }
        };
        tm.addColumn("Nombre");
        tm.addColumn("Correo");
        tm.addColumn("Telefono");
        this.setTitle("Seleccionar cliente");
        funciones.setLogo(this);
        
        
        
        for (Cliente cliente : main.getBarberia().getClientes()){
            tm.addRow(new Object[]{cliente.getNombre(), cliente.getCorreo(), cliente.getTelefono()});
        }
        tablaClientes.setModel(tm);
        this.setVisible(true);
    }
    
    
   
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane2 = new javax.swing.JScrollPane();
        tablaClientes = new javax.swing.JTable();
        jButton1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        tablaClientes.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Nombre", "Correo", "Telefono"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        jScrollPane2.setViewportView(tablaClientes);

        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/confirmar-icon.png"))); // NOI18N
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 420, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addGap(180, 180, 180)
                .addComponent(jButton1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 271, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButton1))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        modificarCita.getCita().setCliente(main.getBarberia().getClientes().get(tablaClientes.getSelectedRow()));
        modificarCita.refrescar();
        this.dispose();
    }//GEN-LAST:event_jButton1ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable tablaClientes;
    // End of variables declaration//GEN-END:variables
}
