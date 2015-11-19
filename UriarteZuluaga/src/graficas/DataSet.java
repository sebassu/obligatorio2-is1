package graficas;

import java.io.FileNotFoundException;
import java.io.IOException;
import org.jfree.data.xy.XYDataset;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;
import persistencia.ArchivoLectura;

public class DataSet {

    private static XYSeries leerPercentilesDeArchivo(XYSeries p, String ubicacion,
            String percentil)
            throws FileNotFoundException, IOException {
        int colP = -1;
        ArchivoLectura archivoLeido = new ArchivoLectura(ubicacion);
        while (archivoLeido.hayMasLineas()) {
            String[] linea = archivoLeido.linea().trim().split("\\t");
            if (colP == -1) {
                for (int i = 0; i < linea.length; i++) {
                    if (linea[i].equals(percentil)) {
                        colP = i;
                    }
                }
            } else {
                p.add(Double.parseDouble(linea[0]),
                        Double.parseDouble(linea[colP]));
            }
        }
        archivoLeido.cerrar();
        return p;
    }

    public static XYSeries estaturaP97Anios2Masculino() throws IOException {
        XYSeries p97 = new XYSeries("1.Cuidado");
        leerPercentilesDeArchivo(p97, "resources//tab_lhfa_boys_p_0_2.txt", "P97");
        return p97;
    }

    public static XYSeries estaturaP85Anios2Masculino() throws IOException {
        XYSeries p85 = new XYSeries("2.Atención");
        leerPercentilesDeArchivo(p85, "resources//tab_lhfa_boys_p_0_2.txt", "P85");
        return p85;
    }

    public static XYSeries estaturaP50Anios2Masculino() throws IOException {
        XYSeries p50 = new XYSeries("3.Óptimo");
        leerPercentilesDeArchivo(p50, "resources//tab_lhfa_boys_p_0_2.txt", "P50");
        return p50;
    }

    public static XYSeries estaturaP15Anios2Masculino() throws IOException {
        XYSeries p15 = new XYSeries("4.Atención");
        leerPercentilesDeArchivo(p15, "resources//tab_lhfa_boys_p_0_2.txt", "P15");
        return p15;
    }

    public static XYSeries estaturaP3Anios2Masculino() throws IOException {
        XYSeries p3 = new XYSeries("5.Cuidado");
        leerPercentilesDeArchivo(p3, "resources//tab_lhfa_boys_p_0_2.txt", "P3");
        return p3;
    }

    public static XYSeries estaturaP97Anios2Femenino() throws IOException {
        XYSeries p97 = new XYSeries("1.Cuidado");
        leerPercentilesDeArchivo(p97, "resources//tab_lhfa_girls_p_0_2.txt", "P97");
        return p97;
    }

    public static XYSeries estaturaP85Anios2Femenino() throws IOException {
        XYSeries p85 = new XYSeries("2.Atención");
        leerPercentilesDeArchivo(p85, "resources//tab_lhfa_girls_p_0_2.txt", "P85");
        return p85;
    }

    public static XYSeries estaturaP50Anios2Femenino() throws IOException {
        XYSeries p50 = new XYSeries("3.Óptimo");
        leerPercentilesDeArchivo(p50, "resources//tab_lhfa_girls_p_0_2.txt", "P50");
        return p50;
    }

    public static XYSeries estaturaP15Anios2Femenino() throws IOException {
        XYSeries p15 = new XYSeries("4.Atención");
        leerPercentilesDeArchivo(p15, "resources//tab_lhfa_girls_p_0_2.txt", "P15");
        return p15;
    }

    public static XYSeries estaturaP3Anios2Femenino() throws IOException {
        XYSeries p3 = new XYSeries("5.Cuidado");
        leerPercentilesDeArchivo(p3, "resources//tab_lhfa_girls_p_0_2.txt", "P3");
        return p3;
    }

    public static XYDataset datasetEstaturaAnios2Masculino(XYSeries datosNiño)
            throws IOException {
        XYSeriesCollection dataset = new XYSeriesCollection();
        dataset.addSeries(estaturaP97Anios2Masculino());
        dataset.addSeries(estaturaP85Anios2Masculino());
        dataset.addSeries(estaturaP50Anios2Masculino());
        dataset.addSeries(estaturaP15Anios2Masculino());
        dataset.addSeries(estaturaP3Anios2Masculino());
        dataset.addSeries(datosNiño);

        return dataset;
    }

    public static XYDataset datasetEstaturaAnios2Femenino(XYSeries datosNiña)
            throws IOException {
        XYSeriesCollection dataset = new XYSeriesCollection();
        dataset.addSeries(estaturaP97Anios2Femenino());
        dataset.addSeries(estaturaP85Anios2Femenino());
        dataset.addSeries(estaturaP50Anios2Femenino());
        dataset.addSeries(estaturaP15Anios2Femenino());
        dataset.addSeries(estaturaP3Anios2Femenino());
        dataset.addSeries(datosNiña);

        return dataset;
    }

    public static XYSeries estaturaP97Anios2A5Masculino() throws IOException {
        XYSeries p97 = new XYSeries("1.Cuidado");
        leerPercentilesDeArchivo(p97, "resources//tab_lhfa_boys_p_2_5.txt", "P97");
        return p97;
    }

    public static XYSeries estaturaP85Anios2A5Masculino() throws IOException {
        XYSeries p85 = new XYSeries("2.Atención");
        leerPercentilesDeArchivo(p85, "resources//tab_lhfa_boys_p_2_5.txt", "P85");
        return p85;
    }

    public static XYSeries estaturaP50Anios2A5Masculino() throws IOException {
        XYSeries p50 = new XYSeries("3.Óptimo");
        leerPercentilesDeArchivo(p50, "resources//tab_lhfa_boys_p_2_5.txt", "P50");
        return p50;
    }

    public static XYSeries estaturaP15Anios2A5Masculino() throws IOException {
        XYSeries p15 = new XYSeries("4.Atención");
        leerPercentilesDeArchivo(p15, "resources//tab_lhfa_boys_p_2_5.txt", "P15");
        return p15;
    }

    public static XYSeries estaturaP3Anios2A5Masculino() throws IOException {
        XYSeries p3 = new XYSeries("5.Cuidado");
        leerPercentilesDeArchivo(p3, "resources//tab_lhfa_boys_p_2_5.txt", "P3");
        return p3;
    }

    public static XYDataset datasetEstaturaAnios2A5Masculino(XYSeries datosNiño)
            throws IOException {
        XYSeriesCollection dataset = new XYSeriesCollection();
        dataset.addSeries(estaturaP97Anios2A5Masculino());
        dataset.addSeries(estaturaP85Anios2A5Masculino());
        dataset.addSeries(estaturaP50Anios2A5Masculino());
        dataset.addSeries(estaturaP15Anios2A5Masculino());
        dataset.addSeries(estaturaP3Anios2A5Masculino());
        dataset.addSeries(datosNiño);

        return dataset;
    }

    public static XYSeries estaturaP97Anios2A5Femenino() throws IOException {
        XYSeries p97 = new XYSeries("1.Cuidado");
        leerPercentilesDeArchivo(p97, "resources//tab_lhfa_girls_p_2_5.txt", "P97");
        return p97;
    }

    public static XYSeries estaturaP85Anios2A5Femenino() throws IOException {
        XYSeries p85 = new XYSeries("2.Atención");
        leerPercentilesDeArchivo(p85, "resources//tab_lhfa_girls_p_2_5.txt", "P85");
        return p85;
    }

    public static XYSeries estaturaP50Anios2A5Femenino() throws IOException {
        XYSeries p50 = new XYSeries("3.Óptimo");
        leerPercentilesDeArchivo(p50, "resources//tab_lhfa_girls_p_2_5.txt", "P50");
        return p50;
    }

    public static XYSeries estaturaP15Anios2A5Femenino() throws IOException {
        XYSeries p15 = new XYSeries("4.Atención");
        leerPercentilesDeArchivo(p15, "resources//tab_lhfa_girls_p_2_5.txt", "P15");
        return p15;
    }

    public static XYSeries estaturaP3Anios2A5Femenino() throws IOException {
        XYSeries p3 = new XYSeries("5.Cuidado");
        leerPercentilesDeArchivo(p3, "resources//tab_lhfa_girls_p_2_5.txt", "P3");
        return p3;
    }

    public static XYDataset datasetEstaturaAnios2A5Femenino(XYSeries datosNiña)
            throws IOException {
        XYSeriesCollection dataset = new XYSeriesCollection();
        dataset.addSeries(estaturaP97Anios2A5Femenino());
        dataset.addSeries(estaturaP85Anios2A5Femenino());
        dataset.addSeries(estaturaP50Anios2A5Femenino());
        dataset.addSeries(estaturaP15Anios2A5Femenino());
        dataset.addSeries(estaturaP3Anios2A5Femenino());
        dataset.addSeries(datosNiña);

        return dataset;
    }

    public static XYSeries estaturaP97Anios5A15Masculino() throws IOException {
        XYSeries p97 = new XYSeries("1.Cuidado");
        leerPercentilesDeArchivo(p97, "resources//hfa_boys_perc_WHO2007_exp.txt", "P97");
        return p97;
    }

    public static XYSeries estaturaP85Anios5A15Masculino() throws IOException {
        XYSeries p85 = new XYSeries("2.Atención");
        leerPercentilesDeArchivo(p85, "resources//hfa_boys_perc_WHO2007_exp.txt", "P85");
        return p85;
    }

    public static XYSeries estaturaP50Anios5A15Masculino() throws IOException {
        XYSeries p50 = new XYSeries("3.Óptimo");
        leerPercentilesDeArchivo(p50, "resources//hfa_boys_perc_WHO2007_exp.txt", "P50");
        return p50;
    }

    public static XYSeries estaturaP15Anios5A15Masculino() throws IOException {
        XYSeries p15 = new XYSeries("4.Atención");
        leerPercentilesDeArchivo(p15, "resources//hfa_boys_perc_WHO2007_exp.txt", "P15");
        return p15;
    }

    public static XYSeries estaturaP3Anios5A15Masculino() throws IOException {
        XYSeries p3 = new XYSeries("5.Cuidado");
        leerPercentilesDeArchivo(p3, "resources//hfa_boys_perc_WHO2007_exp.txt", "P3");
        return p3;
    }

    public static XYDataset datasetEstaturaAnios5A15Masculino(XYSeries datosNiño)
            throws IOException {
        XYSeriesCollection dataset = new XYSeriesCollection();
        dataset.addSeries(estaturaP97Anios5A15Masculino());
        dataset.addSeries(estaturaP85Anios5A15Masculino());
        dataset.addSeries(estaturaP50Anios5A15Masculino());
        dataset.addSeries(estaturaP15Anios5A15Masculino());
        dataset.addSeries(estaturaP3Anios5A15Masculino());
        dataset.addSeries(datosNiño);

        return dataset;
    }

    public static XYSeries estaturaP97Anios5A15Femenino() throws IOException {
        XYSeries p97 = new XYSeries("1.Cuidado");
        leerPercentilesDeArchivo(p97, "resources//hfa_girls_perc_WHO2007_exp.txt", "P97");
        return p97;
    }

    public static XYSeries estaturaP85Anios5A15Femenino() throws IOException {
        XYSeries p85 = new XYSeries("2.Atención");
        leerPercentilesDeArchivo(p85, "resources//hfa_girls_perc_WHO2007_exp.txt", "P85");
        return p85;
    }

    public static XYSeries estaturaP50Anios5A15Femenino() throws IOException {
        XYSeries p50 = new XYSeries("3.Óptimo");
        leerPercentilesDeArchivo(p50, "resources//hfa_girls_perc_WHO2007_exp.txt", "P50");
        return p50;
    }

    public static XYSeries estaturaP15Anios5A15Femenino() throws IOException {
        XYSeries p15 = new XYSeries("4.Atención");
        leerPercentilesDeArchivo(p15, "resources//hfa_girls_perc_WHO2007_exp.txt", "P15");
        return p15;
    }

    public static XYSeries estaturaP3Anios5A15Femenino() throws IOException {
        XYSeries p3 = new XYSeries("5.Cuidado");
        leerPercentilesDeArchivo(p3, "resources//hfa_girls_perc_WHO2007_exp.txt", "P3");
        return p3;
    }

    public static XYDataset datasetEstaturaAnios5A15Femenino(XYSeries datosNiña)
            throws IOException {
        XYSeriesCollection dataset = new XYSeriesCollection();
        dataset.addSeries(estaturaP97Anios5A15Femenino());
        dataset.addSeries(estaturaP85Anios5A15Femenino());
        dataset.addSeries(estaturaP50Anios5A15Femenino());
        dataset.addSeries(estaturaP15Anios5A15Femenino());
        dataset.addSeries(estaturaP3Anios5A15Femenino());
        dataset.addSeries(datosNiña);

        return dataset;
    }

    public static XYSeries perimCefaP97Anios3Masculino() throws IOException {
        XYSeries p97 = new XYSeries("1.Cuidado");
        leerPercentilesDeArchivo(p97, "resources//tab_hcfa_boys_p_0_5.txt", "P97");
        return p97;
    }

    public static XYSeries perimCefaP85Anios3Masculino() throws IOException {
        XYSeries p85 = new XYSeries("2.Atención");
        leerPercentilesDeArchivo(p85, "resources//tab_hcfa_boys_p_0_5.txt", "P85");
        return p85;
    }

    public static XYSeries perimCefaP50Anios3Masculino() throws IOException {
        XYSeries p50 = new XYSeries("3.Óptimo");
        leerPercentilesDeArchivo(p50, "resources//tab_hcfa_boys_p_0_5.txt", "P50");
        return p50;
    }

    public static XYSeries perimCefaP15Anios3Masculino() throws IOException {
        XYSeries p15 = new XYSeries("4.Atención");
        leerPercentilesDeArchivo(p15, "resources//tab_hcfa_boys_p_0_5.txt", "P15");
        return p15;
    }

    public static XYSeries perimCefaP3Anios3Masculino() throws IOException {
        XYSeries p3 = new XYSeries("5.Cuidado");
        leerPercentilesDeArchivo(p3, "resources//tab_hcfa_boys_p_0_5.txt", "P3");
        return p3;
    }

    public static XYDataset datasetPerimCefaAnios3Masculino(XYSeries datosNiño)
            throws IOException {
        XYSeriesCollection dataset = new XYSeriesCollection();
        dataset.addSeries(perimCefaP97Anios3Masculino());
        dataset.addSeries(perimCefaP85Anios3Masculino());
        dataset.addSeries(perimCefaP50Anios3Masculino());
        dataset.addSeries(perimCefaP15Anios3Masculino());
        dataset.addSeries(perimCefaP3Anios3Masculino());
        dataset.addSeries(datosNiño);

        return dataset;
    }

    public static XYSeries perimCefaP97Anios3Femenino() throws IOException {
        XYSeries p97 = new XYSeries("1.Cuidado");
        leerPercentilesDeArchivo(p97, "resources//tab_hcfa_girls_p_0_5.txt", "P97");
        return p97;
    }

    public static XYSeries perimCefaP85Anios3Femenino() throws IOException {
        XYSeries p85 = new XYSeries("2.Atención");
        leerPercentilesDeArchivo(p85, "resources//tab_hcfa_girls_p_0_5.txt", "P85");
        return p85;
    }

    public static XYSeries perimCefaP50Anios3Femenino() throws IOException {
        XYSeries p50 = new XYSeries("3.Óptimo");
        leerPercentilesDeArchivo(p50, "resources//tab_hcfa_girls_p_0_5.txt", "P50");
        return p50;
    }

    public static XYSeries perimCefaP15Anios3Femenino() throws IOException {
        XYSeries p15 = new XYSeries("4.Atención");
        leerPercentilesDeArchivo(p15, "resources//tab_hcfa_girls_p_0_5.txt", "P15");
        return p15;
    }

    public static XYSeries perimCefaP3Anios3Femenino() throws IOException {
        XYSeries p3 = new XYSeries("5.Cuidado");
        leerPercentilesDeArchivo(p3, "resources//tab_hcfa_girls_p_0_5.txt", "P3");
        return p3;
    }

    public static XYDataset datasetPerimCefaAnios3Femenino(XYSeries datosNiña)
            throws IOException {
        XYSeriesCollection dataset = new XYSeriesCollection();
        dataset.addSeries(perimCefaP97Anios3Femenino());
        dataset.addSeries(perimCefaP85Anios3Femenino());
        dataset.addSeries(perimCefaP50Anios3Femenino());
        dataset.addSeries(perimCefaP15Anios3Femenino());
        dataset.addSeries(perimCefaP3Anios3Femenino());
        dataset.addSeries(datosNiña);

        return dataset;
    }

    public static XYSeries pesoP97Anios2Masculino() throws IOException {
        XYSeries p97 = new XYSeries("1.Cuidado");
        leerPercentilesDeArchivo(p97, "resources//tab_wfa_boys_p_0_5.txt", "P97");
        return p97;
    }

    public static XYSeries pesoP85Anios2Masculino() throws IOException {
        XYSeries p85 = new XYSeries("2.Atención");
        leerPercentilesDeArchivo(p85, "resources//tab_wfa_boys_p_0_5.txt", "P85");
        return p85;
    }

    public static XYSeries pesoP50Anios2Masculino() throws IOException {
        XYSeries p50 = new XYSeries("3.Óptimo");
        leerPercentilesDeArchivo(p50, "resources//tab_wfa_boys_p_0_5.txt", "P50");
        return p50;
    }

    public static XYSeries pesoP15Anios2Masculino() throws IOException {
        XYSeries p15 = new XYSeries("4.Atención");
        leerPercentilesDeArchivo(p15, "resources//tab_wfa_boys_p_0_5.txt", "P15");
        return p15;
    }

    public static XYSeries pesoP3Anios2Masculino() throws IOException {
        XYSeries p3 = new XYSeries("5.Cuidado");
        leerPercentilesDeArchivo(p3, "resources//tab_wfa_boys_p_0_5.txt", "P3");
        return p3;
    }

    public static XYDataset datasetPesoAnios2Masculino(XYSeries datosNiño)
            throws IOException {
        XYSeriesCollection dataset = new XYSeriesCollection();
        dataset.addSeries(pesoP97Anios2Masculino());
        dataset.addSeries(pesoP85Anios2Masculino());
        dataset.addSeries(pesoP50Anios2Masculino());
        dataset.addSeries(pesoP15Anios2Masculino());
        dataset.addSeries(pesoP3Anios2Masculino());
        dataset.addSeries(datosNiño);

        return dataset;
    }

    public static XYSeries pesoP97Anios2Femenino() throws IOException {
        XYSeries p97 = new XYSeries("1.Cuidado");
        leerPercentilesDeArchivo(p97, "resources//tab_wfa_girls_p_0_5.txt", "P97");
        return p97;
    }

    public static XYSeries pesoP85Anios2Femenino() throws IOException {
        XYSeries p85 = new XYSeries("2.Atención");
        leerPercentilesDeArchivo(p85, "resources//tab_wfa_girls_p_0_5.txt", "P85");
        return p85;
    }

    public static XYSeries pesoP50Anios2Femenino() throws IOException {
        XYSeries p50 = new XYSeries("3.Óptimo");
        leerPercentilesDeArchivo(p50, "resources//tab_wfa_girls_p_0_5.txt", "P50");
        return p50;
    }

    public static XYSeries pesoP15Anios2Femenino() throws IOException {
        XYSeries p15 = new XYSeries("4.Atención");
        leerPercentilesDeArchivo(p15, "resources//tab_wfa_girls_p_0_5.txt", "P15");
        return p15;
    }

    public static XYSeries pesoP3Anios2Femenino() throws IOException {
        XYSeries p3 = new XYSeries("5.Cuidado");
        leerPercentilesDeArchivo(p3, "resources//tab_wfa_girls_p_0_5.txt", "P3");
        return p3;
    }

    public static XYDataset datasetPesoAnios2Femenino(XYSeries datosNiña)
            throws IOException {
        XYSeriesCollection dataset = new XYSeriesCollection();
        dataset.addSeries(pesoP97Anios2Femenino());
        dataset.addSeries(pesoP85Anios2Femenino());
        dataset.addSeries(pesoP50Anios2Femenino());
        dataset.addSeries(pesoP15Anios2Femenino());
        dataset.addSeries(pesoP3Anios2Femenino());
        dataset.addSeries(datosNiña);

        return dataset;
    }

    public static XYSeries pesoEstaturaP97Anios5Masculino() throws IOException {
        XYSeries p97 = new XYSeries("1.Cuidado");
        leerPercentilesDeArchivo(p97, "resources//tab_wfh_boys_p_0_5.txt", "P97");
        return p97;
    }

    public static XYSeries pesoEstaturaP85Anios5Masculino() throws IOException {
        XYSeries p85 = new XYSeries("2.Atención");
        leerPercentilesDeArchivo(p85, "resources//tab_wfh_boys_p_0_5.txt", "P85");
        return p85;
    }

    public static XYSeries pesoEstaturaP50Anios5Masculino() throws IOException {
        XYSeries p50 = new XYSeries("3.Óptimo");
        leerPercentilesDeArchivo(p50, "resources//tab_wfh_boys_p_0_5.txt", "P50");
        return p50;
    }

    public static XYSeries pesoEstaturaP15Anios5Masculino() throws IOException {
        XYSeries p15 = new XYSeries("4.Atención");
        leerPercentilesDeArchivo(p15, "resources//tab_wfh_boys_p_0_5.txt", "P15");
        return p15;
    }

    public static XYSeries pesoEstaturaP3Anios5Masculino() throws IOException {
        XYSeries p3 = new XYSeries("5.Cuidado");
        leerPercentilesDeArchivo(p3, "resources//tab_wfh_boys_p_0_5.txt", "P3");
        return p3;
    }

    public static XYDataset datasetPesoEstaturaAnios5Masculino(XYSeries datosNiño)
            throws IOException {
        XYSeriesCollection dataset = new XYSeriesCollection();
        dataset.addSeries(pesoEstaturaP97Anios5Masculino());
        dataset.addSeries(pesoEstaturaP85Anios5Masculino());
        dataset.addSeries(pesoEstaturaP50Anios5Masculino());
        dataset.addSeries(pesoEstaturaP15Anios5Masculino());
        dataset.addSeries(pesoEstaturaP3Anios5Masculino());
        dataset.addSeries(datosNiño);

        return dataset;
    }

    public static XYSeries pesoEstaturaP97Anios5Femenino() throws IOException {
        XYSeries p97 = new XYSeries("1.Cuidado");
        leerPercentilesDeArchivo(p97, "resources//tab_wfh_girls_p_0_5.txt", "P97");
        return p97;
    }

    public static XYSeries pesoEstaturaP85Anios5Femenino() throws IOException {
        XYSeries p85 = new XYSeries("2.Atención");
        leerPercentilesDeArchivo(p85, "resources//tab_wfh_girls_p_0_5.txt", "P85");
        return p85;
    }

    public static XYSeries pesoEstaturaP50Anios5Femenino() throws IOException {
        XYSeries p50 = new XYSeries("3.Óptimo");
        leerPercentilesDeArchivo(p50, "resources//tab_wfh_girls_p_0_5.txt", "P50");
        return p50;
    }

    public static XYSeries pesoEstaturaP15Anios5Femenino() throws IOException {
        XYSeries p15 = new XYSeries("4.Atención");
        leerPercentilesDeArchivo(p15, "resources//tab_wfh_girls_p_0_5.txt", "P15");
        return p15;
    }

    public static XYSeries pesoEstaturaP3Anios5Femenino() throws IOException {
        XYSeries p3 = new XYSeries("5.Cuidado");
        leerPercentilesDeArchivo(p3, "resources//tab_wfh_girls_p_0_5.txt", "P3");
        return p3;
    }

    public static XYDataset datasetPesoEstaturaAnios5Femenino(XYSeries datosNiña)
            throws IOException {
        XYSeriesCollection dataset = new XYSeriesCollection();
        dataset.addSeries(pesoEstaturaP97Anios5Femenino());
        dataset.addSeries(pesoEstaturaP85Anios5Femenino());
        dataset.addSeries(pesoEstaturaP50Anios5Femenino());
        dataset.addSeries(pesoEstaturaP15Anios5Femenino());
        dataset.addSeries(pesoEstaturaP3Anios5Femenino());
        dataset.addSeries(datosNiña);

        return dataset;
    }
}
