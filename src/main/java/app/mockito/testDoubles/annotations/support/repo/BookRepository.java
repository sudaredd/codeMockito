package app.mockito.testDoubles.annotations.support.repo;

import app.mockito.testDoubles.annotations.support.model.Book;

import java.util.List;

public interface BookRepository {

    List<Book> findNewBooks(int days);
}
