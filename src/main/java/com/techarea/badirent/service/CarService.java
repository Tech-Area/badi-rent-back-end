package com.techarea.badirent.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.techarea.badirent.dto.CarDto;
import com.techarea.badirent.mapper.CarMapper;
import com.techarea.badirent.repository.CarRepository;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
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

    public CarDto save(String carDto, MultipartFile imageFile) throws IOException {
        CarDto carDtoToSave = getCarJson(carDto);
        byte[] carImageArray = imageFile.getBytes();
        carDtoToSave.setCarImage(carImageArray);
        return CarMapper.map(carRepository.save(CarMapper.map(carDtoToSave)));
    }

    private CarDto getCarJson(String carDto) {
        CarDto carDto1 = new CarDto();
        try{
            ObjectMapper objectMapper = new ObjectMapper();
            carDto1 = objectMapper.readValue(carDto,CarDto.class);
        }catch (Exception e)
        {
            System.out.println(e.getMessage());
        }

        return carDto1;
    }
}
