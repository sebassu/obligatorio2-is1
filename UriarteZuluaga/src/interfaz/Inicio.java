package interfaz;

import dominio.Sistema;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import persistencia.Serializacion;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author UriarteZuluaga
 */
public class Inicio {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Sistema s;
        final Sistema elSistema;
        try {
            s = Serializacion.deserializar();
        } catch (IOException | ClassNotFoundException e) {
            s = new Sistema();
        }
        elSistema = s;
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
    }

}
