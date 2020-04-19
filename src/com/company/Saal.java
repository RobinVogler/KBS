package com.company;

import java.util.ArrayList;

public class Saal {
    private Kino kino;
    private ArrayList<Reihe> reihen = new ArrayList<Reihe>();

    public Saal(Kino kino, ArrayList<Integer> plaetzeProReihe){
        this.kino = kino;
        plaetzeProReihe.forEach(reihenLaenge -> reihen.add(new Reihe(this, reihenLaenge)));
    }

    public Kino getKino() {
        return kino;
    }

    public void setKino(Kino kino) {
        this.kino = kino;
    }

    public ArrayList<Reihe> getReihen(){
        return reihen;
    }

    public void setReihen(ArrayList<Reihe> reihen){
        this.reihen = reihen;
    }

    public void addReihe(Reihe reihe){
        this.reihen.add(reihe);
    }

    public void addReihe(Integer plaetzeInReihe){
        this.reihen.add(new Reihe(this, plaetzeInReihe));
    }
}
