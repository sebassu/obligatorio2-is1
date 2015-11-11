
package dominio;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

public class Evento implements Serializable, Comparable {

    private String titulo;
    private String tipo;
    private String lugar;
    private String descripcion;
    private Date fecha;
    private Hijo cualHijo;
    private String notas;

    public Evento(String elTitulo, String elTipo, String laDescripcion,
            Date laFecha, Hijo hijo, String elLugar) {
        this.titulo = elTitulo;
        this.tipo = elTipo;
        this.descripcion = laDescripcion;
        this.fecha = laFecha;
        this.cualHijo = hijo;
        this.lugar = elLugar;
    }

    public Evento(String elTitulo, String elTipo, String laDescripcion,
            Date laFecha, Hijo hijo) {
        this.titulo = elTitulo;
        this.tipo = elTipo;
        this.descripcion = laDescripcion;
        this.fecha = laFecha;
        this.cualHijo = hijo;
        this.lugar = "";
    }

    public Evento(String elTitulo, String elTipo, Date laFecha, Hijo hijo,
            String elLugar) {
        this.titulo = elTitulo;
        this.tipo = elTipo;
        this.descripcion = "";
        this.fecha = laFecha;
        this.cualHijo = hijo;
        this.lugar = elLugar;
    }

    public Evento(String elTitulo, String elTipo, Date laFecha, Hijo hijo) {
        this.titulo = elTitulo;
        this.tipo = elTipo;
        this.descripcion = "";
        this.fecha = laFecha;
        this.cualHijo = hijo;
        this.lugar = "";
    }

    private Evento() {
        this.titulo = "";
        this.tipo = "";
        this.descripcion = "";
        this.fecha = new Date();
        this.cualHijo = new Hijo("", new Date(), 'x', "9.999.999-9", "");
        this.lugar = "";
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

    public String getDescripcion() {
        return descripcion;
    }

    public Date getFecha() {
        return fecha;
    }

    public Hijo getCualHijo() {
        return cualHijo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public void setCualHijo(Hijo cualHijo) {
        this.cualHijo = cualHijo;
    }

    public void setLugar(String elLugar) {
        this.lugar = elLugar;
    }

    public void setTitulo(String elTitulo) {
        this.titulo = elTitulo;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 89 * hash + Objects.hashCode(this.tipo);
        hash = 89 * hash + Objects.hashCode(this.lugar);
        hash = 89 * hash + Objects.hashCode(this.descripcion);
        hash = 89 * hash + Objects.hashCode(this.fecha);
        hash = 89 * hash + Objects.hashCode(this.cualHijo);
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
        final Evento other = (Evento) obj;
        if (!Objects.equals(this.tipo, other.tipo)) {
            return false;
        }
        if (!Objects.equals(this.lugar, other.lugar)) {
            return false;
        }
        if (!Objects.equals(this.descripcion, other.descripcion)) {
            return false;
        }
        if (!Objects.equals(this.fecha, other.fecha)) {
            return false;
        }
        if (!Objects.equals(this.cualHijo, other.cualHijo)) {
            return false;
        }
        return true;
    }

    @Override
    public int compareTo(Object obj) {
        Evento otroEvento = (Evento) obj;
        return this.getFecha().compareTo(otroEvento.getFecha());
    }
}
