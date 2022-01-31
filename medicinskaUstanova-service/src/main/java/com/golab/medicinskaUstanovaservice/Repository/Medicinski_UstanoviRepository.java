package com.golab.medicinskaUstanovaservice.Repository;

import com.golab.medicinskaUstanovaservice.Model.Medicinska_Ustanova;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface Medicinski_UstanoviRepository extends JpaRepository<Medicinska_Ustanova, Long> {

    //selektiraj site med ustanovi
    @Query("select a from Medicinska_Ustanova a where a.Medicinska_ustanova_ID in " +
            "( select Min(b.Medicinska_ustanova_ID) from Medicinska_Ustanova  b group by  b.Naziv)")
    List<Medicinska_Ustanova> findAll();

    //selektiraj lab kade ima kovid testiranje
    @Query("select a from Medicinska_Ustanova a where a.Medicinska_ustanova_ID in ( select Min(b.Medicinska_ustanova_ID) from Medicinska_Ustanova  b group by  b.Naziv) and (a.Covid19_PCR_test = true or a.Brz_antigenski_test = true or a.Imuno_test=true)")
    List<Medicinska_Ustanova> findAllCovid19TestingLabs();

    //count site
    @Query("select count(a) from Medicinska_Ustanova a where a.Medicinska_ustanova_ID in ( select Min(b.Medicinska_ustanova_ID) from Medicinska_Ustanova  b group by  b.Naziv)")
    Integer countAll();

    // count KOVID-19 ustanovi
    @Query("select count(a) from Medicinska_Ustanova a where a.Medicinska_ustanova_ID in ( select Min(b.Medicinska_ustanova_ID) from Medicinska_Ustanova  b group by  b.Naziv) and (a.Covid19_PCR_test = true or a.Brz_antigenski_test = true or a.Imuno_test=true)")
    Integer countcovid19();

    //zemi gi site kategorii
    @Query("select distinct(a.Kategorija) from Medicinska_Ustanova a")
    List<String> getAllCategories();

    //zemi gi site gradovi vo koi ima medicinski ustanovi
    @Query("select distinct(a.Grad) from Medicinska_Ustanova a")
    List<String> getAllCities();

}