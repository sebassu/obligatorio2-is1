package dominio;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import persistencia.ArchivoLectura;

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

    public void agregarEventoAListaCorrespondiente(Evento elEvento) {
        if (esFechaFutura(elEvento.getFecha())) {
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

    public void agregarEvento(String elTitulo, String elTipo,
            String laDescripcion, Calendar laFecha, Hijo hijo, String elLugar)
            throws IllegalArgumentException {
        if (esEsteTipo(elTipo, "Vacunación") || esEsteTipo(elTipo, "Consulta")) {
            throw new IllegalArgumentException("Este tipo de evento debe ser "
                    + "creado con otro método");
        } else {
            if (esEventoValido(elTitulo, laDescripcion, laFecha, hijo, elLugar)) {
                Evento nuevoEvento = new Evento(proximaIdAAsignar,
                        elTitulo, elTipo, laDescripcion, laFecha, hijo, elLugar);
                agregarEventoAListaCorrespondiente(nuevoEvento);
            }
        }
    }

    public void modificarEvento(int laId, String elTitulo, String elTipo,
            String laDescripcion, Calendar laFecha, Hijo hijo, String elLugar)
            throws IllegalArgumentException, IllegalStateException {
        if (esEsteTipo(elTipo, "Vacunación") || esEsteTipo(elTipo, "Consulta")) {
            throw new IllegalArgumentException("Este tipo de evento debe ser "
                    + "buscado con otro método");
        } else {
            if (esEventoValido(elTitulo, laDescripcion, laFecha, hijo, elLugar)) {
                Evento eventoAModificar = new Evento(laId, elTitulo, elTipo,
                        laDescripcion, laFecha, hijo, elLugar);
                modificarEventoEnListaCorrespondiente(eventoAModificar);
            }
        }
    }

    public boolean esEsteTipo(String elTipo, String tipoEsperado) {
        return elTipo.replaceAll("\\W", "").equals(tipoEsperado);
    }

    public void agregarConsulta(String medico, String elTitulo, String elTipo,
            String laDescripcion, Calendar laFecha, Hijo hijo, String elLugar)
            throws IllegalArgumentException {
        if (!esEsteTipo(elTipo, "Consulta")) {
            throw new IllegalArgumentException("Este tipo de evento debe ser "
                    + "creado con otro método");
        } else if (noContieneCaracterAlfabetico(medico)) {
            throw new IllegalArgumentException("El nombre del médico es inválido");
        } else {
            if (esEventoValido(elTitulo, laDescripcion, laFecha, hijo, elLugar)) {
                Consulta nuevaConsulta = new Consulta(proximaIdAAsignar, elTitulo,
                        elTipo, laDescripcion, laFecha, hijo, elLugar, medico);
                agregarEventoAListaCorrespondiente(nuevaConsulta);
            }
        }
    }

    public void modificarConsulta(int laId, String medico, String elTitulo, String elTipo,
            String laDescripcion, Calendar laFecha, Hijo hijo, String elLugar)
            throws IllegalArgumentException, IllegalStateException {
        if (!esEsteTipo(elTipo, "Consulta")) {
            throw new IllegalArgumentException("Este tipo de evento debe ser "
                    + "buscado con otro método");
        } else if (noContieneCaracterAlfabetico(medico)) {
            throw new IllegalArgumentException("El nombre del médico es inálido");
        } else {
            if (esEventoValido(elTitulo, laDescripcion, laFecha, hijo, elLugar)) {
                Consulta consultaAModificar = new Consulta(laId, elTitulo,
                        elTipo, laDescripcion, laFecha, hijo, elLugar, medico);
                modificarEventoEnListaCorrespondiente(consultaAModificar);
            }
        }
    }

    public void modificarVacunacion(int laId, Vacuna vacuna, String elTitulo, String elTipo,
            String laDescripcion, Calendar laFecha, Hijo hijo, String elLugar)
            throws IllegalArgumentException, IllegalStateException {
        if (!esEsteTipo(elTipo, "Vacunación")) {
            throw new IllegalArgumentException("Este tipo de evento debe ser "
                    + "creado con otro método");
        } else if (!listaVacunas.contains(vacuna)) {
            throw new IllegalArgumentException("La vacuna no existe en el sistema");
        } else {
            if (esEventoValido(elTitulo, laDescripcion, laFecha, hijo, elLugar)) {
                Vacunacion vacunacionAModificar = new Vacunacion(laId, elTitulo,
                        elTipo, laDescripcion, laFecha, hijo, elLugar, vacuna);
                modificarEventoEnListaCorrespondiente(vacunacionAModificar);
            }
        }
    }

    public void agregarVacunacion(int laId, Vacuna vacuna, String elTitulo, String elTipo,
            String laDescripcion, Calendar laFecha, Hijo hijo, String elLugar) {
        if (!esEsteTipo(elTipo, "Vacunación")) {
            throw new IllegalArgumentException("Este tipo de evento debe ser "
                    + "creado con otro método");
        } else if (!listaVacunas.contains(vacuna)) {
            throw new IllegalArgumentException("La vacuna no existe en el sistema");
        } else {
            if (esEventoValido(elTitulo, laDescripcion, laFecha, hijo, elLugar)) {
                Vacunacion nuevaVacunacion = new Vacunacion(proximaIdAAsignar,
                        elTitulo, elTipo, laDescripcion, laFecha, hijo, elLugar,
                        vacuna);
                agregarEventoAListaCorrespondiente(nuevaVacunacion);
            }
        }
    }

    public void eliminarEvento(int laId) throws IllegalStateException {
        Evento eventoAEliminar = new Evento(laId);
        if (eventosRealizados.contains(eventoAEliminar)) {
            eventosRealizados.remove(eventoAEliminar);
            Collections.sort(eventosRealizados);
        } else if (eventosARealizar.contains(eventoAEliminar)) {
            eventosARealizar.remove(eventoAEliminar);
            Collections.sort(eventosARealizar);
        } else {
            throw new IllegalStateException("El evento a eliminar no existe");
        }
    }

    protected boolean esEventoValido(String elTitulo, String laDescripcion,
            Calendar laFecha, Hijo hijo, String elLugar)
            throws IllegalArgumentException {
        boolean esValido = false;
        if (noContieneCaracterAlfabetico(elTitulo)) {
            throw new IllegalArgumentException("El título es inválido");
        } else if (noContieneCaracterAlfabetico(elLugar)) {
            throw new IllegalArgumentException("El lugar es inválido");
        } else if (esFechaAntesDeNacimiento(hijo.getFechaNacimiento(), laFecha)) {
            throw new IllegalArgumentException("Esa fecha es antes del nacimiento"
                    + "de su hijo/a");
        } else {
            esValido = true;
        }
        return esValido;
    }

    public boolean noContieneCaracterAlfabetico(String nombre) {
        return nombre.replaceAll("\\W", "").replaceAll("\\d+", "").isEmpty();
    }

    public boolean esCedulaInvalida(String cedula) {
        if (cedula.length() != 11 || cedula.charAt(1) != '.'
                || cedula.charAt(5) != '.' || cedula.charAt(5) != '-') {
            return false;
        } else {
            return cedula.replaceAll("\\D", "").length() == 8;
        }
    }

    protected boolean esFechaAntesDeNacimiento(Calendar laFechaNacimiento,
            Calendar otraFecha) {
        return laFechaNacimiento.getTime().compareTo(otraFecha.getTime()) > 0;
    }

    public boolean esFechaFutura(Calendar laFecha) {
        return laFecha.getTime().compareTo(Calendar.getInstance().getTime()) > 0;
    }

    /**
     * esFechaNacimientoValida:
     *
     * @param laFecha Fecha a ser validada.
     * @return Retorna true si la fecha recibida no es una futura comparada con
     * la actual y además resulta en una edad menor a los doce años para el
     * niño/a.
     */
    public boolean esFechaNacimientoValida(Calendar laFecha) {
        return !esFechaFutura(laFecha)
                && Calendar.getInstance().get(Calendar.YEAR) - laFecha.get(Calendar.YEAR) < 12;
    }

    protected boolean esHijoValido(String elNombre, Calendar laFecha,
            String laCedulaId, String laSociedadMedica)
            throws IllegalArgumentException {
        if (esFechaFutura(laFecha)) {
            throw new IllegalArgumentException("La fecha ingresada es inválida");
        } else if (noContieneCaracterAlfabetico(elNombre)) {
            throw new IllegalArgumentException("El nombre es inválido");
        } else if (esCedulaInvalida(laCedulaId)) {
            throw new IllegalArgumentException("La cedula es inválida");
        } else if (noContieneCaracterAlfabetico(laSociedadMedica)) {
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

    public Evento getEvento(int pos) throws IndexOutOfBoundsException {
        return eventosARealizar.get(pos);
    }

    public int getCantidadEventosARealizar() {
        return eventosARealizar.size();
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

    public int cargarVacunasSistematicas(ArchivoLectura archivoLeido,
            int numeroLinea) throws IOException, IllegalArgumentException {
        String linea = archivoLeido.linea().trim();
        String nombre = "";
        String meses = "";
        String anios = "";
        String descripcion = "";
        int cantRenglones = 0;
        boolean error = false;
        boolean vacunaTerminada = false;
        while (archivoLeido.hayMasLineas() && !linea.equals("-No sistemáticas-")) {
            linea = archivoLeido.linea().trim();
            numeroLinea++;
            String[] datosEnLinea = linea.split(":");
            switch (datosEnLinea[0]) {
                case "Nombre":
                    if (nombre.equals("")) {
                        nombre = datosEnLinea[1].trim();
                    } else {
                        error = true;
                    }
                    break;
                case "Meses":
                    if (meses.equals("")) {
                        meses = datosEnLinea[1].trim();
                    } else {
                        error = true;
                    }
                    break;
                case "Años":
                    if (anios.equals("")) {
                        anios = datosEnLinea[1].trim();
                    } else {
                        error = true;
                    }
                    break;
                case "Descripción":
                    if (descripcion.equals("")) {
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
            if (cantRenglones == 4) {
                vacunaTerminada = true;
            }
            if (vacunaTerminada && !nombre.equals("") && !meses.equals("")
                    && !anios.equals("") && !descripcion.equals("")) {

                procesarVacunaSistematica(nombre, meses, anios, descripcion);
                vacunaTerminada = false;
                nombre = "";
                meses = "";
                anios = "";
                descripcion = "";
            } else {
                throw new IllegalArgumentException("Una vacuna tenia un formato "
                        + "incorrecto y no se pudo procesar");
            }
            if (error) {
                throw new IllegalArgumentException("Error en linea " + numeroLinea
                        + ", no se esperaba '" + linea + "'");
            }
        }
        return numeroLinea;
    }

    public void procesarVacunaSistematica(String nombre, String meses, String anios,
            String descripcion) throws IllegalArgumentException {

        Vacuna vacunaNueva;
        if (!noContieneCaracterAlfabetico(nombre.trim())) {
            vacunaNueva = new Vacuna(nombre, true);

        } else {

        }

    }

    public void cargarVacunasDeArchivo(String ubicacion) throws IllegalArgumentException,
            FileNotFoundException, IOException {
        ArchivoLectura archivoLeido = new ArchivoLectura(ubicacion);
        int numeroLinea = 0;
        String linea = archivoLeido.linea().trim();
        while (archivoLeido.hayMasLineas()) {
            numeroLinea++;
            switch (linea) {
                case "-Sistemáticas-":
                    numeroLinea = cargarVacunasSistematicas(archivoLeido, numeroLinea);
                    break;
                case "-No sistemáticas-":

                    break;
                default:
                    throw new IllegalArgumentException("Error en línea "
                            + numeroLinea + ", no se esperaba '" + linea + "'");
            }
        }
    }
}
