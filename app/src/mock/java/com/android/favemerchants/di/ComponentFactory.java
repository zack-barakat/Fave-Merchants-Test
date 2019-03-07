package com.android.favemerchants.di;

import android.app.Application;
import com.android.favemerchants.di.component.DaggerApplicationMockComponent;
import com.android.favemerchants.di.component.FlavorComponent;

public class ComponentFactory {

    public static final FlavorComponent getComponent(Application context) {
        return DaggerApplicationMockComponent
                .builder()
                .application(context)
                .build();
    }
}