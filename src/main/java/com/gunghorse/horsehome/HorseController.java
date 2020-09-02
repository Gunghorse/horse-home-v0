package com.gunghorse.horsehome;

import org.springframework.web.bind.annotation.*;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/horse")
public class HorseController {
    private HorseRepository horseRepository;

    public HorseController(HorseRepository horseRepository) {
        this.horseRepository = horseRepository;
    }

    @RequestMapping(value="", method = RequestMethod.GET)
    public List<Horse> getAllHorses(){
        return this.horseRepository.findAll();
    }

    @RequestMapping(value="/name/{name}", method = RequestMethod.GET)
    public List<Horse> getByName(@PathVariable("name") String name){
        return this.horseRepository.findByName(name);
    }

    @RequestMapping(value="/age/{birthYear}", method = RequestMethod.GET)
    public List<Horse> getByBirthYear(@PathVariable("birthYear") String birthYear){
        List<Horse> horses = new ArrayList<>();
        for(Horse horse : this.horseRepository.findAll()){
            if(horse.getBirthDate().contains(birthYear))
                horses.add(horse);
        }
        return horses;
    }

    @RequestMapping(value = "/add", method = RequestMethod.POST, produces = "application/json")
    public void addHorse(@RequestBody Horse horse){
        horseRepository.save(horse);
    }

    @RequestMapping(value = "/add/mother/byName/{horseID}/{motherName}", method = RequestMethod.POST)
    public void addMotherByName(@PathVariable("horseID") String horseID,
                          @PathVariable("motherName") String motherName){
        Horse horse = horseRepository.findById(horseID).get();
        horse.setMotherName(motherName);
        horseRepository.save(horse);
    }

    @RequestMapping(value = "/add/father/byName/{horseID}/{fatherName}", method = RequestMethod.POST)
    public void addFatherByName(@PathVariable("horseID") String horseID,
                          @PathVariable("fatherName") String fatherName){
        Horse horse = horseRepository.findById(horseID).get();
        horse.setFatherName(fatherName);
        horseRepository.save(horse);
    }

    @RequestMapping(value = "/add/mother/{horseID}/{motherID}", method = RequestMethod.POST)
    public void addMother(@PathVariable("horseID") String horseID,
                          @PathVariable("motherID") String motherID){
        Horse horse = horseRepository.findById(horseID).get();
        Horse mother = horseRepository.findById(motherID).get();
        horse.setMotherID(motherID);
        horse.setMotherName(mother.getName());
        mother.addChild(horse);
        horseRepository.save(mother);
        horseRepository.save(horse);
    }

    @RequestMapping(value = "/add/father/{horseID}/{fatherID}", method = RequestMethod.POST)
    public void addFather(@PathVariable("horseID") String horseID,
                          @PathVariable("fatherID") String fatherID){
        Horse horse = horseRepository.findById(horseID).get();
        Horse father = horseRepository.findById(fatherID).get();
        horse.setMotherID(fatherID);
        horse.setMotherName(father.getName());
        father.addChild(horse);
        horseRepository.save(father);
        horseRepository.save(horse);
    }

    @RequestMapping(value = "/delete/{id}", method = RequestMethod.DELETE)
    public void deleteHorse(@PathVariable("id") String id){
        Horse horse = horseRepository.findById(id).get();
        horse.setDeathDate(new SimpleDateFormat("dd-MM-yyyy").format(new Date()));
        horseRepository.save(horse);
    }
}
