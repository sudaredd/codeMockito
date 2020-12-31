package app.mockito.testDouble.mock.service;

import app.mockito.testDoubles.mock.model.Book;
import app.mockito.testDoubles.mock.service.BookService;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

public class MockTest {
    
    @Test
    public void testMock() {
        MockBookRepository mockBookRepository = new MockBookRepository();
        BookService bookService = new BookService(mockBookRepository);

        Book book1 = new Book("b1", "Junit 5 in  Action", 50, LocalDate.now());
        
        bookService.addBook(book1);
        
        Book book2 = new Book("b2", "Mockit in  Action", 75, LocalDate.now());

        bookService.addBook(book2);

        mockBookRepository.verify(book2, 1);
    }
}
