package com.example.book;

import com.example.book.service.BookCriteriaService;
import com.example.book.service.BookService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import java.util.List;

@SpringBootApplication
public class BookApplication {

    public static void main(String[] args) {
        ApplicationContext applicationContext = SpringApplication.run(BookApplication.class, args);
        testCriteriaApi(applicationContext);
    }

    private static void testJPQL(ApplicationContext applicationContext) {
        BookService bookService = applicationContext.getBean(BookService.class);
        System.out.println(bookService.findAuthorBook(1));
        System.out.println(bookService.findGroupAuthorsBook(List.of(1,2)));
        System.out.println(bookService.findAuthorsBook(List.of(1,2)));
        System.out.println(bookService.findByPrice(12,15));
        System.out.println(bookService.findByPrice(100));
    }

    private static void testCriteriaApi(ApplicationContext applicationContext){
        BookCriteriaService bookCriteriaRepository = applicationContext.getBean(BookCriteriaService.class);
        System.out.println(bookCriteriaRepository.findAll());
    }

}
