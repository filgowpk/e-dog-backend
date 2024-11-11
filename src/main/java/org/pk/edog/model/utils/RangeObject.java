package org.pk.edog.model.utils;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class RangeObject {
    private int min;
    private int max;

    @Override
    public String toString() {
        return min + "-" + max;
    }
}
