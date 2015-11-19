package dominio;

import auxiliar.Auxiliares;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.Objects;

public class Vacuna implements Serializable, Comparable<Vacuna> {

    public static final long serialVersionUID = 42L;

    //Variables de instancia.
    private String nombre;
    private boolean sistematica;
    private ArrayList<String> vencimientoEnMeses;
    private ArrayList<String> vencimientoEnAnios;
    private String ultimoVencimientoEliminado;
    private String descripcion;

    //Constructor.
    public Vacuna(String nom, boolean bool, String descrip)
            throws IllegalArgumentException {
        nombre = nom;
        sistematica = bool;
        vencimientoEnMeses = new ArrayList<>();
        vencimientoEnAnios = new ArrayList<>();
        descripcion = descrip;
        ultimoVencimientoEliminado = "0";
    }

    public Vacuna(Vacuna vacunaACopiar) {

        nombre = vacunaACopiar.nombre;
        sistematica = vacunaACopiar.sistematica;
        descripcion = vacunaACopiar.descripcion;
        vencimientoEnMeses
                = (ArrayList<String>) vacunaACopiar.vencimientoEnMeses.clone();
        vencimientoEnAnios
                = (ArrayList<String>) vacunaACopiar.vencimientoEnAnios.clone();
        ultimoVencimientoEliminado = vacunaACopiar.ultimoVencimientoEliminado;
    }

    //Constructor privado para pruebas.
    protected Vacuna() {
        nombre = "";
        sistematica = false;
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
        this.sistematica = unBooleano;
    }

    public String getNombre() {
        return nombre;
    }

    public boolean esSistematica() {
        return sistematica;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public void agregarVencimientoEnMeses(String dato)
            throws IllegalStateException {
        if (this.esSistematica()) {
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

    public void eliminarVencimientoMasReciente() {
        boolean eliminado = false;
        if (vencimientoEnMeses.size() > 0) {
            String vencimientoAEliminar = vencimientoEnMeses.get(0);
            if (vencimientoAEliminar.charAt(0) != 'c') {
                ultimoVencimientoEliminado = "m" + vencimientoAEliminar;
                eliminarVencimientoEnMeses(vencimientoAEliminar);
                eliminado = true;
            }
        }
        if (!eliminado) {
            if (vencimientoEnAnios.size() > 0) {
                String vencimientoAEliminar = vencimientoEnAnios.get(0);
                if (vencimientoAEliminar.charAt(0) != 'c') {
                    ultimoVencimientoEliminado = "a" + vencimientoAEliminar;
                    eliminarVencimientoEnAnios(vencimientoAEliminar);
                    eliminado = true;
                }
            }
            if (!eliminado) {
                throw new IllegalStateException("No hay vencimientos para eliminar");
            }
        }
    }

    public String getUltimoVencimientoEliminado() {
        return ultimoVencimientoEliminado;
    }

    public void setUltimoVencimientoEliminado(String ultimoVencimientoEliminado) {
        this.ultimoVencimientoEliminado = ultimoVencimientoEliminado;
    }

    public String getSiguienteVencimiento() {

        if (vencimientoEnMeses.size() > 0) {
            String vencimientoSiguiente = vencimientoEnMeses.get(0);
            if (vencimientoSiguiente.charAt(0) != 'c') {
                return vencimientoSiguiente;

            } else if (vencimientoEnAnios.isEmpty()) {
                return vencimientoSiguiente;
            }
        } else {
            if (vencimientoEnAnios.size() > 0) {
                String vencimientoSiguiente = vencimientoEnAnios.get(0);
                return vencimientoSiguiente;
            }
        }
        throw new IllegalStateException("No hay vencimientos para conseguir");
    }

    public ArrayList<String> getVencimientoEnMeses() {
        return vencimientoEnMeses;
    }

    public void setVencimientoEnMeses(ArrayList<String> vencimientoEnMeses) {
        this.vencimientoEnMeses = vencimientoEnMeses;
    }

    public ArrayList<String> getVencimientoEnAnios() {
        return vencimientoEnAnios;
    }

    public void setVencimientoEnAnios(ArrayList<String> vencimientoEnAnios) {
        this.vencimientoEnAnios = vencimientoEnAnios;
    }

    public String getPeriodoEntreSiguienteVencimientoYAnteriorEnMeses() {
        StringBuilder buf = new StringBuilder();
        for (int i = 1; i < ultimoVencimientoEliminado.length(); i++) {
            buf.append(ultimoVencimientoEliminado.charAt(i));
        }
        String periodo = buf.toString();
        if (ultimoVencimientoEliminado.charAt(0) == 'm') {
            if (!vencimientoEnMeses.isEmpty() && vencimientoEnMeses.get(0).charAt(0) != 'c') {
                int valorPeriodo = Integer.parseInt(vencimientoEnMeses.get(0))
                        - Integer.parseInt(periodo);
                return valorPeriodo + "";
            }
        } else if (ultimoVencimientoEliminado.charAt(0) == 'a') {
            if (!vencimientoEnAnios.isEmpty() && vencimientoEnAnios.get(0).charAt(0) != 'c') {
                int valorPeriodo = Integer.parseInt(vencimientoEnAnios.get(0)) * 12
                        - Integer.parseInt(periodo);
                return valorPeriodo + "";
            }
        } else {
            return getSiguienteVencimiento();
        }
        throw new IllegalStateException("Hubo un problema y no se pudo devolver "
                + "el periodo entre vencimiento siguiente y anterior");
    }

    public void eliminarVencimientoEnMeses(String dato)
            throws IllegalStateException {
        if (this.esSistematica()) {
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
        if (this.esSistematica()) {
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
        if (this.esSistematica()) {
            if (!vencimientoEnAnios.remove(dato)) {
                throw new IllegalStateException("El año " + dato + " no está "
                        + "agregado en " + this.getNombre());
            }
        } else {
            throw new IllegalStateException("Esta vacuna no es Sistemática");
        }
    }

    public void ordenarListas() {
        Comparator<String> numerosPrimero
                = Auxiliares.getComparadorNumerosPrimeroLetrasLuego();
        Collections.sort(vencimientoEnMeses, numerosPrimero);
        Collections.sort(vencimientoEnAnios, numerosPrimero);
    }

    public Iterator<String> iteradorVencimientoEnMeses() {
        return vencimientoEnMeses.iterator();
    }

    public Iterator<String> iteradorVencimientoEnAnios() {
        return vencimientoEnAnios.iterator();
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
        hash = 89 * hash + (this.sistematica ? 1 : 0);
        return hash;
    }

    @Override
    public int compareTo(Vacuna o) {
        return this.getNombre().compareTo(o.getNombre());
    }

    @Override
    public String toString() {
        return nombre;
    }
}
