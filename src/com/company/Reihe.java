package com.company;

import java.util.ArrayList;

public class Reihe {
    private Saal saal;
    private ArrayList<Platz> plaetze = new ArrayList<>();

    Reihe(Saal saal, int plaetze){
        this.saal = saal;
        for(int i = 0; i < plaetze; i++){
            this.plaetze.add(new Platz(this));
        }
    }

    public Platz getPlatzToRightOfPlatz(Platz platz){
        if(platz.getReihe().equals(this)){
            int index = plaetze.indexOf(platz);
            if(index + 1 < this.plaetze.size()){
                return this.plaetze.get(index + 1);
            }
        }
        return null;
    }

    public Platz getPlatzToLeftOfPlatz(Platz platz){
        if(platz.getReihe().equals(this)){
            int index = plaetze.indexOf(platz);
            if(index - 1 > 0){
                return this.plaetze.get(index - 1);
            }
        }
        return null;
    }


    public Saal getSaal() {
        return saal;
    }

    public void setSaal(Saal saal) {
        this.saal = saal;
    }

    public ArrayList<Platz> getPlaetze() {
        return this.plaetze;
    }

    public void setPlaetze(ArrayList<Platz> plaetze) {
        this.plaetze = plaetze;
    }

    public void addPlaetze(Platz platz) {
        this.plaetze.add(platz);
    }

    public void removePlaetze(Platz platz) {
        this.plaetze.remove(platz);
    }
}
