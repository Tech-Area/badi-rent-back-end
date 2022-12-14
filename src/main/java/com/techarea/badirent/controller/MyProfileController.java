package com.techarea.badirent.controller;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/profile")
public class MyProfileController {
    List<String> testList = Arrays.asList("my profile", "page");

    @PreAuthorize("hasRole('GUEST')")
    @GetMapping("/test")
    public List<String> getTestList() {
        return
                testList;
    }
}
