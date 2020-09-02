package com.gunghorse.horsehome;

import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.TypeAlias;
import org.springframework.data.mongodb.core.mapping.Document;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.concurrent.TimeUnit;

import static java.util.Calendar.*;

@Document(collection="horses")
@TypeAlias("horse")
public class Horse {

    @Id
    private String id;
    private String name;
    private String birthDate;
    private String deathDate;
    private String breed;
    private String coatColors;
    private String fatherID;
    private String fatherName;
    private String motherID;
    private String motherName;
    private List<Horse> children = new LinkedList<>();


    public Horse(String name, String birthDate, String breed, String coatColors) {
        this.name = name;
        this.birthDate = birthDate;
        this.breed = breed;
        this.coatColors = coatColors;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public boolean isDead(){
        return !deathDate.equals("");
    }

    public String getBirthDate() {
        return birthDate;
    }

    public String getDeathDate() {
        return deathDate;
    }

    public List<Horse> getChildren() {
        return children;
    }


    public String getBreed() {
        return breed;
    }

    public String getCoatColors() {
        return coatColors;
    }

    public void addChild(Horse child){
        this.children.add(child);
    }

    public String getFatherID() {
        return fatherID;
    }

    public String getFatherName() {
        return fatherName;
    }

    public String getMotherID() {
        return motherID;
    }

    public String getMotherName() {
        return motherName;
    }

    public int getAge(){
        try {
            SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
            Date birthDate = sdf.parse(getBirthDate());
            Calendar birthCal = getCalendar(birthDate);
            if(!isDead()){
                Calendar nowCal = getCalendar(new Date());
                return getDiff(birthCal, nowCal);
            }else {
                Date deadDate = sdf.parse(getDeathDate());
                Calendar deadCal = getCalendar(deadDate);
                return getDiff(birthCal, deadCal);
            }
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return 0;
    }

    private int getDiff(Calendar birthCal, Calendar lastCal){
        int diff = lastCal.get(YEAR) - birthCal.get(YEAR);
        if (birthCal.get(MONTH) > lastCal.get(MONTH) ||
                (birthCal.get(MONTH) == lastCal.get(MONTH) && birthCal.get(DATE) > lastCal.get(DATE))) {
            diff--;
        }
        return diff;
    }

    private Calendar getCalendar(Date date) {
        Calendar cal = Calendar.getInstance(Locale.US);
        cal.setTime(date);
        return cal;
    }

    public void setDeathDate(String deathDate){
        this.deathDate = deathDate;
    }

    public void setFatherID(String fatherID) {
        this.fatherID = fatherID;
    }

    public void setFatherName(String fatherName) {
        this.fatherName = fatherName;
    }

    public void setMotherID(String motherID) {
        this.motherID = motherID;
    }

    public void setMotherName(String motherName) {
        this.motherName = motherName;
    }
}
