package com.example.pmr.views

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.pmr.R
import androidx.compose.ui.unit.sp

enum class MoreTransactionType(
    val iconRes: Int?, // Icon resource ID (nullable)
    val title: String,
    val description: String,
    val onClick: () -> Unit // Action to be executed on click
) {
    ManageQrCodes(
        iconRes = R.drawable.qr_icon,
        title = "Manage QR Codes",
        description = "Generate QR code for the item",
        onClick = { println("Manage QR Codes clicked!") }
    ),
    TagChecker(
        iconRes = R.drawable.qr_icon,
        title = "Tag Checker",
        description = "Check QR tag history",
        onClick = { println("Tag Checker clicked!") }
    ),
    Logout(
        iconRes = R.drawable.logout_icon,
        title = "Logout",
        description = "",
        onClick = { println("Logout clicked!") }
    )
}

@Composable
fun MoreMenuItem(
    transactionType: MoreTransactionType
) {
    Row(
        modifier = Modifier
            .height(72.dp)
            .fillMaxWidth()
            .padding(16.dp)
            .clickable { transactionType.onClick() }, // Call the enum's onClick action
        verticalAlignment = Alignment.CenterVertically
    ) {
        // Icon Section (only if iconRes is not null)
        if (transactionType.iconRes != null) {
            Box(
                modifier = Modifier
                    .height(80.dp)
                    .width(48.dp)
                    .background(
                        color = Color(0xFFF0F2F5), // Background color F0F2F5
                        shape = RoundedCornerShape(6.dp) // Rounded corners
                    ),
                contentAlignment = Alignment.Center // Center the icon inside the box
            ) {
                Icon(
                    painter = painterResource(id = transactionType.iconRes),
                    contentDescription = "${transactionType.title} Icon", // Accessibility description
                    modifier = Modifier.size(24.dp) // Icon size
                )
            }
        } else {
            Spacer(modifier = Modifier.size(48.dp)) // Placeholder to maintain layout consistency
        }

        // Text Section
        Column(
            modifier = Modifier
                .weight(1f) // Use remaining space
                .padding(start = 16.dp),
            verticalArrangement = Arrangement.spacedBy(-5.dp)
        ) {
            Text(
                text = transactionType.title,
                style = androidx.compose.material3.MaterialTheme.typography.titleMedium

            )
            Text(
                text = transactionType.description,
                style = androidx.compose.material3.MaterialTheme.typography.bodyMedium
            )
        }
    }
}

@Preview(showSystemUi = true, showBackground = true)
@Composable
fun PreviewMoreTransactionMenu() {
    Column(
        modifier = Modifier

            .fillMaxWidth(),

        verticalArrangement = Arrangement.spacedBy(0.dp)

    ) {
        Box(
            modifier = Modifier
                .padding(top = 50.dp)
                .height(56.dp),
//                .padding(top = 30.dp), // Add top margin here
            contentAlignment = Alignment.Center

        ) {
            Text(
                text = "More",
                fontSize = 18.sp,
                fontWeight = FontWeight.SemiBold,
                modifier = Modifier.padding(16.dp)
            )
        }


        MoreMenuItem(transactionType = MoreTransactionType.ManageQrCodes)
        MoreMenuItem(transactionType = MoreTransactionType.TagChecker)
        MoreMenuItem(transactionType = MoreTransactionType.Logout)
    }
}
