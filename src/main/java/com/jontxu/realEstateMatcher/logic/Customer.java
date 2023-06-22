package com.jontxu.realEstateMatcher.logic;

import com.jontxu.realEstateMatcher.data.*;

import java.util.ArrayList;
import java.util.List;

public final class Customer implements Observer {
    private final String emailAddress;
    private final RealEstateType realEstateType;
    private final String city;
    private final List<PurchaseOption> purchaseOptions;
    private List<RealStateAgency> realEstateAgencies;
    private final int priceCap;

    public Customer(String emailAddress, RealEstateType realEstateType, String city, List<PurchaseOption> purchaseOptions, int priceCap) {
        this.emailAddress = emailAddress;
        this.realEstateType = realEstateType;
        this.city = city;
        this.purchaseOptions = purchaseOptions;
        this.priceCap = priceCap;
        realEstateAgencies = new ArrayList<>();
    }

    @Override
    public void update(RealStateAgency realEstateAgency) {
        realEstateAgencies.add(realEstateAgency);
        List<RealEstate> listOfMatches = realEstateAgencies.stream()
                .flatMap(realEstate -> realEstate.getRealEstates().stream())
                .filter(realEstate -> filterMatches(realEstate))
                .toList();
        System.out.println("Matches for customer with email address: " + this.emailAddress + " are:");
        for (RealEstate match : listOfMatches) {
            System.out.println(match.toString());
        }
    }

    private boolean filterMatches(RealEstate realEstate) {
        return realEstate.city().equalsIgnoreCase(this.city) &&
                realEstate.price() <= this.priceCap &&
                comparePurchaseOptions(realEstate.purchaseOptions())&&
                realEstate.type().equals(this.realEstateType);
    }

    private boolean comparePurchaseOptions(List<PurchaseOption> purchaseOptions) {
        return purchaseOptions.stream()
                .anyMatch(purchaseOption -> this.purchaseOptions.contains(purchaseOption));
    }
}
