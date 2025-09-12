package com.defey.testcourse.utils

import java.text.NumberFormat
import java.time.LocalDate
import java.time.format.DateTimeFormatter
import java.time.format.DateTimeParseException
import java.util.Locale

fun parseDate(dateString: String): LocalDate? {
    return try {
        LocalDate.parse(dateString, DateTimeFormatter.ISO_LOCAL_DATE)
    } catch (e: DateTimeParseException) {
        null
    }
}

fun formatDateToString(localDate: LocalDate?): String {
    if (localDate == null) return ""
    val formatter = DateTimeFormatter.ofPattern("d MMMM yyyy")
    return localDate.format(formatter)
}

fun formatPriceClean(priceString: String, locale: Locale = Locale.forLanguageTag("ru-RU")): String {
    val cleanPrice = priceString.replace("\\s+".toRegex(), "")
    val priceNumber = cleanPrice.toDoubleOrNull() ?: return priceString
    val format = NumberFormat.getCurrencyInstance(locale)
    format.maximumFractionDigits = 0
    return format.format(priceNumber)
}

fun String.onlyDigits(): String = this.filter { it.isDigit() }.trim()