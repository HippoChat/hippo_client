package com.example.hippo

import android.text.Editable
import android.text.TextWatcher
import android.util.Patterns
import android.widget.EditText

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

fun String.isValidPhone(): Boolean
        = this.isNotEmpty() && Patterns.PHONE.matcher(this).matches()

fun String.isValidCode(): Boolean
        = this.isNotEmpty() && this.length == 4

fun String.isValidName(): Boolean
        = this.isNotEmpty() && !this[0].isDigit() 
        