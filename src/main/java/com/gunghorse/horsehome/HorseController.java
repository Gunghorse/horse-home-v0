package com.gunghorse.horsehome;

import org.springframework.web.bind.annotation.*;

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

    @RequestMapping(value="/age/{age}", method = RequestMethod.GET)
    public List<Horse> getByAge(@PathVariable("age") int age){
        return this.horseRepository.findByAge(age);
    }

    /**
     * Endpoint /add?id=fatheerID,motherID
     *
     * @param horse
     * @param mommasAndPappasIDs
     */
    @RequestMapping(value = "/add", method = RequestMethod.POST, produces = "application/json")
    public void addHorse(@RequestBody Horse horse, @RequestParam(required = false, name = "id")List<String> mommasAndPappasIDs){
        horse.setFather(horseRepository.findById(mommasAndPappasIDs.get(0)).get());
        horse.setMother(horseRepository.findById(mommasAndPappasIDs.get(1)).get());
        horseRepository.save(horse);
    }


    @RequestMapping(value = "/delete/{id}", method = RequestMethod.DELETE)
    public void deleteHorse(@PathVariable("id") String id){
        horseRepository.deleteById(id);
    }
}
