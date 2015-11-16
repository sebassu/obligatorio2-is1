package interfaz;

import auxiliar.Validaciones;
import dominio.Evento;
import dominio.Hijo;
import dominio.Sistema;
import java.awt.Color;
import java.util.ArrayList;
import java.util.Calendar;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;

public class VentanaCrearEvento extends javax.swing.JFrame {

    public VentanaCrearEvento(Sistema sis, int posEvento) {
        this.modelo = sis;
        this.posEventoAModificar = posEvento;
        this.idEventoAModificar = 0;
        try {
            initComponents();
            ((JLabel) jComboBoxTipo.getRenderer()).setHorizontalAlignment(SwingConstants.CENTER);
            ((JLabel) jComboBoxHijo.getRenderer()).setHorizontalAlignment(SwingConstants.CENTER);
            jComboBoxHijo.setModel(new DefaultComboBoxModel(modelo.getHijos().toArray()));
            ArrayList<String> aux = new ArrayList<>();
            aux.add("Otro");
            aux.add("Consulta");
            if (modelo.getCantidadVacunas() > 0) {
                aux.add("Vacunación");
            }
            jComboBoxTipo.setModel(new DefaultComboBoxModel(aux.toArray()));
            jComboBoxHijo.setSelectedIndex(0);
            jLabelOtro.setEnabled(false);
            txtOtro.setEnabled(false);
            jLabelErrorOtro.setEnabled(false);
            jLabelOtro.setVisible(false);
            txtOtro.setVisible(false);
            jLabelErrorOtro.setVisible(false);
            jLabelErrorFecha.setVisible(false);
            jLabelErrorLugar.setVisible(false);
            jLabelErrorTitulo.setVisible(false);
            if (posEvento != -1) {
                Evento eventoAModificar = modelo.getEvento(posEvento);
                idEventoAModificar = eventoAModificar.getId();
                txtTitulo.setText(eventoAModificar.getTitulo());
                txtLugar.setText(eventoAModificar.getLugar());
                jComboBoxHijo.setSelectedItem(eventoAModificar.getCualHijo());
                jComboBoxTipo.setSelectedItem(eventoAModificar.getTipo());
                if (eventoAModificar.getTipo().equals("Otro")) {
                    jLabelOtro.setEnabled(true);
                    txtOtro.setEnabled(true);
                    jLabelOtro.setVisible(true);
                    txtOtro.setVisible(true);
                    txtOtro.setText(eventoAModificar.getTipo());
                }
                textAreaDesc.setText(eventoAModificar.getDescripcion());
            }
        } catch (IllegalStateException e) {
            System.out.println(e.getMessage());
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        textArea1 = new java.awt.TextArea();
        jPanel5 = new javax.swing.JPanel();
        btnAceptar = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        jButtonCerrar = new javax.swing.JButton();
        jPanel6 = new javax.swing.JPanel();
        jPanelDatos = new javax.swing.JPanel();
        jLabel11 = new javax.swing.JLabel();
        txtTitulo = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jComboBoxTipo = new javax.swing.JComboBox();
        jLabelVacuna = new javax.swing.JLabel();
        jDateChooserFecha = new com.toedter.calendar.JDateChooser();
        jLabelErrorFecha = new javax.swing.JLabel();
        jLabelErrorTitulo = new javax.swing.JLabel();
        txtOtro = new javax.swing.JTextField();
        jComboBoxHijo = new javax.swing.JComboBox();
        jLabel15 = new javax.swing.JLabel();
        txtLugar = new javax.swing.JTextField();
        jLabelOtro = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        jLabelErrorLugar = new javax.swing.JLabel();
        jLabelErrorOtro = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        textAreaDesc = new javax.swing.JTextArea();
        jComboBoxVacunas = new javax.swing.JComboBox();
        jLabelMedico = new javax.swing.JLabel();
        txtMedico = new javax.swing.JTextField();
        jLabel18 = new javax.swing.JLabel();
        jLabelErrorMedico = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Registro de Hijo");
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        setMinimumSize(new java.awt.Dimension(200, 200));
        setResizable(false);

        btnAceptar.setText("Aceptar");
        btnAceptar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAceptarActionPerformed(evt);
            }
        });

        jPanel1.setBackground(new java.awt.Color(204, 204, 204));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jButtonCerrar.setText("Cerrar");
        jButtonCerrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonCerrarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnAceptar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButtonCerrar, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 1, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnAceptar, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButtonCerrar, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(6, 6, 6))
        );

        jPanel6.setBackground(new java.awt.Color(255, 255, 255));

        jPanelDatos.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Datos del Evento", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 11), new java.awt.Color(0, 51, 204))); // NOI18N
        jPanelDatos.setOpaque(false);

        jLabel11.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel11.setLabelFor(txtTitulo);
        jLabel11.setText("Título:");

        txtTitulo.setBorder(javax.swing.BorderFactory.createCompoundBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204)), javax.swing.BorderFactory.createEmptyBorder(2, 2, 2, 2)));
        txtTitulo.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtTituloFocusLost(evt);
            }
        });

        jLabel12.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel12.setLabelFor(jDateChooserFecha);
        jLabel12.setText("Fecha:");

        jLabel13.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel13.setText("Tipo de Evento:");

        jComboBoxTipo.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                jComboBoxTipoFocusLost(evt);
            }
        });

        jLabelVacuna.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabelVacuna.setLabelFor(jComboBoxVacunas);
        jLabelVacuna.setText("Vacuna:");
        jLabelVacuna.setEnabled(false);

        jDateChooserFecha.setToolTipText("Seleccionar una fecha anterior a la actual");
        jDateChooserFecha.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                jDateChooserFechaFocusLost(evt);
            }
        });

        jLabelErrorFecha.setForeground(new java.awt.Color(255, 0, 0));
        jLabelErrorFecha.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabelErrorFecha.setText("Fecha inválida");
        jLabelErrorFecha.setFocusable(false);

        jLabelErrorTitulo.setForeground(new java.awt.Color(255, 0, 0));
        jLabelErrorTitulo.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabelErrorTitulo.setText("Título inválido");
        jLabelErrorTitulo.setFocusable(false);

        txtOtro.setBorder(javax.swing.BorderFactory.createCompoundBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204)), javax.swing.BorderFactory.createEmptyBorder(2, 2, 2, 2)));
        txtOtro.setEnabled(false);
        txtOtro.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtOtroFocusLost(evt);
            }
        });

        jLabel15.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel15.setLabelFor(jComboBoxHijo);
        jLabel15.setText("Hijo:");

        txtLugar.setBorder(javax.swing.BorderFactory.createCompoundBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204)), javax.swing.BorderFactory.createEmptyBorder(2, 2, 2, 2)));
        txtLugar.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtLugarFocusLost(evt);
            }
        });

        jLabelOtro.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabelOtro.setLabelFor(txtOtro);
        jLabelOtro.setText("Otro:");
        jLabelOtro.setEnabled(false);

        jLabel17.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel17.setLabelFor(textAreaDesc);
        jLabel17.setText("Descripción:");

        jLabelErrorLugar.setForeground(new java.awt.Color(255, 0, 0));
        jLabelErrorLugar.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabelErrorLugar.setText("Lugar inválido");
        jLabelErrorLugar.setFocusable(false);

        jLabelErrorOtro.setForeground(new java.awt.Color(255, 0, 0));
        jLabelErrorOtro.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabelErrorOtro.setText("Tipo inválido");
        jLabelErrorOtro.setFocusable(false);

        textAreaDesc.setColumns(20);
        textAreaDesc.setRows(5);
        jScrollPane1.setViewportView(textAreaDesc);

        jComboBoxVacunas.setEnabled(false);

        jLabelMedico.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabelMedico.setLabelFor(txtLugar);
        jLabelMedico.setText("Médico:");
        jLabelMedico.setEnabled(false);

        txtMedico.setBorder(javax.swing.BorderFactory.createCompoundBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204)), javax.swing.BorderFactory.createEmptyBorder(2, 2, 2, 2)));
        txtMedico.setEnabled(false);
        txtMedico.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtMedicoFocusLost(evt);
            }
        });

        jLabel18.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel18.setLabelFor(txtLugar);
        jLabel18.setText("Lugar:");

        jLabelErrorMedico.setForeground(new java.awt.Color(255, 0, 0));
        jLabelErrorMedico.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabelErrorMedico.setText("Nombre inválido");
        jLabelErrorMedico.setFocusable(false);

        javax.swing.GroupLayout jPanelDatosLayout = new javax.swing.GroupLayout(jPanelDatos);
        jPanelDatos.setLayout(jPanelDatosLayout);
        jPanelDatosLayout.setHorizontalGroup(
            jPanelDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelDatosLayout.createSequentialGroup()
                .addGroup(jPanelDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanelDatosLayout.createSequentialGroup()
                        .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jDateChooserFecha, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanelDatosLayout.createSequentialGroup()
                        .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtTitulo))
                    .addGroup(jPanelDatosLayout.createSequentialGroup()
                        .addComponent(jLabel15, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jComboBoxHijo, javax.swing.GroupLayout.PREFERRED_SIZE, 158, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanelDatosLayout.createSequentialGroup()
                        .addGroup(jPanelDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabelVacuna, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabelOtro, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabelMedico, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel18, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanelDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanelDatosLayout.createSequentialGroup()
                                .addComponent(jComboBoxVacunas, javax.swing.GroupLayout.PREFERRED_SIZE, 158, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addComponent(jComboBoxTipo, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(txtOtro)
                            .addComponent(txtLugar)
                            .addComponent(txtMedico))))
                .addGap(4, 4, 4)
                .addGroup(jPanelDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabelErrorFecha, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabelErrorTitulo)
                    .addComponent(jLabelErrorLugar)
                    .addComponent(jLabelErrorOtro)
                    .addComponent(jLabelErrorMedico)))
            .addGroup(jPanelDatosLayout.createSequentialGroup()
                .addComponent(jLabel17, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelDatosLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1)
                .addContainerGap())
        );
        jPanelDatosLayout.setVerticalGroup(
            jPanelDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelDatosLayout.createSequentialGroup()
                .addGroup(jPanelDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtTitulo, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabelErrorTitulo, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanelDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanelDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jLabelErrorFecha, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jDateChooserFecha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanelDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jComboBoxHijo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel15, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanelDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jComboBoxTipo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanelDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtOtro, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabelOtro, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabelErrorOtro, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanelDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtLugar, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabelErrorLugar, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel18, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(19, 19, 19)
                .addGroup(jPanelDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jComboBoxVacunas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabelVacuna, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanelDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtMedico, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabelMedico, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabelErrorMedico, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel17, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel6Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanelDatos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel6Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanelDatos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(44, 44, 44))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, 425, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnAceptarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAceptarActionPerformed
       /* boolean error = false;
        String[] parametros = new String[4];
        parametros[0] = txtTitulo.getText().trim();
        if (parametros[0].isEmpty()) {
            jLabelErrorTitulo.setVisible(error = true);
        }
        Calendar fechaSeleccionada = jDateChooserFecha.getCalendar();
        if (!Validaciones.esFechaFutura(fechaSeleccionada)) {
            jLabelErrorFecha.setVisible(error = true);
        }
        parametros[1] = jComboBoxTipo.getSelectedItem().toString();
        if (parametros[1].equals("Otro")) {
            parametros[1] = txtOtro.getText().trim();
            if (parametros[2].isEmpty()) {
                jLabelErrorOtro.setVisible(error = true);
            }
        }
        parametros[2] = txtLugar.getText().trim();
        if (parametros[2].isEmpty()) {
            jLabelErrorLugar.setVisible(error = true);
        }
        if (!error) {
            try {
                if (posEventoAModificar != -1) {
                  switch(jComboBoxTipo.getSelectedItem().toString()) {
                      case "Otro":
                          modelo.agregarEvento(parametros[0], parametros[1],
                            textAreaDesc.getText(), fechaSeleccionada,
                            (Hijo) jComboBoxHijo.getSelectedItem(), parametros[2]);
                      case "Vacunación":
                          
                          modelo.AgregarVacunacion(parametros[0], parametros[1],
                            textAreaDesc.getText(), fechaSeleccionada,
                            (Hijo) jComboBoxHijo.getSelectedItem(), parametros[2]);
                  }
                } else {
                    modelo.modificarEvento(idEventoAModificar, parametros[0], parametros[1],
                            textAreaDesc.getText(), fechaSeleccionada,
                            (Hijo) jComboBoxHijo.getSelectedItem(), parametros[2]);
                }
            } catch (IllegalArgumentException | IllegalStateException e) {
                JOptionPane.showMessageDialog(this, "Error", e.getMessage(),
                        JOptionPane.ERROR_MESSAGE);
            }
        } else {
            JOptionPane.showMessageDialog(this, "Error", VentanaPrincipal.ERR_INGRESO,
                    JOptionPane.ERROR_MESSAGE);
        }*/
    }//GEN-LAST:event_btnAceptarActionPerformed

    private void jButtonCerrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonCerrarActionPerformed
        this.dispose();
    }//GEN-LAST:event_jButtonCerrarActionPerformed

    private void txtTituloFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtTituloFocusLost
        jLabelErrorTitulo.setVisible(txtTitulo.getText().trim().isEmpty());
    }//GEN-LAST:event_txtTituloFocusLost

    private void jDateChooserFechaFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jDateChooserFechaFocusLost
        jLabelErrorFecha.setVisible(!Validaciones.esFechaFutura(jDateChooserFecha.getCalendar()));
    }//GEN-LAST:event_jDateChooserFechaFocusLost

    private void txtOtroFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtOtroFocusLost
        jLabelErrorOtro.setVisible(txtOtro.getText().trim().isEmpty());
    }//GEN-LAST:event_txtOtroFocusLost

    private void txtLugarFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtLugarFocusLost
        String textoEscrito = txtLugar.getText().trim();
        if (textoEscrito.isEmpty()) {
            jLabelErrorLugar.setText("Lugar vacío");
            jLabelErrorLugar.setForeground(Color.yellow);
            jLabelErrorLugar.setVisible(true);
        } else if (Validaciones.noContieneCaracterAlfabetico(textoEscrito)) {
            jLabelErrorLugar.setText("Lugar inválido");
            jLabelErrorLugar.setForeground(Color.red);
            jLabelErrorLugar.setVisible(true);
        } else {
            jLabelErrorLugar.setVisible(false);
        }
    }//GEN-LAST:event_txtLugarFocusLost

    private void jComboBoxTipoFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jComboBoxTipoFocusLost
        txtOtro.setEnabled(false);
        jLabelErrorOtro.setVisible(false);
        jLabelOtro.setVisible(false);
        txtOtro.setVisible(false);
        jLabelVacuna.setVisible(false);
        jComboBoxVacunas.setEnabled(false);
        jComboBoxVacunas.setVisible(false);
        txtMedico.setEnabled(false);
        jLabelMedico.setVisible(false);
        txtMedico.setVisible(false);
        jLabelErrorMedico.setVisible(false);
        switch (jComboBoxTipo.getSelectedItem().toString()) {
            case "Otro":
                txtOtro.setEnabled(true);
                jLabelErrorOtro.setVisible(true);
                jLabelOtro.setVisible(true);
                txtOtro.setVisible(true);
                txtMedico.setText("");
                break;
            case "Consulta":
                txtMedico.setEnabled(true);
                jLabelMedico.setVisible(true);
                txtMedico.setVisible(true);
                txtOtro.setText("");
                break;
            case "Vacunación":
                jLabelVacuna.setVisible(false);
                jComboBoxVacunas.setEnabled(false);
                jComboBoxVacunas.setVisible(false);
                txtMedico.setText("");
                txtOtro.setText("");
                break;
        }
    }//GEN-LAST:event_jComboBoxTipoFocusLost

    private void txtMedicoFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtMedicoFocusLost
        jLabelErrorMedico.setVisible(Validaciones.noContieneCaracterAlfabetico(txtMedico.getText()));
    }//GEN-LAST:event_txtMedicoFocusLost

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAceptar;
    private javax.swing.JButton jButtonCerrar;
    private javax.swing.JComboBox jComboBoxHijo;
    private javax.swing.JComboBox jComboBoxTipo;
    private javax.swing.JComboBox jComboBoxVacunas;
    private com.toedter.calendar.JDateChooser jDateChooserFecha;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabelErrorFecha;
    private javax.swing.JLabel jLabelErrorLugar;
    private javax.swing.JLabel jLabelErrorMedico;
    private javax.swing.JLabel jLabelErrorOtro;
    private javax.swing.JLabel jLabelErrorTitulo;
    private javax.swing.JLabel jLabelMedico;
    private javax.swing.JLabel jLabelOtro;
    private javax.swing.JLabel jLabelVacuna;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanelDatos;
    private javax.swing.JScrollPane jScrollPane1;
    private java.awt.TextArea textArea1;
    private javax.swing.JTextArea textAreaDesc;
    private javax.swing.JTextField txtLugar;
    private javax.swing.JTextField txtMedico;
    private javax.swing.JTextField txtOtro;
    private javax.swing.JTextField txtTitulo;
    // End of variables declaration//GEN-END:variables
    private final Sistema modelo;
    private final int posEventoAModificar;
    private int idEventoAModificar;
}
