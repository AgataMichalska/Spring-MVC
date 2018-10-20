package pl.akademiakodu.service;

import org.springframework.beans.factory.annotation.Autowired;
import pl.akademiakodu.dao.BookDao;
import pl.akademiakodu.model.Book;
import pl.akademiakodu.model.Product;

import java.util.List;

@org.springframework.stereotype.Service
public class BookServiceImpl implements Service {

    @Autowired
    private BookDao bookDao;


    @Override
    public void save(Book book) {
        if (book.getId() == 0) {
            bookDao.save(book);
        } else {
            bookDao.update(book);
        }
    }

    @Override
    public void save2(Product product) {
            bookDao.save2(product);
           }

    @Override
    public List<Book> getList() {
        return bookDao.getList();
    }

    @Override
    public List<Product> getList2() {
        return bookDao.getList2();
    }

    @Override
    public Book read(int id) {
        return bookDao.find(id);
    }

    @Override
    public void remove(int id) {
        bookDao.remove(id);
    }

    @Override
    public void update(Book book) {
    }

    @Override
    public void update2(Product product) {

    }
}