/*
FUNCIONALIDAD:
1. declaración objeto Quiniela sin inicialización.
2. Acción de asignación de los resultados definitivos de la quiniela.
3. Asignación del número de apuestas en función de los aciertos.
4. Asignar total recaudacion
5. Realización apuesta del objeto Quiniela definido
6. Obtención y visualizar el número de aciertos del objeto Quiniela declarado.
7. Visualización premio obtenido por el objeto Quiniela declarado.
 */
package clasepractica_16_11_2021;

public class Quiniela_uso_1 {
    //método main
    public static void main(String [] argumentos) throws Exception {
        new Quiniela_uso_1().metodoPrincipal();
    }
    
    //método metodoPrincipal
    private void metodoPrincipal() {
        //DECLARACIONES
        //1. declaración objeto Quiniela sin inicialización.
        Quiniela apuesta1=new Quiniela();
        
        //ACCIONES
        //2. Acción de asignación de los resultados definitivos de la quiniela.
        Quiniela.asignacionResultados();
        //3. Asignación del número de apuestas en función de los aciertos.
        Quiniela.getApuestasAciertos();
        //4. asignación total recaudacion
        Quiniela.setTotalRecaudacion(12000000.00);
        //5. Realización apuesta del objeto Quiniela definido
        apuesta1.apuestaQuiniela();
        //6. Obtención y visualizar el número de aciertos del objeto Quiniela declarado.
        System.out.println("\nEL NÚMERO DE ACIERTOS DE LA QUINIELA \n"+
                apuesta1.toString()+"\nES: "+apuesta1.obtenerNumeroAciertos());
        //7. Visualizar el premio que le corresponde
        System.out.println("\nEL PREMIO QUE LE CORRESPONDE ES: "+apuesta1.obtenerPremio());
    }
    
}
