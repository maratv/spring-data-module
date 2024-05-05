package ru.edu.springdata.dto;

import lombok.Data;
import ru.edu.springdata.model.Author;
import ru.edu.springdata.model.Category;

import java.util.HashSet;
import java.util.Set;

@Data
public class BookDto {

    private String title;
    private String language;
    private Category category;
    private boolean active;
    private Set<Author> authors = new HashSet<>();
}
