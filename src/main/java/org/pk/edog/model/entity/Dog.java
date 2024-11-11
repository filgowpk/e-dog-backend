package org.pk.edog.model.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import org.pk.edog.model.enums.*;
import org.pk.edog.model.utils.RangeObject;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Data
@AllArgsConstructor
@Builder
@Document(collection = "dogs")
public class Dog {
    @Id
    private Long id;
    private Breed breed;
    private String shortDescription;
    private String description;
    private String imageUrl;
    private String originCountry;
    private float height;
    private float weight;
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
    private boolean goodWithChildren;
    private boolean goodWithOtherPets;
    private boolean hypoallergenic;

}
