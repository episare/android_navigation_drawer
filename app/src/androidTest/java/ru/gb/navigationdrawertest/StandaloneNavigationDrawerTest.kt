package ru.gb.navigationdrawertest

import androidx.appcompat.widget.ActionMenuView
import androidx.appcompat.widget.AppCompatImageButton
import androidx.appcompat.widget.AppCompatTextView
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.assertion.ViewAssertions.matches

import androidx.test.espresso.matcher.ViewMatchers.*
import androidx.test.ext.junit.rules.ActivityScenarioRule
import androidx.test.ext.junit.runners.AndroidJUnit4
import org.hamcrest.core.AllOf.allOf
import org.hamcrest.core.IsInstanceOf.instanceOf

import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class StandaloneNavigationDrawerTest {

    @get:Rule
    val activityRule = ActivityScenarioRule(MainActivity::class.java)

    @Test
    fun checkToolbarMenu() {

        onView(withId(R.id.toolbar)).check(matches(isDisplayed()))

        val toolbarTextView = onView(
            allOf(
                instanceOf(AppCompatTextView::class.java),
                withParent(withId(R.id.toolbar))
            )
        )
        val toolbarImageButton = onView(
            allOf(
                instanceOf(AppCompatImageButton::class.java),
                withParent(withId(R.id.toolbar))
            )
        )
        val textHomeFragment = onView(withId(R.id.text_home))

        val toolbarActionMenuView =
            onView(allOf(instanceOf(ActionMenuView::class.java), withParent(withId(R.id.toolbar))))

        toolbarTextView.check(matches(withText("Home")))
        textHomeFragment.check(matches(withText("This is home Fragment")))

        toolbarImageButton.check(matches(isClickable()))
        toolbarImageButton.perform(click())
        onView(withId(R.id.nav_gallery)).perform(click())

        toolbarTextView.check(matches(withText("Gallery")))
        onView(withId(R.id.text_gallery)).check(matches(withText("This is gallery Fragment")))

        toolbarImageButton.check(matches(isClickable()))
        toolbarImageButton.perform(click())
        onView(withId(R.id.nav_slideshow)).perform(click())

        toolbarTextView.check(matches(withText("Slideshow")))
        onView(withId(R.id.text_slideshow)).check(matches(withText("This is slideshow Fragment")))

        toolbarImageButton.check(matches(isClickable()))
        toolbarImageButton.perform(click())
        onView(withId(R.id.nav_home)).perform(click())

        toolbarTextView.check(matches(withText("Home")))
        textHomeFragment.check(matches(withText("This is home Fragment")))

        toolbarActionMenuView.check(matches(isEnabled()))
        toolbarActionMenuView.perform(click())
        onView(withChild(withText("Settings"))).check(matches(isEnabled()))
        onView(withChild(withText("Settings"))).perform(click())

    }
}