package org.pk.edog.service;

import org.pk.edog.model.dto.DogSummaryDTO;
import org.pk.edog.model.entity.Dog;
import org.pk.edog.model.enums.Breed;
import org.pk.edog.model.query.DogQuery;
import org.pk.edog.repository.DogRepository;
import org.pk.edog.service.util.DogQueryCreator;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@Service
public class DogService {

    private final DogRepository dogRepository;
    private final MongoTemplate mongoTemplate;

    public DogService(DogRepository dogRepository, MongoTemplate mongoTemplate) {
        this.dogRepository = dogRepository;
        this.mongoTemplate = mongoTemplate;
    }

    public List<DogSummaryDTO> getAllDogsSimpleList(DogQuery dogQuery) {
        List<Dog> dogList = mongoTemplate.find(DogQueryCreator.buildQuery(dogQuery), Dog.class);
        return dogList.stream()
                .map(DogSummaryDTO::fromDog)
                .toList();
    }

    public List<Dog> getAllDogsDetailedList(DogQuery dogQuery) {
        return mongoTemplate.find(DogQueryCreator.buildQuery(dogQuery), Dog.class);
    }

    public Optional<Dog> getDogByBreed(Breed breed) {
        return dogRepository.findByBreed(breed);
    }

    @Transactional
    public Dog saveDog(Dog dog) {
        if (dogRepository.findByBreed(dog.getBreed()).isPresent()) {
            throw new IllegalArgumentException("Dog with breed " + dog.getBreed() + " already exists");
        }

        return dogRepository.save(dog);
    }

    @Transactional
    public Dog updateDogByBreed(Dog newDog) {
        Optional<Dog> dogOptional = dogRepository.findByBreed(newDog.getBreed());

        if (dogOptional.isEmpty()) {
            throw new NoSuchElementException("Dog with breed " + newDog.getBreed() + " not found");
        }

        return dogRepository.save(newDog);
    }

    public void deleteDogByBreed(Breed breed) {
        dogRepository.deleteByBreed(breed);
    }

    public void deleteAllDogs() {
        dogRepository.deleteAll();
    }
}
