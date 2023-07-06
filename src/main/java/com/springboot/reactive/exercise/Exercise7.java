package com.springboot.reactive.exercise;

import java.io.IOException;

public class Exercise7 {


    public static void main(String[] args) throws IOException {

        // Use ReactiveSources.intNumbersFlux() and ReactiveSources.userMono()

        // Print all values from intNumbersFlux that's greater than 5
        // TODO: Write code here
        ReactiveSources.intNumbersFlux()
                .filter(integer -> integer > 5)
                .subscribe(integer -> System.out.println(integer));

        // Print 10 times each value from intNumbersFlux that's greater than 5
        // TODO: Write code here
        ReactiveSources.intNumbersFlux()
                .filter(integer -> integer > 5)
                .map(integer -> integer*10)
                .subscribe(integer -> System.out.println(integer));

        // Print 10 times each value from intNumbersFlux for the first 3 numbers emitted that's greater than 5
        // TODO: Write code here
        ReactiveSources.intNumbersFlux()
                .filter(integer -> integer > 5)
                .take(3)
                .map(integer -> integer*10)
                .subscribe(integer -> System.out.println(integer));

        // Print each value from intNumbersFlux that's greater than 20. Print -1 if no elements are found
        // TODO: Write code here
        ReactiveSources.intNumbersFlux()
                .filter(integer -> integer >20)
                .defaultIfEmpty(-1)
                .subscribe(integer -> System.out.println(integer));

        // Switch ints from intNumbersFlux to the right user from userFlux
        // TODO: Write code here
        ReactiveSources.intNumbersFlux()
                .flatMap(integer -> ReactiveSources.userFlux().filter(user -> user.getId() == integer)) //any() instead of filter()
                .subscribe(user -> System.out.println(user));

        // Print only distinct numbers from intNumbersFluxWithRepeat
        // TODO: Write code here
        ReactiveSources.intNumbersFluxWithRepeat()
                .distinct()
                .subscribe(integer -> System.out.println(integer));

        // Print from intNumbersFluxWithRepeat excluding immediately repeating numbers
        // TODO: Write code here
        ReactiveSources.intNumbersFluxWithRepeat()
                .distinctUntilChanged()
                .subscribe(integer -> System.out.println(integer));

        System.out.println("Press a key to end");
        System.in.read();
    }

}
