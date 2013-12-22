/* Sa se determine cel mai lung subsir crescator al unui sir de numere intregi
 * introdus de la tastaura
 */
package tema7;

import java.util.*;
import java.io.*;

public class SubsirCrescator {

    static int[] v;
    static int n;
    static int[] lg;
    static int max = -0xfffffff;
    static int m, indice;
    static Scanner sc;

    private static void detSubsir() {
        lg[n] = 1;
        for (int k = n - 1; k > 0; k--) {
            m = 0;
            for (int i = k + 1; i <= n; i++) {
                if (v[i] > v[k] && lg[i] > m) {
                    m = lg[i];
                }
            }
            lg[k] = m + 1;
            if (lg[k] > max) {
                max = lg[k];
                indice = k;
            }
        }
    }

    public static void printSubsir() {
        PrintWriter pw = null;
        try {
            pw = new PrintWriter(new File("sCrescatorOut.txt"));
        } catch (FileNotFoundException ex) {
            System.out.println("File could not be opend");
        }
        pw.write("Cel mai lung subir crescator are lungimea " + max + "\n");
        pw.write(v[indice] + " ");
        for (int i = indice + 1; i <= n; i++) {
            if ((v[i] > v[indice]) && (lg[i] == max - 1)) {
                pw.write(v[i] + " ");
                max--;
            }
        }
        pw.close();
    }

    public static void main(String[] Args) {
        try {
            sc = new Scanner(new File("subsirCrescator.txt"));
        } catch (FileNotFoundException e) {
            System.out.println("File not found!\n" + e.getMessage().toString());
        }
        try {
            n = sc.nextInt();
        } catch (Exception ex) {
            System.out.println("Not a number");
            System.out.println(ex.getMessage().toString());
        }
        try {
            v = new int[n + 1];
            lg = new int[n + 1];
            for (int i = 1; i < n + 1; i++) {
                v[i] = sc.nextInt();
            }
        } catch (Exception ex) {
            System.out.println(ex.getMessage().toString());
        }
        sc.close();
        detSubsir();
        printSubsir();
    }
}
