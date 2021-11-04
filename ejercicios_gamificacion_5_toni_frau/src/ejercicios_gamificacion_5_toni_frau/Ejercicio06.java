/*
 * FUNCIONALIDAD: crear programa para inicializar 2 arrays, entera con temperaturas
 * medias y String con los meses del año para mostrar la temperatura media,
 * la del mes más caluroso y el más frío
 * OBJETIVO: realizar el proyecto de entregas para la asignatura de programación
 * FECHA DE REALIZACIÓN: 02.11-2021
 * AUTOR: Antoni Frau Gordiola
 */
package ejercicios_gamificacion_5_toni_frau;

public class Ejercicio06 {
    //método main
    public static void main(String [] argumentos) throws Exception {
        new Ejercicio06().metodoPrincipal();
    }
    
    //método metodoPrincipal
    private void metodoPrincipal() throws Exception
    {
        //DECLARACIONES
        int[] temperaturas = {8,9,13,19,22,25,29,38,31,23,18,13};
        String[] meses = {"Enero", "Febrero", "Marzo", "Abril", "Mayo", "Junio",
            "Julio", "Agosto", "Septiembre", "Octubre", "Noviembre", "Diciembre"};
        
        //ACCIONES
        temperaturaMedia(temperaturas, meses);
        
        masCalido(temperaturas, meses);
        
        masFrio(temperaturas, meses);
    }
    
    //método proceso temperaturaMedia que muestra las temperaturas medias de cada mes
    private void temperaturaMedia(int[] temperaturas, String[] meses)
    {
        //INICIALIZACIÓN
        float media = 0;
        
        //ACCIONES
        for (int i = 0; i < meses.length;i++)
            media += temperaturas[i];
        
        media /= temperaturas.length;
        
        //VISUALIZACIÓN
        System.out.println("La temperatura media del año es " + media);
    }
    
    //método proceso masCalido para detectar la temperatura más calida y mostrarla
    private void masCalido(int[] temperaturas, String[] meses)
    {
        //INICIALIZACIÓN
        int maxima = 0;
        for (int i = 0; i< meses.length;i++)
            if (temperaturas[i] > temperaturas[maxima])
                maxima = i;
        
        System.out.println("La temperatura máxima es de " + meses[maxima] + " con"
                + " " + temperaturas[maxima] + " grados");
    }
    
    //método proceso masFrio para detectar la temperatura más fría y mostrarla
    private void masFrio(int[] temperaturas, String[] meses)
    {
        //INICIALIZACIÓN
        int minima = 0;
        for (int i = 0; i<meses.length;i++)
            if (temperaturas[i] < temperaturas[minima])
                minima = i;
        
        System.out.println("La temperatura mínima es de " + meses[minima] + " con"
                + " " + temperaturas[minima] + " grados");
    }
}