package com.gunghorse.horsehome;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

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

    @RequestMapping(value="/rank/{rank}", method = RequestMethod.GET)
    public List<Horse> getByRank(@PathVariable("rank") int rank){
        return this.horseRepository.findByRank(rank);
    }
}
