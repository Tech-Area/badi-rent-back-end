package com.techarea.badirent.entity;

import lombok.*;
import org.hibernate.annotations.Type;

import javax.persistence.*;

@Entity
@Table(name = "motos")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Data
@Builder
public class Moto {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String brand;
    private String name;

    @Column(name = "engine_type")
    private String engineType;

    @Column(name = "rent_price")
    private Double rentPrice;

    @Column(name = "insurance_price")
    private Double insurancePrice;

    private Boolean available;

    @Column(name = "moto_image")
    @Lob
    @Type(type="org.hibernate.type.BinaryType")
    private byte[] motoImage;

}
