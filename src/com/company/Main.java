package com.company;
import java.util.ArrayList;
import java.util.Scanner;
import java.time.LocalDateTime;

public class Main {
    public static void main(String[] args) {
        ArrayList<Kino> kinos = new ArrayList<>();
        ArrayList<Film> filme = new ArrayList<>();
        ArrayList<Kunde> kunden = new ArrayList<>();
        ArrayList<Vorstellung> vorstellungen = new ArrayList<>();
        ArrayList<Ticket> tickets = new ArrayList<>();
        boolean verlassen = false;
        Scanner scanner = new Scanner(System.in);
        int auswahl;

        while(!verlassen){
            System.out.println("[1] Neues Kino erstellen\n[2] Kino entfernen\n[3] Kino bearbeiten\n[4] Neuen Film erstellen\n[5] Film bearbeiten\n[6] Film löschen\n[7] Neue Vorstellung erstellen\n[8] Vorstellung bearbeiten\n[9] Vorstellung löschen\n[10] Vorstellung finden\n[11] Neuer Kunde estellen\n[12] Kunde bearbeiten\n[13] Kunde löschen\n[14] Kunde finden\n[15] Reservieren\n[16] Stornieren\n[17] Neues Ticket esrtellen\n[18] Programm Schliessen");
            auswahl = Integer.parseInt(scanner.nextLine());
            switch (auswahl){
                case 1:// kino erstellen
                    ArrayList<ArrayList<Integer>> plaetzeProReiheProSaal = new ArrayList<>();
                    System.out.println("Geben sie anzahl Saele ein: ");
                    int anzahlSaele = Integer.parseInt(scanner.nextLine());
                    for(int i = 0; i < anzahlSaele; i++) {
                        ArrayList<Integer> plaetzeProReihe = new ArrayList<>();
                        System.out.println("Geben sie anzahl Reihen für Saal " + (i+1) + " ein: ");
                        int anzahlReihen = Integer.parseInt(scanner.nextLine());
                        for(int j = 0; j < anzahlReihen; j++){
                            System.out.println("Geben sie anzahl Plaetze für Reihe " + (j+1) + " von Saal " + (i+1) + " ein: ");
                            int anzahlPlaetze = Integer.parseInt(scanner.nextLine());
                            if(anzahlPlaetze <= 0){
                                System.out.println("Es können nicht 0 oder weniger Plätze pro Reihe gewählt werden");
                                j--;
                                continue;
                            }
                            plaetzeProReihe.add(anzahlPlaetze);
                        }
                        plaetzeProReiheProSaal.add(plaetzeProReihe);
                    }
                    kinos.add(new Kino(plaetzeProReiheProSaal));
                    break;
                case 2://kino löschen
                    System.out.println("Möchten sie ein Kino entfernen[Y/N]");
                    String ja = scanner.nextLine();
                    if(ja.toUpperCase().equals("Y")){
                        for(int i = 0; i < kinos.size(); i++){
                            System.out.println("[" + (i+1) + "]\n" +
                                    "Kino: " + (i+1) + "\n" +
                                    "Anzahl Säle: " + kinos.get(i).getSaele().size() + "\n" +
                                    "-------------------------------------------------------------");
                        }
                        System.out.println("Wählen sie ein Kino aus der Liste");
                        int entferntesKino = Integer.parseInt(scanner.nextLine());
                        entferntesKino -= 1;
                        if(kinos.size() >= entferntesKino + 1) {
                            kinos.remove(entferntesKino);
                        }
                    }
                    break;
                case 3://Kino bearbeiten
                    System.out.println("Möchten sie ein Kino bearbeiten[Y/N]");
                    String ja2 = scanner.nextLine();
                    if(ja2.toUpperCase().equals("Y")) {
                        for (int i = 0; i < kinos.size(); i++) {
                            System.out.println("[" + (i + 1) + "]\n" +
                                    "Kino: " + (i + 1) + "\n" +
                                    "Anzahl Säle: " + kinos.get(i).getSaele().size() + "\n" +
                                    "-------------------------------------------------------------");
                        }
                        System.out.println("Wählen sie ein Kino aus der Liste");
                        int gewaehlteskino = Integer.parseInt(scanner.nextLine());
                        gewaehlteskino -= 1;
                        System.out.println("[1] Saal hinzufügen\n[2] Saal entfernen\n[3] Saal bearbeiten\n[4] abbrechen");
                        int gewaehlteauswahl = Integer.parseInt(scanner.nextLine());
                        switch(gewaehlteauswahl){
                            case 1:
                                ArrayList<Integer> platzproreihe = new ArrayList<>();
                                System.out.println("Geben sie anzahl Reihen ein");
                                int anzahlreihen = Integer.parseInt(scanner.nextLine());
                                for(int i = 0; i < anzahlreihen; i++){
                                    System.out.println("Geben sie anzahl Plaetze für Reihe " + (i+1) + " ein: ");
                                    int anzahlplaetze = Integer.parseInt(scanner.nextLine());
                                    platzproreihe.add(anzahlplaetze);
                                }
                                kinos.get(gewaehlteskino).addSaele(new Saal(kinos.get(gewaehlteskino),platzproreihe));
                                break;
                            case 2:
                                for(int i = 0; i < kinos.get(gewaehlteskino).getSaele().size(); i++){
                                    System.out.println("[" + (i+1) + "]\n" +
                                            "Saal: "+ (i+1) + "\n" +
                                            "anzahl Reihen: " + kinos.get(gewaehlteskino).getSaele().get(i).getReihen().size() + "\n" +
                                            "-------------------------------------------------------------");
                                }
                                System.out.println("Wählen sie einen Saal aus der Liste welchen sie entfernen möchten");
                                int gewaehltersaal = Integer.parseInt(scanner.nextLine());
                                gewaehltersaal -= 1;
                                if(kinos.get(gewaehlteskino).getSaele().size() >= gewaehltersaal + 1){
                                    kinos.get(gewaehlteskino).removeSaele(kinos.get(gewaehlteskino).getSaele().get(gewaehltersaal));
                                }
                                break;
                            case 3:
                                for(int i = 0; i < kinos.get(gewaehlteskino).getSaele().size(); i++){
                                    System.out.println("[" + (i+1) + "]\n" +
                                            "Saal "+ (i+1) + "\n" +
                                            "anzahl Reihen: " + kinos.get(gewaehlteskino).getSaele().get(i).getReihen().size() + "\n" +
                                            "-------------------------------------------------------------");
                                }
                                System.out.println("Wählen sie einen Saal aus der Liste");
                                int gewaehltersaal2 = Integer.parseInt(scanner.nextLine());
                                gewaehltersaal2 -= 1;
                                System.out.println("[1] Reihe hinzufügen\n[2] Reihe entfernen\n[3] Reihe bearbeiten\n[4] abbrechen");
                                int gewaehlteauswahl2 = Integer.parseInt(scanner.nextLine());
                                switch(gewaehlteauswahl2){
                                    case 1:
                                        System.out.println("Geben sie anzahl plätze ein");
                                        int anzahlplaetze = Integer.parseInt(scanner.nextLine());
                                        kinos.get(gewaehlteskino).getSaele().get(gewaehltersaal2).addReihe(new Reihe(kinos.get(gewaehlteskino).getSaele().get(gewaehltersaal2), anzahlplaetze));
                                        break;
                                    case 2:
                                        for(int i = 0; i < kinos.get(gewaehlteskino).getSaele().get(gewaehltersaal2).getReihen().size(); i++) {
                                            System.out.println("[" + (i + 1) + "]\n" +
                                                    "Reihennummer: " + (i + 1) + "\n" +
                                                    "Anzahl Plätze: " + kinos.get(gewaehlteskino).getSaele().get(gewaehltersaal2).getReihen().get(i).getPlaetze().size() + "\n" +
                                                    "-------------------------------------------------------------");
                                        }
                                        System.out.println("Wählen sie eine Reihe aus der Liste welche sie entfernen möchten");
                                        int gewaehltereihe = Integer.parseInt(scanner.nextLine());
                                        gewaehltereihe -= 1;
                                        if(kinos.get(gewaehlteskino).getSaele().get(gewaehltersaal2).getReihen().size() >= gewaehltereihe + 1){
                                            kinos.get(gewaehlteskino).getSaele().get(gewaehltersaal2).removeReihe(kinos.get(gewaehlteskino).getSaele().get(gewaehltersaal2).getReihen().get(gewaehltereihe));
                                        }
                                        break;
                                    case 3:
                                        for(int i = 0; i < kinos.get(gewaehlteskino).getSaele().get(gewaehltersaal2).getReihen().size(); i++) {
                                            System.out.println("[" + (i + 1) + "]\n" +
                                                    "Reihennummer: " + (i + 1) + "\n" +
                                                    "Anzahl Plätze: " + kinos.get(gewaehlteskino).getSaele().get(gewaehltersaal2).getReihen().get(i).getPlaetze().size() + "\n" +
                                                    "-------------------------------------------------------------");
                                        }
                                        System.out.println("Wählen sie eine Reihe aus der Liste");
                                        int gewaehltereihe2 = Integer.parseInt(scanner.nextLine());
                                        gewaehltereihe2 -= 1;
                                        System.out.println("[1] Platz hinzufügen\n[2] Platz entfernen\n[3] abbrechen");
                                        int gewaehlteauswahl3 = Integer.parseInt(scanner.nextLine());
                                        switch(gewaehlteauswahl3){
                                            case 1:
                                                System.out.println("Wie viele Plätze möchten sie hinzufügen");
                                                int anzahlneueplaetze = Integer.parseInt(scanner.nextLine());
                                                for(int i = 0; i < anzahlneueplaetze; i++) {
                                                    kinos.get(gewaehlteskino).getSaele().get(gewaehltersaal2).getReihen().get(gewaehltereihe2).addPlatz(new Platz(kinos.get(gewaehlteskino).getSaele().get(gewaehltersaal2).getReihen().get(gewaehltereihe2)));
                                                }
                                                break;
                                            case 2:
                                                for(int i = 0; i < kinos.get(gewaehlteskino).getSaele().get(gewaehltersaal2).getReihen().get(gewaehltereihe2).getPlaetze().size(); i++){
                                                    System.out.println("[" + (i + 1) + "]\n" +
                                                            "Platznummer: " + (i + 1) + "\n" +
                                                            "gehört zu Reihe: " + kinos.get(gewaehlteskino).getSaele().get(gewaehltersaal2).getReihen().get(gewaehltereihe2) + "\n" +
                                                            "-------------------------------------------------------------");
                                                }
                                                System.out.println("Wählen sie einen Platz aus der Liste welchen sie entfernen möchten");
                                                int gewaehlterplatz = Integer.parseInt(scanner.nextLine());
                                                gewaehlterplatz -= 1;
                                                if(kinos.get(gewaehlteskino).getSaele().get(gewaehltersaal2).getReihen().get(gewaehltereihe2).getPlaetze().size() >= gewaehlterplatz + 1){
                                                    kinos.get(gewaehlteskino).getSaele().get(gewaehltersaal2).getReihen().get(gewaehltereihe2).removePlatz(kinos.get(gewaehlteskino).getSaele().get(gewaehltersaal2).getReihen().get(gewaehltereihe2).getPlaetze().get(gewaehlterplatz));
                                                }
                                                break;
                                            default:
                                                break;
                                        }
                                        break;
                                    default:
                                        break;
                                }
                                break;
                            default:
                                break;
                        }
                    }

                    break;
                case 4://Film erstellen
                    scanner.nextLine();
                    System.out.println("Geben sie Einen Filmtitel ein: ");
                    String filmTitel = scanner.nextLine();
                    System.out.println("Geben sie die Filmdauer in Minuten ein: ");
                    double filmDauerInMinuten = scanner.nextDouble();

                    scanner.nextLine();
                    System.out.println("Geben sie Eine Filmbeschreibung ein: ");
                    String filmBeschreibung = scanner.nextLine();
                    System.out.println("Geben sie Die Filmsprache ein: ");
                    String filmSprache = scanner.nextLine();
                    filme.add(new Film(filmTitel,filmDauerInMinuten,filmBeschreibung,filmSprache));
                    break;
                case 5://Film bearbeiten
                    System.out.println("Möchten sie einen Film bearbeiten[Y/N]");
                    String ja3 = scanner.nextLine();
                    if(ja3.toUpperCase().equals("Y")){
                        for(int i = 0; i < filme.size(); i++){
                            System.out.println("["+(i+1)+"]\n" +
                                    "Filmtitel: " + filme.get(i).getFilmTitel() + "\n" +
                                    "Filmdauer: " + filme.get(i).getFilmDauerInMinuten() + " Minuten" + "\n" +
                                    "Filmsprache: " + filme.get(i).getFilmSprache()+ "\n" +
                                    "-------------------------------------------------------------");
                        }
                        System.out.println("Wählen sie einen Film aus der Liste");
                        int gewaehlterfilm = Integer.parseInt(scanner.nextLine());
                        gewaehlterfilm -= 1;
                        System.out.println("Aktueller Filmtitel: \n" + filme.get(gewaehlterfilm).getFilmTitel());
                        System.out.println("Neuer Filmtitel[Y/N]");
                        String ja4 = scanner.nextLine();
                        if(ja4.toUpperCase().equals("Y")){
                            System.out.println("Geben sie den neuen Filmtitel ein");
                            String filmtitel = scanner.nextLine();
                            filme.get(gewaehlterfilm).setFilmTitel(filmtitel);
                        }

                        System.out.println("Aktuelle Filmdauer: \n" + filme.get(gewaehlterfilm).getFilmDauerInMinuten());
                        System.out.println("Neue Filmdauer[Y/N]");
                        String ja5 = scanner.nextLine();
                        if(ja5.toUpperCase().equals("Y")){
                            System.out.println("Geben sie die neue Filmdauer ein(in Minuten)");
                            double filmdauer = scanner.nextDouble();
                            filme.get(gewaehlterfilm).setFilmDauerInMinuten(filmdauer);
                        }

                        System.out.println("Aktuelle FilmSprache: \n" + filme.get(gewaehlterfilm).getFilmSprache());
                        System.out.println("Neue Filmsprache[Y/N]");
                        String ja6 = scanner.nextLine();
                        if(ja6.toUpperCase().equals("Y")){
                            System.out.println("Geben sie die neue Filmsprache ein");
                            String filmsprache = scanner.nextLine();
                            filme.get(gewaehlterfilm).setFilmSprache(filmsprache);
                        }

                        System.out.println("Aktuelle Filmbeschreibung: \n" + filme.get(gewaehlterfilm).getFilmBeschreibung());
                        System.out.println("Neue Filmbeschreibung[Y/N]");
                        String ja7 = scanner.nextLine();
                        if(ja7.toUpperCase().equals("Y")){
                            System.out.println("Geben sie die neue Filmbeschreibung ein");
                            String filmsprache = scanner.nextLine();
                            filme.get(gewaehlterfilm).setFilmSprache(filmsprache);
                        }
                    }
                    break;
                case 6://Film löschen
                    System.out.println("Möchten sie einen Film löschen[Y/N]");
                    String ja4 = scanner.nextLine();
                    if(ja4.toUpperCase().equals("Y")) {
                        for(int i = 0; i < filme.size(); i++){
                            System.out.println("["+(i+1)+"]\n" +
                                    "Filmtitel: " + filme.get(i).getFilmTitel() + "\n" +
                                    "Filmdauer: " + filme.get(i).getFilmDauerInMinuten() + " Minuten" + "\n" +
                                    "Filmsprache: " + filme.get(i).getFilmSprache()+ "\n" +
                                    "-------------------------------------------------------------");
                        }
                        System.out.println("Wählen sie einen Film aus der Liste aus");
                        int gewaehlterfilm = Integer.parseInt(scanner.nextLine());
                        gewaehlterfilm -= 1;
                        if(filme.size() >= gewaehlterfilm + 1){
                            filme.remove(filme.get(gewaehlterfilm));
                        }
                    }
                    break;
                case 7://Vorstellung erstellen
                    for(int i = 0; i < filme.size(); i++){
                        System.out.println("["+(i+1)+"]\n" +
                                "Filmtitel: " + filme.get(i).getFilmTitel() + "\n" +
                                "Filmdauer: " + filme.get(i).getFilmDauerInMinuten() + " Minuten" + "\n" +
                                "Filmsprache: " + filme.get(i).getFilmSprache()+ "\n" +
                                "-------------------------------------------------------------");
                    }
                    System.out.println("Wählen sie einen Film aus der Liste aus: ");
                    int gewaehlterFilm = Integer.parseInt(scanner.nextLine());
                    gewaehlterFilm -= 1;
                    scanner.nextLine();
                    System.out.println("Geben sie das Jahr der Vorstellung ein(2020 nicht 20)");
                    String jahr = scanner.nextLine();
                    System.out.println("Geben sie den Monat der Vorstellung ein(12 nicht Dezember)");
                    String monat = scanner.nextLine();
                    System.out.println("Geben sie den Tag der Vorstellung ein(01 nicht 1)");
                    String tag = scanner.nextLine();
                    System.out.println("Geben sie die Stunde der Vorstellung ein(09 nicht 9)");
                    String stunde = scanner.nextLine();
                    System.out.println("Geben sie die Minute der Vorstellung ein(07 nicht 7)");
                    String minute = scanner.nextLine();
                    String zeitString = jahr+"-"+monat+"-"+tag+"T"+stunde+":"+minute+":00";
                    LocalDateTime zeit = LocalDateTime.parse(zeitString);
                    for(int i = 0; i < kinos.size(); i++){
                        System.out.println("[" + (i+1) + "]\n" +
                                "Kino " + (i+1) + "\n" +
                                "Anzahl Säle: " + kinos.get(i).getSaele().size() + "\n" +
                                "-------------------------------------------------------------");
                    }
                    System.out.println("Wählen sie ein Kino aus der Liste");
                    int gewaehltesKino = Integer.parseInt(scanner.nextLine());
                    gewaehltesKino -= 1;
                    for(int i = 0; i < kinos.get(gewaehltesKino).getSaele().size(); i++){
                        System.out.println("[" + (i+1) + "]\n" +
                                "Saal "+ (i+1) + "\n" +
                                "-------------------------------------------------------------");
                    }
                    System.out.println("Wählen sie einen Saal aus der Liste");
                    int gewaehlterSaal = Integer.parseInt(scanner.nextLine());
                    gewaehlterSaal -= 1;
                    vorstellungen.add(new Vorstellung(filme.get(gewaehlterFilm), zeit, kinos.get(gewaehltesKino).getSaele().get(gewaehlterSaal)));
                    break;
                case 8://Vorstellung bearbeiten
                    System.out.println("Möchten sie eine Vorstellung bearbeiten[Y/N]");
                    String ja5 = scanner.nextLine();
                    if(ja5.toUpperCase().equals("Y")){
                        for(int i = 0; i < vorstellungen.size(); i++){
                            System.out.println("[" + (i+1) + "]\n" +
                                    "Film: " + vorstellungen.get(i).getFilm().getFilmTitel() + "\n" +
                                    "Zeit: " + vorstellungen.get(i).getZeit() + "\n" +
                                    "Kino: " + kinos.indexOf(vorstellungen.get(i).getSaal().getKino()) + 1 + "\n" +
                                    "Saal: " + vorstellungen.get(i).getSaal().getKino().getSaele().indexOf(vorstellungen.get(i).getSaal()) + 1 + "\n" +
                                    "-------------------------------------------------------------");
                        }
                        System.out.println("Wählen sie eine Vorstellung aus der Liste");
                        int gewaehltevorstellung = Integer.parseInt(scanner.nextLine());
                        gewaehltevorstellung -= 1;
                        System.out.println("Neuer Film[Y/N]");
                        String ja6 = scanner.nextLine();
                        if(ja6.toUpperCase().equals("Y")){
                            for(int i = 0; i < filme.size(); i++){
                                System.out.println("["+(i+1)+"]\n" +
                                        "Filmtitel: " + filme.get(i).getFilmTitel() + "\n" +
                                        "Filmdauer: " + filme.get(i).getFilmDauerInMinuten() + " Minuten" + "\n" +
                                        "Filmsprache: " + filme.get(i).getFilmSprache()+ "\n" +
                                        "-------------------------------------------------------------");
                            }
                            System.out.println("Wählen sie einen Film");
                            int gewaehlterfilm = Integer.parseInt(scanner.nextLine());
                            gewaehlterfilm -= 1;
                            vorstellungen.get(gewaehltevorstellung).setFilm(filme.get(gewaehlterfilm));
                        }
                        System.out.println("Neue Zeit[Y/N]");
                        ja6 = scanner.nextLine();
                        if(ja6.toUpperCase().equals("Y")){
                            System.out.println("Geben sie das Jahr der Vorstellung ein(2020 nicht 20)");
                            String Jahr = scanner.nextLine();
                            System.out.println("Geben sie den Monat der Vorstellung ein(12 nicht Dezember)");
                            String Monat = scanner.nextLine();
                            System.out.println("Geben sie den Tag der Vorstellung ein(01 nicht 1)");
                            String Tag = scanner.nextLine();
                            System.out.println("Geben sie die Stunde der Vorstellung ein(09 nicht 9)");
                            String Stunde = scanner.nextLine();
                            System.out.println("Geben sie die Minute der Vorstellung ein(07 nicht 7)");
                            String Minute = scanner.nextLine();
                            String ZeitString = Jahr+"-"+Monat+"-"+Tag+"T"+Stunde+":"+Minute+":00";
                            LocalDateTime Zeit = LocalDateTime.parse(ZeitString);
                            vorstellungen.get(gewaehltevorstellung).setZeit(Zeit);
                        }
                        System.out.println("Neuer Ort[Y/N]");
                        ja6 = scanner.nextLine();
                        if(ja6.toUpperCase().equals("Y")){
                            for (int i = 0; i < kinos.size(); i++) {
                                System.out.println("[" + (i + 1) + "]\n" +
                                        "Kino: " + (i + 1) + "\n" +
                                        "Anzahl Säle: " + kinos.get(i).getSaele().size() + "\n" +
                                        "-------------------------------------------------------------");
                            }
                            System.out.println("Wählen sie ein Kino");
                            int Gewaehlteskino = Integer.parseInt(scanner.nextLine());
                            Gewaehlteskino -= 1;
                            for(int i = 0; i < kinos.get(Gewaehlteskino).getSaele().size(); i++){
                                System.out.println("[" + (i+1) + "]\n" +
                                        "Saal: "+ (i+1) + "\n" +
                                        "anzahl Reihen: " + kinos.get(Gewaehlteskino).getSaele().get(i).getReihen().size() + "\n" +
                                        "-------------------------------------------------------------");
                            }
                            System.out.println("Wählen sie einen Saal");
                            int Gewaehltersaal = Integer.parseInt(scanner.nextLine());
                            Gewaehltersaal -= 1;
                            vorstellungen.get(gewaehltevorstellung).setSaal(kinos.get(Gewaehlteskino).getSaele().get(Gewaehltersaal));
                        }
                    }
                    break;
                case 9://Vorstellung löschen
                    System.out.println("Möchten sie eine Vorstellung löschen[Y/N]");
                    String ja6 = scanner.nextLine();
                    if(ja6.toUpperCase().equals("Y")){
                        for(int i = 0; i < vorstellungen.size(); i++){
                            System.out.println("[" + (i+1) + "]\n" +
                                    "Film: " + vorstellungen.get(i).getFilm().getFilmTitel() + "\n" +
                                    "Zeit: " + vorstellungen.get(i).getZeit() + "\n" +
                                    "Kino: " + kinos.indexOf(vorstellungen.get(i).getSaal().getKino()) + 1 + "\n" +
                                    "Saal: " + vorstellungen.get(i).getSaal().getKino().getSaele().indexOf(vorstellungen.get(i).getSaal()) + 1 + "\n" +
                                    "-------------------------------------------------------------");
                        }
                        System.out.println("Wählen sie eine Vorstellung aus der Liste welche sie löschen möchten");
                        int gewaehltevorstellung = Integer.parseInt(scanner.nextLine());
                        gewaehltevorstellung -= 1;
                        if(vorstellungen.size() >= gewaehltevorstellung + 1){
                            vorstellungen.remove(vorstellungen.get(gewaehltevorstellung));
                            vorstellungen.get(gewaehltevorstellung).absagen();
                        }
                    }
                    break;
                case 10://Vorstellung finden
                    for (int i = 0; i < kinos.size(); i++) {
                        System.out.println("[" + (i + 1) + "]\n" +
                                "Kino: " + (i + 1) + "\n" +
                                "Anzahl Säle: " + kinos.get(i).getSaele().size() + "\n" +
                                "-------------------------------------------------------------");
                    }
                    System.out.println("Wählen sie ein Kino");
                    int gewaehlteskino = Integer.parseInt(scanner.nextLine());
                    gewaehlteskino -= 1;
                    System.out.println("[1]Mit Film\n[2]mit Saal");
                    int auswahl2 = Integer.parseInt(scanner.nextLine());
                    switch(auswahl2){
                        case 1:
                            for(int i = 0; i < filme.size(); i++){
                                System.out.println("["+(i+1)+"]\n" +
                                        "Filmtitel: " + filme.get(i).getFilmTitel() + "\n" +
                                        "Filmdauer: " + filme.get(i).getFilmDauerInMinuten() + " Minuten" + "\n" +
                                        "Filmsprache: " + filme.get(i).getFilmSprache()+ "\n" +
                                        "-------------------------------------------------------------");
                            }
                            System.out.println("Wählen sie einen Film");
                            int gewaehlterfilm = Integer.parseInt(scanner.nextLine());
                            gewaehlterfilm -= 1;
                            ArrayList<Vorstellung> gefiltertevorstellungnachFilm = kinos.get(gewaehlteskino).getTicketsystem().getVorstellungenMitFilm(filme.get(gewaehlterfilm));
                            for(int i = 0; i < gefiltertevorstellungnachFilm.size(); i++){
                                System.out.println("[" + (i+1) + "]\n" +
                                        "Film: " + gefiltertevorstellungnachFilm.get(i).getFilm().getFilmTitel() + "\n" +
                                        "Zeit: " + gefiltertevorstellungnachFilm.get(i).getZeit() + "\n" +
                                        "Kino: " + kinos.indexOf(gefiltertevorstellungnachFilm.get(i).getSaal().getKino()) + 1 + "\n" +
                                        "Saal: " + gefiltertevorstellungnachFilm.get(i).getSaal().getKino().getSaele().indexOf(gefiltertevorstellungnachFilm.get(i).getSaal()) + 1 + "\n" +
                                        "-------------------------------------------------------------");
                            }
                            break;
                        case 2:
                            for(int i = 0; i < kinos.get(gewaehlteskino).getSaele().size(); i++){
                                System.out.println("[" + (i+1) + "]\n" +
                                        "Saal: "+ (i+1) + "\n" +
                                        "anzahl Reihen: " + kinos.get(gewaehlteskino).getSaele().get(i).getReihen().size() + "\n" +
                                        "-------------------------------------------------------------");
                            }
                            System.out.println("Wählen sie den Saal");
                            int gewaehltersaal = Integer.parseInt(scanner.nextLine());
                            gewaehltersaal -= 1;
                            ArrayList<Vorstellung> gefiltertevorstellungnachSaal = kinos.get(gewaehlteskino).getTicketsystem().getVorstellungenMitSaal(kinos.get(gewaehlteskino).getSaele().get(gewaehltersaal));
                            for(int i = 0; i < gefiltertevorstellungnachSaal.size(); i++){
                                System.out.println("[" + (i+1) + "]\n" +
                                        "Film: " + gefiltertevorstellungnachSaal.get(i).getFilm().getFilmTitel() + "\n" +
                                        "Zeit: " + gefiltertevorstellungnachSaal.get(i).getZeit() + "\n" +
                                        "Kino: " + kinos.indexOf(gefiltertevorstellungnachSaal.get(i).getSaal().getKino()) + 1 + "\n" +
                                        "Saal: " + gefiltertevorstellungnachSaal.get(i).getSaal().getKino().getSaele().indexOf(gefiltertevorstellungnachSaal.get(i).getSaal()) + 1 + "\n" +
                                        "-------------------------------------------------------------");
                            }
                            break;
                        default:
                            break;
                    }
                    break;
                case 11://kunde erstellen
                    System.out.println("Geben sie einen Kunden namen ein: ");
                    String kundenName = scanner.nextLine();
                    scanner.nextLine();
                    System.out.println("Geben sie die Kunden Telefonnummer ein: ");
                    String kundenTelefonnummer = scanner.nextLine();

                    kunden.add(new Kunde(kundenName,kundenTelefonnummer));
                    break;
                case 12://kunde bearbeiten
                    System.out.println("Möchten sie einen Kunden beareiten[Y/N]");
                    String ja7 = scanner.nextLine();
                    if(ja7.toUpperCase().equals("Y")){
                        for(int i = 0; i < kunden.size(); i++){
                            System.out.println("[" + (i+1) + "]\n" +
                                    "Kunde: " + kunden.get(i).getName() + "\n" +
                                    "Telefonnummer: " + kunden.get(i).getTelefonnummer() + "\n" +
                                    "-------------------------------------------------------------");
                        }
                        System.out.println("Wählen sie eien Kunden aus der Liste");
                        int gewaehlterkunde = Integer.parseInt(scanner.nextLine());
                        gewaehlterkunde -= 1;
                        System.out.println("Geben sie einen neuen Namen ein");
                        String neuername = scanner.nextLine();
                        System.out.println("Geben sie die neue Telefonnummer ein");
                        String neuetel = scanner.nextLine();
                        kunden.get(gewaehlterkunde).setName(neuername);
                        kunden.get(gewaehlterkunde).setTelefonnummer(neuetel);
                    }
                    break;
                case 13://kunde löschen
                    System.out.println("Möchten sie einen Kunden löschen[Y/N]");
                    String ja8 = scanner.nextLine();
                    if(ja8.toUpperCase().equals("Y")) {
                        for (int i = 0; i < kunden.size(); i++) {
                            System.out.println("[" + (i + 1) + "]\n" +
                                    "Kunde: " + kunden.get(i).getName() + "\n" +
                                    "Telefonnummer: " + kunden.get(i).getTelefonnummer() + "\n" +
                                    "-------------------------------------------------------------");
                        }
                        System.out.println("Wählen sie einen Kunden au der Liste");
                        int gewaehlterkunde = Integer.parseInt(scanner.nextLine());
                        gewaehlterkunde -= 1;
                        if(kunden.size() >= gewaehlterkunde + 1){
                            kunden.remove(kunden.get(gewaehlterkunde));
                        }
                    }
                    break;
                case 14://kunde finden
                    for(int i = 0; i < kinos.size(); i++){
                        System.out.println("[" + (i+1) + "]\n" +
                                "Kino: " + (i+1) + "\n" +
                                "Anzahl Säle: " + kinos.get(i).getSaele().size() + "\n" +
                                "-------------------------------------------------------------");
                    }
                    System.out.println("Wählen sie ein Kino aus der Liste");
                    int gewaehlteskino2 = Integer.parseInt(scanner.nextLine());
                    gewaehlteskino2 -= 1;
                    System.out.println("[1]Mit Namen\n[2]mit Telefonnummer");
                    int auswahl3 = Integer.parseInt(scanner.nextLine());
                    switch(auswahl3){
                        case 1:
                            System.out.println("Geben sie den Namen ein");
                            String gesuchtername = scanner.nextLine();
                            ArrayList<Kunde> gefiltertekundenachname = kinos.get(gewaehlteskino2).getTicketsystem().getKundenMitName(gesuchtername);
                            for(int i = 0; i < gefiltertekundenachname.size(); i++){
                                System.out.println("[" + (i + 1) + "]\n" +
                                        "Kunde: " + gefiltertekundenachname.get(i).getName() + "\n" +
                                        "Telefonnummer: " + gefiltertekundenachname.get(i).getTelefonnummer() + "\n" +
                                        "-------------------------------------------------------------");
                            }
                            break;
                        case 2:
                            System.out.println("Geben sie die Telefonnummer ein");
                            String gesuchtetelefonnummer = scanner.nextLine();
                            ArrayList<Kunde> gefiltertekundenachtelefonnummer = kinos.get(gewaehlteskino2).getTicketsystem().getKundenMitTelefonnummer(gesuchtetelefonnummer);
                            for(int i = 0; i < gefiltertekundenachtelefonnummer.size(); i++){
                                System.out.println("[" + (i + 1) + "]\n" +
                                        "Kunde: " + gefiltertekundenachtelefonnummer.get(i).getName() + "\n" +
                                        "Telefonnummer: " + gefiltertekundenachtelefonnummer.get(i).getTelefonnummer() + "\n" +
                                        "-------------------------------------------------------------");
                            }
                            break;
                        default:
                            break;
                    }
                    break;
                case 15://reservieren
                    for(int i = 0; i < kunden.size(); i++){
                        System.out.println("[" + (i+1) + "]\n" +
                                "Kunde: " + kunden.get(i).getName() + "\n" +
                                "Telefonnummer: " + kunden.get(i).getTelefonnummer() + "\n" +
                                "-------------------------------------------------------------");
                    }
                    System.out.println("Wählen sie eien Kunden aus der Liste");
                    int gewaehlterkunde = Integer.parseInt(scanner.nextLine());
                    gewaehlterkunde -= 1;
                    System.out.println("Für wie viele Personen möchten sie reservoeren");
                    int anzahlpersonen = Integer.parseInt(scanner.nextLine());
                    boolean nebeneinander = false;
                    if(anzahlpersonen != 1){
                        System.out.println("Möchten sie nebeneinander sitzen[Y/N]");
                        String ja9 = scanner.nextLine();
                        if (ja9.toUpperCase().equals("Y")) {
                            nebeneinander = true;
                        }
                    }
                    for(int i = 0; i < vorstellungen.size(); i++){
                        System.out.println("[" + (i+1) + "]\n" +
                                "Film: " + vorstellungen.get(i).getFilm().getFilmTitel() + "\n" +
                                "Zeit: " + vorstellungen.get(i).getZeit() + "\n" +
                                "Kino: " + kinos.indexOf(vorstellungen.get(i).getSaal().getKino()) + 1 + "\n" +
                                "Saal: " + vorstellungen.get(i).getSaal().getKino().getSaele().indexOf(vorstellungen.get(i).getSaal()) + 1 + "\n" +
                                "-------------------------------------------------------------");
                    }
                    System.out.println("Wählen sie eine Vorstellung aus der Liste");
                    int gewaehltevorstellung = Integer.parseInt(scanner.nextLine());
                    gewaehltevorstellung -= 1;
                    if(anzahlpersonen == 1){
                        kunden.get(gewaehlterkunde).platzReservieren(vorstellungen.get(gewaehltevorstellung));
                    }
                    else{
                        kunden.get(gewaehlterkunde).plaetzeReservieren(vorstellungen.get(gewaehltevorstellung),anzahlpersonen,nebeneinander);
                    }
                    break;
                case 16://stornieren
                    for(int i = 0; i < kunden.size(); i++){
                        System.out.println("[" + (i+1) + "]\n" +
                                "Kunde: " + kunden.get(i).getName() + "\n" +
                                "Telefonnummer: " + kunden.get(i).getTelefonnummer() + "\n" +
                                "-------------------------------------------------------------");
                    }
                    System.out.println("Wählen sie einen Kunden aus der Liste");
                    int gewaehlterKunde = Integer.parseInt(scanner.nextLine());
                    gewaehlterKunde -= 1;
                    for(int i = 0; i < vorstellungen.size(); i++){
                        System.out.println("[" + (i+1) + "]\n" +
                                "Film: " + vorstellungen.get(i).getFilm().getFilmTitel() + "\n" +
                                "Zeit: " + vorstellungen.get(i).getZeit() + "\n" +
                                "Kino: " + kinos.indexOf(vorstellungen.get(i).getSaal().getKino()) + 1 + "\n" +
                                "Saal: " + vorstellungen.get(i).getSaal().getKino().getSaele().indexOf(vorstellungen.get(i).getSaal()) + 1 + "\n" +
                                "-------------------------------------------------------------");
                    }
                    System.out.println("Wählen sie eine Vorstellung aus der Liste");
                    int gewaehlteVorstellung = Integer.parseInt(scanner.nextLine());
                    gewaehlteVorstellung -= 1;
                    vorstellungen.get(gewaehlteVorstellung).getSaal().getKino().getTicketsystem().stornieren(kunden.get(gewaehlterKunde),vorstellungen.get(gewaehlteVorstellung));
                    break;
                case 17://ticket erstellen
                    for(int i = 0; i < kunden.size(); i++){
                        System.out.println("[" + (i+1) + "]\n" +
                                "Kunde: " + kunden.get(i).getName() + "\n" +
                                "Telefonnummer: " + kunden.get(i).getTelefonnummer() + "\n" +
                                "-------------------------------------------------------------");
                    }
                    System.out.println("Wählen sie einen Kunden aus der Liste");
                    int gewaehlterKunde2 = Integer.parseInt(scanner.nextLine());
                    gewaehlterKunde2 -= 1;
                    for(int i = 0; i < vorstellungen.size(); i++){
                        System.out.println("[" + (i+1) + "]\n" +
                                "Film: " + vorstellungen.get(i).getFilm().getFilmTitel() + "\n" +
                                "Zeit: " + vorstellungen.get(i).getZeit() + "\n" +
                                "Kino: " + kinos.indexOf(vorstellungen.get(i).getSaal().getKino()) + 1 + "\n" +
                                "Saal: " + vorstellungen.get(i).getSaal().getKino().getSaele().indexOf(vorstellungen.get(i).getSaal()) + 1 + "\n" +
                                "-------------------------------------------------------------");
                    }
                    System.out.println("Wählen sie eine Vorstellung aus der Liste");
                    int gewaehlteVorstellung2 = Integer.parseInt(scanner.nextLine());
                    gewaehlteVorstellung2 -= 1;
                    for(int i = 0; i < vorstellungen.get(gewaehlteVorstellung2).getSaal().getReihen().size(); i++){
                        System.out.println("[" + (i+1) + "]\n" +
                                "Reihennummer: " + (i+1) + "\n" +
                                "anzahl Plätze: " + vorstellungen.get(gewaehlteVorstellung2).getSaal().getReihen().get(i).getPlaetze().size() + "\n" +
                                "-------------------------------------------------------------");
                    }
                    System.out.println("Wählen sie eine Reihe aus der Liste");
                    int gewaehlteReihe = Integer.parseInt(scanner.nextLine());
                    gewaehlteReihe -= 1;
                    System.out.println("Wählen sie einen Platz aus der Reihe");
                    int gewaehlterPlatz = Integer.parseInt(scanner.nextLine());
                    gewaehlterPlatz -= 1;
                    tickets.add(new Ticket(kunden.get(gewaehlterKunde2),vorstellungen.get(gewaehlteVorstellung2),vorstellungen.get(gewaehlteVorstellung2).getSaal().getReihen().get(gewaehlteReihe).getPlaetze().get(gewaehlterPlatz)));
                    break;
                case 18://beenden
                    verlassen = true;
                    break;
                default:
                    break;
            }
        }


    }
}
