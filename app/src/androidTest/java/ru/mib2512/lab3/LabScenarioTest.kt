package ru.mib2512.lab3
import androidx.test.core.app.ActivityScenario
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.platform.app.InstrumentationRegistry
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.Espresso.pressBack
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.action.ViewActions.typeText
import androidx.test.espresso.action.ViewActions.replaceText
import androidx.test.espresso.action.ViewActions.closeSoftKeyboard
import androidx.test.espresso.action.ViewActions.scrollTo
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.*
import org.hamcrest.Matchers.not
import org.junit.Assert.assertTrue
import org.junit.Test
import org.junit.runner.RunWith
@RunWith(AndroidJUnit4::class)
class LabScenarioTest {
    @Test fun buttonsSwitchBothFragmentsAndRestoreSelection() {
        ActivityScenario.launch(MainActivity::class.java).use { scenario ->
            onView(withId(R.id.frag2_btn)).perform(click())
            onView(withId(R.id.info)).check(matches(withText(R.string.student_group)))
            scenario.recreate()
            onView(withId(R.id.info)).check(matches(withText(R.string.student_group)))
            onView(withId(R.id.switch_btn)).perform(click())
            onView(withId(R.id.info)).check(matches(withText(R.string.students)))
            onView(withId(R.id.frag2_btn)).perform(click())
            onView(withId(R.id.frag1_btn)).perform(click())
            onView(withId(R.id.info)).check(matches(withText(R.string.students)))
            scenario.onActivity { assertTrue(it.window.attributes.flags and android.view.WindowManager.LayoutParams.FLAG_SECURE != 0) }
        }
    }
}
