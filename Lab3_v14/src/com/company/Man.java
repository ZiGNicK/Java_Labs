package com.company;

/**
 * <h1>Abstract Man</h1>
 * Абстрактный класс описывающий типичного человека
 * @author Nikolai Dik
 * @version 1.2
 * @since 2-04-2018
 */

public abstract class Man {
    protected String name;
    protected int age;

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
