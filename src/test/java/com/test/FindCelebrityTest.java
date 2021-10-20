package com.test;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class FindCelebrityTest {

    @Test
    void testCelebrityFound() {
        assertEquals(2,FindCelebrity.isThereCelebrity(fillOneCelebrity()).get());
    }

    @Test
    void testPeopleEmpty() {
        assertEquals(0, FindCelebrity.isThereCelebrity(new ArrayList<>()).get());
    }

    @Test
    void testKnowsNoOne() {
        assertEquals(4, FindCelebrity.knowsNoOne(fillOnePeoplesZeros()));
    }

    @Test
    void testFalseKnowsNoOne() {
        assertNotEquals(0, FindCelebrity.knowsNoOne(fillOnePeoplesNotZeros()));
    }

    private List<Person> fillOnePeoplesZeros() {
        return Arrays.asList(
                new Person(0),
                new Person(0),
                new Person(0),
                new Person(0));
    }

    private List<Person> fillOnePeoplesNotZeros() {
        return Arrays.asList(
                new Person(0),
                new Person(1),
                new Person(0),
                new Person(0));
    }

    private  List<List<Person>> fillOneCelebrity() {
        List<List<Person>> people = new ArrayList<>();
        List<Person> personList1 = Arrays.asList(
                new Person(0),
                new Person(0),
                new Person(1),
                new Person(0));
        people.add(personList1);

        List<Person> personList2 = Arrays.asList(
                new Person(0),
                new Person(0),
                new Person(1),
                new Person(0));
        people.add(personList2);

        List<Person> personList3 = Arrays.asList(
                new Person(0),
                new Person(0),
                new Person(0),
                new Person(0));
        people.add(personList3);

        List<Person> personList4 = Arrays.asList(
                new Person(0),
                new Person(0),
                new Person(1),
                new Person(0));
        people.add(personList4);
        return people;
    }

}