/*
EJEMPLO DE UTILIZACIÓN DE LA CLASE Pila GENERICA CON CIFRAS ROMANAS A TRAVÉS
DE UN MENU.
 */
package clases_genericas_ii;

import java.io.*;

public class EjemploPilaCifrasRomana {

    public static void main(String[] args) {
        new EjemploPilaCifrasRomana().metodoPrincipal();
    }
    
    public void metodoPrincipal() {
        Pila<CifraRomana> pilaCifrasRomanas = new Pila<CifraRomana>(5);
        CifraRomana cifra,cifraUmbral;
        int valor;
        boolean salir = false;
        int opcio = 0;
        while (!salir) {
            menu();
            System.out.print("\nINTRODUCIR OPCIÓN: ");
            opcio = LT.readInt();
            switch (opcio) {
                case 1: System.out.print("INTRODUCIR EL VALOR DECIMAL DE LA CIFRA A INTRODUCIR: ");
                        valor = LT.readInt();
                        cifra = new CifraRomana(valor);
                        pilaCifrasRomanas.introducir(cifra);
                        break;
                case 2: System.out.print("INTRODUCIR UMBRAL: ");
                        cifraUmbral=new CifraRomana(LT.readInt());
                        while (!pilaCifrasRomanas.estaVacia()) {
                            cifra=pilaCifrasRomanas.extraer();
                            if (cifra.menorQue(cifraUmbral)) {
                                System.out.println(cifra.toString());
                            }   
                        }
                        System.out.println("PILA VACIA");
                        break;
                case 3: System.out.print("INTRODUCIR UMBRAL: ");
                        cifraUmbral=new CifraRomana(LT.readInt());
                        while (!pilaCifrasRomanas.estaVacia()) {
                            cifra=pilaCifrasRomanas.extraer();
                            if (!cifra.menorQue(cifraUmbral)) {
                                System.out.println(cifra.toString());
                            }   
                        }
                        System.out.println("PILA VACIA");
                        break;
                case 4: System.out.print("INTRODUCIR UMBRAL: ");
                        cifraUmbral=new CifraRomana(LT.readInt());
                        while (!pilaCifrasRomanas.estaVacia()) {
                            //extracción cifra de la pila
                            cifra=pilaCifrasRomanas.extraer();
                            if (cifra.compara(cifraUmbral)==-1) {
                                System.out.println("LA CIFRA ROMANA "+cifra.toString()+" ES MENOR AL UMBRAL");
                            } 
                            else if (cifra.compara(cifraUmbral)==0) {
                                System.out.println("LA CIFRA ROMANA "+cifra.toString()+" ES IGUAL QUE EL UMBRAL");
                            }
                            else {
                                System.out.println("LA CIFRA ROMANA "+cifra.toString()+" ES MAYOR QUE EL UMBRAL");
                            }
                        }
                        System.out.println("PILA VACIA");
                        break;
                case 5: while (!pilaCifrasRomanas.estaVacia()) {
                            cifra=pilaCifrasRomanas.extraer();
                            System.out.println(cifra.toString());
                        }
                        System.out.println("PILA VACIA");
                        break;
                case 0:
                    salir = true;
                    break;
            }   
        }
    }

    private static void menu() {
        System.out.println("\n\nPILA DE CIFRAS ROMANAS");
        System.out.println("\n\t1. INTRODUCIR UNA CIFRA EN LA PILA");
        System.out.println("\t2. VISUALIZACIÓN CIFRAS INFERIORES A UN UMBRAL");
        System.out.println("\t3. VISUALIZACIÓN CIFRAS SUPERIORES A UN UMBRAL");
        System.out.println("\t4. VISUALIZACIÓN COMPARATIVA CIFRAS CON UN UMBRAL");
        System.out.println("\t5. VISUALIZACIÓN DE TODAS LAS CIFRAS CONTENIDAS EN LA PILA");
        System.out.println("\t0. SALIR");
    }

}
