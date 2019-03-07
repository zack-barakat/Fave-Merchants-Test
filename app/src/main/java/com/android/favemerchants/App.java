package com.android.favemerchants;

import android.app.Application;
import com.android.favemerchants.di.ComponentFactory;
import com.android.favemerchants.di.component.ApplicationComponent;

public class App extends Application {

    private ApplicationComponent component;

    @Override
    public void onCreate() {
        super.onCreate();
        initDagger();
    }

    protected void initDagger() {

        ApplicationComponent appComponent = ComponentFactory.getComponent(this);
        setComponent(appComponent);
    }

    public ApplicationComponent getComponent() {
        return component;
    }

    public void setComponent(ApplicationComponent component) {
        this.component = component;

        component.inject(this);
    }
}
