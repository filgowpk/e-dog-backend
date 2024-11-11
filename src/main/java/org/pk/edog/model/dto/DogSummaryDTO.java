package org.pk.edog.model.dto;

import lombok.Builder;
import lombok.Data;
import org.pk.edog.model.entity.Dog;
import org.pk.edog.model.enums.Breed;

@Data
@Builder
public class DogSummaryDTO {
    private Breed breed;
    private String shortDescription;
    private String imageUrl;

    public static DogSummaryDTO fromDog(Dog dog) {
        return DogSummaryDTO.builder()
                .breed(dog.getBreed())
                .shortDescription(dog.getShortDescription())
                .imageUrl(dog.getImageUrl())
                .build();
    }
}
