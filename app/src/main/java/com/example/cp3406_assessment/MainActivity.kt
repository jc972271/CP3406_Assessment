package com.example.cp3406_assessment

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Card
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import com.example.cp3406_assessment.ui.theme.CP3406_AssessmentTheme

import com.example.cp3406_assessment.data.Book
import com.example.cp3406_assessment.data.books

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            CP3406_AssessmentTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize()
                ) {
                    BookApp()
                }
            }
        }
    }
}

/**
 * Composable that displays an app bar and a list of dogs.
 */
@Composable
fun BookApp() {
    Scaffold(
        topBar = {
            BookTopAppBar()
        }
    ) { it ->
        LazyColumn(contentPadding = it) {
            items(books) {
                BookItem(
                    book = it,
                    modifier = Modifier.padding(dimensionResource(R.dimen.padding_small))
                )
            }
        }
    }
}

/**
 * Composable that displays a list item containing a book cover and its information.
 *
 * @param book contains the data that populates the list item
 * @param modifier modifiers to set to this composable
 */
@Composable
fun BookItem(
    book: Book,
    modifier: Modifier = Modifier
) {
    Card(
        modifier = modifier
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(dimensionResource(R.dimen.padding_small))
        ) {
            BookCover(book.imageResourceId)
            BookInformation(book.title, book.author)
        }
    }
}

/**
 * Composable that displays a Top Bar with an icon and text.
 *
 * @param modifier modifiers to set to this composable
 */
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun BookTopAppBar(modifier: Modifier = Modifier) {
    CenterAlignedTopAppBar(
        title = {
            Row(
                verticalAlignment = Alignment.CenterVertically
            ) {
                Image(
                    modifier = Modifier
                        .size(dimensionResource(R.dimen.image_size))
                        .padding(dimensionResource(R.dimen.padding_small)),
                    painter = painterResource(R.drawable.book_placeholder),

                    // Content Description is not needed here - image is decorative, and setting a
                    // null content description allows accessibility services to skip this element
                    // during navigation.

                    contentDescription = null
                )
                Text(
                    text = stringResource(R.string.app_name),
                    style = MaterialTheme.typography.displaySmall
                )
            }
        },
        modifier = modifier
    )
}

/**
 * Composable that displays a photo of a book cover.
 *
 * @param bookCover is the resource ID for the book cover
 * @param modifier modifiers to set to this composable
 */
@Composable
fun BookCover(
    @DrawableRes bookCover: Int,
    modifier: Modifier = Modifier
) {
    Image(
        modifier = modifier
            .size(dimensionResource(R.dimen.image_size))
            .padding(dimensionResource(R.dimen.padding_small)),
        //contentScale = ContentScale.Crop,
        painter = painterResource(bookCover),

        // Content Description is not needed here - image is decorative, and setting a null content
        // description allows accessibility services to skip this element during navigation.

        contentDescription = null
    )
}

/**
 * Composable that displays a books title and author.
 *
 * @param bookTitle is the resource ID for the string of the book's title
 * @param bookAuthor is the Int that represents the book's author
 * @param modifier modifiers to set to this composable
 */
@Composable
fun BookInformation(
    @StringRes bookTitle: Int,
    @StringRes bookAuthor: Int,
    modifier: Modifier = Modifier
) {
    Column(modifier = modifier) {
        Text(
            text = stringResource(bookTitle),
            style = MaterialTheme.typography.displayMedium,
            modifier = Modifier.padding(top = dimensionResource(R.dimen.padding_small))
        )
        Text(
            text = stringResource(bookAuthor, R.string.by_author),
            style = MaterialTheme.typography.bodyLarge
        )
    }
}

/**
 * Composable that displays what the UI of the app looks like in light theme in the design tab.
 */
@Preview
@Composable
fun AppPreview() {
    CP3406_AssessmentTheme(darkTheme = false) {
        BookApp()
    }
}