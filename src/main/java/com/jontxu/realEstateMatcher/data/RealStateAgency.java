package com.jontxu.realEstateMatcher.data;

import com.jontxu.realEstateMatcher.logic.Customer;

import java.util.ArrayList;
import java.util.List;

public class RealStateAgency implements Observable{
    private List<RealEstate> realEstates;
    private List<Customer> subscribedCustomers;

    public RealStateAgency() {
        realEstates = new ArrayList<>();
        subscribedCustomers = new ArrayList<>();
    }
    public List<RealEstate> getRealEstates() {
        return realEstates;
    }

    public void addToRealEstates(RealEstate realEstate) {
        realEstates.add(realEstate);
    }



    public List<Customer> getSubscribedCustomers() {
        return subscribedCustomers;
    }



    @Override
    public void registerObserver(Customer customer) {
        subscribedCustomers.add(customer);
    }

    @Override
    public void removeObserver(Customer customer) {
        subscribedCustomers.remove(customer);
    }

    @Override
    public void notifyObservers() {
        for (Customer subscribedCustomer : subscribedCustomers) {
            subscribedCustomer.update(this);
        }
    }

    public void setRealEstates(List<RealEstate> realEstates) {
        this.realEstates = realEstates;
    }
}
