
package GUI.clientes;

import GUI.Main;
import GUI.funciones.funciones;
import barberia.Cliente;
import java.util.ArrayList;
import javax.swing.JFrame;
import javax.swing.JOptionPane;



public class EliminarCliente extends javax.swing.JFrame  {

    Main main; 
    Cliente cliente;
    java.util.ArrayList<Cliente> clientes;
    int indice;
    
    public EliminarCliente(Main main) {
        try{
        this.main = main;
        this.cliente = null;
        this.clientes= main.getBarberia().getClientes();
        this.indice = 0;
        this.setLocation(800,100);
        init();
        this.setVisible(true);
        } catch (ArrayIndexOutOfBoundsException e){
        } catch (UnsupportedOperationException e){
            JOptionPane.showMessageDialog(this, e.getMessage(), "No hay clientes registrados", JOptionPane.INFORMATION_MESSAGE);
        }
    }
    
    private void init(){
        initComponents();
        
        listaClientes.setModel(funciones.initLista(main.getBarberia().getClientes()));
        listaClientes.setSelectedIndex(this.indice);
        

        funciones.setLogo(this);//colocar logo;
        this.setTitle("Eliminar cliente");//titulo ventana
       
        
    }
    
    private void cambiarLabels(int indice)// coloca los datos actuales del cliente excogido y limpia los campos de texto 
    {
        try{
        cliente = clientes.get(indice);
        labNombreActual.setText(cliente.getNombre());
        labCorreoActual.setText(cliente.getCorreo());
        labTelefonoActual.setText(cliente.getTelefono());
        listaClientes.setSelectedIndex(indice);
        }catch (IndexOutOfBoundsException e){
        
        }
        
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        labNombreActual = new javax.swing.JLabel();
        labCorreoActual = new javax.swing.JLabel();
        labTelefonoActual = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        listaClientes = new javax.swing.JList();
        Volver = new javax.swing.JButton();
        btnEliminar = new javax.swing.JButton();
        jLabel9 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setResizable(false);

        jLabel1.setText("Datos del cliente:");

        jLabel2.setText("Nombre: ");

        jLabel3.setText("Correo: ");

        jLabel4.setText("Telefono");

        labNombreActual.setText(".");

        labCorreoActual.setText(".");

        labTelefonoActual.setText(".");

        listaClientes.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        listaClientes.setSelectedIndex(0);
        listaClientes.setVerifyInputWhenFocusTarget(false);
        listaClientes.addListSelectionListener(new javax.swing.event.ListSelectionListener() {
            public void valueChanged(javax.swing.event.ListSelectionEvent evt) {
                listaClientesValueChanged(evt);
            }
        });
        jScrollPane1.setViewportView(listaClientes);

        Volver.setText("Cancelar");
        Volver.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                VolverActionPerformed(evt);
            }
        });

        btnEliminar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/delete-icon.png"))); // NOI18N
        btnEliminar.setNextFocusableComponent(Volver);
        btnEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarActionPerformed(evt);
            }
        });

        jLabel9.setText("Lista de clientes registrados");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addGap(23, 23, 23)
                        .addComponent(btnEliminar)
                        .addGap(18, 18, 18)
                        .addComponent(Volver))
                    .addComponent(jLabel9, javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel4, javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(jLabel3))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addComponent(labNombreActual))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(20, 20, 20)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(labTelefonoActual)
                                    .addComponent(labCorreoActual)))))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 342, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(64, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(8, 8, 8)
                .addComponent(jLabel9)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(34, 34, 34)
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(labNombreActual))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(labCorreoActual))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(labTelefonoActual))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 15, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(Volver)
                    .addComponent(btnEliminar))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
    
    // <editor-fold defaultstate="collapsed" desc="eventos">
    private void listaClientesValueChanged(javax.swing.event.ListSelectionEvent evt) {//GEN-FIRST:event_listaClientesValueChanged
        if (listaClientes.getSelectedIndex() != -1){
            this.indice = listaClientes.getSelectedIndex();
        }
        if (listaClientes.getSelectedIndex()==clientes.size()){
            indice = clientes.size()-1;
        }
        cambiarLabels(this.indice);
    }//GEN-LAST:event_listaClientesValueChanged

    private void VolverActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_VolverActionPerformed
        this.dispose();
       
    }//GEN-LAST:event_VolverActionPerformed

    private void btnEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarActionPerformed
        
        
        try{
            clientes.remove(listaClientes.getSelectedIndex());
            listaClientes.setModel(funciones.initLista(clientes));
            this.indice=listaClientes.getSelectedIndex();
            cambiarLabels(this.indice);
        }catch (UnsupportedOperationException e){//ya no quedan clientes para eliminar
            javax.swing.DefaultListModel modelo = (javax.swing.DefaultListModel)listaClientes.getModel();
            modelo.removeAllElements();
            labCorreoActual.setText(null);
            labNombreActual.setText(null);
            labTelefonoActual.setText(null);
        }catch (RuntimeException e){
            JOptionPane.showMessageDialog(this,"Ya no hay ningún cliente","No hay clientes",JOptionPane.ERROR_MESSAGE);
            this.dispose();
        }
       
        
        
    }//GEN-LAST:event_btnEliminarActionPerformed
// </editor-fold> 
    
    // <editor-fold defaultstate="collapsed" desc="declaracion variables">
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Volver;
    private javax.swing.JButton btnEliminar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel labCorreoActual;
    private javax.swing.JLabel labNombreActual;
    private javax.swing.JLabel labTelefonoActual;
    private javax.swing.JList listaClientes;
    // End of variables declaration//GEN-END:variables
// </editor-fold> 
  
}
