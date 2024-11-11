package org.pk.edog.model.query;

import lombok.Builder;
import lombok.Data;
import org.pk.edog.model.enums.Characteristic;
import org.pk.edog.model.enums.Color;
import org.pk.edog.model.enums.Difficulty;
import org.pk.edog.model.enums.Level;

import java.util.List;

@Data
@Builder
public class DogQuery {

    // Pagination and sorting
    private Integer limit;
    private Integer offset;
    private String sortBy;
    private Boolean sortDesc;

    // Filter by fields
    private List<Color> colors;
    private List<Characteristic> characteristics;
    private String originCountry;
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
