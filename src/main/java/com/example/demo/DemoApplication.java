package com.example.demo;

import com.example.demo.db.Animal;
import com.example.demo.dto.AnimalDto;
import com.example.demo.dto.DogDto;
import com.example.demo.mapper.AnimalMapper;
import org.mapstruct.factory.Mappers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Arrays;
import java.util.HashSet;

@SpringBootApplication
public class DemoApplication {

	@Autowired
	private final static AnimalMapper animalMapper = Mappers.getMapper( AnimalMapper.class );

	public static void main(String[] args) {
		AnimalDto animal = DogDto.builder()
				.owners(new HashSet<>(Arrays.asList("Marry", "John")))
				.weight(10L)
				.build();

		Animal animalEntity = animalMapper.toDbEntity(animal);

		animalEntity.getOwners().forEach(o -> System.out.println(o.getAnimal()));

	}

}
