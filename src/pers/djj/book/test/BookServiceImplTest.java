package pers.djj.book.test;

import pers.djj.book.pojo.Book;
import pers.djj.book.service.BookService;
import pers.djj.book.service.impl.BookServiceImpl;
import org.junit.Test;

import java.math.BigDecimal;

public class BookServiceImplTest {
    private final BookService bookService = new BookServiceImpl();

    @Test
    public void addBook() {
        bookService.addBook(new Book(null, "djj's book", "djj", new BigDecimal(1000000),
                100000000, 0, null));
    }

    @Test
    public void deleteBookById() {
        bookService.deleteBookById(21);
    }

    @Test
    public void updateBook() {
        bookService.updateBook(new Book(21, "djj's another book！", "djj", new BigDecimal(999999),
                10, 111110, null));
    }

    @Test
    public void queryBookById() {
        System.out.println(bookService.queryBookById(21));
    }

    @Test
    public void queryBooks() {
        for (Book queryBook : bookService.queryBooks()) {
            System.out.println(queryBook);
        }
    }

    @Test
    public void getPage() {
        System.out.println(bookService.getPage(2, 3));
    }


    @Test
    public void getPageByPrice() {
        System.out.println(bookService.getPageByPrice(1, 4, 10, 80));
    }
}