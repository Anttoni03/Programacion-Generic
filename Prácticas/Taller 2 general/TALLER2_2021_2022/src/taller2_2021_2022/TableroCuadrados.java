/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package taller2_2021_2022;

import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.Random;
import javax.swing.JPanel;

/**
 *
 * @author Juan
 */
public class TableroCuadrados extends JPanel {
    //DECLARACIÓN ATRIBUTOS
    private Cuadrado [] tablero;
    private int complejidad;
    private int dimensionX, dimensionY;
    private int coordenadaDiferente;
    private MouseListener gestorEventos;
    
    public TableroCuadrados(int dimX, int dimY, int complejidad, int nivel, 
                            MouseListener gestorEventos) {
        this.gestorEventos=gestorEventos;
        dimensionX=(dimX-((nivel-1)*2))/nivel;
        dimensionY=(dimY-((nivel-1)*2))/nivel;
        setLayout(new GridLayout(nivel,nivel,2,2));
        this.complejidad=complejidad;
        tablero=new Cuadrado[nivel*nivel];
        generacionTablero();
    }
    
    private void generacionTablero() {
        Random generador=new Random();
        int rojo=generador.nextInt(256);
        int verde=generador.nextInt(256);
        int azul=generador.nextInt(256);
        Color color=new Color(rojo,verde,azul);
        for (int indice=0;indice<tablero.length;indice++) {
                tablero[indice]=new Cuadrado(color,dimensionX,dimensionY);
                add(tablero[indice]);
                tablero[indice].addMouseListener(gestorEventos);
        }
//        System.out.println("ORIGINAL: ("+rojo+","+verde+","+azul+")");
        coordenadaDiferente=generador.nextInt(tablero.length);
        rojo=Math.abs(rojo-(100/complejidad));
        verde=Math.abs(verde-(100/complejidad));
        azul=Math.abs(azul-(100/complejidad));
//        System.out.println("FINAL: ("+rojo+","+verde+","+azul+")");
        tablero[coordenadaDiferente].cambiarColor(new Color(rojo,verde,azul));
    }
    
    public int cuadroSeleccionado(MouseEvent evento) {
        int numeroComponente=0;
        for (;numeroComponente<tablero.length;numeroComponente++) {
            if (evento.getSource()==tablero[numeroComponente]) break;
        }        
        return numeroComponente;
    }

    public void seleccionaValida(int posicion) {
        tablero[posicion].seleccionValida();
    }    
    
    public void seleccionaErronea(int posicion) {
        tablero[posicion].seleccionErronea();
        tablero[coordenadaDiferente].seleccionValida();
    }
    
    public boolean esCuadradoDiferente(int posicion) {
        return posicion==coordenadaDiferente;
    }
}
