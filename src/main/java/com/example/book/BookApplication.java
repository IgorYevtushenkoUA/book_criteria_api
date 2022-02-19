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
        testJPQL(applicationContext);
        System.out.println("--------------");
//        testCriteriaApi(applicationContext);
    }

    private static void testJPQL(ApplicationContext applicationContext) {
        BookService bookService = applicationContext.getBean(BookService.class);
//        System.out.println(bookService.findAuthorBook(1));
//        System.out.println(bookService.findGroupAuthorsBook(List.of(1, 2)));
//        System.out.println(bookService.findAuthorsBook(List.of(1, 2)));
//        System.out.println(bookService.findByPrice(90,100));
//        System.out.println(bookService.findByPrice(100));
        System.out.println(bookService.findBookByTextInDescriptionOrNameOrAuthorOrPublisher("lol"));
        System.out.println(bookService.findBookByTextInDescriptionOrNameOrAuthorOrPublisher("des"));
        System.out.println(bookService.findBookByTextInDescriptionOrNameOrAuthorOrPublisher("Des"));
    }

    private static void testCriteriaApi(ApplicationContext applicationContext) {
        BookCriteriaService bookCriteriaService = applicationContext.getBean(BookCriteriaService.class);
//        System.out.println(bookCriteriaService.findAll());
        System.out.println(bookCriteriaService.findAuthorBooks(1));
//        System.out.println(bookCriteriaService.findByPrice(90,100));
//        System.out.println(bookCriteriaService.findByPrice(100));
    }
}
