package org.pk.edog.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.pk.edog.model.dto.DogSummaryDTO;
import org.pk.edog.model.entity.Dog;
import org.pk.edog.model.enums.Breed;
import org.pk.edog.model.query.DogQuery;
import org.pk.edog.service.DogService;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

import static java.util.Objects.isNull;

@RestController("/api/v1/dog")
public class DogController {

    private final DogService dogService;

    public DogController(DogService dogService) {
        this.dogService = dogService;
    }

    @Operation(summary = "Get a simple list of all dogs", description = "Retrieve a paginated summary list of all dogs with optional sorting and filtering.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "List of dogs retrieved successfully"),
            @ApiResponse(responseCode = "404", description = "No dogs found", content = @Content),
            @ApiResponse(responseCode = "500", description = "Internal server error", content = @Content)
    })
    @GetMapping
    public ResponseEntity<List<DogSummaryDTO>> getAllDogsSimpleList(@ModelAttribute DogQuery dogQuery) {
        try {
            List<DogSummaryDTO> dogs = dogService.getAllDogsSimpleList(dogQuery);
            if (dogs.isEmpty()) {
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            }
            return new ResponseEntity<>(dogs, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @Operation(summary = "Get a detailed list of all dogs", description = "Retrieve a paginated detailed list of all dogs with optional sorting and filtering.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "List of dogs retrieved successfully"),
            @ApiResponse(responseCode = "404", description = "No dogs found", content = @Content),
            @ApiResponse(responseCode = "500", description = "Internal server error", content = @Content)
    })
    @GetMapping("/detailed")
    public ResponseEntity<List<Dog>> getAllDogsDetailedList(@ModelAttribute DogQuery dogQuery) {
        try {
            List<Dog> dogs = dogService.getAllDogsDetailedList(dogQuery);
            if (dogs.isEmpty()) {
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            }
            return new ResponseEntity<>(dogs, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @Operation(summary = "Get a dog by breed")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Dog retrieved successfully"),
            @ApiResponse(responseCode = "404", description = "Dog with specified breed not found", content = @Content),
            @ApiResponse(responseCode = "500", description = "Internal server error", content = @Content)
    })
    @GetMapping("/{breed}")
    public ResponseEntity<Dog> getDogByBreed(@PathVariable Breed breed) {
        try {
            Optional<Dog> dogOptional = dogService.getDogByBreed(breed);
            return dogOptional.map(value -> new ResponseEntity<>(value, HttpStatus.OK))
                    .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @Operation(summary = "Add a new dog")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Dog created successfully"),
            @ApiResponse(responseCode = "400", description = "Invalid request body", content = @Content),
            @ApiResponse(responseCode = "409", description = "Dog already exists", content = @Content),
            @ApiResponse(responseCode = "500", description = "Internal server error", content = @Content)
    })
    @PostMapping
    public ResponseEntity<Dog> saveDog(HttpEntity<Dog> dog) {
        try {
            if (isNull(dog.getBody())) {
                return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
            }
            return new ResponseEntity<>(dogService.saveDog(dog.getBody()), HttpStatus.CREATED);
        } catch (IllegalArgumentException e) {
            return new ResponseEntity<>(HttpStatus.CONFLICT);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @Operation(summary = "Update a dog by breed")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Dog updated successfully"),
            @ApiResponse(responseCode = "400", description = "Invalid request body", content = @Content),
            @ApiResponse(responseCode = "404", description = "Dog with specified breed not found", content = @Content),
            @ApiResponse(responseCode = "500", description = "Internal server error", content = @Content)
    })
    @PutMapping
    public ResponseEntity<Dog> updateDogByBreed(HttpEntity<Dog> dog) {
        try {
            if (isNull(dog.getBody())) {
                return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
            }
            return new ResponseEntity<>(dogService.updateDogByBreed(dog.getBody()), HttpStatus.OK);
        } catch (NoSuchElementException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @Operation(summary = "Delete a dog by breed")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "204", description = "Dog deleted successfully"),
            @ApiResponse(responseCode = "404", description = "Dog with specified breed not found"),
            @ApiResponse(responseCode = "500", description = "Internal server error")
    })
    @DeleteMapping("/{breed}")
    public ResponseEntity<Void> deleteDogByBreed(@PathVariable Breed breed) {
        try {
            if (dogService.getDogByBreed(breed).isEmpty()) {
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            }
            dogService.deleteDogByBreed(breed);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @Operation(summary = "Delete all dogs")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "204", description = "All dogs deleted successfully"),
            @ApiResponse(responseCode = "500", description = "Internal server error")
    })
    @DeleteMapping
    public ResponseEntity<Void> deleteAllDogs() {
        try {
            dogService.deleteAllDogs();
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
