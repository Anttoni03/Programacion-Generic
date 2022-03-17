

public class RecorridoFicheroClientes {
    
    private ClienteObjetoFicherosIn fichero;
    
    public static void main(String[] args)
    {
        new RecorridoFicheroClientes().metodoPrincipal();
    }
    
    private void metodoPrincipal()
    {
        fichero = new ClienteObjetoFicherosIn("clientes.dat");
        

        for (Cliente cliente = fichero.lectura(); !cliente.esCentinela();)
        {
            System.out.println(cliente.toString());
            System.out.println("");
            cliente = fichero.lectura();
        }
        
        fichero.cerrarEnlace();
    }
}
