package com.vava.java8;

import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.LongStream;

/**
 * Created by vasantas on 9/7/2016.
 */
public class PrimePartitioner {
    public static void main(String[] args) {
        PrimePartitioner pp = new PrimePartitioner();
        pp.testPrime(10000000000L);
    }

    private void testPrime(long n) {
        Map<Boolean, List<Long>> m = LongStream.range(1L, n).parallel().boxed().collect(Collectors.partitioningBy(this::isPrime));
        System.out.println(m);
    }

    private boolean isPrime(long c){
        return LongStream.range(2L,c).parallel().noneMatch( i -> c % i ==0);
    }
}
