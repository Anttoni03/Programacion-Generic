/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package problemasmatriciales;

/**
 *
 * @author tonif
 */
public class PermutacionesVectores {
    public static void main(String[] args)
    {
        new PermutacionesVectores().metodoPrincipal();
    }
    
    private void metodoPrincipal()
    {
        char[] let = "abcdefghijklmnopqrstuvwxyz".toCharArray();
        int n = 4;
        Vector v = new Vector(n);
        for (int i = 0; i < n; i++)
            v.ponerElemento(i, (double)((int)let[i]));
        
        v.combinatorios();
    }
}
