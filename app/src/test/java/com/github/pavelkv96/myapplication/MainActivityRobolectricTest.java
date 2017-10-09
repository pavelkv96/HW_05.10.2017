package com.github.pavelkv96.myapplication;

import android.widget.EditText;
import android.widget.TextView;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.Robolectric;
import org.robolectric.RobolectricTestRunner;
import org.robolectric.android.controller.ActivityController;
import org.robolectric.annotation.Config;

import static junit.framework.Assert.assertEquals;

/**
 * Created by Pavel on 07.10.2017.
 */

@RunWith(RobolectricTestRunner.class)
@Config(constants = BuildConfig.class)
public class MainActivityRobolectricTest {
    private ActivityController<MainActivity> activityController;
    private MainActivity mainActivity;

    @Before
    public void init() {
        activityController.create();
        activityController.start();
        activityController.resume();

        mainActivity = activityController.get();
        activityController = Robolectric.buildActivity(MainActivity.class);
    }

    //Test will complete
    @Test
    public void testMainActivity() {


        EditText etNum1 = (EditText) mainActivity.findViewById(R.id.etNum1);
        EditText etNum2 = (EditText) mainActivity.findViewById(R.id.etNum2);
        etNum1.setText("1");
        etNum2.setText("2");
        mainActivity.findViewById(R.id.btnAdd).performClick();
        TextView tvResult = (TextView) mainActivity.findViewById(R.id.tvResult);
        assertEquals(tvResult.getText().toString(), "3.0");
    }

    @After
    public void destroy() {
        activityController.pause();
        activityController.stop();
        activityController.destroy();
    }
}