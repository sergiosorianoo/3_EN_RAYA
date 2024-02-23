package com.politecnicomalaga;

import java.util.Scanner;

public class TresEnRaya_V2 {

    static Scanner scan = new Scanner(System.in);

    public static void main(String[] args) {
        //Explicacion de lo que hace el programa
        introduccion();
        //Creo una variable para saber a que jugador le toca
        int turno = 1;
        //En la variable guardo el tablero creado por el metodo
        String[][] tablero = tablero();
        //Metodo para mostrar por pantalla el tablero
        mostrarTablero(tablero);
        do {
            //Coloco ficha segun el jugador 
            tablero = colocarFicha(tablero, turno);
            //avanzo turno
            turno++;
            //Compruebo si ha ganado alguien o es empate
        } while (!ganador(tablero, turno));
    }

    public static void introduccion() {
        System.out.println("Juguemos a las 3 en raya.");
        System.out.println("Jugaran 2 jugadores, X y O.");
    }

    public static String[][] tablero() {
        //Definicion del tablero
        String[][] tablero = {
            {" ", "\033[31m" + "|" + "\033[0m", " ", "\033[31m" + "|" + "\033[0m", " ", " ", " ", " ", " ", "1", "\033[31m" + "|" + "\033[0m", "2", "\033[31m" + "|" + "\033[0m", "3"},
            {"\033[31m" + "-" + "\033[0m", "\033[31m" + "+" + "\033[0m", "\033[31m" + "-", "\033[31m" + "+" + "\033[0m", "\033[31m" + "-" + "\033[0m", " ", " ", " ", " ", "\033[31m" + "-" + "\033[0m", "\033[31m" + "+" + "\033[0m", "\033[31m" + "-" + "\033[0m", "\033[31m" + "+" + "\033[0m", "\033[31m" + "-" + "\033[0m"},
            {" ", "\033[31m" + "|" + "\033[0m", " ", "\033[31m" + "|" + "\033[0m", " ", " ", " ", " ", " ", "4", "\033[31m" + "|" + "\033[0m", "5", "\033[31m" + "|" + "\033[0m", "6"},
            {"\033[31m" + "-" + "\033[0m", "\033[31m" + "+" + "\033[0m", "\033[31m" + "-", "\033[31m" + "+" + "\033[0m", "\033[31m" + "-" + "\033[0m", " ", " ", " ", " ", "\033[31m" + "-" + "\033[0m", "\033[31m" + "+" + "\033[0m", "\033[31m" + "-" + "\033[0m", "\033[31m" + "+" + "\033[0m", "\033[31m" + "-" + "\033[0m"},
            {" ", "\033[31m" + "|" + "\033[0m", " ", "\033[31m" + "|" + "\033[0m", " ", " ", " ", " ", " ", "7", "\033[31m" + "|" + "\033[0m", "8", "\033[31m" + "|" + "\033[0m", "9"}
        };
        return tablero;
    }

    public static String[][] colocarFicha(String[][] tablero, int turno) {

        //Creo a los jugadores dependiendo del turno
        int jugador;
        String ficha;
        if (turno % 2 == 0) {
            ficha = "O";
            jugador = 2;
        } else {
            ficha = "X";
            jugador = 1;
        }

        System.out.println("Jugador " + jugador + " tu turno.");
        tablero();

        int posicion;

        //Variable para ver si la posicion elegida ya esta ocupada
        boolean correcto = false;

        do {

            System.out.print("¿Que posicion quieres ocupar?:");
            posicion = scan.nextInt();

            //Switch para ver donde pone la ficha el jugador
            switch (posicion) {
                case 1:
                    if (tablero[0][0].equals("X") || tablero[0][0].equals("O")) {
                        System.out.println("Casilla ocupada, elige otra.");
                        mostrarTablero(tablero);
                    } else {
                        tablero[0][0] = ficha;
                        correcto = true;
                    }
                    break;
                case 2:
                    if (tablero[0][2].equals("X") || tablero[0][2].equals("O")) {
                        System.out.println("Casilla ocupada, elige otra.");
                        mostrarTablero(tablero);
                    } else {
                        tablero[0][2] = ficha;
                        correcto = true;
                    }
                    break;
                case 3:
                    if (tablero[0][4].equals("X") || tablero[0][4].equals("O")) {
                        System.out.println("Casilla ocupada, elige otra.");
                        mostrarTablero(tablero);
                    } else {
                        tablero[0][4] = ficha;
                        correcto = true;
                    }
                    break;
                case 4:
                    if (tablero[2][0].equals("X") || tablero[2][0].equals("O")) {
                        System.out.println("Casilla ocupada, elige otra.");
                        mostrarTablero(tablero);
                    } else {
                        tablero[2][0] = ficha;
                        correcto = true;
                    }
                    break;
                case 5:
                    if (tablero[2][2].equals("X") || tablero[2][2].equals("O")) {
                        System.out.println("Casilla ocupada, elige otra.");
                        mostrarTablero(tablero);
                    } else {
                        tablero[2][2] = ficha;
                        correcto = true;
                    }
                    break;
                case 6:
                    if (tablero[2][4].equals("X") || tablero[2][4].equals("O")) {
                        System.out.println("Casilla ocupada, elige otra.");
                        mostrarTablero(tablero);
                    } else {
                        tablero[2][4] = ficha;
                        correcto = true;
                    }
                    break;
                case 7:
                    if (tablero[4][0].equals("X") || tablero[4][0].equals("O")) {
                        System.out.println("Casilla ocupada, elige otra.");
                        mostrarTablero(tablero);
                    } else {
                        tablero[4][0] = ficha;
                        correcto = true;
                    }
                    break;
                case 8:
                    if (tablero[4][2].equals("X") || tablero[4][2].equals("O")) {
                        System.out.println("Casilla ocupada, elige otra.");
                        mostrarTablero(tablero);
                    } else {
                        tablero[4][2] = ficha;
                        correcto = true;
                    }
                    break;
                case 9:
                    if (tablero[4][4].equals("X") || tablero[4][4].equals("O")) {
                        System.out.println("Casilla ocupada, elige otra.");
                        mostrarTablero(tablero);
                    } else {
                        tablero[4][4] = ficha;
                        correcto = true;
                    }
                    break;
                default:
                    break;
            }
        } while (!correcto);
        System.out.println("");
        mostrarTablero(tablero);
        //Devuelvo el tablero actualizado con la ficha colocada
        return tablero;

    }

    public static void mostrarTablero(String[][] tablero) {
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 14; j++) {
                System.out.print(tablero[i][j]);
            }
            System.out.println("");
        }
    }

    public static boolean ganador(String[][] tablero, int turno) {
        boolean winwin = false;
        //primera fila
        if (tablero[0][0].equals("X") && tablero[0][2].equals("X") && tablero[0][4].equals("X")) {
            winwin = true;
            System.out.println("Ganaste Jugador 1.");
        }
        if (tablero[0][0].equals("O") && tablero[0][2].equals("O") && tablero[0][4].equals("O")) {
            winwin = true;
            System.out.println("Ganaste Jugador 2.");
        }
        //segunda fila
        if (tablero[2][0].equals("X") && tablero[2][2].equals("X") && tablero[2][4].equals("X")) {
            winwin = true;
            System.out.println("Ganaste Jugador 1.");
        }
        if (tablero[2][0].equals("O") && tablero[2][2].equals("O") && tablero[2][4].equals("O")) {
            winwin = true;
            System.out.println("Ganaste Jugador 2.");
        }
        //tercera fila
        if (tablero[4][0].equals("X") && tablero[4][2].equals("X") && tablero[4][4].equals("X")) {
            winwin = true;
            System.out.println("Ganaste Jugador 1.");
        }
        if (tablero[4][0].equals("O") && tablero[4][2].equals("O") && tablero[4][4].equals("O")) {
            winwin = true;
            System.out.println("Ganaste Jugador 2.");
        }
        //primera columna
        if (tablero[0][0].equals("X") && tablero[2][0].equals("X") && tablero[4][0].equals("X")) {
            winwin = true;
            System.out.println("Ganaste Jugador 1.");
        }
        if (tablero[0][0].equals("O") && tablero[2][0].equals("O") && tablero[4][0].equals("O")) {
            winwin = true;
            System.out.println("Ganaste Jugador 2.");
        }
        //segunda columna
        if (tablero[0][2].equals("X") && tablero[2][2].equals("X") && tablero[4][2].equals("X")) {
            winwin = true;
            System.out.println("Ganaste Jugador 1.");
        }
        if (tablero[0][2].equals("O") && tablero[2][2].equals("O") && tablero[4][2].equals("O")) {
            winwin = true;
            System.out.println("Ganaste Jugador 2.");
        }
        //tercera columna
        if (tablero[4][0].equals("X") && tablero[4][2].equals("X") && tablero[4][4].equals("X")) {
            winwin = true;
            System.out.println("Ganaste Jugador 1.");
        }
        if (tablero[4][0].equals("O") && tablero[4][2].equals("O") && tablero[4][4].equals("O")) {
            winwin = true;
            System.out.println("Ganaste Jugador 2.");
        }
        //primera diagonal
        if (tablero[0][0].equals("X") && tablero[2][2].equals("X") && tablero[4][4].equals("X")) {
            winwin = true;
            System.out.println("Ganaste Jugador 1.");
        }
        if (tablero[0][0].equals("O") && tablero[2][2].equals("O") && tablero[4][4].equals("O")) {
            winwin = true;
            System.out.println("Ganaste Jugador 2.");
        }
        //segunda diagonal
        if (tablero[0][4].equals("X") && tablero[2][2].equals("X") && tablero[4][0].equals("X")) {
            winwin = true;
            System.out.println("Ganaste Jugador 1.");
        }
        if (tablero[0][4].equals("O") && tablero[2][2].equals("O") && tablero[4][0].equals("O")) {
            winwin = true;
            System.out.println("Ganaste Jugador 2.");
        }

        if (!winwin && turno == 10) {
            System.out.println("Habeis empatado.");
            winwin = true;
        }

        return winwin;
    }
}
