package app.mockito.testDoubles.fake.service;

import app.mockito.testDoubles.fake.model.Book;
import app.mockito.testDoubles.fake.repo.BookRepository;

import java.util.Collection;

public class BookService {

    private BookRepository bookRepository;

    public BookService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    public void addBook(Book book) {
        bookRepository.add(book);
    }

    public Collection<Book> findAllBooks() {
        return bookRepository.findAll();
    }

    public int findNumberOfBooks() {
        return bookRepository.findAll().size();
    }
}

