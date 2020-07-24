package com.hugh.datastructure.LinkedList.pojo;

import com.google.common.base.Objects;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

/**
 * @program: draft
 * @description: java pojo
 * @author: Fly.Hugh
 * @create: 2020-07-24 23:05
 **/
public class Person {

    private String name;

    public Person(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Person person = (Person) o;

        return getName().equals(person.getName());
    }

    @Override
    public int hashCode() {
        return getName().hashCode();
    }
}
