package com.techarea.badirent.controller;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/rent")

public class RentController {
    List<String> testList = Arrays.asList("rent", "page");

    @PreAuthorize("hasRole('ADMIN')")
    @GetMapping
    public List<String> getTestList() {
        return
                testList;
    }
}
