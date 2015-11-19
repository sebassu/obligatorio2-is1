package dominio;

import auxiliar.Par;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.Iterator;
import java.util.Objects;
import org.jfree.data.xy.XYSeries;

public class Hijo implements Serializable, Comparable {

    private String nombre;
    private Calendar fechaNacimiento;
    private boolean esHombre;
    private String cedulaId;
    private String sociedadMedica;
    private String medicoDeCabecera;
    private final ArrayList<Par<Double, Double>> listaPesos;
    private final ArrayList<Par<Double, Double>> listaPerimetrosCefalicos;
    private final ArrayList<Par<Double, Double>> listaAlturas;
    private ArrayList<Par<Vacuna,ArrayList<Calendar>>> historialVacunaciones;


    public Hijo() {
        this("9.999.999-9");
    }

    public Hijo(String laCedulaId) {
        nombre = "";
        fechaNacimiento = Calendar.getInstance();
        cedulaId = laCedulaId;
        sociedadMedica = "";
        listaPesos = new ArrayList<>();
        listaPerimetrosCefalicos = new ArrayList<>();
        listaAlturas = new ArrayList<>();
        historialVacunaciones = new ArrayList<>();
        medicoDeCabecera = "";
    }

    public Hijo(String elNombre, Calendar laFecha, boolean elSexo, String laCedulaId,
            String laSociedadMedica, String unMedico) {
        nombre = elNombre;
        fechaNacimiento = laFecha;
        esHombre = elSexo;
        cedulaId = laCedulaId;
        sociedadMedica = laSociedadMedica;
        listaPesos = new ArrayList<>();
        listaPerimetrosCefalicos = new ArrayList<>();
        listaAlturas = new ArrayList<>();
        historialVacunaciones = new ArrayList<>();
        medicoDeCabecera = unMedico;
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

    public boolean esBebe() {
        return Calendar.getInstance().get(Calendar.YEAR)
                - fechaNacimiento.get(Calendar.YEAR) < 4;
    }

    public String getCedulaId() {
        return cedulaId;
    }

    public String getMedicoDeCabecera() {
        return medicoDeCabecera;
    }

    public void setMedicoDeCabecera(String elMedicoCabecera) {
        this.medicoDeCabecera = elMedicoCabecera;
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

    public String getSociedadMedica() {
        return sociedadMedica;
    }

    public void agregarPeso(double dato, double dia) {
        listaPesos.add(new Par<>(dia, dato));
    }

    public void modificarPeso(double dato, double dia) {
        Par<Double, Double> datoBuscado = new Par<>(dia, 0D);
        listaPesos.set(listaPesos.indexOf(datoBuscado), new Par<>(dia, dato));
    }

    public Iterator<Par<Double, Double>> getIteradorListaPesos() {
        return listaPesos.iterator();
    }

    public void agregarAltura(double dato, double dia) {
        listaAlturas.add(new Par<>(dia, dato));
    }

    public void modificarAltura(double dato, double dia) {
        Par<Double, Double> datoBuscado = new Par<>(dia, 0D);
        listaAlturas.set(listaAlturas.indexOf(datoBuscado), new Par<>(dia, dato));
    }

    public Iterator<Par<Double, Double>> getIteradorListaAlturas() {
        return listaAlturas.iterator();
    }

    public void agregarPerimetroCefalico(double dato, double dia) {
        listaPerimetrosCefalicos.add(new Par<>(dia, dato));
    }

    public void modificarPerimetroCefalico(double dato, double dia) {
        Par<Double, Double> datoBuscado = new Par<>(dia, 0D);
        listaPerimetrosCefalicos.set(listaPerimetrosCefalicos.indexOf(datoBuscado),
                new Par<>(dia, dato));
    }

    public Iterator<Par<Double, Double>> getIteradorListaPerimetrosCefalicos() {
        return listaPerimetrosCefalicos.iterator();
    }

    public void agregarVacunaRecivida(Vacuna v, Calendar dia) {
        Par<Vacuna,ArrayList<Calendar>> vacunaNueva =
                new Par<>(new Vacuna(v), new ArrayList<Calendar>());
        vacunaNueva.getDato2().add(dia);
        if (!historialVacunaciones.contains(vacunaNueva)) {
            historialVacunaciones.add(vacunaNueva);
        } else {
            historialVacunaciones.get(historialVacunaciones.indexOf(
                vacunaNueva)).getDato2().add(dia);
            Collections.sort(historialVacunaciones.get(historialVacunaciones.indexOf(
                vacunaNueva)).getDato2());
        }
    }

    public void eliminarVacunaRecivida(Vacuna v) {
        Par<Vacuna,ArrayList<Calendar>> vacunaBuscada = new Par<>(v, new ArrayList<Calendar>());
        historialVacunaciones.remove(vacunaBuscada);
    }
    
    public void eliminarFechaVacunaRecivida(Vacuna v, Calendar fecha) {
        Par<Vacuna,ArrayList<Calendar>> vacunaBuscada = new Par<>(v, new ArrayList<Calendar>());
        historialVacunaciones.get(historialVacunaciones.indexOf(
                vacunaBuscada)).getDato2().remove(fecha);
    }

    public Iterator<Par<Vacuna,ArrayList<Calendar>>> getIteradorHistorialVacunaciones() {
        return historialVacunaciones.iterator();
    }
    
    public XYSeries obtenerPesosParaGrafica() {
        XYSeries pesos = new XYSeries("Peso por Edad");
        Iterator<Par<Double, Double>> itListaPesos =
                listaPesos.iterator();
        while (itListaPesos.hasNext()) {
            
            Par<Double, Double> estePar = itListaPesos.next();
            pesos.add(estePar.getDato1(), estePar.getDato2());
        }
        
        return pesos;
    }
    
    public XYSeries obtenerEstaturaParaGrafica() {
        XYSeries estaturas = new XYSeries("Longitud / Estatura por Edad");
        Iterator<Par<Double, Double>> itListaEstaturas =
                listaPesos.iterator();
        while (itListaEstaturas.hasNext()) {
            
            Par<Double, Double> estePar = itListaEstaturas.next();
            estaturas.add(estePar.getDato1(), estePar.getDato2());
        }
        
        return estaturas;
    }
    
    public XYSeries obtenerPerimCefalicoParaGrafica() {
        XYSeries perimCefalico = new XYSeries("Perímetro Cefálico por Edad");
        Iterator<Par<Double, Double>> itListaPerimetros =
                listaPesos.iterator();
        while (itListaPerimetros.hasNext()) {
            
            Par<Double, Double> estePar = itListaPerimetros.next();
            perimCefalico.add(estePar.getDato1(), estePar.getDato2());
        }
        
        return perimCefalico;
    }
    
    public XYSeries obtenerPesoEstaturaParaGrafica() {
        XYSeries pesosEstaturas = new XYSeries("Peso por Estatura");
        Iterator<Par<Double, Double>> itListaEstaturas =
                listaPesos.iterator();
        Iterator<Par<Double, Double>> itListaPesos =
                listaPesos.iterator();
        while (itListaEstaturas.hasNext() && itListaPesos.hasNext()) {
            
            Par<Double, Double> esteParEstatura = itListaEstaturas.next();
            Par<Double, Double> esteParPeso = itListaPesos.next();
            pesosEstaturas.add(esteParEstatura.getDato2(), esteParPeso.getDato2());
        }
        
        return pesosEstaturas;
    }
    
    public int mesesDesdeNacimientoAFecha(Calendar fecha) {
  
        return ((fechaNacimiento.get(Calendar.YEAR)) 
                - fecha.get(Calendar.YEAR)) * 12 + 
                fechaNacimiento.get(Calendar.MONTH) - fecha.get(Calendar.MONTH);
    }
    
    public int aniosDesdeNacimientoAFecha(Calendar fecha) {
  
        return ((fechaNacimiento.get(Calendar.YEAR)) 
                - fecha.get(Calendar.YEAR));
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

    @Override
    public String toString() {
        return nombre;
    }
}
