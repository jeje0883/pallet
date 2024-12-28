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
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.foundation.shape.RoundedCornerShape
import com.example.pmr.R

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
        text = "Scan QR",
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
        fillColor = Color (0xFFF0F2F5),
        text = "Generate",
        iconRes = null,
        width = 95
    )
}

@Composable
fun CustomButton(
    buttonType: ButtonType,
    onClick: () -> Unit
) {
    // Determine if a border should be applied
    val hasBorder = buttonType.borderColor != Color.Transparent

    // Create a modifier chain
    var buttonModifier = Modifier
        .padding(16.dp) // Padding around the button
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
        modifier = buttonModifier
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically
        ) {
            // Only show Icon if iconRes is not null
            if (buttonType.iconRes != null) {
                Icon(
                    painter = painterResource(id = buttonType.iconRes),
                    contentDescription = "${buttonType.text} icon", // Enhanced accessibility description
                    tint = if (buttonType.fillColor != Color.Transparent) buttonType.textColor else Color.Unspecified, // Apply tint only if button has fill color
                    modifier = Modifier
                        .size(24.dp) // Adjust icon size as needed
                        .padding(end = 8.dp) // Space between icon and text
                )
            }
            Text(text = buttonType.text, color = buttonType.textColor)
        }
    }
}

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
            CustomButton(
                buttonType = ButtonType.Upload,
                onClick = { /* Handle Upload Click */ }
            )
            CustomButton(
                buttonType = ButtonType.Print,
                onClick = { /* Handle Print Click */ }
            )
            CustomButton(
                buttonType = ButtonType.ScanQR,
                onClick = { /* Handle Scan QR Click */ }
            )
            CustomButton(
                buttonType = ButtonType.ScanHistory,
                onClick = { /* Handle Scan History Click */ }
            )
            CustomButton(
                buttonType = ButtonType.Cancel,
                onClick = { /* Handle Cancel Click */ }
            )
            CustomButton(
                buttonType = ButtonType.Okay,
                onClick = { /* Handle Okay Click */ }
            )
            CustomButton(
                buttonType = ButtonType.Confirm,
                onClick = { /* Handle Confirm Click */ }
            )
            CustomButton(
                buttonType = ButtonType.Delete,
                onClick = { /* Handle Delete Click */ }
            )
            CustomButton(
                buttonType = ButtonType.Generate,
                onClick = { /* Handle Delete Click */ }
            )
        }
    }
}
