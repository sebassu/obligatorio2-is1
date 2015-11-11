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
public class Consulta extends Evento {
    
    private String medico;

    public Consulta(String elTitulo, String elTipo, String laDescripcion,
            Calendar laFecha, Hijo hijo, String elLugar, String elMedico) {
        super(elTitulo, elTipo, laDescripcion, laFecha, hijo, elLugar);
        this.medico = elMedico;
    }
    
    public String getVacuna() {
        return medico;
    }

    public void setVacuna(String elMedico) {
        this.medico = elMedico;
    }
}
