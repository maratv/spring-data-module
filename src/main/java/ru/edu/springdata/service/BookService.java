package ru.edu.springdata.service;

import ru.edu.springdata.dto.BookDto;
import ru.edu.springdata.model.Book;
import java.util.List;

public interface BookService {
    Book addBook(Book book);

    Book updateBook(Long id, BookDto bookDto);

    void deleteBook(Long id);

    List<Book> getAllBooks();

    List<Book> getBooksByCategory(String categoryName);

    List<Book> getBooksByLanguage(String language);
}
