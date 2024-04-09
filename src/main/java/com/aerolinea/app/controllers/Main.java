package com.aerolinea.app.controllers;

import java.util.Random;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Main {

    @GetMapping("")
    public String index() {
        Random random = new Random();
        int num = random.nextInt(101) + 100;
        return "MYA" + num;
    }

}
