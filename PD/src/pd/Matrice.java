/*
 * Se dau n matrice. Sa se determine o modaltate optima de a le inmulti
 */
package pd;

import java.util.*;
import java.io.*;

public class Matrice {
    static int n;
    static int [] d;
    static int [][] cost;
    static Scanner sc;
    static PrintWriter pw;
    static int poz;
    public static void sol(int i, int j){
        if(i == j) System.out.print(i + " ");
        else {
            poz = cost[j][i];
            System.out.print("(");
            sol(i, poz-1);
            System.out.print(",");
            sol(poz, j);
            System.out.print(")");
        }
    }
    public static void main(String [] Args){
        try {
            sc = new Scanner(new File("matriceIn.txt"));
        } catch (FileNotFoundException ex) {
            System.out.println("Eraore deschidere fisier");
        }
        n = sc.nextInt();
        d = new int[1000];
        cost = new int[1000][1000];
        for(int i = 0; i <= n; i++){
            d[i] = sc.nextInt();
        }
        
        for(int j = 2; j <= n; j++){
            for(int i = j-1; i >=1; i--){
                int m = 999999; int k = 0;
                for(k = i; k < j; k++){
                    int aux = cost[i][k] + cost[k+1][j] + d[i-1]*d[k]*d[j];
                    if(aux < m) m = aux;
                }
                cost[i][j] = m;
                cost[j][i] = k;
            }
        }
        try {
            pw = new PrintWriter(new File("matriceOut.txt"));
        } catch (FileNotFoundException ex) {
            System.out.println("Eroare fisier de scriere");
        }
        pw.write(cost[1][n] + " ");
        sol(1, n);
        pw.close();
        sc.close();
    }
}
