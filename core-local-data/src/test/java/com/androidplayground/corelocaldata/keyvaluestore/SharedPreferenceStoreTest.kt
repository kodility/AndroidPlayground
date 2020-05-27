package com.androidplayground.corelocaldata.keyvaluestore

import com.github.ivanshafran.sharedpreferencesmock.SPMockBuilder
import org.junit.After
import org.junit.Before
import org.junit.Test

/**
 * Created by Mostafa Monowar at 16-May-20 3:58 AM
 * monowar1993@gmail.com
 */
class SharedPreferenceStoreTest {
    private val spMockBuilder by lazy { SPMockBuilder() }
    private lateinit var sharedPreferenceStore: SharedPreferenceStore

    @Before
    fun setUp() {
        sharedPreferenceStore = SharedPreferenceStore(spMockBuilder.createContext(), "test_shared_preferences")
    }

    @Test
    fun saveAndRetrieveIntPreference() {
        sharedPreferenceStore.put("int-key", 123)
            .test()
            .assertComplete()

        sharedPreferenceStore.getInt("int-key")
            .test()
            .assertValues(123)
            .assertNoErrors()
    }

    @Test
    fun saveAndRetrieveBooleanPreference() {
        sharedPreferenceStore.put("boolean-key", true)
            .test()
            .assertComplete()

        sharedPreferenceStore.getBoolean("boolean-key")
            .test()
            .assertNoErrors()
            .assertValues(true)
    }

    @Test
    fun throwIfPreferenceNotInt() {
        sharedPreferenceStore.put("string-key", "string").blockingAwait()

        sharedPreferenceStore.getInt("string-key")
            .test()
            .assertError(ClassCastException::class.java)
    }

    @Test
    fun throwIfPreferenceNotBoolean() {
        sharedPreferenceStore.put("string-key", "string").blockingAwait()

        sharedPreferenceStore.getBoolean("string-key")
            .test()
            .assertError(ClassCastException::class.java)
    }

    @Test
    fun removeSingleEntry() {
        sharedPreferenceStore.put("1", "foo").blockingAwait()
        sharedPreferenceStore.put("2", "bar").blockingAwait()
        sharedPreferenceStore.remove("1").blockingAwait()

        sharedPreferenceStore.getString("1")
            .test()
            .assertError(NullPointerException::class.java)

        sharedPreferenceStore.getString("2")
            .test()
            .assertResult("bar")
    }

    @Test
    fun clearKvsAsCache() {
        sharedPreferenceStore.put("1", "foo").blockingAwait()
        sharedPreferenceStore.put("2", "bar").blockingAwait()
        sharedPreferenceStore.clear().blockingAwait()

        sharedPreferenceStore.getString("1")
            .test()
            .assertError(NullPointerException::class.java)

        sharedPreferenceStore.getString("2")
            .test()
            .assertError(NullPointerException::class.java)
    }

    @After
    fun cleanUp() {
        // No resources to clean.
    }
}
