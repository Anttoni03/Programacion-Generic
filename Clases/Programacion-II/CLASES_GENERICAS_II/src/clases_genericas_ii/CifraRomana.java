/*
CLASE CifraRomana

*/

package clases_genericas_ii;

public class CifraRomana implements Comparador{
    private static final char [] SIMBOLOS = "IVXLCDMWY ".toCharArray();
    private String numRomano;
    private int valor;

    public CifraRomana() {}
    
    public CifraRomana(int numero)  {
        try {
            if (numero < 0 || numero > 39999) {     
                throw new numeroNoRepresentable("Número no representable en"
                            + " numeración romana");  
            }
            else {
                numRomano=decimalToRomano(numero);
                valor=numero;
            }            
        }catch (numeroNoRepresentable error) {
            System.out.println("ERROR: "+error.toString());
        }
    }
    
    public CifraRomana(String cifra)  {
        try {
            if (cifraCorrecta(cifra)) {
                numRomano=cifra;
                valor=romanoToDecimal(cifra);
            }
            else {
                throw new cifraRomanaIncorrecta("cifra romana incorrecta");
            }            
        }catch (cifraRomanaIncorrecta error) {
            System.out.println("ERROR: "+error.toString());
        }

    }

    @Override
    public String toString() {
        return numRomano;
    }

    private String decimalToRomano(int numero) {
        String tmp="";        
        int orden = 4;
        int divisor = 10000;
        while (orden >= 0) {
            int cifra = numero / divisor;
            numero = numero % divisor;
            tmp += digitosRomanos(cifra, orden);
            orden--;
            divisor /= 10;
        }  
        return tmp;
    }

    private String digitosRomanos(int cifra, int orden) {
        final String TROMANOS[][] = new String[][]{
            {" "    , " "    , " "    , " "    ," "    },
            {"I "   , "X "   , "C "   , "M "   ,"Y "   },
            {"II "  , "XX "  , "CC "  , "MM "  ,"YY "  },
            {"III " , "XXX " , "CCC " , "MMM " ,"YYY " },
            {"IV "  , "XL "  , "CD "  , "MW "  ," "    },
            {"V "   , "L "   , "D "   , "W "   ," "    },
            {"VI "  , "LX "  , "DC "  , "WM "  ," "    },
            {"VII " , "LXX " , "DCC " , "WMM " ," "    },
            {"VIII ", "LXXX ", "DCCC ", "WMMM "," "    },
            {"IX "  , "XC "  , "CM "  , "MY "  ," "    }
        };
        String tmp = "";
        int indice = 0;
        while (TROMANOS[cifra][orden].charAt(indice) != ' ') {
            tmp += TROMANOS[cifra][orden].charAt(indice);
            indice++;
        }
        return tmp;
    }

    private int romanoToDecimal(String cifra) {
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
    
    private int posicionSIMBOLO(char caracter) {
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
    
    //MÉTODO QUE RETORNA
    //  -1 SI LA CifraRomana ES MENOR QUE LA DADA POR PARÁMETRO
    //  0 SI LA CifraRomana ES IGUAL QUE LA DADA POR PARÁMETRO
    //  1 SI LA CifraRomana ES MAYOR QUE LA DADA POR PARÁMETRO
    @Override
    public int compara(Comparador cifraRomanaB) {
        if (valor < ((CifraRomana) cifraRomanaB).valor) {
            return -1;
        } else if (valor == ((CifraRomana) cifraRomanaB).valor) {
            return 0;
        } else {
            return 1;
        }        
    }

    //MÉTODO QUE DEVUELVE true SI LA CifraRomana ES MENOR QUE LA DADA POR
    //PARÁMETRO
    @Override
    public boolean menorQue(Comparador cifraRomanaB) {
        return valor < ((CifraRomana) cifraRomanaB).valor;
    }
}
