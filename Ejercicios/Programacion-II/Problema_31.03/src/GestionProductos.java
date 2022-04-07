
import java.io.*;

public class GestionProductos {
    
    private final int cantidadDistritos = 100;
    FicheroProductoDistritoIn ficheroDistritoLectura;
    FicheroProductoDistritoOut ficheroDistritoEscritura;
    FicheroProductosInOut ficheroProductos;
    int opcion;
    
    public static void main(String[] args)
    {
        new GestionProductos().metodoPrincipal();
    }
    
    private void metodoPrincipal()
    {
        opcion = 1;
        boolean fin = false;
        
        while (!fin){
            menu();
            switch (opcion){
                case 1:
                    escrituraProductosDistrito();
                    break;
                case 2:
                    escrituraProductos();
                    break;
                case 3:
                    actualizarProductos();
                    break;
                case 4:
                    listadoProductos();
                    break;
                case 5:
                    listadoProductosDistrito();
                    break;
                case 6:
                    fin = true;
                    break;
            }
        }
        salir();
    }
    
    private void escrituraProductosDistrito()
    {
        int distrito;
        
        titulo("ESCRITURA DE PRODUCTOS DE UN DISTRITO");
        try{
            do
            {
                System.out.print("SELECCIONA EL DISTRITO A ESCRIBIR(-1 para crear los ficheros faltantes): ");
                distrito = LT.readInt();
                //mirar si el fichero existe  ==============
                File f = new File("distrito"+distrito+"_productos.dat");
                if (f.length() > FicheroProductoDistritoOut.bytesCentinela() && f.exists()){
                    System.out.print("HAY ELEMENTOS EN ESTE FICHERO. SI CONTINÚA SE BORRARÁN. CONTINUAR?('s'/'n'): ");
                    if (LT.readChar() == 'n')
                    {
                        distrito = 0;
                    }
                }
                //=========================================
            } while ((distrito < -1 || 100 < distrito) || distrito == 0);
        } catch(Exception e){
            System.err.println("ERROR: " + e.toString());
            distrito = 1;
        }
        
        if (distrito == -1)
        {
            creacionDistritos();
            espaciar(1);
            System.out.println("SE HAN CREADO LOS FICHEROS FALTANTES");
            espaciar(1);
            continuar();
            return;
        }
        ficheroDistritoEscritura = new FicheroProductoDistritoOut("distrito"+distrito+"_productos.dat");
        
        
        for (boolean fin = false;!fin;){
            espaciar(2);
            System.out.println("INTRODUCE UN PRODUCTO (CÓDIGO Y VENTAS)");
            ProductoDistrito producto = new ProductoDistrito();
            producto.lectura();
            ficheroDistritoEscritura.escritura(producto);
            espaciar(2);
            System.out.print("SEGUIR INTRODUCIENDO PRODUCTOS?('s'/'n'): ");
            fin = LT.readChar() == 'n';
        }
        ficheroDistritoEscritura.escritura(ProductoDistrito.getCentinela());
        ficheroDistritoEscritura.cierre();        
    }
    
    private void escrituraProductos()
    {
        ficheroProductos = new FicheroProductosInOut("productos.dat");
        
        titulo("ESCRITURA DE PRODUCTOS");
        for (boolean fin = false; !fin;)
        {
            espaciar(2);
            System.out.println("INTRODUCCIÓN DE UN PRODUCTO");
            Producto producto = new Producto();
            producto.lectura(ficheroProductos.getNuevoCodigo());
            ficheroProductos.escritura(producto);
            espaciar(1);
            System.out.print("SEGUIR INTRODUCIENDO PRODUCTOS?('s'/'n'): ");
            fin = LT.readChar() == 'n';
        }
        ficheroProductos.cierre();
    }
    
    private void actualizarProductos()
    {
        titulo("ACTUALIZACIÓN DE PRODUCTOS");
                
        File f = new File("productos.dat");
        if (!f.exists())
        {
            System.out.println("NO HAY PRODUCTOS QUE ACTUALIZAR");
            espaciar(1);
            continuar();
            return;
        }
        ficheroProductos = new FicheroProductosInOut("productos.dat");
        if (creacionDistritos())
        {
            System.out.println("TODAVÍA NO HABÍAN 100 FCIHEROS DE PRODUCTOS DE "
                    + "DISTRITOS. SE HAN AÑADIDO LOS FALTANTES.");
            espaciar(1);
        }
        else
        {
            for (int i = 1; i < cantidadDistritos+1; i++)
            {
                ficheroDistritoLectura = new FicheroProductoDistritoIn("distrito"+i+"_productos.dat");

                ProductoDistrito productoDis = ficheroDistritoLectura.lectura();
                while (!productoDis.esCentinela())
                {
                    int codigo = productoDis.getCodigo();
                    Producto producto = ficheroProductos.lectura(codigo);
                    producto.setVentas(producto.getVentas() + productoDis.getVentas());
                    ficheroProductos.escritura(producto,codigo);
                    productoDis = ficheroDistritoLectura.lectura();
                }
                ficheroDistritoLectura.cierre();
            }
            System.out.println("LOS PRODUCTOS SE HAN ACTUALIZADO");
            espaciar(1);
        }
        ficheroProductos.cierre();
        
        continuar();
    }
    
    private void listadoProductos()
    {
        Producto producto;
        
        titulo("LISTADO DE PRODUCTOS");
        try{
            File f = new File("productos.dat");
            if (f.length() == 0 || !f.exists())
            {
                System.out.println("NO HAY PRODUCTOS");
                espaciar(1);
            }
            else{
                ficheroProductos = new FicheroProductosInOut("productos.dat");
                producto = ficheroProductos.lectura();
                while (producto != null && producto.getCodigo() != 0)
                {
                    System.out.println(producto.toString());
                    producto = ficheroProductos.lectura();
                    espaciar(1);
                }
                ficheroProductos.cierre();
            }
        } catch(Exception e){
            System.err.println("ERROR: "+e.toString());
        }
        continuar();
    }
    
    private void listadoProductosDistrito()
    {
        int distrito;
        ProductoDistrito producto = new ProductoDistrito();
        
        titulo("LISTA DE PRODUCTOS DE UN DISTRITO");
        try{
            do
            {
                System.out.print("SELECCIONA EL DISTRITO A LEER: ");
                distrito = LT.readInt();
            } while (distrito < -1 || 100 < distrito || distrito == 0);

            espaciar(1);
            if (distrito != -1)
            {
                File f = new File("distrito"+distrito+"_productos.dat");
                if (f.length() <= FicheroProductoDistritoOut.bytesCentinela() || !f.exists())
                {
                    System.out.println("NO HAY PRODUCTOS");
                    espaciar(1);
                    continuar();
                    return;
                }
                else
                {
                    ficheroDistritoLectura = new FicheroProductoDistritoIn("distrito"+distrito+"_productos.dat");
                    producto = ficheroDistritoLectura.lectura();
                    while (!producto.esCentinela())
                    {
                        System.out.println(producto.toString());
                        producto = ficheroDistritoLectura.lectura();
                        espaciar(1);
                    }
                    ficheroDistritoLectura.cierre();
                }
            }
            else
            {
                for (int i = 1; i <= cantidadDistritos; i++)
                {
                    File f = new File("distrito"+i+"_productos.dat");
                    System.out.println("DISTRITO "+i);
                    if (f.length() <= FicheroProductoDistritoOut.bytesCentinela() || !f.exists())
                    {
                        espaciar(1);
                        continue;
                    }
                    ficheroDistritoLectura = new FicheroProductoDistritoIn("distrito"+i+"_productos.dat");
                    producto = ficheroDistritoLectura.lectura();
                    while (!producto.esCentinela())
                    {
                        System.out.println(producto.toString());
                        producto = ficheroDistritoLectura.lectura();
                        espaciar(1);
                    }
                    ficheroDistritoLectura.cierre();
                }
            }
        } catch(Exception e){
            System.err.println("ERROR: "+e.toString());
        }
        continuar();
    }
    
    private void salir()
    {
        titulo("SALIDA");
        System.out.println("Adiosss!!");
    }
    
    private void menu()
    {
        titulo("MENÚ PRINCIPAL");
        System.out.print("SELECCIONA UNA ACCIÓN:"
                + "\n[1] Escritura sobre los productos de un distrito"
                + "\n[2] Escritura sobre productos"
                + "\n[3] Actualizar productos con distritos"
                + "\n[4] Mostar listado de productos"
                + "\n[5] Mostrar listado de productos de un distrito"
                + "\n[6] Salir"
                + "\n\t---> ");
        try{
            opcion = LT.readInt();
        } catch(Exception e){
            System.err.println("ACCIÓN NO VÁLIDA");
            opcion = 5;
        }
    }
    
    private void continuar()
    {
        System.out.print("<> PULSA INTRO PARA CONTINUAR ·");
        LT.readChar();
    }
    
    private void espaciar(int i)
    {
        for (int j = 0; j < i; j++) {
            System.out.println("");
        }
    }
    
    private void titulo(String texto)
    {
        espaciar(25);
        System.out.print("<<<<<<<    "+texto+"    >>>>>>>");
        espaciar(2);
    }
    
    private boolean creacionDistritos()
    {
        boolean algunoNuevo = false;
        FicheroProductoDistritoOut fichEsc;
        for (int i = 1; i < cantidadDistritos+1; i++)
        {
            File f = new File("distrito"+i+"_productos.dat");
            if (!f.exists())
            {
                fichEsc = new FicheroProductoDistritoOut("distrito"+i+"_productos.dat");
                fichEsc.escritura(ProductoDistrito.getCentinela());
                algunoNuevo = true;
                fichEsc.cierre();
            }
        }
        return algunoNuevo;
    }
}