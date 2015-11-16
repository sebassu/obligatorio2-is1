package dominio;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import persistencia.ArchivoLectura;
import auxiliar.Validaciones;

public class Sistema implements Serializable {

    private final ArrayList<Hijo> listaHijos;
    private final ArrayList<Vacuna> listaVacunas;
    private final ArrayList<Evento> eventosRealizados;
    private final ArrayList<Evento> eventosARealizar;
    private int proximaIdAAsignar;

    public Sistema() {
        listaHijos = new ArrayList<>();
        listaVacunas = new ArrayList<>();
        eventosRealizados = new ArrayList<>();
        eventosARealizar = new ArrayList<>();
        proximaIdAAsignar = Integer.MIN_VALUE;
    }

    public void agregarEvento(Evento elEvento) {
        if (Validaciones.esFechaFutura(elEvento.getFecha())) {
            eventosARealizar.add(elEvento);
            Collections.sort(eventosARealizar);
        } else {
            eventosRealizados.add(elEvento);
            Collections.sort(eventosRealizados);
        }
        proximaIdAAsignar++;
    }

    public void modificarEventoEnListaCorrespondiente(Evento elEvento)
            throws IllegalStateException {
        int pos = eventosARealizar.indexOf(elEvento);
        if (pos == -1) {
            pos = eventosRealizados.indexOf(elEvento);
            if (pos == -1) {
                throw new IllegalStateException("No existe un evento con esta ID");
            } else {
                eventosRealizados.set(pos, elEvento);
                Collections.sort(eventosRealizados);
            }
        } else {
            eventosARealizar.set(pos, elEvento);
            Collections.sort(eventosARealizar);
        }
    }

    public boolean esEsteTipo(String elTipo, String tipoEsperado) {
        return elTipo.replaceAll("\\W", "").equals(tipoEsperado);
    }

    protected boolean esEventoValido(String elTitulo, String laDescripcion,
            Calendar laFecha, Hijo hijo, String elLugar)
            throws IllegalArgumentException {
        boolean esValido = false;
        if (Validaciones.noContieneCaracterAlfabetico(elTitulo)) {
            throw new IllegalArgumentException("El título es inválido");
        } else if (Validaciones.noContieneCaracterAlfabetico(elLugar)) {
            throw new IllegalArgumentException("El lugar es inválido");
        } else if (Validaciones.esFechaAntesDeNacimiento(hijo.getFechaNacimiento(), laFecha)) {
            throw new IllegalArgumentException("Esa fecha es antes del nacimiento"
                    + "de su hijo/a");
        } else {
            esValido = true;
        }
        return esValido;
    }

    protected boolean esHijoValido(String elNombre, Calendar laFecha,
            String laCedulaId, String laSociedadMedica)
            throws IllegalArgumentException {
        if (Validaciones.esFechaFutura(laFecha)) {
            throw new IllegalArgumentException("La fecha ingresada es inválida");
        } else if (Validaciones.noContieneCaracterAlfabetico(elNombre)) {
            throw new IllegalArgumentException("El nombre es inválido");
        } else if (Validaciones.esCedulaInvalida(laCedulaId)) {
            throw new IllegalArgumentException("La cedula es inválida");
        } else if (Validaciones.noContieneCaracterAlfabetico(laSociedadMedica)) {
            throw new IllegalArgumentException("El nombre de la sociedad Médica "
                    + "es inválido");
        }
        return true;
    }

    public void agregarHijo(String elNombre, Calendar laFecha, boolean esHombre,
            String laCedulaId, String laSociedadMedica, String medicoCab)
            throws IllegalArgumentException, IllegalStateException {
        if (esHijoValido(elNombre, laFecha, laCedulaId, laSociedadMedica)) {
            Hijo hijoAAgregar = new Hijo(elNombre, laFecha, esHombre, laCedulaId,
                    laSociedadMedica, medicoCab);
            if (listaHijos.contains(hijoAAgregar)) {
                throw new IllegalStateException("Los datos ingresados corresponden "
                        + "a un hijo/a ya ingresado.");
            } else {
                listaHijos.add(hijoAAgregar);
                Collections.sort(listaHijos);
            }
        }
    }

    public void modificarHijo(String elNombre, Calendar laFecha, boolean esHombre,
            String laCedulaId, String laSociedadMedica, String elMedico, String laCedulaAnterior)
            throws IllegalArgumentException, IllegalStateException {
        if (esHijoValido(elNombre, laFecha, laCedulaId, laSociedadMedica)) {
            Hijo hijoAModificar = new Hijo(laCedulaAnterior);
            int pos = listaHijos.indexOf(hijoAModificar);
            if (pos == -1) {
                throw new IllegalStateException("Los datos ingresados no corresponden "
                        + "a un hijo/a ya ingresado.");
            } else {
                Hijo aux = listaHijos.get(pos);
                aux.setNombre(elNombre);
                aux.setCedulaId(laCedulaId);
                aux.setFechaNacimiento(laFecha);
                aux.setGenero(esHombre);
                aux.setMedicoDeCabecera(elMedico);
                aux.setSociedadMedica(laSociedadMedica);
                Collections.sort(listaHijos);
            }
        }
    }

    public Hijo getHijo(int pos) throws IndexOutOfBoundsException {
        return listaHijos.get(pos);
    }

    public ArrayList<Hijo> getHijos() throws IllegalStateException {
        if (listaHijos.isEmpty()) {
            throw new IllegalStateException("La lista de hijos es vacía");
        } else {
            return listaHijos;
        }
    }

    public Evento getEvento(int pos) throws IndexOutOfBoundsException {
        return eventosARealizar.get(pos);
    }

    public int getCantidadEventosARealizar() {
        return eventosARealizar.size();
    }

    public int getCantidadHijos() {
        return listaHijos.size();
    }

    public int getCantidadVacunas() {
        return listaVacunas.size();
    }

    public void eliminarHijo(String laCedulaId) throws IllegalStateException {
        Hijo hijoABorrar = new Hijo(laCedulaId);
        if (listaHijos.contains(hijoABorrar)) {
            listaHijos.remove(hijoABorrar);
            Collections.sort(listaHijos);
        } else {
            throw new IllegalStateException("Los datos ingresados no corresponden "
                    + "a un hijo/a ya ingresado.");
        }
    }

    public void eliminarHijoPorPos(int posicion) throws NullPointerException {
        listaHijos.remove(posicion);
    }

    public String cargarVacunasSistematicas(ArchivoLectura archivoLeido,
            int numeroLinea) throws IOException, IllegalArgumentException {
        String nombre = "";
        String meses = "";
        String anios = "";
        String descripcion = "";
        String linea = "";
        int cantRenglones = 0;
        boolean error = false;
        boolean vacunaTerminada = false;
        boolean saltearEspacioEnBlanco = true;
        while (archivoLeido.hayMasLineas()) {
            linea = archivoLeido.linea().trim();
            if (!saltearEspacioEnBlanco) {
                numeroLinea++;
                String[] datosEnLinea = linea.split(":");
                switch (datosEnLinea[0]) {
                    case "N":
                        if (nombre.equals("") && datosEnLinea.length > 1) {
                            nombre = datosEnLinea[1].trim();
                        } else {
                            error = true;
                        }
                        break;
                    case "M":
                        if (meses.equals("") && datosEnLinea.length > 1) {
                            meses = datosEnLinea[1].trim();
                        } else {
                            error = true;
                        }
                        break;
                    case "A":
                        if (anios.equals("") && datosEnLinea.length > 1) {
                            anios = datosEnLinea[1].trim();
                        } else {
                            error = true;
                        }
                        break;
                    case "D":
                        if (descripcion.equals("") && datosEnLinea.length > 1) {
                            descripcion = datosEnLinea[1].trim();
                            vacunaTerminada = true;
                        } else {
                            error = true;
                        }
                        break;
                    case "-NO SISTEMATICAS-":
                        return datosEnLinea[0];
                    default:
                        throw new IllegalArgumentException("Una vacuna no tiene "
                                + "el campo de información '" + datosEnLinea[0] + "'");
                }
                cantRenglones++;
                if (cantRenglones == 4) {
                    vacunaTerminada = true;
                }
                if (vacunaTerminada) {
                    if (!nombre.equals("") && !meses.equals("")
                            && !anios.equals("") && !descripcion.equals("")) {

                        procesarVacunaSistematica(nombre, meses, anios, descripcion);
                        vacunaTerminada = false;
                        nombre = "";
                        meses = "";
                        anios = "";
                        descripcion = "";
                        saltearEspacioEnBlanco = true;
                        cantRenglones = 0;
                    } else {
                        throw new IllegalArgumentException("Una vacuna tenia un formato "
                                + "incorrecto y no se pudo procesar");
                    }
                }
            } else if (linea.equals("")) {
                saltearEspacioEnBlanco = false;
            } else {
                error = true;
            }

            if (error) {
                throw new IllegalArgumentException("Error en linea " + numeroLinea
                        + ", no se esperaba '" + linea + "'");
            }
        }
        return "";
    }

    public void procesarVacunaSistematica(String nombre, String meses, String anios,
            String descripcion) throws IllegalArgumentException, NumberFormatException {

        Vacuna vacunaNueva;
        if (!esNombreInvalido(nombre.trim())) {
            vacunaNueva = new Vacuna(nombre, true, descripcion);
            String[] mes = meses.split(" ");
            String[] anio = anios.split(" ");
            if (!meses.equals("-")) {
                for (int i = 0; i < mes.length; i++) {
                    if (mesValido(mes[i])) {
                        vacunaNueva.agregarVencimientoEnMeses(mes[i]);
                    } else {
                        throw new IllegalArgumentException("En la vacuna " + nombre
                                + " el mes " + mes[i] + " es inválido");
                    }
                }
            }
            if (!anios.equals("-")) {
                for (int i = 0; i < anio.length; i++) {
                    if (anioValido(anio[i])) {
                        vacunaNueva.agregarVencimientoEnAnios(anio[i]);
                    } else {
                        throw new IllegalArgumentException("En la vacuna " + nombre
                                + " el año " + anio[i] + " es inválido");
                    }
                }
            }
            vacunaNueva.ordenarListas();
            listaVacunas.add(vacunaNueva);
        } else {
            throw new IllegalArgumentException("El nombre de vacuna " + nombre
                    + " es inválido");
        }
    }
    
    public boolean esNumeroNatural(String num) {
        
        for (int i = 0; i < num.length(); i++) {
            if (!Character.isDigit(num.charAt(i)))
                return false;
        }
        return !num.equals("");
    }
    
    public boolean mesValido(String mes) {
        
        if (esNumeroNatural(mes)) {
            int intMes = Integer.parseInt(mes);
            return intMes < mesMaximoIngresable();
        }
        return periodoMesValido(mes);
    }
    
    public boolean periodoMesValido(String periodo) {
        
        if (periodo.length() > 2) {
            if (periodo.charAt(0) == 'c' && periodo.charAt(1) == '/') {
                String[] separarMes = periodo.split("/");
                if (separarMes.length > 1)
                return mesValido(separarMes[1]);
            }
        }
        return false;
    }
    
    public boolean periodoAnioValido(String periodo) {
        
        if (periodo.length() > 2) {
            if (periodo.charAt(0) == 'c' && periodo.charAt(1) == '/') {
                String[] separarAnio = periodo.split("/");
                if (separarAnio.length > 1)
                return anioValido(separarAnio[1]);
            }
        }
        return false;
    }
    
    public boolean anioValido(String anio) {
        
         if (esNumeroNatural(anio)) {
            int intAnio = Integer.parseInt(anio);
            return intAnio < anioMaximoIngresable();
        } 
        return periodoAnioValido(anio);
    }

    public void cargarVacunasNoSistematicas(ArchivoLectura archivoLeido,
            int numeroLinea) throws IOException, IllegalArgumentException {
        String nombre = "";
        String descripcion = "";
        int cantRenglones = 0;
        boolean error = false;
        boolean vacunaTerminada = false;
        boolean saltearEspacioEnBlanco = true;
        while (archivoLeido.hayMasLineas()) {
            String linea = archivoLeido.linea().trim();
            if (!saltearEspacioEnBlanco) {
                numeroLinea++;
                String[] datosEnLinea = linea.split(":");
                switch (datosEnLinea[0]) {
                    case "N":
                        if (nombre.equals("") && datosEnLinea.length > 1) {
                            nombre = datosEnLinea[1].trim();
                        } else {
                            error = true;
                        }
                        break;
                    case "D":
                        if (descripcion.equals("") && datosEnLinea.length > 1) {
                            descripcion = datosEnLinea[1].trim();
                            vacunaTerminada = true;
                        } else {
                            error = true;
                        }
                        break;
                    default:
                        throw new IllegalArgumentException("Una vacuna no tiene "
                                + "el campo de información '" + datosEnLinea[0]);
                }
                cantRenglones++;
                if (cantRenglones == 2) {
                    vacunaTerminada = true;
                }
                if (vacunaTerminada) {
                    if (!nombre.equals("") && !descripcion.equals("")) {

                        procesarVacunaNoSistematica(nombre, descripcion);
                        vacunaTerminada = false;
                        nombre = "";
                        descripcion = "";
                        saltearEspacioEnBlanco = true;
                    } else {
                        throw new IllegalArgumentException("Una vacuna tenia un formato "
                                + "incorrecto y no se pudo procesar");
                    }
                }
            } else if (linea.equals("")) {
                saltearEspacioEnBlanco = false;
            } else {
                error = true;
            }

            if (error) {
                throw new IllegalArgumentException("Error en linea " + numeroLinea
                        + ", no se esperaba '" + linea + "'");
            }
        }
    }

    public void procesarVacunaNoSistematica(String nombre, String descripcion)
            throws IllegalArgumentException, NumberFormatException {

        Vacuna vacunaNueva;
        if (!Validaciones.noContieneCaracterAlfabetico(nombre.trim())) {
            vacunaNueva = new Vacuna(nombre, true, descripcion);
            listaVacunas.add(vacunaNueva);
        } else {
            throw new IllegalArgumentException("El nombre de vacuna " + nombre
                    + " es inválido");
        }
    }

    int anioMaximoIngresable() {

        return 12;
    }

    int mesMaximoIngresable() {

        return anioMaximoIngresable() * 12;
    }

    public void cargarVacunasDeArchivo(String ubicacion) throws IllegalArgumentException,
            FileNotFoundException, IOException {
        ArchivoLectura archivoLeido = new ArchivoLectura(ubicacion);
        int numeroLinea = 0;
        if (archivoLeido.hayMasLineas()) {
            String linea = archivoLeido.linea().trim();
            numeroLinea++;
            switch (linea) {
                case "-SISTEMATICAS-":
                    linea = cargarVacunasSistematicas(archivoLeido, numeroLinea);
                    if (linea.equals("-NO SISTEMATICAS-")) {
                        cargarVacunasNoSistematicas(archivoLeido, numeroLinea);
                    }
                    break;
                default:
                    throw new IllegalArgumentException("Error, se encontró un"
                            + "título desconocido: '" + linea + "'");
            }
        }
        archivoLeido.cerrar();
    }
}
