package com.example.book.service;

import com.example.book.entity.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.*;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
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

        CriteriaQuery<Book> selectAllPerson = criteriaQuery.select(root);
        TypedQuery<Book> typedQuery = entityManager.createQuery(selectAllPerson);
        List<Book> resultList = typedQuery.getResultList();
        return resultList;
    }

}
