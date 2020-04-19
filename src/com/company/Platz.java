package com.company;

public class Platz {
    private Reihe reihe;

    public Platz(Reihe reihe){
        this.reihe = reihe;
    }

    public Reihe getReihe() {
        return reihe;
    }

    public void setReihe(Reihe reihe) {
        this.reihe = reihe;
    }
}
