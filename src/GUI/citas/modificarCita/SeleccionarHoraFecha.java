

package GUI.citas.modificarCita;

import Exceptions.BusyHourException;
import Exceptions.DateOutOfScheduleException;
import GUI.funciones.funciones;
import barberia.Cita;
import com.toedter.calendar.demo.DateChooserPanel;
import java.time.LocalDateTime;
import java.util.Calendar;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;



public class SeleccionarHoraFecha extends javax.swing.JFrame {
    
   
    private ModificarCita modificarCita;
    private int hora;
    
    public SeleccionarHoraFecha(ModificarCita modificarCita) 
    {

        this.modificarCita = modificarCita;
        System.out.println("+++"+modificarCita.getCita().getFecha().getDayOfMonth());
        initComponents(); 
        this.setTitle("Seleccionar nueva hora y fecha");
        funciones.setLogo(this);
        initCB();
        this.setVisible(true);
    }
    
    private void initCB(){
        java.time.LocalDateTime dt = modificarCita.getCita().getFecha();
        
        
        this. hora = dt.getHour();
        if (hora>12){
            hora -= 12;
            cb_am_pm.setSelectedIndex(1);
        }else if (hora == 0){
            hora = 12;
            cb_am_pm.setSelectedIndex(0);
        } else if (hora == 12){
            cb_am_pm.setSelectedIndex(1);
        }
        cbHora.setSelectedIndex(hora-1);
        
        
        Calendario.setCalendar(funciones.dateToCal(dt));
        
        Calendario.setDate(Calendario.getCalendar().getTime());
        
    }
 

        

   private void capturarHora(){
        this.hora = cbHora.getSelectedIndex() + 1;
        if (cb_am_pm.getSelectedItem().equals("pm")) {
            this.hora += 12;
            if (this.hora == 24) {
                this.hora = 12;
            }
            } else if (hora == 12) {
                this.hora = 0;
        }
        
        
    }
   
   private Calendar capturarFecha(){
       return Calendario.getCalendar();
   }
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        Calendario = new com.toedter.calendar.JCalendar();
        btnCambiarFecha = new javax.swing.JButton();
        cbHora = new javax.swing.JComboBox();
        jLabel1 = new javax.swing.JLabel();
        cb_am_pm = new javax.swing.JComboBox();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        btnCambiarFecha.setIcon(new javax.swing.ImageIcon(getClass().getResource("/confirmar-icon.png"))); // NOI18N
        btnCambiarFecha.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                reacomodar(evt);
            }
        });

        cbHora.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        cbHora.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12" }));

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel1.setText(":00");

        cb_am_pm.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        cb_am_pm.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "am", "pm" }));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(cbHora, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(cb_am_pm, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnCambiarFecha, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addComponent(Calendario, javax.swing.GroupLayout.DEFAULT_SIZE, 416, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(cbHora, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel1))
                        .addGap(0, 1, Short.MAX_VALUE))
                    .addComponent(cb_am_pm)
                    .addComponent(btnCambiarFecha, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(Calendario, javax.swing.GroupLayout.PREFERRED_SIZE, 302, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void reacomodar(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_reacomodar
        
        try {
            capturarHora();
            Calendar calendario = Calendario.getCalendar();
            calendario.set(Calendar.HOUR_OF_DAY, hora);
            calendario.set(Calendar.MINUTE, 0);
            
            modificarCita.getMain().getBarberia().getAgenda().reacomodar(modificarCita.getCita(), funciones.calToDate(calendario));
            this.dispose();
            modificarCita.refrescar();
        } catch (DateOutOfScheduleException ex) {
            JOptionPane.showMessageDialog(this, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        } catch (BusyHourException ex) {
            JOptionPane.showMessageDialog(this, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
        
        
    }//GEN-LAST:event_reacomodar

    
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private com.toedter.calendar.JCalendar Calendario;
    private javax.swing.JButton btnCambiarFecha;
    private javax.swing.JComboBox cbHora;
    private javax.swing.JComboBox cb_am_pm;
    private javax.swing.JLabel jLabel1;
    // End of variables declaration//GEN-END:variables
}
