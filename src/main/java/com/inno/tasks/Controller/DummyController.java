package com.inno.tasks.Controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DummyController {

    @RequestMapping("/")
    public String dummyGet(){
        return "Hello world";
    }
}
