package persistencia;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class ArchivoLectura {

//Variable de clase - Mensaje a desplegarse en pantalla en caso de error.
    private static final String ERR_ARCHIVO = "Ha ocurrido un error al intentar"
            + " acceder al archivo seleccionado. Verifique que no ha movido, "
            + " renombrado o eliminado al mismo.";

//Variables de instancia.
    private String linea = "";
    private BufferedReader in;

//Constructor.
    public ArchivoLectura(String unNombre) throws FileNotFoundException {
        try {
            in = new BufferedReader(new FileReader(unNombre));
        } catch (FileNotFoundException e) {
            throw new FileNotFoundException(ERR_ARCHIVO);
        }
    }

    /**
     * Método encargado de la lectura del archivo, retornando un valor Booleano
     * de existir líneas restantes por leer.
     *
     * @return Valor Booleano (True si quedan líneas por leer, False en caso
     * contrario).
     * @throws java.io.IOException Excepción lanzada en caso de existir un error
     * al intentar acceder al archivo.
     */
    public boolean hayMasLineas() throws IOException {
        try {
            linea = in.readLine();
        } catch (IOException e) {
            throw new IOException(ERR_ARCHIVO);
        }
        return (linea != null);
    }

//Método de acceso a la línea leída en el método hayMasLineas() superior.    
    public String linea() {
        return linea;
    }

//Método encargado de cerrar el archivo abierto en el constructor.    
    public void cerrar() throws IOException {
        try {
            in.close();
        } catch (IOException e) {
            throw new IOException(ERR_ARCHIVO);
        }
    }
}
