/*
4.	Realizar un programa que posibilite el recorrido del fichero clientes.dat 
visualizando en pantalla los objetos Cliente contenidos en él.
 */
package claseteoria__15_03_2022;

public class Problema4__10_03_2022 {
    //método main
    public static void main(String [] argumentos) {
        new Problema4__10_03_2022().metodoPrincipal();
    }
    
    //método metodoPrincipal
    private void metodoPrincipal() {
        //DECLARACIONES  
        //declaración objeto Cliente para almacenar, de uno en uno, los objetos
        //Cliente leídos desde el fichero
        Cliente cliente;
        //declaración objeto ClienteObjetoFicherosIn para posibilitar la
        //lectura de objetos Cliente desde el fichero 
        ClienteObjetoFicherosIn fichero;        
        
        //ACCIONES
        //instanciación objeto ClienteObjetoFicherosIn fichero para establecer
        //el enlace con el fichero físico clientes.dat a nivel de lectura
        //de objetos Cliente
        fichero=new ClienteObjetoFicherosIn("clientes.dat");  
        //bucle de RECORRIDO para llevar a cabo la lectura y visualización de
        //los objetos Cliente contenidos en el fichero
        for (cliente=fichero.lectura();!cliente.esCentinela();) {
            //visualización objeto PeliculaConCentinela leido
            System.out.println(cliente.toString());
            //lectura siguiente objeto PeliculaConCentinela
            cliente=fichero.lectura();
        }
        //cierre del enlace con el fichero
        fichero.cierre();
    }
}
