package com.example.cloud.processor;

import java.math.BigInteger;
import java.util.function.Function;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class PrimeNumberApplication {

  public static void main(String[] args) {
    SpringApplication.run(PrimeNumberApplication.class, args);
  }

  @Bean
  Function<Integer, BigInteger> calculateNthPrime(PrimeNumberService primeNumberService) {
    return primeNumberService::nthPrime;
  }
}
