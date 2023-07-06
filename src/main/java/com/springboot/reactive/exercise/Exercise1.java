package com.springboot.reactive.exercise;

import java.util.List;
import java.util.stream.Collectors;

public class Exercise1 {

    // Use StreamSources.intNumbersStream() and StreamSources.userStream()
    public static void main(String[] args) {
        Exercise1 exercise1 = new Exercise1();
        exercise1.challenge1();
        exercise1.challenge2();
        exercise1.challenge3();
        exercise1.challenge4();
        exercise1.challenge5();
        exercise1.challenge6();
    }


    // Print all numbers in the intNumbersStream stream
    // TODO: Write code here
    public void challenge1() {
        StreamSources.intNumbersStream()
                .forEach(num -> System.out.println(num));
    }

    // Print numbers from intNumbersStream that are less than 5
    // TODO: Write code here
    public void challenge2() {
        StreamSources.intNumbersStream()
                .filter(num -> num<5)
                .forEach(num -> System.out.println(num));
    }

    // Print the second and third numbers in intNumbersStream that's greater than 5
    // TODO: Write code here
    public void challenge3() {
        StreamSources.intNumbersStream()
                .filter(num -> num>5)
                .skip(1L)
                .limit(2)
                .forEach(num -> System.out.println(num));
    }

    //  Print the first number in intNumbersStream that's greater than 5.
    // If nothing is found, print -1
    // TODO: Write code here
    public void challenge4() {
        Integer integer = StreamSources.intNumbersStream()
                .filter(num -> num > 5)
                .findFirst().orElse(-1);
        System.out.println(integer);
    }

    // Print first names of all users in userStream
    // TODO: Write code here
    public void challenge5() {
        StreamSources.userStream()
                .map(user -> user.getFirstName())
                .forEach(fName -> System.out.println(fName));
    }

    // Print first names in userStream for users that have IDs from number stream
    // TODO: Write code here
    public void challenge6() {
        //List<Integer> userIdList = StreamSources.intNumbersStream().collect(Collectors.toList());

        StreamSources.userStream()
                //.filter(user -> userIdList.contains(user.getId()))
                .filter(user -> StreamSources.intNumbersStream().anyMatch(id -> id==user.getId())) //or filter() instead of anyMatch()
                .map(user -> user.getFirstName())
                .forEach(fName -> System.out.println(fName));
    }
}
