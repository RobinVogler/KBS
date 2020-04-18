package com.company;

import java.util.ArrayList;

public class Kunde {
    private String name;
    private String telefonnummer;
    private ArrayList<Ticket> tickets;
    private ArrayList<Kino> kinos;

    public Kunde(String name, String telefonnummer){
        this.name = name;
        this.telefonnummer = telefonnummer;
    }

    public boolean platzReservieren(Vorstellung vorstellung){
        ArrayList<Platz> freiePlaetze = new ArrayList<>();
        vorstellung.getSaal().getReihen().forEach(reihe -> {
            freiePlaetze.addAll(reihe.getPlaetze());
        });

        Ticketsystem ticketsystem = vorstellung.getSaal().getKino().getTicketsystem();
        ArrayList<Ticket> allTickets = ticketsystem.getTickets();

        allTickets.forEach(ticket -> {
            if(ticket.getVorstellung().equals(vorstellung)){
                freiePlaetze.remove(ticket.getPlatz());
            }
        });

        if(freiePlaetze.size() > 0){
            Ticket newTicket = new Ticket(this, vorstellung, freiePlaetze.get(0));
            ticketsystem.addTicket(newTicket);
            addTicket(newTicket);
            return true;
        }
        else{
            return false;
        }
    }

    public boolean plaetzeReservieren(Vorstellung vorstellung, int anzahlPersonen, boolean nebeneinander){
        ArrayList<Platz> freiePlaetze = new ArrayList<>();
        vorstellung.getSaal().getReihen().forEach(reihe -> {
            freiePlaetze.addAll(reihe.getPlaetze());
        });

        Ticketsystem ticketsystem = vorstellung.getSaal().getKino().getTicketsystem();
        ArrayList<Ticket> allTickets = ticketsystem.getTickets();

        allTickets.forEach(ticket -> {
            if(ticket.getVorstellung().equals(vorstellung)){
                freiePlaetze.remove(ticket.getPlatz());
            }
        });

        if(!nebeneinander){
            if(freiePlaetze.size() > anzahlPersonen - 1 && freiePlaetze.size() > 0){
                for(int i = 0; i < anzahlPersonen; i++){
                    Ticket newTicket = new Ticket(this, vorstellung, freiePlaetze.get(i));
                    ticketsystem.addTicket(newTicket);
                    addTicket(newTicket);
                }
                return true;
            }
            else{
                return false;
            }
        }
        else{
            ArrayList<ArrayList<Platz>> listOfNebeneinanderliegendePlaetze = new ArrayList<>();
            ArrayList<Platz> hinzugefügtePlaetze = new ArrayList<>();

            freiePlaetze.forEach(startPlatz -> {
                if(!hinzugefügtePlaetze.contains(startPlatz)){
                    Platz currentPlatz = startPlatz;

                    while(freiePlaetze.contains(currentPlatz.getReihe().getPlatzToLeftOfPlatz(currentPlatz))){
                        currentPlatz = currentPlatz.getReihe().getPlatzToLeftOfPlatz(currentPlatz);
                    }

                    ArrayList<Platz> currentNebeneinanderliegendePlaetze = new ArrayList<>();
                    currentNebeneinanderliegendePlaetze.add(currentPlatz);
                    hinzugefügtePlaetze.add(currentPlatz);

                    while(freiePlaetze.contains(currentPlatz.getReihe().getPlatzToRightOfPlatz(currentPlatz))){
                        currentPlatz = currentPlatz.getReihe().getPlatzToLeftOfPlatz(currentPlatz);
                        currentNebeneinanderliegendePlaetze.add(currentPlatz);
                        hinzugefügtePlaetze.add(currentPlatz);
                    }
                    listOfNebeneinanderliegendePlaetze.add(currentNebeneinanderliegendePlaetze);
                }
            });

            ArrayList<Platz> smallestPossiblePlaetzeList = new ArrayList<>();

            for(int i = 0; i < listOfNebeneinanderliegendePlaetze.size(); i++){
                if(listOfNebeneinanderliegendePlaetze.get(i).size() >= anzahlPersonen && smallestPossiblePlaetzeList.size() == 0){
                    smallestPossiblePlaetzeList = listOfNebeneinanderliegendePlaetze.get(i);
                }
                else if(listOfNebeneinanderliegendePlaetze.get(i).size() >= anzahlPersonen && listOfNebeneinanderliegendePlaetze.get(i).size() < smallestPossiblePlaetzeList.size()){
                    smallestPossiblePlaetzeList = listOfNebeneinanderliegendePlaetze.get(i);
                }
            }

            if(smallestPossiblePlaetzeList.size() > anzahlPersonen){
                smallestPossiblePlaetzeList.forEach(platz -> {
                    Ticket newTicket = new Ticket(this, vorstellung, platz);
                    ticketsystem.addTicket(newTicket);
                    addTicket(newTicket);
                });
                return true;
            }
            return false;
        }
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTelefonnummer() {
        return telefonnummer;
    }

    public void setTelefonnummer(String telefonnummer) {
        this.telefonnummer = telefonnummer;
    }

    public ArrayList<Ticket> getTickets() {
        return tickets;
    }

    public void setTickets(ArrayList<Ticket> tickets) {
        this.tickets = tickets;
    }

    public void addTicket(Ticket ticket) {
        this.tickets.add(ticket);
    }

    public void removeTicket(Ticket ticket) {
        this.tickets.remove(ticket);
    }

    public ArrayList<Kino> getKinos() {
        return kinos;
    }

    public void setKinos(ArrayList<Kino> kinos) {
        this.kinos = kinos;
    }

    public void addKino(Kino kino) {
        this.kinos.add(kino);
    }

    public void removeKino(Kino kino) {
        this.kinos.remove(kino);
    }
}
