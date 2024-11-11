package org.pk.edog.model.converter;

import org.pk.edog.model.enums.Color;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class ColorConverter implements Converter<String, List<Color>> {
    @Override
    public List<Color> convert(String source) {
        try {
            String[] colorStrings = source.replaceAll("[\\[\\]\"]", "").split(",");
            return Arrays.stream(colorStrings)
                    .map(color -> Color.valueOf(color.trim().toUpperCase()))
                    .collect(Collectors.toList());
        } catch (IllegalArgumentException e) {
            System.out.println("Invalid color: " + source);
            return List.of();
        }
    }
}