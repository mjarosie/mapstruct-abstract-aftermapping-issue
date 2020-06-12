package com.example.demo.db;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class OwnersPair {
    Animal animal;
    String name;
}
