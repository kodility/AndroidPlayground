package com.androidplayground.libbase.utils

import androidx.fragment.app.Fragment

/**
 * Extension function used for automatically casting the parent activity context or fragment to the specified
 * listener. In case none of them is implementing the requested interface then an exception is thrown.
 */
inline fun <reified T> Fragment.listener(): T = when {
    context is T -> context as T
    activity is T -> activity as T
    parentFragment is T -> parentFragment as T
    else -> throw IllegalStateException("The Activity or the ParentFragment using this fragment must implement " +
            "the ${T::class.java.simpleName} interface")
}

/**
 * This is essentially the same as [listener] but for Java with optional support since reified functions
 * are not visible in Java.
 * The reason we have optional support for Java only is that our old code needs that while our new one does not.
 * Once we have migrated all of our consumer code of this method to Kotlin we can delete this method.
 */
fun <T> Fragment.optionalListener(clazz: Class<T>): T? {
    val localContext = context
    val localActivity = activity
    val localParentFragment = parentFragment

    return when {
        localContext != null && clazz.isAssignableFrom(localContext.javaClass) -> clazz.cast(localContext)
        localActivity != null && clazz.isAssignableFrom(localActivity.javaClass) -> clazz.cast(localActivity)
        localParentFragment != null && clazz.isAssignableFrom(localParentFragment.javaClass) -> clazz.cast(localParentFragment)
        else -> null
    }
}

@Suppress("Detekt.ComplexCondition")
fun <T : Fragment> recreateFragmentIfRequired(fragment: T?, factory: () -> T): T {
    if (fragment == null || fragment.isRemoving || fragment.activity == null || fragment.isDetached) {
        return factory()
    }
    return fragment
}