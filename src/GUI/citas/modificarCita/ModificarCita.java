/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package GUI.citas.modificarCita;

import GUI.Main;
import static GUI.Main.main;
import GUI.citas.AdministrarCitas;
import GUI.funciones.funciones;
import barberia.Barberia;
import barberia.Cita;
import barberia.Cliente;
import barberia.HorarioAtencion;
import barberia.Servicio;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import javax.swing.DefaultListModel;
import javax.swing.JDialog;


public class ModificarCita extends javax.swing.JFrame {

    private Cita cita;
    private Barberia barberia;
    private ArrayList<Cita> citas;
    private ArrayList<Cliente> clientes;
    private HorarioAtencion horarioAtencion;
    private AdministrarCitas administrarCitas;
    private Main main;
    
    public ModificarCita(Main main, Cita cita, AdministrarCitas administrarCitas) {
        this.main = main;
        this.barberia = main.getBarberia();
        this.cita = cita;
        
        this.clientes = this.barberia.getClientes();
        this.citas = this.barberia.getCitas();
        this.horarioAtencion = this.barberia.getHorarioAtencion();
        this.administrarCitas = administrarCitas;
        funciones.setLogo(this);
        this.setTitle("Modificar cita");
        
        initComponents();
        refrescar();
        administrarCitas.cambiarLabels();
        
        this.setVisible(true);
    }

    public void refrescar(){
        labDetalle.setText(cita.getDetalle());
        labCliente.setText(cita.getCliente().getNombre());
        DateTimeFormatter df = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");
        labHoraFecha.setText(cita.getFecha().format(df));
        DefaultListModel modeloListaServicios = new DefaultListModel();
        for (Servicio s : cita.getServicios()){
            modeloListaServicios.addElement(s.getNombre());
        }
        listaServicios.setModel(modeloListaServicios);
        administrarCitas.refrescar();
        
    }
            
   
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        listaServicios = new javax.swing.JList();
        btnHoraFecha = new javax.swing.JButton();
        btnCliente = new javax.swing.JButton();
        btnServicios = new javax.swing.JButton();
        btnDetalle = new javax.swing.JButton();
        labCliente = new javax.swing.JLabel();
        labHoraFecha = new javax.swing.JLabel();
        labDetalle = new javax.swing.JLabel();
        btnGuardar = new javax.swing.JButton();
        labMonto = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setResizable(false);

        jLabel1.setText("Datos actuales de la cita: ");

        jScrollPane1.setViewportView(listaServicios);

        btnHoraFecha.setIcon(new javax.swing.ImageIcon(getClass().getResource("/calendar_icon.png"))); // NOI18N
        btnHoraFecha.setText("Elegir Hora y fecha");
        btnHoraFecha.setToolTipText("Clic para modificar");
        btnHoraFecha.setBorderPainted(false);
        btnHoraFecha.setContentAreaFilled(false);
        btnHoraFecha.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnHoraFechaActionPerformed(evt);
            }
        });

        btnCliente.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Person.png"))); // NOI18N
        btnCliente.setText("Elegir cliente");
        btnCliente.setToolTipText("Clic para modificar");
        btnCliente.setContentAreaFilled(false);
        btnCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnClienteActionPerformed(evt);
            }
        });

        btnServicios.setIcon(new javax.swing.ImageIcon(getClass().getResource("/services.png"))); // NOI18N
        btnServicios.setText("Elegir servicios");
        btnServicios.setToolTipText("Clic para agregar/quitar");
        btnServicios.setContentAreaFilled(false);
        btnServicios.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnServiciosActionPerformed(evt);
            }
        });

        btnDetalle.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon_info.png"))); // NOI18N
        btnDetalle.setText("Editar detalle");
        btnDetalle.setToolTipText("Clic para agregar/quitar");
        btnDetalle.setContentAreaFilled(false);
        btnDetalle.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDetalleActionPerformed(evt);
            }
        });

        labCliente.setText(":");

        labHoraFecha.setText(":");

        labDetalle.setText(":");

        btnGuardar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/confirmar-icon.png"))); // NOI18N
        btnGuardar.setText("Cerrar");
        btnGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGuardarActionPerformed(evt);
            }
        });

        labMonto.setText(":");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 268, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 14, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnCliente)
                            .addComponent(btnHoraFecha)
                            .addComponent(btnDetalle)
                            .addComponent(btnServicios)))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(23, 23, 23)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(labDetalle, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(labCliente)
                                    .addComponent(labHoraFecha, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel1)))
                            .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(labMonto))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(165, 165, 165)
                                .addComponent(btnGuardar)))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnCliente)
                        .addGap(7, 7, 7)
                        .addComponent(btnHoraFecha)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnDetalle)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnServicios)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(labCliente)
                        .addGap(18, 18, 18)
                        .addComponent(labHoraFecha)
                        .addGap(18, 18, 18)
                        .addComponent(labDetalle)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(labMonto)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnGuardar)
                        .addContainerGap())))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
    public Main getMain(){
        return main;
    }
    private void btnHoraFechaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnHoraFechaActionPerformed
        
        new SeleccionarHoraFecha(this);
    }//GEN-LAST:event_btnHoraFechaActionPerformed

    private void btnClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnClienteActionPerformed
       new SeleccionarCliente(main, this);
    }//GEN-LAST:event_btnClienteActionPerformed

    private void btnServiciosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnServiciosActionPerformed
        new SeleccionarServicios(barberia.getServicios(), this);
    }//GEN-LAST:event_btnServiciosActionPerformed

    private void btnDetalleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDetalleActionPerformed
        new AgregarDetalle(this);
    }//GEN-LAST:event_btnDetalleActionPerformed

    private void btnGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarActionPerformed
        this.dispose();
    }//GEN-LAST:event_btnGuardarActionPerformed

    public Cita getCita(){
        return this.cita;
    }
 

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCliente;
    private javax.swing.JButton btnDetalle;
    private javax.swing.JButton btnGuardar;
    private javax.swing.JButton btnHoraFecha;
    private javax.swing.JButton btnServicios;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel labCliente;
    private javax.swing.JLabel labDetalle;
    private javax.swing.JLabel labHoraFecha;
    private javax.swing.JLabel labMonto;
    private javax.swing.JList listaServicios;
    // End of variables declaration//GEN-END:variables
}
