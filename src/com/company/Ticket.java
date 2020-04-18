package com.company;

public class Ticket {
    private Kunde kunde;
    private Vorstellung vorstellung;
    private Platz platz;

    public Ticket(Kunde kunde, Vorstellung vorstellung, Platz platz){
        this.kunde = kunde;
        this.vorstellung = vorstellung;
        this.platz = platz;
    }

    public Kunde getKunde() {
        return kunde;
    }

    public void setKunde(Kunde kunde) {
        this.kunde = kunde;
    }

    public Vorstellung getVorstellung() {
        return vorstellung;
    }

    public void setVorstellung(Vorstellung vorstellung) {
        this.vorstellung = vorstellung;
    }

    public Platz getPlatz() {
        return platz;
    }

    public void setPlatz(Platz platz) {
        this.platz = platz;
    }
}
