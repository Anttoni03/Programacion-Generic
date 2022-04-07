/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GestionContactos;
import java.io.*;

public class FicheroContactoInOut {
    
    private RandomAccessFile fichero = null;
    
    public FicheroContactoInOut(String nombreFichero)
    {
        try{
            fichero = new RandomAccessFile(nombreFichero,"rw");
        } catch (FileNotFoundException e){
            System.err.println("ERROR DE ENLACE DEL FICHERO: " + e.toString());
        }
    }
    
    
    public Contacto lectura()
    {
        Contacto contacto = new Contacto();
        
        try{
            contacto.setCodigo(fichero.readInt());          //Lectura de 4 bytes del código
            contacto.setNombre(lecturaString(32));          //Lectura de 32 caracteres del nombre
            contacto.setTelefono(lecturaString(16));        //Lectura de 16 caracteres del teléfono
            contacto.setEmail(lecturaString(32));           //Lectura de 32 caracteres del mail
            contacto.setDireccion(lecturaString(64));       //Lectura de 64 caracteres de la dirección
            contacto.setEdad(fichero.readInt());            //Lectura de 4 bytes de la edad
            contacto.setEliminado(fichero.readBoolean());   //Lectura de 1 byte del estado
        } catch (EOFException e) {
            //System.err.println("ERROR EN LA LECTURA DEL FICHERO: " + e.toString());
        } catch (IOException e) {
            System.err.println("ERROR EN LA LECTURA DEL FICHERO: " + e.toString());
        }
        
        return contacto;
    }
    
    
    public Contacto lectura(int posicion)
    {
        Contacto contacto = new Contacto();
        
        try{
            if (posicion > 0 && posicion <= (fichero.length()/Contacto.getDimension())){
                
                fichero.seek((posicion - 1)*Contacto.getDimension());
                
                contacto = lectura();
            }
            else{
                throw new EntradaIncorrecta("LA POSICIÓN NO EXISTE");
            }
        } catch(IOException e){
            System.err.println("ERROR EN LA LECTURA DEL FICHERO: " + e.toString());
        } finally {
            return contacto;
        }
    }
    
    
    private String lecturaString(int cantidadCaracteres)
    {
        String temp = "";
        
        try{
            for (int i = 0; i < cantidadCaracteres; i++)
            {
                temp += fichero.readChar();
            }
        } catch (IOException e){
            System.err.println("ERROR EN LA LECTURA DEL FICHERO: " + e.toString());
        } finally {
            return temp;
        }
    }
    
    public void escritura(Contacto contacto)
    {
        try{
            fichero.seek(fichero.length());
            
            fichero.writeInt(contacto.getCodigo());
            fichero.writeChars(escrituraString(contacto.getNombre(), 32));
            fichero.writeChars(escrituraString(contacto.getTelefono(), 16));
            fichero.writeChars(escrituraString(contacto.getEmail(), 32));
            fichero.writeChars(escrituraString(contacto.getDireccion(), 64));
            fichero.writeInt(contacto.getEdad());
            fichero.writeBoolean(contacto.getEliminado());
        } catch(IOException e){
            System.err.println("ERROR EN ESCRITURA FICHERO: " + e.toString());
        }
    }
    
    public void escritura(Contacto contacto, int posicion)
    {
        try{
            if (posicion > 0 && posicion <= (fichero.length() / Contacto.getDimension()))
            {
                fichero.seek((posicion-1) * Contacto.getDimension());
                
                fichero.writeInt(contacto.getCodigo());
                fichero.writeChars(escrituraString(contacto.getNombre(), 32));
                fichero.writeChars(escrituraString(contacto.getTelefono(), 16));
                fichero.writeChars(escrituraString(contacto.getEmail(), 32));
                fichero.writeChars(escrituraString(contacto.getDireccion(), 64));
                fichero.writeInt(contacto.getEdad());
                fichero.writeBoolean(contacto.getEliminado());
            }
            else{
                throw new EntradaIncorrecta("LA POSICIÓN NO EXISTE");
            }
        } catch(EntradaIncorrecta e){
            System.err.println("ERROR EN ESCRITURA FICHERO: " + e.toString());
        } catch(IOException e){
            System.err.println("ERROR EN ESCRITURA FICHERO: " + e.toString());
        }
    }
    
    
    private String escrituraString(String texto, int cantidadCaracteres)
    {
        String temp = "";
        try{
            for (int i = 0; i < texto.length() && i < cantidadCaracteres; i++)
            {
                temp += texto.charAt(i);
            }
            
            if (texto.length() < cantidadCaracteres){
                for (int i = 0; i < cantidadCaracteres - texto.length(); i++)
                {
                    temp += ' ';
                }
            }
        } catch (Exception e){
            System.err.println("ERROR DE ESCRITURA EN FICHERO: " + e.toString());
        } finally{
            return temp;
        }
    }
    
    public void cierre()
    {
        try{
            fichero.close();
        } catch(IOException e){
            System.err.println("ERROR AL CERRAR EL FICHERO: " + e.toString());
        }
    }
    
}
