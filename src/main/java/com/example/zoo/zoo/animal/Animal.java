package com.example.zoo.zoo.animal;

public class Animal {

    private String type;
    private int age;
    private String name;

    public Animal(String type, int age, String name) {

        this.type = type;
        this.age = age;
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public int getAge() {
        return age;
    }

    public String getName() {
        return name;
    }
}
