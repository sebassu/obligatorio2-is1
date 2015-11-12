
package dominio;

import java.io.Serializable;
import java.util.Calendar;
import java.util.Date;

public class Evento implements Serializable, Comparable {

    private int id;
    private String titulo;
    private String tipo;
    private String lugar;
    private String descripcion;
    private Calendar fecha;
    private Hijo cualHijo;
    private String notas;

    public Evento(int laId, String elTitulo, String elTipo, String laDescripcion,
            Calendar laFecha, Hijo hijo, String elLugar) {
        this.id = laId;
        this.titulo = elTitulo;
        this.tipo = elTipo;
        this.descripcion = laDescripcion;
        this.fecha = laFecha;
        this.cualHijo = hijo;
        this.lugar = elLugar;
    }

    public Evento(int laId, String elTitulo, String elTipo, String laDescripcion,
            Calendar laFecha, Hijo hijo) {
        this.id = laId;
        this.titulo = elTitulo;
        this.tipo = elTipo;
        this.descripcion = laDescripcion;
        this.fecha = laFecha;
        this.cualHijo = hijo;
        this.lugar = "";
    }

    public Evento(int laId, String elTitulo, String elTipo, Calendar laFecha, Hijo hijo,
            String elLugar) {
        this.id = laId;
        this.titulo = elTitulo;
        this.tipo = elTipo;
        this.descripcion = "";
        this.fecha = laFecha;
        this.cualHijo = hijo;
        this.lugar = elLugar;
    }

    public Evento(int laId, String elTitulo, String elTipo, Calendar laFecha, Hijo hijo) {
        this.id = laId;
        this.titulo = elTitulo;
        this.tipo = elTipo;
        this.descripcion = "";
        this.fecha = laFecha;
        this.cualHijo = hijo;
        this.lugar = "";
    }

    public Evento(int laId) {
        this.id = laId;
        this.titulo = "";
        this.tipo = "";
        this.descripcion = "";
        this.fecha.setTime(new Date());
        this.cualHijo = null;
        this.lugar = "";
    }

    protected Evento() {
        this.id = 0;
        this.titulo = "";
        this.tipo = "";
        this.descripcion = "";
        this.fecha.setTime(new Date());
        this.cualHijo = null;
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

    public Calendar getFecha() {
        return fecha;
    }

    public Hijo getCualHijo() {
        return cualHijo;
    }

    public int getId() {
        return id;
    }

    public void setId(int laId) {
        this.id = laId;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public void setFecha(Calendar fecha) {
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
