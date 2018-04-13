package com.company;

/**
 * <h1>Man</h1>
 * Абстрактный класс, описывающий человека
 * @author Nikolai Dik
 * @version 1.0
 * @since 25-03-2018
 */

public abstract class Man {
    private String name;
    private int age;

    public Man() {
    }

    public Man(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
