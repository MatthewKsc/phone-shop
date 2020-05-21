package com.matthewksc.phoneshop.controller;

import com.matthewksc.phoneshop.dao.entity.Phone;
import com.matthewksc.phoneshop.service.PhoneService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/phones")
public class PhoneController {

    private PhoneService phoneService;

    public PhoneController(PhoneService phoneService) {
        this.phoneService = phoneService;
    }

    @GetMapping
    public Iterable<Phone> getAllPhones(){
        return phoneService.findAll();
    }

    @GetMapping("/{model}")
    public Phone getPhoneByModel(@PathVariable String model){ //can do PathVariable("model")
        return phoneService.findByModel(model);
    }

    @GetMapping("/price/{maxPrice}")
    public Iterable<Phone> getPhoneBelowPrice(@PathVariable Double maxPrice){
        return phoneService.findUnderPrice(maxPrice);
    }

    @GetMapping("/company/{companyName}")
    public Iterable<Phone> getCompanyPhones(@PathVariable String companyName){
        return phoneService.findByCompanyName(companyName);
    }

    @GetMapping("/rating/{rate}")
    public Iterable<Phone> getCompanyPhones(@PathVariable int rate){
        return phoneService.findByRating(rate);
    }

    @PostMapping
    public Phone insertPhone(@RequestBody Phone phone){
        return phoneService.insert(phone);
    }

    @PutMapping("/update")
    public Phone updatePhone(@RequestBody Phone phone){
        return phoneService.save(phone); //in mongo its update with upsert: true
    }
}
