package org.pk.edog.repository;

import org.pk.edog.model.entity.Dog;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DogRepository extends MongoRepository<Dog, Long> {

}
