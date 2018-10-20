package pl.akademiakodu.service;

import pl.akademiakodu.model.Book;
import pl.akademiakodu.model.Product;

import java.util.List;

public interface Service {

    void save(Book book);
    void save2(Product product);

    List<Book> getList();
    List<Product> getList2();

    Book read(int id);

    void remove(int id);

    void update(Book book);
    void update2(Product product);

}