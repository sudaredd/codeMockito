package app.mockito.testDouble.stub.service;

import app.mockito.testDoubles.stub.model.Book;
import app.mockito.testDoubles.stub.repo.BookRepository;
import app.mockito.testDoubles.stub.service.BookService;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class StubTest {
    
    @Test
    public void testStub() {
        BookService bookService = new BookService(new StubBookRepository());

        List<Book> allBooks = bookService.findBooksWithAppliedDiscount(10,6);
        assertNotNull(allBooks);
        assertEquals(2, allBooks.size());
        
        assertEquals(90, allBooks.get(0).getPrice());
        assertEquals(81, allBooks.get(1).getPrice());
    } 
    
    @Test
    public void testStubWithMockito() {
        BookRepository bookRepository = mock(BookRepository.class);
        BookService bookService = new BookService(bookRepository);

        List<Book> l = new ArrayList<>();
        l.add(new app.mockito.testDoubles.stub.model.Book("b1", "Junit 5 in  Action", 100, LocalDate.now()));
        l.add(new app.mockito.testDoubles.stub.model.Book("b2", "Mockit in  Action", 90, LocalDate.now()));

        when(bookRepository.findNewBooks(6)).thenReturn(l);
        List<Book> allBooks = bookService.findBooksWithAppliedDiscount(10,6);
        assertNotNull(allBooks);
        assertEquals(2, allBooks.size());
        
        assertEquals(90, allBooks.get(0).getPrice());
        assertEquals(81, allBooks.get(1).getPrice());
    }
}
