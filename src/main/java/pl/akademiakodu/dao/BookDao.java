package pl.akademiakodu.dao;

import pl.akademiakodu.model.Book;
import pl.akademiakodu.model.Product;

import java.util.ArrayList;
import java.util.List;

public interface BookDao {

    void save(Book b);
    void save2(Product p);

    List<Book> getList();

    List<Product> getList2();

    Book find(int id);

    void remove(int id);

    void update(Book b);
    void update2(Product p);

}