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

        nhlService.getGameById("2019010003");
        return "Hello, World!";
    }
}