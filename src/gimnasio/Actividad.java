/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gimnasio;

import java.io.Serializable;
import java.util.Objects;

/**
 *
 * @author usu21
 */
public class Actividad implements Serializable {

    private String nombre;

    private int maxPlazas;

    private double precio;

    private int inscritos;
    
    public Actividad(){
        
    }

    public Actividad(String nombre, int maxPlazas, double precio ) {
        this.nombre = nombre;
        this.maxPlazas = maxPlazas;
        this.precio = precio;
        inscritos = 0;
    }
    
    
    //Método que indica si la actividad está llena o no
    public boolean isFull(){
        return(maxPlazas == inscritos);
    }
    
    public int getPlazasDisponibles(){
        return maxPlazas -inscritos;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 97 * hash + Objects.hashCode(this.nombre);
        return hash;
    }

    //arreglamos el equals para que no sea CaseSensitive
    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Actividad other = (Actividad) obj;
        return this.nombre.equalsIgnoreCase(other.getNombre());
        
    }

   
    
    

    public int getInscritos() {
        return inscritos;
    }

    public void setInscritos(int inscritos) {
        this.inscritos = inscritos;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public int getMaxPlazas() {
        return maxPlazas;
    }

    public void setMaxPlazas(int maxPlazas) {
        this.maxPlazas = maxPlazas;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

}
