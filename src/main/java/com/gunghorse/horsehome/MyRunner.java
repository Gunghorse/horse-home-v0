package com.gunghorse.horsehome;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.List;


@Component
public class MyRunner implements CommandLineRunner {

    @Autowired
    private HorseRepository horseRepository;
    @Autowired
    private StableRepository stableRepository;

    @Override
    public void run(String... args) throws Exception {

        //horseRepository.deleteAll();
        //stableRepository.deleteAll();
        /*List<Horse> horses = horseRepository.findAll();

        Stable stable = new Stable("Top Stable", "Sopot");
        for(Horse horse : horses)
            stable.addHorse(horse);

        stableRepository.save(stable);*/
    }
}



