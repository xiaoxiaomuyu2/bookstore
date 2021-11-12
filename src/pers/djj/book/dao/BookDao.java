package pers.djj.book.dao;

import pers.djj.book.pojo.Book;

import java.util.List;

public interface BookDao {
    int addBook(Book book);

    int deleteBookById(Integer id);

    int updateBook(Book book);

    Book queryBookById(Integer id);

    List<Book> queryBooks();

    Integer queryBookCount();

    List<Book> queryForPage(int offset, int size);

    int queryBookCountByPrice(int minPrice, int maxPrice);

    List<Book> queryForPageByPrice(int offset, int pageSize, int minPrice, int maxPrice);
}
