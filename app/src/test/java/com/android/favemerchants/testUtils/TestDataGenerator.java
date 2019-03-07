package com.android.favemerchants.testUtils;

import com.android.favemerchants.data.model.Merchant;

import java.util.ArrayList;

public class TestDataGenerator {

    public static ArrayList<Merchant> getMerchants() {
        ArrayList<Merchant> faveMerchants = new ArrayList<>();
        faveMerchants.add(new Merchant("Old Town", "Kuala Lumpur", "oldown@gmail.com"));
        faveMerchants.add(new Merchant("Starbucks", "Kuala Lumpur", "starbucks@gmail.com"));
        faveMerchants.add(new Merchant("KFC", "Kuala Lumpur", "kfc@gmail.com"));
        faveMerchants.add(new Merchant("Nandos", "Kuala Lumpur", "nandos@gmail.com"));
        faveMerchants.add(new Merchant("KGB", "Kuala Lumpur", "kgb@gmail.com"));
        faveMerchants.add(new Merchant("Subway", "Kuala Lumpur", "subway@gmail.com"));
        faveMerchants.add(new Merchant("Mcdonald", "Kuala Lumpur", "Mcdonald@gmail.com"));
        faveMerchants.add(new Merchant("Carl's Junior", "Kuala Lumpur", "carlsjunior@gmail.com"));

        return faveMerchants;
    }
}
