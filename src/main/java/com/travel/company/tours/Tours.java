package com.travel.company.tours;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.GregorianCalendar;

@RestController
@RequestMapping("/tours")

public class Tours {

    @GetMapping

    public ResponseEntity<String> getInformation() {

        String information = "I'm tour. Wait till my team finish all my details.";
        return ResponseEntity.ok(information);
    }


    @GetMapping(value = "/Korfu")
    public Tour getTour(){
        //tu powinno być odłączenie do bazy, ale na razie easy
        return Tour.builder().
                beginningDate(new GregorianCalendar(2019, 8, 21)).
                destination("Korfu").
                endingDate(new GregorianCalendar(2019, 8, 21)).
                price(2000.99f).
                build();
    }



}
