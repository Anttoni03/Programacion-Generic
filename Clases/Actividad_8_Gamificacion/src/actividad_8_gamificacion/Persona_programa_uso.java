/*
ACTIVIDAD 8 - GAMIFICACIÓN
Implementar un programa que lleve a término los siguientes puntos:
    1. Declaración de un array de 5 componentes de objetos Persona.
    2. Instanciación, con el constructor sin parámetros, de los objetos 
    Persona contenidos en el array anteriormente declarado.
    3. Lectura, por teclado, de los 4 primeros objetos Persona, 
    contenidos en el array.
    4. Visualización de los 4 primeros objetos Persona contenidos en 
    el array.
    5. Copiar el primer objeto Persona en la quinta componente del array.
    6. Visualización de todos los objetos Persona contenidos en el array.
    7. Los primeros 4 objetos Persona del array reciben un cobro del 
    salario mínimo.
    8. El último objeto del array cumple un año más.
    9. Visualización de todos los objetos Persona.
 */
package actividad_8_gamificacion;

public class Persona_programa_uso {
    //método main
    public static void main(String [] argumentos) throws Exception {
        new Persona_programa_uso().metodoPrincipal();
    }
    
    //método metodoPrincipal
    private void metodoPrincipal() {
        //DECLARACIONES
////////1. Declaración de un array de 5 componentes de objetos Persona.
        Persona [] personas=new Persona[5];
        
        //ACCIONES
//////////2. Instanciación, con el constructor sin parámetros, de los objetos 
        //Persona contenidos en el array anteriormente declarado.
        for (int indice=0;indice<personas.length;indice++) {
            //instanciación objeto Persona contenido en la componente
            //indice-ésima del array personas
            personas[indice]=new Persona();
        }
        
//////////3. Lectura, por teclado, de los 4 primeros objetos Persona, 
        //contenidos en el array.
        for (int indice=0;indice<4;indice++) {
            //lectura del objeto Persona contenido en la componente
            //índice-ésima del array personas
            personas[indice].lectura();
        }
        
//////////4. Visualización de los 4 primeros objetos Persona contenidos en 
        //el array.
        for (int indice=0;indice<4;indice++) {
            //visualización del objeto Persona contenido en la componente
            //índice-ésima del array personas
            System.out.println(personas[indice].toString());
        } 
        
//////////5. Copiar el primer objeto Persona en la quinta componente 
        //del array.
        personas[5-1]=personas[0].copia();
        
//////////6. Visualización de todos los objetos Persona contenidos 
        //en el array.
        for (int indice=0;indice<personas.length;indice++) {
            //visualización del objeto Persona contenido en la componente
            //índice-ésima del array personas
            System.out.println(personas[indice].toString());
        } 
        
//////////7. Los primeros 4 objetos Persona del array reciben un cobro 
        //del salario mínimo.
        for (int indice=0;indice<4;indice++) {
            //cobro salario mínimo para el objeto Persona contenido en la componente
            //índice-ésima del array personas
            personas[indice].cobro();
        }  
        
//////////8. El último objeto del array cumple un año más.
        personas[personas.length-1].cumpleaños();
        
//////////9. Visualización de todos los objetos Persona.
        for (int indice=0;indice<personas.length;indice++) {
            //visualización del objeto Persona contenido en la componente
            //índice-ésima del array personas
            System.out.println(personas[indice].toString());
        }         
    }
    
}
