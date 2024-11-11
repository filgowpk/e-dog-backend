package org.pk.edog.model.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum Color {
    UNDEFINED("Undefined"),
    BLACK("Black"),
    WHITE("White"),
    BROWN("Brown"),
    GOLDEN("Golden"),
    GREY("Grey"),
    TAN("Tan"),
    RED("Red"),
    CREAM("Cream"),
    BRINDLE("Brindle"),
    BLUE("Blue"),
    MERLE("Merle"),
    SABLE("Sable"),
    FAWN("Fawn"),
    LIVER("Liver"),
    TRI_COLOR("Tri-color");

    private final String description;
}
