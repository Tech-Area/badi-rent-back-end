package com.techarea.badirent.mapper;

import com.techarea.badirent.dto.MotoDto;
import com.techarea.badirent.entity.Moto;

public class MotoMapper {
    public static Moto map(MotoDto motoDto) {
        return Moto.builder()
                .id(motoDto.getId())
                .brand(motoDto.getBrand())
                .name(motoDto.getName())
                .engineType(motoDto.getEngineType())
                .rentPrice(motoDto.getRentPrice())
                .insurancePrice(motoDto.getInsurancePrice())
                .available(motoDto.getAvailable())
                .motoImage(motoDto.getMotoImage())
                .build();
    }

    public static MotoDto map(Moto moto) {
        return MotoDto.builder()
                .id(moto.getId())
                .brand(moto.getBrand())
                .name(moto.getName())
                .engineType(moto.getEngineType())
                .rentPrice(moto.getRentPrice())
                .insurancePrice(moto.getInsurancePrice())
                .available(moto.getAvailable())
                .motoImage(moto.getMotoImage())
                .build();
    }
}
