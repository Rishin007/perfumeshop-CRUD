package com.example.controller;

import com.example.entity.Perfume;
import com.example.exception.PerfumeNotFoundException;
import com.example.exception.ResourceNotFoundException;
import com.example.service.PerfumeService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * REST controller for handling HTTP requests related to perfumes.
 * Provides endpoints to perform CRUD operations on perfume resources.
 */

@Tag(
        name = "CRUD REST APIs using COLLECTIONS",
        description = "This project focuses on implementing the basic CRUD operations :-" +
                " CREATE,READ,UPDATE,DELETE of a collection of perfumes. " +
                "This also involves the use of Exceptions to handle prior exceptions while working with data."
)
@AllArgsConstructor
@RestController
@RequestMapping("perfumes")
public class PerfumeController {

    /** Service layer dependency to handle perfume business logic */
    private final PerfumeService perfumeService;

    /**
     * Retrieves all available perfumes.
     *
     * @return ResponseEntity containing list of all perfumes and HTTP status 200 (OK),
     *         or throws PerfumeNotFoundException if no perfumes are available.
     */
    @Operation(
            summary = "To read all perfumes REST API",
            description = "Fetching all the perfumes from the collection " +
                    "which is here acting as data base"
    )
    @GetMapping()
    public ResponseEntity<List<Perfume>> getAllPerfumes() {
        return new ResponseEntity<>(
                perfumeService.findAllPerfumes()
                        .orElseThrow(() -> new PerfumeNotFoundException()), HttpStatus.OK);
    }

    /**
     * Retrieves perfumes filtered by type.
     *
     * @param type the type of perfume (e.g., "Eau de Parfum")
     * @return ResponseEntity containing list of matching perfumes and HTTP status 200 (OK),
     *         or throws ResourceNotFoundException if no perfumes of the given type are found.
     */
    @Operation(
            summary = "To read all perfumes REST API",
            description = "Fetching all the perfumes from the collection based on their TYPE"

    )
    @GetMapping("{type}")
    public ResponseEntity<List<Perfume>> getPerfumesByType(@PathVariable String type) {
        return new ResponseEntity<>(
                perfumeService.findPerfumesByType(type)
                        .orElseThrow(() -> new ResourceNotFoundException("Perfume", "type", type)), HttpStatus.OK);
    }

    /**
     * Retrieves perfumes filtered by name.
     *
     * @param name the name of the perfume
     * @return ResponseEntity containing list of perfumes with the given name and HTTP status 200 (OK),
     *         or throws ResourceNotFoundException if no perfumes with the name are found.
     */
    @Operation(
            summary = "To read all perfumes REST API",
            description = "Fetching all the perfumes from the collection based on their NAME "
    )
    @GetMapping("specific")
    public ResponseEntity<List<Perfume>> getPerfumeByName(@RequestParam String name) {
        return new ResponseEntity<>(
                perfumeService.findPerfumeByName(name)
                        .orElseThrow(() -> new ResourceNotFoundException("Perfume", "name", name)), HttpStatus.OK);
    }

    /**
     * Creates a new perfume.
     *
     * @param perfume the perfume object to be added
     * @return ResponseEntity containing the created perfume and HTTP status 201 (Created)
     */
    @Operation(
            summary = "CREATE perfume REST API",
            description = "Fetching all the perfumes from the collection " +
                    "which is here acting as data base"
    )
    @PostMapping()
    public ResponseEntity<Perfume> createPerfume(@RequestBody Perfume perfume) {
        return new ResponseEntity<>(perfumeService.createPerfume(perfume), HttpStatus.CREATED);
    }

    /**
     * Updates an existing perfume by its name.
     *
     * @param name the current name of the perfume to update
     * @param perfume the perfume object with updated data
     * @return ResponseEntity containing the updated perfume and HTTP status 200 (OK),
     *         or throws ResourceNotFoundException if no matching perfume is found.
     */
    @Operation(
            summary = "UPDATE perfume REST API",
            description = "Fetching all the perfumes from the collection " +
                    "which is here acting as data base"
    )
    @PutMapping("{name}")
    public ResponseEntity<Perfume> updatePerfume(@PathVariable String name, @RequestBody Perfume perfume) {
        return new ResponseEntity<>(
                perfumeService.updatePerfume(name, perfume)
                        .orElseThrow(() -> new ResourceNotFoundException("Perfume", "name", name)), HttpStatus.OK);
    }

    /**
     * Deletes a perfume by its name.
     *
     * @param name the name of the perfume to delete
     * @return ResponseEntity containing a success message and HTTP status 200 (OK),
     *         or throws ResourceNotFoundException if no matching perfume is found.
     */
    @Operation(
            summary = "DELTE perfume REST API",
            description = "Fetching all the perfumes from the collection " +
                    "which is here acting as data base"
    )
    @DeleteMapping("{name}")
    public ResponseEntity<String> deletePerfume(@PathVariable String name) {
        return new ResponseEntity<>(
                perfumeService.deletePerfume(name)
                        .orElseThrow(() -> new ResourceNotFoundException("Perfume", "name", name)), HttpStatus.OK);
    }
}
