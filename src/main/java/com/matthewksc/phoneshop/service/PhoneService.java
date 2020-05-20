package com.matthewksc.phoneshop.service;

import com.matthewksc.phoneshop.dao.PhoneRepository;
import com.matthewksc.phoneshop.dao.entity.Phone;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class PhoneService {

    private PhoneRepository phoneRepository;

    public PhoneService(PhoneRepository phoneRepository) {
        this.phoneRepository = phoneRepository;
    }

    public void insertAll(List<Phone> phones){
        phoneRepository.insert(phones);
    }

    public void save(Phone phones){
        phoneRepository.save(phones);
    }

    public void insert(Phone phones){
        phoneRepository.insert(phones);
    }

    public Phone findByModel(String model){
        return phoneRepository.findByModel(model)
                .orElseThrow(() -> new RuntimeException("No such model in database")); //todo own exception
    }

    public Iterable<Phone> findUnderPrice(Double max){
        return phoneRepository.findByPriceLessThan(max);
    }

    public Iterable<Phone> findByCompanyName(String companyName){
        return phoneRepository.findByCompany_Name(companyName);
    }

    public Iterable<Phone> findByRating(int rating){
        return phoneRepository.findByRating(rating);
    }

    public Iterable<Phone> findAll(){
        return phoneRepository.findAll();
    }

    public void deleteAll(){
        phoneRepository.deleteAll();
    }
}
