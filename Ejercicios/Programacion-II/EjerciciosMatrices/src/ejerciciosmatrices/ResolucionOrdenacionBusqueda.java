
package ejerciciosmatrices;

public class ResolucionOrdenacionBusqueda {

    private static final String NOMBRE = "matrices.dat";
    
    public static void main(String[] args)
    {
        new ResolucionOrdenacionBusqueda().metodoPrincipal();
    }
    

    private void metodoPrincipal()
    {
        int opcion = 0;
        do
        {
            try{
                opcion = menuPrincipal();

                switch (opcion) {
                    case 1:
                        titulo("GRABACIÓN MATRICES");
                        contenidoFicheroMatrices();
                        break;
                    case 2:
                        titulo("ORDENACIÓN DE OBJETOS MATRIZ POR FILAS");
                        ordenacionMatrices();
                        break;
                    case 3:
                        titulo("LISTADO DE MATRICES");
                        listadoMatrices();
                        break;
                    case 4:
                        titulo("BÚSQUEDA DE MATRIZ");
                        busquedaMatriz();
                        break;
                }
                if (opcion != 0)
                    continuar();
            } catch (NumberFormatException e){
                System.err.println("ERROR: " + e.toString());
            } catch (Exception e){
                System.err.println("ERROR: " + e.toString());
            }
        } while (opcion != 0);
    }

    private void contenidoFicheroMatrices()
    {
        
        FicheroMatricesInOut ficheroEscritura = new FicheroMatricesInOut(NOMBRE);

        MatrizNxM matriz;
        
        for (boolean escribir = true; escribir;escribir = LT.readChar() == 's') {
            int[] dim = pedirDimension();
            matriz = new MatrizNxM(dim[0], dim[1]);
            matriz.lectura();
            ficheroEscritura.escritura(matriz);
            System.out.print("Seguir escribiendo(s/n)?: ");
        }
        
        ficheroEscritura.cerrarEnlace();
    }
    

    private void ordenacionMatrices()
    {
        FicheroMatricesInOut fichero = new FicheroMatricesInOut(NOMBRE);
        fichero.actualizarCantidad();
        MatrizNxM matriz;
        System.out.println("Cantidad total - "+fichero.getCantidadMatrices());
        for (int i = 0; i<fichero.getCantidadMatrices()-1; i++)
        {
            int minPosicion = i;
            MatrizNxM minMat = fichero.lectura(i);
            System.out.println("Con i - "+i);
            System.out.println(minMat.toString()+"\n\n");
            for (int j = i+1; j < fichero.getCantidadMatrices(); j++)
            {
                matriz = fichero.lectura(j);
                System.out.println("Con j - "+ j);
                System.out.println(matriz.toString()+"\n\n");
                if (matriz.getDim1() < minMat.getDim1())
                {
                    minMat = matriz.copiar();
                    minPosicion = j;
                }
                
            }
            MatrizNxM temp = fichero.lectura(i);
            fichero.escritura(temp,0);
            //fichero.escritura(minMat, i);
        }
        System.out.println("Final");
        fichero.cerrarEnlace();
    }
    
    private void listadoMatrices()
    {
        FicheroMatricesInOut fichero = new FicheroMatricesInOut(NOMBRE);
        fichero.actualizarCantidad();
        System.out.println("Hay cantidad - "+fichero.getCantidadMatrices());
        MatrizNxM matriz;
        
        matriz = fichero.lectura();
        while (matriz != null && matriz.getDim1() != 0)
        {
            System.out.println(matriz.toString());
            matriz = fichero.lectura();
        }
        
        fichero.cerrarEnlace();
    }
    

    private void busquedaMatriz()
    {
        FicheroMatricesInOut fichero = new FicheroMatricesInOut(NOMBRE);

        int votaciones;
        
        System.out.print("Número de votaciones que quieres generar [1..100]? ");
        try{
            votaciones = LT.readInt();
            
            for (int i = 1; i <= votaciones; i++)
            {
                System.out.print("Vot: "+i+"\t ");
                for (int j = 1; j <= 10; j++)
                {
                }
                espaciado(1);
            }
        } catch (NumberFormatException e) {
            System.err.println("ERROR: " + e.toString());
        } catch (Exception e) {
            System.err.println("ERROR: " + e.toString());
        } finally {
            fichero.cerrarEnlace();
        }
    }
    
    
    public int [] pedirDimension()
    {
        int[] dim = new int[2];
        System.out.println("Indica la dimensión:");
        System.out.print("[filas]: ");
        dim[0] = LT.readInt();
        System.out.print("[columnas]: ");
        dim[1] = LT.readInt();
        
        return dim;
    }
    
    private int menuPrincipal()
    {
        System.out.print("Gestión matrices a nivel de objetos\n\n"
                + "1. Crear matrices que se guardan en un fichero\n"
                + "2. Ordenar las matrices guardadas por número de filas\n"
                + "3. Listado de matrices guardadas\n"
                + "4. Búsqueda de matriz en particular\n"
                + "0. Salir\n\n"
                + "\tInserta un opción: ");
        return LT.readInt();
    }
    
    private void continuar()
    {
        espaciado(2);
        System.out.print("<> Presiona \'intro\' para continuar · ");
        LT.readChar();
        espaciado(25);
    }
    
    private void espaciado(int i)
    {
        for (int j = 0; j < i; j++) {
            System.out.println("");
        }
    }
    
    private void titulo(String texto)
    {
        espaciado(2);
        System.out.print("<<<<<   "+texto+"   >>>>>");
        espaciado(2);
    }
}
