/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interfaz;

import auxiliar.Par;
import dominio.CarneVacunas;
import dominio.Hijo;
import dominio.Sistema;
import dominio.Vacuna;
import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Iterator;
import javax.swing.JButton;
import javax.swing.border.Border;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;

public class VentanaCarneVacunas extends javax.swing.JFrame {

    private JButton[][] botonesVacunasSistematicas;
    private JButton[][] botonesVacunasNoSistematicas;
    private final CarneVacunas infoCarne;

    public VentanaCarneVacunas(Sistema sis, Hijo hijoSeleccionado, Color amarillo,
            Color oscuro, Color claro) {
        initComponents();
        infoCarne = new CarneVacunas(sis.nombreVacunasSistematicasParaCarne(hijoSeleccionado),
                sis.nombreVacunasNoSistematicasParaCarne(hijoSeleccionado),
                sis.mesesParaCarneVacunas(hijoSeleccionado), sis.aniosParaCarneVacunas(hijoSeleccionado));
        formatearPanelVacunasSistematicas(amarillo, oscuro, claro);
        formatearPanelVacunasNoSistematicas(amarillo, oscuro, claro);
        marcarVacunasSistematicasDadas(hijoSeleccionado);
        marcarVacunasNoSistematicasDadas(hijoSeleccionado);
        recomendarNuevasVacunaciones(hijoSeleccionado, sis, oscuro);
        cargarDescripcionesVacunas(hijoSeleccionado, sis);
        this.pack();
    }

    public final void cargarDescripcionesVacunas(Hijo hijoSeleccionado, Sistema sis) {
        Iterator<Par<Vacuna, ArrayList<Calendar>>> iteradorVacunas
                = hijoSeleccionado.getIteradorHistorialVacunaciones();
        Iterator<Vacuna> vacunasSistema = sis.getVacunas().iterator();
        String ret = "<u>DESCRIPCIONES</u>";
        while (iteradorVacunas.hasNext()) {
            Par<Vacuna, ArrayList<Calendar>> datoActual = iteradorVacunas.next();
            Vacuna vacunaActual = datoActual.getDato1();
            ret = ret + "<br>" + vacunaActual.getNombre() + ": " + vacunaActual.getDescripcion();
        }
        while (vacunasSistema.hasNext()) {
            Vacuna vacunaActual = vacunasSistema.next();
            if (!hijoSeleccionado.contieneVacunaDeEsteNombre(vacunaActual.getNombre())) {
                ret = ret + "<br>" + vacunaActual.getNombre() + ": " + vacunaActual.getDescripcion();
            }
        }
        descripcionesVacunas.setText("<html>" + ret + "</html>");
    }

    private void recomendarNuevasVacunaciones(Hijo hijoSeleccionado, Sistema sis, Color oscuro) {
        Iterator<Par<Vacuna, ArrayList<Calendar>>> iteradorVacunas
                = hijoSeleccionado.getIteradorHistorialVacunaciones();
        Iterator<Vacuna> vacunasSistema = sis.getVacunas().iterator();
        while (iteradorVacunas.hasNext()) {
            Par<Vacuna, ArrayList<Calendar>> datoActual = iteradorVacunas.next();
            ArrayList<Calendar> fechasVacunaciones = datoActual.getDato2();
            Vacuna vacunaActual = datoActual.getDato1();
            if (vacunaActual.esSistematica() && fechasVacunaciones.size() > 0) {

                Calendar fechaVacunacion = fechasVacunaciones.get(fechasVacunaciones.size() - 1);
                int periodoNuevoARecomendar = hijoSeleccionado.
                        mesesDesdeNacimientoAFecha(fechaVacunacion) + Integer.parseInt(
                                vacunaActual.getPeriodoEntreSiguienteVencimientoYAnteriorEnMeses());
                int posCol;
                if (periodoNuevoARecomendar > 24) {
                    periodoNuevoARecomendar = periodoNuevoARecomendar / 12;
                    posCol = infoCarne.getPosColumnaAnio(periodoNuevoARecomendar + "");
                } else {
                    posCol = infoCarne.getPosColumnaMes(periodoNuevoARecomendar + "");
                }
                int posFil = infoCarne.getPosFilVacunaSistematica(vacunaActual.getNombre());
                botonesVacunasSistematicas[posFil][posCol].setBackground(Color.gray);
            }
        }
        while (vacunasSistema.hasNext()) {
            Vacuna vacunaActual = vacunasSistema.next();
            if (vacunaActual.esSistematica()
                    && !hijoSeleccionado.contieneVacunaDeEsteNombre(vacunaActual.getNombre())) {
                int posCol;
                int posFil = infoCarne.getPosFilVacunaSistematica(vacunaActual.getNombre());
                ArrayList<String> marcarPeriodosRecomendados = vacunaActual.getVencimientoEnMeses();
                for (String s : marcarPeriodosRecomendados) {
                    posCol = infoCarne.getPosColumnaMes(s);
                    botonesVacunasSistematicas[posFil][posCol].setBackground(oscuro);
                }
                marcarPeriodosRecomendados = vacunaActual.getVencimientoEnAnios();
                for (String s : marcarPeriodosRecomendados) {
                    posCol = infoCarne.getPosColumnaAnio(s);
                    botonesVacunasSistematicas[posFil][posCol].setBackground(oscuro);
                }
            }
        }
    }

    private void marcarVacunasNoSistematicasDadas(Hijo hijoSeleccionado) {
        Iterator<Par<Vacuna, ArrayList<Calendar>>> iteradorVacunas
                = hijoSeleccionado.getIteradorHistorialVacunaciones();

        while (iteradorVacunas.hasNext()) {
            Par<Vacuna, ArrayList<Calendar>> datoActual = iteradorVacunas.next();
            Iterator<Calendar> itFechasVacunacion = datoActual.getDato2().iterator();
            Vacuna vacunaActual = datoActual.getDato1();
            if (!vacunaActual.esSistematica()) {
                if (itFechasVacunacion.hasNext()) {
                    Calendar fecha = itFechasVacunacion.next();
                    int posFecha = infoCarne.getPosColumnaFecha();
                    int posEdad = infoCarne.getPosColumnaEdad();
                    int posFilaVacuna = infoCarne.getPosFilVacunaNoSistematica(vacunaActual.getNombre());
                    int edad = hijoSeleccionado.mesesDesdeNacimientoAFecha(fecha);
                    String edadAImprimir = edad + " meses";
                    if (edad > 24) {
                        edadAImprimir = hijoSeleccionado.aniosDesdeNacimientoAFecha(fecha) + " años";
                    }
                    if (hijoSeleccionado.esHombre()) {
                        botonesVacunasNoSistematicas[posFilaVacuna][posEdad].setBackground(Color.blue);
                        botonesVacunasNoSistematicas[posFilaVacuna][posFecha].setBackground(Color.blue);
                    } else {
                        botonesVacunasNoSistematicas[posFilaVacuna][posEdad].setBackground(Color.magenta);
                        botonesVacunasNoSistematicas[posFilaVacuna][posFecha].setBackground(Color.magenta);
                    }
                    SimpleDateFormat formatoFecha = new SimpleDateFormat("dd-MM-yyyy");
                    botonesVacunasNoSistematicas[posFilaVacuna][posFecha].setText(formatoFecha.format(fecha.getTime()));
                    botonesVacunasNoSistematicas[posFilaVacuna][posEdad].setText(edadAImprimir);
                }
            }
        }
    }

    private void marcarVacunasSistematicasDadas(Hijo hijoSeleccionado) {
        Iterator<Par<Vacuna, ArrayList<Calendar>>> iteradorVacunas
                = hijoSeleccionado.getIteradorHistorialVacunaciones();

        while (iteradorVacunas.hasNext()) {
            Par<Vacuna, ArrayList<Calendar>> datoActual = iteradorVacunas.next();
            Iterator<Calendar> itFechasVacunacion = datoActual.getDato2().iterator();
            Vacuna vacunaActual = datoActual.getDato1();
            if (vacunaActual.esSistematica()) {
                while (itFechasVacunacion.hasNext()) {
                    Calendar fechaVacunacion = itFechasVacunacion.next();
                    int periodoDesdeFecha = hijoSeleccionado.mesesDesdeNacimientoAFecha(fechaVacunacion);
                    int posCol;
                    if (periodoDesdeFecha > 24) {
                        periodoDesdeFecha = hijoSeleccionado.aniosDesdeNacimientoAFecha(fechaVacunacion);
                        posCol = infoCarne.getPosColumnaAnio(periodoDesdeFecha + "");
                    } else {
                        posCol = infoCarne.getPosColumnaMes(periodoDesdeFecha + "");
                    }
                    int posFil = infoCarne.getPosFilVacunaSistematica(vacunaActual.getNombre());
                    if (hijoSeleccionado.esHombre()) {
                        botonesVacunasSistematicas[posFil][posCol].setBackground(Color.blue);
                    } else {
                        botonesVacunasSistematicas[posFil][posCol].setBackground(Color.magenta);
                    }
                    SimpleDateFormat formatoFecha = new SimpleDateFormat("dd-MM-yyyy");
                    botonesVacunasSistematicas[posFil][posCol].setText(formatoFecha.format(fechaVacunacion.getTime()));
                }
            }
        }
    }

    private void formatearPanelVacunasSistematicas(Color amarillo, Color oscuro, Color claro) {
        String[] nombreVacunas = infoCarne.getListaVacunasSistematicas();
        String[] meses = infoCarne.getListaMeses();
        String[] anios = infoCarne.getListaAnios();
        int cantVacunas = nombreVacunas.length + 1;
        int cantMeses = meses.length;
        int cantAnios = anios.length;
        panelBotonesSistematicas.setLayout(new GridBagLayout());
        botonesVacunasSistematicas = new JButton[cantVacunas][cantMeses + cantAnios];
        for (int f = 0; f < cantVacunas; f++) {
            for (int c = 0; c < cantMeses + cantAnios; c++) {
                boolean crearBoton = false;
                GridBagConstraints constrains = new GridBagConstraints();
                constrains.gridx = c;
                constrains.gridy = f;
                constrains.fill = GridBagConstraints.BOTH;
                constrains.gridwidth = 1;
                JButton jButton = new JButton();
                if (f == 0) {
                    if (c == 0) {
                        jButton.setText("Vacunas");
                        jButton.setBackground(oscuro);
                        crearBoton = true;
                    } else if (c == 1) {
                        constrains.gridwidth = cantMeses - 1;
                        jButton.setText("Edad en meses");
                        jButton.setBackground(claro);
                        crearBoton = true;
                    } else if (c == cantMeses) {
                        constrains.gridwidth = cantAnios;
                        jButton.setText("Edad en años");
                        jButton.setBackground(claro);
                        crearBoton = true;
                    }
                } else {
                    if (f == 1 && c == 0) {
                        jButton.setBackground(amarillo);
                    } else if (c == 0) {
                        jButton.setText(nombreVacunas[f - 1]);
                        jButton.setBackground(claro);
                    } else if (f == 1) {
                        if (c >= cantMeses) {
                            jButton.setText(anios[c - cantMeses]);
                            jButton.setBackground(claro);
                        } else {
                            jButton.setText(meses[c]);
                            jButton.setBackground(claro);
                        }
                    } else {
                        jButton.setBackground(amarillo);
                        jButton.setEnabled(false);
                    }
                    crearBoton = true;
                }
                if (crearBoton) {
                    jButton.setForeground(Color.black);
                    Border borde = new CompoundBorder(new LineBorder(Color.WHITE, 1),
                            new EmptyBorder(5, 5, 5, 5));
                    jButton.setBorder(borde);
                    panelBotonesSistematicas.add(jButton, constrains);
                    botonesVacunasSistematicas[f][c] = jButton;
                }
            }
        }
    }

    private void formatearPanelVacunasNoSistematicas(Color amarillo, Color oscuro, Color claro) {
        String[] nombreVacunas = infoCarne.getListaVacunasNoSistematicas();
        String[] columnas = {"", "Fecha", "Edad"};
        int cantVacunas = nombreVacunas.length;
        int cantColumnas = columnas.length;
        panelBotonesNoSistematicas.setLayout(new GridBagLayout());
        botonesVacunasNoSistematicas = new JButton[cantVacunas][cantColumnas];
        for (int f = 0; f < cantVacunas; f++) {
            for (int c = 0; c < cantColumnas; c++) {
                GridBagConstraints constrains = new GridBagConstraints();
                constrains.gridx = c;
                constrains.gridy = f;
                constrains.fill = GridBagConstraints.BOTH;
                JButton jButton = new JButton();
                if (c == 0 && f == 0) {
                    jButton.setText("Vacunas no sistemáticas");
                    jButton.setBackground(oscuro);
                } else if (f == 0) {
                    jButton.setText(columnas[c]);
                    jButton.setBackground(claro);
                } else if (c == 0) {
                    jButton.setText(nombreVacunas[f]);
                    jButton.setBackground(claro);
                } else {
                    jButton.setBackground(amarillo);
                    jButton.setEnabled(false);
                }
                Border borde = new CompoundBorder(new LineBorder(Color.WHITE),
                        new EmptyBorder(5, 5, 5, 5));
                jButton.setBorder(borde);
                jButton.setForeground(Color.black);
                panelBotonesNoSistematicas.add(jButton, constrains);
                botonesVacunasNoSistematicas[f][c] = jButton;
            }
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panelBotonesSistematicas = new javax.swing.JPanel();
        panelBotonesNoSistematicas = new javax.swing.JPanel();
        descripcionesVacunas = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Carné de vacunación");

        panelBotonesSistematicas.setToolTipText("Carne de vacunas sistematicas");
        panelBotonesSistematicas.setAutoscrolls(true);
        panelBotonesSistematicas.setCursor(new java.awt.Cursor(java.awt.Cursor.CROSSHAIR_CURSOR));
        panelBotonesSistematicas.setMaximumSize(new java.awt.Dimension(100, 100));

        javax.swing.GroupLayout panelBotonesSistematicasLayout = new javax.swing.GroupLayout(panelBotonesSistematicas);
        panelBotonesSistematicas.setLayout(panelBotonesSistematicasLayout);
        panelBotonesSistematicasLayout.setHorizontalGroup(
            panelBotonesSistematicasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 417, Short.MAX_VALUE)
        );
        panelBotonesSistematicasLayout.setVerticalGroup(
            panelBotonesSistematicasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 102, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout panelBotonesNoSistematicasLayout = new javax.swing.GroupLayout(panelBotonesNoSistematicas);
        panelBotonesNoSistematicas.setLayout(panelBotonesNoSistematicasLayout);
        panelBotonesNoSistematicasLayout.setHorizontalGroup(
            panelBotonesNoSistematicasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 386, Short.MAX_VALUE)
        );
        panelBotonesNoSistematicasLayout.setVerticalGroup(
            panelBotonesNoSistematicasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 158, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(descripcionesVacunas, javax.swing.GroupLayout.PREFERRED_SIZE, 386, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(panelBotonesSistematicas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(panelBotonesNoSistematicas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(71, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addComponent(panelBotonesSistematicas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(panelBotonesNoSistematicas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(descripcionesVacunas, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(21, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel descripcionesVacunas;
    private javax.swing.JPanel panelBotonesNoSistematicas;
    private javax.swing.JPanel panelBotonesSistematicas;
    // End of variables declaration//GEN-END:variables
}
