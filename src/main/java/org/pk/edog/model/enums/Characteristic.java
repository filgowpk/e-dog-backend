package org.pk.edog.model.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum Characteristic {
    FRIENDLY("Friendly"),
    CALM("Calm"),
    ACTIVE("Active"),
    PROTECTIVE("Protective"),
    INTELLIGENT("Intelligent"),
    INDEPENDENT("Independent"),
    PLAYFUL("Playful"),
    ALERT("Alert"),
    STUBBORN("Stubborn"),
    CURIOUS("Curious"),
    LOYAL("Loyal"),
    GENTLE("Gentle"),
    ENERGETIC("Energetic"),
    SHY("Shy"),
    CONFIDENT("Confident");

    private final String description;
}
