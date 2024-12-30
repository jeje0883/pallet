package com.example.pmr.components

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.drawWithContent
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.StrokeCap
import androidx.compose.ui.graphics.drawscope.DrawScope
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp

@Composable
fun CornerBorderBox(
    modifier: Modifier = Modifier,
    cornerLength: Dp = 40.dp,  // total corner "reach"
    cornerRadius: Dp = 6.dp,   // radius of the arc
    borderWidth: Dp = 2.dp,
    borderColor: Color = Color.Black,
    content: @Composable () -> Unit = {}
) {
    Box(
        modifier = modifier.drawWithContent {
            // Draw the child composable(s) first
            drawContent()

            // Then draw lines + arcs at each corner
            drawCornerArcsAndLines(
                cornerLength = cornerLength.toPx(),
                cornerRadius = cornerRadius.toPx(),
                strokeWidth = borderWidth.toPx(),
                borderColor = borderColor
            )
        }
    ) {
        content()
    }
}

private fun DrawScope.drawCornerArcsAndLines(
    cornerLength: Float,
    cornerRadius: Float,
    strokeWidth: Float,
    borderColor: Color
) {
    val w = size.width
    val h = size.height

    // "lineLen" is how long each straight segment is, leaving room for the arc.
    val lineLen = (cornerLength - cornerRadius).coerceAtLeast(0f)

    // --- Top-Left Corner ---
    // Horizontal line
    drawLine(
        color = borderColor,
        start = Offset(cornerRadius, 0f),
        end = Offset(cornerRadius + lineLen, 0f),
        strokeWidth = strokeWidth,
        cap = StrokeCap.Round
    )
    // Arc: from 180° (left) to 270° (up) around (cornerRadius, cornerRadius)
    drawArcSegment(
        color = borderColor,
        center = Offset(cornerRadius, cornerRadius),
        radius = cornerRadius,
        startAngle = 180f,
        sweepAngle = 90f,
        strokeWidth = strokeWidth
    )
    // Vertical line
    drawLine(
        color = borderColor,
        start = Offset(0f, cornerRadius),
        end = Offset(0f, cornerRadius + lineLen),
        strokeWidth = strokeWidth,
        cap = StrokeCap.Round
    )

    // --- Top-Right Corner ---
    // Horizontal line
    drawLine(
        color = borderColor,
        start = Offset(w - cornerRadius - lineLen, 0f),
        end = Offset(w - cornerRadius, 0f),
        strokeWidth = strokeWidth,
        cap = StrokeCap.Round
    )
    // Arc: from 270° (up) to 360° (right) around (w - cornerRadius, cornerRadius)
    drawArcSegment(
        color = borderColor,
        center = Offset(w - cornerRadius, cornerRadius),
        radius = cornerRadius,
        startAngle = 270f,
        sweepAngle = 90f,
        strokeWidth = strokeWidth
    )
    // Vertical line
    drawLine(
        color = borderColor,
        start = Offset(w, cornerRadius),
        end = Offset(w, cornerRadius + lineLen),
        strokeWidth = strokeWidth,
        cap = StrokeCap.Round
    )

    // --- Bottom-Left Corner ---
    // Vertical line
    drawLine(
        color = borderColor,
        start = Offset(0f, h - cornerRadius - lineLen),
        end = Offset(0f, h - cornerRadius),
        strokeWidth = strokeWidth,
        cap = StrokeCap.Round
    )
    // Arc: from 90° (down) to 180° (left) around (cornerRadius, h - cornerRadius)
    drawArcSegment(
        color = borderColor,
        center = Offset(cornerRadius, h - cornerRadius),
        radius = cornerRadius,
        startAngle = 90f,
        sweepAngle = 90f,
        strokeWidth = strokeWidth
    )
    // Horizontal line
    drawLine(
        color = borderColor,
        start = Offset(cornerRadius, h),
        end = Offset(cornerRadius + lineLen, h),
        strokeWidth = strokeWidth,
        cap = StrokeCap.Round
    )

    // --- Bottom-Right Corner ---
    // Vertical line
    drawLine(
        color = borderColor,
        start = Offset(w, h - cornerRadius - lineLen),
        end = Offset(w, h - cornerRadius),
        strokeWidth = strokeWidth,
        cap = StrokeCap.Round
    )
    // Arc: from 0° (right) to 90° (down) around (w - cornerRadius, h - cornerRadius)
    drawArcSegment(
        color = borderColor,
        center = Offset(w - cornerRadius, h - cornerRadius),
        radius = cornerRadius,
        startAngle = 0f,
        sweepAngle = 90f,
        strokeWidth = strokeWidth
    )
    // Horizontal line
    drawLine(
        color = borderColor,
        start = Offset(w - cornerRadius - lineLen, h),
        end = Offset(w - cornerRadius, h),
        strokeWidth = strokeWidth,
        cap = StrokeCap.Round
    )
}

/**
 * Draws an arc outline (not filled) from [startAngle] to [startAngle + sweepAngle],
 * using the given [strokeWidth], all within the circle defined by ([center], [radius]).
 *
 * Compose angles:
 *   - 0° is at 3 o'clock, angles increase clockwise.
 *   - 90° is at 6 o'clock, 180° is at 9 o'clock, 270° is at 12 o'clock.
 */
private fun DrawScope.drawArcSegment(
    color: Color,
    center: Offset,
    radius: Float,
    startAngle: Float,
    sweepAngle: Float,
    strokeWidth: Float
) {
    drawArc(
        color = color,
        startAngle = startAngle,
        sweepAngle = sweepAngle,
        useCenter = false,
        topLeft = Offset(center.x - radius, center.y - radius),
        size = androidx.compose.ui.geometry.Size(2 * radius, 2 * radius),
        style = Stroke(width = strokeWidth, cap = StrokeCap.Round)
    )
}
