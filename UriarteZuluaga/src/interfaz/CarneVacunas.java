/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interfaz;

import dominio.Hijo;
import dominio.Sistema;
import java.awt.Color;
import java.awt.GridLayout;
import javax.swing.JButton;

/**
 *
 * @author Zuluaga
 */
public class CarneVacunas extends javax.swing.JFrame {

    private JButton[][] botonesVacunasSistematicas;
    private JButton[][] botonesVacunasNoSistematicas;

    public CarneVacunas(Sistema sis, Hijo hijoSeleccionado, Color amarillo, 
            Color oscuro, Color claro) {
        initComponents();
        llenarPanelVacunasSistematicas(sis, hijoSeleccionado, amarillo, oscuro, claro);
        llenarPanelVacunasNoSistematicas(sis, hijoSeleccionado, amarillo, oscuro, claro);
    }

    private void llenarPanelVacunasSistematicas(Sistema sis, Hijo hijoSeleccionado,
            Color amarillo, Color oscuro, Color claro) {
        String[] nombreVacunas = sis.nombreVacunasSistematicasParaCarne(hijoSeleccionado);
        String[] meses = {"", "1", "2", "4"};
        int cantVacunas = nombreVacunas.length;
        int cantMeses = meses.length;
        panelBotonesSistematicas.setLayout(new GridLayout(cantVacunas, cantMeses));
        botonesVacunasSistematicas = new JButton[cantVacunas][cantMeses];
        for (int f = 0; f < cantVacunas; f++) {
            for (int c = 0; c < cantMeses; c++) {
                JButton jButton = new JButton();               
                if (c == 0) {
                    jButton.setText(nombreVacunas[f]);
                    jButton.setBackground(claro);
                } else if (f == 0) {
                    jButton.setText(meses[c]);
                    jButton.setBackground(claro);
                } else {
                    jButton.setBackground(amarillo);
                    jButton.setEnabled(false);
                }
                jButton.setForeground(Color.black);
                panelBotonesSistematicas.add(jButton);
                botonesVacunasSistematicas[f][c] = jButton;
            }
        }
    }

    private void llenarPanelVacunasNoSistematicas(Sistema sis, Hijo hijoSeleccionado,
            Color amarillo, Color oscuro, Color claro) {
        String[] nombreVacunas = sis.nombreVacunasNoSistematicasParaCarne(hijoSeleccionado);
        String[] columnas = {"", "Fecha", "Edad"};
        int cantVacunas = nombreVacunas.length;
        int cantColumnas = columnas.length;
        panelBotonesNoSistematicas.setLayout(new GridLayout(cantVacunas, cantColumnas));
        botonesVacunasNoSistematicas = new JButton[cantVacunas][cantColumnas];
        for (int f = 0; f < cantVacunas; f++) {
            for (int c = 0; c < cantColumnas; c++) {
                JButton jButton = new JButton();
                if (c == 0) {
                    jButton.setText(nombreVacunas[f]);
                    jButton.setBackground(claro);
                } else if (f == 0) {
                    jButton.setText(columnas[c]);
                    jButton.setBackground(claro);
                } else {
                    jButton.setBackground(amarillo);
                    jButton.setEnabled(false);
                }
                jButton.setForeground(Color.black);
                panelBotonesNoSistematicas.add(jButton);
                botonesVacunasNoSistematicas[f][c] = jButton;
            }
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panelBotonesSistematicas = new javax.swing.JPanel();
        panelBotonesNoSistematicas = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        javax.swing.GroupLayout panelBotonesSistematicasLayout = new javax.swing.GroupLayout(panelBotonesSistematicas);
        panelBotonesSistematicas.setLayout(panelBotonesSistematicasLayout);
        panelBotonesSistematicasLayout.setHorizontalGroup(
            panelBotonesSistematicasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        panelBotonesSistematicasLayout.setVerticalGroup(
            panelBotonesSistematicasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 191, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout panelBotonesNoSistematicasLayout = new javax.swing.GroupLayout(panelBotonesNoSistematicas);
        panelBotonesNoSistematicas.setLayout(panelBotonesNoSistematicasLayout);
        panelBotonesNoSistematicasLayout.setHorizontalGroup(
            panelBotonesNoSistematicasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 417, Short.MAX_VALUE)
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
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(panelBotonesNoSistematicas, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(panelBotonesSistematicas, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(72, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(panelBotonesSistematicas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(38, 38, 38)
                .addComponent(panelBotonesNoSistematicas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(30, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

//    /**
//     * @param args the command line arguments
//     */
//    public static void main(String args[]) {
//        /* Set the Nimbus look and feel */
//        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
//        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
//         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
//         */
//        try {
//            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
//                if ("Nimbus".equals(info.getName())) {
//                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
//                    break;
//                }
//            }
//        } catch (ClassNotFoundException ex) {
//            java.util.logging.Logger.getLogger(CarneVacunas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (InstantiationException ex) {
//            java.util.logging.Logger.getLogger(CarneVacunas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (IllegalAccessException ex) {
//            java.util.logging.Logger.getLogger(CarneVacunas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
//            java.util.logging.Logger.getLogger(CarneVacunas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        }
//        //</editor-fold>
//
//        /* Create and display the form */
//        java.awt.EventQueue.invokeLater(new Runnable() {
//            public void run() {
//                new CarneVacunas().setVisible(true);
//            }
//        });
//    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel panelBotonesNoSistematicas;
    private javax.swing.JPanel panelBotonesSistematicas;
    // End of variables declaration//GEN-END:variables
}