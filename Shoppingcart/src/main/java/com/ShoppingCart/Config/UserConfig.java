package com.ShoppingCart.Config;

import java.util.List;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.ShoppingCart.Repository.UserRepository;
import com.ShoppingCart.model.User;

@Configuration
public class UserConfig {
	User user;
	UserRepository userRepo;

  @Bean
  CommandLineRunner commandLineRunner(UserRepository userRepo) {
    return args -> {
      User user1 = new User(
          "angelia@gmail.com",
          "12345",
          "Angel",
          "rseiwf@gmail.com",
          "123 Rd"
      );

      User user2 = new User(
          "name2",
          "pass2",
          "name2",
          "Name@email.com",
          "3444 SW "
      );

      //Hard coded user profiles
      userRepo.saveAll(List.of(user1, user2));

    };

  }
}
