/*
FUNCIONALIDAD: dado un texto introducido por teclado, visualiza el texto codificado
en función del siguiente criterio de encriptación: desplazamiento de los caracteres
del alfabeto 3 posiciones a la izquierda.

INFORMACIÓN SUMINISTRADA:
ALFABETO=           {a,b,c,d,e,f,g,h,i,j,k,l,m,n,o,p,q,r,s,t,u,v,w,x,y,z}
 */
package clase_teoria_______17_12_2021;

public class codificacion_v3 {
    public static void main(String [] argumentos) throws Exception {
        new codificacion_v3().metodoPrincipal();
    }
    
    private void metodoPrincipal() {
        //DECLARACIONES
        final char FINAL_SECUENCIA='.';
        final char ESPACIO=' ';
        char caracter;
        
        //ACCIONES
        //mensaje usuario para introducir texto
        System.out.print("INTRODUCIR TEXTO A CODIFICAR: ");
        //lectura del primer caracter del texto introducido
        caracter=LT.readChar();
        //bucle iterativo de tratamiento de recorrido (iteración de caracteres)
        while (caracter!=FINAL_SECUENCIA) {
            //tratamiento caracter leido
            if (caracter!=ESPACIO) {
                //codificación caracter
                caracter=codificacion(caracter);
            }
            //visualización caracter codificado
            System.out.print(caracter);
            //lectura siguiente caracter del texto
            caracter=LT.readChar();
        }
        //salto de linea en visualización
        System.out.println();    
    }
    
    //método que lleva a cabo la codificación de un caracter dado
    public char codificacion(char car) {
        //DECLARACIONES
        final char [] ALFABETO="abcdefghijklmnopqrstuvwxyz".toCharArray();
        
        //ACCIONES
        //búsqueda en ALFABETO el caracter dado
        int indice=0;
        while (car!=ALFABETO[indice]) {
            indice++;
        }
        //retornar caracter codificado correspondiente
        return ALFABETO[(indice+3)%ALFABETO.length];        
    }
    
}

