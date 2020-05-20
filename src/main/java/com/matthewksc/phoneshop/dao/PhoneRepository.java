package com.matthewksc.phoneshop.dao;

import com.matthewksc.phoneshop.dao.entity.Phone;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;
import java.util.Optional;

@Repository
public interface PhoneRepository extends MongoRepository<Phone, String> {

    Optional<Phone> findById(String id); //can be used id but model is more practical
    Optional<Phone> findByModel(String model);
    Iterable<Phone> findByPriceLessThan(Double max);
    Iterable<Phone> findByCompany_Name(String companyName);

    @Query(value = "{'reviews.rating':{$gte:?0}}") //gte - grater than equals
    Iterable<Phone> findByRating(int rating);
}
