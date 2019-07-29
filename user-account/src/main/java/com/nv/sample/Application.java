package com.nv.sample;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@SpringBootApplication
public class Application {

  @RequestMapping(value = "/welcome")
  public String available() {
    return "Welcome to user account";
  }

  public static void main(String[] args) {
    SpringApplication.run(Application.class, args);
  }
}
