package app.mockito.stubbing.service;

import app.mockito.stubbing.model.Book;
import app.mockito.stubbing.repo.BookRepository;

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

    public double calculateTotalCost(List<String> bookIds) {

        double total = 0;
        for (String bookId : bookIds) {
            
            Book book = bookRepository.findBookByBookId(bookId);
            total += book.getPrice();
        }
        return total;
    }
    
    public void addBook(Book book) {
        bookRepository.save(book);
    }
}

