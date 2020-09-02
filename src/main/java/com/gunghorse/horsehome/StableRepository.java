package com.gunghorse.horsehome;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface StableRepository extends MongoRepository<Stable, String> {
    List<Stable> findByName(@Param("name") String name);
    List<Stable> findByAddress(@Param("address") int address);
}
