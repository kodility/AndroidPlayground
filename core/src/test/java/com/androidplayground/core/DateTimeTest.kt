package com.androidplayground.core

import org.junit.Test
import org.threeten.bp.LocalDateTime
import org.threeten.bp.OffsetDateTime
import org.threeten.bp.ZoneId
import org.threeten.bp.ZoneOffset
import org.threeten.bp.ZonedDateTime
import org.threeten.bp.format.DateTimeFormatter

/**
 * Created by Mostafa Monowar
 * monowar1993@gmail.com
 */
class DateTimeTest {
    @Test
    fun printDateTime() {
        println(DateTimeFormatter.ISO_LOCAL_DATE_TIME.format(LocalDateTime.now()))
        println(DateTimeFormatter.ISO_OFFSET_DATE_TIME.format(OffsetDateTime.now()))
        println(DateTimeFormatter.ISO_ZONED_DATE_TIME.format(ZonedDateTime.now()))
        println(DateTimeFormatter.ISO_INSTANT.format(LocalDateTime.now().atZone(ZoneId.systemDefault()).toInstant()))
        println()
        println(
            DateTimeFormatter.ISO_OFFSET_DATE_TIME.format(
                ZonedDateTime.now().toInstant().atZone(ZoneId.of("UTC")).toOffsetDateTime()
            )
        )
        println(
            DateTimeFormatter.ISO_ZONED_DATE_TIME.format(
                ZonedDateTime.now().toInstant().atZone(ZoneId.of("UTC"))
            )
        )
        println()
        println(ZonedDateTime.now().toInstant().atZone(ZoneOffset.of("+01")))
        println(OffsetDateTime.now().toInstant().atZone(ZoneOffset.of("+01")))

        println(DateTimeFormatter.ISO_INSTANT.format(ZonedDateTime.now()))
    }
}
