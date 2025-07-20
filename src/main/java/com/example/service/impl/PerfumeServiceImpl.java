package com.example.service.impl;

import com.example.entity.Perfume;
import com.example.service.PerfumeService;
import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * Implementation of PerfumeService using an in-memory list to simulate data storage.
 */
@Service
public class PerfumeServiceImpl implements PerfumeService {

    // In-memory list to store perfume data
    private List<Perfume> perfumes = new ArrayList<>();

    /**
     * Initializes a predefined list of perfumes after the bean is constructed.
     * This simulates loading sample data into memory.
     */
    @PostConstruct
    public void makePerfumes() {
        perfumes.add(Perfume.builder().name("Bellavita, CEO Man").type("Eau de Parfum").quantity("100ml").price(699).build());
        perfumes.add(Perfume.builder().name("EM5, Pause").type("Eau de Parfum").quantity("60ml").price(949).build());
        perfumes.add(Perfume.builder().name("Arabian Aroma, Sauvage").type("Extrait de Parfum").quantity("30ml").price(599).build());
        perfumes.add(Perfume.builder().name("Nautica, Voyage").type("Eau de Toilette").quantity("100ml").price(1948).build());
        perfumes.add(Perfume.builder().name("Bellavita, CEO Man").type("Eau de Cologne ").quantity("50ml").price(699).build());
        perfumes.add(Perfume.builder().name("Wild Stone, Edge").type("Eau de Parfum").quantity("80ml").price(514).build());
        perfumes.add(Perfume.builder().name("OG Luxury, Smokey Intense").type("Extrait de Parfum").quantity("40ml").price(599).build());
        perfumes.add(Perfume.builder().name("Adidas, Victory League").type("Eau de Toilette").quantity("70ml").price(1177).build());
        perfumes.add(Perfume.builder().name("Jaguar, Classic Black").type("Eau de Toilette").quantity("80ml").price(2048).build());
        perfumes.add(Perfume.builder().name("The Man Company, Hope").type("Eau de Parfum").quantity("50ml").price(474).build());
        perfumes.add(Perfume.builder().name("Versace, Man").type("Eau Fraîche").quantity("30ml").price(2942).build());
        perfumes.add(Perfume.builder().name("Bellavita, SKY Aquatic").type("Eau de Cologne").quantity("60ml").price(479).build());
        perfumes.add(Perfume.builder().name("Beardo, Whisky Smoke").type("Eau de Parfum").quantity("50ml").price(265).build());
        perfumes.add(Perfume.builder().name("Fandamei, Hypnos").type("Eau de Cologne").quantity("100ml").price(699).build());
        perfumes.add(Perfume.builder().name("Nautica, Blue").type("Eau de Toilette").quantity("100ml").price(1600).build());

        System.out.println("ALL PERFUMES HAVE BEEN SAVED....");
        perfumes.forEach(System.out::println);
    }

    /**
     * Retrieves all available perfumes.
     *
     * @return Optional containing the list of all perfumes, or empty if none are found
     */
    @Override
    public Optional<List<Perfume>> findAllPerfumes() {
        if (perfumes.isEmpty())
            return Optional.empty();
        else
            return Optional.of(perfumes);
    }

    /**
     * Finds perfumes by their type.
     *
     * @param type the type of perfume to filter by
     * @return Optional containing the filtered list or empty if no match is found
     */
    @Override
    public Optional<List<Perfume>> findPerfumesByType(String type) {
        List<Perfume> list = perfumes.stream()
                .filter(perfume -> perfume.getType().equalsIgnoreCase(type))
                .collect(Collectors.toList());

        return list.isEmpty() ? Optional.empty() : Optional.of(list);
    }

    /**
     * Finds perfumes by their name (case-insensitive).
     *
     * @param name the name of the perfume to search for
     * @return Optional containing a list of matching perfumes or empty if none found
     */
    @Override
    public Optional<List<Perfume>> findPerfumeByName(String name) {
        List<Perfume> temp = new ArrayList<>();
        for (Perfume per : perfumes) {
            if (per.getName().equalsIgnoreCase(name))
                temp.add(per);
        }
        return temp.isEmpty() ? Optional.empty() : Optional.of(temp);
    }

    /**
     * Adds a new perfume to the list.
     *
     * @param perfume the perfume object to add
     * @return the newly added perfume
     */
    @Override
    public Perfume createPerfume(Perfume perfume) {
        perfumes.add(perfume);
        return perfume;
    }

    /**
     * Updates an existing perfume identified by its name.
     *
     * @param name the name of the perfume to update
     * @param perfume the updated perfume data
     * @return Optional containing the updated perfume or empty if no matching perfume is found
     */
    @Override
    public Optional<Perfume> updatePerfume(String name, Perfume perfume) {
        for (Perfume p : perfumes) {
            if (p.getName().equalsIgnoreCase(name)) {
                p.setName(perfume.getName());
                p.setType(perfume.getType());
                p.setQuantity(perfume.getQuantity());
                p.setPrice(perfume.getPrice());
                return Optional.of(perfume);
            }
        }
        return Optional.empty();
    }

    /**
     * Deletes a perfume by its name.
     *
     * @param name the name of the perfume to delete
     * @return Optional containing a success message or empty if no match is found
     */
    @Override
    public Optional<String> deletePerfume(String name) {
        boolean removed = perfumes.removeIf(perfume -> perfume.getName().equalsIgnoreCase(name));
        return removed ? Optional.of(name + " has been removed from the list...") : Optional.empty();
    }
}
