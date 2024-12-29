// File: Button.kt

package com.example.pmr.components

import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.ui.unit.sp
import com.example.pmr.R

/**
 * Enum representing different types of buttons with their properties.
 */
enum class ButtonType(
    val textColor: Color,
    val fillColor: Color,
    val borderColor: Color = Color.Transparent, // Default to no border
    val text: String,
    val iconRes: Int?, // Drawable resource ID, nullable for buttons without icons
    val width: Int,
    val height: Int = 40 // Default height set to 40.dp
) {
    Upload(
        textColor = Color.White,
        fillColor = Color(0xFF10B981), // Green
        text = "Upload",
        iconRes = R.drawable.upload_icon, // Your PNG icon
        width = 310
    ),
    Print(
        textColor = Color.White,
        fillColor = Color(0xFF268AF5), // Blue
        text = "Print",
        iconRes = R.drawable.print_icon, // Your PNG icon
        width = 104
    ),
    ScanQR(
        textColor = Color.White,
        fillColor = Color(0xFF268AF5), // Blue
        text = "Scan QR", // Corrected text
        iconRes = R.drawable.scan_icon, // Your PNG icon
        width = 118
    ),
    ScanHistory(
        textColor = Color.Black,
        fillColor = Color.Transparent, // No fill color
        borderColor = Color(0xFFF0ECF1), // Specific border color
        text = "Scan History",
        iconRes = R.drawable.scan_history_icon, // Your PNG icon
        width = 310
    ),
    Cancel(
        textColor = Color.Black,
        fillColor = Color(0xFFF0F2F5), // Corrected Gray color with 8 digits
        text = "Cancel",
        iconRes = null, // No icon
        width = 310
    ),
    Okay(
        textColor = Color.White,
        fillColor = Color(0xFF268AF5), // Blue
        text = "Okay",
        iconRes = null, // No icon
        width = 310
    ),
    Confirm(
        textColor = Color.White,
        fillColor = Color(0xFF268AF5), // Blue
        text = "Confirm",
        iconRes = null, // No icon
        width = 310
    ),
    Delete(
        textColor = Color.White,
        fillColor = Color(0xFFDC2626), // Red
        text = "Yes, delete it!",
        iconRes = null, // No icon
        width = 310
    ),
    Generate(
        textColor = Color.Black,
        fillColor = Color(0xFFF0F2F5),
        text = "Generate",
        iconRes = null,
        width = 95
    )
}

/**
 * Singleton object containing composable functions for each button type.
 */
object CustomButton {

    /**
     * General-purpose button composable.
     */
    @Composable
    fun Button(
        buttonType: ButtonType,
        onClick: () -> Unit
    ) {
        // Determine if a border should be applied
        val hasBorder = buttonType.borderColor != Color.Transparent

        // Create a modifier chain with fixed width and height
        var buttonModifier = Modifier
            .padding(vertical = 8.dp) // Vertical padding between buttons
            .width(buttonType.width.dp)
            .height(buttonType.height.dp)

        // Apply border conditionally
        if (hasBorder) {
            buttonModifier = buttonModifier.border(
                width = 2.dp, // Border width
                color = buttonType.borderColor, // Border color
                shape = RoundedCornerShape(4.dp) // Match the button's shape
            )
        }

        Button(
            onClick = onClick,
            colors = ButtonDefaults.buttonColors(containerColor = buttonType.fillColor),
            shape = RoundedCornerShape(4.dp), // Corner radius
            modifier = buttonModifier,
            contentPadding = PaddingValues(horizontal = 12.dp) // Adjust horizontal padding
        ) {
            Row(
                verticalAlignment = Alignment.CenterVertically, // Vertically center content
                horizontalArrangement = Arrangement.Center, // Horizontally center content
                modifier = Modifier.fillMaxSize() // Fill the button's size
            ) {
                // Only show Icon if iconRes is not null
                if (buttonType.iconRes != null) {
                    Icon(
                        painter = painterResource(id = buttonType.iconRes),
                        contentDescription = "${buttonType.text} icon", // Enhanced accessibility description
                        tint = if (buttonType.fillColor != Color.Transparent) buttonType.textColor else Color.Unspecified, // Apply tint only if button has fill color
                        modifier = Modifier
                            .size(20.dp) // Slightly smaller icon to save space
                            .padding(end = 8.dp) // Space between icon and text
                    )
                }
                Text(
                    text = buttonType.text,
                    color = buttonType.textColor,
                    fontSize = 14.sp, // Reduced font size to fit text within fixed width
                    maxLines = 1,
                    overflow = TextOverflow.Ellipsis, // Handle overflow gracefully
                    modifier = Modifier // Removed Modifier.weight(1f) to allow content to center
                )
            }
        }
    }

    /**
     * Composable for the "Upload" button.
     */
    @Composable
    fun Upload(onClick: () -> Unit) {
        Button(buttonType = ButtonType.Upload, onClick = onClick)
    }

    /**
     * Composable for the "Print" button.
     */
    @Composable
    fun Print(onClick: () -> Unit) {
        Button(buttonType = ButtonType.Print, onClick = onClick)
    }

    /**
     * Composable for the "Scan QR" button.
     */
    @Composable
    fun ScanQR(onClick: () -> Unit) {
        Button(buttonType = ButtonType.ScanQR, onClick = onClick)
    }

    /**
     * Composable for the "Scan History" button.
     */
    @Composable
    fun ScanHistory(onClick: () -> Unit) {
        Button(buttonType = ButtonType.ScanHistory, onClick = onClick)
    }

    /**
     * Composable for the "Cancel" button.
     */
    @Composable
    fun Cancel(onClick: () -> Unit) {
        Button(buttonType = ButtonType.Cancel, onClick = onClick)
    }

    /**
     * Composable for the "Okay" button.
     */
    @Composable
    fun Okay(onClick: () -> Unit) {
        Button(buttonType = ButtonType.Okay, onClick = onClick)
    }

    /**
     * Composable for the "Confirm" button.
     */
    @Composable
    fun Confirm(onClick: () -> Unit) {
        Button(buttonType = ButtonType.Confirm, onClick = onClick)
    }

    /**
     * Composable for the "Delete" button.
     */
    @Composable
    fun Delete(onClick: () -> Unit) {
        Button(buttonType = ButtonType.Delete, onClick = onClick)
    }

    /**
     * Composable for the "Generate" button.
     */
    @Composable
    fun Generate(onClick: () -> Unit) {
        Button(buttonType = ButtonType.Generate, onClick = onClick)
    }
}

/**
 * Preview composable to display all buttons.
 */
@Preview(showBackground = true, showSystemUi = true)
@Composable
fun PreviewButtons() {
    Box(
        modifier = Modifier
            .fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        Column (
            modifier = Modifier
                .padding(16.dp)
                .verticalScroll(rememberScrollState()),
            verticalArrangement = Arrangement.spacedBy(16.dp) // Add spacing between buttons
        ) {
            CustomButton.Upload(
                onClick = { /* Handle Upload Click */ }
            )
            CustomButton.Print(
                onClick = { /* Handle Print Click */ }
            )
            CustomButton.ScanQR(
                onClick = { /* Handle Scan QR Click */ }
            )
            CustomButton.ScanHistory(
                onClick = { /* Handle Scan History Click */ }
            )
            CustomButton.Cancel(
                onClick = { /* Handle Cancel Click */ }
            )
            CustomButton.Okay(
                onClick = { /* Handle Okay Click */ }
            )
            CustomButton.Confirm(
                onClick = { /* Handle Confirm Click */ }
            )
            CustomButton.Delete(
                onClick = { /* Handle Delete Click */ }
            )
            CustomButton.Generate(
                onClick = { /* Handle Generate Click */ }
            )
        }
    }
}
