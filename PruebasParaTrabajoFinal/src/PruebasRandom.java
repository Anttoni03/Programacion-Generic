
import java.util.Random;

/**
 *
 * @author tonif
 */
public class PruebasRandom {
    //método main
    public static void main(String [] argumentos) throws Exception {
        new PruebasRandom().metodoPrincipal();
    }
    
    //método metodoPrincipal
    private void metodoPrincipal()
    {
        Random rand = new Random();
        
        System.out.println(rand.nextInt(10));
    }
}
