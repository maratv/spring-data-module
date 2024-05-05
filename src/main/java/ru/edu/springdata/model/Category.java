package ru.edu.springdata.model;

import jakarta.persistence.*;
import lombok.Data;

/**
 * Категория книг. На пр. Health, History, IT
 */
@Data
@Entity
public class Category {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true)
    private String name;
}
