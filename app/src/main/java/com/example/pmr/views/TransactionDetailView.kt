// TransactionDetailView.kt

package com.example.pmr.views

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.pmr.components.CustomerInformation
import com.example.pmr.components.Header
import com.example.pmr.components.ItemInformation
import com.example.pmr.components.TransactionDetailViewSwitcher
import com.example.pmr.data.Pallet
import com.example.pmr.navigation.NavRoutes
import androidx.navigation.NavHostController



@Composable
fun TransactionDetailView(
    navController: NavHostController? = null,
    pallet: Pallet
) {
    var selectedTab by remember { mutableStateOf(0) }

    // Main content
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(horizontal = 16.dp, vertical = 8.dp),
        verticalArrangement = Arrangement.Top,
        horizontalAlignment = Alignment.Start
    ) {
        // Section: Header
        Header.Edit(
            title = pallet.code,
            onLeftClick = {
                navController?.navigate(NavRoutes.Rentals.route) {
                    // Optionally pop up to avoid building up a large stack:
                    popUpTo(NavRoutes.Rentals.route) { inclusive = true }
                }
            }

        )
        Spacer(modifier = Modifier.height(10.dp))

        // Section: Tab Switcher
        TransactionDetailViewSwitcher(
            selectedTab = selectedTab,
            onTabSelect = { newTab ->
                selectedTab = newTab
            }
        )
        Spacer(modifier = Modifier.height(10.dp))

        // Section: Conditional Content Based on Selected Tab
        when (selectedTab) {
            0 -> CustomerInformation(pallet)
            1 -> ItemInformation(pallet, navController = navController)
            else -> {}
        }
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun PreviewTransactionDetailView() {

    TransactionDetailView(
        pallet = Pallet(
            source = "PMR Pallet Ltd. Co.",
            customer = "Alaska Milk Corporation",
            code = "DR-AMC-LAG-001",
            deliveryReceipt = "#20691"
        )
    )
}
