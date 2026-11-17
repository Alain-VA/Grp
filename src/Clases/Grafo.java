/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Clases;

import java.util.ArrayList;
import javax.swing.JFrame;

/**
 *
 * @author a0va7
 */
public class Grafo {

    private int matriz[][];

    public Grafo(int mat[][]) {
        this.matriz = mat;
    }

    public int getDistancia(int a, int b) {
        return matriz[a][b];
    }

    public int size() {
        return matriz.length;
    }

    // recibe la dimension de la matriz, la instancia
    // y le asigna "infinito" a cada celda
    public Grafo(int n) {
        // matriz cuadrada de n filas y n columnas
        matriz = new int[n][n];

        // inicializo la matriz
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                matriz[i][j] = Integer.MAX_VALUE;
            }
        }
    }

    // recibe la dimension de la matriz, y un conjunto de aristas
    // los nodos no afectados por las aristas no seran adyacentes
    public Grafo(int n, Arista[] arr) {
        // invoco al otro constructor para inicializar la matriz
        this(n);

        for (Arista a : arr) {
            addArista(a);
        }
    }

    public void addArista(Arista a) {
        matriz[a.getN1()][a.getN2()] = a.getDistancia();
        matriz[a.getN2()][a.getN1()] = a.getDistancia();
    }

    public ArrayList<Integer> getVecinos(int n) {
        ArrayList<Integer> a = new ArrayList<Integer>();

        //Inicio for
        for (int i = 0; i < matriz.length; i++) {

            //Declaracción de condicional
            if (matriz[n][i] != Integer.MAX_VALUE) {
                a.add(i);
            }

            //Retorna el valor nuevo valor de a;
            return a;
        }

        return a;
    }

    public static void main(String[] args) {
        JFrame ventana = new JFrame("Grafo");
        ventana.add(new Lienzo());

        ventana.setSize(600, 600);
        ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        ventana.setVisible(true);
    }
}
