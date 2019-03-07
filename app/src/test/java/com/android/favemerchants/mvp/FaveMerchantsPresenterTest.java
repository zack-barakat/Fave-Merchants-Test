package com.android.favemerchants.mvp;

import com.android.favemerchants.data.model.Merchant;
import com.android.favemerchants.rule.TestSchedulersRule;
import com.android.favemerchants.testCase.AppRobolectricTestCase;
import com.android.favemerchants.testUtils.TestDataGenerator;
import com.android.favemerchants.ui.favemerchants.FaveMerchantsContracts;
import com.android.favemerchants.ui.favemerchants.FaveMerchantsPresenter;
import io.reactivex.Observable;
import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.mockito.Mock;

import javax.inject.Inject;
import java.util.concurrent.TimeUnit;

import static org.mockito.Mockito.*;

public class FaveMerchantsPresenterTest extends AppRobolectricTestCase {

    @Rule
    public TestSchedulersRule rule = new TestSchedulersRule();

    @Inject
    FaveMerchantsPresenter presenter;
    @Mock
    FaveMerchantsContracts.View view;

    @Before
    public void setUp() throws Exception {
        component().inject(this);
        super.setUp();
        presenter = spy(presenter);
    }

    @Test
    public void onViewAttach_shouldShowMerchants() {
        //Given
        when(apiHelper.getFaveMerchants()).thenReturn(Observable.just(TestDataGenerator.getMerchants()));
        //When
        presenter.onAttachView(view);
        rule.advanceTimeBy(1, TimeUnit.SECONDS);
        //verify
        verify(view).showMerchants(TestDataGenerator.getMerchants());
    }

    @Test
    public void onSearchClick_shouldOpenMerchantsSearchScreen() {
        //Given
        presenter.onAttachView(view);
        //When
        presenter.onSearchClick();
        //verify
        verify(view).openSearchScreen();
    }

    @Test
    public void onEmailClick_shouldOpenEmailScreen() {
        //Given
        presenter.onAttachView(view);
        Merchant merchant = TestDataGenerator.getMerchants().get(0);

        //When
        presenter.onEmailMerchantClick(0);
        rule.advanceTimeBy(1, TimeUnit.SECONDS);
        //verify
        verify(view).openEmailMerchantScreen(merchant.getName(), merchant.getEmail());
    }

    @After
    public void unsubAll() {
        presenter.onDestroyView();
    }
}