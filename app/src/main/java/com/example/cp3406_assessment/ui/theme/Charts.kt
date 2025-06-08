package com.example.cp3406_assessment.ui.theme

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.layout.*
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Path
import androidx.compose.ui.graphics.StrokeCap
import androidx.compose.ui.graphics.StrokeJoin
import androidx.compose.ui.graphics.drawscope.DrawStyle
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun LineChart(
    modifier: Modifier = Modifier,
    dataPoints: List<Float>,  // values to plot
    lineColor: Color = Color.Blue,
    pointColor: Color = Color.Red,
) {
    // Basic checks
    if (dataPoints.isEmpty()) {
        Text("No data available", modifier = modifier)
        return
    }

    Canvas(modifier = modifier) {
        val canvasWidth = size.width
        val canvasHeight = size.height

        // Find max and min values in data for scaling
        val maxValue = dataPoints.maxOrNull() ?: 0f
        val minValue = dataPoints.minOrNull() ?: 0f
        val valueRange = maxValue - minValue
        if (valueRange == 0f) return@Canvas // avoid division by zero

        // Horizontal distance between points
        val spacing = canvasWidth / (dataPoints.size - 1)

        // Map data points to canvas coordinates
        val points = dataPoints.mapIndexed { index, value ->
            val x = index * spacing
            // Invert y axis because canvas y=0 is top
            val y = canvasHeight - ((value - minValue) / valueRange * canvasHeight)
            Offset(x, y)
        }

        // Draw line path connecting all points
        val path = Path().apply {
            moveTo(points[0].x, points[0].y)
            for (i in 1 until points.size) {
                lineTo(points[i].x, points[i].y)
            }
        }

        // Draw the line
        drawPath(
            path = path,
            color = lineColor,
            style = Stroke(
                width = 2f,
                cap = StrokeCap.Round,
                join = StrokeJoin.Round
            )
        )

        // Draw circles at each point
        points.forEach { point ->
            drawCircle(
                color = pointColor,
                radius = 2f * 1.5f,
                center = point
            )
        }
    }
}

@Preview
@Composable
fun SampleChartScreen() {
    val sampleData = listOf(10f, 50f, 30f, 60f, 90f, 40f, 80f)

    Column(
        modifier = Modifier
            .padding(16.dp)
    ) {
        Text("Simple Line Chart", style = MaterialTheme.typography.titleLarge)
        Spacer(modifier = Modifier.height(20.dp))

        LineChart(
            modifier = Modifier
                .height(200.dp)
                .fillMaxWidth(),
            dataPoints = sampleData,
            lineColor = Color(0xFF3F51B5),
            pointColor = Color(0xFFFF5722)
        )
    }
}