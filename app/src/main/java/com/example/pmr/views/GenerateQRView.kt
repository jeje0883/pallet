package com.example.pmr.views

import android.graphics.Bitmap
import android.graphics.Color
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer // Import Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Checkbox
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue          // Added Import
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue          // Added Import
import androidx.compose.ui.Alignment             // Added Import
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.asImageBitmap
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.pmr.components.CustomButton
import com.example.pmr.components.Header
import com.example.pmr.components.InputType
import com.google.zxing.BarcodeFormat
import com.google.zxing.qrcode.QRCodeWriter
import androidx.compose.ui.graphics.graphicsLayer


@Composable
fun GenerateQRCode(
    data: String? = null,
    modifier: Modifier = Modifier
) {
    // Remember the generated bitmap to avoid regenerating on every recomposition
    val qrBitmap = remember(data) {
        data?.let { generateQRCodeBitmap(it, 292) }
    }

    qrBitmap?.let {
        Image(
            bitmap = it.asImageBitmap(),
            contentDescription = "QR Code",
            modifier = modifier
                .fillMaxSize()
        )
    }
}


// Helper function to generate a QR code bitmap
//private fun generateQRCodeBitmap(data: String, size: Int): Bitmap? {
//    return try {
//        val writer = QRCodeWriter()
//        val bitMatrix = writer.encode(data, BarcodeFormat.QR_CODE, size, size)
//        val bitmap = Bitmap.createBitmap(size, size, Bitmap.Config.RGB_565)
//
//        for (x in 0 until size) {
//            for (y in 0 until size) {
//                bitmap.setPixel(x, y, if (bitMatrix[x, y]) Color.BLACK else Color.WHITE)
//            }
//        }
//        bitmap
//    } catch (e: Exception) {
//        e.printStackTrace()
//        null
//    }
//}

private fun generateQRCodeBitmap(data: String, size: Int): Bitmap? {
    return try {
        val hints = mapOf(
            com.google.zxing.EncodeHintType.MARGIN to 0 // Remove default margin
        )
        val writer = QRCodeWriter()
        val bitMatrix = writer.encode(data, BarcodeFormat.QR_CODE, size, size, hints)
        val bitmap = Bitmap.createBitmap(size, size, Bitmap.Config.RGB_565)

        for (x in 0 until size) {
            for (y in 0 until size) {
                bitmap.setPixel(x, y, if (bitMatrix[x, y]) Color.BLACK else Color.WHITE)
            }
        }
        bitmap
    } catch (e: Exception) {
        e.printStackTrace()
        null
    }
}




// Accepts string to be converted to QR Code
@Composable
fun GenerateQR(data: String) {
    var selectedItem by remember { mutableStateOf("Item") }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.Top, // Start from the top
        horizontalAlignment = Alignment.CenterHorizontally // Center horizontally
    ) {
        // Header Section
        Header.GenerateQR(title = "Generate QR Code")
        Spacer(modifier = Modifier.height(16.dp)) // Spacer for spacing

        // Input Selection
        InputType.Selection(
            title = "Item",
            options = listOf("Item", "Item2", "Item3"),
            value = selectedItem,
            onValueChange = { selectedItem = it }
        )
        Spacer(modifier = Modifier.height(16.dp)) // Spacer for spacing

        // Row containing the rotated text and QR code
        Row(
            modifier = Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically, // Center vertically within the Row
            horizontalArrangement = Arrangement.Center // Center horizontally within the Row
        ) {
            // Rotated "PROPERTY OF PMR" Text
            Text(
                text = "PROPERTY OF PMR",
                modifier = Modifier
                    .graphicsLayer {
//                        rotationZ = -90f // Rotate text 90 degrees counter-clockwise
                    }
                    .padding(0.dp) // Space between text and QR code
                    .width(10.dp)
            )

            // Column containing Data Text and QR Code
            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center
            ) {
                Text(
                    text = data,
                    modifier = Modifier.align(Alignment.CenterHorizontally)
                )
//                Spacer(modifier = Modifier.height(8.dp)) // Spacer for spacing
                GenerateQRCode(
                    data = data
                )
//                Spacer(modifier = Modifier.height(8.dp)) // Spacer for spacing
                Text(
                    text = "ECR T12 - 1000x1200MM",
                    modifier = Modifier.align(Alignment.CenterHorizontally)
                )
            }
        }

        Spacer(modifier = Modifier.weight(1f)) // Pushes the bottom content to the bottom

        // Bottom Row with Checkbox and Generate Button
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = 16.dp), // Spacer at the bottom
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically // Vertically center the contents
        ) {
            Row(
                verticalAlignment = Alignment.CenterVertically // Center the Checkbox and Text vertically
            ) {
                var checked by remember { mutableStateOf(false) }
                Checkbox(
                    checked = checked,
                    onCheckedChange = { checked = it }
                )
                Spacer(modifier = Modifier.width(8.dp)) // Spacer between Checkbox and Text
                Text(text = "Auto Generate")
            }

            CustomButton.Generate(
                onClick = { /* Handle Generate Click */ }
            )
        }

        // Print Button centered horizontally
        CustomButton.Print(
            onClick = { /* Handle Print Click */ },
//            modifier = Modifier.align(Alignment.CenterHorizontally) // Center the Print button
        )
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun PreviewGenerateQR() {
    GenerateQR("SN XWB907335")
}
