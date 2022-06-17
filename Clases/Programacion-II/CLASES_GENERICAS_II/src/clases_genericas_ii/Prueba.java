/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clases_genericas_ii;

/**
 *
 * @author tonif
 */
public class Prueba{
    public static void main(String[] args) {
        new Prueba().p();
    }
    
    private void p(){
        Pru<char> hola = new Pru<char>();
    }
    
    private class Pru<T> {

        public Pru(){ System.out.println("Hola"); }
    }
}
