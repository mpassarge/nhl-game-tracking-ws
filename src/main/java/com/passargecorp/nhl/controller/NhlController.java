package com.passargecorp.nhl.controller;

import com.passargecorp.nhl.service.NhlService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
public class NhlController {

    private NhlService nhlService;

    @GetMapping
    public String tmp() {

        /*
        2019020501
        2019020502
        2019020504
        2019020503
        2019020505
        */
        nhlService.getGameById("2019010003");
        return "Hello, World!";
    }
}