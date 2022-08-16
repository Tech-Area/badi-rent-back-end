package com.techarea.badirent.dto;

import lombok.*;
import org.springframework.web.multipart.MultipartFile;

@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class CarDto {
    private Long id;
    private String brand;
    private String name;
    private String engineType;
    private Double rentPrice;
    private Double insurancePrice;
    private Boolean available;
    private Integer seats;
    private byte[] carImage;
}
