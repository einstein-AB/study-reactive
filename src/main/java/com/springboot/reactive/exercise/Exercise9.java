package com.springboot.reactive.exercise;

import java.io.IOException;

public class Exercise9 {


    public static void main(String[] args) throws IOException {

        // Use ReactiveSources.intNumbersFlux()

        // Print size of intNumbersFlux after the last item returns
        // TODO: Write code here
        /*ReactiveSources.intNumbersFlux()
                .count()
                .subscribe(aLongCount -> System.out.println(aLongCount));*/

        // Collect all items of intNumbersFlux into a single list and print it
        // TODO: Write code here
        /*ReactiveSources.intNumbersFlux()
                .collectList()
                .subscribe(integers -> System.out.println(integers));*/

        // Transform to a sequence of sums of adjacent two numbers
        // TODO: Write code here
        ReactiveSources.intNumbersFlux()
                .buffer(2)
                .map(integerList -> integerList.get(0) + integerList.get(1))
                .subscribe(integerSum -> System.out.println(integerSum));


        System.out.println("Press a key to end");
        System.in.read();
    }

}
