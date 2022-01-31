package com.golab.medicinskaUstanovaservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class MedicinskaUstanovaServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(MedicinskaUstanovaServiceApplication.class, args);
	}

}
