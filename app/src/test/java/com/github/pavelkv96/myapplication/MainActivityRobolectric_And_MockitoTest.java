package com.github.pavelkv96.myapplication;

import android.view.View;
import android.widget.Button;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Matchers;

import static junit.framework.Assert.assertEquals;
import static org.mockito.Mockito.spy;
import static org.mockito.Mockito.when;
import org.junit.runner.RunWith;
import org.robolectric.Robolectric;
import org.robolectric.RobolectricTestRunner;
import org.robolectric.annotation.Config;

import static org.mockito.Mockito.mock;

/**
 * Created by Pavel on 07.10.2017.
 */
@RunWith(RobolectricTestRunner.class)
@Config(constants = BuildConfig.class, sdk = 21)
public class MainActivityRobolectric_And_MockitoTest {

    private IMyVisible mVisible;
    private IMyVisible mVisible_two;
    private Button mDivButton;

    @Before
    public void setUp() {
        MainActivity mMainActivity = Robolectric.setupActivity(MainActivity.class);
        mVisible_two = mock(MainActivity.class);
        mVisible = spy(MainActivity.class);
        mDivButton = (Button) mMainActivity.findViewById(R.id.btnDiv);
    }

    //Test will complete
    @Test
    public void MockTest() {
        when(mVisible_two.Visible(Matchers.anyString())).thenReturn("VISIBLE");
        mDivButton.setVisibility(View.INVISIBLE);
        assertEquals(mDivButton.getVisibility(),View.INVISIBLE);
    }

    //Test won't complete
    @Test
    public void SpyTest() {
        when(mVisible.Visible(Matchers.anyString())).thenReturn("VISIBLE");
        mDivButton.setVisibility(View.VISIBLE);
        assertEquals(mDivButton.getVisibility(),View.INVISIBLE);
    }
}