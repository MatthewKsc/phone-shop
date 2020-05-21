package com.matthewksc.phoneshop.service;

import com.matthewksc.phoneshop.dao.PhoneRepository;
import com.matthewksc.phoneshop.dao.entity.Company;
import com.matthewksc.phoneshop.dao.entity.Phone;
import com.matthewksc.phoneshop.exeptions.NotFoundPhoneException;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

@RunWith(MockitoJUnitRunner.class)
public class PhoneServiceTest {

    @Mock
    PhoneRepository phoneRepository;

    @InjectMocks
    PhoneService phoneService;

    @Test
    public void insertAll() {
        List<Phone> phones = initData();
        given(phoneRepository.insert(phones)).willReturn(phones);

        List<Phone> check = phoneService.insertAll(phones);
        List<Phone> fake = new ArrayList<>();

        assertEquals(phones, check);
        assertNotEquals(fake, check);
        assertEquals(3, check.size());
        assertNotEquals(0, check.size());
    }

    @Test
    public void save() {
        Phone phone1 = new Phone();
        Phone phone2 = new Phone();
        given(phoneRepository.save(phone1)).willReturn(phone1);

        Phone check = phoneService.save(phone1);

        assertEquals(phone1, check);
        assertNotEquals(phone2, check);
    }

    @Test
    public void insert() {
        Phone phone1 = new Phone();
        Phone phone2 = new Phone();
        given(phoneRepository.insert(phone1)).willReturn(phone1);

        Phone check = phoneService.insert(phone1);

        assertEquals(phone1, check);
        assertNotEquals(phone2, check);
    }

    @Test
    public void findByModel() {
        Phone withModel = new Phone();
        withModel.setModel("testmodel");
        given(phoneRepository.findByModel("testmodel")).willReturn(java.util.Optional.of(withModel));
        given(phoneRepository.findByModel("wdawad")).willThrow(NotFoundPhoneException.class);

        Phone check = phoneService.findByModel("testmodel");
        Phone fake = new Phone();

        assertEquals(check, withModel);
        assertNotEquals(fake, check);
        assertThrows(NotFoundPhoneException.class,() -> phoneService.findByModel("wdawad"));
    }

    @Test
    public void findUnderPrice() {
        given(phoneRepository.findByPriceLessThan(110.00)).willReturn(initData());

        List<Phone> check = (List<Phone>) phoneService.findUnderPrice(110.00);
        List<Phone> fake = (List<Phone>) phoneService.findUnderPrice(100.00);

        assertEquals(check, phoneService.findUnderPrice(110.00));
        assertEquals(3, check.size());
        assertEquals(0, fake.size());
        assertNotEquals(0, check.size());
        assertNotEquals(check, fake);
    }

    @Test
    public void findByCompanyName() {
        given(phoneRepository.findByCompany_Name("usa")).willReturn(initData());

        List<Phone> check = (List<Phone>) phoneService.findByCompanyName("usa");
        List<Phone> fake = (List<Phone>) phoneService.findByCompanyName("china");

        assertEquals(check, phoneService.findByCompanyName("usa"));
        assertEquals(3,check.size());
        assertEquals(0,fake.size());
        assertNotEquals(0, check.size());
        assertNotEquals(check ,fake);
    }

    @Test
    public void findByRating() {
        given(phoneRepository.findByRating(4)).willReturn(initData());

        List<Phone> check = (List<Phone>) phoneService.findByRating(4);
        List<Phone> fake = (List<Phone>) phoneService.findByRating(2);

        assertEquals(check, phoneService.findByRating(4));
        assertEquals(3,check.size());
        assertEquals(0,fake.size());
        assertNotEquals(0, check.size());
        assertNotEquals(check, fake);
    }

    @Test
    public void findAll() {
        given(phoneRepository.findAll()).willReturn(initData());

        List<Phone> check = (List<Phone>) phoneService.findAll();
        List<Phone> fake = new ArrayList<>();

        assertEquals(check, phoneService.findAll());
        assertNotEquals(check, fake);
        assertEquals(3, check.size());
        assertNotEquals(0, check.size());
    }

    @Test
    public void deleteAll() {
        List<Phone> phones = initData();
        phoneService.deleteAll();

        verify(phoneRepository, times(1)).deleteAll();
    }

    private List<Phone> initData() {
        List<Phone> phones = new ArrayList<>();
        phones.add(new Phone());
        phones.add(new Phone());
        phones.add(new Phone());
        phones.stream().forEach(ele -> ele.setPrice(100.00));
        Company company = new Company();
        company.setName("usa");
        phones.stream().forEach(ele-> ele.setCompany(company));
        return phones;
    }
}