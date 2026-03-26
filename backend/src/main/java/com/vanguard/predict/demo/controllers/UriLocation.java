package com.vanguard.predict.demo.controllers;

import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;

public class UriLocation {
    static public URI uriLocationBuilder(Integer id){
        return ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/id}")
                .buildAndExpand(id)
                .toUri();
    }
}
