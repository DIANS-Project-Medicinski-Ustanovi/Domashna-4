package com.golab.cloudgateway;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FallBackMethodController {

    @GetMapping("/userServiceFallBack")
    public String userServiceFallBackMethod(){
        return "User Service is taking longer than Expected. Please try again later.";
    }

    @GetMapping("/MedicinskaUstanovaServiceFallBack")
    public String MedicinskaUstanovaServiceFallBackMethod(){
        return "MedicinskaUstanova Service is taking longer than Expected. Please try again later.";
    }
}


