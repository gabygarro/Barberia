/*
*
*ESTE FRAME IMPLEMENTA LAS FUNCIONALIDADES DE :
    -CONSULTAR CITA
    -ELIMINAR CITA
    -CONFIRMAR CITA
    -ENVIAR CORREO DE CONFIRMACIÓN (INDIVIDUAL)
    -REDIRECCIÓN A VENTANA DE MODIFICACIÓN DE CITA
*/

package GUI.citas;

import GUI.Main;
import GUI.citas.modificarCita.ModificarCita;
import GUI.funciones.funciones;
import barberia.Cita;
import barberia.Cliente;
import barberia.Servicio;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import javax.swing.DefaultListModel;
import javax.swing.JOptionPane;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;


/**
 *
 * @author Daniel
 */
public class AdministrarCitas extends javax.swing.JFrame {

    private Main main; 
    private ArrayList<Cliente> clientes;
    private ArrayList<Cita> citas;
    private DefaultTableModel modeloTabla;
    private DefaultListModel modeloListaServicios;
    private int indice;
    private Cita cita;
    public AdministrarCitas(Main main) {
        try{
        initComponents();
        this.main = main;
        this.clientes = main.getBarberia().getClientes();
        this.citas= main.getBarberia().getCitas();
        this.indice =0; 
        modeloListaServicios = new DefaultListModel();
        modeloTabla = new DefaultTableModel(){
            @Override
            public boolean isCellEditable(int row, int column) {
       
                return false;
            }
        };
        modeloTabla.addColumn("Fecha y hora");
        modeloTabla.addColumn("Cliente");
        initTabla();
        
        
        this.setTitle("Administrar citas");
        funciones.setLogo(this);
            System.out.println("hizo");
        this.setVisible(true);
        }catch (RuntimeException e){
            JOptionPane.showMessageDialog(this,e.getMessage(),"Error", JOptionPane.ERROR_MESSAGE);
        }
        
    }
    public void cambiarLabels(){
        try{
 
        labCliente.setText(cita.getCliente().getNombre() +" <"+cita.getCliente().getCorreo()+">");
        textDetalle.setText(cita.getDetalle());
        labMonto.setText(String.valueOf(cita.calcularMonto()));
        if (cita.estaConfirmada()){
            labConfirmacion.setText("Confirmada");
        }else{
            labConfirmacion.setText("Aún sin confirmar");
        }
        
        modeloListaServicios.removeAllElements();
        for (Servicio s: cita.getServicios()){
            modeloListaServicios.addElement(s.getNombre());
        }
        listaServicios.setModel(modeloListaServicios);
        }catch (ArrayIndexOutOfBoundsException e){
            JOptionPane.showMessageDialog(this,"Seleccione la cita que desea editar", "?", JOptionPane.WARNING_MESSAGE);
            
        }catch (NullPointerException exception){
            
        }
        
    }
    
    public void refrescar(){
        indice = tablaCitas.getSelectedRow();
        try{
            initTabla();
        }catch (IndexOutOfBoundsException e){//no hay una cita seleccionada
            
        }catch (RuntimeException ex){//se eliminaron todas las citas
            if (modeloTabla.getRowCount() > 0) {
                for (int i = modeloTabla.getRowCount() - 1; i > -1; i--) {
                    modeloTabla.removeRow(i);
                }
            }
            textDetalle.setText(null);
            labCliente.setText(null);
            labMonto.setText(null);
            modeloListaServicios.removeAllElements();
        }
        try{
        tablaCitas.setRowSelectionInterval(indice-1, indice-1);
        }catch (IllegalArgumentException exc){
            //
        }
        cambiarLabels();
    }
    
    private void initTabla(){
        if (citas.size()==0){
            System.out.println("no hay citas");
            throw new RuntimeException("No hay citas registradas en el sistema");
        }
        
        if (modeloTabla.getRowCount() > 0) {
            for (int i = modeloTabla.getRowCount() - 1; i > -1; i--) {
                modeloTabla.removeRow(i);
            }
        }
        tablaCitas.setModel(modeloTabla);

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");
        
        for (Cita cita : citas){
            modeloTabla.addRow(new Object[]{cita.getFecha().format(formatter), cita.getCliente().getNombre()});
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tablaCitas = new javax.swing.JTable();
        btnCerrar = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        labCliente = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        listaServicios = new javax.swing.JList();
        jLabel5 = new javax.swing.JLabel();
        labMonto = new javax.swing.JLabel();
        btnCancelar = new javax.swing.JButton();
        btnConfirmar = new javax.swing.JButton();
        btnEditarCita = new javax.swing.JButton();
        jScrollPane3 = new javax.swing.JScrollPane();
        textDetalle = new javax.swing.JTextArea();
        labConfirmacion = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setResizable(false);

        jLabel1.setText("Citas existentes");

        tablaCitas.getSelectionModel().addListSelectionListener(new ListSelectionListener(){
            public void valueChanged(ListSelectionEvent event) {
                System.out.println(tablaCitas.getSelectedRow());
            }
        });
        tablaCitas.setModel(new DefaultTableModel() {

            @Override
            public boolean isCellEditable(int row, int column) {
                //all cells false
                return false;
            }
        }
    );
    tablaCitas.addMouseListener(new java.awt.event.MouseAdapter() {
        public void mouseClicked(java.awt.event.MouseEvent evt) {
            tablaCitasMouseClicked(evt);
        }
    });
    jScrollPane1.setViewportView(tablaCitas);

    btnCerrar.setText("Cerrar");
    btnCerrar.addActionListener(new java.awt.event.ActionListener() {
        public void actionPerformed(java.awt.event.ActionEvent evt) {
            btnCerrarActionPerformed(evt);
        }
    });

    jLabel2.setText("Cliente:");

    jLabel3.setText("Detalle:");

    jLabel4.setText("Servicios:");

    labCliente.setText("..");

    listaServicios.setFocusable(false);
    listaServicios.setRequestFocusEnabled(false);
    jScrollPane2.setViewportView(listaServicios);

    jLabel5.setText("Monto: ");

    labMonto.setText("..");

    btnCancelar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/dialog_cancel.png"))); // NOI18N
    btnCancelar.setToolTipText("Cancelar cita");
    btnCancelar.addActionListener(new java.awt.event.ActionListener() {
        public void actionPerformed(java.awt.event.ActionEvent evt) {
            eliminar(evt);
        }
    });

    btnConfirmar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/confirmar-icon.png"))); // NOI18N
    btnConfirmar.setToolTipText("Confirmar cita");
    btnConfirmar.addActionListener(new java.awt.event.ActionListener() {
        public void actionPerformed(java.awt.event.ActionEvent evt) {
            btnConfirmarActionPerformed(evt);
        }
    });

    btnEditarCita.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pencil.png"))); // NOI18N
    btnEditarCita.setToolTipText("Modificar datos de cita seleccionada");
    btnEditarCita.addActionListener(new java.awt.event.ActionListener() {
        public void actionPerformed(java.awt.event.ActionEvent evt) {
            btnEditarCitaActionPerformed(evt);
        }
    });

    textDetalle.setColumns(20);
    textDetalle.setRows(5);
    textDetalle.setEnabled(false);
    textDetalle.setFocusable(false);
    jScrollPane3.setViewportView(textDetalle);

    labConfirmacion.setText(":::");

    javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
    getContentPane().setLayout(layout);
    layout.setHorizontalGroup(
        layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addGroup(layout.createSequentialGroup()
            .addContainerGap()
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addComponent(jLabel1)
                    .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGroup(layout.createSequentialGroup()
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                            .addComponent(btnCerrar)
                            .addGap(88, 88, 88))
                        .addGroup(layout.createSequentialGroup()
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 375, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(jLabel2)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(labCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 240, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addComponent(jLabel4)
                                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(btnConfirmar)
                        .addComponent(btnCancelar)
                        .addComponent(btnEditarCita)))
                .addGroup(layout.createSequentialGroup()
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(jLabel5)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(labMonto, javax.swing.GroupLayout.PREFERRED_SIZE, 278, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 308, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel3)
                        .addComponent(labConfirmacion))
                    .addGap(0, 0, Short.MAX_VALUE))))
    );
    layout.setVerticalGroup(
        layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addGroup(layout.createSequentialGroup()
            .addContainerGap()
            .addComponent(jLabel1)
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 156, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(layout.createSequentialGroup()
                    .addGap(34, 34, 34)
                    .addComponent(btnConfirmar)
                    .addGap(11, 11, 11)
                    .addComponent(btnCancelar)
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                    .addComponent(btnEditarCita)))
            .addGap(18, 18, 18)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                .addComponent(jLabel2)
                .addComponent(labCliente))
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
            .addComponent(labConfirmacion)
            .addGap(15, 15, 15)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                .addComponent(jLabel5)
                .addComponent(labMonto))
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
            .addComponent(jLabel3)
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
            .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addGap(18, 18, 18)
            .addComponent(jLabel4)
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
            .addComponent(btnCerrar)
            .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
    );

    pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnCerrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCerrarActionPerformed
        this.dispose();
    }//GEN-LAST:event_btnCerrarActionPerformed

    private void btnEditarCitaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditarCitaActionPerformed
        try{
        new ModificarCita(main, citas.get(tablaCitas.getSelectedRow()),this);
        }catch(IndexOutOfBoundsException e){
            JOptionPane.showMessageDialog(this, "Seleccione una cita", "No hay cita", JOptionPane.WARNING_MESSAGE);
        }
    }//GEN-LAST:event_btnEditarCitaActionPerformed

    private void tablaCitasMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tablaCitasMouseClicked
        
        try{
            this.cita = citas.get(tablaCitas.getSelectedRow());
            cambiarLabels();
        }catch (IndexOutOfBoundsException e){
            
        }
        
    }//GEN-LAST:event_tablaCitasMouseClicked

    private void btnConfirmarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnConfirmarActionPerformed
        try {
            cita.confirmar();
            cambiarLabels();
        }catch(Exception e){
            JOptionPane.showMessageDialog(this, "Seleccione una cita", "No hay cita", JOptionPane.WARNING_MESSAGE);
        }
    }//GEN-LAST:event_btnConfirmarActionPerformed

    private void eliminar(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_eliminar
        try{
           int indice = tablaCitas.getSelectedRow();
           citas.remove(indice);
           refrescar();
        }catch (IndexOutOfBoundsException e){
            listaServicios.setSelectedIndex(listaServicios.getMaxSelectionIndex());

        }
    }//GEN-LAST:event_eliminar

 

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCancelar;
    private javax.swing.JButton btnCerrar;
    private javax.swing.JButton btnConfirmar;
    private javax.swing.JButton btnEditarCita;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JLabel labCliente;
    private javax.swing.JLabel labConfirmacion;
    private javax.swing.JLabel labMonto;
    private javax.swing.JList listaServicios;
    private javax.swing.JTable tablaCitas;
    private javax.swing.JTextArea textDetalle;
    // End of variables declaration//GEN-END:variables
}
