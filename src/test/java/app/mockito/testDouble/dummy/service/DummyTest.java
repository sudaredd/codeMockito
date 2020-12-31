package app.mockito.testDouble.dummy.service;

import app.mockito.testDouble.dummy.service.FakeBookRepository;
import app.mockito.testDoubles.dummy.model.Book;
import app.mockito.testDoubles.dummy.repo.BookRepository;
import app.mockito.testDoubles.dummy.service.BookService;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.Collection;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class DummyTest {

    @Test
    public void testDummy() {
        BookService bookService = new BookService(new FakeBookRepository(), new DummyEmailService());
        bookService.addBook(new Book("b1", "Junit 5 in  Action", 31.25, LocalDate.now()));
        bookService.addBook(new Book("b2", "Mockito in  Action", 21.05, LocalDate.now()));
        bookService.addBook(new Book("b3", "Java 8 in  Action", 41.75, LocalDate.now()));

        Collection<Book> allBooks = bookService.findAllBooks();
        assertNotNull(allBooks);
        assertEquals(3, allBooks.size());
    }
}
