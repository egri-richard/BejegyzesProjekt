package hu.petrik;

import java.time.DateTimeException;
import java.time.LocalDateTime;

public class Bejegyzes {
    private String szerzo;
    private String tartalom;
    private Integer likeok;
    private LocalDateTime letrejott;
    private LocalDateTime szerkesztve;

    Bejegyzes(String szerzo, String tartalom) {
        this.szerzo = szerzo;
        this.tartalom = tartalom;
        this.likeok = 0;
        this.letrejott = LocalDateTime.now();
        this.szerkesztve = LocalDateTime.now();
    }

    public String getSzerzo() {
        return this.szerzo;
    }

    public String getTartalom() {
        return this.tartalom;
    }

    public void setTartalom(String in) {
        this.tartalom = in;
    }

    public Integer getLikeok() {
        return this.likeok;
    }

    public LocalDateTime getLetrejott() {
        return this.letrejott;
    }

    public LocalDateTime getSzerkesztve() {
        return this.szerkesztve;
    }

    public void plusLike() {
        this.likeok++;
    }

    @Override
    public String toString() {
        String retString;
        if (this.szerkesztve == this.letrejott) {
            retString = this.szerzo +" - "+ this.likeok +" - "+this.letrejott +"\n"+
                        this.tartalom;
        } else {
            retString = this.szerzo +" - "+ this.likeok +" - "+this.letrejott +"\n"+
                        "Szerkesztve: " + this.szerkesztve +"\n"+
                        this.tartalom;
        }
        return retString;
    }
}
