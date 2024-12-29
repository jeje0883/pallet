package com.example.pmr.components

import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun ItemInformation() {
    Box(
        modifier = Modifier
            .height(280.dp)
            .fillMaxWidth()
            .border(
                width = 1.dp,
                color = Color(0xFFDBE0E5), // Corrected color specification with alpha
                shape = RoundedCornerShape(6.dp) // Ensure the border shape matches the background
            ),
        contentAlignment = Alignment.Center
    ) {
        Column(
            modifier = Modifier
                .padding(16.dp)
                .width(310.dp)// Added padding for better spacing
        ) {
            Row(
                modifier = Modifier
                    .fillMaxWidth(),
//                    .height(40.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    text = "ERC T12 Rental",
                    fontSize = 18.sp, // Set font size to 18sp
                    fontWeight = FontWeight.SemiBold, // SemiBold font weight
                    modifier = Modifier.weight(1f) // Occupy available space
                )
                CustomButton.ScanQR (
                    onClick = { /* Handle Scan QR Click */ }
                )
            }

            Spacer(modifier = Modifier.height(16.dp))

            Row(
                modifier = Modifier.fillMaxWidth()
            ) {
                Column(
                    modifier = Modifier.weight(1f)
                ) {
                    Row(
                        modifier = Modifier.fillMaxWidth(),
//                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Text(
                            text = "Quantity:",
                            modifier = Modifier.weight(6f), // Align to start
                            fontSize = 14.sp
                        )
                        Text(
                            text = "24,000",
                            modifier = Modifier
                                .weight(1.2f),
//                                .padding(start = 16.dp), // Indent to the right
                            fontSize = 14.sp
                        )
                        Text(
                            text = "PC/S",
                            modifier = Modifier
                                .weight(1f),
//                                .padding(start = 70.dp), // Indent to the right
                            fontSize = 14.sp
                        )
                    }

                    Spacer(modifier = Modifier.height(8.dp))

                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Text(
                            text = "Scanned Pallets:",
                            modifier = Modifier.weight(6f), // Align to start
                            fontSize = 14.sp
                        )
                        Text(
                            text = "0",
                            modifier = Modifier.weight(1.2f), // Align center automatically
                            fontSize = 14.sp
                        )
                        Text(
                            text = "PC/S",
                            modifier = Modifier
                                .weight(1f),
//                                .padding(start = 70.dp), // Indent to the right
                            fontSize = 14.sp
                        )
                    }
                }
            }

            Spacer(modifier = Modifier.height(16.dp))

            CustomButton.ScanHistory (
                onClick = { /* Handle Scan History Click */ }
            )

//            Spacer(modifier = Modifier.height(4.dp))

            CustomButton.Upload(
                onClick = { /* Handle Upload Click */ }
            )
        }
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun PreviewItemInformation() {
    ItemInformation()
}
