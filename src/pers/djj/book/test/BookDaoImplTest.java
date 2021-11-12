package pers.djj.book.test;

import pers.djj.book.dao.BookDao;
import pers.djj.book.dao.impl.BookDaoImpl;
import pers.djj.book.pojo.Book;
import org.junit.Test;

import java.math.BigDecimal;

public class BookDaoImplTest {
    private final BookDao bookDao = new BookDaoImpl();

    @Test
    public void addBook() {
        bookDao.addBook(new Book(null, "djj's book", "djj", new
                BigDecimal(9999), 1100000, 0, null
        ));
    }

    @Test
    public void deleteBookById() {
        bookDao.deleteBookById(21);
    }

    @Test
    public void updateBook() {
        bookDao.updateBook(new Book(21, "djj's another book", "djj", new
                BigDecimal(9999), 1100000, 0, null
        ));
    }

    @Test
    public void queryBookById() {
        System.out.println(bookDao.queryBookById(21));
    }

    @Test
    public void queryBooks() {
        for (Book queryBook : bookDao.queryBooks()) {
            System.out.println(queryBook);
        }
    }

    @Test
    public void queryBookCount() {
        System.out.println(bookDao.queryBookCount());
    }

    @Test
    public void queryForPage() {
        for (Book book : bookDao.queryForPage(2, 5)) {
            System.out.println(book);
        }
    }

    @Test
    public void queryBookCountByPrice() {
        System.out.println(bookDao.queryBookCountByPrice(10, 80));
    }

    @Test
    public void queryForPageByPrice() {
        System.out.println(bookDao.queryForPageByPrice(0, 4, 10, 80));
    }
}