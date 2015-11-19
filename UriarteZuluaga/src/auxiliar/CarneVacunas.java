package auxiliar;

import java.util.HashMap;

public class CarneVacunas {

    private final HashMap<String, Integer> vacunaSistematicaAPosFila;
    private final HashMap<String, Integer> vacunaNoSistematicaAPosFila;
    private final HashMap<String, Integer> mesAPosCol;
    private final HashMap<String, Integer> anioAPosCol;
    private final String[] listaAnios;
    private final String[] listaMeses;
    private final String[] listaVacunasSistematicas;
    private final String[] listaVacunasNoSistematicas;

    private void llenarHashMapConDatosArray(HashMap<String, Integer> map, String[] arreglo) {
        for (int i = 0; i < arreglo.length; i++) {
            map.put(arreglo[i], i + 1);
        }
    }

    private void llenarHashMapColumnasConAmbosArrays(HashMap<String, Integer> mesAPos,
            HashMap<String, Integer> anioAPos, String[] arregloMeses, String[] arregloAnios) {
        int cantMeses = arregloMeses.length;
        for (int i = 0; i < cantMeses; i++) {
            mesAPos.put(arregloMeses[i], i);
        }
        for (int i = 0; i < arregloAnios.length; i++) {
            anioAPos.put(arregloAnios[i], i + cantMeses);
        }
    }

    public CarneVacunas(String[] vacunasSistematicas, String[] vacunasNoSistematicas,
            String[] mesesCarne, String[] aniosCarne) {
        vacunaSistematicaAPosFila = new HashMap<>();
        vacunaNoSistematicaAPosFila = new HashMap<>();
        mesAPosCol = new HashMap<>();
        anioAPosCol = new HashMap<>();
        listaMeses = mesesCarne;
        listaAnios = aniosCarne;
        listaVacunasSistematicas = vacunasSistematicas;
        listaVacunasNoSistematicas = vacunasNoSistematicas;
        llenarHashMapConDatosArray(vacunaSistematicaAPosFila, listaVacunasSistematicas);
        llenarHashMapConDatosArray(vacunaNoSistematicaAPosFila, listaVacunasNoSistematicas);
        llenarHashMapColumnasConAmbosArrays(mesAPosCol, anioAPosCol, listaMeses, listaAnios);
    }

    public String[] getListaAnios() {
        return listaAnios;
    }

    public String[] getListaMeses() {
        return listaMeses;
    }

    public String[] getListaVacunasSistematicas() {
        return listaVacunasSistematicas;
    }

    public String[] getListaVacunasNoSistematicas() {
        return listaVacunasNoSistematicas;
    }

    public int getPosColumnaMes(String mes) {
        return mesAPosCol.get(mes);
    }

    public int getPosColumnaAnio(String anio) {
        return anioAPosCol.get(anio);
    }

    public int getPosFilVacunaSistematica(String nombreVacuna) {
        return vacunaSistematicaAPosFila.get(nombreVacuna);
    }

    public int getPosFilVacunaNoSistematica(String nombreVacuna) {
        return vacunaNoSistematicaAPosFila.get(nombreVacuna);
    }

    public int getPosColumnaFecha() {
        return 1;
    }

    public int getPosColumnaEdad() {
        return 2;
    }
}
