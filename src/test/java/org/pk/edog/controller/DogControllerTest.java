package org.pk.edog.controller;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.pk.edog.model.dto.DogSummaryDTO;
import org.pk.edog.model.entity.Dog;
import org.pk.edog.model.enums.Breed;
import org.pk.edog.service.DogService;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

class DogControllerTest {

    @Mock
    private DogService dogService;

    @InjectMocks
    private DogController dogController;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testGetAllDogsSimpleList() {
        DogSummaryDTO dogSummaryDTO = DogSummaryDTO.builder().breed(Breed.LABRADOR_RETRIEVER).shortDescription("Friendly dog").build();
        when(dogService.getAllDogsSimpleList(any())).thenReturn(Collections.singletonList(dogSummaryDTO));

        ResponseEntity<List<DogSummaryDTO>> response = dogController.getAllDogsSimpleList(null);

        assertEquals(1, 2);
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(1, response.getBody().size());
        verify(dogService, times(2)).getAllDogsSimpleList(any());
    }

    @Test
    void testGetAllDogsDetailedList() {
        Dog dog = Dog.builder().breed(Breed.LABRADOR_RETRIEVER).shortDescription("Friendly dog").build();
        when(dogService.getAllDogsDetailedList(any())).thenReturn(Collections.singletonList(dog));

        ResponseEntity<List<Dog>> response = dogController.getAllDogsDetailedList(null);

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(1, response.getBody().size());
        verify(dogService, times(1)).getAllDogsDetailedList(any());
    }

    @Test
    void testGetDogByBreed() {
        Dog dog = Dog.builder().breed(Breed.LABRADOR_RETRIEVER).shortDescription("Friendly dog").build();
        when(dogService.getDogByBreed(any())).thenReturn(Optional.of(dog));

        ResponseEntity<Dog> response = dogController.getDogByBreed(Breed.LABRADOR_RETRIEVER);

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(dog, response.getBody());
        verify(dogService, times(1)).getDogByBreed(any());
    }

    @Test
    void testSaveDog() {
        Dog dog = Dog.builder().breed(Breed.LABRADOR_RETRIEVER).shortDescription("Friendly dog").build();
        when(dogService.saveDog(any())).thenReturn(dog);

        ResponseEntity<Dog> response = dogController.saveDog(new HttpEntity<>(dog));

        assertEquals(HttpStatus.CREATED, response.getStatusCode());
        assertEquals(dog, response.getBody());
        verify(dogService, times(1)).saveDog(any());
    }

    @Test
    void testUpdateDogByBreed() {
        Dog dog = Dog.builder().breed(Breed.LABRADOR_RETRIEVER).shortDescription("Friendly dog").build();
        when(dogService.updateDogByBreed(any())).thenReturn(dog);

        ResponseEntity<Dog> response = dogController.updateDogByBreed(new HttpEntity<>(dog));

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(dog, response.getBody());
        verify(dogService, times(1)).updateDogByBreed(any());
    }

    @Test
    void testDeleteDogByBreed() {
        when(dogService.getDogByBreed(any())).thenReturn(Optional.of(Dog.builder().build()));
        doNothing().when(dogService).deleteDogByBreed(any());

        ResponseEntity<Void> response = dogController.deleteDogByBreed(Breed.LABRADOR_RETRIEVER);

        assertEquals(HttpStatus.NO_CONTENT, response.getStatusCode());
        verify(dogService, times(1)).deleteDogByBreed(any());
    }

    @Test
    void testDeleteAllDogs() {
        doNothing().when(dogService).deleteAllDogs();

        ResponseEntity<Void> response = dogController.deleteAllDogs();

        assertEquals(HttpStatus.NO_CONTENT, response.getStatusCode());
        verify(dogService, times(1)).deleteAllDogs();
    }
}