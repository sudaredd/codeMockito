package app.mockito.stubbing.repo;

import app.mockito.stubbing.model.Book;

import java.util.List;

public interface BookRepository {

    List<Book> findNewBooks(int days);

    Book findBookByBookId(String bookId);

    void save(Book book);
}
