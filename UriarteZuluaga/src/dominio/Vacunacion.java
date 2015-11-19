package dominio;

import java.util.Calendar;
import java.util.Objects;

public class Vacunacion extends Evento {

    public static final long serialVersionUID = 42L;

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

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 43 * hash + Objects.hashCode(this.vacuna);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        return super.equals(obj);
    }
}
