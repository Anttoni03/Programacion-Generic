/*
Con las clases Contacto, FicheroContactoInOut y sus correspondientes clases de gestión de
ficheros, este programa en java lleva a cabo la gestión de la actualización de ficheros
de objetos Contacto contactos.dat. Se visualiza el siguiente menú:

        <<<<<<<   MENU GESTIÓN ACTUALIZACIÓN CONTACTOS    >>>>>>>

        [1] CREACIÓN DE CONTACTO.
        [2] LECTURA DE CONTACTO.
        [3] MODIFICADO DE CONTACTO.
        [4] ELIMINACIÓN DE CONTACTO.
        [5] LISTADO DE CONTACTOS.
        [6] SALIR.

Posibilitando al usuario introducir una opción del mismo, finalizando la ejecución del
programa cuando se elija la opción 6.
 */
package GestionContactos;
import General.*;
import java.io.*;

public class GestionActualizacionContactos {
    //ATRIBUTOS
    private static final String nombreFichero="contactos.dat";
    
    
    //declaración método main
    public static void main(String [] argumentos) {
        new GestionActualizacionContactos().metodoPrincipal();
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
                case 1:     crearContacto();break;
                case 2:     lecturaContacto();break;
                case 3:     modificacionContacto();break;
                case 4:     eliminacionContacto();break;
                case 5:     listadoContactos();break;
                default:    fin=true;
            }             
        }
    }

    //MÉTODO crearContacto LLEVA  A CABO LA LECTURA POR TECLADO DE UN OBJETO Contacto
    //Y SU GRABACIÓN EN EL FICHERO CORRESPONDIENTE
    private void crearContacto() {
        //DECLARACIONES
        //declaración objeto Contacto para almacenar, de uno en uno, los objetos
        //Contacto a leer desde el teclado
        Contacto contacto;
        //declaración objeto FicheroContactoInOut para posibilitar la
        //escritura(y lectura) de objetos Contacto en un fichero
        FicheroContactoInOut fichero;
        
        //ACCIONES
        //instanciación objeto FicheroObjetosActualizacionOut fichero para establecer
        //el enlace con el fichero físico a nivel de escritura
        //de objetos Contacto
        fichero=new FicheroContactoInOut(nombreFichero);
        //bucle de lectura y grabación de objetos Contacto 
        for (boolean fin=false;!fin;) {
            //instanciación objeto Contacto
            contacto=new Contacto();
            //lectura objeto Contacto desde el teclado
            contacto.lectura();
            //grabación objeto leído en el fichero
            fichero.escritura(contacto);
            //verificar si el usuario quiere continuar dando de altas contactos
            fin=!continuar("<> CONTINUAR CON CREACIÓN DE CONTACTOS (s/n): ");
        }
        //cierre del enlace con el fichero
        fichero.cierre();              
    }
    
    
    //MÉTODO lecturaContacto LLEVA  A CABO LA LECTURA Y VISUALIZACIÓN DE UN
    //OBJETO Contacto POR CÓDIGO CONTENIDO EN EL FICHERO CORRESPONDIENTE
    private void lecturaContacto() {
        //DECLARACIONES
        int codigo = 0;
        //declaración objeto Contacto para almacenar, de uno en uno, los objetos
        //Contacto leídos desde el fichero
        Contacto contacto;
        //declaración objeto FicheroObjetosContactoIn para posibilitar la
        //lectura de objetos Contacto desde el fichero 
        FicheroContactoInOut fichero;
        
        //ACCIONES
        //instanciación objeto FicheroObjetosContactoIn fichero para establecer
        //el enlace con el fichero físico a nivel de lectura
        //de objetos Contacto
        fichero=new FicheroContactoInOut(nombreFichero);  
        //limpiar pantalla
        limpiarPantalla("<<<<<<<   LECTURA DE UN CONTACTO    >>>>>>>");
        System.out.print("INTRODUCIR EL CÓDIGO DEL CONTACTO A BUSCAR: ");
        codigo = LT.readInt();
        contacto = fichero.lectura(codigo);
        if (!contacto.getEliminado())
            //visualización objeto PeliculaConCentinela leido si no es eliminado
            System.out.println(contacto.toString());
        else
            System.out.println("ESTE CONTACTO HA SIDO BORRADO");
        
        pausa("<<<<<<<<   PARA VOLVER AL MENU PULSAR RETURN    >>>>>>>>");

        //cierre del enlace con el fichero
        fichero.cierre(); 
    }
    
    
    //MÉTODO listadoContactos LLEVA  A CABO LA LECTURA Y VISUALIZACIÓN DE LOS
    //OBJETOS Contacto CONTENIDOS EN EL FICHERO CORRESPONDIENTE
    private void listadoContactos() {
        //DECLARACIONES  
        //declaración objeto Contacto para almacenar, de uno en uno, los objetos
        //Contacto leídos desde el fichero
        Contacto contacto;
        //declaración objeto FicheroObjetosContactoIn para posibilitar la
        //lectura de objetos Contacto desde el fichero 
        FicheroContactoInOut fichero;
        
        //ACCIONES
        //instanciación objeto FicheroObjetosContactoIn fichero para establecer
        //el enlace con el fichero físico a nivel de lectura
        //de objetos Contacto
        fichero=new FicheroContactoInOut(nombreFichero);  
        //limpiar pantalla
        limpiarPantalla("<<<<<<<   LISTADO DE CONTACTOS    >>>>>>>");
        try{
            //bucle de RECORRIDO para llevar a cabo la lectura y visualización de
            //los objetos contenidos en el fichero
            for (contacto=fichero.lectura();contacto != null && contacto.getCodigo() != 0;) {
                if (!contacto.getEliminado())
                    //visualización objeto Contacto leido si no es eliminado
                    System.out.println(contacto.toString());
                //lectura siguiente objeto Contacto
                contacto=fichero.lectura();
            }
        } catch(Exception e){
            fichero.cierre();
        }
        pausa("<<<<<<<<   PARA VOLVER AL MENU PULSAR RETURN    >>>>>>>>");

        //cierre del enlace con el fichero
    }
    

    //MÉTODO modificacionContacto LLEVA  A CABO LA LECTURA Y CAMBIO DE LOS
    //OBJETOS Contacto INTRODUCIDOS POR TECLADO SEGÚN EL CÓDIGO INDICADO
    private void modificacionContacto() {
        //DECLARACIONES
        int codigo = 0, modif;
        Contacto contacto;
        FicheroContactoInOut fichero;
        
        //ACCIONES
        fichero = new FicheroContactoInOut(nombreFichero);
        //limpiar pantalla
        limpiarPantalla("<<<<<<     MODIFICANDO CONTACTOS       >>>>>>");
        
        for (boolean fin=false;!fin;) {
            modif = 0;
            System.out.print("INTRODUCIR CÓDIGO DE CONTACTO A MODIFICAR: ");
            codigo = LT.readInt();
            contacto = fichero.lectura(codigo);
            if (contacto.getEliminado())
            {
                System.out.println("ESTE CONTACTO HA SIDO ELIMINADO");
            }
            else
            {
                System.out.println(contacto.toString());
                while (modif < 1 || 5 < modif)
                {
                    System.out.print("INTRODICIR MODIFICACIÓN: \n"
                        + "[1] NOMBRE\n"
                        + "[2] TELÉFONO\n"
                        + "[3] EMAIL\n"
                        + "[4] DIRECCIÓN\n"
                        + "[5] EDAD\n"
                        + "\t---> ");
                modif = LT.readInt();
                }
                switch (modif){
                    case 1:
                        System.out.print("NUEVO NOMBRE: ");
                        contacto.setNombre(LT.readLine());
                        break;
                    case 2:
                        System.out.print("NUEVO TELÉFONO: ");
                        contacto.setTelefono(LT.readLine());
                        break;
                    case 3:
                        System.out.print("NUEVO EMAIL: ");
                        contacto.setEmail(LT.readLine());
                        break;
                    case 4:
                        System.out.print("NUEVA DIRECCIÓN: ");
                        contacto.setDireccion(LT.readLine());
                        break;
                    case 5:
                        System.out.print("NUEVA EDAD: ");
                        contacto.setEdad(LT.readInt());
                        break;
                }
                fichero.escritura(contacto, codigo);
            }
            //verificar si el usuario quiere continuar dando de altas contactos
            fin=!continuar("<> CONTINUAR CON MODIFICACIÓN DE CONTACTOS (s/n): ");
        }
        pausa("<<<<<<<<   PARA VOLVER AL MENU PULSAR RETURN    >>>>>>>>");
    }

    
    //MÉTODO eliminacionContacto LLEVA  A CABO EL CAMBIO DEL INDICADOR ELIMINADO EN
    //OBJETOS Contacto INTRODUCIDOS POR TECLADO SEGÚN EL CÓDIGO INDICADO
    private void eliminacionContacto() {
        //DECLARACIONES
        int codigo = 0;
        Contacto contacto;
        FicheroContactoInOut fichero;
        
        //ACCIONES
        fichero = new FicheroContactoInOut(nombreFichero);
        //limpiar pantalla
        limpiarPantalla("<<<<<<     ELIMINANDO CONTACTOS       >>>>>>");
        
        for (boolean fin=false;!fin;) {
            System.out.print("INTRODUCIR CÓDIGO DE CONTACTO A ELIMINAR: ");
            codigo = LT.readInt();
            contacto = fichero.lectura(codigo);
            if (contacto.getEliminado())
            {
                System.out.println("ESTE CONTACTO YA HA SIDO ELIMINADO");
            }
            else
            {
                contacto.setEliminado(true);
                fichero.escritura(contacto,codigo);
            }
            //verificar si el usuario quiere continuar dando de altas contactos
            fin=!continuar("<> CONTINUAR CON ELIMINACIÓN DE CONTACTOS (s/n): ");
        }
        pausa("<<<<<<<<   PARA VOLVER AL MENU PULSAR RETURN    >>>>>>>>");
    }
    
    
    //MÉTODO menu LLEVA A CABO LA VISUALIZACIÓN DEL MENU DE LA
    //APLICACIÓN
    private void menu() {
        //limpiar la pantalla
        limpiarPantalla("<<<<<<<   MENU GESTIÓN ACTUALIZACIÓN CONTACTOS    >>>>>>>");
        //visualziación opciones
        System.out.println("[1] CREACIÓN DE CONTACTO.");
        System.out.println("[2] LECTURA DE CONTACTO.");
        System.out.println("[3] MODIFICADO DE CONTACTO.");
        System.out.println("[4] ELIMINACIÓN DE CONTACTO.");
        System.out.println("[5] LISTADO DE CONTACTOS.");
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
