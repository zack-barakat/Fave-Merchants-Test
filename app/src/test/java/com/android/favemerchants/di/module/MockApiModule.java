package com.android.favemerchants.di.module;

import com.android.favemerchants.data.TestApiHelper;
import com.android.favemerchants.data.network.IApiHelper;
import com.android.favemerchants.di.scopes.ApplicationScope;
import dagger.Module;
import dagger.Provides;

import static org.mockito.Mockito.spy;


@Module(includes = {TestApplicationModule.class})
public class MockApiModule {

    @Provides
    @ApplicationScope
    IApiHelper provideApiHelper() {
        return spy(new TestApiHelper());
    }
}

