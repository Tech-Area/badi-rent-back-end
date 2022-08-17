package com.techarea.badirent.controller;

import com.techarea.badirent.dto.CarDto;
import com.techarea.badirent.dto.MotoDto;
import com.techarea.badirent.service.MotoService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/motos")
@ControllerAdvice
@CrossOrigin(origins = "*")
public class MotoController {

    private final MotoService motoService;

    public MotoController(MotoService motoService) {
        this.motoService = motoService;
    }

    @GetMapping
    @PreAuthorize("permitAll()")
    public ResponseEntity<List<MotoDto>> getAll() {
        return new ResponseEntity<>(motoService.getAll(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    @PreAuthorize("permitAll()")
    public ResponseEntity<MotoDto> getById(@PathVariable Long id) {
        return new ResponseEntity<>(motoService.getById(id), HttpStatus.OK);
    }
    @PostMapping
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<MotoDto> save(@RequestPart("motoDto") String motoDto,
                                        @RequestPart("file") MultipartFile imageFile) throws IOException {
        return new ResponseEntity<>(motoService.save(motoDto, imageFile), HttpStatus.CREATED);
    }
}
