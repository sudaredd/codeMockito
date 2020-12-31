package app.mockito.testDoubles.stub.service;

import app.mockito.testDoubles.stub.model.Book;
import app.mockito.testDoubles.stub.repo.BookRepository;

import java.util.Collection;
import java.util.List;

public class BookService {

    private BookRepository bookRepository;

    public BookService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }


    public List<Book> findBooksWithAppliedDiscount(int discountRate, int days) {

        List<Book> newBooks = bookRepository.findNewBooks(days);
        for (Book book : newBooks) {
            double price = book.getPrice();
            double discountedPrice = price - (price * discountRate) / 100;
            book.setPrice(discountedPrice);
        }
        return newBooks;
    }
}

