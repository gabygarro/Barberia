package GUI.citas.modificarCita;

import GUI.funciones.funciones;
import barberia.Servicio;
import java.util.ArrayList;
import javax.swing.DefaultListModel;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class SeleccionarServicios extends javax.swing.JFrame {

   private ArrayList<Servicio> serviciosBarberia;
   private ArrayList<Servicio> serviciosCita;
   private ModificarCita modificarCita;
   private DefaultListModel modeloLista;
   private double monto;
   
    public SeleccionarServicios(ArrayList<Servicio> serviciosBarberia, ModificarCita modificarCita) {
        this.serviciosBarberia = serviciosBarberia;
        this.modificarCita = modificarCita;
        this.modeloLista = new DefaultListModel();
        this.serviciosCita = modificarCita.getCita().getServicios();
        this.monto =0;

        initComponents();
        this.setTitle("Modifica servicios");
        funciones.setLogo(this);
        listaServicios.setModel(modeloLista);
        initTabla();
        refrescar();
        this.setVisible(true);
        
    }
    
    private void initLista(){
        modeloLista.removeAllElements();
        
        for (Servicio s : serviciosCita){
            modeloLista.addElement(s.getNombre());
        }
        
    }
    private void initTabla(){
        DefaultTableModel tm = new DefaultTableModel(){
                @Override
            public boolean isCellEditable(int row, int column) {
       
                return false;
            }
        };
        tm.addColumn("Nombre");
        tm.addColumn("Precio");
        for (Servicio s : serviciosBarberia){
            tm.addRow(new Object[] {s.getNombre(), s.getPrecio()});
        }
        tablaServicios.setModel(tm);
    }

    private void refrescar(){
        initLista();
        labMonto.setText("c"+modificarCita.getCita().calcularMonto());
        modificarCita.refrescar();
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        borrar = new javax.swing.JButton();
        btnAgregar = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        tablaServicios = new javax.swing.JTable();
        jScrollPane1 = new javax.swing.JScrollPane();
        textoDescripcion = new javax.swing.JTextArea();
        jScrollPane3 = new javax.swing.JScrollPane();
        listaServicios = new javax.swing.JList();
        jButton1 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        labMonto = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        borrar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon-delete.png"))); // NOI18N
        borrar.setText("Eliminar");
        borrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                borrarActionPerformed(evt);
            }
        });

        btnAgregar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/add.png"))); // NOI18N
        btnAgregar.setText("Agregar");
        btnAgregar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgregarActionPerformed(evt);
            }
        });

        tablaServicios.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Nombre", "Precio"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.Double.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        tablaServicios.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tablaServiciosMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(tablaServicios);

        textoDescripcion.setColumns(20);
        textoDescripcion.setRows(5);
        textoDescripcion.setWrapStyleWord(true);
        textoDescripcion.setAutoscrolls(false);
        jScrollPane1.setViewportView(textoDescripcion);

        jScrollPane3.setViewportView(listaServicios);

        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/save-icon.png"))); // NOI18N
        jButton1.setText("Guardar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jLabel1.setText("Descripción del servicio:");

        labMonto.setText("Monto: ");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jScrollPane3)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 316, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnAgregar)
                    .addComponent(borrar)
                    .addComponent(jLabel1)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 181, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(labMonto))
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addGap(224, 224, 224)
                .addComponent(jButton1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 168, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(21, 21, 21)
                        .addComponent(labMonto)
                        .addGap(18, 18, 18)
                        .addComponent(btnAgregar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(borrar)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 7, Short.MAX_VALUE)
                .addComponent(jButton1))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnAgregarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregarActionPerformed
        try {
            if (!serviciosCita.contains(serviciosBarberia.get(tablaServicios.getSelectedRow()))){
                serviciosCita.add(serviciosBarberia.get(tablaServicios.getSelectedRow()));
            }
            refrescar();
        }catch (IndexOutOfBoundsException e){
            JOptionPane.showMessageDialog(this, "Seleccione un servicio", "?", JOptionPane.WARNING_MESSAGE);
        }
    }//GEN-LAST:event_btnAgregarActionPerformed

    private void tablaServiciosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tablaServiciosMouseClicked
        try{
            textoDescripcion.setText(serviciosBarberia.get(tablaServicios.getSelectedRow()).getDescripcion());
        }catch (IndexOutOfBoundsException e){
            JOptionPane.showMessageDialog(this, "Seleccione un servicio", "?", JOptionPane.WARNING_MESSAGE);
        }
    }//GEN-LAST:event_tablaServiciosMouseClicked

    private void borrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_borrarActionPerformed
        try{
           int indice = listaServicios.getSelectedIndex();
           serviciosCita.remove(indice);
           refrescar();
           listaServicios.setSelectedIndex(indice-1);
        }catch (IndexOutOfBoundsException e){
            listaServicios.setSelectedIndex(listaServicios.getMaxSelectionIndex());

        }
    }//GEN-LAST:event_borrarActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        this.dispose();
    }//GEN-LAST:event_jButton1ActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton borrar;
    private javax.swing.JButton btnAgregar;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JLabel labMonto;
    private javax.swing.JList listaServicios;
    private javax.swing.JTable tablaServicios;
    private javax.swing.JTextArea textoDescripcion;
    // End of variables declaration//GEN-END:variables
}

