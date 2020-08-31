package com.gunghorse.horsehome;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface HorseRepository extends MongoRepository<Horse, String> {
    List<Horse> findByName(@Param("name") String name);
    List<Horse> findByRank(@Param("rank") int rank);
}