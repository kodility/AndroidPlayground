package com.androidplayground.libapi

import org.junit.Test

import org.junit.Assert.*
import org.threeten.bp.*
import org.threeten.bp.format.DateTimeFormatter

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
class ExampleUnitTest {
    @Test
    fun addition_isCorrect() {
        assertEquals(4, 2 + 2)

        println(DateTimeFormatter.ISO_LOCAL_DATE_TIME.format(LocalDateTime.now()))
        println(DateTimeFormatter.ISO_OFFSET_DATE_TIME.format(OffsetDateTime.now()))
        println(DateTimeFormatter.ISO_ZONED_DATE_TIME.format(ZonedDateTime.now()))
        println(DateTimeFormatter.ISO_INSTANT.format(LocalDateTime.now().atZone(ZoneId.systemDefault()).toInstant()))
        println()
        println(
            DateTimeFormatter.ISO_OFFSET_DATE_TIME.format(
                ZonedDateTime.now().toInstant().atZone(ZoneId.of("UTC")).toOffsetDateTime()
            ))
        println(
            DateTimeFormatter.ISO_ZONED_DATE_TIME.format(
                ZonedDateTime.now().toInstant().atZone(ZoneId.of("UTC"))
            ))
        println()
        println(ZonedDateTime.now().toInstant().atZone(ZoneOffset.of("+01")))
        println(OffsetDateTime.now().toInstant().atZone(ZoneOffset.of("+01")))

        println(DateTimeFormatter.ISO_INSTANT.format(ZonedDateTime.now()))
    }
}
