package app.mockito.testDouble.fake.service;

import app.mockito.testDoubles.fake.model.Book;
import app.mockito.testDoubles.fake.service.BookService;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.Collection;

public class FakeTest {
    
    @Test
    public void testFake() {
        BookService bookService = new BookService(new FakeBookRepository());
        bookService.addBook(new Book("b1", "Junit 5 in  Action", 31.25, LocalDate.now()));
        bookService.addBook(new Book("b2", "Mockito in  Action", 21.05, LocalDate.now()));
        bookService.addBook(new Book("b3", "Java 8 in  Action", 41.75, LocalDate.now()));

        Collection<Book> allBooks = bookService.findAllBooks();
        assertNotNull(allBooks);
        assertEquals(3, allBooks.size());
    }
}
