package com.example.cloud.processor;

import java.math.BigInteger;

import org.springframework.stereotype.Service;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class PrimeNumberService {

  public BigInteger nthPrime(int input) {
    log.info("Calculating the Nth Prime for " + input);

    int primeCount = 0;
    BigInteger number = BigInteger.ONE;
    while (primeCount < input) {
      number = number.add(BigInteger.ONE);
      if (isPrime(number)) {
        ++primeCount;
      }
    }

    return number;
  }

  private boolean isPrime(BigInteger candidate) {
    if (candidate.compareTo(BigInteger.ONE) <= 0) {
      return false;
    }

    BigInteger potentialDivisor = BigInteger.valueOf(2l);
    while (!candidate.mod(potentialDivisor).equals(BigInteger.ZERO)) {
      potentialDivisor = potentialDivisor.add(BigInteger.ONE);
    }

    return potentialDivisor.equals(candidate);
  }
}
