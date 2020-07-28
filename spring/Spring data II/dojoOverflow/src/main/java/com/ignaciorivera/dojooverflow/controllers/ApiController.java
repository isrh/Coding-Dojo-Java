package com.ignaciorivera.dojooverflow.controllers;

import org.springframework.web.bind.annotation.RestController;

import com.ignaciorivera.dojooverflow.services.MainService;



@RestController

public class ApiController {

private final MainService mainService;
    
    public ApiController(MainService mainService) {
        this.mainService = mainService;
    }
}
