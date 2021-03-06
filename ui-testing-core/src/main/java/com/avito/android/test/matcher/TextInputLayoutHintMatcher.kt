package com.avito.android.test.matcher

import android.support.design.widget.TextInputLayout
import android.support.test.espresso.matcher.BoundedMatcher
import android.view.View
import org.hamcrest.Description
import org.hamcrest.Matcher

class TextInputLayoutHintMatcher(private val stringMatcher: Matcher<String>) :
    BoundedMatcher<View, TextInputLayout>(TextInputLayout::class.java) {

    override fun describeTo(description: Description) {
        description.appendText("with hint text: ")
        stringMatcher.describeTo(description)
    }

    override fun matchesSafely(layout: TextInputLayout): Boolean =
        stringMatcher.matches(layout.hint.toString())
}
