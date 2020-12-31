package app.mockito.testDouble.stub.service;

import app.mockito.testDoubles.stub.model.Book;
import app.mockito.testDoubles.stub.service.BookService;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

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
}
