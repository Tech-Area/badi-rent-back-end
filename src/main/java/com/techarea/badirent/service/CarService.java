package com.techarea.badirent.service;

import com.techarea.badirent.dto.CarDto;
import com.techarea.badirent.mapper.CarMapper;
import com.techarea.badirent.repository.CarRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CarService {
    private final CarRepository carRepository;


    public CarService(CarRepository carRepository) {
        this.carRepository = carRepository;
    }

    public List<CarDto> getAll() {
        return carRepository.findAll().stream().map(CarMapper::map).collect(Collectors.toList());
    }

    public CarDto save(CarDto carDto) {
        return CarMapper.map(carRepository.save(CarMapper.map(carDto)));
    }
}
