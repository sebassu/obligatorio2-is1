package dominio;

import auxiliar.Auxiliares;
import java.io.Serializable;
import java.util.Calendar;

public class Evento implements Serializable, Comparable {

    public static final long serialVersionUID = 42L;

    private int id;
    private String titulo;
    private String tipo;
    private String lugar;
    private String descripcion;
    private Calendar fecha;
    private Hijo cualHijo;
    private String notas;

    protected Evento() throws IllegalArgumentException, NullPointerException {
        this(0, "A", "A", "", Calendar.getInstance(), new Hijo(), "");
    }

    public Evento(int laId) throws IllegalArgumentException, NullPointerException {
        this(laId, "A", "A", "", Calendar.getInstance(), new Hijo(), "");
    }

    public Evento(int laId, String elTitulo, String elTipo, Calendar laFecha, Hijo elHijo)
            throws IllegalArgumentException, NullPointerException {
        this(laId, elTitulo, elTipo, "", laFecha, elHijo, "");
    }

    public Evento(int laId, String elTitulo, String elTipo, Calendar laFecha, Hijo elHijo,
            String elLugar) throws IllegalArgumentException, NullPointerException {
        this(laId, elTitulo, elTipo, "", laFecha, elHijo, elLugar);
    }

    public Evento(int laId, String elTitulo, String elTipo, String laDescripcion,
            Calendar laFecha, Hijo elHijo) throws IllegalArgumentException, NullPointerException {
        this(laId, elTitulo, elTipo, laDescripcion, laFecha, elHijo, "");
    }

    public Evento(int laId, String elTitulo, String elTipo, String laDescripcion,
            Calendar laFecha, Hijo hijo, String elLugar)
            throws IllegalArgumentException, NullPointerException {
        this.setId(laId);
        this.setTitulo(elTitulo);
        this.setTipo(elTipo);
        this.setDescripcion(laDescripcion);
        this.setFecha(laFecha);
        this.setCualHijo(hijo);
        this.setLugar(elLugar);
    }

    public String getTitulo() {
        return titulo;
    }

    public String getLugar() {
        return lugar;
    }

    public String getTipo() {
        return tipo;
    }

    public String getNotas() {
        return notas;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public Calendar getFecha() {
        return fecha;
    }

    public Hijo getCualHijo() {
        return cualHijo;
    }

    public int getId() {
        return id;
    }

    public final void setId(int laId) {
        this.id = laId;
    }

    public final void setTipo(String elTipo) throws IllegalArgumentException {
        if (Auxiliares.noContieneCaracterAlfabetico(elTipo)) {
            throw new IllegalArgumentException("Tipo inválido.");
        } else {
            this.tipo = elTipo;
        }
    }

    public final void setDescripcion(String laDescripcion) {
        this.descripcion = laDescripcion;
    }

    public final void setNotas(String lasNotas) {
        this.notas = lasNotas;
    }

    public final void setFecha(Calendar fecha) throws NullPointerException {
        if (fecha == null) {
            throw new NullPointerException("Fecha nula.");
        } else {
            this.fecha = fecha;
        }
    }

    public final void setCualHijo(Hijo cualHijo) throws NullPointerException {
        if (cualHijo == null) {
            throw new NullPointerException("Hijo nulo.");
        } else {
            this.cualHijo = cualHijo;
        }
    }

    public final void setLugar(String elLugar) throws IllegalArgumentException {
        if (!elLugar.isEmpty()
                && Auxiliares.noContieneCaracterAlfabetico(elLugar)) {
            throw new IllegalArgumentException("Lugar inválido.");
        } else {
            this.lugar = elLugar;
        }
    }

    public final void setTitulo(String elTitulo) throws IllegalArgumentException {
        if (Auxiliares.noContieneCaracterAlfabetico(elTitulo)) {
            throw new IllegalArgumentException("Título inválido.");
        } else {
            this.titulo = elTitulo;
        }
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 23 * hash + this.id;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        final Evento other = (Evento) obj;
        return this.id == other.id;
    }

    @Override
    public int compareTo(Object obj) {
        Evento otroEvento = (Evento) obj;
        return this.getFecha().compareTo(otroEvento.getFecha());
    }
}
