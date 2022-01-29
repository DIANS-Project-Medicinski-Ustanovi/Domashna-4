package com.example.webapp.service;

import com.example.webapp.dtos.MedicinskaUstanovaDto;

import java.util.HashMap;
import java.util.List;
import java.util.Optional;

public interface Medicinski_UstanoviService {

    public List<MedicinskaUstanovaDto> findAllMedicinskiUstanovi();

    public List<MedicinskaUstanovaDto> findAllCovid19TestingLabs();

    public Optional<MedicinskaUstanovaDto> findById(int id);

    public Integer all();

    public Integer covid();

    List<MedicinskaUstanovaDto> findAllByCategory(String category);

    List<MedicinskaUstanovaDto> findAllByCity(String city);

    List<MedicinskaUstanovaDto> findAllNotCovid19Testing();

    List<MedicinskaUstanovaDto> getMedicalLabsByFilter(String category, String city, String covid19Test);

    List<String> getAllCities();

    List<String> getAllCategories();

    public HashMap<Integer, MedicinskaUstanovaDto> FilterdMedUstanovi(String category, String city, String covid19Test);

}