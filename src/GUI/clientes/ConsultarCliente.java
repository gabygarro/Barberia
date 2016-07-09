
package GUI.clientes;

import GUI.Main;
import GUI.funciones.funciones;
import barberia.Cliente;
import javax.swing.JOptionPane;



public class ConsultarCliente extends javax.swing.JFrame  {

    Main main; 
    Cliente cliente;
    
    public ConsultarCliente(Main main) {
        try{
        this.main = main;
      
        this.cliente = null;
        init();
        this.setLocation(800,400);
       
        this.setVisible(true);} catch (ArrayIndexOutOfBoundsException e){
        } catch (UnsupportedOperationException e){
            JOptionPane.showMessageDialog(this, e.getMessage(), "No hay clientes registrados", JOptionPane.ERROR_MESSAGE);
        }
    }
    
    private void init(){
        initComponents(); 
        listaClientes.setModel(funciones.initLista(main.getBarberia().getClientes()));
        listaClientes.setSelectedIndex(0);
        funciones.setLogo(this);//colocar logo;
        this.setTitle("Consultar datos");//titulo ventana
        cambiarLabels(); 
        
        
         
        
    }
    
    private void cambiarLabels()// coloca los datos actuales del cliente excogido y limpia los campos de texto 
    {
        this.cliente = main.getBarberia().getClientes().get(listaClientes.getSelectedIndex());
        labNombreActual.setText(cliente.getNombre());
        labCorreoActual.setText(cliente.getCorreo());
        labTelefonoActual.setText(cliente.getTelefono());
        
      
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
        btnVolver = new javax.swing.JButton();
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

        btnVolver.setText("Cerrar");
        btnVolver.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                voler(evt);
            }
        });

        jLabel9.setText("Lista de clientes registrados");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 277, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel9)
                    .addComponent(jLabel1)
                    .addComponent(jLabel4)
                    .addGroup(layout.createSequentialGroup()
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
                    .addGroup(layout.createSequentialGroup()
                        .addGap(105, 105, 105)
                        .addComponent(btnVolver)))
                .addContainerGap(19, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel9)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
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
                .addGap(18, 18, 18)
                .addComponent(btnVolver)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
    
    // <editor-fold defaultstate="collapsed" desc="eventos">
    private void listaClientesValueChanged(javax.swing.event.ListSelectionEvent evt) {//GEN-FIRST:event_listaClientesValueChanged
        cambiarLabels();
    }//GEN-LAST:event_listaClientesValueChanged

    private void voler(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_voler
        this.dispose();
        
    }//GEN-LAST:event_voler
// </editor-fold> 
    
    // <editor-fold defaultstate="collapsed" desc="declaracion variables">
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnVolver;
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
