/*
FUNCIONALIDAD: dada unalinea por teclado visualizar el número de caracteres
que la componen.

USO CLASE Linea
 */
package clase_practica_____21_12_2021;


public class VisualizarNumeroCaracteresLineaPorTeclado {
    //declaración método main
    public static void main(String [] argumentos) throws Exception {
        new VisualizarNumeroCaracteresLineaPorTeclado().programaPrincipal();
    }
    
    //declaración método programaPrincipal
    public void programaPrincipal() throws Exception {
        //DECLARACIONES    
        //deckaración objeto Linea para almacenar la secuencia de caracteres
        //introducida por teclado
        Linea linea=new Linea();
        
        //ACCIONES
        //mensaje usuario para introducir secuencia linea por teclado a cabada en 
        //SALTO DE LINEA
        System.out.print("INTRODUCIR LINEA (finalizar con salto de linea): ");
        //LECTURA Y TRATAMIENTO LINEA
        if (Linea.hayLinea()) {
            //lectura linea
            linea.lectura();
            //tratamiento linea
            //visualizar el número de caracteres de la linea
            System.out.println("EL NÚMERO DE CARACTERES DE LA LINEA ES "+linea.getNumCaracteres());
        }
        
    }
}
