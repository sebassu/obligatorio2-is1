/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dominio;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Iterator;
import java.util.Objects;

/**
 *
 * @author UriarteZuluaga
 */
public class Hijo implements Serializable, Comparable {

    private String nombre;
    private Calendar fechaNacimiento;
    private boolean esHombre;
    private String cedulaId;
    private String sociedadMedica;
    private String medicoCabecilla;
    private final ArrayList<Par<Calendar, Integer>> listaPesos;
    private final ArrayList<Par<Calendar, Integer>> listaPerimetrosCefalicos;
    private final ArrayList<Par<Calendar, Integer>> listaAlturas;
    private final ArrayList<Par<Calendar, Vacuna>> historialVacunaciones;

    private Hijo() {
        nombre = "";
        fechaNacimiento.setTime(new Date());
        esHombre = true;
        cedulaId = "9.999.999-9";
        sociedadMedica = "";
        listaPesos = new ArrayList<>();
        listaPerimetrosCefalicos = new ArrayList<>();
        listaAlturas = new ArrayList<>();
        historialVacunaciones = new ArrayList<>();
    }

    public Hijo(String laCedulaId) {
        nombre = "";
        fechaNacimiento.setTime(new Date());
        esHombre = true;
        cedulaId = laCedulaId;
        sociedadMedica = "";
        listaPesos = new ArrayList<>();
        listaPerimetrosCefalicos = new ArrayList<>();
        listaAlturas = new ArrayList<>();
        historialVacunaciones = new ArrayList<>();
    }

    public Hijo(String elNombre, Calendar laFecha, boolean elSexo, String laCedulaId,
            String laSociedadMedica) {
        nombre = elNombre;
        fechaNacimiento = laFecha;
        esHombre = elSexo;
        cedulaId = laCedulaId;
        sociedadMedica = laSociedadMedica;
        listaPesos = new ArrayList<>();
        listaPerimetrosCefalicos = new ArrayList<>();
        listaAlturas = new ArrayList<>();
        historialVacunaciones = new ArrayList<>();
    }

    public String getNombre() {
        return nombre;
    }

    public Calendar getFechaNacimiento() {
        return fechaNacimiento;
    }

    public boolean esHombre() {
        return esHombre;
    }

    public String getCedulaId() {
        return cedulaId;
    }

    public String getSociedadMedica() {
        return sociedadMedica;
    }

    public String getMedicoCabecilla() {
        return medicoCabecilla;
    }

    public void setMedicoCabecilla(String elMedicoCabecilla) {
        this.medicoCabecilla = elMedicoCabecilla;
    }

    public void setNombre(String elNombre) {
        this.nombre = elNombre;
    }

    public void setFechaNacimiento(Calendar laFechaNacimiento) {
        this.fechaNacimiento = laFechaNacimiento;
    }

    public void setGenero(boolean bool) {
        this.esHombre = bool;
    }

    public void setCedulaId(String laCedulaId) {
        this.cedulaId = laCedulaId;
    }

    public void setSociedadMedica(String laSociedadMedica) {
        this.sociedadMedica = laSociedadMedica;
    }

    public void agregarPeso(int dato, Calendar dia) {
        listaPesos.add(new Par<>(dia, dato));
    }

    public void modificarPeso(int dato, Calendar dia) {
        Par<Calendar, Integer> datoBuscado = new Par<>(dia, 0);
        listaPesos.set(listaPesos.indexOf(datoBuscado), new Par<>(dia, dato));
    }

    public Iterator<Par<Calendar, Integer>> getIteradorListaPesos() {
        return listaPesos.iterator();
    }

    public void agregarAltura(int dato, Calendar dia) {
        listaAlturas.add(new Par<>(dia, dato));
    }

    public void modificarAltura(int dato, Calendar dia) {
        Par<Calendar, Integer> datoBuscado = new Par<>(dia, 0);
        listaAlturas.set(listaAlturas.indexOf(datoBuscado), new Par<>(dia, dato));
    }

    public Iterator<Par<Calendar, Integer>> getIteradorListaAlturas() {
        return listaAlturas.iterator();
    }

    public void agregarPerimetroCefalico(int dato, Calendar dia) {
        listaPerimetrosCefalicos.add(new Par<>(dia, dato));
    }

    public void modificarPerimetroCefalico(int dato, Calendar dia) {
        Par<Calendar, Integer> datoBuscado = new Par<>(dia, 0);
        listaPerimetrosCefalicos.set(listaPerimetrosCefalicos.indexOf(datoBuscado),
                new Par<>(dia, dato));
    }

    public Iterator<Par<Calendar, Integer>> getIteradorListaPerimetrosCefalicos() {
        return listaPerimetrosCefalicos.iterator();
    }

    public void agregarVacuna(Vacuna v, Calendar dia) {
        historialVacunaciones.add(new Par<>(dia, v));
    }

    public void modificarVacuna(Vacuna v, Calendar dia) {
        Par<Calendar, Vacuna> vacunaBuscada = new Par<>(dia, v);
        historialVacunaciones.set(historialVacunaciones.indexOf(vacunaBuscada),
                new Par<>(dia, v));
    }

    public Iterator<Par<Calendar, Vacuna>> getIteradorHistorialVacunaciones() {
        return historialVacunaciones.iterator();
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        final Hijo other = (Hijo) obj;
        return Objects.equals(this.cedulaId, other.cedulaId);
    }

    @Override
    public int compareTo(Object obj) {
        Hijo otroHijo = (Hijo) obj;
        if (this.getNombre().equals(otroHijo.getNombre())) {
            return this.getCedulaId().compareTo(otroHijo.getCedulaId());
        } else {
            return this.getNombre().compareTo(otroHijo.getNombre());
        }
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 53 * hash + Objects.hashCode(this.cedulaId);
        return hash;
    }
}
