package com.example.webapp.dtos;

import lombok.Data;

@Data
public class MedicinskaUstanovaDto {

    private int Medicinska_ustanova_ID;
    private String Naziv, Kategorija, Adresa, Grad;
    private Double Ocena;
    private Integer Broj_na_kritiki;
    private String Website, Tel_broj;
    private String Ponedelnik, Vtornik, Sreda, Cetvrtok, Petok, Sabota, Nedela;
    private Boolean Covid19_PCR_test, Brz_antigenski_test, Imuno_test;
    private String Online_booking, Cenovnik, Promocii;
    private String placeURL, imgURL;
    private Double Latitude, Longitude;
    private String Zabeleshki;
}
