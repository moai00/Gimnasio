/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gimnasio;

import utilidades.EntradaDatos;
import utilidades.Fichero;

/**
 *
 * @author Miquel Port
 */
public class Menu {

    private Fichero socioFile;
    private ListaSocios misSocios;

    public Menu() {

        socioFile = new Fichero("socios.xml");

        misSocios = (ListaSocios) socioFile.leer();
        if (misSocios == null) {
            misSocios = new ListaSocios();
        }
        int opcion;

        do {
            mostrarMenu();
            opcion = EntradaDatos.pedirEntero("Escoge una opcion");

            switch (opcion) {
                case 1:
                    nuevoSocio();
                    break;
                case 0:
                    System.out.println("Haz mucho ejercicio");
                    break;
                default:
                    System.out.println("Opcion Incorrecta");
            }

        } while (opcion != 0);
    }
private void nuevoSocio(){
    int nsocio;
    boolean existe;
    do{
        existe = false;
        nsocio = EntradaDatos.pedirEntero("Nº de socio");
        if (nsocio <= 0){
            System.out.println("El nº de socio no pude ser menor o iqual a 0");
        }else{
            Socio s = new Socio();
            s.setNumSocio(nsocio);
            existe = misSocios.existe(s);
            if(existe){
                System.out.println("Ya existe un socio con ese numero");
            }
        }
        
    }while (nsocio <= 0);
}
    
    private void mostrarMenu() {
        System.out.println("GIMNASIO NOTEROMPAS");
        System.out.println("1. Nuevo Socio");
        System.out.println("2. Nueva Actividad");
        System.out.println("3. Consultas");
        System.out.println("4. Inscribir socio a una actividad");
        System.out.println("5. Alta / Baja VIP");
        System.out.println("0. Salir");
    }

}
