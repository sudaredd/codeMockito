package app.mockito.stubbing.service;

import app.mockito.stubbing.model.Book;
import app.mockito.stubbing.repo.BookRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.exceptions.misusing.PotentialStubbingProblem;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class BookServiceTest {

    @InjectMocks
    private BookService bookService;

    @Mock
    private BookRepository bookRepository;

    @Test
    public void testCalculateTotalCostOfBooks() {
        List<String> booksids = new ArrayList<>();
        booksids.add("b1");
        booksids.add("b2");
        Book b1 = new Book("b1", "Junit 5 in  Action", 100, LocalDate.now());
        Book b2 = new Book("b2", "Mockit in  Action", 90, LocalDate.now());

        when(bookRepository.findBookByBookId("b1")).thenReturn(b1);
        when(bookRepository.findBookByBookId("b2")).thenReturn(b2);

        double actualCost = bookService.calculateTotalCost(booksids);


        assertEquals(190.0, actualCost, 0.01);


    }

    @Test
    public void testCalculateTotalCostOfBooks_doReturn() {
        List<String> booksids = new ArrayList<>();
        booksids.add("b1");
        booksids.add("b2");
        Book b1 = new Book("b1", "Junit 5 in  Action", 100, LocalDate.now());
        Book b2 = new Book("b2", "Mockit in  Action", 90, LocalDate.now());

        doReturn(b1).when(bookRepository).findBookByBookId("b1");
        doReturn(b2).when(bookRepository).findBookByBookId("b2");

        double actualCost = bookService.calculateTotalCost(booksids);


        assertEquals(190.0, actualCost, 0.01);
    }

    @Test
    public void testVoidMethod() {
        Book b1 = new Book("b1", "Junit 5 in  Action", 100, LocalDate.now());

        doNothing().when(bookRepository).save(b1);

        bookService.addBook(b1);
    }

    @Test
    public void testVoidMethod_PotentialStubbingException() {
        Book b1 = new Book("b1", "Junit 5 in  Action", 100, LocalDate.now());
        Book b2 = new Book("b2", "Junit 5 in  Action", 100, LocalDate.now());

        doNothing().when(bookRepository).save(b1);

        PotentialStubbingProblem potentialStubbingProblem = assertThrows(PotentialStubbingProblem.class, () -> bookService.addBook(b2));
        System.out.println("excep::" + potentialStubbingProblem.getLocalizedMessage());
    }
}
