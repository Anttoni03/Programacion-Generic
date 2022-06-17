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
utilizar un mecanismo para traducir los valores. Para ello se puede utilizar un algoritmo 
que utilice dos tablas en lugar de una como ocurría con la clase anterior, la primera,
de nombre TIPOS, servirá para determinar la estructura de cada cifra, la segunda, 
de nombre SIMBOLOS, servirá para determinar qué símbolo se debe utilizar en cada ocasión, 
según la posición que ocupe al valor.

TABLA TIPOS:

    0       1      2      3      4      5       6      7        8      9   (dígito decimal)
   
{ESPACIO,"i "  ,"ii " ,"iii " ,"ij " ,"j "  ,"ji "  ,"jii "  ,"jiii ","ik "}

la estructura que conforma la tabla TIPOS viene del hecho de observar en detalle la tabla 
TROMANOS de la clase anterior: como podemos ver existe una cierta semejanza entre las columnas, 
por ejemplo, en la fila 6, los valores de cada columna son: 
                  6    {"VI "  , "LX "  , "DC "  , "WM "  ," "    }
y en la fila 8:
                  8    {"VIII ", "LXXX ", "DCCC ", "WMMM "," "    }

Podemos observar que en cada fila hay una misma estructura, lo que cambian son los símbolos
que se utilizan. 

TABLA SIMBOLOS:
                        1    2     3     4     5     6     7     8     9

          simbolo-->    I    V     X     L     C     D     M     W     Y 

      posorden --------->    1           2           3           4           5


Con esta tabla SIMBOLOS se puede ver que los elementos que se utilizan para representar una
cifra, según el orden en que ésta se encuentre dentro del valor tratado, son: 

                    I, V y X    para las  unidades, 
                    X, L y C    para las decenas, 
                    C, D y M    para las centenas, 
                    M, W y Y    para los miles. 

Por ello, en la tabla TIPOS:

    - cuando aparece el valor i, siempre hace referencia a los valores I, X, C, M; 
    - cuando aparece el valor j, siempre hace referencia a V, L, D o V; 
    - y cuando aparece k hace referencia a X, C, M o X. 

Por lo tanto se puede plantear un algoritmo como el siguiente para poder
convertir los valores:

public void tractar_xifra (int cifra, orden) {
  int indice = 1;
  String tmp="";
  int posorden = orden * 2;
  while (TIPOS[cifra][indice]!= ' ') {
         if (TIPOS[cifra][indice] == 'i') {
              tmp=tmp+SIMBOLOS[posorden-1];
         }
         else {
                    if (TIPOS[cifra][indice] == 'j') {
                             tmp=tmp+SIMBOLOS[posorden];
                    }
                    else {  // Es decir: TIPOS[cifra][indice] == 'k'
                             tmp=tmp+SIMBOLOS[posorden+1];
                    }
         }
         indide ++;
  }
}

*/


package complejidadalgoritmica;

public class NumeroRomano3 {

    private String numRomano;

    public NumeroRomano3(int numero) throws numeroNoRepresentable {
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
        final String TIPOS[] =
            {" ","0 ", "00 ", "000 ","01 ","1 ","10 ","100 ","1000 ","02 "};
        final char SIMBOLOS[] =
            {'I','V','X','L','C','D','M','W','Y'};
        
        int indice=0;
        String tmp="";
        int postOrden=orden*2;
        while (TIPOS[cifra].charAt(indice)!=' ') {
            if (TIPOS[cifra].charAt(indice)=='0') {
                tmp=tmp+SIMBOLOS[postOrden];
            }
            else {
                if (TIPOS[cifra].charAt(indice)=='1') {
                    tmp=tmp+SIMBOLOS[postOrden+1];
                }
                else {
                    tmp=tmp+SIMBOLOS[postOrden+2];
                }
            }
            indice++;
        }
        return tmp;
    }

    @Override
    public String toString() {
        return numRomano;
    }
    
    
}
