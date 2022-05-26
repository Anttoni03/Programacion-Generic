/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejerciciosmatrices;

/**
 *
 * @author tonif
 */
public class ResolucionSistema {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        new ResolucionSistema().metodoPrincipal();
    }
    
    private void metodoPrincipal()
    {
        System.out.println("Introducir la cantidad de filas/columnas de la "
                + "matriz A para resolver Ax = B seguido de la matriz:");
        System.out.print("Filas/columnas: ");
        int n = LT.readInt();
        MatrizNxM m = new MatrizNxM(n,n);
        System.out.println("\n\nIntroducir los elementos del vector B para "
                + "resolver Ax = B:");
        MatrizNxM v = new MatrizNxM(n,1);
        
        m.lectura();
        v.lectura();

        m.invertir();
        MatrizNxM resultado = MatrizNxM.producto(m, v);
        System.out.println(resultado.toString());
    }
}
