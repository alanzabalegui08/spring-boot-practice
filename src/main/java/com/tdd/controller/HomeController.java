package com.tdd.controller;

import com.sun.jndi.toolkit.url.Uri;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api")
public class HomeController {

    // tdd examples & some more (:
    @GetMapping("/")
    public String index() {
        return "hello world !";
    }

    // use the method GET & create list for return with ResponseEntity
    @GetMapping("list")
    public ResponseEntity<Iterable<List>>getlist(){
        List list =  new ArrayList();
        list.add("orange");
        list.add("apple");
        list.add("banana");

        URI location = ServletUriComponentsBuilder.fromCurrentRequest().buildAndExpand(list.get(1)).toUri();

        // the most normal response
        return ResponseEntity.ok(list);

        // other type reponse in method get
        //return ResponseEntity.ok().header("Location", location.toString()).build();

    }


}
