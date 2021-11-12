package pers.djj.book.service.impl;

import pers.djj.book.dao.BookDao;
import pers.djj.book.dao.impl.BookDaoImpl;
import pers.djj.book.pojo.Book;
import pers.djj.book.pojo.Page;
import pers.djj.book.service.BookService;

import java.util.List;

public class BookServiceImpl implements BookService {
    private final BookDao bookDao = new BookDaoImpl();

    @Override
    public void addBook(Book book) {
        bookDao.addBook(book);
    }

    @Override
    public void deleteBookById(Integer id) {
        bookDao.deleteBookById(id);
    }

    @Override
    public void updateBook(Book book) {
        bookDao.updateBook(book);
    }

    @Override
    public Book queryBookById(Integer id) {
        return bookDao.queryBookById(id);
    }

    @Override
    public List<Book> queryBooks() {
        return bookDao.queryBooks();
    }

    @Override
    public Page<Book> getPage(int pageNumber, int pageSize) {
        Page<Book> page = new Page<>();
        page.setPageSize(pageSize);
        int bookCount = bookDao.queryBookCount();
        page.setTotalItemCount(bookCount);
        int pageCount = bookCount / page.getPageSize();
        if (bookCount % page.getPageSize() != 0) {
            pageCount += 1;
        }
        page.setTotalPageCount(pageCount);
        page.setPageNumber(pageNumber);
        int offset = (page.getPageNumber() - 1) * page.getPageSize();
        List<Book> bookList = bookDao.queryForPage(offset, page.getPageSize());
        page.setItemList(bookList);

//        System.out.println(page);
        return page;
    }

    @Override
    public Page<Book> getPageByPrice(int pageNumber, int pageSize, int minPrice, int maxPrice) {
        Page<Book> page = new Page<>();
        page.setPageSize(pageSize);
        int bookCount = bookDao.queryBookCountByPrice(minPrice, maxPrice);
        page.setTotalItemCount(bookCount);
        int pageCount = bookCount / page.getPageSize();
        if (bookCount % page.getPageSize() != 0) {
            pageCount += 1;
        }
        page.setTotalPageCount(pageCount);
        page.setPageNumber(pageNumber);
        int offset = (page.getPageNumber() - 1) * page.getPageSize();
        List<Book> bookList = bookDao.queryForPageByPrice(offset, page.getPageSize(), minPrice, maxPrice);
        page.setItemList(bookList);

//        System.out.println(page);
        return page;
    }
}
