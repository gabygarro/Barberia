

package GUI;
import Exceptions.*;
import Exceptions.ScheduleTimingException;

import GUI.administracion.HorarioDeAtencion;
import GUI.administracion.ListaDeEspera;
import GUI.administracion.Notificaciones;
import GUI.citas.AdministrarCitas;
import GUI.citas.CrearCita;
import GUI.citas.EscogerFecha;
import GUI.citas.VerCalendario;


import GUI.clientes.AdministrarClientes;

import GUI.clientes.CrearClientes;

import GUI.funciones.funciones;
import GUI.servicios.AdministrarServicios;

import barberia.*;
import java.time.LocalTime;

import java.util.ArrayList;
import java.util.Calendar;

import javax.swing.JOptionPane;


public class Main extends javax.swing.JFrame {

    private Barberia barberia;
    
    
    public Main(){

        barberia=new Barberia("Barberia HairCut Bros.","22222222222","barberiahaircutbros@gmail.com");
        barberia.setContrasenaCorreo("Lucky Charms");
        //new SelectorHorarioAtencion(this).setVisible(true);
        funciones.setLogo(this);
        this.setTitle(getBarberia().getNombre());
        funciones.setLogo(this);
        
        this.setResizable(false);
        initComponents();
        
        new HorarioDeAtencion(this);
        
        
         
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel3 = new javax.swing.JLabel();
        jMenuBar1 = new javax.swing.JMenuBar();
        MenuClientes = new javax.swing.JMenu();
        jMenuItem3 = new javax.swing.JMenuItem();
        jMenuItem4 = new javax.swing.JMenuItem();
        MenuCitas = new javax.swing.JMenu();
        NuevaCita = new javax.swing.JMenuItem();
        jMenuItem6 = new javax.swing.JMenuItem();
        jMenu1 = new javax.swing.JMenu();
        jMenuItem5 = new javax.swing.JMenuItem();
        jMenuItem7 = new javax.swing.JMenuItem();
        MenuServicios = new javax.swing.JMenu();
        jMenuItem10 = new javax.swing.JMenuItem();
        MenuAdmin = new javax.swing.JMenu();
        jMenu2 = new javax.swing.JMenu();
        jMenuItem12 = new javax.swing.JMenuItem();
        jMenuItem13 = new javax.swing.JMenuItem();
        jMenuItem1 = new javax.swing.JMenuItem();
        jMenuItem11 = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBounds(new java.awt.Rectangle(300, 200, 0, 0));
        setFont(new java.awt.Font("Aharoni", 3, 10)); // NOI18N
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/the barbershop.png"))); // NOI18N
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 510, 310));

        jMenuBar1.setToolTipText("Crear nuevo usuario");

        MenuClientes.setText("Clientes");

        jMenuItem3.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_N, java.awt.event.InputEvent.CTRL_MASK));
        jMenuItem3.setText("Nuevo");
        jMenuItem3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem3ActionPerformed(evt);
            }
        });
        MenuClientes.add(jMenuItem3);

        jMenuItem4.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_A, java.awt.event.InputEvent.CTRL_MASK));
        jMenuItem4.setText("Administrar");
        jMenuItem4.setToolTipText("Administrar usuarios existentes");
        jMenuItem4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem4ActionPerformed(evt);
            }
        });
        MenuClientes.add(jMenuItem4);

        jMenuBar1.add(MenuClientes);

        MenuCitas.setText("Citas");

        NuevaCita.setText("Nueva");
        NuevaCita.setToolTipText("Crear nueva cita");
        NuevaCita.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                NuevaCitaActionPerformed(evt);
            }
        });
        MenuCitas.add(NuevaCita);

        jMenuItem6.setText("Administrar");
        jMenuItem6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem6ActionPerformed(evt);
            }
        });
        MenuCitas.add(jMenuItem6);

        jMenu1.setText("Calendario");

        jMenuItem5.setText("Mes");
        jMenuItem5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem5ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem5);

        jMenuItem7.setText("Semana");
        jMenuItem7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem7ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem7);

        MenuCitas.add(jMenu1);

        jMenuBar1.add(MenuCitas);

        MenuServicios.setText("Servicios");

        jMenuItem10.setText("Administrar");
        jMenuItem10.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem10ActionPerformed(evt);
            }
        });
        MenuServicios.add(jMenuItem10);

        jMenuBar1.add(MenuServicios);

        MenuAdmin.setText("Administración");

        jMenu2.setText("Horario");

        jMenuItem12.setText("Ver");
        jMenuItem12.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem12ActionPerformed(evt);
            }
        });
        jMenu2.add(jMenuItem12);

        jMenuItem13.setText("Establecer");
        jMenuItem13.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem13ActionPerformed(evt);
            }
        });
        jMenu2.add(jMenuItem13);

        MenuAdmin.add(jMenu2);

        jMenuItem1.setText("Lista de Espera");
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        MenuAdmin.add(jMenuItem1);

        jMenuItem11.setText("Notificaciones");
        jMenuItem11.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem11ActionPerformed(evt);
            }
        });
        MenuAdmin.add(jMenuItem11);

        jMenuBar1.add(MenuAdmin);

        setJMenuBar(jMenuBar1);

        pack();
    }// </editor-fold>//GEN-END:initComponents
    

        //lo que se ejecuta a la hora de elegir opciones en el JMenuBar  
    private void jMenuItem3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem3ActionPerformed
        new CrearClientes(this);
    }//GEN-LAST:event_jMenuItem3ActionPerformed

    private void jMenuItem4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem4ActionPerformed
        new AdministrarClientes(this);
    }//GEN-LAST:event_jMenuItem4ActionPerformed

    private void NuevaCitaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_NuevaCitaActionPerformed
        new CrearCita(this);
    }//GEN-LAST:event_NuevaCitaActionPerformed

    private void jMenuItem6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem6ActionPerformed
        new AdministrarCitas(this);
    }//GEN-LAST:event_jMenuItem6ActionPerformed

    private void jMenuItem13ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem13ActionPerformed
        new HorarioDeAtencion(this);
    }//GEN-LAST:event_jMenuItem13ActionPerformed

    private void jMenuItem12ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem12ActionPerformed
        JOptionPane.showMessageDialog(this,getBarberia().getHorarioAtencion().toString());
    }//GEN-LAST:event_jMenuItem12ActionPerformed

    private void jMenuItem5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem5ActionPerformed
        new EscogerFecha(this,VerCalendario.MES);
    }//GEN-LAST:event_jMenuItem5ActionPerformed

    private void jMenuItem7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem7ActionPerformed
        new EscogerFecha(this, VerCalendario.SEMANA);
    }//GEN-LAST:event_jMenuItem7ActionPerformed

    private void jMenuItem10ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem10ActionPerformed
        new AdministrarServicios(this);
    }//GEN-LAST:event_jMenuItem10ActionPerformed

    private void jMenuItem11ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem11ActionPerformed
        new Notificaciones(this);
    }//GEN-LAST:event_jMenuItem11ActionPerformed

    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
        new ListaDeEspera(this);
    }//GEN-LAST:event_jMenuItem1ActionPerformed
      
    
    
    public void crearCliente(String nombre, String correo, String telefono) throws ExistingClientException, InvalidPhoneException, InvalidNameException, InvalidEmailException{
        barberia.crearCliente(nombre, correo, telefono);
    }
   
    public void setHorarioAtencion(int diaInicio, int diaFin, LocalTime inicio, LocalTime salidaAlmuerzo,LocalTime entradAlmuerzo, LocalTime fin) throws ScheduleTimingException
    {
        
            barberia.setHorarioAtencion(diaInicio, diaFin, inicio, salidaAlmuerzo, entradAlmuerzo, fin);
        
    }
    public void agregarCita(Calendar calendario,Cliente cliente, ArrayList<Servicio> servicios, String detalle ) throws BusyHourException, CreatedAppointmentThrowable, DateOutOfScheduleException{
        barberia.agregarCita(calendario,cliente,servicios, detalle);
    }
    
    public Barberia getBarberia(){
        return this.barberia;
    }

    public static void main(String args[]){
         java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                
                    funciones.LnF();
                    new Main();
            }
        });
    }
   
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenu MenuAdmin;
    private javax.swing.JMenu MenuCitas;
    private javax.swing.JMenu MenuClientes;
    private javax.swing.JMenu MenuServicios;
    private javax.swing.JMenuItem NuevaCita;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem10;
    private javax.swing.JMenuItem jMenuItem11;
    private javax.swing.JMenuItem jMenuItem12;
    private javax.swing.JMenuItem jMenuItem13;
    private javax.swing.JMenuItem jMenuItem3;
    private javax.swing.JMenuItem jMenuItem4;
    private javax.swing.JMenuItem jMenuItem5;
    private javax.swing.JMenuItem jMenuItem6;
    private javax.swing.JMenuItem jMenuItem7;
    // End of variables declaration//GEN-END:variables
}
