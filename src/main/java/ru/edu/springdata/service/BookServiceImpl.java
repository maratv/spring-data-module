package ru.edu.springdata.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.edu.springdata.dto.BookDto;
import ru.edu.springdata.exception.SourceNotFoundException;
import ru.edu.springdata.model.Book;
import ru.edu.springdata.model.Category;
import ru.edu.springdata.repository.BookRepository;
import ru.edu.springdata.repository.CategoryRepository;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class BookServiceImpl implements BookService {

    private final BookRepository bookRepository;
    private final CategoryRepository categoryRepository;

    @Override
    public Book addBook(Book book) {
        return bookRepository.save(book);
    }

    @Override
    public Book updateBook(Long id, BookDto bookDto) {
        Optional<Book> optionalBook = bookRepository.findById(id);
        if (optionalBook.isPresent()) {
            Book book = optionalBook.get();
            book.setTitle(bookDto.getTitle() != null ? bookDto.getTitle() : book.getTitle());
            book.setLanguage(bookDto.getLanguage() != null ? bookDto.getLanguage() : book.getLanguage());
            book.setCategory(bookDto.getCategory() != null ? bookDto.getCategory() : book.getCategory());
            bookRepository.save(book);
            return book;
        } else {
            throw new SourceNotFoundException("Book with id: '" + id + "' not found");
        }
    }

    @Override
    public void deleteBook(Long id) {
        bookRepository.deleteById(id);
    }

    @Override
    public List<Book> getAllBooks() {
        return bookRepository.findAll();
    }

    @Override
    public List<Book> getBooksByCategory(String categoryName) {
        Optional<Category> optionalCategory = categoryRepository.findByName(categoryName);
        if (optionalCategory.isPresent()) {
            return bookRepository.findAllByCategory(optionalCategory.get());
        } else {
            throw new SourceNotFoundException("Category: '" + categoryName + "' not found");
        }
    }

    @Override
    public List<Book> getBooksByLanguage(String language) {
        return bookRepository.findAllByLanguage(language);
    }
}

