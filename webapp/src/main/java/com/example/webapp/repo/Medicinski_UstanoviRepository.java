package com.example.webapp.repo;

import com.example.webapp.dtos.MedicinskaUstanovaDto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface Medicinski_UstanoviRepository extends JpaRepository<MedicinskaUstanovaDto, Integer> {

    //selektiraj site med ustanovi
    @Query("select a from MedicinskaUstanovaDto a where a.Medicinska_ustanova_ID in " +
            "( select Min(b.Medicinska_ustanova_ID) from MedicinskaUstanovaDto  b group by  b.Naziv)")
    List<MedicinskaUstanovaDto> findAll();

    //selektiraj lab kade ima kovid testiranje
    @Query("select a from MedicinskaUstanovaDto a where a.Medicinska_ustanova_ID in ( select Min(b.Medicinska_ustanova_ID) from MedicinskaUstanovaDto  b group by  b.Naziv) and (a.Covid19_PCR_test = true or a.Brz_antigenski_test = true or a.Imuno_test=true)")
    List<MedicinskaUstanovaDto> findAllCovid19TestingLabs();

    //count site
    @Query("select count(a) from MedicinskaUstanovaDto a where a.Medicinska_ustanova_ID in ( select Min(b.Medicinska_ustanova_ID) from MedicinskaUstanovaDto  b group by  b.Naziv)")
    Integer countAll();

    // count KOVID-19 ustanovi
    @Query("select count(a) from MedicinskaUstanovaDto a where a.Medicinska_ustanova_ID in ( select Min(b.Medicinska_ustanova_ID) from MedicinskaUstanovaDto  b group by  b.Naziv) and (a.Covid19_PCR_test = true or a.Brz_antigenski_test = true or a.Imuno_test=true)")
    Integer countcovid19();

    //zemi gi site kategorii
    @Query("select distinct(a.Kategorija) from MedicinskaUstanovaDto a")
    List<String> getAllCategories();

    //zemi gi site gradovi vo koi ima medicinski ustanovi
    @Query("select distinct(a.Grad) from MedicinskaUstanovaDto a")
    List<String> getAllCities();

}