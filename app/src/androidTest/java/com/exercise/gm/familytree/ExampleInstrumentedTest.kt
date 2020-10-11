package com.exercise.gm.familytree

import androidx.test.platform.app.InstrumentationRegistry
import androidx.test.ext.junit.runners.AndroidJUnit4

import org.junit.Test
import org.junit.runner.RunWith

import org.junit.Assert.*

/**
 * Instrumented test, which will execute on an Android device.
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
@RunWith(AndroidJUnit4::class)
class ExampleInstrumentedTest {
    @Test
    fun useAppContext() {
        // Context of the app under test.
        val appContext = InstrumentationRegistry.getInstrumentation().targetContext
        assertEquals("com.exercise.gm.familytree", appContext.packageName)
    }

    @Test
    fun buildAndUseFamilyTree() {
        val ft = FamilyTree()
        ft.createFamilyTree(0, "Helena", 1, "Ogustus")
        ft.haveAKid(0, 1, 2, "Shon", Gender.MALE)
        ft.haveAKid(0, 1, 3, "Milly", Gender.FEMALE)
        ft.haveAKid(0, 1, 4, "Igor", Gender.MALE)
        ft.haveAKid(0, 1, 5, "Ashley", Gender.FEMALE)


        ft.marry(2, 6,"Juliana", Gender.FEMALE)
        ft.haveAKid(6, 2, 7, "David", Gender.MALE)
        ft.haveAKid(6, 2, 8, "Yan", Gender.MALE)


        ft.marry(5, 9, "Stephan", Gender.MALE)
        ft.haveAKid(6, 5, 10, "Herlinda", Gender.FEMALE)
        ft.haveAKid(6, 5, 11, "Sandy", Gender.FEMALE)


        ft.divorce(2, 6, Custody.MOTHER)
        ft.show()
    }
}