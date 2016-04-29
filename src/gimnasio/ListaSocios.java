/*
 * Clase que encapsula el ArrayList de Socio
 */
package gimnasio;

import java.util.ArrayList;

/**
 *
 * @author usu21
 */
public class ListaSocios {
    
    private ArrayList<Socio> lista;

    public ListaSocios() {
       lista = new ArrayList<>();
    }
    
    
    public void altaSocio (Socio s){
        lista.add(s);
    }
    
    public boolean existe (Socio s){
        return lista.contains(s);
    }
    
    public int cantidad(){
        return lista.size();
    }

    
    // metodo que a partir del nº de socio me devuelve el Socio
    //si no existe devuelve null
    public Socio getSocio (int numSocio){
        for (Socio s: lista){
            if (s.getNumSocio() == numSocio){
                return s;
            }
        }
        return null;
    }
    
    public double cuotasTotales(){
        double total = 0;
        for (Socio s : lista){
            total += s.getCuota();
        }
        return total;
    }
    
    public ArrayList<Socio> getLista() {
        return lista;
    }

    public void setLista(ArrayList<Socio> lista) {
        this.lista = lista;
    }

}
