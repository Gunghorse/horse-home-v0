package com.gunghorse.horsehome;

import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.TypeAlias;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection="horses")
@TypeAlias("horse")
public class Horse {

    @Id
    private String id;
    private String name;
    private int age;
    private String breed;
    private String coatColors;
    private Horse father;
    private Horse mother;

    public Horse(String name, int age, String breed, String coatColors, Horse father, Horse mother) {
        this.name = name;
        this.age = age;
        this.breed = breed;
        this.coatColors = coatColors;
        this.father = father;
        this.mother = mother;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public String getBreed() {
        return breed;
    }

    public String getCoatColors() {
        return coatColors;
    }

    public Horse getFather() {
        return father;
    }

    public void setFather(Horse father) {
        this.father = father;
    }

    public Horse getMother() {
        return mother;
    }

    public void setMother(Horse mother) {
        this.mother = mother;
    }

    @Override
    public String toString() {
        return "Horse{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", breed='" + breed + '\'' +
                ", coatColors='" + coatColors + '\'' +
                ", father=" + father +
                ", mother=" + mother +
                '}';
    }
}
