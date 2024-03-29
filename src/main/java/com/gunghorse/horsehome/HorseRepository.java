package com.gunghorse.horsehome;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;
import java.util.Map;

public interface HorseRepository extends MongoRepository<Horse, String> {
    List<Horse> findByName(@Param("name") String name);
}
