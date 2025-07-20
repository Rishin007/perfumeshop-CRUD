package com.example.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Represents a Perfume entity with basic attributes such as name, type, quantity, and price.
 *
 * Lombok annotations are used to reduce boilerplate:
 * - @Data: Generates getters, setters, toString, equals, and hashCode methods.
 * - @Builder: Enables the builder pattern for easy object creation.
 * - @NoArgsConstructor: Generates a no-argument constructor.
 * - @AllArgsConstructor: Generates a constructor with all fields.
 */
@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class Perfume {

    /** The name of the perfume (e.g., "Bellavita, CEO Man") */
    private String name;

    /** The type of perfume (e.g., "Eau de Parfum", "Extrait de Parfum") */
    private String type;

    /** The quantity or volume of the perfume (e.g., "100ml", "50ml") */
    private String quantity;

    /** The price of the perfume in currency units (e.g., 699) */
    private Integer price;
}
