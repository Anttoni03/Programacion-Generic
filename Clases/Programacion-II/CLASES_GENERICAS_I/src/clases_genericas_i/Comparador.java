/*
 CLASE INTERFACE PARA COMPARAR DOS OBJETOS CON LOS MÉTODOS compara y menorQue

    MÉTODO compara --> DEVUELVE

            -1 SI EL OBJETO ES MENOR QUE EL DADO POR PARÁMETRO
            0 SI EL OBJETO ES IGUAL QUE EL DADO POR PARÁMETRO
            1 SI EL OBJETO ES MAYOR QUE EL DADO POR PARÁMETRO

    MÉTODO menorQue --> DEVUELVE true SI EL OBJETO ES MENOR QUE EL DADO POR 
    PARÁMETRO
 */
package clases_genericas_i;

public interface Comparador {

    public int compara(Comparador objeto);

    public boolean menorQue(Comparador objeto);
}
