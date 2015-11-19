package interfaz;

import auxiliar.Auxiliares;
import dominio.Consulta;
import dominio.Evento;
import dominio.Hijo;
import dominio.Sistema;
import dominio.Vacuna;
import dominio.Vacunacion;
import java.awt.Color;
import java.util.ArrayList;
import java.util.Calendar;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;

public class VentanaCrearEvento extends javax.swing.JFrame {

    public VentanaCrearEvento(Sistema sis, int posEvento, VentanaPrincipal v) {
        this.modelo = sis;
        this.posEventoAModificar = posEvento;
        this.ventanaPrincipal = v;
        try {
            initComponents();
            ((JLabel) jComboBoxTipo.getRenderer()).setHorizontalAlignment(SwingConstants.CENTER);
            ((JLabel) jComboBoxHijo.getRenderer()).setHorizontalAlignment(SwingConstants.CENTER);
            jComboBoxHijo.setModel(new DefaultComboBoxModel(modelo.getHijos().toArray()));
            jComboBoxVacunas.setModel(new DefaultComboBoxModel(modelo.getVacunas().toArray()));
            ArrayList<String> aux = new ArrayList<>();
            aux.add("Otro");
            aux.add("Consulta");
            if (modelo.getCantidadVacunas() > 0) {
                aux.add("Vacunación");
            }
            jComboBoxTipo.setModel(new DefaultComboBoxModel(aux.toArray()));
            jDateChooserFecha.setCalendar(Calendar.getInstance());
            jComboBoxTipo.setSelectedIndex(0);
            jComboBoxHijo.setSelectedIndex(0);
            jLabelErrorOtro.setVisible(false);
            jLabelErrorLugar.setVisible(false);
            jLabelErrorTitulo.setVisible(false);
            if (posEvento != -1) {
                Evento eventoAModificar = modelo.getEvento(posEvento);
                txtOtro.setEnabled(false);
                jComboBoxTipo.setEnabled(false);
                jComboBoxHijo.setEnabled(false);
                txtTitulo.setText(eventoAModificar.getTitulo());
                txtLugar.setText(eventoAModificar.getLugar());
                jComboBoxHijo.setSelectedItem(eventoAModificar.getCualHijo());
                switch (eventoAModificar.getTipo()) {
                    case "Vacunación":
                    case "Consulta":
                        jComboBoxTipo.setSelectedItem(eventoAModificar.getTipo());
                        break;
                    default:
                        jLabelOtro.setVisible(true);
                        txtOtro.setVisible(true);
                        txtOtro.setText(eventoAModificar.getTipo());
                        break;
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
        jLabelErrorTitulo = new javax.swing.JLabel();
        txtOtro = new javax.swing.JTextField();
        jComboBoxHijo = new javax.swing.JComboBox();
        jLabel15 = new javax.swing.JLabel();
        txtLugar = new javax.swing.JTextField();
        jLabelOtro = new javax.swing.JLabel();
        jLabelErrorLugar = new javax.swing.JLabel();
        jLabelErrorOtro = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        textAreaDesc = new javax.swing.JTextArea();
        jComboBoxVacunas = new javax.swing.JComboBox();
        jLabelMedico = new javax.swing.JLabel();
        txtMedico = new javax.swing.JTextField();
        jLabel18 = new javax.swing.JLabel();
        jLabelErrorMedico = new javax.swing.JLabel();
        filler1 = new javax.swing.Box.Filler(new java.awt.Dimension(0, 0), new java.awt.Dimension(0, 0), new java.awt.Dimension(32767, 0));

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Registro de Evento");
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        setMinimumSize(new java.awt.Dimension(200, 200));

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
                .addComponent(btnAceptar, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jButtonCerrar, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(33, 33, 33))
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
        jPanel6.setMaximumSize(new java.awt.Dimension(463, 466));
        jPanel6.setMinimumSize(new java.awt.Dimension(463, 466));

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

        jComboBoxTipo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBoxTipoActionPerformed(evt);
            }
        });

        jLabelVacuna.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabelVacuna.setLabelFor(jComboBoxVacunas);
        jLabelVacuna.setText("Vacuna:");

        jDateChooserFecha.setToolTipText("Seleccionar una fecha anterior a la actual");

        jLabelErrorTitulo.setForeground(new java.awt.Color(255, 0, 0));
        jLabelErrorTitulo.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabelErrorTitulo.setText("Título inválido");
        jLabelErrorTitulo.setFocusable(false);

        txtOtro.setBorder(javax.swing.BorderFactory.createCompoundBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204)), javax.swing.BorderFactory.createEmptyBorder(2, 2, 2, 2)));
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
        textAreaDesc.setBorder(javax.swing.BorderFactory.createTitledBorder("Descripción"));
        jScrollPane1.setViewportView(textAreaDesc);

        jLabelMedico.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabelMedico.setLabelFor(txtLugar);
        jLabelMedico.setText("Médico:");

        txtMedico.setBorder(javax.swing.BorderFactory.createCompoundBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204)), javax.swing.BorderFactory.createEmptyBorder(2, 2, 2, 2)));
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
            .addComponent(filler1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanelDatosLayout.createSequentialGroup()
                .addGroup(jPanelDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanelDatosLayout.createSequentialGroup()
                        .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jDateChooserFecha, javax.swing.GroupLayout.PREFERRED_SIZE, 226, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanelDatosLayout.createSequentialGroup()
                        .addGroup(jPanelDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabelVacuna, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabelOtro, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabelMedico, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel18, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanelDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jComboBoxTipo, javax.swing.GroupLayout.PREFERRED_SIZE, 226, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanelDatosLayout.createSequentialGroup()
                                .addComponent(txtMedico, javax.swing.GroupLayout.PREFERRED_SIZE, 226, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, Short.MAX_VALUE)
                                .addComponent(jLabelErrorMedico))
                            .addComponent(jComboBoxVacunas, javax.swing.GroupLayout.PREFERRED_SIZE, 226, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanelDatosLayout.createSequentialGroup()
                                .addComponent(txtOtro, javax.swing.GroupLayout.PREFERRED_SIZE, 226, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jLabelErrorOtro))
                            .addGroup(jPanelDatosLayout.createSequentialGroup()
                                .addComponent(txtLugar, javax.swing.GroupLayout.PREFERRED_SIZE, 226, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jLabelErrorLugar))))
                    .addGroup(jPanelDatosLayout.createSequentialGroup()
                        .addComponent(jLabel15, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jComboBoxHijo, javax.swing.GroupLayout.PREFERRED_SIZE, 226, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanelDatosLayout.createSequentialGroup()
                        .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtTitulo, javax.swing.GroupLayout.PREFERRED_SIZE, 226, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabelErrorTitulo))
                    .addGroup(jPanelDatosLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane1)))
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
                    .addGroup(jPanelDatosLayout.createSequentialGroup()
                        .addComponent(jDateChooserFecha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(2, 2, 2)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanelDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jComboBoxHijo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel15, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanelDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
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
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanelDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabelVacuna, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jComboBoxVacunas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(6, 6, 6)
                .addGroup(jPanelDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelErrorMedico, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtMedico, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabelMedico, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(filler1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 191, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanelDatos, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanelDatos, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(0, 0, 0)
                .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnAceptarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAceptarActionPerformed
        try {
            String titulo = txtTitulo.getText().trim();
            if (Auxiliares.noContieneCaracterAlfabetico(titulo)) {
                jLabelErrorTitulo.setVisible(true);
            }
            String tipo = jComboBoxTipo.getSelectedItem().toString();
            switch (tipo) {
                case "Otro":
                    tipo = txtOtro.getText().trim();
                    if (Auxiliares.noContieneCaracterAlfabetico(tipo)
                            || tipo.equalsIgnoreCase("Consulta")
                            || tipo.equalsIgnoreCase("Vacunación")
                            || tipo.equalsIgnoreCase("Vacunacion")) {
                        jLabelErrorOtro.setVisible(true);
                    }
                    break;
                case "Consulta":
                    ValidarMedico();
                    break;
            }
            Evento eventoAAgregar;
            switch (tipo) {
                case "Consulta":
                    eventoAAgregar = new Consulta(Sistema.proximaIDEventos++, titulo, tipo,
                            textAreaDesc.getText().trim(), jDateChooserFecha.getCalendar(),
                            (Hijo) jComboBoxHijo.getSelectedItem(), txtLugar.getText().trim(),
                            txtMedico.getText().trim());
                    break;
                case "Vacunación":
                    eventoAAgregar = new Vacunacion(Sistema.proximaIDEventos++, titulo, tipo,
                            textAreaDesc.getText().trim(), jDateChooserFecha.getCalendar(),
                            (Hijo) jComboBoxHijo.getSelectedItem(), txtLugar.getText().trim(),
                            (Vacuna) jComboBoxVacunas.getSelectedItem());
                    break;
                default:
                    eventoAAgregar = new Evento(Sistema.proximaIDEventos++, titulo, tipo,
                            textAreaDesc.getText().trim(), jDateChooserFecha.getCalendar(),
                            (Hijo) jComboBoxHijo.getSelectedItem(), txtLugar.getText().trim());
                    break;
            }
            if (posEventoAModificar == -1) {
                modelo.agregarEvento(eventoAAgregar);
                ventanaPrincipal.pintarDia(jDateChooserFecha.getCalendar());
            } else {
                modelo.modificarEvento(eventoAAgregar, posEventoAModificar);
            }
            ventanaPrincipal.activarOpcionesModificacionEventos();
            ventanaPrincipal.cargarPanelEventosProximos();
            this.dispose();
        } catch (IllegalArgumentException e) {
            JOptionPane.showMessageDialog(this, VentanaPrincipal.ERR_INGRESO, "Error"
                    + e.getMessage(), JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_btnAceptarActionPerformed

    private void jButtonCerrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonCerrarActionPerformed
        this.dispose();
    }//GEN-LAST:event_jButtonCerrarActionPerformed

    private void txtMedicoFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtMedicoFocusLost
        ValidarMedico();
    }//GEN-LAST:event_txtMedicoFocusLost

    private void txtLugarFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtLugarFocusLost
        String textoEscrito = txtLugar.getText().trim();
        if (textoEscrito.isEmpty()) {
            jLabelErrorLugar.setText("Lugar vacío");
            jLabelErrorLugar.setForeground(Color.orange);
            jLabelErrorLugar.setVisible(true);
        } else if (Auxiliares.noContieneCaracterAlfabetico(textoEscrito)) {
            jLabelErrorLugar.setText("Lugar inválido");
            jLabelErrorLugar.setForeground(Color.red);
            jLabelErrorLugar.setVisible(true);
        } else {
            jLabelErrorLugar.setVisible(false);
        }
    }//GEN-LAST:event_txtLugarFocusLost

    private void txtOtroFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtOtroFocusLost
        jLabelErrorOtro.setVisible(txtOtro.getText().trim().isEmpty());
    }//GEN-LAST:event_txtOtroFocusLost

    private void jComboBoxTipoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBoxTipoActionPerformed
        jLabelErrorOtro.setVisible(false);
        jLabelOtro.setVisible(false);
        txtOtro.setVisible(false);
        jLabelVacuna.setVisible(false);
        jComboBoxVacunas.setVisible(false);
        jLabelMedico.setVisible(false);
        txtMedico.setVisible(false);
        jLabelErrorMedico.setVisible(false);
        switch (jComboBoxTipo.getSelectedItem().toString()) {
            case "Otro":
                jLabelOtro.setVisible(true);
                txtOtro.setVisible(true);
                txtMedico.setText("");
                break;
            case "Consulta":
                jLabelMedico.setVisible(true);
                txtMedico.setVisible(true);
                txtOtro.setText("");
                break;
            case "Vacunación":
                jLabelVacuna.setVisible(true);
                jComboBoxVacunas.setVisible(true);
                txtMedico.setText("");
                txtOtro.setText("");
                break;
        }
    }//GEN-LAST:event_jComboBoxTipoActionPerformed

    private void txtTituloFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtTituloFocusLost
        jLabelErrorTitulo.setVisible(Auxiliares.noContieneCaracterAlfabetico(txtTitulo.getText()));
    }//GEN-LAST:event_txtTituloFocusLost

    private void ValidarMedico() {
        String textoEscrito = txtMedico.getText().trim();
        if (textoEscrito.isEmpty()) {
            jLabelErrorMedico.setText("Campo vacío");
            jLabelErrorMedico.setForeground(Color.orange);
            jLabelErrorMedico.setVisible(true);
        } else if (Auxiliares.noContieneCaracterAlfabetico(textoEscrito)) {
            jLabelErrorMedico.setText("Médico inválido");
            jLabelErrorMedico.setForeground(Color.red);
            jLabelErrorMedico.setVisible(true);
        } else {
            jLabelErrorMedico.setVisible(false);
        }
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAceptar;
    private javax.swing.Box.Filler filler1;
    private javax.swing.JButton jButtonCerrar;
    private javax.swing.JComboBox jComboBoxHijo;
    private javax.swing.JComboBox jComboBoxTipo;
    private javax.swing.JComboBox jComboBoxVacunas;
    private com.toedter.calendar.JDateChooser jDateChooserFecha;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel18;
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
    private javax.swing.JTextArea textAreaDesc;
    private javax.swing.JTextField txtLugar;
    private javax.swing.JTextField txtMedico;
    private javax.swing.JTextField txtOtro;
    private javax.swing.JTextField txtTitulo;
    // End of variables declaration//GEN-END:variables
    private final Sistema modelo;
    private final int posEventoAModificar;
    private VentanaPrincipal ventanaPrincipal;
}
