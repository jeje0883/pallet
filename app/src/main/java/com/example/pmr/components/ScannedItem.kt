// /components/ScannedItem.kt
package com.example.pmr.components

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.pmr.R


@Composable
fun ScannedItem(
    identifier: String,
    timestamp: String,
    onItemClick: () -> Unit = {}, // Optional item click callback
    onActionClick: () -> Unit = {},
    modifier: Modifier = Modifier
) {
    Row(
        modifier = modifier
            .fillMaxWidth()
//            .clickable(onClick = onItemClick) // Make the entire row clickable
            .border(
                BorderStroke(1.dp, Color.LightGray),
                shape = RoundedCornerShape(8.dp)
            )
            .padding(16.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        // Scan Icon with Background Box
        Box(
            modifier = Modifier
                .size(36.dp) // Size of the background box
                .background(
                    color = Color(0xFFF0F2F5), // Defined in theme
                    shape = RoundedCornerShape(8.dp) // Rounded corners
                ),
            contentAlignment = Alignment.Center
        ) {
            Icon(
                painter = painterResource(id = R.drawable.scan_icon),
                contentDescription = "Scan Icon",
                modifier = Modifier
                    .size(24.dp) // Size of the scan icon
            )
        }

        Spacer(modifier = Modifier.width(16.dp)) // Space between icon and texts

        // Texts
        Column(
            modifier = Modifier
                .weight(1f) // Takes up remaining space
        ) {
            Text(
                text = identifier,
                style = MaterialTheme.typography.bodyLarge.copy(
                    fontWeight = FontWeight.Bold
                ),
                color = MaterialTheme.colorScheme.onBackground
            )
            Spacer(modifier = Modifier.height(4.dp))
            Text(
                text = timestamp,
                style = MaterialTheme.typography.bodySmall,
                color = MaterialTheme.colorScheme.onBackground.copy(alpha = 0.7f)
            )
        }

        Spacer(modifier = Modifier.width(16.dp)) // Space between texts and action icon

        // Action Icon Button with Background Box
        //replace onAction with actual
        IconButton(onClick = { } ) {
            Box(
                modifier = Modifier
                    .size(24.dp) // Size of the background box
                    .background(
                        color = Color(0xFFF0F2F5), // Defined in theme
                        shape = RoundedCornerShape(4.dp) // Rounded corners
                    ),
                contentAlignment = Alignment.Center
            ) {
                Icon(
                    painter = painterResource(id = R.drawable.up_icon),
                    contentDescription = "Approve Scan", // More descriptive
                    modifier = Modifier
                        .size(16.dp) // Size of the action icon
                )
            }
        }
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun PreviewScannedItem () {
    ScannedItem(
        identifier = "XWB241097",
        timestamp = "Dec 09, 2024 12:53:07 PM",
    )
}