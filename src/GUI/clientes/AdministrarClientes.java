
package GUI.clientes;

import Exceptions.ExistingAppointmentException;
import Exceptions.InvalidEmailException;
import Exceptions.InvalidNameException;
import Exceptions.InvalidPhoneException;
import GUI.Main;
import GUI.funciones.funciones;
import barberia.Cita;
import barberia.Cliente;
import java.time.LocalDateTime;
import java.time.chrono.ChronoLocalDateTime;
import javax.swing.DefaultListModel;
import javax.swing.JFrame;
import javax.swing.JOptionPane;



public class AdministrarClientes extends javax.swing.JFrame  {

    Main main; 
   
    java.util.ArrayList<Cliente> clientes;
    Cliente cliente;
    int indiceSeleccionado;
    
    public AdministrarClientes(Main main) {
        try{
        this.main = main;
        
        this.cliente = null;
        this.clientes = main.getBarberia().getClientes();
        init();
        this.setLocation(300, 300);
        this.setVisible(true);
        
        } catch (ArrayIndexOutOfBoundsException e){ //no hace nada
        } catch (UnsupportedOperationException e){
            JOptionPane.showMessageDialog(this, e.getMessage(), "No hay clientes registrados", JOptionPane.INFORMATION_MESSAGE);
        }
    }
    
    private void init(){
            initComponents();
            indiceSeleccionado = 0;
            listaClientes.setModel(funciones.initLista(clientes));
            listaClientes.setSelectedIndex(indiceSeleccionado);
        
       
            funciones.setLogo(this);//colocar logo;
            this.setTitle("Modificar datos de clientes");//titulo ventana

            cambiarLabels(); 
            textNuevoTelefono.addActionListener(new java.awt.event.ActionListener(){
                    public void actionPerformed(java.awt.event.ActionEvent e){
                        btnGuardarActionPerformed(e);
                    }});
            textNuevoCorreo.addActionListener(new java.awt.event.ActionListener(){
                    public void actionPerformed(java.awt.event.ActionEvent e){
                        btnGuardarActionPerformed(e);
                    }});
            textNuevoNombre.addActionListener(new java.awt.event.ActionListener(){
                    public void actionPerformed(java.awt.event.ActionEvent e){
                        btnGuardarActionPerformed(e);
                    }});
        
       
        
    }
    
    private void cambiarLabels()// coloca los datos actuales del cliente excogido y limpia los campos de texto 
    {
        labNombreActual.setText(cliente.getNombre());
        labCorreoActual.setText(cliente.getCorreo());
        labTelefonoActual.setText(cliente.getTelefono());
        labNuevosDatosCliente.setText("Nuevos datos para " + cliente.getNombre() + ":");
    }
    private void setEspaciosTexto(String nombre, String telefono, String correo){
        textNuevoNombre.setText(nombre);
        textNuevoCorreo.setText(correo);
        textNuevoTelefono.setText(telefono);   
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
        labNuevoNombre = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        textNuevoNombre = new javax.swing.JTextField();
        textNuevoCorreo = new javax.swing.JTextField();
        textNuevoTelefono = new javax.swing.JTextField();
        labNuevosDatosCliente = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        listaClientes = new javax.swing.JList();
        btnVolver = new javax.swing.JButton();
        btnGuardar = new javax.swing.JButton();
        jLabel9 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        jLabel5 = new javax.swing.JLabel();
        btnEliminar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setResizable(false);

        jLabel1.setText("Datos del cliente:");

        jLabel2.setText("Nombre: ");

        jLabel3.setText("Correo: ");

        jLabel4.setText("Telefono");

        labNombreActual.setText(".");

        labCorreoActual.setText(".");

        labTelefonoActual.setText(".");

        labNuevoNombre.setText("Nuevo nombre: ");

        jLabel6.setText("Nuevo correo: ");

        jLabel7.setText("Nuevo telefono: ");

        textNuevoNombre.setToolTipText("Enter para guardar");
        textNuevoNombre.setNextFocusableComponent(textNuevoCorreo);
        textNuevoNombre.setRequestFocusEnabled(false);
        textNuevoNombre.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseDragged(java.awt.event.MouseEvent evt) {
                textNuevoNombreMouseDragged(evt);
            }
        });
        textNuevoNombre.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                textNuevoNombreMouseClicked(evt);
            }
        });

        textNuevoCorreo.setToolTipText("Enter para guardar");
        textNuevoCorreo.setNextFocusableComponent(textNuevoTelefono);
        textNuevoCorreo.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseDragged(java.awt.event.MouseEvent evt) {
                textNuevoCorreoMouseDragged(evt);
            }
        });
        textNuevoCorreo.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                textNuevoCorreoMouseClicked(evt);
            }
        });

        textNuevoTelefono.setToolTipText("Enter para guardar");
        textNuevoTelefono.setNextFocusableComponent(btnGuardar);
        textNuevoTelefono.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseDragged(java.awt.event.MouseEvent evt) {
                textNuevoTelefonoMouseDragged(evt);
            }
        });
        textNuevoTelefono.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                textNuevoTelefonoActionPerformed(evt);
            }
        });

        labNuevosDatosCliente.setText(":");

        listaClientes.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        listaClientes.setSelectedIndex(0);
        listaClientes.setVerifyInputWhenFocusTarget(false);
        listaClientes.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                listaClientesMouseClicked(evt);
            }
        });
        listaClientes.addListSelectionListener(new javax.swing.event.ListSelectionListener() {
            public void valueChanged(javax.swing.event.ListSelectionEvent evt) {
                listaClientesValueChanged(evt);
            }
        });
        jScrollPane1.setViewportView(listaClientes);

        btnVolver.setText("Volver");
        btnVolver.setToolTipText("Volver al menú anterior");
        btnVolver.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVolverActionPerformed(evt);
            }
        });

        btnGuardar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/save-icon.png"))); // NOI18N
        btnGuardar.setToolTipText("Guardar nuevos datos");
        btnGuardar.setNextFocusableComponent(btnVolver);
        btnGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGuardarActionPerformed(evt);
            }
        });

        jLabel9.setText("Lista de clientes registrados");

        jLabel5.setForeground(new java.awt.Color(102, 102, 102));
        jLabel5.setText("(Deje los espacios en blanco para conservar los valores actuales)");

        btnEliminar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/delete-icon.png"))); // NOI18N
        btnEliminar.setToolTipText("Eliminar cliente seleccionado");
        btnEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jSeparator1)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                    .addComponent(labNuevoNombre)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(textNuevoNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 247, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                    .addComponent(jLabel6)
                                    .addGap(27, 27, 27)
                                    .addComponent(textNuevoCorreo, javax.swing.GroupLayout.PREFERRED_SIZE, 247, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 277, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(42, 42, 42)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
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
                                    .addComponent(btnEliminar)))
                            .addComponent(jLabel9)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel7)
                                .addGap(18, 18, 18)
                                .addComponent(textNuevoTelefono, javax.swing.GroupLayout.PREFERRED_SIZE, 247, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(122, 122, 122)
                                .addComponent(btnGuardar, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(btnVolver))
                            .addComponent(labNuevosDatosCliente)
                            .addComponent(jLabel5))
                        .addGap(0, 63, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jLabel9)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
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
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnEliminar))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(27, 27, 27)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(2, 2, 2)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(labNuevosDatosCliente)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel5)
                        .addGap(11, 11, 11)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(labNuevoNombre)
                            .addComponent(textNuevoNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(23, 23, 23)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel6)
                            .addComponent(textNuevoCorreo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(23, 23, 23)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel7)
                            .addComponent(textNuevoTelefono, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnVolver, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(btnGuardar)))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
    
    // <editor-fold defaultstate="collapsed" desc="eventos">
    private void listaClientesValueChanged(javax.swing.event.ListSelectionEvent evt) {//GEN-FIRST:event_listaClientesValueChanged
        if (listaClientes.getSelectedIndex()== -1){
            try{
            this.cliente = main.getBarberia().getClientes().get(indiceSeleccionado);
            }catch (IndexOutOfBoundsException e){}
        }else{
            indiceSeleccionado=listaClientes.getSelectedIndex();
            this.cliente = main.getBarberia().getClientes().get(indiceSeleccionado);
        }
        cambiarLabels();
        listaClientes.setSelectedIndex(indiceSeleccionado);
        
        setEspaciosTexto(null, null, null);
    }//GEN-LAST:event_listaClientesValueChanged

    
    private void textNuevoNombreMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_textNuevoNombreMouseClicked
        textNuevoNombre.requestFocus();
    }//GEN-LAST:event_textNuevoNombreMouseClicked

    private void textNuevoCorreoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_textNuevoCorreoMouseClicked
        textNuevoCorreo.requestFocus();
    }//GEN-LAST:event_textNuevoCorreoMouseClicked

    private void textNuevoTelefonoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_textNuevoTelefonoActionPerformed
        textNuevoTelefono.requestFocus();
    }//GEN-LAST:event_textNuevoTelefonoActionPerformed

    private void listaClientesMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_listaClientesMouseClicked
        listaClientes.requestFocus();
    }//GEN-LAST:event_listaClientesMouseClicked

    private void btnVolverActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVolverActionPerformed
        if(!(textNuevoCorreo.getText().isEmpty()) && !(textNuevoCorreo.getText().equals(cliente.getCorreo()))){
            salirSinGuardar();
        } else if (!(textNuevoNombre.getText().isEmpty())&&!(textNuevoNombre.getText().equals(cliente.getNombre())))
        {salirSinGuardar();
        } else if (!(textNuevoTelefono.getText().isEmpty())&&!(textNuevoTelefono.getText().equals(cliente.getTelefono())))
        {salirSinGuardar();
        } else {
            volver();
        }        
    }//GEN-LAST:event_btnVolverActionPerformed
    
    private void salirSinGuardar(){
        if( JOptionPane.showConfirmDialog(this, "Si sale, se perderán "
                        + "los nuevos datos que no haya guardado"
                        + "\n¿Desea salir de todos modos?", 
                        "Salir sin guardar", JOptionPane.YES_NO_OPTION) == 0)
        {
            volver();
        }             
    }
    public void volver(){
        this.dispose();
    }
    private void textNuevoNombreMouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_textNuevoNombreMouseDragged
        textNuevoNombre.requestFocus();
    }//GEN-LAST:event_textNuevoNombreMouseDragged

    private void textNuevoCorreoMouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_textNuevoCorreoMouseDragged
        textNuevoCorreo.requestFocus();
    }//GEN-LAST:event_textNuevoCorreoMouseDragged

    private void textNuevoTelefonoMouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_textNuevoTelefonoMouseDragged
        textNuevoTelefono.requestFocus();
    }//GEN-LAST:event_textNuevoTelefonoMouseDragged

    private void btnGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarActionPerformed
        String nombre=null;
        String correo=null;
        String telefono=null;
        if (!textNuevoNombre.getText().isEmpty()){
            cliente.setNombre(textNuevoNombre.getText());
            nombre=textNuevoNombre.getText();
        }
        if (!textNuevoCorreo.getText().isEmpty()){
            try{
                cliente.setCorreo(textNuevoCorreo.getText());
                correo = textNuevoCorreo.getText();
            }catch(InvalidEmailException e){
                JOptionPane.showMessageDialog(this, e.getMessage(), "Correo inválido", JOptionPane.ERROR_MESSAGE);
            }
        }
        if (!textNuevoTelefono.getText().isEmpty()){
            try{
                cliente.setTelefono(textNuevoTelefono.getText());
                telefono = textNuevoTelefono.getText();
            }catch(InvalidPhoneException e){
                JOptionPane.showMessageDialog(this, e.getMessage(), "Correo inválido", JOptionPane.ERROR_MESSAGE);
            }

        }
        indiceSeleccionado =listaClientes.getSelectedIndex();
        listaClientes.setModel(funciones.initLista(clientes));//vuelve a crear la lista con los valores modificados
        setEspaciosTexto(nombre, telefono, correo);
    }//GEN-LAST:event_btnGuardarActionPerformed

   
    private void btnEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarActionPerformed
        new EliminarCliente(main);
    }//GEN-LAST:event_btnEliminarActionPerformed
// </editor-fold> //manejar eventos (clic en botobes, enters..)
    
    // <editor-fold defaultstate="collapsed" desc="declaracion variables">
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnEliminar;
    private javax.swing.JButton btnGuardar;
    private javax.swing.JButton btnVolver;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JLabel labCorreoActual;
    private javax.swing.JLabel labNombreActual;
    private javax.swing.JLabel labNuevoNombre;
    private javax.swing.JLabel labNuevosDatosCliente;
    private javax.swing.JLabel labTelefonoActual;
    private javax.swing.JList listaClientes;
    private javax.swing.JTextField textNuevoCorreo;
    private javax.swing.JTextField textNuevoNombre;
    private javax.swing.JTextField textNuevoTelefono;
    // End of variables declaration//GEN-END:variables
// </editor-fold> 
  
}
