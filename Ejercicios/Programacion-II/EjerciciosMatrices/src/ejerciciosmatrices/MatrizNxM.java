/*
Clase MatrizNxM, donde Ny M son enteros y N>=1 y M>=1
 */
package ejerciciosmatrices;
public class MatrizNxM implements java.io.Serializable{
    // ATRIBUTOS
    //4 bytes dimension1 + 4 bytes dimension2 =                      8 bytes
    private int dimension1 = 0,dimension2 = 0;
    //8 bytes por elemento =             (dimension1 + dimension2) * 8 bytes
    private double [][] elementos;
    
    // MÉTODOS
    
    // MÉTODOS CONSTRUCTORES
    public MatrizNxM() {}
    
    public MatrizNxM(int dim1,int dim2) {
        dimension1=dim1;
        dimension2=dim2;
        elementos=new double[dimension1][dimension2];
    }
    
    public MatrizNxM(double [][] dato) {
        dimension1=dato.length;
        dimension2=dato[0].length;
        elementos=new double[dimension1][dimension2];
        elementos=dato;
    }
  
    // MÉTODOS FUNCIONALES
    
    //método que posibilita la lectura de un objeto MatrizNxM, componente a componente,
    //desde el teclado
    
    public static int getDimension(int dim1, int dim2)
    {
        int cantidad = 8;
        cantidad += (dim1 * dim2 * 8);
        return cantidad;
    }
    
    public int getDim1()
    {
        return dimension1;
    }
    public int getDim2()
    {
        return dimension2;
    }
    public double[][] getElementos()
    {
        return elementos.clone();
    }
    
    public void setElementos(double[][] elem)
    {
        dimension1 = elem.length;
        dimension2 = elem[0].length;
        elementos = elem.clone();
    }
    
    public void lectura() {
        try {
            System.out.println("LECTURA MATRIZ DE DIMENSION "+dimension1+"x"+dimension2);
            for (int fila=0;fila<dimension1;fila++) {
                for (int columna=0;columna<dimension2;columna++) {
                    System.out.print("elemento ("+fila+","+columna+") : ");
                    elementos[fila][columna]=LT.readDouble();
                }
            }            
        }catch (Exception error) {
            System.out.println("EROR: "+error.toString());
        }
    }
    
    //lleva a cabo la conversión a String de un objeto MatrizNxM con fines
    //de visualización
    public String toString() {
        String salida="";
        for (int fila=0;fila<dimension1;fila++) {
            for (int columna=0;columna<dimension2;columna++) {
                salida=salida+elementos[fila][columna]+"\t";
            }
            salida=salida+"\n";
        }
        return salida;
    }
    
    //método de clase que lleva a cabo la suma de dos objetos MatrizNxM dados por parámetro
    public static MatrizNxM suma(MatrizNxM a, MatrizNxM b) {
        MatrizNxM resultado=null;
        try {
                    //verificar si tienen el mismo número de filas y de columnas
                    if ((a.dimension1==b.dimension1)&&
                        (a.dimension2==b.dimension2)){
                        resultado=new MatrizNxM(a.dimension1,a.dimension2);     
                        for (int fila=0;fila<a.dimension1;fila++) {
                            for (int columna=0;columna<a.dimension2;columna++) {
                                resultado.elementos[fila][columna]=a.elementos[fila][columna]+b.elementos[fila][columna];
                            }
                        } 
                    }    
                    else {   
                        //al no tener el mismo número de filas y columnas llevamos a cabo
                        //la invocación de la excepción no predefinida matricesIncompatibles
                        throw new Exception("MATRICES INCOMPATIBLES PARA LA SUMA");   
                    }      
        } catch (Exception error) {}
        return resultado;
    }
    
    //método de objeto que lleva a cabo la suma de un objeto MatrizNxM con otro objeto 
    //MatrixNxM dado por parámetro
    public MatrizNxM suma(MatrizNxM b) {
        MatrizNxM resultado=null;
        try {
                    //verificar si tienen el mismo número de filas y de columnas
                    if ((dimension1==b.dimension1)&&
                        (dimension2==b.dimension2)){
                        resultado=new MatrizNxM(dimension1,dimension2);     
                        for (int fila=0;fila<dimension1;fila++) {
                            for (int columna=0;columna<dimension2;columna++) {
                                resultado.elementos[fila][columna]=elementos[fila][columna]+b.elementos[fila][columna];
                            }
                        } 
                    }    
                    else {   
                        //al no tener el mismo número de filas y columnas llevamos a cabo
                        //la invocación de la excepción no predefinida matricesIncompatibles
                        throw new Exception("MATRICES INCOMPATIBLES PARA LA SUMA");   
                    }      
        } catch (Exception error) {}
        return resultado;
    }
    
    //método de clase que lleva a cabo la resta de dos objetos MatrizNxM dados por parámetro
    public static MatrizNxM resta(MatrizNxM a, MatrizNxM b) {
        MatrizNxM resultado=null;
        try {
                    //verificar si tienen el mismo número de filas y de columnas
                    if ((a.dimension1==b.dimension1)&&
                        (a.dimension2==b.dimension2)) {
                        resultado=new MatrizNxM(a.dimension1,a.dimension2);     
                        for (int fila=0;fila<a.dimension1;fila++) {
                            for (int columna=0;columna<a.dimension2;columna++) {
                                resultado.elementos[fila][columna]=a.elementos[fila][columna]-b.elementos[fila][columna];
                            }
                        } 
                    }    
                    else {   
                        //al no tener el mismo número de filas y columnas llevamos a cabo
                        //la invocación de la excepción no predefinida matricesIncompatibles
                        throw new Exception("MATRICES INCOMPATIBLES PARA LA RESTA");   
                    }      
        } catch (Exception error) {}
        return resultado;
    }
  
    //método de objeto que lleva a cabo la suma de un objeto MatrizNxM con otro objeto 
    //MatrixNxM dado por parámetro
    public MatrizNxM resta(MatrizNxM b) {
        MatrizNxM resultado=null;
        try {
                    //verificar si tienen el mismo número de filas y de columnas
                    if ((dimension1==b.dimension1)&&
                        (dimension2==b.dimension2)){
                        resultado=new MatrizNxM(dimension1,dimension2);     
                        for (int fila=0;fila<dimension1;fila++) {
                            for (int columna=0;columna<dimension2;columna++) {
                                resultado.elementos[fila][columna]=elementos[fila][columna]-b.elementos[fila][columna];
                            }
                        } 
                    }    
                    else {   
                        //al no tener el mismo número de filas y columnas llevamos a cabo
                        //la invocación de la excepción no predefinida matricesIncompatibles
                        throw new Exception("MATRICES INCOMPATIBLES PARA LA RESTA");   
                    }      
        } catch (Exception error) {}
        return resultado;
    }
    
    //método de clase que lleva a cabo el producto de dos objetos MatrixNxM dados
    //por parámetro
    public static MatrizNxM producto(MatrizNxM a, MatrizNxM b) {
        MatrizNxM resultado=null;
        try {
            //verificar si las dos matrices son compatibles para el producto
            if (a.dimension2==b.dimension1){
                resultado=new MatrizNxM(a.dimension1,b.dimension2);
                for (int fila=0;fila<a.dimension1;fila++) {
                    for (int columna=0;columna<b.dimension2;columna++) {
                        resultado.elementos[fila][columna]=0;
                        for (int indice=0;indice<a.dimension2;indice++) {
                            resultado.elementos[fila][columna]+=
                                    (a.elementos[fila][indice]*b.elementos[indice][columna]);
                        }
                    }
                }
                
            }
            else {
                //al no ser compatibles para el producto llevamos a cabo la invocación
                //de la excepción no predefinida matricesIncompatibles
                throw new Exception("MATRICES INCOMPATIBLES PARA EL PRODUCTO");
            }
        }catch (Exception error) {}
        return resultado;   
    }
    
    
    
    //método de objeto que lleva a cabo el producto de dos objetos MatrixNxM dados
    //por parámetro
    public  MatrizNxM producto(MatrizNxM b) {
        MatrizNxM resultado=null;
        try {
            //verificar si las dos matrices son compatibles para el producto
            if ((dimension1==b.dimension2)&&
                 (dimension2==b.dimension1)){
                resultado=new MatrizNxM(dimension1,b.dimension2);
                for (int fila=0;fila<dimension1;fila++) {
                    for (int columna=0;columna<b.dimension2;columna++) {
                        resultado.elementos[fila][columna]=0;
                        for (int indice=0;indice<dimension2;indice++) {
                            resultado.elementos[fila][columna]+=
                                    (elementos[fila][indice]*b.elementos[indice][columna]);
                        }
                    }
                }
                
            }
            else {
                //al no ser compatibles para el producto llevamos a cabo la invocación
                //de la excepción no predefinida matricesIncompatibles
                throw new Exception("MATRICES INCOMPATIBLES PARA EL PRODUCTO");
            }
        }catch (Exception error) {}
        return resultado;   
    }

    //método de clase que lleva a cabo la comparación a nivel de igualdad de dos
    //objetos MatrixNxM dados por parámetro
    public static boolean iguales(MatrizNxM a,MatrizNxM b) {
        //verificar si tienen las mismas dimensiones
        if ((a.dimension1==b.dimension2)&&
                        (a.dimension2==b.dimension2)) {
            //verificar si son iguales elemento a elemento
            for (int fila=0;fila<a.dimension1;fila++) {
                for (int columna=0;columna<a.dimension2;columna++) {
                    if (a.elementos[fila][columna]!=b.elementos[fila][columna]) {
                        return false;
                    }
                }
            }
        }
        else {
            return false;
        }
        return true;
    }
    
    
    //método de objeto que lleva a cabo la comparación a nivel de igualdad un objeto MatrixNxM
    //con otro objeto MatrixNxM dado por parámetro
    public boolean iguales(MatrizNxM b) {
        //verificar si tienen las mismas dimensiones
        if ((dimension1==b.dimension2)&&
                        (dimension2==b.dimension2)) {
            //verificar si son iguales elemento a elemento
            for (int fila=0;fila<dimension1;fila++) {
                for (int columna=0;columna<dimension2;columna++) {
                    if (elementos[fila][columna]!=b.elementos[fila][columna]) {
                        return false;
                    }
                }
            }
        }
        else {
            return false;
        }
        return true;
    }
    
    //método que lleva a cabo el cálculo de la matriz traspuesta de un objeto
    //MatrixNxM
    public MatrizNxM traspuesta() {
        MatrizNxM resultado=new MatrizNxM(dimension1,dimension2);
        for (int fila=0;fila<dimension1;fila++) {
            for (int columna=0;columna<dimension2;columna++) {
                resultado.elementos[fila][columna]=elementos[columna][fila];
            }
        }
        return resultado;
    }
    
    public void identidad()
    {
        for (int fila=0;fila<dimension1;fila++) {
            for (int columna=0;columna<dimension2;columna++)
            {
                elementos[fila][columna] = (fila == columna) ? 1 : 0;
            }
        }
    }
    
    public void cambiarFilas(int origen, int destino)
    {
        try
        {
            if (origen < dimension1 && destino < dimension1)
            {
                double[] filaTemporal = elementos[origen];
                elementos[origen] = elementos[destino];
                elementos[destino] = filaTemporal;
            }
            else
                throw new Exception("MATRICES INCOMPATIBLES PARA EL PRODUCTO");
        }
        catch (Exception error) {}
    }
    
    public void invertir()
    {
        MatrizNxM resultado = new MatrizNxM(dimension1, dimension2);
        try{
            if (dimension1 == dimension2)
            {
                double determinante = determinante();
                for (int i = 0; i < dimension1; i++)
                {
                    for (int j = 0; j < dimension2; j++)
                    {
                        resultado.elementos[i][j] = adjunto(i, j).determinante() * ((i+j) % 2 == 0 ? 1 : -1);
                        resultado.elementos[i][j] /= Math.abs(determinante);
                    }
                }

                resultado = resultado.traspuesta();
                elementos = resultado.elementos.clone();
            }
            else
                throw new Exception("MATRIZ INCOMPATIBLE");
        } catch (Exception e) {}
    }
    
    public double determinante()
    {
        int resultado = 0;
        
        if (dimension1 == dimension2)
        {
            if (dimension1 == 1) return elementos[0][0];
            
            for (int i = 0; i < dimension1; i++)
            {
                resultado += adjunto(i, 0).determinante() * (i % 2 == 0 ? 1 : -1) * elementos[i][0];
            }
        }
        
        return resultado;
    }
    
    public MatrizNxM copiar()
    {
        MatrizNxM copia = new MatrizNxM(elementos);
        return copia;
    }
    
    public MatrizNxM adjunto(int fila, int columna)
    {
        MatrizNxM resultado = new MatrizNxM(dimension1-1, dimension2 - 1);
        for (int i = 0, i2 = 0; i < dimension1; i++)
        {
            if (i == fila) continue;
            for (int j = 0, j2 = 0; j < dimension2; j++)
            {
                if (j == columna) continue;
                resultado.elementos[i2][j2] = elementos[i][j];
                j2++;
            }
            i2++;
        }
        return resultado;
    }
}
