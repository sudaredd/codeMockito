package app.mockito.testDouble.stub.service;

import app.mockito.testDoubles.stub.model.Book;
import app.mockito.testDoubles.stub.repo.BookRepository;

import java.time.LocalDate;
import java.util.*;

public class StubBookRepository implements BookRepository {

    @Override
    public List<Book> findNewBooks(int days) {
        
        List<Book> l = new ArrayList<>();
        l.add(new app.mockito.testDoubles.stub.model.Book("b1", "Junit 5 in  Action", 100, LocalDate.now()));
        l.add(new app.mockito.testDoubles.stub.model.Book("b2", "Mockit in  Action", 90, LocalDate.now()));
        
        return l;
    }
}
