package ru.gb.navigationdrawertest.pageElements

import androidx.appcompat.widget.ActionMenuView
import androidx.appcompat.widget.AppCompatImageButton
import androidx.appcompat.widget.AppCompatTextView
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.*
import org.hamcrest.Matchers.allOf
import org.hamcrest.Matchers.instanceOf

import ru.gb.navigationdrawertest.R

class ToolbarElement {

    private val toolbarImageButton = onView(
        allOf(
            instanceOf(AppCompatImageButton::class.java),
            withParent(withId(R.id.toolbar))
        )
    )

    private val toolbarActionMenuView = onView(
        allOf(
            instanceOf(ActionMenuView::class.java),
            withParent(withId(R.id.toolbar))
        )
    )

    fun checkToolbarIsDisplayed(): ToolbarElement {
        onView(withId(R.id.toolbar))
            .check(matches(isDisplayed()));
        return this
    }

    fun checkToolbarTitle(text: String): ToolbarElement {
        onView(
            allOf(
                instanceOf(AppCompatTextView::class.java),
                withParent(withId(R.id.toolbar))
            )
        ).check(matches(withText(text)))
        return this
    }

    fun checkImageButtonIsClickable(): ToolbarElement {
        toolbarImageButton.check(matches(isClickable()))
        return this
    }

    fun clickImageButton(): ToolbarElement {
        toolbarImageButton.perform(click())
        return this
    }

    fun clickNavigateToHome(): ToolbarElement {
        onView(withId(R.id.nav_home)).perform(click())
        return this
    }

    fun clickNavigateToGallery(): ToolbarElement {
        onView(withId(R.id.nav_gallery)).perform(click())
        return this
    }

    fun clickNavigateToSlideshow(): ToolbarElement {
        onView(withId(R.id.nav_slideshow)).perform(click())
        return this
    }

    fun checkHomeFragmentText(text: String): ToolbarElement {
        onView(withId(R.id.text_home)).check(matches(withText(text)))
        return this
    }

    fun checkGalleryFragmentText(text: String): ToolbarElement {
        onView(withId(R.id.text_gallery)).check(matches(withText(text)))
        return this
    }

    fun checkSlideshowFragmentText(text: String): ToolbarElement {
        onView(withId(R.id.text_slideshow)).check(matches(withText(text)))
        return this
    }

    fun checkToolbarActionMenuIsEnabled(): ToolbarElement {
        toolbarActionMenuView.check(matches(isEnabled()))
        return this
    }

    fun clickToolbarActionMenu(): ToolbarElement {
        toolbarActionMenuView.perform(click())
        return this
    }

    fun checkActionMenuItemIsEnabled(itemName: String): ToolbarElement {
        onView(withChild(withText(itemName))).check(matches(isEnabled()))
        return this
    }

    fun clickActionMenuItem(itemName: String): ToolbarElement {
        onView(withChild(withText(itemName))).perform(click())
        return this
    }

}