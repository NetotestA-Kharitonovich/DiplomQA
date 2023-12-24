package ru.iteco.fmhandroid.ui.pageobject;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
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

public class ButtonMainSteps {

    //Кнопка Назад в разделе О приложении
    public void buttonBackAbout() {
        ViewInteraction clickBack = onView(
                allOf(withId(R.id.about_back_image_button)));
        clickBack.check(matches(isDisplayed()));
        clickBack.perform(click());
    }

    //Кнопка перехода в раздел Цитатник
    public void buttonLoveIsAll() {
        ViewInteraction clickButtonLoveIsAll = onView(
                allOf(withId(R.id.our_mission_image_button)));
        clickButtonLoveIsAll.check(matches(isDisplayed()));
        clickButtonLoveIsAll.perform(click());
    }

    //Выбор сообщения Новости в разделе Главная
    public void containerListNews() {
        ViewInteraction clickButtonListNews = onView(
                allOf(withId(R.id.expand_material_button),
                        childAtPosition(
                                childAtPosition(
                                        withId(R.id.container_list_news_include_on_fragment_main),
                                        0),
                                4)));
        clickButtonListNews.check(matches(isDisplayed()));
        clickButtonListNews.perform(click());
    }

    //Двойное нажатие на сообщение в News в разделе Главная
    public void containerListDoubleTapNews() {
        new ButtonMainSteps().containerListNews();
        new ButtonMainSteps().containerListNews();
    }

    //Выбор сообщения Новости по позиции
    public void newsListRecycler() {
        ViewInteraction recyclerViewList = onView(
                allOf(withId(R.id.news_list_recycler_view),
                        childAtPosition(
                                withId(R.id.all_news_cards_block_constraint_layout),
                                0)));
        recyclerViewList.check(matches(isDisplayed()));
        recyclerViewList.perform(actionOnItemAtPosition(0, click()));
    }

    //Выбор сообщения Новости по позиции, Двойное нажатие
    public void newsListDoubleTapRecycler() {
        new ButtonMainSteps().newsListRecycler();
        new ButtonMainSteps().newsListRecycler();
    }

    //Кнопка Все новости в разделе Главная
    public void buttonAllNews() {
        ViewInteraction clickAllNews = onView((withId(R.id.all_news_text_view)));
        clickAllNews.check(matches(isDisplayed()));
        clickAllNews.perform(click());
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
