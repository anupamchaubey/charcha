package com.charcha.repository;

import com.charcha.model.Region;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RegionRepository extends MongoRepository<Region, String> {

    // Optional: use if you want to check or update regions
    boolean existsByRegionName(String regionName);
}
