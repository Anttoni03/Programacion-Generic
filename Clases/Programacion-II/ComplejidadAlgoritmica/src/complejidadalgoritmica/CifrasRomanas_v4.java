/*
PROGRAMA QUE LLEVA A CABO LA CONVERSIÓN A NÚMERACIÓN DECIMAL DE UNA CIFRA ROMANA
INTRODUCIDA POR TECLADO. TODO ELLO A TRAVÉS DE UN MENU GENERAL.
 */
package complejidadalgoritmica;


import java.io.IOException;

public class CifrasRomanas_v4 {
    public static void main(String[] args) {
        new CifrasRomanas_v4().metodoPrincipal();
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
        System.out.println("EL NÚMERO CORRESPONDIENTE A " +numRomano+
                " ES: \n\n                 " + conversion(numRomano));  
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
        for (;cifra.charAt(indice)!=' ';indice++) {
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

    private int valorDigito(char c) {
        final String SIMBOLOS = "IVXLCDMWY ";
        final int valores[] = {1, 5, 10, 50, 100, 500, 1000, 5000, 10000, 0};
        int indice = 0;
        while (c != SIMBOLOS.charAt(indice)) {
            indice++;
        }
        return valores[indice];
    }

}
