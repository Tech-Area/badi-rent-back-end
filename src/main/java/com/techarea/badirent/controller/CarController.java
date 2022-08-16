package com.techarea.badirent.controller;

import com.techarea.badirent.dto.CarDto;
import com.techarea.badirent.service.CarService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/cars")
@PreAuthorize("permitAll()")
public class CarController {
    private final CarService carService;

    public CarController(CarService carService) {
        this.carService = carService;
    }

    @GetMapping
    @PreAuthorize("permitAll()")
    public ResponseEntity<List<CarDto>> getAll() {
        return new ResponseEntity<>(carService.getAll(), HttpStatus.OK);
    }

    @PostMapping
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<CarDto> save(@RequestBody CarDto carDto){
        return new ResponseEntity<>(carService.save(carDto),HttpStatus.CREATED);
    }
}
