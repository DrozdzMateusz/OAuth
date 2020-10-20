package com.example.OAuth;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloAPi {

    @PostMapping("/api/hello")
    public String sayHello(){
        return "Hello";
    }

}
