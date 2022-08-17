package com.techarea.badirent.controller;

import com.techarea.badirent.dto.ATVDto;
import com.techarea.badirent.service.ATVService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@RequestMapping("/atvs")
@ControllerAdvice
@CrossOrigin(origins = "*")
public class ATVController {

    private final ATVService atvService;

    public ATVController(ATVService atvService) {
        this.atvService = atvService;
    }

    @GetMapping
    @PreAuthorize("permitAll()")
    public ResponseEntity<List<ATVDto>> getAll() {

        return new ResponseEntity<>(atvService.getAll(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    @PreAuthorize("permitAll()")
    public ResponseEntity<ATVDto> getById(@PathVariable Long id) {
        return new ResponseEntity<>(atvService.getById(id), HttpStatus.OK);
    }

    @PostMapping
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<ATVDto> save(@RequestPart("atvDto") String atvDto,
                                       @RequestPart("file") MultipartFile imageFile) throws IOException {
        return new ResponseEntity<>(atvService.save(atvDto, imageFile), HttpStatus.CREATED);
    }
}
