/*
FUNCIONALIDAD: Dada la declaración de un objeto Libro con incialización lleva a cabo 
la solicitud de un año para posteriormente visualizar la verificación de si el
libro declarado es del mismo año de edición que el introducido por teclado 
NOTA: antes de la verificación vamos a modificar el atributo anyoEdicion del
objeto Libro
 */
package clasepractica_16_11_2021;

public class Lbro_uso_2_v2 {
    //método main
    public static void main(String [] argumentos) throws Exception {
        new Lbro_uso_2_v2().metodoPrincipal();
    }
    
    //método metodoPrincipal() 
    private void metodoPrincipal() {
        //DECLARACIONES
        //declaración de un objeto Libro con inicialización
        Libro libro1=new Libro("primero","uno","primerGenero","primera",2001);
        //declaración variable entera para almacenar el año a verificar
        int año;
        
        //ACCIONES
        //mensaje usuario para introducir año a verificar
        System.out.print("INTRODUCE AÑO: ");
        //lectura valor introducido porteclado asignándolo a la variable año
        año=LT.readInt();
        
        //modificación atributo anyoEdicion del objeto Libro
        libro1.setAnyoEdicion(2010);
        
        //verificación año leído con el año de edici´ñon del Libro declarado
        if (libro1.verificacionAño(año)) {
            //el año de edición coincide con el año de verificación y or lo tanto
            //visualizamos el mensaje correspondiente
            System.out.println("EL LIBRO TIENE COMO AÑO DE EDCIÓN EL AÑO LEÍDO");
        }
        else {
            //visualización mensaje corespondiente
            System.out.println("EL LIBRO NO SE CORRESPONDE CON EL AÑO LEÍDO");          
        }

    }
    
    
}
