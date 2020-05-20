package com.matthewksc.phoneshop;

import com.matthewksc.phoneshop.dao.entity.Company;
import com.matthewksc.phoneshop.dao.entity.Phone;
import com.matthewksc.phoneshop.dao.entity.Reviews;
import com.matthewksc.phoneshop.service.PhoneService;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Service;
import java.sql.Date;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class init {

    private PhoneService phoneService;

    public init(PhoneService phoneService) {
        this.phoneService = phoneService;
    }

    @EventListener(ApplicationReadyEvent.class)
    public void initData(){
        Phone honor20 = new Phone( "Honor20", 1500.00,
                new Company("Huawei", "China" ,"Shenzhen"),
                Arrays.asList(
                        new Reviews("Matt", 4, Date.valueOf(LocalDate.now().minusDays(2))),
                        new Reviews("Pat", 3, Date.valueOf(LocalDate.now()))
                )
        );

        Phone s20 = new Phone( "S20", 3500.00,
                new Company("Samsung", "South Korea" ,"Suwon"),
                Arrays.asList(
                        new Reviews("Matt", 4, Date.valueOf(LocalDate.now().minusDays(2))),
                        new Reviews("Pat", 3, Date.valueOf(LocalDate.now()))
                )
        );

        Phone k10 = new Phone( "K10", 700.00,
                new Company("LG", "South Korea" ,"Seul"),
                new ArrayList<>()
        );

        phoneService.deleteAll();
        List<Phone> phones = Arrays.asList(honor20, s20, k10);
        phoneService.insertAll(phones);
    }
}
