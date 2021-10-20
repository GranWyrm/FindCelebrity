package com.test;

import java.util.Objects;

public class Person {
    private int knowsSomeone;

    public Person(int knowsSomeone) {
        this.knowsSomeone = knowsSomeone;
    }

    public int knowsSomeone() {
        return knowsSomeone;
    }

    public void setKnowsSomeone(int knowsSomeone) {
        this.knowsSomeone = knowsSomeone;
    }

    @Override
    public String toString() {
        return String.valueOf(knowsSomeone);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Person person = (Person) o;
        return knowsSomeone == person.knowsSomeone;
    }

    @Override
    public int hashCode() {
        return Objects.hash(knowsSomeone);
    }
}
