/*
FUNCIONALIDAD: dado un fichero de texto, con el nombre fichero1.txt, lleva a cabo
la lectura y visualización de su contenido caracter a caracter.
NOTA: en esta versión no utilizamos la variable char caracter porque visualizamos
directamente el casting char del código de caracter ((char) codigo)).
 */
package claseteorica_____03_12_2021;

public class ProblemaConvertirIntEnArrayChar {
    //método main
    public static void main(String [] argumentos) throws Exception
    {
        new ProblemaConvertirIntEnArrayChar().metodoPrincipal();
    }
    
    private void metodoPrincipal()
    {
        //DECLARACIÓN DE VARIABLES
        int numeroInicial;
        System.out.print("Introducir un número: ");
        numeroInicial = LT.readInt();
        int[] numerosBinario = new int[10];
        
        //TRATAMIENTO DE DATOS
        for (int i = numerosBinario.length-1; i >= 0; i--)
        {
            int numero = (int) Math.floor(Math.abs(numeroInicial) / Math.pow(10, i));
            numerosBinario[numerosBinario.length - 1 - i] = numero;
            numeroInicial -= numero * Math.pow(10, i);
        }
        
        //IMPRIMIR RESUTADO
        for (int i = 0; i < numerosBinario.length; i++) {
            System.out.print(numerosBinario[i]);
            if (i != numerosBinario.length-1) System.out.print(".");
        }
    }
}
