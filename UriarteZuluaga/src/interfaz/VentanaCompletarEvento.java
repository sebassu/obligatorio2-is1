package interfaz;

import auxiliar.Auxiliares;
import dominio.Evento;
import dominio.Hijo;
import dominio.Sistema;
import java.awt.event.KeyEvent;
import java.util.Calendar;
import javax.swing.JOptionPane;

public class VentanaCompletarEvento extends javax.swing.JFrame {

    public VentanaCompletarEvento(Sistema sis, int pos) {
        this.modelo = sis;
        this.posEventoACompletar = pos;
        Evento eventoACompletar = modelo.getEvento(pos);
        switch (eventoACompletar.getTipo()) {
            case "Consulta":
                if (!eventoACompletar.getCualHijo().esBebe()) {
                    jLabelPerimetroCefalico.setVisible(false);
                    txtPerimetroCefalico.setVisible(false);
                }
                break;
            default:
                jLabelPeso.setVisible(false);
                jLabelAltura.setVisible(false);
                jLabelPerimetroCefalico.setVisible(false);
                txtPeso.setVisible(false);
                txtAltura.setVisible(false);
                txtPerimetroCefalico.setVisible(false);
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
        jScrollPane1 = new javax.swing.JScrollPane();
        textAreaNotas = new javax.swing.JTextArea();
        filler1 = new javax.swing.Box.Filler(new java.awt.Dimension(0, 0), new java.awt.Dimension(0, 0), new java.awt.Dimension(32767, 0));
        txtPeso = new javax.swing.JTextField();
        txtAltura = new javax.swing.JTextField();
        txtPerimetroCefalico = new javax.swing.JTextField();
        jLabelPeso = new javax.swing.JLabel();
        jLabelAltura = new javax.swing.JLabel();
        jLabelPerimetroCefalico = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Registro de Hijo");
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
                .addContainerGap(272, Short.MAX_VALUE)
                .addComponent(btnAceptar)
                .addGap(18, 18, 18)
                .addComponent(jButtonCerrar, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE)
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

        textAreaNotas.setColumns(20);
        textAreaNotas.setRows(5);
        textAreaNotas.setBorder(javax.swing.BorderFactory.createTitledBorder("Notas"));
        jScrollPane1.setViewportView(textAreaNotas);

        txtPeso.setToolTipText("Medido en kilogramos");
        txtPeso.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtPesoKeyPressed(evt);
            }
        });

        txtAltura.setToolTipText("Medida en centímetros");
        txtAltura.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtAlturaKeyPressed(evt);
            }
        });

        txtPerimetroCefalico.setToolTipText("Medido en centímetros");
        txtPerimetroCefalico.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtPerimetroCefalicoKeyPressed(evt);
            }
        });

        jLabelPeso.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabelPeso.setLabelFor(txtPeso);
        jLabelPeso.setText("Peso (kg):");

        jLabelAltura.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabelAltura.setLabelFor(txtAltura);
        jLabelAltura.setText("Altura (cm):");

        jLabelPerimetroCefalico.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabelPerimetroCefalico.setLabelFor(txtPerimetroCefalico);
        jLabelPerimetroCefalico.setText("Perímetro cefálico (cm):");

        javax.swing.GroupLayout jPanelDatosLayout = new javax.swing.GroupLayout(jPanelDatos);
        jPanelDatos.setLayout(jPanelDatosLayout);
        jPanelDatosLayout.setHorizontalGroup(
            jPanelDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(filler1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanelDatosLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1)
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelDatosLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanelDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabelPeso, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabelAltura, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabelPerimetroCefalico, javax.swing.GroupLayout.Alignment.TRAILING))
                .addGap(18, 18, 18)
                .addGroup(jPanelDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtAltura, javax.swing.GroupLayout.PREFERRED_SIZE, 219, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtPerimetroCefalico, javax.swing.GroupLayout.PREFERRED_SIZE, 219, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtPeso, javax.swing.GroupLayout.PREFERRED_SIZE, 219, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(65, 65, 65))
        );
        jPanelDatosLayout.setVerticalGroup(
            jPanelDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelDatosLayout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addComponent(filler1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 243, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addGroup(jPanelDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtPeso, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabelPeso))
                .addGap(17, 17, 17)
                .addGroup(jPanelDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtAltura, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabelAltura))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanelDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtPerimetroCefalico, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabelPerimetroCefalico))
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
                .addComponent(jPanelDatos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
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
                .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, 409, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnAceptarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAceptarActionPerformed
        try {
            Evento eventoACompletar = modelo.getEvento(posEventoACompletar);
            eventoACompletar.setFecha(Calendar.getInstance());
            int mesesDesdeNacimiento = Auxiliares.mesesDesdeLaFecha(eventoACompletar.getFecha());
            switch (eventoACompletar.getTipo()) {
                case "Consulta":
                    Hijo h = eventoACompletar.getCualHijo();
                    if (eventoACompletar.getCualHijo().esBebe()) {
                        h.agregarPerimetroCefalico(Double.parseDouble(txtPerimetroCefalico.getText()),
                                mesesDesdeNacimiento);
                    }
                    h.agregarAltura(Double.parseDouble(txtAltura.getText()), mesesDesdeNacimiento);
                    h.agregarPeso(Double.parseDouble(txtPeso.getText()), mesesDesdeNacimiento);     //Falta break; adrede.
                default:
                    eventoACompletar.setNotas(textAreaNotas.getText().trim());
                    break;
            }
            JOptionPane.showMessageDialog(this, "El evento se ha completado exitosamente "
                    + "en el sistema.", "Operación completada",
                    JOptionPane.INFORMATION_MESSAGE);
            modelo.darDeBajaEvento(posEventoACompletar);
        } catch (NumberFormatException | NullPointerException e) {
            JOptionPane.showMessageDialog(this, "Error", VentanaPrincipal.ERR_INGRESO
                    + "\nError detectado: " + e.getMessage(), JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_btnAceptarActionPerformed

    private void jButtonCerrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonCerrarActionPerformed
        this.dispose();
    }//GEN-LAST:event_jButtonCerrarActionPerformed

    private void txtPesoKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtPesoKeyPressed
        BorrarNoNumeros(evt);
    }//GEN-LAST:event_txtPesoKeyPressed

    private void txtAlturaKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtAlturaKeyPressed
        BorrarNoNumeros(evt);
    }//GEN-LAST:event_txtAlturaKeyPressed

    private void txtPerimetroCefalicoKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtPerimetroCefalicoKeyPressed
        BorrarNoNumeros(evt);
    }//GEN-LAST:event_txtPerimetroCefalicoKeyPressed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAceptar;
    private javax.swing.Box.Filler filler1;
    private javax.swing.JButton jButtonCerrar;
    private javax.swing.JLabel jLabelAltura;
    private javax.swing.JLabel jLabelPerimetroCefalico;
    private javax.swing.JLabel jLabelPeso;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanelDatos;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextArea textAreaNotas;
    private javax.swing.JTextField txtAltura;
    private javax.swing.JTextField txtPerimetroCefalico;
    private javax.swing.JTextField txtPeso;
    // End of variables declaration//GEN-END:variables
    private final Sistema modelo;
    private final int posEventoACompletar;

    private void BorrarNoNumeros(KeyEvent evt) {
        char caracter = evt.getKeyChar();
        if (!Character.isDigit(caracter) && caracter != '.' && caracter
                != KeyEvent.VK_BACK_SPACE) {
            evt.consume();
        }
    }
}
