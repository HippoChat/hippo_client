package com.example.hippo

import android.text.Editable
import android.text.TextWatcher
import android.widget.EditText
import java.util.regex.Pattern

fun EditText.validate(message: String, validator: (String) -> Boolean) {
    this.afterTextChanged {
        this.error = if (validator(it)) null else message
    }
    this.error = if (validator(this.text.toString())) null else message
}

fun EditText.afterTextChanged(afterTextChanged: (String) -> Unit) {
    this.addTextChangedListener(object : TextWatcher {
        override fun afterTextChanged(s: Editable?) {
            afterTextChanged.invoke(s.toString())
        }

        override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {}

        override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {}
    })
}

// Patterns.PHONE is not suitable for validation
// So we used https://regex101.com/library/wZ4uU6
private val phonePattern: Pattern =
    Pattern.compile("\\+?\\d{1,4}?[-.\\s]?\\(?\\d{1,3}?\\)?[-.\\s]?\\d{1,4}[-.\\s]?\\d{1,4}[-.\\s]?\\d{1,9}")

fun String.isValidPhone(): Boolean =
    this.isNotEmpty() && phonePattern.matcher(this).matches()

fun String.isValidCode(): Boolean = this.isNotEmpty() && this.length == 4

// Sounds like a reasonable name length
fun String.isValidName(): Boolean = this.isNotEmpty() && this.length < 20
        