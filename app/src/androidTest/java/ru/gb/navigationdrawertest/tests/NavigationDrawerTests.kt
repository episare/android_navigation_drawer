package ru.gb.navigationdrawertest.tests

import androidx.test.ext.junit.rules.ActivityScenarioRule
import org.junit.Rule
import org.junit.Test
import ru.gb.navigationdrawertest.MainActivity
import ru.gb.navigationdrawertest.pageElements.ToolbarElement

class NavigationDrawerTests {

    private val EXPECTED_HOME_TOOLBAR_TITLE = "Home"
    private val EXPECTED_GALLERY_TOOLBAR_TITLE = "Gallery"
    private val EXPECTED_SLIDESHOW_TOOLBAR_TITLE = "Slideshow"

    private val EXPECTED_HOME_FRAGMENT_TEXT = "This is home Fragment"
    private val EXPECTED_GALLERY_FRAGMENT_TEXT = "This is gallery Fragment"
    private val EXPECTED_SLIDESHOW_FRAGMENT_TEXT = "This is slideshow Fragment"

    private val ACTION_MENU_ITEM_SETTINGS = "Settings"

    @get:Rule
    val activityRule = ActivityScenarioRule(MainActivity::class.java)

    @Test
    fun checkNavigateToHome() {
        ToolbarElement()
            .checkToolbarIsDisplayed()
            .checkImageButtonIsClickable()
            .clickImageButton()
            .clickNavigateToHome()
            .checkToolbarTitle(EXPECTED_HOME_TOOLBAR_TITLE)
            .checkHomeFragmentText(EXPECTED_HOME_FRAGMENT_TEXT)
    }

    @Test
    fun checkNavigateToGallery() {
        ToolbarElement()
            .checkToolbarIsDisplayed()
            .checkImageButtonIsClickable()
            .clickImageButton()
            .clickNavigateToGallery()
            .checkToolbarTitle(EXPECTED_GALLERY_TOOLBAR_TITLE)
            .checkGalleryFragmentText(EXPECTED_GALLERY_FRAGMENT_TEXT)
    }

    @Test
    fun checkNavigateToSlideshow() {
        ToolbarElement()
            .checkToolbarIsDisplayed()
            .checkImageButtonIsClickable()
            .clickImageButton()
            .clickNavigateToSlideshow()
            .checkToolbarTitle(EXPECTED_SLIDESHOW_TOOLBAR_TITLE)
            .checkSlideshowFragmentText(EXPECTED_SLIDESHOW_FRAGMENT_TEXT)
    }

    @Test
    fun checkActionMenuSettings() {
        ToolbarElement()
            .checkToolbarIsDisplayed()
            .checkToolbarActionMenuIsEnabled()
            .clickToolbarActionMenu()
            .checkActionMenuItemIsEnabled(ACTION_MENU_ITEM_SETTINGS)
            .clickActionMenuItem(ACTION_MENU_ITEM_SETTINGS)
    }
}