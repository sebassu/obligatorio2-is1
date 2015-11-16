package dominio;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Objects;

public class Vacuna implements Serializable, Comparable<Vacuna> {

    //Variables de instancia.
    private String nombre;
    private boolean sistematca;
    private final ArrayList<Integer> vencimientoEnMeses;
    private final ArrayList<Integer> vencimientoEnAnios;

    //Constructor.
    public Vacuna(String nom, boolean bool) throws IllegalArgumentException {
        this.setNombre(nom);
        this.setSistematca(bool);
        vencimientoEnMeses = new ArrayList<>();
        vencimientoEnAnios = new ArrayList<>();
    }

    //Constructor privado para pruebas.
    protected Vacuna() {
        this.nombre = "";
        this.sistematca = false;
        vencimientoEnMeses = new ArrayList<>();
        vencimientoEnAnios = new ArrayList<>();
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

    public void agregarVencimientoEnMeses(int dato) 
            throws IllegalStateException {
        if (!vencimientoEnMeses.contains(dato)) {
            vencimientoEnMeses.add(dato);
        } else throw new IllegalStateException();
    }
    
    public void eliminarVencimientoEnMeses(int dato) 
            throws IllegalStateException {
        Integer integerAuxiliar = dato;
        if (!vencimientoEnMeses.remove(integerAuxiliar)) 
            throw new IllegalStateException();
    }

    public void agregarVencimientoEnAnios(int dato) 
            throws IllegalStateException {
        if (!vencimientoEnAnios.contains(dato)) {
            vencimientoEnAnios.add(dato);
        } else throw new IllegalStateException();
    }
    
    public void eliminarVencimientoEnAnios(int dato) 
            throws IllegalStateException {
        Integer integerAuxiliar = dato;
        if (!vencimientoEnAnios.remove(integerAuxiliar)) 
            throw new IllegalStateException();
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
