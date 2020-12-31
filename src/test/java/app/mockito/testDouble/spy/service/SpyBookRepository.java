package app.mockito.testDouble.spy.service;

import app.mockito.testDoubles.spy.model.Book;
import app.mockito.testDoubles.spy.repo.BookRepository;

public class SpyBookRepository implements BookRepository {

    private int addCalled;

    private Book lastBook;

    @Override
    public void add(Book book) {
        lastBook = book;
        addCalled++;
    }

    public int getAddCalled() {
        return addCalled;
    }

    public boolean isLastBook(Book  book) {
        return lastBook.equals(book);
    }
}
