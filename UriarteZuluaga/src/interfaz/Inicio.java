package interfaz;

import dominio.Sistema;
import java.io.IOException;
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
        VentanaPrincipal a = new VentanaPrincipal(elSistema);
        a.setVisible(true);
    }
}
