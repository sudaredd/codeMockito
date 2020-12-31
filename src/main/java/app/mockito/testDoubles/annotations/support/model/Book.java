package app.mockito.testDoubles.annotations.support.model;

import java.time.LocalDate;
import java.util.Objects;

public class Book {
    private String bookId;
    private String bookName;
    private double price;
    private LocalDate publishedDate;

    public Book(String bookId, String bookName, double price, LocalDate publishedDate) {
        this.bookId = bookId;
        this.bookName = bookName;
        this.price = price;
        this.publishedDate = publishedDate;
    }

    public String getBookId() {
        return bookId;
    }

    public String getBookName() {
        return bookName;
    }

    public double getPrice() {
        return price;
    }

    public LocalDate getPublishedDate() {
        return publishedDate;
    }

    @Override
    public String toString() {
        return "Book{" +
                "bookId='" + bookId + '\'' +
                ", bookName='" + bookName + '\'' +
                ", price=" + price +
                ", publishedDate=" + publishedDate +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Book book = (Book) o;
        return Double.compare(book.price, price) == 0 &&
                Objects.equals(bookId, book.bookId) &&
                Objects.equals(bookName, book.bookName) &&
                Objects.equals(publishedDate, book.publishedDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(bookId, bookName, price, publishedDate);
    }

    public void setPrice(double discountedPrice) {
        price = discountedPrice;
    }
}
