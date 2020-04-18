package com.company;

public class Film {
    private String filmTitel;
    private Double filmDauerInMinuten;
    private String filmBeschreibung;
    private String filmSprache;

    public Film(String filmTitel, Double filmDauerInMinuten, String filmBeschreibung, String filmSprache){
        this.filmTitel = filmTitel;
        this.filmDauerInMinuten = filmDauerInMinuten;
        this.filmBeschreibung = filmBeschreibung;
        this.filmSprache = filmSprache;
    }
    
    public String getFilmTitel() {
        return filmTitel;
    }

    public void setFilmTitel(String filmTitel) {
        this.filmTitel = filmTitel;
    }

    public Double getFilmDauerInMinuten() {
        return filmDauerInMinuten;
    }

    public void setFilmDauerInMinuten(Double filmDauerInMinuten) {
        this.filmDauerInMinuten = filmDauerInMinuten;
    }

    public String getFilmBeschreibung() {
        return filmBeschreibung;
    }

    public void setFilmBeschreibung(String filmBeschreibung) {
        this.filmBeschreibung = filmBeschreibung;
    }

    public String getFilmSprache() {
        return filmSprache;
    }

    public void setFilmSprache(String filmSprache) {
        this.filmSprache = filmSprache;
    }
}
