package com.codegate01.weatherapi.controller;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v0/")
public class Heartbeat {

    @RequestMapping(value ="status", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public String heartbeat(){
        return "Alive";
    }
}
