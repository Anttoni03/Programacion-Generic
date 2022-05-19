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
        Vector v = new Vector(4);
        v.ponerElemento(0, (double)((int)'a'));
        v.ponerElemento(1, (double)((int)'b'));
        v.ponerElemento(2, (double)((int)'c'));
        v.ponerElemento(3, (double)((int)'d'));
        
        v.combinatorios();
    }
}
