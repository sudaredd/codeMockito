package app.mockito.testDoubles.dummy.service;

import app.mockito.testDoubles.dummy.model.Book;
import app.mockito.testDoubles.dummy.repo.BookRepository;

import java.util.Collection;

public class BookService {

    private BookRepository bookRepository;

    private EmailService emailService;

    public BookService(BookRepository bookRepository, EmailService emailService) {
        this.bookRepository = bookRepository;
        this.emailService = emailService;
    }

    public void addBook(Book book) {
        bookRepository.add(book);
    }

    public Collection<Book> findAllBooks() {
        return bookRepository.findAll();
    }

    public void sendMsg(String msg) {
        emailService.sendEmail(msg);
    }

    public int findNumberOfBooks() {
        return bookRepository.findAll().size();
    }
}

