package com.android.favemerchants.di;

import android.app.Application;
import com.android.favemerchants.di.component.DaggerApplicationProdComponent;
import com.android.favemerchants.di.component.FlavorComponent;

public class ComponentFactory {

    public static final FlavorComponent getComponent(Application context) {
        return DaggerApplicationProdComponent
                .builder()
                .application(context)
                .build();
    }
}