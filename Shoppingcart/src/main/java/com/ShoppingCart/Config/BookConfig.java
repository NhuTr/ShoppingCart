package com.ShoppingCart.Config;

import java.util.List;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.ShoppingCart.Repository.BookRepository;

import com.ShoppingCart.model.Book;


@Configuration
public class BookConfig {
	Book book;
	BookRepository bookRepo;

  @Bean
  CommandLineRunner commandLineRunner1(BookRepository bookRepo) {
    return args -> {
      Book book1 = new Book(
          "A Quite Place",
          "Megan Miranda",
          "Horror",
          "9780689815119"
      );

      Book book2 = new Book(
          "The Selfish Gene",
          "Richard Dawkins",
          "Science",
          "9780192177735"
         
      );

      //Hard coded user profiles
      bookRepo.saveAll(List.of(book1, book2));

    };

  }
}
