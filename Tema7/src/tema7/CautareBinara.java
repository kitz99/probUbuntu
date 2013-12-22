package tema7;

import java.io.*;
import java.util.Scanner;

public class CautareBinara {

    static int cauta(int a, int b, int k) {
        if (a > b) {
            return -1;
        }
        int m = (a + b) / 2;
        if (k == v[m]) {
            return m;
        } else if (k > v[m]) {
            return cauta(m + 1, b, k);
        } else {
            return cauta(a, m, k);
        }
    }
    static int[] v;
    static int n;
    static int k;
    static Scanner sc;

    public static void main(String[] args) throws FileNotFoundException {
        sc = new Scanner(new File("numere.txt"));
        boolean ok = true;
        try {
            n = sc.nextInt();

        } catch (Exception e) {
            ok = false;
            System.out.println(e.getMessage().toString());
        }
        if (ok) {
            v = new int[n];
            try {
                for (int i = 0; i < n; i++) {
                    v[i] = sc.nextInt();
                }
            } catch (Exception ex) {
                System.out.println(ex.getMessage().toString());

            }
            for (int i = 0; i < n - 1; i++) {
                if (v[i] > v[i + 1]) {
                    System.exit(0);
                }
            }
        }
        try {
            k = sc.nextInt();
        } catch (Exception ex) {
            System.out.println(ex.getMessage().toString());
        }
        int c = cauta(0, n - 1, k);
        if (c == -1) {
            PrintWriter pw = new PrintWriter(new File("iesire.txt"));
            pw.write("Nu exista in vector ");
            pw.close();
        } else {
            PrintWriter pw = new PrintWriter(new File("iesire.txt"));
            pw.write("Elementul " + k + "se afla pe pozitia " + (c + 1) + "\n");
            pw.close();
        }
    }
}
