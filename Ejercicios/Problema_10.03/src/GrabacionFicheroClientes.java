import java.io.File;

public class GrabacionFicheroClientes {
    
    public static void main(String[] args)
    {
        new GrabacionFicheroClientes().metodoPrincipal();
    }
    
    private void metodoPrincipal()
    {
        Cliente cliente;
        ClienteObjetoFicherosOut ficheroEscritura;
        ClienteObjetoFicherosOut ficheroEscritura2;
        int cantidadClientes = 0;
        
        ficheroEscritura = new ClienteObjetoFicherosOut("clientes.dat");
        
        for (boolean fin = false; !fin;)
        {
            cliente = new Cliente();
            cliente.lectura();
                        
            ficheroEscritura.escritura(cliente);
            cantidadClientes++;
            
            System.out.print("Continuar? (SI - S / NO - N): ");
            fin = LT.readChar() == 'N';
        }
        ficheroEscritura.cerrarEnlace();
        
        
        ficheroEscritura2 = new ClienteObjetoFicherosOut("temp.dat");        
        
        int menorCodigo = obtenerMenorCodigo(0);
        cliente = new Cliente();
        cliente = obtenerClientePorCodigo(menorCodigo);
        for (int i = 0; i < cantidadClientes; i++) {            
            if (!cliente.esCentinela())
            {
                ficheroEscritura2.escritura(cliente);
            }
            menorCodigo = obtenerMenorCodigo(menorCodigo);
            cliente = obtenerClientePorCodigo(menorCodigo);
        }
        
        ficheroEscritura2.cerrarEnlace();
        
        File ficheroOriginal = new File("clientes.dat");
        File ficheroTemporal = new File("temp.dat");
        LT.skipLine();
        ficheroOriginal.delete();
        ficheroTemporal.renameTo(ficheroOriginal);
    }
    
    
    private int obtenerMenorCodigo(int minimo)
    {
        ClienteObjetoFicherosIn fichero = new ClienteObjetoFicherosIn("clientes.dat");
        Cliente cliente = fichero.lectura();
        int aux = Integer.MAX_VALUE;
        
        while (!cliente.esCentinela()) {
            if (cliente.getCodigo() < aux && minimo < cliente.getCodigo())
                aux = cliente.getCodigo();
            
            cliente = fichero.lectura();
        }
        fichero.cerrarEnlace();
        
        return (aux == Integer.MAX_VALUE)? -1 : aux;
    }
    
    private Cliente obtenerClientePorCodigo(int codigo)
    {
        ClienteObjetoFicherosIn fichero = new ClienteObjetoFicherosIn("clientes.dat");
        Cliente cliente = new Cliente();
        
        cliente = fichero.lectura();
        while (cliente.getCodigo() != codigo)
        {
            cliente = new Cliente();
            cliente = fichero.lectura();                
        }
        
        fichero.cerrarEnlace();
        return cliente;
    }
}