package com.example.demo.db;

import lombok.*;

import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Builder
public class Animal {
    private Long id;
    private Long weight;
    private Set<OwnersPair> owners;
}
