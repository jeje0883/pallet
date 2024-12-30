// /views/QRTransactionMenu.kt
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
import androidx.navigation.NavHostController
import com.example.pmr.R
import androidx.compose.ui.unit.sp
import com.example.pmr.navigation.NavRoutes

enum class QRTransactionType(
    val iconRes: Int?, // Icon resource ID (nullable)
    val title: String,
    val description: String,
    val onClick: (NavHostController) -> Unit // Accepts navController
) {
    DeliveryRental(
        iconRes = R.drawable.delivery_icon,
        title = "Delivery Rental",
        description = "Manage rental deliveries to customers",
        onClick = { navController ->
            // Navigate to DeliveryRental route
            navController.navigate(NavRoutes.Rentals.route)
        }
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
        onClick = { println("Pallet Replacement clicked!") }
    ),
    PalletTransfer(
        iconRes = R.drawable.transfer_icon,
        title = "Pallet Transfer",
        description = "Manage pallet transfers between customers",
        onClick = { println("Pallet Transfer clicked!") }
    ),
    ReceivePallet(
        iconRes = R.drawable.receive_icon,
        title = "Receive Pallet",
        description = "Manage receive pallets",
        onClick = { println("Receive Pallet clicked!") }
    ),
}

// A single item in the transaction menu
@Composable
fun QRTransactionMenuItem(
    transactionType: QRTransactionType,
    navController: NavHostController
) {
    Row(
        modifier = Modifier
            .height(72.dp)
            .fillMaxWidth()
            .padding(16.dp)
            .clickable {
                // Pass navController to onClick
                transactionType.onClick(navController)
            },
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
            if (transactionType.description.isNotEmpty()) {
                Text(
                    text = transactionType.description,
                    style = androidx.compose.material3.MaterialTheme.typography.bodyMedium
                )
            }
        }
    }
}

// The main screen for QR transactions
@Composable
fun QRTransactionMenu(navController: NavHostController) {
    Column(
        modifier = Modifier.fillMaxWidth(),
        verticalArrangement = Arrangement.spacedBy(0.dp)
    ) {
        Box(
            modifier = Modifier.height(56.dp),
            contentAlignment = Alignment.Center
        ) {
            Text(
                text = "QR Transactions",
                fontSize = 18.sp,
                fontWeight = FontWeight.SemiBold,
                modifier = Modifier.padding(16.dp)
            )
        }

        // Render each item
        QRTransactionType.values().forEach { type ->
            QRTransactionMenuItem(transactionType = type, navController = navController)
        }
    }
}

@Preview(showSystemUi = true, showBackground = true)
@Composable

//show only with nav
//fun PreviewQRTransactionMenu() {
//    // Using a placeholder since we don't have NavController in preview
//    QRTransactionMenuItem(
//        transactionType = QRTransactionType.DeliveryRental,
//        navController = androidx.navigation.compose.rememberNavController()
//    )
//}

//show all with mock nav
fun PreviewQRTransactionMenu() {
    // Mock NavController for preview purposes
    val mockNavController = androidx.navigation.compose.rememberNavController()

    // Render the entire QRTransactionMenu
    QRTransactionMenu(navController = mockNavController)
}