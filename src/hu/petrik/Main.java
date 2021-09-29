package hu.petrik;

import java.util.ArrayList;
import java.util.List;

public class Main {

    static List<Bejegyzes> Blist = new ArrayList<>();

    public static void main(String[] args) {
	    add2();
        System.out.println(Blist);
    }

    public static void add2() {
        Blist.add(new Bejegyzes("Pisti", "Szeretem az almát"));
        Blist.add(new Bejegyzes("Jani", "Szeretem a Banánt"));
    }
}
