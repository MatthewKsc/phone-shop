package com.matthewksc.phoneshop.service;

import com.matthewksc.phoneshop.dao.PhoneRepository;
import com.matthewksc.phoneshop.dao.entity.Phone;
import com.matthewksc.phoneshop.exeptions.NotFoundPhoneException;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class PhoneService {

    private PhoneRepository phoneRepository;

    public PhoneService(PhoneRepository phoneRepository) {
        this.phoneRepository = phoneRepository;
    }

    public List<Phone> insertAll(List<Phone> phones){
        return phoneRepository.insert(phones);
    }

    public Phone save(Phone phones){
        return phoneRepository.save(phones);
    }

    public Phone insert(Phone phones){
        return phoneRepository.insert(phones);
    }

    public Phone findByModel(String model){
        return phoneRepository.findByModel(model)
                .orElseThrow(() -> new NotFoundPhoneException(model));
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
