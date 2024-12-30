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
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import com.example.pmr.components.CornerBorderBox
import com.example.pmr.components.Header
import com.example.pmr.navigation.NavRoutes

@Composable
fun ScanQRView(
    navController: NavHostController? = null
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.Top,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Header.Scan(
            title = "Scan",
            onLeftClick = {
                navController?.navigate(NavRoutes.TransactionDetailView.route) {
                    // Optionally pop up to avoid building up a large stack:
                    popUpTo(NavRoutes.TransactionDetailView.route) { inclusive = true }
                }
            }
        )
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
            borderWidth = 2.dp,         // thickness of the lines
            borderColor = Color.Black
        ) {
//            ScannerView()
        }
    }
}



@Preview(showBackground = true, showSystemUi = true)
@Composable
fun PreviewScanQRView() {
    ScanQRView()
}
