package interfaz;

import dominio.Hijo;
import dominio.Sistema;
import java.awt.event.KeyEvent;
import java.util.Calendar;
import java.util.Date;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;

public class VentanaCrearHijo extends javax.swing.JFrame {

    public VentanaCrearHijo(Sistema sis, Hijo h, boolean esParaEditar) {
        this.modelo = sis;
        this.edicion = esParaEditar;
        this.cedulaAnt = "";
        initComponents();
        ((JLabel) jComboBoxGenero.getRenderer()).setHorizontalAlignment(SwingConstants.CENTER);
        jDateChooserNac.setSelectableDateRange(null, new Date());
        jLabelErrorCedula.setVisible(false);
        jLabelErrorFecha.setVisible(false);
        jLabelErrorMed.setVisible(false);
        jLabelErrorNomSoc.setVisible(false);
        jLabelErrorNombre.setVisible(false);
        setLocationRelativeTo(null);
        if (esParaEditar) {
            this.setTitle("Edición de un Registro");
            this.cedulaAnt = h.getCedulaId();
            txtCedula.setText(cedulaAnt);
            txtMedico.setText(h.getMedicoDeCabecera());
            txtSociedad.setText(h.getSociedadMedica());
            txtNombre.setText(h.getNombre());
            jDateChooserNac.setCalendar(h.getFechaNacimiento());
            if (!h.esHombre()) {
                jComboBoxGenero.setSelectedIndex(1);
            }
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel5 = new javax.swing.JPanel();
        btnAceptar = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        jButton1 = new javax.swing.JButton();
        jPanel6 = new javax.swing.JPanel();
        jPanelDatos = new javax.swing.JPanel();
        jLabel11 = new javax.swing.JLabel();
        txtNombre = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        txtCedula = new javax.swing.JTextField();
        jLabel13 = new javax.swing.JLabel();
        jComboBoxGenero = new javax.swing.JComboBox();
        jLabel14 = new javax.swing.JLabel();
        jLabelErrorCedula = new javax.swing.JLabel();
        jDateChooserNac = new com.toedter.calendar.JDateChooser();
        jLabelErrorFecha = new javax.swing.JLabel();
        jLabelErrorNombre = new javax.swing.JLabel();
        jPanelEstadisticas = new javax.swing.JPanel();
        jLabel8 = new javax.swing.JLabel();
        txtSociedad = new javax.swing.JTextField();
        txtMedico = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        jLabelErrorNomSoc = new javax.swing.JLabel();
        jLabelErrorMed = new javax.swing.JLabel();

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

        jButton1.setText("Cerrar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
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
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 1, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnAceptar, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(6, 6, 6))
        );

        jPanel6.setBackground(new java.awt.Color(255, 255, 255));

        jPanelDatos.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Datos personales", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 11), new java.awt.Color(0, 51, 204))); // NOI18N
        jPanelDatos.setOpaque(false);

        jLabel11.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel11.setLabelFor(txtNombre);
        jLabel11.setText("Nombre:");

        txtNombre.setBorder(javax.swing.BorderFactory.createCompoundBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204)), javax.swing.BorderFactory.createEmptyBorder(2, 2, 2, 2)));
        txtNombre.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtNombreFocusLost(evt);
            }
        });
        txtNombre.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtNombreKeyTyped(evt);
            }
        });

        jLabel12.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel12.setLabelFor(jDateChooserNac);
        jLabel12.setText("Nacimiento:");

        txtCedula.setToolTipText("Formato: N.NNN.NNN-N");
        txtCedula.setBorder(javax.swing.BorderFactory.createCompoundBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204)), javax.swing.BorderFactory.createEmptyBorder(2, 2, 2, 2)));
        txtCedula.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtCedulaKeyTyped(evt);
            }
        });

        jLabel13.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel13.setText("CI:");

        jComboBoxGenero.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Masculino", "Femenino" }));

        jLabel14.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel14.setLabelFor(jComboBoxGenero);
        jLabel14.setText("Género:");

        jLabelErrorCedula.setForeground(new java.awt.Color(255, 0, 0));
        jLabelErrorCedula.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabelErrorCedula.setText("Cédula inválida");
        jLabelErrorCedula.setFocusable(false);
        jLabelErrorCedula.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                jLabelErrorCedulaFocusLost(evt);
            }
        });

        jDateChooserNac.setToolTipText("Seleccionar una fecha anterior a la actual");
        jDateChooserNac.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                jDateChooserNacFocusLost(evt);
            }
        });

        jLabelErrorFecha.setForeground(new java.awt.Color(255, 0, 0));
        jLabelErrorFecha.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabelErrorFecha.setText("Fecha inválida");
        jLabelErrorFecha.setFocusable(false);

        jLabelErrorNombre.setForeground(new java.awt.Color(255, 0, 0));
        jLabelErrorNombre.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabelErrorNombre.setText("Nombre inválido");
        jLabelErrorNombre.setFocusable(false);

        javax.swing.GroupLayout jPanelDatosLayout = new javax.swing.GroupLayout(jPanelDatos);
        jPanelDatos.setLayout(jPanelDatosLayout);
        jPanelDatosLayout.setHorizontalGroup(
            jPanelDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelDatosLayout.createSequentialGroup()
                .addGroup(jPanelDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(jPanelDatosLayout.createSequentialGroup()
                        .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jDateChooserNac, javax.swing.GroupLayout.DEFAULT_SIZE, 158, Short.MAX_VALUE))
                    .addGroup(jPanelDatosLayout.createSequentialGroup()
                        .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtNombre))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanelDatosLayout.createSequentialGroup()
                        .addGroup(jPanelDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel14, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanelDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jComboBoxGenero, 0, 158, Short.MAX_VALUE)
                            .addComponent(txtCedula))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanelDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabelErrorCedula, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabelErrorFecha, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabelErrorNombre))
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanelDatosLayout.setVerticalGroup(
            jPanelDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelDatosLayout.createSequentialGroup()
                .addGroup(jPanelDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabelErrorNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanelDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanelDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jLabelErrorFecha, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jDateChooserNac, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanelDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtCedula, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabelErrorCedula, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanelDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel14, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jComboBoxGenero, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
        );

        jPanelEstadisticas.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Datos Servicio de Salud", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 11), new java.awt.Color(0, 51, 204))); // NOI18N
        jPanelEstadisticas.setOpaque(false);

        jLabel8.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel8.setText("Sociedad médica:");

        txtSociedad.setBorder(javax.swing.BorderFactory.createCompoundBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204)), javax.swing.BorderFactory.createEmptyBorder(2, 2, 2, 2)));

        txtMedico.setBorder(javax.swing.BorderFactory.createCompoundBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204)), javax.swing.BorderFactory.createEmptyBorder(2, 2, 2, 2)));
        txtMedico.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtMedicoFocusLost(evt);
            }
        });
        txtMedico.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtMedicoKeyTyped(evt);
            }
        });

        jLabel9.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel9.setText("Médico de Cabecera:");

        jLabelErrorNomSoc.setForeground(new java.awt.Color(255, 0, 0));
        jLabelErrorNomSoc.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabelErrorNomSoc.setText("Entrada inválida");
        jLabelErrorNomSoc.setFocusable(false);
        jLabelErrorNomSoc.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                jLabelErrorNomSocFocusLost(evt);
            }
        });

        jLabelErrorMed.setForeground(new java.awt.Color(255, 0, 0));
        jLabelErrorMed.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabelErrorMed.setText("Nombre inválido");
        jLabelErrorMed.setFocusable(false);

        javax.swing.GroupLayout jPanelEstadisticasLayout = new javax.swing.GroupLayout(jPanelEstadisticas);
        jPanelEstadisticas.setLayout(jPanelEstadisticasLayout);
        jPanelEstadisticasLayout.setHorizontalGroup(
            jPanelEstadisticasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelEstadisticasLayout.createSequentialGroup()
                .addGroup(jPanelEstadisticasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel9, javax.swing.GroupLayout.DEFAULT_SIZE, 121, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanelEstadisticasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(txtSociedad, javax.swing.GroupLayout.DEFAULT_SIZE, 132, Short.MAX_VALUE)
                    .addComponent(txtMedico))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanelEstadisticasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabelErrorNomSoc)
                    .addComponent(jLabelErrorMed)))
        );
        jPanelEstadisticasLayout.setVerticalGroup(
            jPanelEstadisticasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelEstadisticasLayout.createSequentialGroup()
                .addContainerGap(19, Short.MAX_VALUE)
                .addGroup(jPanelEstadisticasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtSociedad, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabelErrorNomSoc, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanelEstadisticasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtMedico, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabelErrorMed, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanelEstadisticas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanelDatos, javax.swing.GroupLayout.PREFERRED_SIZE, 351, javax.swing.GroupLayout.PREFERRED_SIZE)))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanelDatos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanelEstadisticas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnAceptarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAceptarActionPerformed
        boolean error = false;
        String[] aux = new String[4];
        aux[0] = txtNombre.getText();
        if (modelo.noContieneCaracterAlfabetico(aux[0])) {
            jLabelErrorNombre.setVisible(error = true);
        }
        aux[1] = txtCedula.getText();
        if (modelo.esCedulaInvalida(aux[1])) {
            jLabelErrorCedula.setVisible(error = true);
        }
        aux[2] = txtSociedad.getText();
        if (modelo.noContieneCaracterAlfabetico(aux[2])) {
            jLabelErrorNomSoc.setVisible(error = true);
        }
        aux[3] = txtMedico.getText();
        if (modelo.noContieneCaracterAlfabetico(aux[3])) {
            jLabelErrorMed.setVisible(error = true);
        }
        Calendar c = jDateChooserNac.getCalendar();
        if (!modelo.esFechaNacimientoValida(c)) {
            jLabelErrorFecha.setVisible(error = true);
        }
        if (!error) {
            try {
                if (edicion) {
                    modelo.modificarHijo(aux[0], c,
                            jComboBoxGenero.getSelectedIndex() == 0, aux[1],
                            aux[2], aux[3], cedulaAnt);
                } else {
                    modelo.agregarHijo(aux[0], c,
                            jComboBoxGenero.getSelectedIndex() == 0, aux[1], aux[2], aux[3]);
                }
            } catch (IllegalArgumentException | IllegalStateException e) {
                JOptionPane.showMessageDialog(this, "Error", "Los datos ingresados "
                        + "corresponden a un hijo ya ingresado.", JOptionPane.ERROR_MESSAGE);
            }
        } else {
            JOptionPane.showMessageDialog(this, "Error", VentanaPrincipal.ERR_INGRESO,
                    JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_btnAceptarActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        this.dispose();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void txtNombreFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtNombreFocusLost
        jLabelErrorNombre.setVisible(modelo.noContieneCaracterAlfabetico(txtNombre.getText()));
    }//GEN-LAST:event_txtNombreFocusLost

    private void txtMedicoFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtMedicoFocusLost
        jLabelErrorMed.setVisible(modelo.noContieneCaracterAlfabetico(txtMedico.getText()));
    }//GEN-LAST:event_txtMedicoFocusLost

    private void jDateChooserNacFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jDateChooserNacFocusLost
        jLabelErrorFecha.setVisible(!modelo.esFechaNacimientoValida(jDateChooserNac.getCalendar()));
    }//GEN-LAST:event_jDateChooserNacFocusLost

    private void jLabelErrorNomSocFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jLabelErrorNomSocFocusLost
        jLabelErrorNomSoc.setVisible(modelo.noContieneCaracterAlfabetico(txtSociedad.getText()));
    }//GEN-LAST:event_jLabelErrorNomSocFocusLost

    private void jLabelErrorCedulaFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jLabelErrorCedulaFocusLost
        jLabelErrorCedula.setVisible(modelo.esCedulaInvalida(txtCedula.getText()));
    }//GEN-LAST:event_jLabelErrorCedulaFocusLost

    private void txtCedulaKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtCedulaKeyTyped
        char caracter = evt.getKeyChar();
        if (!Character.isDigit(caracter) && caracter != '-' && caracter != '.'
                && caracter != KeyEvent.VK_BACK_SPACE) {
            evt.consume();
        }
    }//GEN-LAST:event_txtCedulaKeyTyped

    private void txtNombreKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtNombreKeyTyped
        validarEntradaAlfabetica(evt);
    }//GEN-LAST:event_txtNombreKeyTyped

    private void txtMedicoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtMedicoKeyTyped
        validarEntradaAlfabetica(evt);
    }//GEN-LAST:event_txtMedicoKeyTyped

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAceptar;
    private javax.swing.JButton jButton1;
    private javax.swing.JComboBox jComboBoxGenero;
    private com.toedter.calendar.JDateChooser jDateChooserNac;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JLabel jLabelErrorCedula;
    private javax.swing.JLabel jLabelErrorFecha;
    private javax.swing.JLabel jLabelErrorMed;
    private javax.swing.JLabel jLabelErrorNomSoc;
    private javax.swing.JLabel jLabelErrorNombre;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanelDatos;
    private javax.swing.JPanel jPanelEstadisticas;
    private javax.swing.JTextField txtCedula;
    private javax.swing.JTextField txtMedico;
    private javax.swing.JTextField txtNombre;
    private javax.swing.JTextField txtSociedad;
    // End of variables declaration//GEN-END:variables
    private final Sistema modelo;
    private final boolean edicion;
    private String cedulaAnt;

    private void validarEntradaAlfabetica(KeyEvent evt) {
        char caracter = evt.getKeyChar();
        if (!Character.isAlphabetic(caracter) && caracter != ' ' && caracter != '-'
                && caracter != KeyEvent.VK_BACK_SPACE) {
            evt.consume();
        }
    }
}
