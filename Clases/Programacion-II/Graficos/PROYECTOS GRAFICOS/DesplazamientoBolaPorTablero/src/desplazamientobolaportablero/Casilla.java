/*
CLASE Casilla: aglutina las declaraciones y las funcionalidades de objetos Casilla

realización: Juan Montes de Oca
*/

package desplazamientobolaportablero;

class Casilla {
    //DECLARACIÓN DE ATRIBUTOS
    private boolean ocupada;
    private int x,y;
    
    //MÉTODOS CONSTRUCTORES
    public Casilla(int fila,int columna, int dimension) {
        ocupada=false;
        x=fila*dimension;
        y=columna*dimension;
    }
    
    //MÉTODO QUE LIBERA UNA CASILLA
    public void setLiberada() {
        ocupada=false;
    }
    
    //MÉTODO QUE DEVUELVE EL ESTADO DE UNA CASILLA
    public boolean estado() {
        return ocupada;
    }
    
    //MÉTODO QUE CAMBIA EL ESTADO A OCUPADA DE UNA CASILLA 
    public void setOcupada() {
        ocupada=true;
    }
    
    //MÉTODO QUE CAMCIA EL ESTADO DE UNA CASILLA
    public void cambiarEstado() {
        ocupada=!ocupada;
    }
    
    //MÉTODO DE MODIFICA LA COORDENADA X DE UNA CASILLA
    public void setX(int x) {
        this.x=x;
    }
    
    //MÉTODO DE MODIFICA LA COORDENADA Y DE UNA CASILLA
    public void setY(int y) {
        this.y=y;
    }  
    
    //MÉTODO DE DA ACCESO A LA COORDENADA X DE UNA CASILLA
    public int getX() {
        return x;
    }
    
    //MÉTODO DE DA ACCESO A LA COORDENADA Y DE UNA CASILLA
    public int getY() {
        return y;
    }    

}
