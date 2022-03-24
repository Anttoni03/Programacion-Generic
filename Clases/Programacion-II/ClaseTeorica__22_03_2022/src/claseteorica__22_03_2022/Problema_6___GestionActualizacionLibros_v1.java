/*
Dadas las clases Libro, Actualizacion y sus correspondientes clases de gestión de
ficheros a nivel de objetos, implementar un programa en java para llevar a cabo la
gestión de la actualización de ficheros de objetos Libro libros.dat. Se deberá visualizar
el siguiente menú:

        <<<<<<<   MENU GESTIÓN ACTUALIZACIÓN LIBROS    >>>>>>>

        [1] ALTA ACTUALIZACIONES.
        [2] LISTADO LIBROS.
        [3] LISTADO ACTUALIZACIONES PENDIENTES DE PROCESAR.
        [4] LISTADO INCIDENCIAS ÚLTIMA ACTUALIZACIÓN.
        [5] ACTUALIZACIÓN FICHERO LIBROS.
        [6] SALIR.

Posibilitando al usuario introducir una opción del mismo, finalizando la ejecución del
programa cuando se elija la opción 6. También se deberá implementar la opción 2,
LISTADO LIBROS, a través de la cual, se visualizarán en la pantalla los objetos Libros
contenidos en el fichero libros.dat, volviendo la menú cuando el usuario lo desee.
Las demás opciones (1,3,4,5) se implementarán visualizando el siguiente mensaje:
“OPCIÓN NO IMPLEMENTADA” volviendo al menú otra vez.

 */
package claseteorica__22_03_2022;

import java.io.File;

public class Problema_6___GestionActualizacionLibros_v1 {
    //ATRIBUTOS
    private static final String nombreFichero="libros.dat";
    
    
    //declaración método main
    public static void main(String [] argumentos) {
        new Problema_6___GestionActualizacionLibros_v1().metodoPrincipal();
    }
    
    //método metodoPrincipal
    private void metodoPrincipal() {
        //DECLARACIONES
        //declaración variable booleana para controlar el final
        //del programa
        boolean fin=false;
        
        //ACCIONES
            while (!fin) {
            //visualización menu
            menu();
            //lectura opción y gestión opción elegida
            switch (LT.readInt()) {
                case 1:     limpiarPantalla("<<<<<<      OPCIÓN NO IMPLEMENTADA      >>>>>>");
                            pausa("<<<  VOLVER AL MENU --> PULSAR RETURN  >>>");
                            break;
                case 2:     listadoLibros();break;
                case 3:     limpiarPantalla("<<<<<<      OPCIÓN NO IMPLEMENTADA      >>>>>>");
                            pausa("<<<  VOLVER AL MENU --> PULSAR RETURN  >>>");
                            break;
                case 4:     limpiarPantalla("<<<<<<      OPCIÓN NO IMPLEMENTADA      >>>>>>");
                            pausa("<<<  VOLVER AL MENU --> PULSAR RETURN  >>>");
                            break;
                case 5:     limpiarPantalla("<<<<<<      OPCIÓN NO IMPLEMENTADA      >>>>>>");
                            pausa("<<<  VOLVER AL MENU --> PULSAR RETURN  >>>");
                            break;
                default:    fin=true;
            }             
        }
    }

    //MÉTODO listadoLibros LLEVA  A CABO LA LECTURA Y VISUALIZACIÓN DE LOS
    //OBJETOS Libro CONTENIDOS EN EL FICHERO CORRESPONDIENTE
    private void listadoLibros() {
        //DECLARACIONES  
        //declaración objeto Libro para almacenar, de uno en uno, los objetos
        //Libro leídos desde el fichero
        Libro libro;
        //declaración objeto FicheroObjetosLibroIn para posibilitar la
        //lectura de objetos Libro desde el fichero 
        FicheroObjetosLibroIn fichero;        
        
        //ACCIONES
        //instanciación objeto FicheroObjetosLibroIn fichero para establecer
        //el enlace con el fichero físico a nivel de lectura
        //de objetos Libro
        fichero=new FicheroObjetosLibroIn(nombreFichero);  
        //limpiar pantalla
        limpiarPantalla("<<<<<<<   LISTADO DE LIBROS    >>>>>>>");
        //bucle de RECORRIDO para llevar a cabo la lectura y visualización de
        //los objetos Cliente contenidos en el fichero
        for (libro=fichero.lectura();!libro.esCentinela();) {
            //visualización objeto PeliculaConCentinela leido
            System.out.println(libro.toString());
            //lectura siguiente objeto PeliculaConCentinela
            libro=fichero.lectura();
        }
        pausa("<<<<<<<<   PARA VOLVER AL MENU PULSAR RETURN    >>>>>>>>");

        //cierre del enlace con el fichero
        fichero.cierre(); 
    }

    //MÉTODO menu LLEVA A CABO LA VISUALIZACIÓN DEL MENU DE LA
    //APLICACIÓN
    private void menu() {
        //limpiar la pantalla
        limpiarPantalla("<<<<<<<   MENU GESTIÓN ACTUALIZACIÓN LIBROS    >>>>>>>");
        //visualziación opciones
        System.out.println("[1] ALTA ACTUALIZACIONES.");
        System.out.println("[2] LISTADO LIBROS.");
        System.out.println("[3] LISTADO ACTUALIZACIONES PENDIENTES DE PROCESAR.");
        System.out.println("[4] LISTADO INCIDENCIAS ÚLTIMA ACTUALIZACIÓN.");
        System.out.println("[5] ACTUALIZACIÓN FICHERO LIBROS.");
        System.out.println("[6] SALIR.");
        System.out.print("              [OPCIÓN] --> ");
        
    }

    //MÉTODO limpiarPantalla LLEVA A CABO LA LIMPIEZA DE LA PANTALLA
    //DE TEXTO
    private void limpiarPantalla(String mensaje) {
        System.out.print("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n"
                + "\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n"
                + mensaje+"\n\n");
    }
    
    //MÉTODO QUE SOLICITA RESPUESTA PARA CONTINUAR O NO CON LA OPCIÓN ELEGIDA
    private boolean continuar(String mensaje) {
       //DECLARACIONES
       //declaración variable char para obtener la respuesta pro teclado
       char respuesta='n';
       
       //ACCIONES
       try {
           //mensaje para continuar o no
           System.out.print(mensaje); 
           //lectura respuesta
           respuesta=LT.readChar();
           //devolver respuesta           
       }catch (Exception error) {
           System.out.println("ERROR CONTINUAR: "+error.toString());
       }
       return ((respuesta=='s') || (respuesta=='S'));
   }
    
    //MÉTODO pausa LLEVA A CABO LA PAUSA DE LA EJECUCIÓN DEL PROGRAMA
    //HASTA QUE EL USUARIO INTRODUZCA POR TECLADO EL RETURN
    private void pausa(String mensaje) {
        //visualziación mensaje dado
        System.out.print("\n\n"+mensaje);
        //esperar hasta introducción return
        LT.readChar();
    }
}
