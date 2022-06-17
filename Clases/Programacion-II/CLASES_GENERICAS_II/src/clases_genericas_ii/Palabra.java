package clases_genericas_ii;

/*
CLASE Palabra
ENTORNO DE TRABAJO:
La secuencia de caracteres introducida por teclado puede contener como 
caracteres os siguientes: espacios en blanco, saltos de línea, caracteres
del alfabeto (minúsculas sin acentos ni diéresis), el espacio en blanco y los siguientes 
signos de puntuación: . , : @ ? ! " ( ) < >.
El final de secuencia vendrá dado por el caracter de control salto de línea '\n'
 */



public class Palabra implements java.io.Serializable {
    //ATRIBUTOS (describen el estado de los objetos Palabra)
    //declaración atributo de clase constante caracter que representa el final de
    //la secuencia de caracteres
    private static final char FINAL_SECUENCIA='\n';
    //declaración atributo de clase constante caracter que representa el espacio
    //en blanco
    private static final char ESPACIO=' ';
    //declaración atributo de clase constante entero que representa el máximo número
    //de caracteres que puede aglutinar un objetp Palabra
    private static final int MAXIMO_NUMERO_CARACTERES=20;
    //declaración atributo de clase variable caracter que representa el caracter leido
    //de la secuencia de caracteres introducida por teclado
    private static char caracter=ESPACIO; //es inicializada con el caracter espacio
                                          //para llevar a cabo la lectura
                                          //del primer caracter de la secuencia
                                          //a través del método buscarPalabra() la
                                          //primera vez que es llamado.
    //declaración atributo de objeto variable array de componentes caracter que representa
    //los caracteres de un objeto Palabra
    private char [] caracteres=new char[MAXIMO_NUMERO_CARACTERES];
    //declaración atributo de objeto variable entero que representa el número de caracteres
    //de un objeto Palabra
    private int numeroCaracteres;
    
    //MÉTODOS
    
    //CONSTRUCTORES
    public Palabra() {
        numeroCaracteres=0;
    }
    
    //delaración constructor que posibilite la creación de un objeto Palabra
    //pasándole, a través de un parámetro String, los caracteres que
    //va a contener
    public Palabra(String dato) {
        //asignación de los caracteres del parámetro String dato al atributo
        //array caracteres con el método toCharArray
        caracteres=dato.toCharArray();
        //asignación del número de caracteres del parámetro String dato
        //a altributo numeroCaracteres
        numeroCaracteres=dato.length();
    }
    
    //MÉTODOS FUNCIONALES (describen el comportamiento de los objetos Palabra)
    
    //MÉTODO buscarPalabra QUE TIENE COMO OBJETIVO LA BÚSQUEDA DE UNA PALABRA
    //EN LA SECUENCIA DE CARACTERES DE ENTRADA. DICHA BÚSQUEDA SE BASA EN LA
    //LECTURA E IDENTIFICACIÓN DEL PRIMER CARACTER DE LA PALABRA
    private static void buscarPalabra() {
        try {
            //leer siguiente caracter mientras el caracter leido no sea ni alfabético
            //ni final de secuencia ('.'), es decir, como el conjunto de caracteres
            //que entran en juego en el entorno de tratamiento secuencia son: los
            //caracteres alfabéticos minúsculas, es espacio en blanco y el '.', la
            //condición compuesta anterior es análoga a decir que hay que seguir leyendo
            //desde la secuencia mientras que el caracter leido sea espacio en blanco
            while (esSeparador(caracter)) {
                //lectura siguiente caracter de la secuencia
                caracter=LT.readCharacterLine();
            }            
        }catch (Exception error) {
            System.out.println(error.toString());
        }

    }
    
    //MÉTODO hayPalabras QUE TIENE COMO OBJETIVO EL RESPONDER A LA PREGUNTA DE SI
    //HAY ALGUNA PALABRA EN LA SECUENCIA DE CARACTERES PARA LEER
    public static boolean hayPalabras() {
        buscarPalabra();
        if (caracter!=FINAL_SECUENCIA) {
            return true;
        }
        else {
            caracter=ESPACIO;
            return false;
        }
    }
    
    //MÉTODO lectura QUE TIENE COMO OBJETIVO LA LECTURA DE UN OBJETO Palabra 
    //DESDE LA SECUENCIA DE CARACTERES DE ENTRADA.
    //NOTA: EL MÉTODO lectura SÓLO PODRÁ LLAMARSE DESPUÉS DE HABER LLAMADO AL
    //MÉTODO hayPalabras Y QUE SE HAYA VERIFICADO QUE HAY ALGUNA PALABRA PARA LEER
    //
    // VERSIÓN MÉTODO DE OBJETO
    //
    public void lectura() {
        //inicializar a 0 el atributo numeroCaracteres del objeto Palabra que ha
        //llamado a este método y que será el obvjeto en el que vamos a almacenar
        //la palabra leida desde la secuencia
        numeroCaracteres=0;
        try {
            //lectura y almacenamiento de los caracteres de la palabra leida desde
            //la secuencia de caracteres
            while ((caracter!=FINAL_SECUENCIA)&&(!esSeparador(caracter))) {
                //almacenar el caracter de la palabra leido en la componente
                //correspondiente del atributo array caracteres del objeto Palabra
                caracteres[numeroCaracteres]=caracter;
                //inrementar el atributo numeroCaracteres del objeto Palabra en una
                //unidad porque acabamos de almacenar el array caracteres un caracter
                //de la palabra
                numeroCaracteres++;
                //lectura siguiente caracter de la secuencia
                caracter=LT.readCharacterLine();
            }             
        }catch (Exception error) {
            System.out.println(error.toString());
        }
    }
    
    //MÉTODO lectura QUE TIENE COMO OBJETIVO LA LECTURA DE UN OBJETO Palabra 
    //DESDE LA SECUENCIA DE CARACTERES DE ENTRADA.
    //NOTA: EL MÉTODO lectura SÓLO PODRÁ LLAMARSE DESPUÉS DE HABER LLAMADO AL
    //MÉTODO hayPalabras Y QUE SE HAYA VERIFICADO QUE HAY ALGUNA PALABRA PARA LEER
    //
    // VERSIÓN MÉTODO DE CLASE
    //
    public static void lectura(Palabra pal) {
        //inicializar a 0 el atributo numeroCaracteres del objeto Palabra que ha
        //llamado a este método y que será el obvjeto en el que vamos a almacenar
        //la palabra leida desde la secuencia
        pal.numeroCaracteres=0;
        
        try {
            //lectura y almacenamiento de los caracteres de la palabra leida desde
            //la secuencia de caracteres
            while ((caracter!=FINAL_SECUENCIA)&&(caracter!=ESPACIO)) {
                //almacenar el caracter de la palabra leido en la componente
                //correspondiente del atributo array caracteres del objeto Palabra
                pal.caracteres[pal.numeroCaracteres]=caracter;
                //inrementar el atributo numeroCaracteres del objeto Palabra en una
                //unidad porque acabamos de almacenar el array caracteres un caracter
                //de la palabra
                pal.numeroCaracteres++;
                //lectura siguiente caracter de la secuencia
                caracter=LT.readCharacterLine();
            }             
        }catch (Exception error) {
            System.out.println(error.toString());
        } 
    }
    
    //MÉTODO toString que tiene como objetivo la conversión de un objeto Palabra en
    ///String con fines de ser utilizado con los métodos de visualización System.out.print
    //y System.out.println
    public String toString() {
        //DECLARACIÓN
        String temporal="";
        //añadir, por concxatenación, al String temporal los caracteres del objeto
        //palabra
        for (int indice=0;indice<numeroCaracteres;indice++) {
            //concatenar al String temporal el caracter del objeto Palabra
            //que está almacenado en la componente indice-ésima del array
            //caracteres de dicho objeto
            temporal=temporal+caracteres[indice];
        }
        //devolver String resultante
        return temporal;
    }
    
    
    //MÉTODO numeroVocales QUE TIENE COMO OBJETIVO EL OBTENER EL NÚMERO DE
    //VOCALES DE UN OVJETO PALABRA
    public int numeroVocales() {
        //DECLRACIONES
        int contador=0;
        //contabilizar el número der vocales de la palabra
        for (int indice=0;indice<numeroCaracteres;indice++) {
            //verificar si el caracter contenido en la componente indice-ésima
            //del atriubuto array caracteres del objeto Palabra es una vocal
            if (esVocal(caracteres[indice])) {
                //incrementar contador de vocales
                contador++;
            }
        }
        //devolver contador de vocales
        return contador;
    }
    
    
    //MÉTODO numeroConsonantes QUE TIENE COMO OBJETIVO EL OBTENER EL NÚMERO DE
    //CARACTERES CONSONANTES DE UN OBJETO Palabra
    public int numeroConsonantes() {
        return (numeroCaracteres-numeroVocales());
    }
    
    //MÉTODO esVocal QUE TIENE COMO OBJETIVO VERIFICAR SI UN CARACTER, PASADO POR 
    //PARÁMETRO, ES UNA VOCAL
    private boolean esVocal(char car) {
        return ((car=='a')||(car=='e')||(car=='i')||(car=='o')||(car=='u'));
    }
    
    //MÉTODO numeroParDeCaracteres QUE TIENE COMO OBJETIVO VERIFICAR SI UN OBJETO
    //Palabra TIENE UN NÚMERO PAR DE CARACTERES
    public boolean numeroParDeCaracteres() {
        return (numeroCaracteres%2==0);
    }
    
    //MÉTODO getNumeroCaracteres QUE TIENE COMO OBJETIBO EL OBTENER EL
    //NÚMERO DE CARACTERES DE UN OVJETO Palabra
    public int getNumeroCaracteres() {
        return numeroCaracteres;
    }
    
    //MÉTODO tieneLasCincoVocales QUE TIENE COMO OBJETIVO VERIFICAR SI UN OBJETO
    //Palabra TIENE 5 VOCALES Y ÉSTAS SON LAS CINCO VOCALES
    public boolean tieneLasCincoVocales() {
        //DECLARACIONES 
        //declaración array de componentes char para almacenar las 5 vocales
        final char [] VOCALES={'a','e','i','o','u'};
        //declraciín array de omponente enteras para almacenar las apariciones
        //de las vocales
        int [] apariciones={0,0,0,0,0};
        
        //TRATAMIENTO
        //verificación caracter a caracter del objeto Palabra si es vocal, y si
        //lo es incrementar su contador correspondiente
        for (int indice=0;indice<numeroCaracteres;indice++) {
            //verificación si es una vocal el indice-ésimo caracter del objeto Palabra
            int i;
            for (i=0;((i<VOCALES.length)&&(caracteres[indice]!=VOCALES[i]));i++) {}
            if (i<VOCALES.length) {
                //incrementar contador de la vocal identificada
                apariciones[i]++;   
            }
        }
        //analizar resultado de las apariciones
        //Si todas las componentes del array apariciones tiene valor 1 significará
        //que en la palabra hay 5 vocales y éstas son las 5 vocales
        for (int indice=0;indice<apariciones.length;indice++) {
            if (apariciones[indice]!=1) {
                return false;
            }
        }
        return true;
    }

    //MÉTODO adicionCaracter LLEVA A CABO LA ADICIÓN DE UN CARACTER DADO POR PARÁMETRO
    //EN UN OBJETO Palabra
    public void adicionCaracter(char caracter) {
        //almacenar el caracter dado en la primera componente libre del atributo
        //caracteres del objeto Palabra. El índice de dicha componente coincide
        //con el valor del atributo numeroCaracteres del mismo objeto Palabra
        caracteres[numeroCaracteres]=caracter;
        //incrementar el atributo numeroCaracteres del objeto Palabra para que
        //tenga en cuenta el caracter que acabamos de añadir en la palabra
        numeroCaracteres++;
    }
    
    //MÉTODO obtenerCaracter LLEVA A CABO LA OBTENCIÓN DEL CARACTER DE UNA
    //PALABRA QUE ESTÁ ALMACENADO EN LA POSICIÓN DADA DENTRO DEL ATRIBUTO
    //caracteres DE DICHO OBJETO Palabra
    public char obtenerCaracter(int posicion) {
        //devolver el caracter del objeto Palabra que está en la posición
        //dada dentro del atributo array caracteres
        return (caracteres[posicion]);
    }

    //MÉTODO esSeparador VERIFICA SI EL CÓDIGO DE CARACTER DADO SE CORRESPONDE
    //CON UN CARACTER SEPARADOR
    private static boolean esSeparador(char car) {
        return ((car==',')||(car=='.')||(car==':')||(car=='@')||(car=='?')||
                (car=='!')||(car=='"')||(car=='(')||(car==')')||(car=='<')||
                (car=='>')||(car==ESPACIO));
    }    
    
    //método que lleva a cabo la inversión de un objeto Palabra a través de una 
    //pila
    public Palabra inversion() {
        //declaración pila de caracteres
        PilaConArrayList<Character> pilaCaracteres=new PilaConArrayList<Character>();
        //declaración objeto palabra
        Palabra pal=new Palabra();
        
        //ACCIONES
        //introducción de los caracteres del objeto palabra en la pila
        for (int indice=0;indice<numeroCaracteres;indice++) {
            //introducción en la pila de caracteres del caracter indice del objeto
            //palabra
            pilaCaracteres.introducir(caracteres[indice]);
        }
        //asignación a pal.numeroCaracteres del número de caracteres introducidos
        //en la pila
        pal.numeroCaracteres=pilaCaracteres.numElementos();
        //bucle extracción de los caracteres de la pila y asignación al objeto Palabra local
        for (int indice=0;!pilaCaracteres.estaVacia();indice++) {
            pal.caracteres[indice]=pilaCaracteres.extraer();
        }
        //retornar el objeto Palabra pal
        return pal;
    }
    
}
