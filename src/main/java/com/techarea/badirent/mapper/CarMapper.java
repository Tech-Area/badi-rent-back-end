package com.techarea.badirent.mapper;

import com.techarea.badirent.dto.CarDto;
import com.techarea.badirent.entity.Car;

public class CarMapper {
    public static Car map(CarDto carDto) {
        return Car.builder()
                .id(carDto.getId())
                .brand(carDto.getBrand())
                .name(carDto.getName())
                .engineType(carDto.getEngineType())
                .rentPrice(carDto.getRentPrice())
                .insurancePrice(carDto.getInsurancePrice())
                .available(carDto.getAvailable())
                .seats(carDto.getSeats())
                .carImage(carDto.getCarImage())
                .build();
    }

    public static CarDto map(Car car) {
        return CarDto.builder()
                .id(car.getId())
                .brand(car.getBrand())
                .name(car.getName())
                .engineType(car.getEngineType())
                .rentPrice(car.getRentPrice())
                .insurancePrice(car.getInsurancePrice())
                .available(car.getAvailable())
                .seats(car.getSeats())
                .carImage(car.getCarImage())
                .build();
    }
}
