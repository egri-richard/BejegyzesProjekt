package hu.petrik;

import java.io.BufferedReader;
import java.io.Console;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class Main {

    static List<Bejegyzes> Blist = new ArrayList<>();
    static Scanner scan = new Scanner(System.in);
    static Random rnd = new Random();

    public static void main(String[] args) {
	    add2();
	    addCustom();
	    addFromFile();
	    assignLikes();
	    editSecond();
        System.out.println(Blist);
        findMostPop();
        isThereMoreThan35();
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

    public static void addFromFile() {
        try {
            FileReader file = new FileReader("bejegyzesek.txt");
            BufferedReader read = new BufferedReader(file);
            String line = read.readLine();

            while(line != null) {
                String[] elements = line.split(";");
                Blist.add(new Bejegyzes(elements[0], elements[1]));
                line = read.readLine();
            }

            read.close();
            file.close();
        } catch (IOException e) {
            System.out.println(e);
        }
    }

    public static void assignLikes() {
        for (int i = 0; i < (Blist.size() * 20); i++) {
            Blist.get(rnd.nextInt(Blist.size())).plusLike();
        }
    }

    public static void editSecond() {
        System.out.println("Változtathat a második bejegyzésben: ");
        System.out.println("Új Szerző: ");
        Blist.get(1).setSzerzo(scan.next());

        System.out.println("Új tartalom");
        Blist.get(1).setTartalom(scan.next());
    }

    public static void findMostPop() {
        Integer i = 1;
        Bejegyzes max = Blist.get(0);
        while(i != Blist.size() ) {
            if (Blist.get(i).getLikeok() > max.getLikeok()) {
                max = Blist.get(i);
            }
            i++;
        }
        System.out.println("A legnépszerűbb bejegyzes " + max.getLikeok() + " likeot kapott");
    }

    public static void isThereMoreThan35() {
        boolean found = false;
        Integer i = 0;
        String retString = "Nincs 35nél több lajkot kapott bejegyzes";

        while(i != Blist.size() || !found) {
            if (Blist.get(i).getLikeok() > 35) {
                found = true;
                retString = "Van 35nél több lajkot kapott bejegyzes";
            }
            i++;
        }

        System.out.println(retString);
    }
}
