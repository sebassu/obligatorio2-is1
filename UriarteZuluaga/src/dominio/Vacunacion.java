/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dominio;

import java.util.Calendar;
import java.util.Objects;

/**
 *
 * @author UriarteZuluaga
 */
public class Vacunacion extends Evento {
    
    private Vacuna vacuna;

    public Vacunacion(int laId, String elTitulo, String elTipo, String laDescripcion,
            Calendar laFecha, Hijo hijo, String elLugar, Vacuna laVacuna) {
        super(laId, elTitulo, elTipo, laDescripcion, laFecha, hijo, elLugar);
        this.vacuna = laVacuna;
    }
    
    public Vacuna getVacuna() {
        return vacuna;
    }

    public void setVacuna(Vacuna laVacuna) {
        this.vacuna = laVacuna;
    } 

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 53 * hash + Objects.hashCode(this.vacuna);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Vacunacion other = (Vacunacion) obj;
        if (!Objects.equals(this.vacuna, other.vacuna)) {
            return false;
        }
        return true;
    }
    
    
}
