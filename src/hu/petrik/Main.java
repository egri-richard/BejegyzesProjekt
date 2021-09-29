package hu.petrik;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    static List<Bejegyzes> Blist = new ArrayList<>();
    static Scanner scan = new Scanner(System.in);

    public static void main(String[] args) {
	    add2();
	    addCustom();
        System.out.println(Blist);
    }

    public static void add2() {
        Blist.add(new Bejegyzes("Pisti", "Szeretem az almát"));
        Blist.add(new Bejegyzes("Jani", "Szeretem a Banánt"));
    }

    public static void addCustom() {
        System.out.print("Hány bejegyzést szeretne hozzáadni? ");
        int numOfAdd = scan.nextInt();
        String szerzoTemp;
        String tartTemp;

        for (int i = 0; i < numOfAdd; i++) {
            System.out.println("Ki a bejegyzés szerzője?");
            szerzoTemp = scan.next();

            System.out.println("Mi a bejegyzés tartalma?");
            tartTemp = scan.next();

            Blist.add(new Bejegyzes(szerzoTemp, tartTemp));
        }
    }
}
