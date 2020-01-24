package com.example.zoo.zoo.animal;

public class Animal {

    private int id;
    private String type;
    private int age;
    private String name;
    private static int counter = 0;

    public Animal(String type, int age, String name) {
        this.id = counter;
        this.type = type;
        this.age = age;
        this.name = name;
        counter++;
    }

    public int getId() {
        return id;
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

    void setType(String type) {
        this.type = type;
    }

    void setAge(int age) {
        this.age = age;
    }

    void setName(String name) {
        this.name = name;
    }
}
