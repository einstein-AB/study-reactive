package com.springboot.reactive.exercise;

import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

public class Exercise3 {

    public static void main(String[] args) throws IOException {

        // Use ReactiveSources.intNumbersFlux()

        // Get all numbers in the ReactiveSources.intNumbersFlux stream
        // into a List and print the list and its size
        // TODO: Write code here
        List<Integer> intList = ReactiveSources.intNumbersFlux()
                .toStream()
                .collect(Collectors.toList());// Blocking code that waits for all the elements to be published and then collected in a list

        System.out.println(intList);
        System.out.println(intList.size());

        System.out.println("Press a key to end");
        System.in.read();
    }

}
