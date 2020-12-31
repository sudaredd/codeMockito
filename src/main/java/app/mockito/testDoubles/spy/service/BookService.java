package app.mockito.testDoubles.spy.service;

import app.mockito.testDoubles.spy.model.Book;
import app.mockito.testDoubles.spy.repo.BookRepository;

import java.util.Collection;

public class BookService {

    private BookRepository bookRepository;

    public BookService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    public void addBook(Book book) {
        if(book.getPrice() <=50)
            return;
        bookRepository.add(book);
    }
    
}

