/*
LOS DÍGITOS ROMANOS Y SUS VALORES EN EL SISTEMA DECIMAL QUE VAMOS A UTILIZAR SON 
LOS SIGUIENTES:

        I 1
        V 5
        X 10
        L 50
        C 100
        D 500
        M 1000
        W 5000
        Y 10000

nota: W e Y no pertenecen a la codificación romana real.

CON ESTOS DÍGITOS ROMANOS, EL NÚMERO MAYOR QUE SE PUEDE REPRESENTAR ES 39.999, ES 
DECIR, YYYMYCMXCIX.

Los valores de las cifras arábigas deben traducirse teniendo en cuenta que la posición de
cada valor puede hacer cambiar su representación en números romanos. Por lo tanto el algoritmo
que haga la conversión deberá tratar las cifras una a una, y deberá hacerlo según
corresponda a su posición. El siguiente algoritmo se encarga de tratar cada una de
las cifras arábigas que componen un cierto valor que se le suministra:

{
 int orden = 5;
 int divisor = 10000;
 int numero;
 lectura(numero);
 Mientras (orden ≥ 1) {
    cifra = numero/divisor;
    numero = numero mod divisor;
    tratarCifra(cifra, orden);
    orden = orden–1;
    divisor = divisor/10;
 }
} 
 

Disponemos de un mecanismo para obtener cada una de las cifras sabiendo en qué lugar 
se encuentran. Para escribir un valor en cifras romanas será preciso
utilizar un mecanismo para traducir los valores. Para ello se puede utilizar una tabla,
que denominaremos TROMANOS, donde indicará la correspondencia para cada cifra posible 
y para cada posición de la cifra dentro del valor tratado:

                1         2        3        4       5     (orden)
        0    {" "    , " "    , " "    , " "    ," "    }
        1    {"I "   , "X "   , "C "   , "M "   ,"Y "   }
        2    {"II "  , "XX "  , "CC "  , "MM "  ,"YY "  }
        3    {"III " , "XXX " , "CCC " , "MMM " ,"YYY " }
        4    {"IV "  , "XL "  , "CD "  , "MW "  ," "    }
        5    {"V "   , "L "   , "D "   , "W "   ," "    }
        6    {"VI "  , "LX "  , "DC "  , "WM "  ," "    }
        7    {"VII " , "LXX " , "DCC " , "WMM " ," "    }
        8    {"VIII ", "LXXX ", "DCCC ", "WMMM "," "    }
        9    {"IX "  , "XC "  , "CM "  , "MY "  ," "    }
 
(dígito decimal)






*/


package complejidadalgoritmica;

public class NumeroRomano1 {

    private String numRomano;

    public NumeroRomano1(int numero) throws numeroNoRepresentable {
        numRomano = "";
        if (numero < 0 || numero > 39999) {     
            throw new numeroNoRepresentable("Número no representable en"
                        + " numeración romana");  
        }
            
        conversion(numero);   
    }
    
    private void conversion(int numero) {
            int orden = 4;
            int divisor = 10000;
            while (orden >= 0) {
                int cifra = numero / divisor;
                numero = numero % divisor;
                numRomano += digitosRomanos(cifra, orden);
                orden--;
                divisor /= 10;
            }        
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

    @Override
    public String toString() {
        return numRomano;
    }
    
    
}
