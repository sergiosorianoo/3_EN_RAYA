package com.politecnicomalaga;

import java.util.Scanner;

public class TresEnRaya_Test {

    static Scanner scan = new Scanner(System.in);

    public static void main(String[] args) {
        
        introduccion();
        
        int turno = 1;
        boolean ganador;
        String fichaX;
        String fichaO;
        String vacio = "( )";
        String nombreJug1, nombreJug2;
        
        String[][] tablero = crearTablero();
        
        mostrarTablero(tablero);
        
        String nombreTempJug1 = guardarNombre(1);
        String nombreTempJug2 = guardarNombre(2);        

        System.out.println("¿Quien quiere empezar?");
        System.out.println("1." + nombreTempJug1);
        System.out.println("2." + nombreTempJug2);
        int eleccion = scan.nextInt();
        
        if (eleccion == 1) {
            fichaX = "(x)";
            fichaO = "(o)";
            nombreJug1 = nombreTempJug1;
            nombreJug2 = nombreTempJug2;

        } else {
            fichaO = "(o)";
            fichaX = "(x)";
            nombreJug1 = nombreTempJug2;
            nombreJug2 = nombreTempJug1;
        }

        do {
            if (turno % 2 == 0) {
                colocarFicha(nombreJug2, tablero, vacio, fichaO);
                mostrarTablero(tablero);
                ganador = comprobaciones(tablero, nombreJug2, fichaO);
            } else {
                colocarFicha(nombreJug1, tablero, vacio, fichaX);
                mostrarTablero(tablero);
                ganador = comprobaciones(tablero, nombreJug2, fichaX);
            }
            turno++;
        } while (!ganador);

    }

    public static void introduccion() {
        System.out.println("Juguemos a las 3 en raya.");
        System.out.println("Jugaran 2 jugadores, X y O.");
    }

    public static String[][] crearTablero() {
        System.out.print("¿Cuantas filas quieres jugar?: ");
        int casillas = scan.nextInt();
        String[][] tablero = new String[casillas][casillas];
        for (int i = 0; i < tablero.length; i++) {
            for (int j = 0; j < tablero.length; j++) {
                tablero[i][j] = "( )";
            }
        }
        return tablero;
    }

    public static void mostrarTablero(String[][] tablero) {
        for (int i = 0; i < tablero.length; i++) {
            for (int j = 0; j < tablero.length; j++) {
                System.out.print(tablero[i][j]);
            }
            System.out.println("");
        }
    }    

    public static String guardarNombre(int numero) {
        System.out.println("Jugador " + numero + ", introduce tu nombre: ");
        String jugador = scan.next();
        return jugador;
    }

    public static String[][] colocarFicha(String nombre, String[][] tablero, String vacio, String ficha) {

        System.out.println("¿En que posicion quieres colocar ficha " + nombre + "?.");
        int posX, posY;
        do {
            System.out.print("Posicion X: ");
            posX = scan.nextInt();
            System.out.print("Posicion Y: ");
            posY = scan.nextInt();
            if (!tablero[posX - 1][posY - 1].equals(vacio)) {
                System.out.println("Casilla ocupada, elige otra.");
            }

        } while (!tablero[posX - 1][posY - 1].equals(vacio));
        tablero[posX - 1][posY - 1] = ficha;
        return tablero;
    }

    public static boolean comprobaciones(String[][] tablero, String nombre, String ficha) {

        int contadores[] = new int[]{0, 0, 0, 0};

        boolean ganador = false;

        for (int fila = 0; fila < tablero.length; fila++) {
            for (int columna = 0; columna < tablero.length; columna++) {
                if (tablero[fila][columna].equals(ficha)) {
                    contadores[0]++;
                }
            }
            if (contadores[0] == tablero.length) {
                ganador = true;
                System.out.println("Ha ganado " + nombre + ", enhorabuena!.");
            }
            contadores[0] = 0;
        }

        for (int fila = 0; fila < tablero.length; fila++) {
            for (int columna = 0; columna < tablero.length; columna++) {
                if (tablero[columna][fila].equals(ficha)) {
                    contadores[1]++;
                }
            }
            if (contadores[1] == tablero.length) {
                ganador = true;
                System.out.println("Ha ganado " + nombre + ", enhorabuena!.");
            }
            contadores[1] = 0;
        }

        for (int fila = 0; fila < tablero.length; fila++) {
            if (tablero[fila][fila].equals(ficha)) {
                contadores[2]++;
            }

            if (contadores[2] == tablero.length) {
                ganador = true;
                System.out.println("Ha ganado " + nombre + ", enhorabuena!.");
            }
            
        }
        
        for (int fila = 0; fila < tablero.length; fila++) {
            if (tablero[fila][tablero.length - fila - 1].equals(ficha)) {
                contadores[3]++;
            }

            if (contadores[3] == tablero.length) {
                ganador = true;
                System.out.println("Ha ganado " + nombre + ", enhorabuena!.");
            }
           
        }

        return ganador;

    }
}

