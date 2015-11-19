package dominio;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import persistencia.ArchivoLectura;
import auxiliar.Auxiliares;
import auxiliar.Par;
import java.util.Iterator;

public class Sistema implements Serializable {

    private final ArrayList<Hijo> listaHijos;
    private final ArrayList<Vacuna> listaVacunas;
    private final ArrayList<Evento> eventosRealizados;
    private final ArrayList<Evento> eventosARealizar;
    public static int proximaIDEventos = Integer.MIN_VALUE;

    public Sistema() {
        listaHijos = new ArrayList<>();
        listaVacunas = new ArrayList<>();
        eventosRealizados = new ArrayList<>();
        eventosARealizar = new ArrayList<>();
    }

    public void agregarEvento(Evento elEvento) {
        eventosARealizar.add(elEvento);
        Collections.sort(eventosARealizar);
    }

    public void modificarEvento(Evento eventoAAgregar, int posEventoAModificar) {
        int idAnterior = eventosARealizar.get(posEventoAModificar).getId();
        eventoAAgregar.setId(idAnterior);
        eventosARealizar.set(posEventoAModificar, eventoAAgregar);
        proximaIDEventos--;
        Collections.sort(eventosARealizar);
    }

    public void reordenarListaEventosARealizar() {
        Collections.sort(eventosARealizar);
    }

    protected boolean esHijoValido(String elNombre, Calendar laFecha,
            String laCedulaId, String laSociedadMedica, String medicoCab)
            throws IllegalArgumentException {
        if (Auxiliares.esFechaFutura(laFecha)) {
            throw new IllegalArgumentException("La fecha ingresada es inválida.");
        } else if (Auxiliares.noContieneCaracterAlfabetico(elNombre)) {
            throw new IllegalArgumentException("El nombre es inválido.");
        } else if (Auxiliares.esCedulaInvalida(laCedulaId)) {
            throw new IllegalArgumentException("La cedula es inválida.");
        } else if (Auxiliares.noContieneCaracterAlfabetico(laSociedadMedica)) {
            throw new IllegalArgumentException("El nombre de la sociedad médica "
                    + "es inválido.");
        } else if (!medicoCab.isEmpty()
                && Auxiliares.noContieneCaracterAlfabetico(medicoCab)) {
            throw new IllegalArgumentException("El nombre del médico ingresado "
                    + "es inválido.");
        }
        return true;
    }

    public void agregarHijo(String elNombre, Calendar laFecha, boolean esHombre,
            String laCedulaId, String laSociedadMedica, String medicoCab)
            throws IllegalArgumentException, IllegalStateException {
        if (esHijoValido(elNombre, laFecha, laCedulaId, laSociedadMedica, medicoCab)) {
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
        if (esHijoValido(elNombre, laFecha, laCedulaId, laSociedadMedica, elMedico)) {
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
        String linea;
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
        if (!Auxiliares.esNombreVacunaInvalido(nombre.trim())) {
            vacunaNueva = new Vacuna(nombre, true, descripcion);
            String[] mes = meses.split(" ");
            String[] anio = anios.split(" ");
            if (!meses.equals("-")) {
                for (String me : mes) {
                    if (mesValido(me)) {
                        vacunaNueva.agregarVencimientoEnMeses(me);
                    } else {
                        throw new IllegalArgumentException("En la vacuna " + nombre
                                + " el mes " + me + " es inválido");
                    }
                }
            }
            if (!anios.equals("-")) {
                for (String anio1 : anio) {
                    if (anioValido(anio1)) {
                        vacunaNueva.agregarVencimientoEnAnios(anio1);
                    } else {
                        throw new IllegalArgumentException("En la vacuna " + nombre
                                + " el año " + anio1 + " es inválido");
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

    public boolean mesValido(String mes) {
        if (Auxiliares.esNumeroNatural(mes)) {
            int intMes = Integer.parseInt(mes);
            return intMes < mesMaximoIngresable();
        }
        return periodoMesValido(mes);
    }

    public boolean periodoMesValido(String periodo) {
        if (periodo.length() > 2) {
            if (periodo.charAt(0) == 'c' && periodo.charAt(1) == '/') {
                String[] separarMes = periodo.split("/");
                if (separarMes.length > 1) {
                    return mesValido(separarMes[1]);
                }
            }
        }
        return false;
    }

    public boolean periodoAnioValido(String periodo) {
        if (periodo.length() > 2) {
            if (periodo.charAt(0) == 'c' && periodo.charAt(1) == '/') {
                String[] separarAnio = periodo.split("/");
                if (separarAnio.length > 1) {
                    return anioValido(separarAnio[1]);
                }
            }
        }
        return false;
    }

    public boolean anioValido(String anio) {
        if (Auxiliares.esNumeroNatural(anio)) {
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
        if (!Auxiliares.noContieneCaracterAlfabetico(nombre.trim())) {
            vacunaNueva = new Vacuna(nombre, false, descripcion);
            listaVacunas.add(vacunaNueva);
        } else {
            throw new IllegalArgumentException("El nombre de vacuna " + nombre
                    + " es inválido");
        }
    }

    public static int anioMaximoIngresable() {
        return 12;
    }

    public static int mesMaximoIngresable() {
        return 24;
    }

    public void cargarVacunasDeArchivo(String ubicacion) throws IllegalArgumentException,
            FileNotFoundException, IOException {
        listaVacunas.clear();
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

    public void eliminarEventoPorPos(int posEvento) {
        eventosARealizar.remove(posEvento);
        Collections.sort(eventosARealizar);
    }

    public void darDeBajaEvento(int posEventoACompletar) {
        Evento eventoACompletar = eventosARealizar.get(posEventoACompletar);
        eventosARealizar.remove(posEventoACompletar);
        eventosRealizados.add(eventoACompletar);
        Collections.sort(eventosRealizados);
        Collections.sort(eventosARealizar);
    }
    
    public String[] nombreVacunasSistematicasParaCarne(Hijo hijoSeleccionado) {
        ArrayList<String> listaNombreVacunas = new ArrayList<>();
        Iterator<Vacuna> itVacunasSistema = listaVacunas.iterator();
        Iterator<Par<Vacuna,ArrayList<Calendar>>> itVacunasHijo =
                 hijoSeleccionado.getIteradorHistorialVacunaciones();
        while (itVacunasHijo.hasNext()) {
            Vacuna vacunaActual = itVacunasHijo.next().getDato1();
            if (vacunaActual.esSistematica() 
                    && !listaNombreVacunas.contains(vacunaActual.toString())) {
                listaNombreVacunas.add(vacunaActual.toString());
            }
        }
        while (itVacunasSistema.hasNext()) {
            Vacuna vacunaActual = itVacunasSistema.next();
            if (vacunaActual.esSistematica() 
                    && !listaNombreVacunas.contains(vacunaActual.toString())) {
                listaNombreVacunas.add(vacunaActual.toString());
            }
        }
        return Auxiliares.convertirArrayListStringAArrayStringConEspacioAlPrincipio(listaNombreVacunas);
    }
    
    public String[] nombreVacunasNoSistematicasParaCarne(Hijo hijoSeleccionado) {
        ArrayList<String> listaNombreVacunas = new ArrayList<>();
        Iterator<Vacuna> itVacunasSistema = listaVacunas.iterator();
        Iterator<Par<Vacuna,ArrayList<Calendar>>> itVacunasHijo =
                 hijoSeleccionado.getIteradorHistorialVacunaciones();
        while (itVacunasHijo.hasNext()) {
            Vacuna vacunaActual = itVacunasHijo.next().getDato1();
            if (!vacunaActual.esSistematica() 
                    && !listaNombreVacunas.contains(vacunaActual.toString())) {
                listaNombreVacunas.add(vacunaActual.toString());
            }
        }
        while (itVacunasSistema.hasNext()) {
            Vacuna vacunaActual = itVacunasSistema.next();
            if (!vacunaActual.esSistematica() 
                    && !listaNombreVacunas.contains(vacunaActual.toString())) {
                listaNombreVacunas.add(vacunaActual.toString());
            }
        }
        return Auxiliares.convertirArrayListStringAArrayStringConEspacioAlPrincipio(listaNombreVacunas);
    }
    
    public String[] mesesParaCarneVacunas(Hijo hijoSeleccionado) {
        ArrayList<String> meses = new ArrayList<>();
        Iterator<Par<Vacuna,ArrayList<Calendar>>> itMesesHijo = 
                hijoSeleccionado.getIteradorHistorialVacunaciones();
        Iterator<Vacuna> itVacunasSistema = listaVacunas.iterator();
        while (itMesesHijo.hasNext()) {
            Par<Vacuna,ArrayList<Calendar>> estePar = itMesesHijo.next();
            Iterator<Calendar> itCalendarioHijo = estePar.getDato2().iterator();
            while (itCalendarioHijo.hasNext()) {
                Calendar estaFecha = itCalendarioHijo.next();
                String mesAAgregar = ""+hijoSeleccionado.mesesDesdeNacimientoAFecha(estaFecha);
                int valorIntegerDeMesAAgregar = Integer.parseInt(mesAAgregar);
                if (valorIntegerDeMesAAgregar > -1 && valorIntegerDeMesAAgregar < 24 
                        && !meses.contains(mesAAgregar)) meses.add(mesAAgregar);
            }
            Iterator<String> itVacunaHijo = estePar.getDato1().iteradorVencimientoEnMeses();
            while (itVacunaHijo.hasNext()) {
                String mesAAgregar = itVacunaHijo.next();
                if (!meses.contains(mesAAgregar)) meses.add(mesAAgregar);
            }
        }
        while (itVacunasSistema.hasNext()) {
            Vacuna estaVacuna = itVacunasSistema.next();
            Iterator<String> itMesesVacuna = estaVacuna.iteradorVencimientoEnMeses();
            while (itMesesVacuna.hasNext()) {
                String mesAAgregar = itMesesVacuna.next();
                if (!meses.contains(mesAAgregar)) meses.add(mesAAgregar);
            }
        }
        return Auxiliares.convertirArrayListStringAArrayMesesConEspacioAlPrincipio(meses);
    }
    
   public String[] aniosParaCarneVacunas(Hijo hijoSeleccionado) {
        ArrayList<String> anios = new ArrayList<>();
        Iterator<Par<Vacuna,ArrayList<Calendar>>> itAniosHijo = 
                hijoSeleccionado.getIteradorHistorialVacunaciones();
        Iterator<Vacuna> itVacunasSistema = listaVacunas.iterator();
        while (itAniosHijo.hasNext()) {
            Par<Vacuna,ArrayList<Calendar>> estePar = itAniosHijo.next();
            Iterator<Calendar> itCalendarioHijo = estePar.getDato2().iterator();
            while (itCalendarioHijo.hasNext()) {
                Calendar estaFecha = itCalendarioHijo.next();
                String anioAAgregar = ""+hijoSeleccionado.aniosDesdeNacimientoAFecha(estaFecha);
                if (Integer.parseInt(anioAAgregar) > 1 && 
                        !anios.contains(anioAAgregar)) anios.add(anioAAgregar);
            }
            Iterator<String> itVacunaHijo = estePar.getDato1().iteradorVencimientoEnAnios();
            while (itVacunaHijo.hasNext()) {
                String anioAAgregar = itVacunaHijo.next();
                if (!anios.contains(anioAAgregar)) anios.add(anioAAgregar);
            }
        }
        while (itVacunasSistema.hasNext()) {
            Vacuna estaVacuna = itVacunasSistema.next();
            Iterator<String> itAniosVacuna = estaVacuna.iteradorVencimientoEnAnios();
            while (itAniosVacuna.hasNext()) {
                String mesAAgregar = itAniosVacuna.next();
                if (!anios.contains(mesAAgregar)) anios.add(mesAAgregar);
            }
        }
        return Auxiliares.convertirArrayListStringAArrayAnios(anios);
    }
}
