package com.example.cp3406_assessment

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.cp3406_assessment.ui.theme.LineChart

@Preview
@Composable
fun StatScreen() {
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
            SampleChart()
        }
    }
}


@Composable
fun SampleChart() {
    val sampleData = listOf(1f, 2f, 4f, 8f, 16f, 32f, 64f)

    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            "Number of Pages Read",
            style = MaterialTheme.typography.titleLarge
        )
        Spacer(modifier = Modifier.height(20.dp))

        Row(
            modifier = Modifier
                .height(220.dp) // extra height for label
                .fillMaxWidth()
        ) {
            // Y Axis Label - rotated vertically
            Box(
                modifier = Modifier
                    .width(40.dp)
                    .fillMaxHeight(),
                contentAlignment = Alignment.Center
            ) {
                Text(
                    "Pages",
                    style = MaterialTheme.typography.bodyMedium,
                    modifier = Modifier
                        .rotate(-90f) // rotate text vertical
                )
            }

            Spacer(modifier = Modifier.width(8.dp))

            // Chart + X axis label below
            Column(
                modifier = Modifier
                    .weight(1f)
                    .fillMaxHeight(),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                LineChart(
                    modifier = Modifier
                        .weight(1f)
                        .fillMaxWidth(),
                    dataPoints = sampleData,
                    lineColor = Color(0xFF3F51B5),
                    pointColor = Color(0xFFFF5722)
                )

                Spacer(modifier = Modifier.height(8.dp))

                Text(
                    "Days",
                    style = MaterialTheme.typography.bodyMedium
                )
            }
        }
    }
}