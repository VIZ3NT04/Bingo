package org.example;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        // Generar carto del (1 - 90) y soles 2 numeros per decena
        // Fer les boles i que se almacenen sempre
        // Sistema per a cantar linea
        // Sistema per a cantar bingo
        Scanner scanner = new Scanner(System.in);
        boolean semafor = false;
        while (!semafor) {

            System.out.println("Vols juagar al bingo? (s/n)");
            String resposta = scanner.nextLine();

            if (resposta.equals("s")) {
                ArrayList<Integer> carto = generarCarto();
                generarBingo(carto);
            } else {
                semafor = true;
            }

        }

    }

    private static void generarBingo(ArrayList<Integer> carto) throws InterruptedException {
        boolean linea = false;
        int contador = 0;
        ArrayList<Integer> bingo = new ArrayList<>();
        for (int i = 0; i < 90; i++) {
            int numero = (int) (Math.random() * 90) + 1;

            if (!bingo.contains(numero)) {
                bingo.add(numero);
                System.out.println("El numero es: " + bingo.get(i));
                Thread.sleep(1000);
            } else {

                i--;
            }



            if (carto.contains(bingo.get(i))) {
                // Mostrar el carto de nou taxant els que ja estan
                int index = carto.indexOf(bingo.get(i));
                carto.set(index, -1);
                for (int j = 0; j < carto.size(); j++) {
                    if (j == 5 || j == 10) System.out.println();
                    if (carto.get(j) == -1) System.out.print("XX ");
                    else System.out.print(carto.get(j) + " ");
                }
                System.out.println();
                if (!linea) {
                    for (int j = 0; j < carto.size(); j++) {
                        if (carto.get(0) == -1 && carto.get(1) == -1 &&
                                carto.get(2) == -1 && carto.get(3) == -1
                                && carto.get(4) == -1) {
                            System.err.println("LINEA!!!");
                            linea = true;
                            break;
                        }
                        if (carto.get(5) == -1 && carto.get(6) == -1 &&
                                carto.get(7) == -1 && carto.get(8) == -1
                                && carto.get(9) == -1) {
                            System.err.println("LINEA!!!");
                            linea = true;
                            break;
                        }
                        if (carto.get(10) == -1 && carto.get(11) == -1 &&
                                carto.get(12) == -1 && carto.get(13) == -1
                                && carto.get(14) == -1) {
                            System.err.println("LINEA!!!");
                            linea = true;
                            break;
                        }
                    }
                }

                contador++;
                Thread.sleep(1000);
                if (contador == 15) {
                    System.err.println("BINGO!!!");
                    break;
                }
            }
        }
    }

    private static ArrayList<Integer> generarCarto() {
        ArrayList<Integer> arrayCarto = new ArrayList<>();
        for (int i = 0; i < 15; i++) {
            int numero = (int) (Math.random() * 90) + 1;
            if (!arrayCarto.contains(numero)) {
                arrayCarto.add(numero);
            } else {
                i--;
            }
        }
        System.out.println("El carto es:");
        for (int i = 0; i < arrayCarto.size(); i++) {
            if (i == 5 || i == 10) System.out.println();
            System.out.print(arrayCarto.get(i) + " ");
        }
        System.out.println();
        return arrayCarto;
    }
}