

public class GrabacionObjetosPelicula {
    //DECLARACIONES
    //declaración métdo main
    public static void main(String [] argumentos)  {
        new GrabacionObjetosPelicula().metodoPrincipal();
    }
    
    //declaración metodoPrincipal
    public void metodoPrincipal() {
        //DECLARACIONES
        //declaración objeto AdicionObjectOutputStream
        PeliculaObjetoFicherosOut fichero;
        //declaración variable booleana para controlar el fin del programa
        boolean fin=false;
        
        //ACCIONES
        //establecimiento enlace con fichero instanciación objeto AdicionObjectOutputStream
        fichero=new  PeliculaObjetoFicherosOut("peliculas.dat");
        while (!fin) {
            Pelicula pelicula = new Pelicula();

            //bucle de lectura desde el teclado y escritura en fichero a nivel
            //de objetos Palabra
            //lectura entero desde el teclado
            pelicula.lectura();
            //visualización palabra leida
            System.out.println("HAS INTRODUCIDO UNA PELÍCULA DEL TIPO: "+pelicula.toString());
            //escritura entero leida en el fichero a nivel de objeto Integer
            fichero.escritura(pelicula);             
            //mensaje para continuar
            System.out.print("CONTINUAR (s/n): ");
            //lectura respuesta
            char respuesta;
            respuesta=LT.readChar();
            if ((respuesta!='s')&&(respuesta!='S')) {
                fin=true;
            }       
        }                       
        //cierre del enlace fichero
        fichero.cierre();
    }
}
