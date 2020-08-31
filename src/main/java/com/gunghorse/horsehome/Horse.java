package com.gunghorse.horsehome;

import org.springframework.data.annotation.Id;

public class Horse {

    @Id
    private String id;
    private String name;
    private int rank;

    public Horse(String name, int rank) {
        this.name = name;
        this.rank = rank;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getRank() {
        return rank;
    }

    @Override
    public String toString() {
        return "Person [id=" + id + ", name=" + name + ", rank=" + rank + "]";
    }
}