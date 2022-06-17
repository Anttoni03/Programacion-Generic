

package complejidadalgoritmica;

import java.io.IOException;

public class CifrasRomanas_v1 {
    public static void main(String[] args) {
        new CifrasRomanas_v1().metodoPrincipal();
    }
           
    public void metodoPrincipal() {
        boolean fin=false;
        while (!fin) {
            visualizacionMenu();
            int opcion=LT.readInt();
            switch (opcion) {
                case 1: conversion();break;
                default: fin=true;
            }
        }
    }
    
    private void visualizacionMenu() {
        System.out.print("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n"
                + "PROGRAMA DE CONVERSIÓN NÚMEROS ENTEROS A NÚMEROS ROMANOS\n\n\n");  
        System.out.print("         1. conversion.\n");
        System.out.print("         2. fin.\n\n\n");
        System.out.print("[] opcion: ");
    }

    private void conversion()  {
        System.out.print("\n\nNÚMERO A CONVERTIR (max: 39999): ");
        int numero=LT.readInt();
        try {          
            System.out.println("EL NÚMERO ROMANO CORRESPONDIENTE A " +numero+
                " ES: \n\n                 " + new NumeroRomano1(numero).toString());
        }catch (numeroNoRepresentable e) {
            System.err.println("ERROR: " + e.getMessage());
            }
         finally {
            System.out.print("\n\n< CONTINUAR --> RETURN > ");
            try {
                char car=(char) System.in.read();
            }catch (IOException error) {}
        }
    }

}
