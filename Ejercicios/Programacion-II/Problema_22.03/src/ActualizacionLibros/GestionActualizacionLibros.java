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
programa cuando se elija la opción 6. Se deberán implementar todas las opciones restantes
(1,..5).
 */
package ActualizacionLibros;
import General.*;
import java.io.File;

public class GestionActualizacionLibros {
    //ATRIBUTOS
    private static final String nombreFichero="libros.dat";
    
    
    //declaración método main
    public static void main(String [] argumentos) {
        new GestionActualizacionLibros().metodoPrincipal();
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
                case 1:     altaActualizaciones();break;
                case 2:     listadoLibros();break;
                case 3:     listadoActualizacionesIncidencias("actualizaciones",
                            "<<<<<<<   LISTADO DE ACTUALIZACIONES PENDIENTES    >>>>>>>",
                            "            NO HAY ACTUALIZACIONES PENDIENTES\n\n");
                            break;
                case 4:     listadoActualizacionesIncidencias("incidencias",
                            "<<<<<<<   LISTADO DE INCIDENCIAS DETECTADAS    >>>>>>>",
                            "   NO HAY INCIDENCIAS DE LA ÚLTIMA ACTUALIZACIÓN\n\n");
                            break;
                case 5:     actualizacionFichero();break;
                default:    fin=true;
            }             
        }
    }

    //MÉTODO altaLibros LLEVA  A CABO LA LECTURA POR TECLADO DE UN OBJETO Actualizacion
    //Y SU GRABACIÓN EN EL FICHERO CORRESPONDIENTE
    private void altaActualizaciones() {
        //DECLARACIONES
        //declaración objeto Actualizacion para almacenar, de uno en uno, los objetos
        //Actualizacion a leer desde el teclado
        Actualizacion actualizacion;
        //declaración objeto FicheroObjetosActualizacionOut para posibilitar la
        //escritura de objetos Actualizacion en un fichero
        FicheroObjetosActualizacionOut fichero;
        //declaración variable booleana para gestionar la ejecución del método
        boolean continuar=true;
        
        //ACCIONES
        //verificar si el fichero de libros existe o no
        File f=new File("actualizaciones_"+nombreFichero);
        if (f.exists()) {
            //mensaje comunicando que si se prosigue con el alta de libros
            //el contenido del fichero existente se eliminará
            System.out.print("SI CONTINUA CON ESTA OPCIÓN EL CONTENIDO"
                    + " DEL FICHERO DE ACTUALIZACIONES SE PERDERÁ\n");
            continuar=continuar("<> CONTINUAR (s/n): ");
        }
        if (continuar) {
            //instanciación objeto FicheroObjetosActualizacionOut fichero para establecer
            //el enlace con el fichero físico a nivel de escritura
            //de objetos Actualizacion
            fichero=new FicheroObjetosActualizacionOut("actualizaciones_"+nombreFichero);
            //bucle de lectura y grabación de objetos Libro 
            for (boolean fin=false;!fin;) {
                //instanciación objeto Cliente
                actualizacion=new Actualizacion();
                //definición objeto Actualizacion del tipo MODIFICACION
                actualizacion.setActualizacion();
                //lectura objeto Cliente desde el teclado
                actualizacion.lectura();
                //grabación objeto Cliente leído en el fichero
                fichero.escritura(actualizacion);
                //verificar si el usuario quiere continuar dando de altas libros
                fin=!continuar("<> CONTINUAR CON ALTA DE MODIFICACIONES (s/n): ");
            }
            //grabación del objeto Cliente CENTINELA al final del fichero
            fichero.escritura(Actualizacion.getCentinela());
            //cierre del enlace con el fichero
            fichero.cierre();              
        }               
    }
    
 
    //MÉTODO actualizacionFichero LLEVA  A CABO LA ACTUALIZACIÓN DEL FICHERO DE OBJETOS
    //Libro TENIENDO EN CUENTA LAS ACTUALIZACIONES PENDIENTES CONTENIDAS EN
    //EL FICHERO DE ACTUALIZACIONES CORRESPONDIENTE
    private void actualizacionFichero() {
        //declaración objeto FicheroObjetosLibroIn para posibilitar la
        //lectura de objetos Libro desde el fichero 
        FicheroObjetosLibroIn maestro; 
        //declaración objeto FicheroObjetosLibroOut para posibilitar la
        //escritura de objetos Libro en el fichero 
        FicheroObjetosLibroOut nuevoMaestro; 
        //declaración objeto FicheroObjetosActualizacionIn para posibilitar la
        //lectura de objetos Actualizacion desde el fichero 
        FicheroObjetosActualizacionIn ficheroActualizaciones; 
        //declaración objeto FicheroObjetosActualizacionOut para posibilitar la
        //escritura de objetos Actualizacion anómalos en el fichero de 
        //incidencias
        FicheroObjetosActualizacionOut ficheroIncidencias;    
        //declaración objeto Libro
        Libro libro;
        //declaración objeto Actualizacion
        Actualizacion actualizacion;
        //declaración objeto File para enlazarlo con el ficheroActualizaciones
        File fichero=new File("actualizaciones_"+nombreFichero);
        
        //ACCIONES
        //verificar si existe el ficheroActualizaciones para llevar a cabo el proceso
        //de actualización
        if (fichero.exists()) {
            //instanciación objeto FicheroObjetosLibroIn maestro para establecer
            //el enlace con el fichero físico a nivel de lectura
            //de objetos Libro
            maestro=new FicheroObjetosLibroIn(nombreFichero);
            //instanciación objeto FicheroObjetosActualizacionIn ficheroActualizaciones para establecer
            //el enlace con el fichero físico a nivel de lectura
            //de objetos Actualizacion
            ficheroActualizaciones=new FicheroObjetosActualizacionIn("actualizaciones_"+nombreFichero);  
            //instanciación objeto FicheroObjetosLibroOut nuevoMaestro para establecer
            //el enlace con el fichero físico a nivel de escritura
            //de objetos Cliente
            nuevoMaestro=new FicheroObjetosLibroOut("nuevoMaestro_"+nombreFichero);
            //instanciación objeto FicheroObjetosActualizacionOut ficheroIncidencias para establecer
            //el enlace con el fichero físico a nivel de escritura
            //de objetos Actualizacion
            ficheroIncidencias=new FicheroObjetosActualizacionOut("incidencias_"+nombreFichero);
            //lectura primer objeto Libro del fichero de libros
            libro=maestro.lectura();
            //lectura primer objeto Actualizacion del fichero de actualizaciones
            actualizacion=ficheroActualizaciones.lectura();
            //BUCLE
            while ((!libro.esCentinela()) || (!actualizacion.esCentinela())) {
                if (libro.getCodigo() < actualizacion.getCodigo()) {
                    nuevoMaestro.escritura(libro);
                    libro=maestro.lectura();
                }else if (libro.getCodigo()==actualizacion.getCodigo()) {
                    switch (actualizacion.getActualizacion()){
                        case MODIFICACION:
                            //actualización objeto Libro con la actualización leída
                            libro.setTitulo(actualizacion.getTitulo());
                            break;
                        case ELIMINACION:
                            //lectura siguinete objeto Libro del fichero de libros
                            libro=maestro.lectura();
                            break;
                        default:
                            //grabación en el fichero de incidencias la actualización actual
                            ficheroIncidencias.escritura(actualizacion);
                    }
                    //lectura siguiente objeto Actualizacion del fichero correspondiente
                    actualizacion=ficheroActualizaciones.lectura();
                }else {
                    switch (actualizacion.getActualizacion()){
                        case ADICION:
                            Libro nuevoLibro = actualizacion.generarLibro();
                            nuevoMaestro.escritura(nuevoLibro);
                            break;
                        default:
                            //grabación en el fichero de incidencias la actualización actual
                            ficheroIncidencias.escritura(actualizacion);
                    }
                    //lectura siguiente objeto Actualizacion del fichero correspondiente
                    actualizacion=ficheroActualizaciones.lectura();
                }
            }
            //grabación de los objetos CENTINELA correspondientes en el fichero
            //nuevoMaestro y en el fichero de incidencias
            nuevoMaestro.escritura(Libro.getCentinela());
            ficheroIncidencias.escritura(Actualizacion.getCentinela());
            //cierre de los enlaces de ficheros
            maestro.cierre();
            nuevoMaestro.cierre();
            ficheroActualizaciones.cierre();
            ficheroIncidencias.cierre();
            //Sustitución del fichero maestro por el fichero nuevoMaestro
            File f1=new File(nombreFichero);
            File f2=new File("nuevoMaestro_"+nombreFichero);
            if (f1.delete()) {
                f2.renameTo(f1);
            }
            //destrucción ficheros de actualizaciones
            File f3=new File("actualizaciones_"+nombreFichero);
            f3.delete();            
        }    
        else {
            //visualizar mensaje correspondiente
            limpiarPantalla("<<<<<<    EL PROCESO DE ACTUALIZACIÓN NO TIENE OBJETO PUES NO HAY ACTUALIZACIONES PENDIENTES    >>>>>");
            pausa("VOLVER AL MENU --> PULSAR RETURN");
        }
    }

    private boolean estaEnMaestro(int codigo)
    {
        FicheroObjetosLibroIn maestro=new FicheroObjetosLibroIn(nombreFichero);
        
        Libro libro = maestro.lectura();
        while (!libro.esCentinela())
        {
            if (libro.getCodigo() == codigo)
                return true;
            
            libro = maestro.lectura();
        }
        maestro.cierre();
        return false;
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

    //MÉTODO listadoActualizaciones LLEVA  A CABO LA LECTURA Y VISUALIZACIÓN DE LOS
    //OBJETOS Actualizacion CONTENIDOS EN EL FICHERO DE ACTUALIZACIONES O EN EL
    //DE INCIDENCIAS CORRESPONDIENTE EN FUNCIÓN DE LOS PARÁMETROS DADOS
    private void listadoActualizacionesIncidencias(String prefijo, 
                                        String mensaje1, String mensaje2) {
        //DECLARACIONES  
        //declaración objeto Actualizacion para almacenar, de uno en uno, los objetos
        //Actualizacion leídos desde el fichero
        Actualizacion actualizacion;
        //declaración objeto FicheroObjetosActualizacionIn para posibilitar la
        //lectura de objetos Actualizacion desde el fichero 
        FicheroObjetosActualizacionIn fichero;        
        
        //ACCIONES
        //limpiar pantalla
        limpiarPantalla(mensaje1);
        //verificar si el fichero de incidencias existe o no
        File f=new File(prefijo+"_"+nombreFichero);
        if (f.exists()) {
            //instanciación objeto FicheroObjetosActualizacionIn fichero para establecer
            //el enlace con el fichero físico a nivel de lectura
            //de objetos Actualizacion
            fichero=new FicheroObjetosActualizacionIn(prefijo+"_"+nombreFichero);  
            //bucle de RECORRIDO para llevar a cabo la lectura y visualización de
            //los objetos Actualizacion contenidos en el fichero
            for (actualizacion=fichero.lectura();!actualizacion.esCentinela();) {
                //visualización objeto Actualizacion leido
                System.out.println(actualizacion.toString());
                //lectura siguiente objeto Actualizacion
                actualizacion=fichero.lectura();
            }
            //cierre del enlace con el fichero
            fichero.cierre();             
        }else {
            System.out.println(mensaje2);
        }
        pausa("<<<<<<<<   PARA VOLVER AL MENU PULSAR RETURN    >>>>>>>>");
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
