/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejercicios_gamificacion_8_toni_frau;

public class Persona_uso {
    public static void main(String[] args) throws Exception
    {
        new Persona_uso().metodoPrincipal();
    }
    
    private void metodoPrincipal()
    {
        //1. Declaración de un array de 5 componentes Persona
        Persona[] personas = new Persona[5];
        
        //2. Instanciación de los componentes del array sin parámetros
        for (int i = 0; i < personas.length; i++)
            personas[i] = new Persona();
        
        //3. Lectura de las 4 primeras personas del array
        for (int i = 0; i < personas.length - 1; i++)
            personas[i].lectura();
        
        //4. Visualización de las 4 primeras personas del array
        for (int i = 0; i < personas.length - 1; i++)
            System.out.println(personas[i].toString());
        
        //5. Copiar la primera persona en la última del array
        personas[personas.length - 1] = personas[0].copia();
        
        //6. Visualización de todas las personas del array
        for (int i = 0; i < personas.length; i++)
            System.out.println(personas[i].toString());
        
        //7. Recibimiento del cobro mínimo a las 4 primeras personas del array
        for (int i = 0; i < personas.length - 1; i++)
            personas[i].cobro();
        
        //8. La última persona del array cumple años
        personas[personas.length - 1].cumpleanos();
        
        //9. Visualización de todas las personas del array
        for (int i = 0; i < personas.length; i++)
            System.out.println(personas[i].toString());
    }
}
