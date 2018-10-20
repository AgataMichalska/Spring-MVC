package pl.akademiakodu.dao;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Repository;
import pl.akademiakodu.model.Book;
import pl.akademiakodu.model.Product;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@Repository
@Transactional
public class BookRepositoryDbDaoImpl implements BookDao {

    @PersistenceContext
    EntityManager entityManager;

    @Override
    public void save(Book b) {
        entityManager.persist(b);   // persist sama decyduje o b(obiekt - ksiązka)
    }


    @Override
    public List<Book> getList() {
        Query query = entityManager.createQuery("FROM Book b");     //HQL,nie SQL
        List<Book> resultList = (List<Book>) query.getResultList();
        return resultList;
    }

    @Override
    public Book find(int id) {
        return entityManager.find(Book.class, id);
    }

    @Override
    public List<Product> getList2() {
        return null;
    }

    @Override
    public void update2(Product p) {

    }

    @Override
    public void save2(Product p) {

    }

    @Override
    public void remove(int id) {
          // pobiera obiekt i wysyła żadanie delete
        Book book = find(id);
        entityManager.remove(book);

        /* operuje na bazie danych, szybciej
        Query query = entityManager.createQuery("DELETE FROM Book b WHERE b.id = :bid");
        query.setParameter("bid",id);
        query.executeUpdate();*/
    }

    @Override
    public void update(Book b) {
        entityManager.merge(b);

    }
}