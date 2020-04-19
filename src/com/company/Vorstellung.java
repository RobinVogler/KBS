package com.company;

import java.time.LocalDateTime;
import java.util.ArrayList;

public class Vorstellung {
    private Film film;
    private LocalDateTime zeit;
    private Saal saal;

    public Vorstellung(Film film, LocalDateTime zeit, Saal saal){
        this.film = film;
        this.zeit = zeit;
        this.saal = saal;
    }

    public void absagen(){
        ArrayList<Kunde> clientsWithTicketsToThisVorstellung = new ArrayList<>();

        this.saal.getKino().getTicketsystem().getTickets().forEach(ticket -> {
            if(ticket.getVorstellung().equals(this)){
                if(!clientsWithTicketsToThisVorstellung.contains(ticket.getKunde())){
                    clientsWithTicketsToThisVorstellung.add(ticket.getKunde());
                }
            }
        });

        clientsWithTicketsToThisVorstellung.forEach(client -> this.saal.getKino().getTicketsystem().stornieren(client, this));

        this.saal.getKino().getTicketsystem().getVorstellungen().remove(this);
    }

    public Film getFilm() {
        return film;
    }

    public void setFilm(Film film) {
        this.film = film;
    }

    public LocalDateTime getZeit() {
        return zeit;
    }

    public void setZeit(LocalDateTime zeit) {
        this.zeit = zeit;
    }

    public Saal getSaal() {
        return saal;
    }

    public void setSaal(Saal saal) {
        this.saal = saal;
    }
}
