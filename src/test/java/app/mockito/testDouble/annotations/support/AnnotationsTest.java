package app.mockito.testDouble.annotations.support;


import app.mockito.testDoubles.annotations.support.model.Book;
import app.mockito.testDoubles.annotations.support.repo.BookRepository;
import app.mockito.testDoubles.annotations.support.service.BookService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class AnnotationsTest {
    
    @InjectMocks
    private BookService bookService;
    
    @Mock
    private BookRepository bookRepository;
    
    @Test
    public void testStubWithMockito() {
//        BookService bookService = new BookService(bookRepository);

        List<Book> l = new ArrayList<>();
        l.add(new Book("b1", "Junit 5 in  Action", 100, LocalDate.now()));
        l.add(new Book("b2", "Mockit in  Action", 90, LocalDate.now()));

        when(bookRepository.findNewBooks(6)).thenReturn(l);
        List<Book> allBooks = bookService.findBooksWithAppliedDiscount(10,6);
        assertNotNull(allBooks);
        assertEquals(2, allBooks.size());

        assertEquals(90, allBooks.get(0).getPrice());
        assertEquals(81, allBooks.get(1).getPrice());
    }
}
