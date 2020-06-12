package com.example.demo.mapper;

import com.example.demo.db.Animal;
import com.example.demo.db.OwnersPair;
import com.example.demo.dto.AnimalDto;
import com.example.demo.dto.DogDto;
import org.mapstruct.AfterMapping;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;

import java.util.Set;
import java.util.stream.Collectors;

@Mapper(componentModel = "spring")
public abstract class AnimalMapper {
    public Animal toDbEntity(AnimalDto animalDto) {
        if (animalDto instanceof DogDto) {
            return toDbEntity((DogDto) animalDto);
        }

        return null;
    }

    public abstract Animal toDbEntity(DogDto animalDto);

    protected Set<OwnersPair> mapOwners(Set<String> owners) {
        return owners
                .stream()
                .map(o -> OwnersPair
                        .builder()
                        .animal(null) // Set null for now to set it later in @AfterMapping
                        .name(o)
                        .build()
                )
                .collect(Collectors.toSet());
    }

    @AfterMapping
    protected void afterAnimalMapping(@MappingTarget Animal animal) {
        // Put a "back-reference" to the animal.
        animal.getOwners().forEach(o -> o.setAnimal(animal));
    }

}
