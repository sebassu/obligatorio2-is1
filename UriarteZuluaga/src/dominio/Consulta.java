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
public class Consulta extends Evento {
    
    private String medico;

    public Consulta(int laId, String elTitulo, String elTipo, String laDescripcion,
            Calendar laFecha, Hijo hijo, String elLugar, String elMedico) {
        super(laId, elTitulo, elTipo, laDescripcion, laFecha, hijo, elLugar);
        this.medico = elMedico;
    }
    
    public String getVacuna() {
        return medico;
    }

    public void setVacuna(String elMedico) {
        this.medico = elMedico;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 97 * hash + Objects.hashCode(this.medico);
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
        final Consulta other = (Consulta) obj;
        if (!Objects.equals(this.medico, other.medico)) {
            return false;
        }
        return true;
    }
    
    
}
