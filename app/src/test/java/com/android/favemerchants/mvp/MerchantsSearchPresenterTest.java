package com.android.favemerchants.mvp;

import com.android.favemerchants.data.model.Merchant;
import com.android.favemerchants.rule.TestSchedulersRule;
import com.android.favemerchants.testCase.AppRobolectricTestCase;
import com.android.favemerchants.testUtils.TestDataGenerator;
import com.android.favemerchants.ui.searchmerchants.MerchantsSearchContracts;
import com.android.favemerchants.ui.searchmerchants.MerchantsSearchPresenter;
import io.reactivex.Observable;
import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.mockito.Mock;

import javax.inject.Inject;
import java.util.ArrayList;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;

import static org.mockito.Mockito.*;

public class MerchantsSearchPresenterTest extends AppRobolectricTestCase {

    @Rule
    public TestSchedulersRule rule = new TestSchedulersRule();

    @Inject
    MerchantsSearchPresenter presenter;
    @Mock
    MerchantsSearchContracts.View view;

    @Before
    public void setUp() throws Exception {
        component().inject(this);
        super.setUp();
        presenter = spy(presenter);
    }

    @Test
    public void onSearchWithResult_shouldShowMerchants() {
        //Given
        presenter.onAttachView(view);
        String query = "Sub";
        when(faveMerchantRepository.getMerchants()).thenReturn(Observable.just(TestDataGenerator.getMerchants()));
        ArrayList<Merchant> merchants = (ArrayList<Merchant>) TestDataGenerator.getMerchants().stream().filter(merchant -> merchant.getName().contains(query)).collect(Collectors.toList());
        when(faveMerchantRepository.getMerchants(query)).thenReturn(Observable.just(merchants));
        //When
        presenter.onQueryChange("Sub");
        rule.advanceTimeBy(1, TimeUnit.SECONDS);
        //verify
        verify(view).showMerchantsSearchResult(merchants);
    }

    @Test
    public void onSearchEmpty_shouldShowEmptyMerchantsResult() {
        //Given
        presenter.onAttachView(view);
        when(apiHelper.getFaveMerchants()).thenReturn(Observable.just(TestDataGenerator.getMerchants()));
        //When
        presenter.onQueryChange("Subssss");
        rule.advanceTimeBy(1, TimeUnit.SECONDS);
        //verify
        verify(view).showEmptyMerchantsResults();
    }

    @After
    public void unsubAll() {
        presenter.onDestroyView();
    }
}