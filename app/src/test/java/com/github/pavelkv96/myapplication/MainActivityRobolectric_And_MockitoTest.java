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

    private IMyVisible myVisible;
    private IMyVisible myVisible_two;
    private Button btnDiv;

    @Before
    public void setUp() {
        MainActivity mMainActivity = Robolectric.setupActivity(MainActivity.class);
        myVisible_two = mock(MainActivity.class);
        myVisible = spy(MainActivity.class);
        btnDiv = (Button) mMainActivity.findViewById(R.id.btnDiv);
    }

    //Test will complete
    @Test
    public void MockTest() {
        when(myVisible_two.Visible(Matchers.anyString())).thenReturn("VISIBLE");
        btnDiv.setVisibility(View.INVISIBLE);
        assertEquals(btnDiv.getVisibility(),View.INVISIBLE);
    }

    //Test won't complete
    @Test
    public void SpyTest() {
        when(myVisible.Visible(Matchers.anyString())).thenReturn("VISIBLE");
        btnDiv.setVisibility(View.VISIBLE);
        assertEquals(btnDiv.getVisibility(),View.INVISIBLE);
    }
}