package com.company;

import java.util.ArrayList;

public class Ticketsystem {
    private ArrayList<Ticket> tickets = new ArrayList<Ticket>();
    private ArrayList<Kunde> kunden = new ArrayList<Kunde>();
    private Kino kino;
    private ArrayList<Film> filme = new ArrayList<>();
    private ArrayList<Vorstellung> vorstellungen = new ArrayList<>();

    public Ticketsystem(Kino kino){
        this.kino = kino;
    }

    public void stornieren(Kunde kunde, Vorstellung vorstellung){
        tickets.forEach(ticket ->{
            if(ticket.getVorstellung().equals(vorstellung) && ticket.getKunde().equals(kunde)){
                kunde.getTickets().remove(ticket);
                System.out.println(ticket.getKunde().getName() + " (" + ticket.getKunde().getTelefonnummer() + ") dein ticket für die Vorstellung von " + vorstellung.getFilm().getFilmTitel() + " wurde storniert.");
                tickets.remove(ticket);
            }
        });
    }

    public Platz platzFinden(Kunde kunde, Vorstellung vorstellung){
        for(int i = 0; i < tickets.size(); i++){
            if(tickets.get(i).getVorstellung().equals(vorstellung) && tickets.get(i).getKunde().equals(kunde)){
                return tickets.get(i).getPlatz();
            }
        }
        return null;
    }

    public ArrayList<Ticket> getTickets() {
        return tickets;
    }

    public void setTickets(ArrayList<Ticket> tickets) {
        this.tickets = tickets;
    }

    public void addTicket(Ticket ticket){
        this.tickets.add(ticket);
    }

    public void removeTicket(Ticket ticket){
        this.tickets.remove(ticket);
    }

    public ArrayList<Kunde> getKunden() {
        return kunden;
    }

    public ArrayList<Kunde> getKundenMitName(String name) {
        ArrayList<Kunde> tempKunden = new ArrayList<Kunde>();
        this.kunden.forEach(kunde -> {
            if(kunde.getName().equals(name)){
                tempKunden.add(kunde);
            }
        });
        return tempKunden;
    }

    public ArrayList<Kunde> getKundenMitTelefonnummer(String telefonnummer) {
        ArrayList<Kunde> tempKunden = new ArrayList<Kunde>();
        this.kunden.forEach(kunde -> {
            if(kunde.getTelefonnummer().equals(telefonnummer)){
                tempKunden.add(kunde);
            }
        });
        return tempKunden;
    }

    public void setKunden(ArrayList<Kunde> kunden) {
        this.kunden = kunden;
    }

    public void addKunde(Kunde kunde){
        this.kunden.add(kunde);
    }

    public void removeKunde(Kunde kunde){
        this.kunden.remove(kunde);
    }

    public Kino getKino() {
        return kino;
    }

    public void setKino(Kino kino) {
        this.kino = kino;
    }

    public ArrayList<Film> getFilme() {
        return filme;
    }

    public void setFilme(ArrayList<Film> filme) {
        this.filme = filme;
    }

    public void addFilm(Film film){
        this.filme.add(film);
    }

    public void removeFilm(Film film){
        this.filme.remove(film);
    }

    public ArrayList<Vorstellung> getVorstellungen() {
        return vorstellungen;
    }

    public void setVorstellungen(ArrayList<Vorstellung> vorstellungen) {
        this.vorstellungen = vorstellungen;
    }

    public void addVorstellung(Vorstellung vorstellung){
        this.vorstellungen.add(vorstellung);
    }

    public void removeVorstellung(Vorstellung vorstellung){
        this.vorstellungen.remove(vorstellung);
    }

    public ArrayList<Vorstellung> getVorstellungenMitFilm(Film film) {
        ArrayList<Vorstellung> tempVorstellungen = new ArrayList<>();
        this.vorstellungen.forEach(vorstellung -> {
            if(vorstellung.getFilm().equals(film)){
                tempVorstellungen.add(vorstellung);
            }
        });
        return tempVorstellungen;
    }

    public ArrayList<Vorstellung> getVorstellungenMitSaal(Saal saal) {
        ArrayList<Vorstellung> tempVorstellungen = new ArrayList<>();
        this.vorstellungen.forEach(vorstellung -> {
            if(vorstellung.getSaal().equals(saal)){
                tempVorstellungen.add(vorstellung);
            }
        });
        return tempVorstellungen;
    }
}
