package dominio;

import java.util.Calendar;

public class Vacunacion extends Evento {

    private Vacuna vacuna;

    protected Vacunacion() {
        super();
        this.vacuna = new Vacuna();
    }

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
}
