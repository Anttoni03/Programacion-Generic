/*
FUNCIONALIDAD:
Dado un fichero de texto de nombre texto.txt visualiza en pantalla las lineas
contenidas en él.

USO CLASE Linea y LineaFicherosLectura
 */
package clase_practica_____21_12_2021;

public class VisualizacionLineasFichero {
    //declaración método main
    public static void main(String [] argumentos) throws Exception {
        new VisualizacionLineasFichero().programaPrincipal();
    }
    
    //declaración método programaPrincipal
    public void programaPrincipal() throws Exception {
        //DECLARACIONES  
        //declaración objeto LineasFicherosIn para posibilitar la lectura a nivel
        //de objetos Linea desde un fichero de texto
        LineaFicherosLectura fichero;
        //declaración objero Linea para almacenar, de una en una, las lineas
        //leidas desde el fichero
        Linea linea=new Linea();
        
        //ACCIONES
        //instanciación objeto LineasFicherosIn para estblecer el enlace con el
        //fichero texto.txt
        fichero=new LineaFicherosLectura("texto.txt");
        //BUCLE DE LECTURA Y VISUALIZACIÓN A NIVEL DE OBJETOS Linea
        while (fichero.hayLineas()) {
            //lectura linea
            linea=fichero.lectura();
            //visualización en pantalla de la linea leida
            System.out.println(linea.toString());
        }
        //cierre enlac e fichero
        fichero.cierre();
    }
        
}
