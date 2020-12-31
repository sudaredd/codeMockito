package app.mockito.testDoubles.dummy.repo;

import app.mockito.testDoubles.dummy.model.Book;

import java.util.Collection;

public interface BookRepository {
    
    void add(Book book);
    Collection<Book> findAll();
}
