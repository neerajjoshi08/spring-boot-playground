package com.example.playground.aop.controller;

import com.example.playground.aop.annotation.MyLogger;
import java.util.List;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/products")
public class MyController {

  @GetMapping("/v1")
  public List<?> getProductsV1() {
    long start = System.currentTimeMillis();

    try {
      Thread.sleep(4_000);
    } catch (InterruptedException e) {
      throw new RuntimeException(e);
    }

    long end = System.currentTimeMillis();
    System.out.println("Time took: " + (end - start));
    return List.of();
  }

  @GetMapping("/v2")
  public List<?> getProductsV2() {
    long start = System.currentTimeMillis();

    try {
      Thread.sleep(200);
    } catch (InterruptedException e) {
      throw new RuntimeException(e);
    }

    long end = System.currentTimeMillis();
    System.out.println("Time took: " + (end - start));
    return List.of();
  }

  @GetMapping("/v3")
  @MyLogger
  public List<?> getProductsV3() {

    try {
      Thread.sleep(3000);
    } catch (InterruptedException e) {
      throw new RuntimeException(e);
    }

    return List.of();
  }
}
