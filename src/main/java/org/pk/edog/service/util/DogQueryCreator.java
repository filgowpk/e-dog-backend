package org.pk.edog.service.util;

import lombok.experimental.UtilityClass;
import org.pk.edog.model.query.DogQuery;
import org.springframework.data.domain.Sort;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;

import static java.util.Objects.isNull;
import static java.util.Objects.nonNull;

@UtilityClass
public class DogQueryCreator {

    public static Query buildQuery(DogQuery dogQuery) {
        if (isNull(dogQuery)) return new Query();

        Criteria criteria = new Criteria();

        if (nonNull(dogQuery.getOriginCountry())) criteria.and("originCountry").is(dogQuery.getOriginCountry());
        if (nonNull(dogQuery.getColors())) criteria.and("colors").in(dogQuery.getColors());
        if (nonNull(dogQuery.getCharacteristics())) criteria.and("characteristics").in(dogQuery.getCharacteristics());
        if (nonNull(dogQuery.getBreedingDifficulty())) criteria.and("breedingDifficulty").is(dogQuery.getBreedingDifficulty());
        if (nonNull(dogQuery.getActivityLevel())) criteria.and("activityLevel").is(dogQuery.getActivityLevel());
        if (nonNull(dogQuery.getSheddingLevel())) criteria.and("sheddingLevel").is(dogQuery.getSheddingLevel());
        if (nonNull(dogQuery.getSpaceNeeds())) criteria.and("spaceNeeds").is(dogQuery.getSpaceNeeds());
        if (nonNull(dogQuery.getGroomingNeeds())) criteria.and("groomingNeeds").is(dogQuery.getGroomingNeeds());
        if (nonNull(dogQuery.getHealthIssues())) criteria.and("healthIssues").is(dogQuery.getHealthIssues());
        if (nonNull(dogQuery.getTrainability())) criteria.and("trainability").is(dogQuery.getTrainability());
        if (nonNull(dogQuery.getGoodWithChildren())) criteria.and("goodWithChildren").is(dogQuery.getGoodWithChildren());
        if (nonNull(dogQuery.getGoodWithOtherPets())) criteria.and("goodWithOtherPets").is(dogQuery.getGoodWithOtherPets());
        if (nonNull(dogQuery.getHypoallergenic())) criteria.and("hypoallergenic").is(dogQuery.getHypoallergenic());

        Query query = new Query(criteria);

        if (nonNull(dogQuery.getLimit())) query.limit(dogQuery.getLimit());
        if (nonNull(dogQuery.getOffset())) query.skip(dogQuery.getOffset());

        if (nonNull(dogQuery.getSortBy())) {
            query.with(Sort.by(dogQuery.getSortDesc() ? Sort.Direction.DESC : Sort.Direction.ASC, dogQuery.getSortBy()));
        }

        System.out.println(query);

        return query;
    }
}
