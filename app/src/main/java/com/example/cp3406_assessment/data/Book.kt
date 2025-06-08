package com.example.cp3406_assessment.data

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import com.example.cp3406_assessment.R

/**
 * A data class to represent the information presented in the dog card
 */
data class Book(
    @DrawableRes val imageResourceId: Int,
    @StringRes val title: Int,
    @StringRes val author: Int,
    var rating: Int
)

val books = listOf(
    Book(R.drawable.book_placeholder, R.string.book_name_1, R.string.book_author_1, 4),
    Book(R.drawable.book_placeholder, R.string.book_name_2, R.string.book_author_2, 4),
)