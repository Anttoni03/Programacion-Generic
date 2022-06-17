/*
PROGRAMA QUE LLEVA A CABO LA CONVERSIÓN A NÚMERACIÓN DECIMAL DE UNA CIFRA ROMANA
INTRODUCIDA POR TECLADO. TODO ELLO A TRAVÉS DE UN MENU GENERAL.
COMPROBACIÓN DE CORRECCIÓN DE LA CIFRA ROMANA A TRAVÉS DE TABLA DE ESTADOS CORRESPONDIENTE
A AUTÓMATO FINITO DETERMINISTA.
 */                             
package complejidadalgoritmica;


import java.io.IOException;

public class CifrasRomanas_v5 {
    private static final char [] SIMBOLOS = "IVXLCDMWY ".toCharArray();
    
    public static void main(String[] args) {
        new CifrasRomanas_v5().metodoPrincipal();
    }
           
    public void metodoPrincipal() {
        boolean fin=false;
        while (!fin) {
            visualizacionMenu();
            int opcion=LT.readInt();
            switch (opcion) {
                case 1: tratamiento();break;
                default: fin=true;
            }
        }
    }
    
    private void visualizacionMenu() {
        System.out.print("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n"
                + "PROGRAMA DE CONVERSIÓN NÚMEROS ROMANOS A NÚMEROS ENTEROS\n\n\n");  
        System.out.print("         1. conversion.\n");
        System.out.print("         2. fin.\n\n\n");
        System.out.print("[] opcion: ");
    }

    private void tratamiento()  {
        System.out.print("\n\nNÚMERO ROMANO A CONVERTIR (max: YYYMYCMXCIX): ");
        String numRomano=LT.readLine();  
        if (cifraCorrecta(numRomano)) {
            System.out.println("EL NÚMERO CORRESPONDIENTE A " +numRomano+
                " ES: \n\n                 " + conversion(numRomano));  
            
        }
        else {
            System.err.println("CIFRA ROMANA NO CORRECTA");
        }
        System.out.print("\n\n< CONTINUAR --> RETURN > ");
            try {
                char car=(char) System.in.read();
            }catch (IOException error) {}    
    }
    
    private int conversion(String cifra) {
        int vDigito1,vDigito2;
        cifra=cifra+' '; // añadimos un blanco atras
        int resultado=0;
        int indice=0;
        vDigito1=valorDigito(cifra.charAt(indice));
        for (;indice<cifra.length()-1;indice++) {
            vDigito2=valorDigito(cifra.charAt(indice+1));
            if (vDigito1>=vDigito2) {
                resultado=resultado+vDigito1;
            }
            else {
                resultado=resultado-vDigito1;
            }
            vDigito1=vDigito2;
        }
        return resultado;
    }

    private int valorDigito(char caracter) {
        
        final int valores[] = new int[]{1, 5, 10, 50, 100, 500, 1000, 5000, 10000,0};
        int indice = 0;
        while (caracter!= SIMBOLOS[indice]) {
            indice++;
        }
        return valores[indice];
    }
    
    private boolean cifraCorrecta(String cifra) {
        final int estadoInicial = 0;
        final int error = 25;
        final int[][] TABLA = {
        // I     V      X      C      L      D      M      W      Y     otros
        {    1,     2,     6,     7,    11,    12,    16,    17,    21, error}, // 0
        {    4,     5,     5, error, error, error, error, error, error, error}, // 1
        {    3, error, error, error, error, error, error, error, error, error}, // 2
        {    4, error, error, error, error, error, error, error, error, error}, // 3
        {    5, error, error, error, error, error, error, error, error, error}, // 4
        {error, error, error, error, error, error, error, error, error, error}, // 5
        {    1,     2,     9,    10,    10, error, error, error, error, error}, // 6
        {    1,     2,     8, error, error, error, error, error, error, error}, // 7
        {    1,     2,     9, error, error, error, error, error, error, error}, // 8
        {    1,     2,    10, error, error, error, error, error, error, error}, // 9
        {    1,     2, error, error, error, error, error, error, error, error}, //10
        {    1,     2,     6,     7,    14,    15,    15, error, error, error}, //11
        {    1,     2,     6,     7,    13, error, error, error, error, error}, //12
        {    1,     2,     6,     7,    14, error, error, error, error, error}, //13
        {    1,     2,     6,     7,    15, error, error, error, error, error}, //14
        {    1,     2,     6,     7, error, error, error, error, error, error}, //15
        {    1,     2,     6,     7,    11,    12,    19,    20,    20, error}, //16
        {    1,     2,     6,     7,    11,    12,    18, error, error, error}, //17
        {    1,     2,     6,     7,    11,    12,    19, error, error, error}, //18
        {    1,     2,     6,     7,    11,    12,    20, error, error, error}, //19
        {    1,     2,     6,     7,    11,    12, error, error, error, error}, //20
        {    1,     2,     6,     7,    11,    12,    16,    17,    22, error}, //21
        {    1,     2,     6,     7,    11,    12,    16,    17,    23, error}, //22
        {    1,     2,     6,     7,    11,    12,    16,    17, error, error}, //23
        {error, error, error, error, error, error, error, error, error, error}  //24
        };
        
        int estado = estadoInicial;
        int indice = 0;       
        while (estado != error && indice < cifra.length()) {
            estado = TABLA[estado][posicionSIMBOLO(cifra.charAt(indice))];
            indice++;
        }
        return (estado != 0 && estado != error);
    }
    
    public int posicionSIMBOLO(char caracter) {
        int indice=0;
        while ((caracter!=SIMBOLOS[indice])&&(indice<SIMBOLOS.length-1)) {
            indice++;
        }
        if (indice<SIMBOLOS.length-1) {
            return indice;
        }
        else {
            return SIMBOLOS.length-1;
        }
    }

}
