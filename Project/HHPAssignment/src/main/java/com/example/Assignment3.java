package com.example;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Assignment3 {

    public static List<?> fibo(int series) {
        return Stream.iterate(new int[] { 0, 1 }, t -> new int[] { t[1], t[0] + t[1] }).limit(series)

                .map(n -> n[0]).collect(Collectors.toList());

    }

    public static void main(String[] args) {
        System.out.println(fibo(10));

    }

}
