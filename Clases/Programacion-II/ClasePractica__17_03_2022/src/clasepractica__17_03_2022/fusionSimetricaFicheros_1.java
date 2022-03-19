/*
Dados ficheros clientes1.dat y clientes2.dat llevar a cabo la fusión simétrica de ambos
ficheros grabando el resultado de la misma en el fichero fusion_cliente1_clientes2.dat.
CRITERIO: orden ascendente en fucnión del atributo codigo.
NOTA: LOS DOS FICHEROS A FUSIONAR DEBEN ESTAR ORDENADOS EN ORDEN CRECIENTE EN FUNCI´N
DEL ATRIBUTO codigo.
 */
package clasepractica__17_03_2022;

public class fusionSimetricaFicheros_1 {
    //método main
    public static void main(String [] argumentos) {
        new fusionSimetricaFicheros_1().metodoPrincipal();
    }
    
    //método metodoPrincipal
    private void metodoPrincipal() {
        //DECLARACIONES  
        //declaración objetos ClienteObjetoFicherosIn para posibilitar la
        //lectura de objetos Cliente desde los dos ficheros objeto de la fusión
        //simétrica
        ClienteObjetoFicherosIn fichero1,fichero2; 
        //declaración objetos ClienteObjetoFicherosOut para posibilitar la
        //escritura de objetos Cliente en el fichero resultado de la fusión
        //simétrica
        ClienteObjetoFicherosOut fichero3; 
        //declaración objetos Cliente para almacenar los objetos Clientes leídos,
        //de uno en uno, desde los ficheros a fusionar
        Cliente cliente1,cliente2;
        
        //ACCIONES
        //instanciación objeto ClienteObjetoFicherosIn fichero1 para establecer
        //el enlace con el fichero físico clientes1.dat a nivel de lectura
        //de objetos Cliente
        fichero1=new ClienteObjetoFicherosIn("clientes1.dat");
        //instanciación objeto ClienteObjetoFicherosIn fichero2 para establecer
        //el enlace con el fichero físico clientes2.dat a nivel de lectura
        //de objetos Cliente
        fichero2=new ClienteObjetoFicherosIn("clientes2.dat");
        //instanciación objeto ClienteObjetoFicherosOut fichero3 para establecer
        //el enlace con el fichero físico fusion_clientes1_clientes2.dat a nivel de escritura
        //de objetos Cliente
        fichero3=new ClienteObjetoFicherosOut("fusion_clientes1_clientes2.dat");
        //lectura del primer objeto Cliente contenido en cada uno de los dos
        //ficheros a fusionar
        cliente1=fichero1.lectura();
        cliente2=fichero2.lectura();
        //BUCLE TRATAMIENTO FUSIÓN SIMÉTRICA
        while ((!cliente1.esCentinela())||(!cliente2.esCentinela())) {
            //verificar de los dos objetos Cliente leídos cuál es el
            //que tiene el atributo código menor
            if (cliente1.getCodigo() < cliente2.getCodigo()) {
                //el objeto cliente1 es el que tiene el atributo menor y por
                //lo tanto es el que se graba en el fichero de salida
                fichero3.escritura(cliente1);
                //lectura siguiente objeto Cliente desde el fichero1
                cliente1=fichero1.lectura();
            } else {
                //el objeto cliente2 es el que tiene el atributo menor y por
                //lo tanto es el que se graba en el fichero de salida
                fichero3.escritura(cliente2);
                //lectura siguiente objeto Cliente desde el fichero2
                cliente2=fichero2.lectura();
            }
        }
        //grabación del objeto Cliente CENTINELA en el fichero fusion_clientes1_clientes2.dat
        fichero3.escritura(Cliente.getCentinela());
        //cierre de enlaces de ficheros
        fichero1.cierre();
        fichero2.cierre();
        fichero3.cierre();
    }
}
