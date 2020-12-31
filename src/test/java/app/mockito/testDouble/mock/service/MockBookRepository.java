package app.mockito.testDouble.mock.service;

import app.mockito.testDoubles.mock.model.Book;
import app.mockito.testDoubles.mock.repo.BookRepository;
import org.junit.jupiter.api.Assertions;

public class MockBookRepository implements BookRepository {

    private int addCalled;

    private Book lastBook;

    @Override
    public void add(Book book) {
        lastBook = book;
        addCalled++;
    }

    public void verify(Book book2, int i) {
        Assertions.assertEquals(book2, lastBook);
        Assertions.assertEquals(addCalled, i);
    }
}
