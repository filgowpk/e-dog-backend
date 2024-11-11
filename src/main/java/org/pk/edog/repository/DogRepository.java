package org.pk.edog.repository;

import org.pk.edog.model.entity.Dog;
import org.pk.edog.model.enums.Breed;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface DogRepository extends MongoRepository<Dog, String> {
    Optional<Dog> findByBreed(Breed breed);
    void deleteByBreed(Breed breed);
}
