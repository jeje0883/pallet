// /views/DeliveryRentalView.kt
package com.example.pmr.views

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.example.pmr.components.Header
import com.example.pmr.components.PalletList
import com.example.pmr.components.SearchField
import com.example.pmr.data.Pallet
import com.example.pmr.data.MockPalletData
import com.example.pmr.navigation.NavRoutes

@Composable
fun DeliveryRentalView(
    navController: NavHostController, // Pass NavController so we can navigate
    onAddClick: () -> Unit = {},
    onPalletClick: (Pallet) -> Unit = {}
) {
    // State for the search query
    var searchQuery by remember { mutableStateOf("") }

    // Filtered pallet list based on the search query
    val filteredPallets = if (searchQuery.isEmpty()) {
        MockPalletData.palletList
    } else {
        MockPalletData.palletList.filter {
            it.source.contains(searchQuery, ignoreCase = true) ||
                    it.customer.contains(searchQuery, ignoreCase = true) ||
                    it.code.contains(searchQuery, ignoreCase = true) ||
                    it.deliveryReceipt.contains(searchQuery, ignoreCase = true)
        }
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(horizontal = 16.dp, vertical = 8.dp),
        verticalArrangement = Arrangement.Top,
        horizontalAlignment = Alignment.Start
    ) {
        // Header Section
        Header.Add(
            title = "Delivery - Rental",
            onLeftClick = {
                // Navigate back to QRTransactionMenu (the "qr" route)
                navController.navigate(NavRoutes.QR.route) {
                    // Optionally pop up to avoid building up a large stack:
                    popUpTo(NavRoutes.QR.route) { inclusive = true }
                }
            },
            onRightClick = onAddClick
        )

        Spacer(modifier = Modifier.height(16.dp))

        // Search Field Section
        SearchField(
            onSearch = { query ->
                searchQuery = query
            },
            onClear = {
                searchQuery = ""
            }
        )

        Spacer(modifier = Modifier.height(16.dp))

        // Pallet List Section
        PalletList(
            pallets = filteredPallets,
            onPalletClick = onPalletClick
        )
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun PreviewDeliveryRentalView() {
    // Use a placeholder navController for preview
    val dummyNavController = androidx.navigation.compose.rememberNavController()
    MaterialTheme {
        DeliveryRentalView(navController = dummyNavController)
    }
}
