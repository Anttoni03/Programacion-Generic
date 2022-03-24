
/*
CLASE PRINCIPAL Y GESTORA DE LA GESTIÓN DE LA ACTUALIZACIÓN DE FICHEROS
*/
package EjerciciosLibro;
import General.LT;

public class GestionActualizacionFicheros {
    
    private int opcion;
    
    
    //MÉTODO MAIN
    public static void main(String[] args)
    {
        new GestionActualizacionFicheros().metodoPrincipal();
    }
    
    private void metodoPrincipal()
    {
        menuPrincipal();
        
        switch (opcion) {
            case 1,3,4,5:
                opcionNoImplementada();
                break;
            case 2:
                opcionListadoLibros();
                break;
            case 6:
                opcionSalir();
                break;
        }
    }
    
    private void menuPrincipal()
    {
        mostrarTitulo("MENÚ GESTIÓN ACTUALIZACIÓN LIBROS");
        System.out.print("[1] ALTA ACTUALIZACIONES."
                + "\n[2] LISTADO LIBROS."
                + "\n[3] LISTADO ACTUALIZACIONES PENDIENTES DE PROCESAR."
                + "\n[4] LISTADO INCIDENCIAS ÚLTIMA ACTUALIZACIÓN."
                + "\n[5] ACTUALIZACIÓN FICHERO LIBROS."
                + "\n[6] SALIR."
                + "\n\t------> ");
        opcion = LT.readInt();
        espaciar(25);
    }
    
    private void mostrarTitulo(String titulo)
    {
        System.out.println("<<<<<<<     "+titulo+"     >>>>>>>");
        espaciar(1);
    }
    
    private void espaciar(int cantidad)
    {
        for (int i = 0; i < cantidad; i++)
            System.out.println("");
    }
    
    private void continuar()
    {
        System.out.print("PULSA Intro PARA CONTINUAR ");
        LT.readLine();
        espaciar(20);
    }
    
    private void opcionNoImplementada()
    {
        mostrarTitulo("OPCIÓN NO IMPLEMENTADA");
        continuar();
        metodoPrincipal();
    }
    
    private void opcionListadoLibros()
    {
        mostrarTitulo("LISTADO LIBROS");
        
        FicheroObjetosLibroIn fichero = new FicheroObjetosLibroIn("libros.dat");
        Libro libro = fichero.lectura();
        while (!libro.esCentinela())
        {
            System.out.println(libro.toString());
            libro = fichero.lectura();
        }
        fichero.cierre();
        
        espaciar(1);
        continuar();
        metodoPrincipal();
    }
    
    private void opcionSalir()
    {
        mostrarTitulo("SALIR");
        continuar();
    }
}