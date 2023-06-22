package com.jontxu.realEstateMatcher.data;

import java.util.List;

public record RealEstate(
        RealEstateType type,
        String city,
        int price,
        List<PurchaseOption> purchaseOptions,
        RealStateAgency realStateAgency
) {
}
