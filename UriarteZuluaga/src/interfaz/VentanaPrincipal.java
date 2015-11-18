package interfaz;

import auxiliar.Auxiliares;
import com.toedter.calendar.JDayChooser;
import dominio.Evento;
import dominio.Hijo;
import dominio.Sistema;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Enumeration;
import javax.swing.AbstractButton;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JToggleButton;
import javax.swing.UIManager;
import javax.swing.filechooser.FileNameExtensionFilter;

public class VentanaPrincipal extends javax.swing.JFrame {

    public static final String ERR_INGRESO = "Se detectaron errores en los datos "
            + "ingresados, reintente\nError detectado: ";

    public static final Color niñoOsc = new Color(60, 154, 40);
    public static final Color niñoClaro = new Color(135, 186, 19);
    public static final Color Amarillo = new Color(233, 224, 40);
    public static final Color niñaOsc = new Color(246, 168, 40);
    public static final Color niñaClaro = new Color(255, 204, 40);

    public VentanaPrincipal(Sistema sis) {
        this.modelo = sis;
        initComponents();
        setExtendedState(MAXIMIZED_BOTH);
        if (activarOpcionesQueRequierenHijos()) {
            activarOpcionesModificacionEventos();
        }
        panelHijos.setLayout(new BoxLayout(panelHijos, BoxLayout.Y_AXIS));
        panelEventosProximos.setLayout(new BoxLayout(panelEventosProximos, BoxLayout.Y_AXIS));
        cargarPanelHijos();
        cargarPanelEventosProximos();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroupHijos = new javax.swing.ButtonGroup();
        buttonGroupEventos = new javax.swing.ButtonGroup();
        jPanel1 = new javax.swing.JPanel();
        btnAgregarHijo = new javax.swing.JButton();
        btnEditarHijo = new javax.swing.JButton();
        jSeparator1 = new javax.swing.JSeparator();
        jSeparator2 = new javax.swing.JSeparator();
        btnEliminarHijo = new javax.swing.JButton();
        jSeparator3 = new javax.swing.JSeparator();
        panelScrolleable = new javax.swing.JScrollPane();
        panelHijos = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jCalendar1 = new com.toedter.calendar.JCalendar();
        jLabel1 = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        panelDiaSeleccionado = new javax.swing.JPanel();
        jScrollPane5 = new javax.swing.JScrollPane();
        jScrollPane6 = new javax.swing.JScrollPane();
        panelEventosProximos = new javax.swing.JPanel();
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
        jSeparator9 = new javax.swing.JPopupMenu.Separator();
        jMenuItem1 = new javax.swing.JMenuItem();
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

        panelScrolleable.setBackground(new java.awt.Color(135, 186, 19));
        panelScrolleable.setBorder(null);

        panelHijos.setBackground(new java.awt.Color(236, 236, 240));

        javax.swing.GroupLayout panelHijosLayout = new javax.swing.GroupLayout(panelHijos);
        panelHijos.setLayout(panelHijosLayout);
        panelHijosLayout.setHorizontalGroup(
            panelHijosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 261, Short.MAX_VALUE)
        );
        panelHijosLayout.setVerticalGroup(
            panelHijosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 386, Short.MAX_VALUE)
        );

        panelScrolleable.setViewportView(panelHijos);

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
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addComponent(jSeparator3)
            .addComponent(panelScrolleable)
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
                .addComponent(panelScrolleable))
        );

        jPanel3.setBackground(new java.awt.Color(60, 154, 40));

        jPanel2.setBackground(new java.awt.Color(135, 186, 19));
        jPanel2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(51, 51, 51)));

        jCalendar1.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jCalendar1.setDecorationBackgroundColor(new java.awt.Color(233, 224, 40));
        jCalendar1.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N

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
                        .addGap(0, 138, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(48, 48, 48)
                .addComponent(jLabel1)
                .addGap(26, 26, 26)
                .addComponent(jCalendar1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(39, 39, 39))
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

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel2.setText("Día seleccionado:");

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel3.setText("Eventos próximos:");

        panelDiaSeleccionado.setBackground(new java.awt.Color(236, 236, 240));

        javax.swing.GroupLayout panelDiaSeleccionadoLayout = new javax.swing.GroupLayout(panelDiaSeleccionado);
        panelDiaSeleccionado.setLayout(panelDiaSeleccionadoLayout);
        panelDiaSeleccionadoLayout.setHorizontalGroup(
            panelDiaSeleccionadoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 163, Short.MAX_VALUE)
        );
        panelDiaSeleccionadoLayout.setVerticalGroup(
            panelDiaSeleccionadoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 186, Short.MAX_VALUE)
        );

        jScrollPane1.setViewportView(panelDiaSeleccionado);

        panelEventosProximos.setBackground(new java.awt.Color(236, 236, 240));

        javax.swing.GroupLayout panelEventosProximosLayout = new javax.swing.GroupLayout(panelEventosProximos);
        panelEventosProximos.setLayout(panelEventosProximosLayout);
        panelEventosProximosLayout.setHorizontalGroup(
            panelEventosProximosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 161, Short.MAX_VALUE)
        );
        panelEventosProximosLayout.setVerticalGroup(
            panelEventosProximosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 178, Short.MAX_VALUE)
        );

        jScrollPane6.setViewportView(panelEventosProximos);

        jScrollPane5.setViewportView(jScrollPane6);

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jScrollPane5)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel4Layout.createSequentialGroup()
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3)
                            .addComponent(jLabel2))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(jLabel3)
                .addGap(2, 2, 2)
                .addComponent(jScrollPane5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1)
                .addContainerGap())
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
        opcRegistrarCarne.setToolTipText("Crear un carné nuevo");
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

        opcEliminarCarne.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_DELETE, 0));
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

        opcRegistrarEvento.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_F6, 0));
        opcRegistrarEvento.setText("Registrar Evento");
        opcRegistrarEvento.setToolTipText("Crear un evento nuevo");
        opcRegistrarEvento.setEnabled(false);
        opcRegistrarEvento.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                opcRegistrarEventoActionPerformed(evt);
            }
        });
        mnuEventos.add(opcRegistrarEvento);

        opcModificarEvento.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_F7, 0));
        opcModificarEvento.setText("Modificar Evento");
        opcModificarEvento.setToolTipText("");
        opcModificarEvento.setEnabled(false);
        opcModificarEvento.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                opcModificarEventoActionPerformed(evt);
            }
        });
        mnuEventos.add(opcModificarEvento);

        opcEliminarEvento.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_DELETE, java.awt.event.InputEvent.CTRL_MASK));
        opcEliminarEvento.setText("Eliminar Evento");
        opcEliminarEvento.setEnabled(false);
        opcEliminarEvento.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                opcEliminarEventoActionPerformed(evt);
            }
        });
        mnuEventos.add(opcEliminarEvento);
        mnuEventos.add(jSeparator9);

        jMenuItem1.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_F9, 0));
        jMenuItem1.setText("Completar Evento");
        jMenuItem1.setEnabled(false);
        mnuEventos.add(jMenuItem1);

        jMenuBar1.add(mnuEventos);

        jMenu2.setText("Gráficas");

        opcGraficaPeso.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_1, java.awt.event.InputEvent.SHIFT_MASK));
        opcGraficaPeso.setText("Peso");
        jMenu2.add(opcGraficaPeso);
        jMenu2.add(jSeparator6);

        opcGraficaAltura.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_2, java.awt.event.InputEvent.SHIFT_MASK));
        opcGraficaAltura.setText("Altura");
        opcGraficaAltura.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                opcGraficaAlturaActionPerformed(evt);
            }
        });
        jMenu2.add(opcGraficaAltura);
        jMenu2.add(jSeparator5);

        opcGraficaPerimetroCefalico.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_3, java.awt.event.InputEvent.SHIFT_MASK));
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
        for (Enumeration<AbstractButton> botonesHijos = buttonGroupHijos.getElements(); botonesHijos.hasMoreElements();) {
            AbstractButton boton = botonesHijos.nextElement();
            if (boton.isSelected()) {
                return Integer.parseInt(boton.getName());
            }
        }
        return -1;
    }

    private int getPosEventoSeleccionado() {
        for (Enumeration<AbstractButton> botonesEventos = buttonGroupEventos.getElements(); botonesEventos.hasMoreElements();) {
            AbstractButton button = botonesEventos.nextElement();
            if (button.isSelected()) {
                return Integer.parseInt(button.getName());
            }
        }
        return -1;
    }

    private void btnAgregarHijoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregarHijoActionPerformed
        registrarHijo();
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
        VentanaCrearEvento v = new VentanaCrearEvento(modelo, -1, this);
        v.setLocationRelativeTo(this);
        v.setVisible(true);
    }//GEN-LAST:event_opcRegistrarEventoActionPerformed

    private void opcModificarEventoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_opcModificarEventoActionPerformed
        VentanaCrearEvento v = new VentanaCrearEvento(modelo, getPosEventoSeleccionado(), this);
        v.setLocationRelativeTo(this);
        v.setVisible(true);
        v.addWindowListener(new WindowListener() {
            @Override
            public void windowOpened(WindowEvent e) {
            }

            @Override
            public void windowClosing(WindowEvent e) {
                activarOpcionesModificacionEventos();
                cargarPanelEventosProximos();
            }

            @Override
            public void windowClosed(WindowEvent e) {
                activarOpcionesModificacionEventos();
                cargarPanelEventosProximos();
            }

            @Override
            public void windowIconified(WindowEvent e) {
            }

            @Override
            public void windowDeiconified(WindowEvent e) {
            }

            @Override
            public void windowActivated(WindowEvent e) {
            }

            @Override
            public void windowDeactivated(WindowEvent e) {
            }
        });
    }//GEN-LAST:event_opcModificarEventoActionPerformed

    private void opcEliminarEventoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_opcEliminarEventoActionPerformed
        int pos = getPosEventoSeleccionado();
        if (pos != -1 && pos < modelo.getCantidadEventosARealizar()) {
            int opcion = JOptionPane.showConfirmDialog(this, "¿Está seguro/a que desea eliminar al "
                    + "evento seleccionado?", "Confirme su selección",
                    JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
            if (opcion == JOptionPane.YES_OPTION) {
                modelo.eliminarEventoPorPos(pos);
                cargarPanelEventosProximos();
                JOptionPane.showMessageDialog(this, "El evento se ha borrado exitosamente"
                        + " del programa.", "Operación completada", JOptionPane.INFORMATION_MESSAGE);
                if (modelo.getCantidadEventosARealizar() == 0) {
                    opcModificarEvento.setEnabled(false);
                    opcEliminarEvento.setEnabled(false);
                }
            }
        } else {
            JOptionPane.showMessageDialog(this, "Debe seleccionar un evento válido para utilizar "
                    + "esta operación del programa.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_opcEliminarEventoActionPerformed

    private void modificarHijoSeleccionado() {
        int pos = getPosHijoSeleccionado();
        if (pos != -1 && pos < modelo.getCantidadHijos()) {
            VentanaCrearHijo v = new VentanaCrearHijo(modelo,
                    modelo.getHijo(getPosHijoSeleccionado()), true, this);
            v.setLocationRelativeTo(this);
            v.setVisible(true);
        } else {
            JOptionPane.showMessageDialog(this, "Debe seleccionar un hijo válido para utilizar "
                    + "esta operación del programa.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void registrarHijo() {
        VentanaCrearHijo v = new VentanaCrearHijo(modelo, null, false, this);
        v.setLocationRelativeTo(this);
        v.setVisible(true);
    }

    private void eliminarHijoSeleccionado() {
        int pos = getPosHijoSeleccionado();
        if (pos != -1 && pos < modelo.getCantidadHijos()) {
            int opcion = JOptionPane.showConfirmDialog(this, "¿Está seguro/a que desea eliminar al "
                    + "carné seleccionado?", "Confirme su selección",
                    JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
            if (opcion == JOptionPane.YES_OPTION) {
                modelo.eliminarHijoPorPos(getPosHijoSeleccionado());
                JOptionPane.showMessageDialog(this, "El registro se ha borrado exitosamente"
                        + " del programa.", "Operación completada", JOptionPane.INFORMATION_MESSAGE);
                cargarPanelHijos();
                if (modelo.getCantidadHijos() == 0) {
                    opcModificarRegistro.setEnabled(false);
                    opcEliminarCarne.setEnabled(false);
                    btnEditarHijo.setEnabled(false);
                    btnEliminarHijo.setEnabled(false);
                }
            }
        } else {
            JOptionPane.showMessageDialog(this, "Debe seleccionar un hijo válido para utilizar "
                    + "esta operación del programa.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    public final boolean activarOpcionesQueRequierenHijos() {
        boolean activar = modelo.getCantidadHijos() > 0;
        if (activar) {
            opcModificarRegistro.setEnabled(true);
            opcEliminarCarne.setEnabled(true);
            btnEditarHijo.setEnabled(true);
            btnEliminarHijo.setEnabled(true);
            mnuEventos.setEnabled(true);
            opcRegistrarEvento.setEnabled(true);
        }
        return activar;
    }

    public final void activarOpcionesModificacionEventos() {
        if (modelo.getCantidadEventosARealizar() > 0) {
            opcModificarEvento.setEnabled(true);
            opcEliminarEvento.setEnabled(true);
        }
    }

    public final void cargarPanelHijos() {
        panelHijos.removeAll();
        if (modelo.getCantidadHijos() == 0) {
            panelHijos.add(Box.createRigidArea(new Dimension(panelHijos.getWidth(), 45)));
            JLabel label = new JLabel("Sin Hijos a mostrar");
            label.setFont(new Font("Tahoma", Font.BOLD, 18));
            label.setAlignmentX(Component.CENTER_ALIGNMENT);
            panelHijos.add(label);
        } else {
            for (int i = 0; i < modelo.getCantidadHijos(); i++) {
                panelHijos.add(Box.createRigidArea(new Dimension(panelHijos.getWidth(), 25)));
                final Hijo h = modelo.getHijo(i);
                JToggleButton aux = new JToggleButton();
                aux.setAlignmentX(Component.CENTER_ALIGNMENT);
                aux.setBorderPainted(false);
                aux.setBackground((h.esHombre() ? niñoClaro : niñaClaro));
                aux.setFont(new Font("Tahoma", Font.BOLD, 14));
                aux.setText(h.getNombre());
                aux.setMinimumSize(new Dimension(panelHijos.getWidth(), 75));
                aux.setName("" + i);
                aux.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        repintarFondo(h.esHombre());
                    }
                });
                aux.setVisible(true);
                aux.setOpaque(true);
                panelHijos.add(aux);
                buttonGroupHijos.add(aux);
            }
        }
        panelHijos.validate();
        panelHijos.repaint();
        panelHijos.updateUI();
        panelHijos.setVisible(false);
        panelHijos.setVisible(true);
    }

    public final void cargarPanelEventosProximos() {
        panelEventosProximos.removeAll();
        if (modelo.getCantidadEventosARealizar() == 0) {
            panelEventosProximos.add(Box.createRigidArea(
                    new Dimension(panelEventosProximos.getWidth(), 45)));
            JLabel label = new JLabel("Sin Eventos a mostrar");
            label.setFont(new Font("Tahoma", Font.BOLD, 24));
            label.setAlignmentX(Component.CENTER_ALIGNMENT);
            panelEventosProximos.add(label);
        } else {
            for (int i = 0; i < modelo.getCantidadEventosARealizar(); i++) {
                Evento evento = modelo.getEvento(i);
                if (Auxiliares.caeEnEstaSemana(evento.getFecha())) {
                    panelEventosProximos.add(Box.createRigidArea(
                            new Dimension(panelEventosProximos.getWidth(), 20)));
                    JToggleButton aux = new JToggleButton();
                    aux.setBorderPainted(false);
                    aux.setAlignmentX(Component.CENTER_ALIGNMENT);
                    aux.setBackground(Color.red);
                    switch (evento.getTipo()) {
                        case "Consulta":
                            aux.setFont(new Font("Tahoma", Font.BOLD, 20));
                            break;
                        case "Vacunación":
                            aux.setFont(new Font("Tahoma", Font.ITALIC, 20));
                            break;
                        default:
                            aux.setFont(new Font("Tahoma", Font.PLAIN, 20));
                            break;
                    }
                    SimpleDateFormat formatoFecha = new SimpleDateFormat("dd-MM-yyyy");
                    aux.setText(evento.getTitulo() + " ("
                            + formatoFecha.format(evento.getFecha().getTime()) + ")");
                    aux.setMinimumSize(new Dimension(panelEventosProximos.getWidth(), 75));
                    aux.setName("" + i);
                    aux.setVisible(true);
                    aux.setOpaque(true);
                    panelEventosProximos.add(aux);
                    buttonGroupEventos.add(aux);
                }
            }
        }
        panelEventosProximos.validate();
        panelEventosProximos.repaint();
        panelEventosProximos.updateUI();
        panelEventosProximos.setVisible(false);
        panelEventosProximos.setVisible(true);
    }

    private void repintarFondo(boolean esHombre) {
        if (esHombre) {
            jPanel1.setBackground(niñoOsc);
            jPanel2.setBackground(niñoClaro);
            jPanel3.setBackground(niñoOsc);
            jPanel4.setBackground(niñoClaro);
        } else {
            jPanel1.setBackground(niñaOsc);
            jPanel2.setBackground(niñaClaro);
            jPanel3.setBackground(niñaOsc);
            jPanel4.setBackground(niñaClaro);
        }
    }

    public void pintarDia(Calendar laFecha, boolean agrego) {
        Component componentes[] = jCalendar1.getDayChooser().getDayPanel().getComponents();
        int i = 7;
        while (((JDayChooser) componentes[i]).getDay() < laFecha.get(Calendar.DAY_OF_MONTH)) {
            i++;
        }
        Component componente = componentes[i];
        int cantidadEventosDia;
        String[] aux = {};
        if (!componente.getName().equals("")) {
            cantidadEventosDia = 0;
        } else {
            aux = componente.getName().split(" - ");
            cantidadEventosDia = Integer.parseInt(aux[0].split(" ")[0]);
        }
        if (agrego) {
            cantidadEventosDia++;
            componente.setBackground(Color.magenta);
            componente.setForeground(Color.red);
            componente.setFont(new Font("Tahoma", Font.BOLD, 14));
        } else {
            if (--cantidadEventosDia == 0 && !(aux[1].split(" ")[0]).equals("0")) {
                componente.setBackground(Color.cyan);
                componente.setForeground(Color.blue);
                componente.setFont(new Font("Tahoma", Font.BOLD, 14));
            } else {
                componente.setBackground(UIManager.getColor("Panel.background"));
                componente.setFont(new Font("Tahoma", Font.PLAIN, 12));
            }
            componente.setName(cantidadEventosDia + " eventos - " + aux[1]);
        }
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAgregarHijo;
    private javax.swing.JButton btnEditarHijo;
    private javax.swing.JButton btnEliminarHijo;
    private javax.swing.ButtonGroup buttonGroupEventos;
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
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JPopupMenu.Separator jSeparator4;
    private javax.swing.JPopupMenu.Separator jSeparator5;
    private javax.swing.JPopupMenu.Separator jSeparator6;
    private javax.swing.JPopupMenu.Separator jSeparator7;
    private javax.swing.JPopupMenu.Separator jSeparator9;
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
    private javax.swing.JPanel panelDiaSeleccionado;
    private javax.swing.JPanel panelEventosProximos;
    private javax.swing.JPanel panelHijos;
    private javax.swing.JScrollPane panelScrolleable;
    // End of variables declaration//GEN-END:variables
    private final Sistema modelo;
}
