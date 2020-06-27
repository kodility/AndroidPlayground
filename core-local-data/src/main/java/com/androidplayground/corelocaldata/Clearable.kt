package com.androidplayground.corelocaldata

import io.reactivex.rxjava3.annotations.CheckReturnValue
import io.reactivex.rxjava3.core.Completable

/**
 * Created by Mostafa Monowar at 03-May-20 1:58 PM
 * monowar1993@gmail.com
 *
 * Implement this interface in order to make a clearable cache. Intentional we did not rename this interface to
 * ClearableCache for historical and understanding reasons. Every local persisting caching mechanism should implement it.
 */
interface Clearable {
    /**
     * Clears the cache on completion.
     *
     * @return a [Completable] that completes when the cache has been cleared.
     */
    @CheckReturnValue
    fun clear(): Completable
}
