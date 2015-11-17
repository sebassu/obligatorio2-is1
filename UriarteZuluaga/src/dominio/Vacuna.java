package dominio;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Objects;

public class Vacuna implements Serializable, Comparable<Vacuna> {

    //Variables de instancia.
    private String nombre;
    private boolean sistematca;
    private final ArrayList<String> vencimientoEnMeses;
    private final ArrayList<String> vencimientoEnAnios;
    private String descripcion;

    //Constructor.
    public Vacuna(String nom, boolean bool, String descrip)
            throws IllegalArgumentException {
        setNombre(nom);
        setSistematca(bool);
        vencimientoEnMeses = new ArrayList<>();
        vencimientoEnAnios = new ArrayList<>();
        descripcion = descrip;
    }

    //Constructor privado para pruebas.
    protected Vacuna() {
        nombre = "";
        sistematca = false;
        vencimientoEnMeses = new ArrayList<>();
        vencimientoEnAnios = new ArrayList<>();
        descripcion = "";
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

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public void agregarVencimientoEnMeses(String dato)
            throws IllegalStateException {
        if (this.esSistematca()) {
            if (!vencimientoEnMeses.contains(dato)) {
                vencimientoEnMeses.add(dato);
            } else {
                throw new IllegalStateException("El mes " + dato + " ya está "
                        + "agregado en " + this.getNombre());
            }
        } else {
            throw new IllegalStateException("Esta vacuna no es Sistemática");
        }
    }

    public void eliminarVencimientoEnMeses(String dato)
            throws IllegalStateException {
        if (this.esSistematca()) {
            if (!vencimientoEnMeses.remove(dato)) {
                throw new IllegalStateException("El mes " + dato + " no está "
                        + "agregado en " + this.getNombre());
            }
        } else {
            throw new IllegalStateException("Esta vacuna no es Sistemática");
        }
    }

    public void agregarVencimientoEnAnios(String dato)
            throws IllegalStateException {
        if (this.esSistematca()) {
            if (!vencimientoEnAnios.contains(dato)) {
                vencimientoEnAnios.add(dato);
            } else {
                throw new IllegalStateException("El año " + dato + " ya está "
                        + "agregado en " + this.getNombre());
            }
        } else {
            throw new IllegalStateException("Esta vacuna no es Sistemática");
        }
    }

    public void eliminarVencimientoEnAnios(String dato)
            throws IllegalStateException {
        if (this.esSistematca()) {
            if (!vencimientoEnAnios.remove(dato)) {
                throw new IllegalStateException("El año " + dato + " no está "
                        + "agregado en " + this.getNombre());
            }
        } else {
            throw new IllegalStateException("Esta vacuna no es Sistemática");
        }
    }

    public void ordenarListas() {
        Comparator<String> numerosPrimero = new Comparator<String>() {
            @Override
            public int compare(String uno, String dos) {
                boolean unoEmpiezaConLetra = Character.isLetter(uno.charAt(0));
                boolean dosEmpiezaConLetra = Character.isLetter(dos.charAt(0));

                if (!unoEmpiezaConLetra && !dosEmpiezaConLetra) {
                    return Integer.parseInt(uno) - Integer.parseInt(dos);
                } else if (unoEmpiezaConLetra && dosEmpiezaConLetra) {
                    String[] unoCortado = uno.split("/");
                    String[] dosCortado = dos.split("/");
                    return Integer.parseInt(unoCortado[1])
                            - Integer.parseInt(dosCortado[1]);
                } else {
                    return 1;
                }
            }
        };
        Collections.sort(vencimientoEnMeses, numerosPrimero);
        Collections.sort(vencimientoEnAnios, numerosPrimero);
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
