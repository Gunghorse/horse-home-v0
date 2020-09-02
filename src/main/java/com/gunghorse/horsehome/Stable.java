package com.gunghorse.horsehome;

import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.TypeAlias;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.LinkedList;
import java.util.List;

@Document(collection="stables")
@TypeAlias("stable")
public class Stable {

    @Id
    private int id;
    private String name;
    private String address;
    private List<Horse> horses = new LinkedList<>();

    public Stable(String name, String address) {
        this.name = name;
        this.address = address;
    }

    public String getName() {
        return name;
    }

    public String getAddress() {
        return address;
    }

    public int getId() {
        return id;
    }

    public List<Horse> getHorses() {
        return horses;
    }

    public void addHorse(Horse horse){
        horses.add(horse);
    }

}
