package com.com.threading;

public final class ImmutableClass {

    private final String name;
    private final int age;

    public ImmutableClass(String name , int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return this.name;
    }

    public int getAge() {
        return this.age;
    }
}
