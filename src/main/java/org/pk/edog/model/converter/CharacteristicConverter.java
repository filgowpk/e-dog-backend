package org.pk.edog.model.converter;

import org.pk.edog.model.enums.Characteristic;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class CharacteristicConverter implements Converter<String, List<Characteristic>> {
    @Override
    public List<Characteristic> convert(String source) {
        try {
            String[] characteristicStrings = source.replaceAll("[\\[\\]\"]", "").split(",");
            return Arrays.stream(characteristicStrings)
                    .map(characteristic -> Characteristic.valueOf(characteristic.trim().toUpperCase()))
                    .collect(Collectors.toList());
        } catch (IllegalArgumentException e) {
            System.out.println("Invalid characteristic: " + source);
            return List.of();
        }
    }
}