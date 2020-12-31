package app.mockito.testDoubles.mock.service;

import app.mockito.testDoubles.mock.model.Book;
import app.mockito.testDoubles.mock.repo.BookRepository;

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

