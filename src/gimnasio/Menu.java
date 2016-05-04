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

    private void nuevoSocio() {
        int nsocio;
        boolean existe;
        do {
            existe = false;
            nsocio = EntradaDatos.pedirEntero("Nº de socio");
            if (nsocio <= 0) {
                System.out.println("El nº de socio no pude ser menor o iqual a 0");
            } else {
                Socio s = new Socio();
                s.setNumSocio(nsocio);
                existe = misSocios.existe(s);
                if (existe) {
                    System.out.println("Ya existe un socio con ese numero");
                }
            }

        } while (nsocio <= 0);
        String nombre = EntradaDatos.pedirCadena("Nombre del Socio");
        String telefono = EntradaDatos.pedirCadena("Telefono");
        double cuota;
        do {
            cuota = EntradaDatos.pedirDouble("Cuota mensual");
            if (cuota < 10) {
                System.out.println("La cuota minima es de 10 euros");

            }

        } while (cuota < 0);
        String respuesta;
        boolean vip = false;
        do {
            respuesta = EntradaDatos.pedirCadena("¿Es socio vip (S/N)?");
            if (respuesta.equalsIgnoreCase("s")) {
                vip = true;
            } else if (respuesta.equalsIgnoreCase("n")) {
                vip = false;
            } else {
                System.out.println("Respuesta incorrecta. Debes indicar s o n");
            }
        } while (!respuesta.equalsIgnoreCase("s") && !respuesta.equalsIgnoreCase("n"));
        Socio s = new Socio(nsocio, nombre, telefono, cuota, vip);
        misSocios.altaSocio(s);
        socioFile.grabar(misSocios);
        System.out.println("Socio dado de alta");
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
