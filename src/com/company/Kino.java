package com.company;

import java.util.ArrayList;

public class Kino {
    private ArrayList<Saal> saele = new ArrayList<>();
    private Ticketsystem ticketsystem;

    public Kino(ArrayList<ArrayList<Integer>> plaetzeProReiheProSaal){
        ticketsystem = new Ticketsystem(this);
        plaetzeProReiheProSaal.forEach(plaetzeProReihe -> saele.add(new Saal(this, plaetzeProReihe)));
    }

    public ArrayList<Saal> getSaele() {
        return this.saele;
    }

    public void setSaele(ArrayList<Saal> saele) {
        this.saele = saele;
    }

    public void addSaele(Saal saal) {
        this.saele.add(saal);
    }

    public void removeSaele(Saal saal) {
        this.saele.remove(saal);
    }

    public Ticketsystem getTicketsystem() {
        return ticketsystem;
    }

    public void setTicketsystem(Ticketsystem ticketsystem) {
        this.ticketsystem = ticketsystem;
    }
}
