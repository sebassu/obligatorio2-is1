/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dominio;

import java.util.Calendar;

/**
 *
 * @author UriarteZuluaga
 */
public class Vacunacion extends Evento {
    
    private Vacuna vacuna;

    public Vacunacion(String elTitulo, String elTipo, String laDescripcion,
            Calendar laFecha, Hijo hijo, String elLugar, Vacuna laVacuna) {
        super(elTitulo, elTipo, laDescripcion, laFecha, hijo, elLugar);
        this.vacuna = laVacuna;
    }
    
    public Vacuna getVacuna() {
        return vacuna;
    }

    public void setVacuna(Vacuna laVacuna) {
        this.vacuna = laVacuna;
    }
    
    
}
