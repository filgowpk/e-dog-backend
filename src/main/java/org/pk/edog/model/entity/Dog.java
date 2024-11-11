package org.pk.edog.model.entity;

import lombok.Builder;
import lombok.Data;
import org.pk.edog.model.custom.RangeObject;
import org.pk.edog.model.enums.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Data
@Builder
@Document(collection = "dogs")
public class Dog {
    @Id
    @Indexed(unique = true)
    private Breed breed;
    private String shortDescription;
    private String description;
    private String imageUrl;
    private String originCountry;
    private Float height;
    private Float weight;
    private RangeObject lifeSpan;
    private RangeObject price;
    private List<Color> colors;
    private List<Characteristic> characteristics;
    private Difficulty breedingDifficulty;
    private Level activityLevel;
    private Level sheddingLevel;
    private Level spaceNeeds;
    private Level groomingNeeds;
    private Level healthIssues;
    private Level trainability;
    private Boolean goodWithChildren;
    private Boolean goodWithOtherPets;
    private Boolean hypoallergenic;

}
