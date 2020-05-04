package com.company;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;

class UnitTest {
    //Film Tests
    private Film film = new Film("testtitel", 42.5, "testbeschreibung", "deutsch");

    @Test
    public void getFilmTitel() throws Exception{
        assertEquals("testtitel", film.getFilmTitel());
    }
    @Test
    public void getFilmDauerInMinuten() throws Exception{
        assertEquals(42.5, film.getFilmDauerInMinuten(), 0.001);
    }
    @Test
    public void getFilmBeschreibung() {
        assertEquals("testbeschreibung", film.getFilmBeschreibung());
    }
    @Test
    public void getFilmSprache() {
        assertEquals("deutsch", film.getFilmSprache());
    }

    //Kino Tests
    @Test
    public void getSaele() {
        Kino kino = new Kino(new ArrayList<ArrayList<Integer>>(Arrays.asList(new ArrayList<Integer>(Arrays.asList(1, 4, 5)))));
        assertEquals(1, kino.getSaele().get(0).getReihen().get(0).getPlaetze().size());
    }
    @Test
    public void addSaele() {
        Kino kino = new Kino(new ArrayList<ArrayList<Integer>>(Arrays.asList(new ArrayList<Integer>(Arrays.asList(1, 4, 5)))));
        Saal saal2 = new Saal(kino, new ArrayList<Integer>(Arrays.asList(6)));
        kino.addSaele(saal2);
        assertTrue(kino.getSaele().contains(saal2));
    }
    @Test
    public void removeSaele() {
        Kino kino = new Kino(new ArrayList<ArrayList<Integer>>());
        Saal saal2 = new Saal(kino, new ArrayList<Integer>(Arrays.asList(6)));
        kino.setSaele(new ArrayList<Saal> (Arrays.asList(saal2)));
        kino.removeSaele(saal2);
        assertFalse(kino.getSaele().contains(saal2));
    }

    //Platz Tests
    @Test
    public void getReihe() {
        Kino kino = new Kino(new ArrayList<ArrayList<Integer>>(Arrays.asList(new ArrayList<Integer>(Arrays.asList(1, 4, 5)))));
        Saal saal2 = new Saal(kino, new ArrayList<Integer>(Arrays.asList(6)));
        Reihe reihe = new Reihe(saal2, 1);
        Platz platz = new Platz(reihe);
        reihe.addPlatz(platz);
        assertEquals(reihe, platz.getReihe());
    }

    //Reihe Tests
    @Test
    public void getPlatzToRightOfPlatz(){
        Kino kino = new Kino(new ArrayList<ArrayList<Integer>>(Arrays.asList(new ArrayList<Integer>(Arrays.asList(1, 4, 5)))));
        assertEquals(kino.getSaele().get(0).getReihen().get(1).getPlaetze().get(1), kino.getSaele().get(0).getReihen().get(1).getPlatzToRightOfPlatz(kino.getSaele().get(0).getReihen().get(1).getPlaetze().get(0)));
    }
    @Test
    public void getPlatzToLeftOfPlatz(){
        Kino kino = new Kino(new ArrayList<ArrayList<Integer>>(Arrays.asList(new ArrayList<Integer>(Arrays.asList(1, 4, 5)))));
        assertEquals(kino.getSaele().get(0).getReihen().get(1).getPlaetze().get(2), kino.getSaele().get(0).getReihen().get(1).getPlatzToLeftOfPlatz(kino.getSaele().get(0).getReihen().get(1).getPlaetze().get(3)));
    }
    @Test
    public void getSaal1() {
        Kino kino = new Kino(new ArrayList<ArrayList<Integer>>(Arrays.asList(new ArrayList<Integer>(Arrays.asList(1, 4, 5)))));
        assertEquals(kino.getSaele().get(0), kino.getSaele().get(0).getReihen().get(0).getSaal());
    }
    @Test
    public void getPlaetze() {
        Kino kino = new Kino(new ArrayList<ArrayList<Integer>>(Arrays.asList(new ArrayList<Integer>(Arrays.asList(1, 4, 5)))));
        assertEquals(5, kino.getSaele().get(0).getReihen().get(2).getPlaetze().size());
    }
    @Test
    public void addPlaetze() {
        Kino kino = new Kino(new ArrayList<ArrayList<Integer>>(Arrays.asList(new ArrayList<Integer>(Arrays.asList(1, 4, 5)))));
        Platz platz = new Platz(kino.getSaele().get(0).getReihen().get(2));
        kino.getSaele().get(0).getReihen().get(2).addPlatz(platz);
        assertTrue(kino.getSaele().get(0).getReihen().get(2).getPlaetze().contains(platz));
    }
    @Test
    public void removePlaetze() {
        Kino kino = new Kino(new ArrayList<ArrayList<Integer>>(Arrays.asList(new ArrayList<Integer>(Arrays.asList(1, 4, 5)))));
        Platz platz = kino.getSaele().get(0).getReihen().get(2).getPlaetze().get(3);
        kino.getSaele().get(0).getReihen().get(2).removePlatz(platz);
        assertFalse(kino.getSaele().get(0).getReihen().get(2).getPlaetze().contains(platz));
    }

    //Saal Tests
    @Test
    public void getKino() {
        Kino kino = new Kino(new ArrayList<ArrayList<Integer>>(Arrays.asList(new ArrayList<Integer>(Arrays.asList(1, 4, 5)))));
        Saal saal2 = new Saal(kino, new ArrayList<Integer>(Arrays.asList(6)));
        assertEquals(kino, saal2.getKino());
    }
    @Test
    public void getReihen(){
        Kino kino = new Kino(new ArrayList<ArrayList<Integer>>(Arrays.asList(new ArrayList<Integer>(Arrays.asList(1, 4, 5)))));
        assertEquals(3, kino.getSaele().get(0).getReihen().size());
    }
    @Test
    public void addReihe(){
        Kino kino = new Kino(new ArrayList<ArrayList<Integer>>(Arrays.asList(new ArrayList<Integer>(Arrays.asList(1, 4, 5)))));
        Reihe reihe = new Reihe(kino.getSaele().get(0), 7);
        kino.getSaele().get(0).addReihe(reihe);
        assertEquals(reihe, kino.getSaele().get(0).getReihen().get(3));
    }
    @Test
    public void addReihe2(){
        Kino kino = new Kino(new ArrayList<ArrayList<Integer>>(Arrays.asList(new ArrayList<Integer>(Arrays.asList(1, 4, 5)))));
        kino.getSaele().get(0).addReihe(8);
        assertEquals(4, kino.getSaele().get(0).getReihen().size());
    }

    //Ticket Tests
    @Test
    public void getKunde() {
        Kunde kunde = new Kunde("kunde", "kundeTel");
        Film film = new Film("ANIME", 5485486.456, "HUIIII", "Japanese");
        Kino kino = new Kino(new ArrayList<ArrayList<Integer>>(Arrays.asList(new ArrayList<Integer>(Arrays.asList(1, 4, 5)))));
        Vorstellung vorstellung = new Vorstellung(film, LocalDateTime.now(), kino.getSaele().get(0));
        Ticket ticket = new Ticket(kunde, vorstellung, kino.getSaele().get(0).getReihen().get(0).getPlaetze().get(0));
        assertEquals(kunde, ticket.getKunde());
    }
    @Test
    public void getVorstellung() {
        Kunde kunde = new Kunde("kunde", "kundeTel");
        Film film = new Film("ANIME", 5485486.456, "HUIIII", "Japanese");
        Kino kino = new Kino(new ArrayList<ArrayList<Integer>>(Arrays.asList(new ArrayList<Integer>(Arrays.asList(1, 4, 5)))));
        Vorstellung vorstellung = new Vorstellung(film, LocalDateTime.now(), kino.getSaele().get(0));
        Ticket ticket = new Ticket(kunde, vorstellung, kino.getSaele().get(0).getReihen().get(0).getPlaetze().get(0));
        assertEquals(vorstellung, ticket.getVorstellung());
    }
    @Test
    public void getPlatz() {
        Kunde kunde = new Kunde("kunde", "kundeTel");
        Film film = new Film("ANIME", 5485486.456, "HUIIII", "Japanese");
        Kino kino = new Kino(new ArrayList<ArrayList<Integer>>(Arrays.asList(new ArrayList<Integer>(Arrays.asList(1, 4, 5)))));
        Vorstellung vorstellung = new Vorstellung(film, LocalDateTime.now(), kino.getSaele().get(0));
        Ticket ticket = new Ticket(kunde, vorstellung, kino.getSaele().get(0).getReihen().get(0).getPlaetze().get(0));
        assertEquals(kino.getSaele().get(0).getReihen().get(0).getPlaetze().get(0), ticket.getPlatz());
    }

    //Ticketsystem Tests
    @Test
    public void getTickets() {
        Kunde kunde = new Kunde("kunde", "kundeTel");
        Film film = new Film("ANIME", 5485486.456, "HUIIII", "Japanese");
        Kino kino = new Kino(new ArrayList<ArrayList<Integer>>(Arrays.asList(new ArrayList<Integer>(Arrays.asList(1, 4, 5)))));
        Vorstellung vorstellung = new Vorstellung(film, LocalDateTime.now(), kino.getSaele().get(0));
        Ticket ticket = new Ticket(kunde, vorstellung, kino.getSaele().get(0).getReihen().get(0).getPlaetze().get(0));
        kino.getTicketsystem().addTicket(ticket);
        assertTrue(kino.getTicketsystem().getTickets().contains(ticket));
    }
    @Test
    public void getKunden() {
        Kunde kunde = new Kunde("kunde", "kundeTel");
        Kino kino = new Kino(new ArrayList<ArrayList<Integer>>(Arrays.asList(new ArrayList<Integer>(Arrays.asList(1, 4, 5)))));
        kino.getTicketsystem().addKunde(kunde);
        assertTrue(kino.getTicketsystem().getKunden().contains(kunde));
    }
    @Test
    public void getKundenMitName() {
        Kunde kunde = new Kunde("kunde", "kundeTel");
        Kino kino = new Kino(new ArrayList<ArrayList<Integer>>(Arrays.asList(new ArrayList<Integer>(Arrays.asList(1, 4, 5)))));
        kino.getTicketsystem().addKunde(kunde);
        assertEquals(1, kino.getTicketsystem().getKundenMitName("kunde").size());
    }
    @Test
    public void getKundenMitTelefonnummer() {
        Kunde kunde = new Kunde("kunde", "kundeTel");
        Kino kino = new Kino(new ArrayList<ArrayList<Integer>>(Arrays.asList(new ArrayList<Integer>(Arrays.asList(1, 4, 5)))));
        kino.getTicketsystem().addKunde(kunde);
        assertEquals(1, kino.getTicketsystem().getKundenMitTelefonnummer("kundeTel").size());
    }

    @Test
    public void getKino1() {
        Kino kino = new Kino(new ArrayList<ArrayList<Integer>>(Arrays.asList(new ArrayList<Integer>(Arrays.asList(1, 4, 5)))));
        assertEquals(kino, kino.getTicketsystem().getKino());
    }
    @Test
    public void getVorstellungen() {
        Kunde kunde = new Kunde("kunde", "kundeTel");
        Film film = new Film("ANIME", 5485486.456, "HUIIII", "Japanese");
        Kino kino = new Kino(new ArrayList<ArrayList<Integer>>(Arrays.asList(new ArrayList<Integer>(Arrays.asList(1, 4, 5)))));
        Vorstellung vorstellung = new Vorstellung(film, LocalDateTime.now(), kino.getSaele().get(0));
        kino.getTicketsystem().addVorstellung(vorstellung);
        assertTrue(kino.getTicketsystem().getVorstellungen().contains(vorstellung));
    }
    @Test
    public void addVorstellung(){
        Kunde kunde = new Kunde("kunde", "kundeTel");
        Film film = new Film("ANIME", 5485486.456, "HUIIII", "Japanese");
        Kino kino = new Kino(new ArrayList<ArrayList<Integer>>(Arrays.asList(new ArrayList<Integer>(Arrays.asList(1, 4, 5)))));
        Vorstellung vorstellung = new Vorstellung(film, LocalDateTime.now(), kino.getSaele().get(0));
        kino.getTicketsystem().addVorstellung(vorstellung);
        assertTrue(kino.getTicketsystem().getVorstellungen().contains(vorstellung));
    }
    @Test
    public void removeVorstellung(){
        Kunde kunde = new Kunde("kunde", "kundeTel");
        Film film = new Film("ANIME", 5485486.456, "HUIIII", "Japanese");
        Kino kino = new Kino(new ArrayList<ArrayList<Integer>>(Arrays.asList(new ArrayList<Integer>(Arrays.asList(1, 4, 5)))));
        Vorstellung vorstellung = new Vorstellung(film, LocalDateTime.now(), kino.getSaele().get(0));
        kino.getTicketsystem().removeVorstellung(vorstellung);
        assertFalse(kino.getTicketsystem().getVorstellungen().contains(vorstellung));
    }
    @Test
    public void getVorstellungenMitFilm() {
        Kunde kunde = new Kunde("kunde", "kundeTel");
        Film film = new Film("ANIME", 5485486.456, "HUIIII", "Japanese");
        Kino kino = new Kino(new ArrayList<ArrayList<Integer>>(Arrays.asList(new ArrayList<Integer>(Arrays.asList(1, 4, 5)))));
        Vorstellung vorstellung = new Vorstellung(film, LocalDateTime.now(), kino.getSaele().get(0));
        kino.getTicketsystem().addVorstellung(vorstellung);
        assertEquals(1, kino.getTicketsystem().getVorstellungenMitFilm(film).size());
    }
    @Test
    public void getVorstellungenMitSaal() {
        Kunde kunde = new Kunde("kunde", "kundeTel");
        Film film = new Film("ANIME", 5485486.456, "HUIIII", "Japanese");
        Kino kino = new Kino(new ArrayList<ArrayList<Integer>>(Arrays.asList(new ArrayList<Integer>(Arrays.asList(1, 4, 5)))));
        Vorstellung vorstellung = new Vorstellung(film, LocalDateTime.now(), kino.getSaele().get(0));
        kino.getTicketsystem().addVorstellung(vorstellung);
        assertEquals(1, kino.getTicketsystem().getVorstellungenMitSaal(kino.getSaele().get(0)).size());
    }

    //Vorstellung Tests

    @Test
    public void absagen(){
        Kunde kunde = new Kunde("kunde", "kundeTel");
        Film film = new Film("ANIME", 5485486.456, "HUIIII", "Japanese");
        Kino kino = new Kino(new ArrayList<ArrayList<Integer>>(Arrays.asList(new ArrayList<Integer>(Arrays.asList(1, 4, 5)))));
        Vorstellung vorstellung = new Vorstellung(film, LocalDateTime.now(), kino.getSaele().get(0));
        Ticket ticket = new Ticket(kunde, vorstellung, kino.getSaele().get(0).getReihen().get(0).getPlaetze().get(0));
        vorstellung.absagen();
        assertFalse(kino.getTicketsystem().getTickets().contains(ticket));
    }
    @Test
    public void getFilm() {
        Film film = new Film("ANIME", 5485486.456, "HUIIII", "Japanese");
        Kino kino = new Kino(new ArrayList<ArrayList<Integer>>(Arrays.asList(new ArrayList<Integer>(Arrays.asList(1, 4, 5)))));
        Vorstellung vorstellung = new Vorstellung(film, LocalDateTime.now(), kino.getSaele().get(0));
        assertEquals(film, vorstellung.getFilm());
    }
    @Test
    public void getZeit() {
        LocalDateTime ldt= LocalDateTime.now();
        Film film = new Film("ANIME", 5485486.456, "HUIIII", "Japanese");
        Kino kino = new Kino(new ArrayList<ArrayList<Integer>>(Arrays.asList(new ArrayList<Integer>(Arrays.asList(1, 4, 5)))));
        Vorstellung vorstellung = new Vorstellung(film, ldt, kino.getSaele().get(0));
        assertEquals(ldt, vorstellung.getZeit());
    }
    @Test
    public void getSaal() {
        Film film = new Film("ANIME", 5485486.456, "HUIIII", "Japanese");
        Kino kino = new Kino(new ArrayList<ArrayList<Integer>>(Arrays.asList(new ArrayList<Integer>(Arrays.asList(1, 4, 5)))));
        Vorstellung vorstellung = new Vorstellung(film, LocalDateTime.now(), kino.getSaele().get(0));
        assertEquals(kino.getSaele().get(0), vorstellung.getSaal());
    }
}