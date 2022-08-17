package com.techarea.badirent.dto;

import lombok.*;

@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class MotoDto {
    private Long id;
    private String brand;
    private String name;
    private String engineType;
    private Double rentPrice;
    private Double insurancePrice;
    private Boolean available;
    private byte[] motoImage;
}
