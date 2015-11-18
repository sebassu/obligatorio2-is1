package interfaz;

import dominio.Hijo;
import dominio.Sistema;
import dominio.Vacuna;
import java.awt.Color;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import persistencia.Serializacion;

public class Inicio {

    public static void main(String[] args) throws IllegalArgumentException, IOException {

        try {
            UIManager.setLookAndFeel(UIManager.getCrossPlatformLookAndFeelClassName());
        } catch (ClassNotFoundException | InstantiationException |
                IllegalAccessException | UnsupportedLookAndFeelException ex) {
            Logger.getLogger(Inicio.class.getName()).log(Level.SEVERE, null, ex);
        }
        Sistema sis;
        final Sistema elSistema;
        try {
            sis = Serializacion.deserializar();
        } catch (IOException | ClassNotFoundException e) {
            sis = new Sistema();
        }
        elSistema = sis;
        Runtime.getRuntime().addShutdownHook(new Thread() {
            @Override
            public void run() {
                try {
                    Serializacion.serializar(elSistema);
                } catch (IOException ex) {
                    Logger.getLogger(Inicio.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
        elSistema.cargarVacunasDeArchivo("Prueba Cargar Vacunas.txt");
        VentanaPrincipal a = new VentanaPrincipal(elSistema);
        a.setVisible(true);
        /* CarneVacunas v = new CarneVacunas(elSistema, new Hijo(),new Color(233, 224, 40),
         new Color(60, 154, 40), new Color(135, 186, 19));
         v.setVisible(true);*/
    }
}
