/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejercicios_gamificacion_9_toni_frau;

public class Palabra {

    //DECLARACION DE LOS ATRIBUTOS DE CLASE PARA LOS OBJETOS PALABRA
    private static final int MAXIMO_NUMERO_CARACTERES = 20;
    private static final char FINAL_SECUENCIA = '.';
    private static final char ESPACIO = ' ';
    private static char caracter=ESPACIO;
    private char[] caracteres = new char[MAXIMO_NUMERO_CARACTERES];
    private int numeroCaracteres = 0;
    
    
    //METODO CONSTRUCTOR
    public Palabra(){
        numeroCaracteres=0;
    }
    
    //METODO BUSCAR PALABRA(lo llamamos de hayPalabras)
    private static void  buscarPalabra(){
        while(caracter==ESPACIO){
            caracter = LT.readChar();
        }
    }
    
    //METODO BOOLEAN HAYPALABRAS
    public static boolean hayPalabras(){
        //BUSCAR PALABRA
        buscarPalabra();
        return (caracter!=FINAL_SECUENCIA);
    }
    
    //METODO LECTURA
    //NOTA: ESTE METODO SOLO SERA LLAMADO CUANDO EL METODO HAY PALABRA A VERIFICADO QUE 
    //HAY ALMENOS 1 PALABRA EN LA SECUENCIA
    public void lectura(){
        //inicializacion del atributo numeroCaracteres 
        numeroCaracteres=0;
        while((caracter!=FINAL_SECUENCIA) && (caracter!=ESPACIO)){
            caracteres[numeroCaracteres]= caracter;
            numeroCaracteres++;
            caracter= LT.readChar();
        }
    }
    
    //METODO TOSTRING
    @Override
    public String toString(){
        String resultado= "";
        for (int indice = 0; indice < numeroCaracteres; indice++) {
            resultado= resultado+caracteres[indice];
        }
        return resultado;
    }
    
    //METODO BOOLEAN QUE VERIFICA SI UNA PALABRA TIENE LOS CARACTERES PAR
    public boolean numeroParDeCaracteres(){
        return numeroCaracteres%2==0;
    }
    
    //METODO TIENE VOCALES
    public boolean tieneVocales(){
        for (int indice = 0; indice < numeroCaracteres; indice++) {
            if (esVocal(caracteres[indice])) {
                return true;
            }
        }
        return false;
    }
    
    //MÉTODO VOCALES SON PARA SABER SI TODAS LAS VOCALES SON UNAS DADAS
    public boolean vocalesSon(char[] c)
    {
        boolean sonTal = true;
        for (int i = 0; i < numeroCaracteres; i++) {
            if (esVocal(caracteres[i]))
            {
                boolean esVocalAMirar = false;
                for (int j = 0; j < c.length; j++)
                {
                    esVocalAMirar = esVocalAMirar || caracteres[i] == c[j];
                }
                sonTal = sonTal && esVocalAMirar;
            }
        }
        return sonTal;
    }
    
    //MÉTODO VOCALES SON PARA SABER SI TODAS LAS VOCALES SON UNA DADA
    public boolean vocalesSon(char c)
    {
        boolean sonTal = true;
        for (int i = 0; i < numeroCaracteres; i++) {
            if (esVocal(caracteres[i]))
            {
                sonTal = sonTal && caracteres[i] == c;
            }
        }
        return sonTal;
    }
    
    //MÉTODO INVERTIR PARA INVERTIR EL ORDEN DE LA PALABRA
    public void invertir()
    {
        char[] invertido = new char[numeroCaracteres+1];
        for (int i = numeroCaracteres-1; i > -1; i--) {
            invertido[i] = caracteres[numeroCaracteres - 1 -i];
        }
        for (int i = 0; i < numeroCaracteres; i++) {
            caracteres[i] = invertido[i];
        }
    }
    
    //MÉTODO PONER MAYUSCULAS PARA PASAR A MAYÚSCULAS LA PALABRA
    public void ponerMayusculas()
    {
        for (int i = 0; i < numeroCaracteres; i++) {
            if ((int)caracteres[i] >= ((int)'a') && (int)caracteres[i] <= ((int)'z'))
                caracteres[i] = (char)((int)caracteres[i] - ((int)'a'-'A'));
        }
    }
    
    //MÉTODO PONER MAYUSCULAS PARA PASAR A MAYÚSCULAS UN CARÁCTER DADO DE LA PALABRA
    public void ponerMayusculas(int pos)
    {
        if ((int)caracteres[pos] >= ((int)'a') && (int)caracteres[pos] <= ((int)'z'))
                caracteres[pos] = (char)((int)caracteres[pos] - ((int)'a'-'A'));
    }
    
    //MÉTODO PARA SABER SI ES PALÍNDROMA
    public boolean esPalindroma()
    {
        boolean esPalindroma = true;
        char[] girado = new char[numeroCaracteres+1];
        for (int i = numeroCaracteres-1; i > -1; i--) {
            girado[i] = caracteres[numeroCaracteres - 1 -i];
        }
        for (int i = 0; i < numeroCaracteres; i++) {
            esPalindroma = esPalindroma && (girado[i] == caracteres[i]);
        }
        return esPalindroma;
    }
    
    //MÉTODO PESO DE CODIGO PARA RECIBIR EL PESO DE CÓDIGO DE LA PALABRA
    public int pesoDeCodigo()
    {
        int peso = 0;
        for (int i = 0; i < numeroCaracteres; i++) {
            peso += (int)caracteres[i];
        }
        return peso;
    }
    
    //MÉTODO CANTIDAD VOCALES
    public int cantidadVocales()
    {
        int contador = 0;
        for (int i = 0; i < numeroCaracteres; i++) {
            if (esVocal(caracteres[i]))
                contador++;
        }
        return contador;
    }
    
    //MÉTODO CANTIDAD CARACTERES
    public int cantidadCaracteres()
    {
        return numeroCaracteres;
    }
    
    //MÉTODO HAY VOCALES PARA SABER SI HAY ALGUNA VOCAL EN LA PALABRA
    public boolean hayVocales()
    {
        boolean resultado = false;
        for (int i = 0; i < numeroCaracteres; i++) {
            if (esVocal(caracteres[i]))
                resultado = true;
        }
        return resultado;
    }
    
    //METODO ES VOCAL
    private boolean esVocal(char c){
        return c=='a' || c =='e' || c=='i' || c=='o' || c=='u';
    }
    
    //METODO QUE OBTIENE EL ULTIMO CARACTER DE UNA PALABRA
    public char getCaracter(int c){
        return caracteres[c];
    }
    
    //MÉTODO CANTIDAD POR VOCAL PARA SABER CUANTAS VOCALES Y DE QUÉ TIPO HAY
    public int[] cantidadPorVocal()
    {
        int[] cantidad = {0,0,0,0,0};
        for (int i = 0; i < numeroCaracteres; i++) {
            switch (caracteres[i]) {
                case 'a':
                    cantidad[0]++;
                    break;
                case 'e':
                    cantidad[1]++;
                    break;
                case 'i':
                    cantidad[2]++;
                    break;
                case 'o':
                    cantidad[3]++;
                    break;
                case 'u':
                    cantidad[4]++;
                    break;
                default:
                    break;
            }
        }
        return cantidad;
    }
    
    //METODO COPIAR
    public static void copiar(Palabra pal1, Palabra pal2){
        pal2.numeroCaracteres=pal1.numeroCaracteres;
        for (int indice = 0; indice < pal1.numeroCaracteres; indice++) {
            pal2.caracteres[indice]=pal1.caracteres[indice];
        }
    }
}