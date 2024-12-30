// File: ScanQRView.kt
package com.example.pmr.views

import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.pmr.components.CornerBorderBox
import com.example.pmr.components.Header

@Composable
fun ScanQRView() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.Top,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Header.Scan(title = "Scan")
        Spacer(modifier = Modifier.padding(14.dp))
        Text(
            text = "Place the QR code within the frame"
        )
        Spacer(modifier = Modifier.padding(4.dp))
        Text(
            text = "Hold your device steady and make sure it's well-lit"
        )

        Spacer(modifier = Modifier.padding(20.dp))
        CornerBorderBox(
            modifier = Modifier.size(300.dp),
            cornerLength = 40.dp,       // how long each corner line should be
//            cornerRadius = 6.dp,       // “roundness” of the line ends
            borderWidth = 2.dp,         // thickness of the lines
            borderColor = Color.Black
        ) {
            // Your inner content goes here (if any)
            // ...
        }
    }
}



@Preview(showBackground = true, showSystemUi = true)
@Composable
fun PreviewScanQRView() {
    ScanQRView()
}
