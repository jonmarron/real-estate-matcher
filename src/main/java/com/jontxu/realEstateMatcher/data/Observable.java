package com.jontxu.realEstateMatcher.data;

import com.jontxu.realEstateMatcher.logic.Customer;

public interface Observable {
    void registerObserver(Customer customer);
    void removeObserver(Customer customer);
    void notifyObservers();
}
