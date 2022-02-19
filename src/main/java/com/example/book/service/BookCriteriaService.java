package com.example.book.service;

import com.example.book.entity.Author;
import com.example.book.entity.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.*;
import javax.persistence.criteria.*;
import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class BookCriteriaService {

    @Autowired
    private EntityManager entityManager;

    public List<Book> findAll() {
        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
        CriteriaQuery<Book> criteriaQuery = criteriaBuilder.createQuery(Book.class);
        Root<Book> root = criteriaQuery.from(Book.class);

        CriteriaQuery<Book> selectAllBook = criteriaQuery.select(root);
        TypedQuery<Book> typedQuery = entityManager.createQuery(selectAllBook);
        List<Book> resultList = typedQuery.getResultList();
        return resultList;
    }

    public List<Book> findAuthorBooks(Integer id) {
        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
        CriteriaQuery<Book> criteriaQuery = criteriaBuilder.createQuery(Book.class);

        Root<Author> author = criteriaQuery.from(Author.class);
        Path<Book> bookPath = author.get("books");

        CriteriaQuery<Book> selectAllBook = criteriaQuery.select(bookPath)
                .where(criteriaBuilder.equal(author.get("id"), id));

        TypedQuery<Book> typedQuery = entityManager.createQuery(selectAllBook);
        List<Book> resultList = typedQuery.getResultList();
        return resultList;
    }

    public List<Book> findByPrice(double priceFrom, double priceTo) {
        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
        CriteriaQuery<Book> criteriaQuery = criteriaBuilder.createQuery(Book.class);
        Root<Book> root = criteriaQuery.from(Book.class);

        CriteriaQuery<Book> selectBooksByPriceBetween = criteriaQuery.select(root)
                .where(criteriaBuilder.between(root.get("price"), priceFrom, priceTo));

        TypedQuery<Book> typedQuery = entityManager.createQuery(selectBooksByPriceBetween);
        List<Book> resultList = typedQuery.getResultList();
        return resultList;
    }

    public List<Book> findByPrice(double price) {
        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
        CriteriaQuery<Book> criteriaQuery = criteriaBuilder.createQuery(Book.class);
        Root<Book> root = criteriaQuery.from(Book.class);

        CriteriaQuery<Book> selectBooksByPrice = criteriaQuery.select(root)
                .where(criteriaBuilder.equal(root.get("price"), price));

        TypedQuery<Book> typedQuery = entityManager.createQuery(selectBooksByPrice);
        List<Book> resultList = typedQuery.getResultList();
        return resultList;

    }

}
