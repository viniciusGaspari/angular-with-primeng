package com.vanguard.predict.demo.helpers;

import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;

public class UriLocationBuilder {
    static public URI uriLocationBuilder(Integer id){
        return ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/id}")
                .buildAndExpand(id)
                .toUri();
    }
}
