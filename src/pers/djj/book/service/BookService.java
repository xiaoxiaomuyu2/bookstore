package pers.djj.book.service;

import pers.djj.book.pojo.Book;
import pers.djj.book.pojo.Page;

import java.util.List;

public interface BookService {
    void addBook(Book book);

    void deleteBookById(Integer id);

    void updateBook(Book book);

    Book queryBookById(Integer id);

    List<Book> queryBooks();

    Page<Book> getPage(int pageNumber, int pageSize);

    Page<Book> getPageByPrice(int pageNumber, int pageSize, int minPrice, int maxPrice);
}