/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI.citas;

import Exceptions.BusyHourException;
import Exceptions.CreatedAppointmentThrowable;
import Exceptions.DateOutOfScheduleException;
import Exceptions.NoDateForAppointmentException;
import GUI.Main;
import GUI.funciones.funciones;
import barberia.*;


import java.util.ArrayList;
import java.util.Calendar;
import javax.swing.DefaultComboBoxModel;
import javax.swing.DefaultListModel;
import javax.swing.JOptionPane;


public class CrearCita extends javax.swing.JFrame {

    private ArrayList<Cliente> clientes;
    private Cliente cliente;
    private Main main;
    private int hora;
    private ArrayList<Servicio> serviciosCita;
    private DefaultListModel modeloLista;
    private double monto;

    @SuppressWarnings("empty-statement")
    public CrearCita(Main main) {
        try {
            this.main = main;
            clientes = main.getBarberia().getClientes();
            modeloLista = new DefaultListModel();
            this.serviciosCita = new ArrayList<>();
            
            this.monto = 0;
            if (clientes.size() == 0) {
                throw new RuntimeException("No hay clientes");
            }
            if (main.getBarberia().getServicios().size()==0){
                throw new RuntimeException("No hay servicios creados");
            }
            
            funciones.setLogo(this);

            initComponents();
            initCombo();
            initServ();
            labHorario.setText(main.getBarberia().getHorarioAtencion().toString());
            this.setVisible(true);

        } catch (RuntimeException e) {
            System.out.println("es acá");
            JOptionPane.showMessageDialog(this, e.getMessage(), "No hay clientes", JOptionPane.ERROR_MESSAGE);
        }

    }

    // <editor-fold defaultstate="collapsed" desc="inicializadores de componentes">
    private void initCombo() {
        try {
            DefaultComboBoxModel modelo = new DefaultComboBoxModel();
            int i = 0;
            for (Cliente c : clientes) {
                modelo.addElement(++i + ". " + c.getNombre());
            }
            cbClientes.setModel(modelo);
            labCorreoCliente.setText(clientes.get(0).getCorreo());
            labTelefonoCliente.setText(clientes.get(0).getTelefono());
        } catch (IndexOutOfBoundsException e) {

        }

        

    }

    ;
    
    private void initServ() {
        try {
            DefaultComboBoxModel modelo = new DefaultComboBoxModel();
            int i = 0;

            for (Servicio s : main.getBarberia().getServicios()) {
                modelo.addElement(++i + ". " + s.getNombre());
            }
            cbServicios.setModel(modelo);
            cbServicios.setSelectedIndex(0);
            Servicio servicio = main.getBarberia().getServicios().get(cbServicios.getSelectedIndex());
            labDescripcionServicio.setText(servicio.getDescripcion());
            labPrecioServicio.setText(String.valueOf(servicio.getPrecio()));
        } catch (IndexOutOfBoundsException e) {

        }
        

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        labSelecCliente = new javax.swing.JLabel();
        labSelecFecha = new javax.swing.JLabel();
        bCrearCita = new javax.swing.JButton();
        cbClientes = new javax.swing.JComboBox();
        DateChooser = new com.toedter.calendar.JDateChooser();
        jScrollPane1 = new javax.swing.JScrollPane();
        listaServicios = new javax.swing.JList();
        labcbServicios = new javax.swing.JLabel();
        cbServicios = new javax.swing.JComboBox();
        labListaServicios = new javax.swing.JLabel();
        btnQuitar = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        labCorreoCliente = new javax.swing.JLabel();
        labTelefonoCliente = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        cb_am_pm = new javax.swing.JComboBox();
        cbHora = new javax.swing.JComboBox();
        jLabel5 = new javax.swing.JLabel();
        labListaServicios1 = new javax.swing.JLabel();
        labMonto = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        labDescripcionServicio = new javax.swing.JLabel();
        labPrecioServicio = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        textDetalle = new javax.swing.JTextArea();
        jSeparator1 = new javax.swing.JSeparator();
        btnAgregarServicio = new javax.swing.JButton();
        labHorario = new javax.swing.JLabel();
        labHorario1 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setResizable(false);

        labSelecCliente.setText("Seleccione un cliente");

        labSelecFecha.setText("Seleccione una fecha para la cita");

        bCrearCita.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        bCrearCita.setText("Crear Cita");
        bCrearCita.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bCrearCitaActionPerformed(evt);
            }
        });

        cbClientes.setName("clientes registrados"); // NOI18N
        cbClientes.setNextFocusableComponent(DateChooser);
        cbClientes.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cbClientesItemStateChanged(evt);
            }
        });

        listaServicios.setModel(modeloLista);
        jScrollPane1.setViewportView(listaServicios);

        labcbServicios.setText("Seleccione uno o más servicios para la cita");

        labListaServicios.setText("Servicios agregados a esta cita:");

        btnQuitar.setText("Quitar");
        btnQuitar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                quitar(evt);
            }
        });

        jLabel1.setText("Seleccione una hora (formato 24h):");

        jLabel2.setText("Correo: ");

        jLabel3.setText("Telefono: ");

        labCorreoCliente.setText(".");

        labTelefonoCliente.setText(".");

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel4.setText(":00");

        cb_am_pm.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "am", "pm" }));
        cb_am_pm.setName("clientes registrados"); // NOI18N
        cb_am_pm.setNextFocusableComponent(DateChooser);
        cb_am_pm.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cb_am_pmItemStateChanged(evt);
            }
        });

        cbHora.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12" }));
        cbHora.setName("clientes registrados"); // NOI18N
        cbHora.setNextFocusableComponent(DateChooser);
        cbHora.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cbHoraItemStateChanged(evt);
            }
        });

        jLabel5.setText("Detalles del servicio:");

        labListaServicios1.setText("Monto:");

        labMonto.setText("0");

        jLabel7.setText("Precio:");

        jLabel8.setText("Descripción:");

        labDescripcionServicio.setText("//");

        labPrecioServicio.setText("//");

        textDetalle.setColumns(20);
        textDetalle.setLineWrap(true);
        textDetalle.setRows(5);
        textDetalle.setAutoscrolls(false);
        jScrollPane2.setViewportView(textDetalle);

        btnAgregarServicio.setText("Agregar este servicio");
        btnAgregarServicio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgregarServicioActionPerformed(evt);
            }
        });

        labHorario.setForeground(new java.awt.Color(153, 153, 153));
        labHorario.setText(".");

        labHorario1.setForeground(new java.awt.Color(153, 153, 153));
        labHorario1.setText("Horario actual:");

        jLabel6.setText("Detalle (información extra) :");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jSeparator1)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(cbClientes, javax.swing.GroupLayout.PREFERRED_SIZE, 221, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel2)
                                .addGap(18, 18, 18)
                                .addComponent(labCorreoCliente))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel3)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(labTelefonoCliente))
                            .addComponent(labSelecCliente))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 6, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(labHorario, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(labHorario1))
                        .addGap(57, 57, 57)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(33, 33, 33)
                                .addComponent(cbHora, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel4)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(cb_am_pm, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(labSelecFecha)
                            .addComponent(DateChooser, javax.swing.GroupLayout.PREFERRED_SIZE, 147, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel1))
                        .addGap(21, 21, 21))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(cbServicios, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addContainerGap())
                    .addGroup(layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(bCrearCita))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(labcbServicios)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 222, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(btnQuitar, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(labListaServicios1)
                                    .addComponent(labMonto, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addComponent(labListaServicios)
                            .addComponent(jLabel5)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel7)
                                .addGap(18, 18, 18)
                                .addComponent(labPrecioServicio, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(btnAgregarServicio))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel6))
                        .addGap(17, 17, 17))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(10, 10, 10)
                                .addComponent(labDescripcionServicio))
                            .addComponent(jLabel8))
                        .addGap(0, 0, Short.MAX_VALUE))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labSelecCliente)
                    .addComponent(labSelecFecha)
                    .addComponent(labHorario1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(cbClientes, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(DateChooser, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel2)
                                .addComponent(labCorreoCliente)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(labTelefonoCliente)
                            .addComponent(jLabel4)
                            .addComponent(cb_am_pm, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cbHora, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(labHorario))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(1, 1, 1)
                .addComponent(labcbServicios)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(cbServicios, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel7)
                            .addComponent(labPrecioServicio))
                        .addGap(18, 18, 18)
                        .addComponent(jLabel8)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(labDescripcionServicio)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 42, Short.MAX_VALUE)
                        .addComponent(btnAgregarServicio)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(labListaServicios)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(labListaServicios1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(labMonto)
                                .addGap(18, 18, 18)
                                .addComponent(btnQuitar, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jLabel6)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addComponent(bCrearCita))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
// </editor-fold>

    // <editor-fold defaultstate="collapsed" desc="eventos">
    private void cbClientesItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cbClientesItemStateChanged
        this.cliente = clientes.get(cbClientes.getSelectedIndex());
        labCorreoCliente.setText(clientes.get(cbClientes.getSelectedIndex()).getCorreo());
        labTelefonoCliente.setText(clientes.get(cbClientes.getSelectedIndex()).getTelefono());
    }//GEN-LAST:event_cbClientesItemStateChanged

    private Calendar capturarHoraFecha() throws NoDateForAppointmentException {
        capturarHora();
        Calendar calend = DateChooser.getCalendar();
        if (calend == null) {
            throw new NoDateForAppointmentException("Seleccione una fecha para la cita");
        }
        System.out.println("hora calend" + hora);
        calend.set(Calendar.HOUR_OF_DAY, hora);
        calend.set(Calendar.MINUTE, 0);

        return calend;
    }

    private void bCrearCitaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bCrearCitaActionPerformed
        try {
            cliente = clientes.get(cbClientes.getSelectedIndex());

            Calendar calend = capturarHoraFecha();
            //LocalDateTime d = LocalDateTime.of(f.get(Calendar.YEAR), f.get(Calendar.MONTH) + 1, f.get(Calendar.DAY_OF_MONTH), hora, 0);
            String det = textDetalle.getText();
            if (serviciosCita.isEmpty()) {
                throw new NullPointerException("Hay que agregar al menos UN servicio para crear la cita");
            }

            main.agregarCita(calend, cliente, serviciosCita, det);

        } catch (NullPointerException e) {//no se ha elegido ningún servicio
            JOptionPane.showMessageDialog(this, e.getMessage(), "No se puede crear la cita", JOptionPane.ERROR_MESSAGE);
        } catch (NoDateForAppointmentException e) {
            JOptionPane.showMessageDialog(this, e.getMessage(), "Fecha inválida", JOptionPane.ERROR_MESSAGE);
        } catch (BusyHourException e) {
            JOptionPane.showMessageDialog(this, e.getMessage(), "Espacio ocupado", JOptionPane.ERROR_MESSAGE);
        } catch (DateOutOfScheduleException e) {
            JOptionPane.showMessageDialog(this, e.getMessage(), "Horario inválido", JOptionPane.ERROR_MESSAGE);
        } catch (CreatedAppointmentThrowable t) {
            this.dispose();
            if (JOptionPane.showConfirmDialog(this, t.getMessage()
                    + "\n¿Desea crear otra?",
                    "Operación exitosa",
                    JOptionPane.YES_NO_OPTION) == 0) {
                new CrearCita(main);
            }
        }

    }//GEN-LAST:event_bCrearCitaActionPerformed

    private void capturarHora() {
        this.hora = cbHora.getSelectedIndex() + 1;
        if (cb_am_pm.getSelectedItem().equals("pm")) {
            this.hora += 12;
            if (this.hora == 24) {
                this.hora = 12;
            }
        } else if (hora == 12) {
            this.hora = 0;
        }

        //System.out.println("hora capturada"+ this.hora);
    }

    private void cb_am_pmItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cb_am_pmItemStateChanged
        capturarHora();
    }//GEN-LAST:event_cb_am_pmItemStateChanged

    private void cbHoraItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cbHoraItemStateChanged
        capturarHora();
    }//GEN-LAST:event_cbHoraItemStateChanged

    private void quitar(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_quitar
        try {
            int indice = listaServicios.getSelectedIndex();
            this.monto -= serviciosCita.get(indice).getPrecio();
            labMonto.setText(String.valueOf(this.monto));
            modeloLista.remove(indice);
            listaServicios.setModel(modeloLista);
            serviciosCita.remove(indice);
        } catch (ArrayIndexOutOfBoundsException e) {//no hay nada seleccionado cuando se presiona el botón
            System.out.println(serviciosCita.size());
            listaServicios.setSelectedIndex(serviciosCita.size() - 1);
        }

    }//GEN-LAST:event_quitar

    private void btnAgregarServicioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregarServicioActionPerformed
        Servicio servicio = main.getBarberia().getServicios().get(cbServicios.getSelectedIndex());
        labDescripcionServicio.setText(servicio.getDescripcion());
        labPrecioServicio.setText(String.valueOf(servicio.getPrecio()));

        if (!serviciosCita.contains(servicio)) {
            serviciosCita.add(servicio);
            modeloLista.addElement(servicio.getNombre());
            this.monto += servicio.getPrecio();
            labMonto.setText(String.valueOf(this.monto));
        }
    }//GEN-LAST:event_btnAgregarServicioActionPerformed
// </editor-fold>

    // <editor-fold defaultstate="collapsed" desc="variables (componentes)">
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private com.toedter.calendar.JDateChooser DateChooser;
    private javax.swing.JButton bCrearCita;
    private javax.swing.JButton btnAgregarServicio;
    private javax.swing.JButton btnQuitar;
    private javax.swing.JComboBox cbClientes;
    private javax.swing.JComboBox cbHora;
    private javax.swing.JComboBox cbServicios;
    private javax.swing.JComboBox cb_am_pm;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JLabel labCorreoCliente;
    private javax.swing.JLabel labDescripcionServicio;
    private javax.swing.JLabel labHorario;
    private javax.swing.JLabel labHorario1;
    private javax.swing.JLabel labListaServicios;
    private javax.swing.JLabel labListaServicios1;
    private javax.swing.JLabel labMonto;
    private javax.swing.JLabel labPrecioServicio;
    private javax.swing.JLabel labSelecCliente;
    private javax.swing.JLabel labSelecFecha;
    private javax.swing.JLabel labTelefonoCliente;
    private javax.swing.JLabel labcbServicios;
    private javax.swing.JList listaServicios;
    private javax.swing.JTextArea textDetalle;
    // End of variables declaration//GEN-END:variables
    // </editor-fold>

}
