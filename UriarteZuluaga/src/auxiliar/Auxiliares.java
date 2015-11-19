package auxiliar;

import dominio.Sistema;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;

public final class Auxiliares {

    public static String[] convertirArrayListStringAArrayString(
            ArrayList<String> original) {
        String[] nuevo = new String[original.size()];
        Iterator<String> iteradorOriginal = original.iterator();

        for (int i = 0; i < nuevo.length; i++) {

            nuevo[i] = iteradorOriginal.next();
        }
        Arrays.sort(nuevo);
        return nuevo;
    }

    public static String[] convertirArrayListStringAArrayStringConEspacioAlPrincipio(
            ArrayList<String> original) {
        String[] nuevo = new String[original.size() + 1];
        Iterator<String> iteradorOriginal = original.iterator();
        nuevo[0] = "";
        for (int i = 1; i < nuevo.length; i++) {

            nuevo[i] = iteradorOriginal.next();
        }
        Arrays.sort(nuevo);
        return nuevo;
    }

    public static String[] convertirArrayListStringAArrayMesesConEspacioAlPrincipio(
            ArrayList<String> original) {
        String[] nuevo = new String[original.size() + 1];
        Comparator<String> numerosPrimero
                = Auxiliares.getComparadorNumerosPrimeroLetrasLuego();
        Collections.sort(original, numerosPrimero);
        Iterator<String> iteradorOriginal = original.iterator();
        nuevo[0] = " ";
        for (int i = 1; i < nuevo.length; i++) {

            nuevo[i] = iteradorOriginal.next();
        }
        return nuevo;
    }
    
    public static String[] convertirArrayListStringAArrayAnios(
            ArrayList<String> original) {
        String[] nuevo = new String[original.size()];
        Comparator<String> numerosPrimero
                = Auxiliares.getComparadorNumerosPrimeroLetrasLuego();
        Collections.sort(original, numerosPrimero);
        Iterator<String> iteradorOriginal = original.iterator();
        for (int i = 0; i < nuevo.length; i++) {

            nuevo[i] = iteradorOriginal.next();
        }
        return nuevo;
    }

    public static Comparator<String> getComparadorNumerosPrimeroLetrasLuego() {

        return new Comparator<String>() {
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
                } else if (unoEmpiezaConLetra) {
                    return 1;
                } else {
                    return -1;
                }
            }
        };
    }

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

    public static double mesesDesdeLaFecha(Calendar fecha) {
        Calendar hoy = Calendar.getInstance();
        return (double) (((hoy.get(Calendar.YEAR)) - fecha.get(Calendar.YEAR)) * 12
                + hoy.get(Calendar.MONTH) - fecha.get(Calendar.MONTH));
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
