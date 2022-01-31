package com.golab.medicinskaUstanovaservice.Model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@Table(name = "Medicinski_Ustanovi")
public class Medicinska_Ustanova {

    public Medicinska_Ustanova() {
    }

    public Medicinska_Ustanova(int medicinska_ustanova_ID, String naziv, String kategorija, String adresa, String grad, Double ocena, Integer broj_na_kritiki, String website, String tel_broj, String ponedelnik, String vtornik, String sreda, String cetvrtok, String petok, String sabota, String nedela, Boolean covid19_PCR_test, Boolean brz_antigenski_test, Boolean imuno_test, String online_booking, String cenovnik, String promocii, String placeURL, String imgURL, Double latitude, Double longitude, String zabeleshki) {
        Medicinska_ustanova_ID = medicinska_ustanova_ID;
        Naziv = naziv;
        Kategorija = kategorija;
        Adresa = adresa;
        Grad = grad;
        Ocena = ocena;
        Broj_na_kritiki = broj_na_kritiki;
        Website = website;
        Tel_broj = tel_broj;
        Ponedelnik = ponedelnik;
        Vtornik = vtornik;
        Sreda = sreda;
        Cetvrtok = cetvrtok;
        Petok = petok;
        Sabota = sabota;
        Nedela = nedela;
        Covid19_PCR_test = covid19_PCR_test;
        Brz_antigenski_test = brz_antigenski_test;
        Imuno_test = imuno_test;
        Online_booking = online_booking;
        Cenovnik = cenovnik;
        Promocii = promocii;
        this.placeURL = placeURL;
        this.imgURL = imgURL;
        Latitude = latitude;
        Longitude = longitude;
        Zabeleshki = zabeleshki;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
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
