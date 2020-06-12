package com.example.demo.dto;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.SuperBuilder;

import java.util.Set;

@Data
@EqualsAndHashCode(callSuper = true)
@SuperBuilder
public class DogDto extends AnimalDto {
    private Long weight;
    private Set<String> owners;
}
