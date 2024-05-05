package ru.edu.springdata.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.edu.springdata.model.Book;
import ru.edu.springdata.model.Category;

import java.util.List;

@Repository
public interface BookRepository extends JpaRepository<Book, Long> {

    List<Book> findAllByCategory(Category category);

    List<Book> findAllByLanguage(String language);
}
