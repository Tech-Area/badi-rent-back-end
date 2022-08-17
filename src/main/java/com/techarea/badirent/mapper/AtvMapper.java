package com.techarea.badirent.mapper;

import com.techarea.badirent.dto.ATVDto;
import com.techarea.badirent.entity.ATV;

public class AtvMapper {
    public static ATV map(ATVDto atvDto) {
        return ATV.builder()
                .id(atvDto.getId())
                .brand(atvDto.getBrand())
                .name(atvDto.getName())
                .engineType(atvDto.getEngineType())
                .rentPrice(atvDto.getRentPrice())
                .insurancePrice(atvDto.getInsurancePrice())
                .available(atvDto.getAvailable())
                .atvImage(atvDto.getAtvImage())
                .build();
    }

    public static ATVDto map(ATV atv) {
        return ATVDto.builder()
                .id(atv.getId())
                .brand(atv.getBrand())
                .name(atv.getName())
                .engineType(atv.getEngineType())
                .rentPrice(atv.getRentPrice())
                .insurancePrice(atv.getInsurancePrice())
                .available(atv.getAvailable())
                .atvImage(atv.getAtvImage())
                .build();
    }
}
