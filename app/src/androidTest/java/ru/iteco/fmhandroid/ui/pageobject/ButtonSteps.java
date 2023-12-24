package ru.iteco.fmhandroid.ui.pageobject;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.action.ViewActions.scrollTo;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.contrib.RecyclerViewActions.actionOnItemAtPosition;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static org.hamcrest.Matchers.allOf;

import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;

import androidx.test.espresso.ViewInteraction;

import org.hamcrest.Description;
import org.hamcrest.Matcher;
import org.hamcrest.TypeSafeMatcher;

import ru.iteco.fmhandroid.R;

public class ButtonSteps {
    //Кновка Войти находящейся в авторизации
    public void signIn() {
        ViewInteraction clickButton = onView(
                allOf(withId(R.id.enter_button)));
        clickButton.check(matches(isDisplayed()));
        clickButton.perform(click());
    }

    public void listRecyclerOurMission() {
        ViewInteraction recyclerView = onView(
                allOf(withId(R.id.our_mission_item_list_recycler_view)));
        recyclerView.perform(actionOnItemAtPosition(0, click()));
    }

    public void buttonOkAlert() {
        ViewInteraction clickOkMessage = onView(
                allOf(withId(android.R.id.button1)));
        clickOkMessage.check(matches(isDisplayed()));
        clickOkMessage.perform(scrollTo(), click());
    }

    public void buttonCancelAlert() {
        ViewInteraction clickCancelMessage = onView(
                allOf(withId(android.R.id.button2)));
        clickCancelMessage.check(matches(isDisplayed()));
        clickCancelMessage.perform(scrollTo(), click());
    }

       private static Matcher<View> childAtPosition(
            final Matcher<View> parentMatcher, final int position) {

        return new TypeSafeMatcher<View>() {
            @Override
            public void describeTo(Description description) {
                description.appendText("Child at position " + position + " in parent ");
                parentMatcher.describeTo(description);
            }

            @Override
            public boolean matchesSafely(View view) {
                ViewParent parent = view.getParent();
                return parent instanceof ViewGroup && parentMatcher.matches(parent)
                        && view.equals(((ViewGroup) parent).getChildAt(position));
            }
        };
    }

}
