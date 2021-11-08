/*
FUNCIONALIDAD: declarada una array, devolver la array con las posiciones invertidas
OBJETIVO: comprender la lectura, escritura y operaciones de valores en un array
FECHA DE CREACIÓN: 04.11.2021
AUTOR:Jose Benito Santaner Castro
 */
package ejercicios_gamificacion_5_toni_frau;

public class CosaBorrar {

    int [] primos = new int [100];
    int primeNumber = 1;
    
    public static void main(String[] args) throws Exception{
        new CosaBorrar().metodoPrincipal();
    }
    
    public void metodoPrincipal(){
        
        
        for(int i=0; i<primos.length;)
        {
            primos[i] = primeNumber;
            primeNumber = nextPrime(primeNumber);
        }
        
        showPrimos();
    }
    
    public int nextPrime(int cosa){
        
        boolean divExactas = false;
        for (int posPrime = cosa+1; !divExactas ; posPrime++){
            
              /*conteo de si ha habido algún número por el que
            que haya sido posible dividir, imposibilitando que sea primo*/
            
            for (float i = posPrime-1; i>1; i--){
                if (posPrime%i != 0){
                    divExactas = true;
                }
            }
            
            if (divExactas == false) {
                
                cosa= posPrime;
                
            }
        }
        return cosa;
    }
    
    public void showPrimos(){
        
        for(int i=0; i<primos.length; i++){
            System.out.println(primos[i]);
        }
    }
}