package com.github.pavelkv96.myapplication;

import android.content.Intent;
import android.support.test.espresso.NoMatchingViewException;
import android.support.test.espresso.ViewAssertion;
import android.support.test.espresso.ViewInteraction;
import android.support.test.rule.ActivityTestRule;
import android.view.View;
import android.widget.TextView;

import org.junit.Test;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.typeText;
import static android.support.test.espresso.matcher.ViewMatchers.withId;

/**
 * Created by Pavel on 06.10.2017.
 */
public class MainActivityEspressoTest {
    private ActivityTestRule<MainActivity> activityTestRule = new ActivityTestRule<MainActivity>(MainActivity.class);

    @Test
    public void testActivityRun() {
        activityTestRule.launchActivity(new Intent());

        ViewInteraction btnAdd = onView(withId(R.id.btnAdd));
        ViewInteraction btnDiv = onView(withId(R.id.btnDiv));
        ViewInteraction etNum1 = onView(withId(R.id.etNum1));
        ViewInteraction etNum2 = onView(withId(R.id.etNum2));
        ViewInteraction TW = onView(withId(R.id.tvResult));
        //TW.check(matches(isDisplayed()));
        //etNum1.check(matches(isDisplayed()));
        //etNum2.check(matches(isDisplayed()));
        //btnAdd.check(matches(isDisplayed()));
        //btnDiv.check(matches(isDisplayed()));

        etNum1.perform(typeText("3"));
        etNum2.perform(typeText("2"));

        //Test will complete
        Button_check(btnAdd, "Add button not enabled");
        TW_check(TW, "5.0", "(Add button) ");

        //Test won't complete
        Button_check(btnDiv, "Div button not enabled");
        TW_check(TW, "3.0", "(Div button) ");
    }

    private void TW_check(ViewInteraction TW, final String value, final String name_method) {
        TW.check(new ViewAssertion() {
            @Override
            public void check(View view, NoMatchingViewException noViewFoundException) {
                if (!((TextView) view).getText().toString().equals(value)) {
                    throw new IllegalStateException(name_method + "The answer is not right: " + value + ". Right value is: " + ((TextView) view).getText().toString());
                }
            }
        });
    }

    private void Button_check(ViewInteraction name_button, final String exception_text) {
        name_button.check(new ViewAssertion() {
            @Override
            public void check(View view, NoMatchingViewException noViewFoundException) {
                if (!view.isEnabled()) {
                    throw new IllegalStateException(exception_text);
                } else {
                    view.performClick();
                }
            }
        });
    }
}