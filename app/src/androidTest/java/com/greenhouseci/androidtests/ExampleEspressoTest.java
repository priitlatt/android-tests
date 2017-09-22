package com.greenhouseci.androidtests;

import android.support.test.espresso.matcher.ViewMatchers;
import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;
import android.view.View;

import org.hamcrest.Matcher;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.clearText;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.action.ViewActions.typeText;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.isDisplayed;
import static android.support.test.espresso.matcher.ViewMatchers.withEffectiveVisibility;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;
import static junit.framework.Assert.assertEquals;

/**
 * Instrumentation test, which will execute on an Android device.
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
@RunWith(AndroidJUnit4.class)
public class ExampleEspressoTest {

    private void isViewDisplayed(Matcher<View> viewMatcher) {
        onView(viewMatcher).check(matches(isDisplayed()));
    }

    private void isNotDisplayed(Matcher<View> viewMatcher) {
        onView(viewMatcher).check(matches(withEffectiveVisibility(ViewMatchers.Visibility.GONE)));
    }

    public void addItemToList(final String item) {
        onView(withId(R.id.edit_item)).perform(clearText(), typeText(item));
        onView(withId(R.id.btn_add)).perform(click());
    }

    @Rule
    public ActivityTestRule<MainActivity> activityRule = new ActivityTestRule<MainActivity>(MainActivity.class);

    @Test
    public void testAddButtonText() {
        Matcher<View> v = withId(R.id.btn_add);
        isViewDisplayed(v);
        onView(v).check(matches(withText(R.string.btn_add_item)));
    }

    @Test
    public void testInputText() {
        Matcher<View> v = withId(R.id.edit_item);
        isViewDisplayed(v);
        onView(v).check(matches(withText("")));
    }

    @Test
    public void initialStateTest() {
        Matcher<View> tv = withId(R.id.tv_empty);
        isViewDisplayed(tv);
        onView(tv).check(matches(withText(R.string.tv_no_items)));
    }

    @Test
    public void testNoItemsTextDisappearing() {
        Matcher<View> tv = withId(R.id.tv_empty);
        addItemToList("First item");
        isNotDisplayed(tv);
    }

//    @Test
//    public void testAddItemsToList() throws Exception {
//        DataInteraction lv = onData(anything()).inAdapterView(withId(R.id.lv_items));
//        addItemToList("item 0");
//        addItemToList("item 1");
//
//        lv.atPosition(0).onChildView(withId(R.id.tv_list_item)).check(matches(withText("item 0")));
//        lv.atPosition(1).onChildView(withId(R.id.tv_list_item)).check(matches(withText("item 1")));
//    }

    @Test
    public void testApplicationName() throws Exception {
        assertEquals("TestApplication", activityRule.getActivity().getApplication().getClass().getSimpleName());
    }
}
