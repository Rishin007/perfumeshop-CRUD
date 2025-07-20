package com.example.service;

import com.example.entity.Perfume;

import java.util.List;
import java.util.Optional;

/**
 * Service interface for managing perfume operations.
 */
public interface PerfumeService {

    /**
     * Retrieves all perfumes available in the system.
     *
     * @return an Optional containing a list of all perfumes, or empty if none found
     */
    Optional<List<Perfume>> findAllPerfumes();

    /**
     * Finds all perfumes matching the given type.
     *
     * @param type the type of perfume to search for (e.g., "Eau de Parfum")
     * @return an Optional containing a list of perfumes of the specified type, or empty if none found
     */
    Optional<List<Perfume>> findPerfumesByType(String type);

    /**
     * Finds perfumes by their name.
     *
     * @param name the name of the perfume to search for
     * @return an Optional containing a list of perfumes with the specified name, or empty if none found
     */
    Optional<List<Perfume>> findPerfumeByName(String name);

    /**
     * Creates and saves a new perfume in the system.
     *
     * @param perfume the perfume object to be created
     * @return the created perfume object
     */
    Perfume createPerfume(Perfume perfume);

    /**
     * Updates the details of an existing perfume identified by name.
     *
     * @param name the name of the perfume to update
     * @param perfume the perfume object containing updated information
     * @return an Optional containing the updated perfume, or empty if the perfume was not found
     */
    Optional<Perfume> updatePerfume(String name, Perfume perfume);

    /**
     * Deletes a perfume from the system by its name.
     *
     * @param name the name of the perfume to delete
     * @return an Optional containing a success message, or empty if the perfume was not found
     */
    Optional<String> deletePerfume(String name);
}
