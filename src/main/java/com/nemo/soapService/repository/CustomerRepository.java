package com.nemo.soapService.repository;

import com.nemo.soapService.model.Address;
import com.nemo.soapService.model.Customer;
import org.springframework.stereotype.Component;
import org.springframework.util.Assert;

import javax.annotation.PostConstruct;
import java.util.HashMap;
import java.util.Map;

@Component
public class CustomerRepository {
    private static final Map<Integer, Customer> customers = new HashMap<>();

    @PostConstruct
    public void init(){
        Customer maks = new Customer();
        maks.setId(1);
        maks.setFirstname("Maksym");
        maks.setLastname("Kuts");
        maks.setAge(20);
        Address maksAddress = new Address();
        maksAddress.setCountry("Ukraine");
        maksAddress.setDistrict("Lviv");
        maksAddress.setRegion("Sokal");
        maksAddress.setCity("Velyki Mosty");
        maksAddress.setStreet("Stari Mosty");
        maksAddress.setBuilding("84");
        maks.setAddress(maksAddress);
        customers.put(maks.getId(),maks);

        Customer jim = new Customer();
        jim.setId(2);
        jim.setFirstname("Jim");
        jim.setLastname("Ban");
        jim.setAge(20);
        Address jimAddress = new Address();
        jimAddress.setCountry("Ukraine");
        jimAddress.setDistrict("Lviv");
        jimAddress.setRegion("Sokal");
        jimAddress.setCity("Velyki Mosty");
        jimAddress.setStreet("Stari Mosty");
        jimAddress.setBuilding("84");
        jim.setAddress(jimAddress);
        customers.put(jim.getId(),jim);
    }

    public Customer findCustomer(Integer id){
        Assert.notNull(id,"Id must be valid");
        return customers.get(id);
    }

    public Customer deleteCustomer(Integer id){
        Assert.notNull(id,"Id must be valid");
        return customers.remove(id);
    }
}
