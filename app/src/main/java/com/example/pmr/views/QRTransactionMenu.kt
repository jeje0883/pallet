//views/QRTransactionMenu.kt

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
import androidx.compose.ui.unit.sp
import com.example.pmr.R

enum class QRTransactionType(
    val iconRes: Int?, // Icon resource ID (nullable)
    val title: String,
    val description: String,
    val onClick: () -> Unit // Action to be executed on click
) {
    DeliveryRental(
        iconRes = R.drawable.delivery_icon,
        title = "Delivery Rental",
        description = "Manage rental deliveries to customers",
        onClick = { println("Delivery Rental clicked!") }
    ),
    CustomerReturn(
        iconRes = R.drawable.return_icon,
        title = "Customer Return",
        description = "Manage customer returns",
        onClick = { println("Return Rental clicked!") }
    ),
    PalletReplacement(
        iconRes = R.drawable.replacement_icon,
        title = "Pallet Replacement",
        description = "Manage pallet replacements for customers",
        onClick = { println("Transaction History clicked!") }
    ),
    PalletTransfer(
        iconRes = R.drawable.transfer_icon,
        title = "Pallet Transfer",
        description = "Manage pallet transfers between customers",
        onClick = { println("Transaction History clicked!") }
    ),
    ReceivePallet(
        iconRes = R.drawable.receive_icon,
        title = "Receive Pallet",
        description = "Manage receive pallets",
        onClick = { println("Transaction History clicked!") }
    ),
}

@Composable
fun QRTransactionMenuItem(
    transactionType: QRTransactionType
) {
    Row(
        modifier = Modifier
            .height(72.dp)
            .fillMaxWidth()
            .padding(16.dp)
            .clickable { transactionType.onClick() },
        verticalAlignment = Alignment.CenterVertically
    ) {
        if (transactionType.iconRes != null) {
            Box(
                modifier = Modifier
                    .size(48.dp)
                    .background(
                        color = Color(0xFFF0F2F5),
                        shape = RoundedCornerShape(6.dp)
                    ),
                contentAlignment = Alignment.Center
            ) {
                Icon(
                    painter = painterResource(id = transactionType.iconRes),
                    contentDescription = "${transactionType.title} Icon",
                    modifier = Modifier.size(24.dp)
                )
            }
        } else {
            Spacer(modifier = Modifier.size(48.dp))
        }

        Column(
            modifier = Modifier
                .weight(1f)
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
fun PreviewQRTransactionMenu() {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp),
        verticalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        Box(
            modifier = Modifier
                .padding(top = 50.dp)
                .fillMaxWidth(),
            contentAlignment = Alignment.Center
        ) {
            Text(
                text = "QR Transactions",
                fontSize = 18.sp,
                fontWeight = FontWeight.SemiBold
            )
        }

        QRTransactionMenuItem(transactionType = QRTransactionType.DeliveryRental)
        QRTransactionMenuItem(transactionType = QRTransactionType.CustomerReturn)
        QRTransactionMenuItem(transactionType = QRTransactionType.PalletReplacement)
        QRTransactionMenuItem(transactionType = QRTransactionType.PalletTransfer)
        QRTransactionMenuItem(transactionType = QRTransactionType.ReceivePallet)
    }
}
