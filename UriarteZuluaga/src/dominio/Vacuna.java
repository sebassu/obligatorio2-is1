package dominio;

import java.io.Serializable;
import java.util.Objects;

public class Vacuna implements Serializable, Comparable<Vacuna> {

    //Variables de instancia.
    private String nombre;
    private boolean sistematca;
    private int primeraAplicacion;
    private int expiracion;
    private int cantidadAplicaciones;

    //Constructor.
    public Vacuna(String nom, boolean bool, int primeraAp,
            int exp, int cantAp) throws IllegalArgumentException {
        this.setNombre(nom);
        this.setSistematca(bool);
        this.setExpiracion(exp);
        this.setCantidadAplicaciones(cantAp);
    }

    //Constructor privado para pruebas.
    protected Vacuna() {
        this.nombre = "";
        this.sistematca = false;
    }

    //Métodos de Acceso y Modificación.
    public final void setNombre(String unNombre) throws IllegalArgumentException {
        if (unNombre.replaceAll("\\W", "").replaceAll("\\d+", "").isEmpty()) {
            throw new IllegalArgumentException("Nombre inválido");
        } else {
            this.nombre = unNombre.trim();
        }
    }

    public final void setSistematca(boolean unBooleano) {
        this.sistematca = unBooleano;
    }

    public String getNombre() {
        return nombre;
    }

    public boolean esSistematca() {
        return sistematca;
    }

    public int getPrimeraAplicacion() {
        return primeraAplicacion;
    }

    public final void setPrimeraAplicacion(int primeraAplicacion) {
        this.primeraAplicacion = primeraAplicacion;
    }

    public int getExpiracion() {
        return expiracion;
    }

    public final void setExpiracion(int expiracion) {
        this.expiracion = expiracion;
    }

    public int getCantidadAplicaciones() {
        return cantidadAplicaciones;
    }

    public final void setCantidadAplicaciones(int cantidadAplicaciones) {
        this.cantidadAplicaciones = cantidadAplicaciones;
    }

    /**
     * Comparación entre vacunas - Se valida la unicidad del nombre.
     *
     * @param unObject Vacuna a comparar.
     * @return true si los nombres de cada vacuna son iguales, false si no lo
     * son.
     */
    @Override
    public boolean equals(Object unObject) {
        boolean ret = false;
        if (unObject != null && unObject instanceof Vacuna) {
            Vacuna otraVacuna = (Vacuna) unObject;
            ret = this.getNombre().equals(otraVacuna.getNombre());
        }
        return ret;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 89 * hash + Objects.hashCode(this.nombre);
        hash = 89 * hash + (this.sistematca ? 1 : 0);
        return hash;
    }

    @Override
    public int compareTo(Vacuna o) {
        return this.getNombre().compareTo(o.getNombre());
    }
}
