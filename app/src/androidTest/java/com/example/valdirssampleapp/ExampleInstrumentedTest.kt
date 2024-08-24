package com.example.valdirssampleapp

import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.platform.app.InstrumentationRegistry
import org.junit.Assert.assertEquals
import org.junit.Test
import org.junit.runner.RunWith

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
        assertEquals("com.example.valdirssampleapp", appContext.packageName)
    }

//    private val moshi = Moshi.Builder()
//        .add(AnimalAdapterFactory)
//        .build()
//
//    @Test
//    fun test() {
//        val dog: Animal = Animal.Dog(true)
//        val cat: Animal = Animal.Cat(7)
//        println(moshi.adapter(Animal::class.java).toJson(dog))
//        println(moshi.adapter(Animal::class.java).toJson(cat))
//        val shouldBeDog: Animal? = moshi.adapter(Animal::class.java).fromJson(moshi.adapter(Animal::class.java).toJson(dog))
//        val shouldBeCat: Animal? = moshi.adapter(Animal::class.java).fromJson(moshi.adapter(Animal::class.java).toJson(cat))
//        println(shouldBeDog)
//        println(shouldBeCat)
//    }
}