package com.example.webapp.service;

import com.example.webapp.dtos.MedicinskaUstanovaDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;


//Service for communicating with medicinska ustanovaMicroservice;

@Service
public class MedicinskaUstanovaFetchService {

    @Autowired
    private RestTemplate restTemplate;

}
