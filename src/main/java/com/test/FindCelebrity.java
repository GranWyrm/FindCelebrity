package com.test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.IntStream;

public class FindCelebrity {
    public static void main(String[] args) {
        List<List<Person>> people = new ArrayList<>();
        final int SIZE = 5;
        fillArray(people,SIZE);

        people.forEach(System.out::println);

        AtomicInteger position = isThereCelebrity(people);

        if (position.get() != 0) {
            System.out.println("Celebrity found in position: " + position.get());
        } else {
            System.out.println("Celebrity not found");
        }
    }

    public static AtomicInteger isThereCelebrity(List<List<Person>> people) {
        if (people.isEmpty()) {
            return new AtomicInteger(0);
        }
        AtomicInteger celebrityPosition = new AtomicInteger(0);
        people.forEach(
                p -> {
                    if (knowsNoOne(p) == p.size()) {
                        celebrityPosition.set(people.indexOf(p));
                    }
                }
        );

        return celebrityPosition;
    }

    public static void fillArray(List<List<Person>> people, int size) {

        IntStream.range(0, size)
                .<ArrayList<Person>>mapToObj(i -> new ArrayList<>())
                .forEach(people::add);
        people.forEach(
                personList -> IntStream.range(0, size)
                        .mapToObj(i -> new Person(ThreadLocalRandom.current().nextInt(0,2)))
                        .forEach(personList::add)
        );
    }

    public static int knowsNoOne(List<Person> list) {
        return Collections.frequency(list, new Person(0));
    }
}
