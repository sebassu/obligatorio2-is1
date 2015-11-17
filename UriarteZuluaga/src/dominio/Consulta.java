package dominio;

import auxiliar.Auxiliares;
import java.util.Calendar;

public class Consulta extends Evento {

    private String medico;

    protected Consulta() {
        super();
        this.medico = "";
    }

    public Consulta(int laId, String elTitulo, String elTipo, String laDescripcion,
            Calendar laFecha, Hijo hijo, String elLugar, String elMedico) {
        super(laId, elTitulo, elTipo, laDescripcion, laFecha, hijo, elLugar);
        this.medico = elMedico;
    }

    public String getMedico() {
        return medico;
    }

    public void setMedico(String elMedico) throws IllegalArgumentException {
        if (!elMedico.isEmpty()
                && Auxiliares.noContieneCaracterAlfabetico(elMedico)) {
            throw new IllegalArgumentException("Nombre de médico inválido");
        }
        this.medico = elMedico;
    }
}
