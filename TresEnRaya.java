package com.politecnicomalaga;

import java.util.Scanner;

public class TresEnRaya {

    static Scanner scan = new Scanner(System.in);

    public static void main(String[] args) {
        //Explicacion de lo que hace el programa
        introduccion();
        //Creo una variable para saber a que jugador le toca
        int turno = 1;
        //En la variable guardo el tablero creado por el metodo
        String[][] tablero = crearTablero();
        //Metodo para mostrar por pantalla el tablero
        mostrarTablero(tablero);
        //Guardo los nombre de los jugadores
        String nombreVariableJug1 = guardarNombre(1);
        String nombreVariableJug2 = guardarNombre(2);
        String nombreJug1,nombreJug2;

        String vacio = "( )";
        boolean ganador = false;

        System.out.println("¿Quien quiere empezar?");
        System.out.println("1." + nombreVariableJug1);
        System.out.println("2." + nombreVariableJug2);
        int eleccion = scan.nextInt();
        String primero;
        String segundo;
        if (eleccion == 1) {
            primero = "(x)";
            segundo = "(o)";
            nombreJug1=nombreVariableJug1;
            nombreJug2=nombreVariableJug2;
            
        } else {
            segundo = "(o)";
            primero = "(x)";
            nombreJug1=nombreVariableJug2;
            nombreJug2=nombreVariableJug1;
        }

        do {
            if (turno % 2 == 0) {
                colocarFicha(nombreJug2, tablero, vacio, segundo);
                mostrarTablero(tablero);
                ganador= comprobacionO(nombreJug2,tablero);
            } else {
                colocarFicha(nombreJug1, tablero, vacio, primero);
                mostrarTablero(tablero);
                ganador= comprobacionX(nombreJug1,tablero);
            }
            turno++;
        } while (!ganador);

        
        int contadores [] = new int[]{0,0,0};
        
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

    public static void asignarFichas() {

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

    public static boolean comprobarHorizX(String[][] tablero, String nombre) {
        //Horizontales
        int cont = 0;
        int contadorY = 0;
        boolean ganador = false;
        for (int fila = 0; fila < tablero.length; fila++) {
            for (int columna = 0; columna < tablero.length; columna++) {
                if (tablero[fila][columna].equals("(x)")) {
                    cont++;
                }
            }
            if (cont == tablero.length) {
                ganador = true;
                System.out.println("Ha ganado " + nombre + ", enhorabuena!.");
            }
            cont = 0;
        }
        return ganador;

    }

    public static boolean comprobarHorizO(String[][] tablero, String nombre) {

        int cont = 0;
        boolean ganador = false;
        for (int fila = 0; fila < tablero.length; fila++) {
            for (int columna = 0; columna < tablero.length; columna++) {
                if (tablero[fila][columna].equals("(o)")) {
                    cont++;
                }
            }
            if (cont == tablero.length) {
                ganador = true;
                System.out.println("Ha ganado " + nombre + ", enhorabuena!.");
            }
            cont = 0;
        }
        return ganador;

    }

    public static boolean comprobarVertX(String[][] tablero, String nombre) {

        int cont = 0;
        boolean ganador = false;
        for (int fila = 0; fila < tablero.length; fila++) {
            for (int columna = 0; columna < tablero.length; columna++) {
                if (tablero[columna][fila].equals("(x)")) {
                    cont++;
                }
            }
            if (cont == tablero.length) {
                ganador = true;
                System.out.println("Ha ganado " + nombre + ", enhorabuena!.");
            }
            cont = 0;
        }
        return ganador;

    }

    public static boolean comprobarVertO(String[][] tablero, String nombre) {

        int cont = 0;
        boolean ganador = false;
        for (int fila = 0; fila < tablero.length; fila++) {
            for (int columna = 0; columna < tablero.length; columna++) {
                if (tablero[columna][fila].equals("(o)")) {
                    cont++;
                }
            }
            if (cont == tablero.length) {
                ganador = true;
                System.out.println("Ha ganado " + nombre + ", enhorabuena!.");
            }
            cont = 0;
        }
        return ganador;

    }

    public static boolean comprobarDiaPrincipalX(String[][] tablero, String nombre) {

        int cont = 0;
        boolean ganador = false;
        for (int fila = 0; fila < tablero.length; fila++) {

            if (tablero[fila][fila].equals("(x)")) {
                cont++;
            }

            if (cont == tablero.length) {
                ganador = true;
                System.out.println("Ha ganado " + nombre + ", enhorabuena!.");
            }
            //cont = 0;
        }
        return ganador;

    }

    public static boolean comprobarDiaPrincipalO(String[][] tablero, String nombre) {

        int cont = 0;
        boolean ganador = false;
        for (int fila = 0; fila < tablero.length; fila++) {

            if (tablero[fila][fila].equals("(o)")) {
                cont++;
            }

            if (cont == tablero.length) {
                ganador = true;
                System.out.println("Ha ganado " + nombre + ", enhorabuena!.");
            }
            //cont = 0;
        }
        return ganador;

    }

    public static boolean comprobarDiaSecundariaO(String[][] tablero, String nombre) {

        int cont = 0;
        boolean ganador = false;
        for (int fila = 0; fila < tablero.length; fila++) {
            if (tablero[fila][tablero.length - fila - 1].equals("(o)")) {
                cont++;
            }

            if (cont == tablero.length) {
                ganador = true;
                System.out.println("Ha ganado " + nombre + ", enhorabuena!.");
            }
        }
        return ganador;

    }

    public static boolean comprobarDiaSecundariaX(String[][] tablero, String nombre) {

        int cont = 0;
        boolean ganador = false;
        for (int fila = 0; fila < tablero.length; fila++) {
            if (tablero[fila][tablero.length - fila - 1].equals("(x)")) {
                cont++;
            }

            if (cont == tablero.length) {
                ganador = true;
                System.out.println("Ha ganado " + nombre + ", enhorabuena!.");
            }
        }
        return ganador;

    }
    
    public static boolean comprobacionX(String nombre, String[][] tablero){
        boolean ganador=false;
        if (comprobarHorizX(tablero,nombre)) {
            ganador=true;
        }else if(comprobarVertX(tablero, nombre)){
            ganador=true;
        }else if (comprobarDiaPrincipalX(tablero,nombre)) {
            ganador=true;
        }else if (comprobarDiaSecundariaX(tablero,nombre)) {
            ganador=true;
        }else{
            ganador=false;
        }
        return ganador;
    }
    
    public static boolean comprobacionO(String nombre, String[][] tablero){
        boolean ganador=false;
        if (comprobarHorizO(tablero,nombre)) {
            ganador=true;
        }else if(comprobarVertO(tablero, nombre)){
            ganador=true;
        }else if (comprobarDiaPrincipalO(tablero,nombre)) {
            ganador=true;
        }else if (comprobarDiaSecundariaO(tablero,nombre)) {
            ganador=true;
        }else{
            ganador=false;
        }
        return ganador;
    }
}
