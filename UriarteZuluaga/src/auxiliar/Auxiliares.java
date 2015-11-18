package auxiliar;

import dominio.Sistema;
import java.util.Calendar;

public final class Auxiliares {

    public static boolean esCedulaInvalida(String cedula) {
        if (cedula.length() != 11 || cedula.charAt(1) != '.'
                || cedula.charAt(5) != '.' || cedula.charAt(9) != '-') {
            return true;
        } else {
            return cedula.replaceAll("\\D", "").length() != 8;
        }
    }

    public static boolean esNumeroNatural(String num) {
        for (int i = 0; i < num.length(); i++) {
            if (!Character.isDigit(num.charAt(i))) {
                return false;
            }
        }
        return !num.equals("");
    }

    public static int mesesDesdeLaFecha(Calendar fecha) {
        Calendar hoy = Calendar.getInstance();
        return ((hoy.get(Calendar.YEAR)) - fecha.get(Calendar.YEAR)) * 12
                + hoy.get(Calendar.MONTH) - fecha.get(Calendar.MONTH);
    }

    public static boolean noContieneCaracterAlfabetico(String nombre) {
        return nombre.replaceAll("\\W", "").replaceAll("\\d+", "").isEmpty();
    }

    public static boolean esFechaAntesDeNacimiento(Calendar laFechaNacimiento,
            Calendar otraFecha) {
        return laFechaNacimiento.getTime().compareTo(otraFecha.getTime()) > 0;
    }

    public static boolean esFechaFutura(Calendar laFecha) {
        return laFecha.getTime().compareTo(Calendar.getInstance().getTime()) > 0;
    }

    public static boolean caeEnEstaSemana(Calendar laFecha) {
        Calendar hoy = Calendar.getInstance();
        return (hoy.get(Calendar.YEAR) == laFecha.get(Calendar.YEAR)
                && hoy.get(Calendar.WEEK_OF_YEAR) == laFecha.get(Calendar.WEEK_OF_YEAR));
    }

    /**
     * esFechaNacimientoValida:
     *
     * @param laFecha Fecha a ser validada.
     * @return Retorna true si la fecha recibida no es una futura comparada con
     * la actual y además resulta en una edad menor a los doce años para el
     * niño/a.
     */
    public static boolean esFechaNacimientoValida(Calendar laFecha) {
        return !esFechaFutura(laFecha)
                && Calendar.getInstance().get(Calendar.YEAR) - laFecha.get(Calendar.YEAR)
                < Sistema.anioMaximoIngresable();
    }

    public static boolean esNombreVacunaInvalido(String nombre) {
        return nombre.replaceAll("\\W", "").isEmpty();
    }
}
