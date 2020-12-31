package app.mockito.testDoubles.stub.repo;

import app.mockito.testDoubles.stub.model.Book;

import java.util.Collection;
import java.util.List;

public interface BookRepository {

    List<Book> findNewBooks(int days);
}
