package com.android.favemerchants.di.component;

import com.android.favemerchants.di.module.FragmentModule;
import com.android.favemerchants.di.scopes.FragmentScope;
import com.android.favemerchants.ui.base.BaseMvpFragment;
import dagger.Component;


@FragmentScope
@Component(dependencies = ApplicationComponent.class, modules = FragmentModule.class)
public interface FragmentComponent {

    void inject(BaseMvpFragment baseMvpFragment);

}