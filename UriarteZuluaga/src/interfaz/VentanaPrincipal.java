package interfaz;

import dominio.Sistema;
import java.awt.Color;
import java.io.File;
import java.io.IOException;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;

public class VentanaPrincipal extends javax.swing.JFrame {

    public static final String ERR_INGRESO = "Se detectaron errores en los datos "
            + "ingresados, reintente.";
    public static final Color niñoOsc = new Color(60, 154, 40);
    public static final Color niñoClaro = new Color(135, 186, 19);
    public static final Color Amarillo = new Color(233, 224, 40);
    public static final Color niña = new Color(246, 168, 40);
    
    public VentanaPrincipal(Sistema sis) {
        this.modelo = sis;
        initComponents();
        setExtendedState(MAXIMIZED_BOTH);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jProgressBar1 = new javax.swing.JProgressBar();
        buttonGroupHijos = new javax.swing.ButtonGroup();
        jPanel1 = new javax.swing.JPanel();
        btnAgregarHijo = new javax.swing.JButton();
        btnEditarHijo = new javax.swing.JButton();
        jSeparator1 = new javax.swing.JSeparator();
        jSeparator2 = new javax.swing.JSeparator();
        btnEliminarHijo = new javax.swing.JButton();
        jSeparator3 = new javax.swing.JSeparator();
        panelBotonesHijos = new javax.swing.JScrollPane();
        jPanel3 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jCalendar1 = new com.toedter.calendar.JCalendar();
        jLabel1 = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();
        jLabel2 = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        jTextArea2 = new javax.swing.JTextArea();
        jLabel3 = new javax.swing.JLabel();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu3 = new javax.swing.JMenu();
        itemCargarVacunas = new javax.swing.JMenuItem();
        jSeparator7 = new javax.swing.JPopupMenu.Separator();
        mnuSalir = new javax.swing.JMenuItem();
        jMenu1 = new javax.swing.JMenu();
        opcRegistrarCarne = new javax.swing.JMenuItem();
        opcModificarRegistro = new javax.swing.JMenuItem();
        opcEliminarCarne = new javax.swing.JMenuItem();
        jSeparator4 = new javax.swing.JPopupMenu.Separator();
        mnuEventos = new javax.swing.JMenu();
        opcRegistrarEvento = new javax.swing.JMenuItem();
        opcModificarEvento = new javax.swing.JMenuItem();
        opcEliminarEvento = new javax.swing.JMenuItem();
        jSeparator8 = new javax.swing.JPopupMenu.Separator();
        jMenu2 = new javax.swing.JMenu();
        opcGraficaPeso = new javax.swing.JMenuItem();
        jSeparator6 = new javax.swing.JPopupMenu.Separator();
        opcGraficaAltura = new javax.swing.JMenuItem();
        jSeparator5 = new javax.swing.JPopupMenu.Separator();
        opcGraficaPerimetroCefalico = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(0, 153, 255));

        jPanel1.setBackground(new java.awt.Color(60, 154, 40));
        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        btnAgregarHijo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/interfaz/imagenes/plus-icon.png"))); // NOI18N
        btnAgregarHijo.setToolTipText("Agregar nuevo jugador");
        btnAgregarHijo.setFocusable(false);
        btnAgregarHijo.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnAgregarHijo.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnAgregarHijo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgregarHijoActionPerformed(evt);
            }
        });

        btnEditarHijo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/interfaz/imagenes/textfield-rename-icon.png"))); // NOI18N
        btnEditarHijo.setToolTipText("Ver propiedades");
        btnEditarHijo.setEnabled(false);
        btnEditarHijo.setFocusable(false);
        btnEditarHijo.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnEditarHijo.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnEditarHijo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditarHijoActionPerformed(evt);
            }
        });

        jSeparator1.setOrientation(javax.swing.SwingConstants.VERTICAL);

        jSeparator2.setOrientation(javax.swing.SwingConstants.VERTICAL);

        btnEliminarHijo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/interfaz/imagenes/edit_delete.png"))); // NOI18N
        btnEliminarHijo.setToolTipText("Eliminar jugadores seleccionados");
        btnEliminarHijo.setEnabled(false);
        btnEliminarHijo.setFocusable(false);
        btnEliminarHijo.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnEliminarHijo.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnEliminarHijo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarHijoActionPerformed(evt);
            }
        });

        panelBotonesHijos.setBackground(new java.awt.Color(135, 186, 19));
        panelBotonesHijos.setBorder(null);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(6, 6, 6)
                .addComponent(btnAgregarHijo, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 2, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnEditarHijo, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnEliminarHijo, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(158, Short.MAX_VALUE))
            .addComponent(jSeparator3)
            .addComponent(panelBotonesHijos)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(31, 31, 31)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnEliminarHijo, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(btnEditarHijo, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                        .addComponent(jSeparator2)
                        .addComponent(jSeparator1)
                        .addComponent(btnAgregarHijo, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator3, javax.swing.GroupLayout.PREFERRED_SIZE, 3, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(panelBotonesHijos))
        );

        jPanel3.setBackground(new java.awt.Color(60, 154, 40));

        jPanel2.setBackground(new java.awt.Color(135, 186, 19));
        jPanel2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(51, 51, 51)));

        jCalendar1.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jCalendar1.setDecorationBackgroundColor(new java.awt.Color(233, 224, 40));

        jLabel1.setFont(new java.awt.Font("Calibri", 1, 24)); // NOI18N
        jLabel1.setText("Calendario de eventos:");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jCalendar1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(0, 120, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(48, 48, 48)
                .addComponent(jLabel1)
                .addGap(41, 41, 41)
                .addComponent(jCalendar1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(24, 24, 24))
        );

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        jPanel4.setBackground(new java.awt.Color(135, 186, 19));

        jTextArea1.setEditable(false);
        jTextArea1.setColumns(20);
        jTextArea1.setRows(5);
        jScrollPane2.setViewportView(jTextArea1);

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel2.setText("Día seleccionado:");

        jTextArea2.setEditable(false);
        jTextArea2.setColumns(20);
        jTextArea2.setRows(5);
        jScrollPane3.setViewportView(jTextArea2);

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel3.setText("Eventos próximos:");

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2)
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 183, Short.MAX_VALUE)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(jLabel3))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 157, Short.MAX_VALUE)
                .addGap(38, 38, 38)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 157, Short.MAX_VALUE)
                .addGap(27, 27, 27))
        );

        jMenu3.setText("Opciones");

        itemCargarVacunas.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_A, java.awt.event.InputEvent.CTRL_MASK));
        itemCargarVacunas.setText("Cargar Vacunas");
        itemCargarVacunas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                itemCargarVacunasActionPerformed(evt);
            }
        });
        jMenu3.add(itemCargarVacunas);
        jMenu3.add(jSeparator7);

        mnuSalir.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_E, java.awt.event.InputEvent.CTRL_MASK));
        mnuSalir.setText("Salir");
        mnuSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnuSalirActionPerformed(evt);
            }
        });
        jMenu3.add(mnuSalir);

        jMenuBar1.add(jMenu3);

        jMenu1.setText("Carnés");

        opcRegistrarCarne.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_F2, 0));
        opcRegistrarCarne.setText("Registrar Carné");
        opcRegistrarCarne.setToolTipText("Crear un juego nuevo");
        opcRegistrarCarne.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                opcRegistrarCarneActionPerformed(evt);
            }
        });
        jMenu1.add(opcRegistrarCarne);

        opcModificarRegistro.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_F3, 0));
        opcModificarRegistro.setText("Modificar Registro");
        opcModificarRegistro.setEnabled(false);
        opcModificarRegistro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                opcModificarRegistroActionPerformed(evt);
            }
        });
        jMenu1.add(opcModificarRegistro);

        opcEliminarCarne.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_F4, 0));
        opcEliminarCarne.setText("Eliminar Carné");
        opcEliminarCarne.setEnabled(false);
        opcEliminarCarne.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                opcEliminarCarneActionPerformed(evt);
            }
        });
        jMenu1.add(opcEliminarCarne);
        jMenu1.add(jSeparator4);

        jMenuBar1.add(jMenu1);

        mnuEventos.setText("Eventos");
        mnuEventos.setEnabled(false);

        opcRegistrarEvento.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_F2, 0));
        opcRegistrarEvento.setText("Registrar Evento");
        opcRegistrarEvento.setToolTipText("Crear un juego nuevo");
        opcRegistrarEvento.setEnabled(false);
        opcRegistrarEvento.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                opcRegistrarEventoActionPerformed(evt);
            }
        });
        mnuEventos.add(opcRegistrarEvento);

        opcModificarEvento.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_F3, 0));
        opcModificarEvento.setText("Modificar Evento");
        opcModificarEvento.setEnabled(false);
        opcModificarEvento.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                opcModificarEventoActionPerformed(evt);
            }
        });
        mnuEventos.add(opcModificarEvento);

        opcEliminarEvento.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_F4, 0));
        opcEliminarEvento.setText("Eliminar Evento");
        opcEliminarEvento.setEnabled(false);
        opcEliminarEvento.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                opcEliminarEventoActionPerformed(evt);
            }
        });
        mnuEventos.add(opcEliminarEvento);
        mnuEventos.add(jSeparator8);

        jMenuBar1.add(mnuEventos);

        jMenu2.setText("Gráficas");

        opcGraficaPeso.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_F1, 0));
        opcGraficaPeso.setText("Peso");
        jMenu2.add(opcGraficaPeso);
        jMenu2.add(jSeparator6);

        opcGraficaAltura.setText("Altura");
        opcGraficaAltura.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                opcGraficaAlturaActionPerformed(evt);
            }
        });
        jMenu2.add(opcGraficaAltura);
        jMenu2.add(jSeparator5);

        opcGraficaPerimetroCefalico.setText("Perímetro Cefálico");
        opcGraficaPerimetroCefalico.setToolTipText("El hijo seleccionado no es bebé");
        jMenu2.add(opcGraficaPerimetroCefalico);

        jMenuBar1.add(jMenu2);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel4, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnEditarHijoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditarHijoActionPerformed
        modificarHijoSeleccionado();
    }//GEN-LAST:event_btnEditarHijoActionPerformed

    private int getPosHijoSeleccionado() {
        //TODO
        return 0;
    }

    private void btnAgregarHijoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregarHijoActionPerformed
        VentanaCrearHijo v = new VentanaCrearHijo(modelo, null, false);
        v.setLocationRelativeTo(this);
        v.setVisible(true);
    }//GEN-LAST:event_btnAgregarHijoActionPerformed

    private void mnuSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnuSalirActionPerformed
        this.dispose();
    }//GEN-LAST:event_mnuSalirActionPerformed

    private void opcGraficaAlturaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_opcGraficaAlturaActionPerformed

    }//GEN-LAST:event_opcGraficaAlturaActionPerformed

    private void opcModificarRegistroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_opcModificarRegistroActionPerformed
        modificarHijoSeleccionado();
    }//GEN-LAST:event_opcModificarRegistroActionPerformed

    private void opcEliminarCarneActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_opcEliminarCarneActionPerformed
        eliminarHijoSeleccionado();
    }//GEN-LAST:event_opcEliminarCarneActionPerformed

    private void opcRegistrarCarneActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_opcRegistrarCarneActionPerformed
        registrarHijo();
    }//GEN-LAST:event_opcRegistrarCarneActionPerformed

    private void itemCargarVacunasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_itemCargarVacunasActionPerformed
        boolean aux;
        do {
            JFileChooser fc = new JFileChooser();
            fc.setCurrentDirectory(new File("/"));
            fc.setFileFilter(new FileNameExtensionFilter("Archivo de texto", "txt"));
            int respuesta = fc.showOpenDialog(this);
            aux = respuesta == JFileChooser.APPROVE_OPTION;
            if (aux) {
                try {
                    modelo.cargarVacunasDeArchivo(fc.getSelectedFile().getAbsolutePath());
                    aux = false;
                } catch (IOException | IllegalArgumentException e) {
                    JOptionPane.showMessageDialog(this, e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        } while (aux);
    }//GEN-LAST:event_itemCargarVacunasActionPerformed

    private void btnEliminarHijoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarHijoActionPerformed
        eliminarHijoSeleccionado();
    }//GEN-LAST:event_btnEliminarHijoActionPerformed

    private void opcRegistrarEventoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_opcRegistrarEventoActionPerformed
        VentanaCrearEvento v = new VentanaCrearEvento(modelo, -1);
        v.setLocationRelativeTo(this);
        v.setVisible(true);
        //if()
        //TODO
    }//GEN-LAST:event_opcRegistrarEventoActionPerformed

    private void opcModificarEventoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_opcModificarEventoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_opcModificarEventoActionPerformed

    private void opcEliminarEventoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_opcEliminarEventoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_opcEliminarEventoActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAgregarHijo;
    private javax.swing.JButton btnEditarHijo;
    private javax.swing.JButton btnEliminarHijo;
    private javax.swing.ButtonGroup buttonGroupHijos;
    private javax.swing.JMenuItem itemCargarVacunas;
    private com.toedter.calendar.JCalendar jCalendar1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenu jMenu3;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JProgressBar jProgressBar1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JPopupMenu.Separator jSeparator4;
    private javax.swing.JPopupMenu.Separator jSeparator5;
    private javax.swing.JPopupMenu.Separator jSeparator6;
    private javax.swing.JPopupMenu.Separator jSeparator7;
    private javax.swing.JPopupMenu.Separator jSeparator8;
    private javax.swing.JTextArea jTextArea1;
    private javax.swing.JTextArea jTextArea2;
    private javax.swing.JMenu mnuEventos;
    private javax.swing.JMenuItem mnuSalir;
    private javax.swing.JMenuItem opcEliminarCarne;
    private javax.swing.JMenuItem opcEliminarEvento;
    private javax.swing.JMenuItem opcGraficaAltura;
    private javax.swing.JMenuItem opcGraficaPerimetroCefalico;
    private javax.swing.JMenuItem opcGraficaPeso;
    private javax.swing.JMenuItem opcModificarEvento;
    private javax.swing.JMenuItem opcModificarRegistro;
    private javax.swing.JMenuItem opcRegistrarCarne;
    private javax.swing.JMenuItem opcRegistrarEvento;
    private javax.swing.JScrollPane panelBotonesHijos;
    // End of variables declaration//GEN-END:variables
    private final Sistema modelo;

    private void modificarHijoSeleccionado() {
        try {
            VentanaCrearHijo v = new VentanaCrearHijo(modelo,
                    modelo.getHijo(getPosHijoSeleccionado()), true);
            v.setLocationRelativeTo(this);
            v.setVisible(true);
        } catch (IndexOutOfBoundsException e) {
            JOptionPane.showMessageDialog(this, "Error al intentar acceder a "
                    + "los datos de un hijo.", "Error", JOptionPane.ERROR_MESSAGE);
            System.out.println(e.getMessage());
        }
    }

    private void registrarHijo() {
        VentanaCrearHijo v = new VentanaCrearHijo(modelo, null, false);
        v.setLocationRelativeTo(this);
        v.setVisible(true);
        if (modelo.getCantidadHijos() > 0) {
            opcModificarRegistro.setEnabled(true);
            opcEliminarCarne.setEnabled(true);
            btnEditarHijo.setEnabled(true);
            btnEliminarHijo.setEnabled(true);
            mnuEventos.setEnabled(true);
            opcRegistrarEvento.setEnabled(true);
        }
    }

    private void eliminarHijoSeleccionado() {
        int opcion = JOptionPane.showConfirmDialog(this, "¿Está seguro/a que desea eliminar al "
                + "carné seleccionado?", "Confirme su selección",
                JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
        if (opcion == JOptionPane.YES_OPTION) {
            modelo.eliminarHijoPorPos(getPosHijoSeleccionado());
            JOptionPane.showMessageDialog(this, "El registro se ha borrado exiitosamente"
                    + "del programa.", "Operación completada", JOptionPane.INFORMATION_MESSAGE);
            if (modelo.getCantidadHijos() == 0) {
                opcModificarRegistro.setEnabled(false);
                opcEliminarCarne.setEnabled(false);
                btnEditarHijo.setEnabled(false);
                btnEliminarHijo.setEnabled(false);
            }
        }
    }
}
