package interfaz;

import dominio.Hijo;
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
import javax.swing.BoxLayout;
import javax.swing.JOptionPane;
import org.jfree.chart.axis.NumberAxis;
import org.jfree.chart.plot.XYPlot;

public class VentanaGraficas extends javax.swing.JFrame {

    public JPanel graficar(XYDataset datos,
            String titulo, String labelX, String labelY, int xLow, int xHigh,
            int yLow, int yHigh, boolean esHombre) {
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
        plot.setRangeGridlineStroke(new BasicStroke(1f));
        plot.setDomainGridlinePaint(Color.black);
        plot.setRangeGridlinePaint(Color.black);
        plot.getRendererForDataset(datos).setSeriesPaint(0, Color.red);
        plot.getRendererForDataset(datos).setSeriesPaint(1, Color.orange);
        plot.getRendererForDataset(datos).setSeriesPaint(2, Color.green);
        plot.getRendererForDataset(datos).setSeriesPaint(3, Color.orange);
        plot.getRendererForDataset(datos).setSeriesPaint(4, Color.red);
        if (esHombre) {
            plot.getRendererForDataset(datos).setSeriesPaint(5, Color.blue);
        } else {
            plot.getRendererForDataset(datos).setSeriesPaint(5, Color.magenta);
        }
        return new ChartPanel(chart);
    }

    public final JPanel graficarPesoAnios2(XYSeries datosNiñoa, boolean hombre)
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
                26, hombre);
    }

    public final JPanel graficarPesoEstaturaAnios2(XYSeries datosNiñoa, boolean hombre)
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
                46, hombre);
    }

    public final JPanel graficarEstaturaAnios2(XYSeries datosNiñoa, boolean hombre)
            throws IOException {
        String chartTitle = "Longitud para la edad (percentiles de nacimiento a"
                + " 2 años)";
        String xAxisLabel = "Edad (en meses cumplidos)";
        String yAxisLabel = "Longitud / estatura (cm)";
        XYDataset datos;
        if (hombre) {
            datos = DataSet.datasetEstaturaAnios2Masculino(datosNiñoa);
        } else {
            datos = DataSet.datasetEstaturaAnios2Femenino(datosNiñoa);
        }
        return graficar(datos, chartTitle, xAxisLabel, yAxisLabel, 0, 24, 45,
                130, hombre);
    }

    public final JPanel graficarEstaturaAnios2A5(XYSeries datosNiñoa, boolean hombre)
            throws IOException {
        String chartTitle = "Estatura para la edad (percentiles de 2 a 5 años)";
        String xAxisLabel = "Edad (en meses cumplidos)";
        String yAxisLabel = "Estatura (cm)";
        XYDataset datos;
        if (hombre) {
            datos = DataSet.datasetEstaturaAnios2A5Masculino(datosNiñoa);
        } else {
            datos = DataSet.datasetEstaturaAnios2A5Femenino(datosNiñoa);
        }
        return graficar(datos, chartTitle, xAxisLabel, yAxisLabel, 24, 60, 45,
                130, hombre);
    }

    public final JPanel graficarEstaturaAnios5A15(XYSeries datosNiñoa, boolean hombre)
            throws IOException {
        String chartTitle = "Estatura para la edad (percentiles de 5 a 15 años)";
        String xAxisLabel = "Edad (en meses cumplidos)";
        String yAxisLabel = "Estatura (cm)";
        XYDataset datos;
        if (hombre) {
            datos = DataSet.datasetEstaturaAnios5A15Masculino(datosNiñoa);
        } else {
            datos = DataSet.datasetEstaturaAnios5A15Femenino(datosNiñoa);
        }
        return graficar(datos, chartTitle, xAxisLabel, yAxisLabel, 60, 180, 100,
                230, hombre);
    }

    public final JPanel graficarPerimCefaAnios3(XYSeries datosNiñoa, boolean hombre)
            throws IOException {
        String chartTitle = "Perímetro cefálico para la edad (percentiles de "
                + "nacimiento a 36 meses)";
        String xAxisLabel = "Edad (en meses cumplidos)";
        String yAxisLabel = "Perímetro cefálico (cm)";
        XYDataset datos;
        if (hombre) {
            datos = DataSet.datasetPerimCefaAnios3Masculino(datosNiñoa);
        } else {
            datos = DataSet.datasetPerimCefaAnios3Femenino(datosNiñoa);
        }
        return graficar(datos, chartTitle, xAxisLabel, yAxisLabel, 60, 180, 100,
                230, hombre);
    }

    public VentanaGraficas(Hijo h, int tipoDeGrafica) {
        try {
            JPanel chartPanel = null;
            switch (tipoDeGrafica) {
                case 1:
                    chartPanel = graficarPesoAnios2(h.obtenerPesosParaGrafica(), h.esHombre());
                    break;
                case 2:
                    chartPanel = graficarEstaturaAnios2(h.obtenerEstaturaParaGrafica(), h.esHombre());
                    break;
                case 3:
                    chartPanel = graficarEstaturaAnios2A5(h.obtenerEstaturaParaGrafica(), h.esHombre());
                    break;
                case 4:
                    chartPanel = graficarEstaturaAnios5A15(h.obtenerEstaturaParaGrafica(), h.esHombre());
                    break;
                case 5:
                    chartPanel = graficarPesoEstaturaAnios2(h.obtenerPesoEstaturaParaGrafica(), h.esHombre());
                    break;
                case 6:
                    chartPanel = graficarPerimCefaAnios3(h.obtenerPerimCefalicoParaGrafica(), h.esHombre());
                    break;
                default:
                    mostrarError();
                    break;
            }
            initComponents();
            panelPrinc.setLayout(new BoxLayout(panelPrinc, BoxLayout.Y_AXIS));
            panelPrinc.add(chartPanel, BorderLayout.CENTER);
            setSize(640, 480);
            setLocationRelativeTo(null);
        } catch (IOException e) {
            mostrarError();
        }
    }

    private void mostrarError() {
        JOptionPane.showMessageDialog(this, "Error al generar la gráfica seleccionada.",
                "Error", JOptionPane.ERROR_MESSAGE);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panelPrinc = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Gráfica de datos de consultas");

        javax.swing.GroupLayout panelPrincLayout = new javax.swing.GroupLayout(panelPrinc);
        panelPrinc.setLayout(panelPrincLayout);
        panelPrincLayout.setHorizontalGroup(
            panelPrincLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        panelPrincLayout.setVerticalGroup(
            panelPrincLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelPrinc, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelPrinc, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel panelPrinc;
    // End of variables declaration//GEN-END:variables
}
