//package com.android.favemerchants.di;
//
//import android.app.Application;
//import com.android.favemerchants.di.component.FlavorComponent;
//import com.android.favemerchants.di.component.DaggerTestApplicationComponent;
//
//public class ComponentFactory {
//
//    public static final FlavorComponent getComponent(Application context) {
//        return DaggerTestApplicationComponent
//                .builder()
//                .application(context)
//                .build();
//    }
//}