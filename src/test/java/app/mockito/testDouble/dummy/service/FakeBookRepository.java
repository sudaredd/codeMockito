package app.mockito.testDouble.dummy.service;

import app.mockito.testDoubles.dummy.model.Book;
import app.mockito.testDoubles.dummy.repo.BookRepository;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class FakeBookRepository implements BookRepository {

    private Map<String, Book> bookStoreMap = new HashMap<>();

    @Override
    public void add(Book book) {
        bookStoreMap.put(book.getBookId(), book);
    }

    @Override
    public Collection<Book> findAll() {
        return bookStoreMap.values();
    }
}
