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

    /**
     * determines if there is a celebrity in the list, only lists with all elements value
     * as zero are celebrities.
     * @param people List of people to be iterated
     * @return Zero if the list is empty or there is no celebrity, else the position of the celebrity.
     */
    public static AtomicInteger isThereCelebrity(List<List<Person>> people) {
        if (!people.isEmpty()) {
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

        return new AtomicInteger(0);
    }


    /**
     * Helper method to fill list of person objects with a defined size, works only for square lists.
     * @param people List to be filled.
     * @param size Desired size of the list.
     */
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

    /**
     * Helper method to see if a person know someone in a list of persons.
     * If the frequency of zeros in a list of persons is different from the size of
     * the list, it means the person knows at least one other person.
     * @param list List of person objects.
     * @return The frequency of the zero in the list
     */
    public static int knowsNoOne(List<Person> list) {
        return Collections.frequency(list, new Person(0));
    }
}
