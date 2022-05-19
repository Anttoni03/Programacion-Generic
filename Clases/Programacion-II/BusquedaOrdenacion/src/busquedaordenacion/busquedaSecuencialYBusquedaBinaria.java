// BÚSQUEDA SECUENCIAL Y BÚSQUEDA BINARIA O DICOTÓMICA EN MEMORIA INTERNA
//A TRAVÉS DE UN VECTOR DE COMPONENTES NUMÉRICAS ENTERAS
// realización: Juan Montes de Oca

package busquedaordenacion;

public class busquedaSecuencialYBusquedaBinaria {
    //declaración método main

    public static void  main (String args[]) {
        new busquedaSecuencialYBusquedaBinaria().metodoPrincipal();
    }
    //declaración método metodoPrincipal
    public void metodoPrincipal() {    
        //DECLARACIONES
        //declaración constante número de elementos vector
        final int MAXIMO=40;
        //declaración vector elementos
        int [] datos = new int [MAXIMO];
        //declaración variable entera para almacenar resultado
        int resultado;
        //declaración variable entera para introducir número a buscar por teclado
        int numero;
        //ACCIONES
        try {
            //mensaje introducción número a buscar
            System.out.print("NÚMERO A BUSCAR: ");
            //lectura número a buscar
            numero=LT.lecturaEntero();
            //inicialización componentes vector con el valor de 2*i (i es la variable
            //iterativa)
            for (int i = 0; i < datos.length ; i++) datos[i] = 2*i ;
            //VISUALIZAR CONTENIDO VECTOR
            for (int i=0;i<datos.length;i++) {
                System.out.print(datos[i]+" ");
            }
            //llama al método que lleva a cabo el tratamniento de búsqueda lineal
//            resultado = busquedaSecuencial(datos, numero);
            //llama al método que lleva a cabo el tratamiento de búsqueda binaria
            resultado = busquedaBinaria(datos, numero);
            //VISUALIZAMOS RESULTADO
            if (resultado != -1)
                System.out.println ( "\nNÚMERO ENCONTRADO EN LA POSICIÓN: "+  resultado);
            else
                System.out.println ( "\nNÚMERO NO ENCONTRADO"  );            
        }catch (Exception error) {
            System.out.println("\nERROR: "+error.toString());
        }

    }

    //MÉTODO DE BÚSQUEDA LÍNEAL/SECUENCIAL
    public int busquedaSecuencial( int [] vector, int dato) {
        int numElementos =vector.length;
        int pos=0;
        try {
            while ((pos<numElementos)&&(vector[pos]!=dato)) {
                pos++;
            }
            if (pos<numElementos) return pos;            
        }catch (Exception error) {
            System.out.println("\nERROR EN MÉTODO BÚSQUEDA: "+error.toString());
        }
        return -1;
    }



    //MÉTODO DE BÚSQUEDA BINARIA/DICOTÓMICA
    public int busquedaBinaria( int [] vector, int dato)  {
        //DECLARACIONES
        int inicio = 0;
        int fin = vector.length - 1;
        int pos;
        try {
            //Tratamiento búsqueda dicotómica/binaria
            while (inicio <= fin) {
                //obtenemos la posición dentro del vector del elemento medio
                pos = (inicio+fin) / 2;
                //comparamos el elemento medio con el valor buscado
                if ( vector[pos] == dato )
                    //si el valor buscado es igual al elemento medio, finalizamos
                    //el tratamiento devolviendo la posición del elemento medio
                    return pos;
                //si el elemento medio no es igual al elemento buscado
                else {
                        //verificamos si el valor buscado es mayor que el elemento
                        //medio del vector
                        if ( vector[pos] < dato ) {
                            //asignamos a inicio el valor del indice de la siguiente
                            //componente al elemento medio
                            inicio = pos+1;
                        }
                        else {
                            //asignamos a fin el indice de la componente anterior del
                            //elemento medio
                            fin = pos-1;                     
                        }
                }
            }            
        }catch (Exception error) {
            System.out.println("\nERROR EN MÉTODO BÚSQUEDA: "+error.toString());
        }
        return -1;
    }

}