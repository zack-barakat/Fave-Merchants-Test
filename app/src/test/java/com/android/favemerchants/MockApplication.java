package com.android.favemerchants;

import com.android.favemerchants.di.component.DaggerTestApplicationComponent;
import com.android.favemerchants.di.component.TestApplicationComponent;

public class MockApplication extends App {
    @Override
    public void onCreate() {
        super.onCreate();
    }

    @Override
    protected void initDagger() {
        TestApplicationComponent applicationComponent = DaggerTestApplicationComponent.builder()
                .application(this)
                .build();
        setComponent(applicationComponent);
    }
}
