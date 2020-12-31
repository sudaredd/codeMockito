package app.mockito.testDoubles.fake.repo;

import app.mockito.testDoubles.fake.model.Book;

import java.util.Collection;

public interface BookRepository {
    
    void add(Book book);
    Collection<Book> findAll();
}
