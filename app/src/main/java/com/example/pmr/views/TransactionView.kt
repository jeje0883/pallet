
// /views/TransactionView.kt
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
import com.example.pmr.components.PalletListScreen
import com.example.pmr.components.SearchField
import com.example.pmr.data.Pallet
import com.example.pmr.data.MockPalletData
import com.example.pmr.navigation.NavRoutes

suspend fun fetchPalletsFromApi(): List<Pallet> {
    // In real usage, make a network request here
    return emptyList() // Placeholder
}

@Composable
fun TransanctionView(
    navController: NavHostController? = null, // Pass NavController so we can navigate
    onAddClick: () -> Unit = {},
    onPalletClick: (Pallet) -> Unit = {}
) {
    // State for the search query
    var allPallets by remember { mutableStateOf<List<Pallet>>(emptyList()) }
    var searchQuery by remember { mutableStateOf("") }

    // Fetch data on first launch
    LaunchedEffect(Unit) {
        val apiData = fetchPalletsFromApi()
        allPallets = if (apiData.isEmpty()) {
            MockPalletData.palletList
        } else {
            apiData
        }
    }

    // Filtered pallet list based on the search query
    val filteredPallets = if (searchQuery.isEmpty()) {
        allPallets
    } else {
        allPallets.filter {
            it.source.contains(searchQuery, ignoreCase = true) ||
                    // fields to include in search
                    it.customer.contains(searchQuery, ignoreCase = true) ||
                    it.code.contains(searchQuery, ignoreCase = true) ||
                    it.deliveryReceipt.contains(searchQuery, ignoreCase = true) ||
                    it.source.contains(searchQuery, ignoreCase = true)
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
                navController?.navigate(NavRoutes.TransactionMenu.route) {
                    // Optionally pop up to avoid building up a large stack:
                    popUpTo(NavRoutes.TransactionMenu.route) { inclusive = true }
                }
            },
            onRightClick = {
                navController?.navigate(NavRoutes.TransactionCreateView.route) {
                    // Optionally pop up to avoid building up a large stack:
                    popUpTo(NavRoutes.TransactionCreateView.route) { inclusive = true }
                }
            }
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
        PalletListScreen(
            pallets = filteredPallets,
            onItemClick = { pallet ->
                // Navigate to detail, passing the pallet’s code
                navController?.navigate("transaction_detail/${pallet.code}")
            }
        )


    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun PreviewDeliveryRentalView() {
    // Use a placeholder navController for preview

    MaterialTheme {
        TransanctionView()
    }
}
