/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dominio;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

/**
 *
 * @author UriarteZuluaga
 */
public class Hijo implements Serializable, Comparable {
    
    private String nombre;
    private Date fechaNacimiento;
    private char sexo;
    private String cedulaId;
    private String sociedadMedica;

    public String getSociedadMedica() {
        return sociedadMedica;
    }
    
    private Hijo() {
        nombre = "";
	fechaNacimiento = new Date();
        sexo = 'x';
        cedulaId = "9.999.999-9";
        sociedadMedica = "";
    }
    
    public Hijo(String elNombre, Date laFecha, char elSexo, String laCedulaId, 
            String laSociedadMedica) {
        nombre = elNombre;
	fechaNacimiento = laFecha;
        sexo = elSexo;
        cedulaId = laCedulaId;
        sociedadMedica = laSociedadMedica;
    }

    public String getNombre() {
        return nombre;
    }

    public Date getFechaNacimiento() {
        return fechaNacimiento;
    }

    public char getSexo() {
        return sexo;
    }

    public String getCedulaId() {
        return cedulaId;
    }

    public void setNombre(String elNombre) {
        this.nombre = elNombre;
    }

    public void setFechaNacimiento(Date laFechaNacimiento) {
        this.fechaNacimiento = laFechaNacimiento;
    }

    public void setSexo(char elSexo) {
        this.sexo = elSexo;
    }

    public void setCedulaId(String laCedulaId) {
        this.cedulaId = laCedulaId;
    }

    public void setSociedadMedica(String laSociedadMedica) {
        this.sociedadMedica = laSociedadMedica;
    }

    
    
    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Hijo other = (Hijo) obj;
        if (!Objects.equals(this.cedulaId, other.cedulaId)) {
            return false;
        }
        return true;
    }  
    
    @Override
     public int compareTo(Object obj) {
        Hijo otroHijo = (Hijo)obj;
        if (this.getNombre().equals(otroHijo.getNombre())) {
            return this.getCedulaId().compareTo(otroHijo.getCedulaId());
        } else return this.getNombre().compareTo(otroHijo.getNombre());
    } 

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 53 * hash + Objects.hashCode(this.cedulaId);
        return hash;
    }
}
