/*
 * Sa se determine subsirul comun maximal a doua siruri de 
 * numere
 */
package tema7;

import java.util.*;
import java.io.*;

public class SubsirComunCrescator {

    static int[] x; // primul sir
    static int[] y; // al doilea sir
    static int n, m; // dim sirului x resp dim sirului y
    static int[][] A;
    static Scanner sc;
    static PrintWriter pw;

    private static void detSubsir() {
        A = new int[n + 1][m + 1];
        for (int k = 1; k <= n; k++) {
            for (int h = 1; h <= m; h++) {
                if (x[k] == y[h]) {
                    A[k][h] = 1 + A[k - 1][h - 1];
                } else if (A[k - 1][h] > A[k][h - 1]) {
                    A[k][h] = A[k - 1][h];
                } else {
                    A[k][h] = A[k][h - 1];
                }
            }
        }
    }

    private static void printSubsir(int k, int h) {
        if (A[k][h] != 0) {
            if (x[k] == y[h]) {
                printSubsir(k - 1, h - 1);
                pw.write(x[k] + " ");
            } else {
                if (A[k][h] == A[k - 1][h]) {
                    printSubsir(k - 1, h);
                } else if (A[k][h] == A[k][h - 1]) {
                    printSubsir(k, h - 1);
                }
            }
        }
    }

    public static void main(String[] Args) {
        try {
            sc = new Scanner(new File("subsirComun.txt"));
        } catch (FileNotFoundException e) {
            System.out.println("File not found!\n" + e.getMessage().toString());
        }
        try {
            n = sc.nextInt();
            m = sc.nextInt();
        } catch (Exception ex) {
            System.out.println("Not numbers!!");
            System.out.println(ex.getMessage().toString());
        }
        try {
            x = new int[n + 1];
            y = new int[n + 1];
            for (int i = 1; i < n + 1; i++) {
                x[i] = sc.nextInt();
            }
            for (int i = 1; i < m + 1; i++) {
                y[i] = sc.nextInt();
            }
        } catch (Exception ex) {
            System.out.println(ex.getMessage().toString());
        }
        sc.close();
        detSubsir();
        int k = n, h = m;
        try {
            pw = new PrintWriter(new File("sComunOut.txt"));
        } catch (FileNotFoundException ex) {
            System.out.println("Eroare la fisier de scriere");
        }
        printSubsir(k, h);
        pw.close();
    }
}
