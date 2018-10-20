package pl.akademiakodu.dao;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Repository;
import pl.akademiakodu.model.Book;
import pl.akademiakodu.model.Product;

import java.util.*;

@Repository
@Primary
public class BookRepositoryStaticDaoImpl implements BookDao {

    private static Map<String, Book> map = new HashMap<>();
    private static Map<String, Product> map2 = new HashMap<>();


    @Override
    public void save(Book b) {
        map.put(UUID.randomUUID().toString(),b);
    }

    @Override
    public void save2(Product p) {
        System.out.println("Repository " + p.toString());
        map2.put(UUID.randomUUID().toString(),p);}


    @Override
    public List<Book> getList() {
        return new ArrayList<>(map.values());
    }

    @Override
    public List<Product> getList2() {
        return new ArrayList<>(map2.values());
    }


    @Override
    public Book find(int id) {
        return null;
    }

    @Override
    public void remove(int id) {
    }

    @Override
    public void update(Book b) {
    }

    @Override
    public void update2(Product p) {

    }
}