/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interfaz;

import javax.swing.JPanel;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.data.xy.XYDataset;
import org.jfree.data.xy.XYSeries;
import graficas.DataSet;
import java.awt.BasicStroke;
import java.awt.BorderLayout;
import java.awt.Color;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import org.jfree.chart.axis.NumberAxis;
import org.jfree.chart.plot.XYPlot;

/**
 *
 * @author Zuluaga
 */
public class Graficas extends javax.swing.JFrame {

    /**
     * Creates new form XYLineChartExample
     *
     * @param datos
     * @return
     */
    public JPanel graficar(XYDataset datos,
            String titulo, String labelX, String labelY, int xLow, int xHigh,
            int yLow, int yHigh) {
        JFreeChart chart = ChartFactory.createXYLineChart(titulo, labelX, labelY,
                datos);

        XYPlot plot = chart.getXYPlot();
        NumberAxis xAxis = (NumberAxis) plot.getDomainAxis();
        xAxis.setLowerBound(xLow);
        xAxis.setUpperBound(xHigh);
        NumberAxis yAxis = (NumberAxis) plot.getRangeAxis();
        yAxis.setLowerBound(yLow);
        yAxis.setUpperBound(yHigh);
       
        plot.setBackgroundPaint(Color.white);
        plot.setDomainGridlineStroke(new BasicStroke(1f));
        plot.setDomainGridlinePaint(Color.black);
        plot.setRangeGridlinePaint(Color.black);
        plot.getRendererForDataset(datos).setSeriesPaint(0, Color.red);
        plot.getRendererForDataset(datos).setSeriesPaint(1, Color.yellow);
        plot.getRendererForDataset(datos).setSeriesPaint(2, Color.green);
        plot.getRendererForDataset(datos).setSeriesPaint(3, Color.yellow);
        plot.getRendererForDataset(datos).setSeriesPaint(4, Color.red);
        plot.getRendererForDataset(datos).setSeriesPaint(5, Color.magenta);

        return new ChartPanel(chart);
    }

    public JPanel graficarPesoAnios2(XYSeries datosNiñoa, boolean hombre) 
            throws IOException {
        String chartTitle = "Peso para la edad (percentiles de nacimiento a 2 años)";
        String xAxisLabel = "Edad (en meses cumplidos)";
        String yAxisLabel = "Peso(kg)";
         XYDataset datos;
        if (hombre) {
            datos = DataSet.datasetPesoAnios2Masculino(datosNiñoa);
        } else {
            datos = DataSet.datasetPesoAnios2Femenino(datosNiñoa);
        }
        return graficar(datos, chartTitle, xAxisLabel, yAxisLabel, 0, 24, 0, 
                26);
    }
    
    public JPanel graficarPesoEstaturaAnios2(XYSeries datosNiñoa, boolean hombre) 
            throws IOException {
        String chartTitle = "Peso / Estatura (percentiles hasta los 5 años)";
        String xAxisLabel = "Estatura (cm)";
        String yAxisLabel = "Peso(kg)";
         XYDataset datos;
        if (hombre) {
            datos = DataSet.datasetPesoEstaturaAnios5Masculino(datosNiñoa);
        } else {
            datos = DataSet.datasetPesoEstaturaAnios5Femenino(datosNiñoa);
        }
        return graficar(datos, chartTitle, xAxisLabel, yAxisLabel, 65, 120, 6, 
                46);
    }
    
    public JPanel graficarEstaturaAnios2(XYSeries datosNiñoa, boolean hombre) 
            throws IOException {
        String chartTitle = "Longitud para la edad (percentiles de nacimiento a"
                + " 2 años)";
        String xAxisLabel = "Edad (en meses cumplidos)";
        String yAxisLabel = "Longitud / estatura (cm)";
         XYDataset datos;
        if (hombre) {
            datos = DataSet. datasetEstaturaAnios2Masculino(datosNiñoa);
        } else {
            datos = DataSet. datasetEstaturaAnios2Femenino(datosNiñoa);
        }
        return graficar(datos, chartTitle, xAxisLabel, yAxisLabel, 0, 24, 45, 
                130);
    }
    
    public JPanel graficarEstaturaAnios2A5(XYSeries datosNiñoa, boolean hombre) 
            throws IOException {
        String chartTitle = "Estatura para la edad (percentiles de 2 a 5 años)";
        String xAxisLabel = "Edad (en meses cumplidos)";
        String yAxisLabel = "Estatura (cm)";
         XYDataset datos;
        if (hombre) {
            datos = DataSet. datasetEstaturaAnios2A5Masculino(datosNiñoa);
        } else {
            datos = DataSet. datasetEstaturaAnios2A5Femenino(datosNiñoa);
        }
        return graficar(datos, chartTitle, xAxisLabel, yAxisLabel, 24, 60, 45, 
                130);
    }
    
    public JPanel graficarEstaturaAnios2A15(XYSeries datosNiñoa, boolean hombre) 
            throws IOException {
        String chartTitle = "Estatura para la edad (percentiles de 5 a 15 años)";
        String xAxisLabel = "Edad (en meses cumplidos)";
        String yAxisLabel = "Estatura (cm)";
         XYDataset datos;
        if (hombre) {
            datos = DataSet. datasetEstaturaAnios5A15Masculino(datosNiñoa);
        } else {
            datos = DataSet. datasetEstaturaAnios5A15Femenino(datosNiñoa);
        }
        return graficar(datos, chartTitle, xAxisLabel, yAxisLabel, 60, 180, 100, 
                230);
    }
    
    public JPanel graficarPerimCefaAnios3(XYSeries datosNiñoa, boolean hombre) 
            throws IOException {
        String chartTitle = "Perímetro cefálico para la edad (percentiles de "
                + "nacimiento a 36 meses)";
        String xAxisLabel = "Edad (en meses cumplidos)";
        String yAxisLabel = "Perímetro cefálico (cm)";
         XYDataset datos;
        if (hombre) {
            datos = DataSet. datasetPerimCefaAnios3Masculino(datosNiñoa);
        } else {
            datos = DataSet. datasetPerimCefaAnios3Femenino(datosNiñoa);
        }
        return graficar(datos, chartTitle, xAxisLabel, yAxisLabel, 60, 180, 100, 
                230);
    }


  /*  public Graficas() throws IOException {
        super("XY Line Chart Example with JFreechart");

         JPanel chartPanel = graficarEstaturaAnios2Masculino();
         add(chartPanel, BorderLayout.CENTER);

         setSize(640, 480);
         setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
         setLocationRelativeTo(null);
    }*/

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     * @param args the command line arguments
     */
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
//            java.util.logging.Logger.getLogger(Graficas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (InstantiationException ex) {
//            java.util.logging.Logger.getLogger(Graficas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (IllegalAccessException ex) {
//            java.util.logging.Logger.getLogger(Graficas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
//            java.util.logging.Logger.getLogger(Graficas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        }
//        //</editor-fold>
//        //</editor-fold>
//
//        /* Create and display the form */
//        java.awt.EventQueue.invokeLater(new Runnable() {
//            public void run() {
//                try {
//                    new Graficas().setVisible(true);
//                } catch (IOException ex) {
//                    Logger.getLogger(Graficas.class.getName()).log(Level.SEVERE, null, ex);
//                }
//            }
//        });
//    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables

}
