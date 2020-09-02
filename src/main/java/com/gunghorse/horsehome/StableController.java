package com.gunghorse.horsehome;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/stable")
public class StableController {
    private StableRepository stableRepository;

    public StableController(StableRepository stableRepository) {
        this.stableRepository = stableRepository;
    }

    @RequestMapping(value="", method = RequestMethod.GET)
    public List<Stable> getAllStables(){
        return this.stableRepository.findAll();
    }

    @RequestMapping(value = "name/{name}", method = RequestMethod.GET)
    public List<Stable> getStableByName(@PathVariable("name") String name){
        return this.stableRepository.findByName(name);
    }

}
