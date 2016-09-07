package com.vava.java8;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * Created by vasantas on 9/6/2016.
 */
public class StreamsTest {
    public static void main(String[] args) {
        StreamsTest test = new StreamsTest();
        test.testReduce();
    }

    private void testReduce(){
        List<Integer> numbers1 = Arrays.asList(0xA, 202, 39);

        numbers1.stream().reduce( (a,b) -> a+b).ifPresent(System.out::println);

        numbers1.stream().reduce( Math::min).ifPresent(System.out::println);
    }

    private void pairs(){
        List<Integer> numbers1 = Arrays.asList(1, 2, 3);
        List<Integer> numbers2 = Arrays.asList(3, 4);

        numbers1.stream().flatMap( i -> numbers2.stream().map( j -> new int[]{i,j})).forEach(a -> System.out.println(Arrays.toString(a)));
    }

    private void testSquares(){
        List<Double> numbers = Arrays.asList(1d, 2d, 3d, 4d, 5d);
        numbers.stream().map(i -> i * i).forEach(System.out::println);
    }

    private void testCount() {
        List<String> data = Arrays.asList("one", "two", "three", "four", "five", "six", "seven");

        data.stream().forEach(System.out::println);

        System.out.println(data.stream().count());
        data.stream().map(String::length).forEach(System.out::println);
        data.stream().map( w -> w.split("") ).flatMap(Arrays::stream).sorted().forEach(System.out::println);
        data.stream().map( w -> w.split("") ).flatMap(Arrays::stream).distinct().map(w -> "->" +w).forEach(System.out::println);


    }
}
