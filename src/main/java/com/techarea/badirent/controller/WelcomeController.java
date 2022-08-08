package com.techarea.badirent.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/welcome")
public class WelcomeController {
    List<String> testList = Arrays.asList("ciprian", "ionut");

    @GetMapping
    public List<String> getTestList() {
        return
                testList;
    }
}
