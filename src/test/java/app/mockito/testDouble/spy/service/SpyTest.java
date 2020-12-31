package app.mockito.testDouble.spy.service;

import app.mockito.testDoubles.spy.model.Book;
import app.mockito.testDoubles.spy.service.BookService;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

public class SpyTest {
    
    @Test
    public void testSpy() {
        SpyBookRepository spyBookRepository = new SpyBookRepository();
        BookService bookService = new BookService(spyBookRepository);

        Book book1 = new Book("b1", "Junit 5 in  Action", 50, LocalDate.now());
        
        bookService.addBook(book1);
        
        assertEquals(spyBookRepository.getAddCalled(), 0);
//        assertTrue(spyBookRepository.isLastBook(book1));


        Book book2 = new Book("b2", "Mockit in  Action", 75, LocalDate.now());

        bookService.addBook(book2);

        assertEquals(spyBookRepository.getAddCalled(), 1);
        assertTrue(spyBookRepository.isLastBook(book2));
    }
}
