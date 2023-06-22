package com.jontxu.realEstateMatcher;

import com.jontxu.realEstateMatcher.data.*;
import com.jontxu.realEstateMatcher.logic.Customer;

import java.util.List;

import static com.jontxu.realEstateMatcher.data.PurchaseOption.*;
import static com.jontxu.realEstateMatcher.data.RealEstateType.*;

public class Application {
    public static void main(String[] args) {
        RealStateAgency agency1 = new RealStateAgency();
        List<RealEstate> realEstates1 = List.of(
                new RealEstate(APARTMENT, "Vienna", 1000, List.of(SALE, RENT), agency1),
                new RealEstate(GARAGE, "London", 2500, List.of(RENT), agency1));
        agency1.setRealEstates(realEstates1);
        Customer customer1 = new Customer("customer1@blabla.com", APARTMENT, "Vienna", List.of(SALE, RENT), 2000);
        Customer customer2 = new Customer("customer2@blabla.com", GARAGE, "London", List.of(RENT), 2600);
        agency1.registerObserver(customer1);
        agency1.registerObserver(customer2);
        agency1.notifyObservers();

    }
}
