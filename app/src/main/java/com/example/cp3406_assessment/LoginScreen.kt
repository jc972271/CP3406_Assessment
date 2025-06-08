package com.example.cp3406_assessment

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.safeContentPadding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.text.input.TextFieldLineLimits
import androidx.compose.foundation.text.input.rememberTextFieldState
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.res.dimensionResource

import com.example.cp3406_assessment.BookTopAppBar
import com.example.cp3406_assessment.data.books

@Preview
@Composable
fun LoginScreen() {
    Scaffold(
        topBar = {
            BookTopAppBar()
        }
    ) { innerPadding ->
        Box(
            modifier = Modifier
                .fillMaxHeight(0.6f)
                .padding(innerPadding),
            contentAlignment = Alignment.Center // centers both vertically and horizontally
        ) {
            Column(
                modifier = Modifier.fillMaxWidth(),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                InputFields()
            }
        }
    }
}

@Preview
@Composable
fun InputFields() {
    var username by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }

    Column {
        OutlinedTextField(
            modifier = Modifier
                .fillMaxWidth()
                .padding(dimensionResource(R.dimen.padding_medium)),
            value = username,
            onValueChange = { username = it },
            label = { Text("Username") }
        )
        OutlinedTextField(
            modifier = Modifier
                .fillMaxWidth()
                .padding(dimensionResource(R.dimen.padding_medium)),
            value = password,
            onValueChange = { password = it },
            label = { Text("Password") }
        )
        Button(
            modifier = Modifier
                .fillMaxWidth()
                .padding(dimensionResource(R.dimen.padding_medium)),
            onClick = {
                // Handle login logic here
                println("Logging in with $username")
            }
        ) {
            Text("Login")
        }
    }
}

