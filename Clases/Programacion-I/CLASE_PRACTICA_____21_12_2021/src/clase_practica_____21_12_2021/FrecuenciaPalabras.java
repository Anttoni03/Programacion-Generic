/*
CLASE FrecuenciaPalabras
 */
package clase_practica_____21_12_2021;

public class FrecuenciaPalabras {
    //DECLARACIÓN ATRIBUTOS
    //declaración atributo de clase constante entero que representa
    //el número máximo de palabras diferentes que pueden aparecer en
    //una secuencia o texto
    private static final int NUMERO_MAXIMO_PALABRAS=500;
    //declaración atributo de objeto array de NUMERO_MAXIMO_PALABRAS componentes
    //de objetos Palabra
    private Palabra [] palabras=new Palabra[NUMERO_MAXIMO_PALABRAS+1];
                                            //sumamos una unidad al número
                                            //de componentes del aray palabras
                                            //debido a la metodología utilizada
                                            //en el método actualización
    //declaración atributo de objeto array de NUMERO_MAXIMO_PALABRAS componentes
    //enteras para representar la frecuencia de aparición de las palabras
    //de una secuencia o texto
    private int [] frecuencias=new int[NUMERO_MAXIMO_PALABRAS+1];
    //declaración atributo de objeto variable entera que representa el
    //número máximo de palabras diferentes contenidas en una secuencia o texto
    private int numeroPalabras;
    
    //MÉTODOS
    //CONSTRUCTOR
    public FrecuenciaPalabras() {
        //inicialización 
        numeroPalabras=0;
    }
    
    //MÉTODOS FUNCIONALES
    
    //MÉTODO actualización TIENE COMO OBJETIVO ACTUALIZAR EL ARRAY DE frecuencias
    //DE UN OBJETO frecuenciaPalabras DADA UN OBJETO Palabra POR PARÁMETRO
    public void actualizacion(Palabra palabra) {
        //ACCIONES
        //delclaración variable entera para acceder al array palabras
        int indice;
        //asignar a la componente numeroPalabras del array palabras la palabra
        //dada por parámetro
        //antes deberíamos instanciar el objeto Palabra de la componente
        //numeroPalabras para luego llevar a cabo la copia
        palabras[numeroPalabras]=new Palabra();
        Palabra.copiar(palabra,palabras[numeroPalabras]);
        //buscar componente del array palabras donde se encuentra la palabra
        //dada por parámetro
        for (indice=0;((indice<(numeroPalabras+1))&&
                (!palabra.iguales(palabras[indice])));indice++) {}
        //al finalizar la sentencia for tendremos en indice la componente
        //en el array palabras donde hemos encontrado la palabra dada
        //por parámetro.
        //Si esta posición es menor que numeroPalabras significará que
        //la palabra dada no es la primera vez que aparecey, por lo tanto,
        //deberemos solo incrementar su frecuencia de aparición en
        //el array frecuencias.
        //si po el contrario, el valor de indice es igual a numeroPalabras,
        //significará que la palabra dada es la primera vez que aparece
        //y por lo tanto tendremos qure darla de alta en la estructura
        //incrementado el atributo numeroPalabras en una unidad para
        //constatar que hay una palabra más e inicializar la frecuencia
        //de esta nueva palabra a 1 en el array de frecuencias
        if (indice<numeroPalabras) {
            //incrementar frecuencia de aparición de la palabra dada
            frecuencias[indice]++;
        }
        else {
            //
            //Como la palabra dada ha sido la primera vez que ha aparecido
            //tenemos que inicializar su frecuencia
            frecuencias[numeroPalabras]=1;
            //y como al inicio del método la palabra ya la habíamos
            //almacenado en el array palabras solo quedaría incrementar
            //el contador de numero de palabras diferentes para constatar
            //el almacenamiento de la palabra en dicho array
            numeroPalabras++;
        }       
    }
    
    //MÉTODO toString QUE LLEVA A CABO LA CONVERSIÓN DE UN OBJETO FrecuenciaPalabras
    //a String con fines de visualización 
    public String toString() {
        //DECLARACIONES
        String tmp="\n";
        //Asignación al String local tmp por concatenación la información
        //relativa al objeto FrecuenciaPalabras
        for (int indice=0;indice<numeroPalabras;indice++) {
            //concatencación al String local tmp de la palabra indice-ésima y de su
            //frecuencia de aparición
            tmp=tmp+"Frecuencia palabra "+palabras[indice].toString()+": "
                    +frecuencias[indice]+".\n";
            
        }
        //devolver String local tmp resultante
        return tmp;
    }
    
    //MÉTODO toString QUE LLEVA A CABO LA CONVERSIÓN A String DE LA FRECUENCIA
    //DE APARICIÓN DE UNA PALABRA DADA CORRESPONDIENTE A UN OBJETO FrecuenciaPalabras
    public String toString(Palabra palabra) {
        //DECLARACIONES
        //declaración variable entera que represente la posición que ocupa en
        //el array de palabras la palabra dada
        int posicion;
        
        //ACCIONES
        //buscar la posición de la palabra dada en el array palabras
        for (posicion=0;!palabra.iguales(palabras[posicion]);posicion++) {}
        //devolución en String de la información frecuencia palabra dada del objeto
        //FrecuenciasCaracteres 
        return "Frecuencia palabra "+palabras[posicion].toString()+": "
                    +frecuencias[posicion]+".";
    }
    
    //MÉTODO obtenerFrecuencia LLAVA A CABO LA OBTENCIÓN DE LA FRECUENCIA DE APARICIÓN
    //DE UNA PALABRA DADA CORRESPONDIENTE A UN OBJETO FrecuenciaPalabras
    public int obtenerFrecuencia(Palabra palabra) {
        //DECLARACIONES
        //declaración variable entera que represente la posición que ocupa en
        //el array de palabras la palabra dada
        int posicion;
        
        //ACCIONES
        //buscar la posición del caracter dado en el array caracteres
        for (posicion=0;!palabra.iguales(palabras[posicion]);posicion++) {}   
        //devolución frecuencia del caracter dado
        return frecuencias[posicion];
    }
    
    
        
    //MÉTODO getPalabras QUE LLEVA A CABO LA OBTENCIÓN DE LAS PALABRAS OBJETO
    //DE LA GESTIÓN DE SUS APARICIONES
    public Palabra [] getPalabras() {
        return palabras;
    }
    
    //MÉTODO getNumeroPalabras QUE LLEVA A CABO LA OBTENCIÓN DEL NÚMERO DE PALABRAS
    //OBJETO DE LA GESTIÓN DE SUS APARICIONES
    public int getNumeroPalabras() {
        return numeroPalabras;
    }
}
