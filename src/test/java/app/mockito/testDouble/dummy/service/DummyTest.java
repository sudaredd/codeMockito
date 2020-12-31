package app.mockito.testDouble.dummy.service;

import app.mockito.testDoubles.dummy.model.Book;
import app.mockito.testDoubles.dummy.service.BookService;
import app.mockito.testDoubles.dummy.repo.BookRepository;
import app.mockito.testDoubles.dummy.service.EmailService;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collection;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

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
    
    @Test
    public void testDummyWithMockito() {
        BookRepository bookRepository = mock(BookRepository.class);

        EmailService emailService = mock(EmailService.class);

        BookService bookService = new BookService(bookRepository, emailService);

        Book book1 = new Book("b1", "Junit 5 in  Action", 31.25, LocalDate.now());
        Book book2 = new Book("b2", "Mockito in  Action", 21.05, LocalDate.now());

        Collection<Book> books = new ArrayList<>();
        books.add(book1);
        books.add(book2);

        when(bookRepository.findAll()).thenReturn(books);
        
//        when(emailService.sendEmail(Mockito.anyString())).thenThrow(new AssertionError(""));

        assertEquals(bookService.findNumberOfBooks(), 2);
    }
}
