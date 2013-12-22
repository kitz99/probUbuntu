/*
 * Problema turnurilor din Hanoi.
 * Se consideră 3 tije. Iniţial pe tija 1 se află n discuri cu diametrele 
 * decrescătoare privind de la bază către vârf, iar pe tijele 2 şi 3 nu se află 
 * nici un disc. Se cere să se mute aceste discuri pe tija 2, ajutându-ne şi de 
 * tija 3, respectând condiţia ca în permanenţă pe orice tijă sub orice disc să 
 * se afle baza tijei sau un disc de diametru mai mare.
 */
package tema7;
import java.util.*;
import java.io.*;

public class TowersOfHanoi {
    static int n;
    static Scanner sc;
    static PrintWriter pw;
    public static void hanoi(int n, char from, char via, char to){
        if(n == 1){
            pw.write("Dicul 1 de pe tija " + from + " pe tija " + to + "\n");
            return;
        }
        else {
            hanoi(n-1, from, to, via);
            pw.write("Discul " + n + " de pe tija " + from + " pe tija " + to + "\n"); 
            hanoi(n-1,via,from,to);
        }
    }
    public static void main(String [] Args){
        try {
            sc = new Scanner(new File("hanoiIn.txt"));
        } catch (FileNotFoundException ex) {
            System.out.println("Eroare deschidere fisier de intrare");
        }
        try{
            n = sc.nextInt();
        } catch(Exception ex){
            System.out.println("Not a number!");
        }
        try {
            pw = new PrintWriter(new File("hanoiOut.txt"));
        } catch (FileNotFoundException ex) {
            System.out.println("Eroare fisier de scriere");
        }
        System.out.println(n);
        hanoi(n, 'A', 'B', 'C');
        pw.close();
    }
}
