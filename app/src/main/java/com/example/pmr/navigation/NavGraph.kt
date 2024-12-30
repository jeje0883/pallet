// /navigation/AppNavGraph.kt
package com.example.pmr.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.pmr.data.MockPalletData
import com.example.pmr.views.TransanctionView
import com.example.pmr.views.TransactionDetailView
import com.example.pmr.views.QRTransactionMenu
import com.example.pmr.views.MoreMenu
import com.example.pmr.views.Home
import com.example.pmr.views.GenerateQRView
import com.example.pmr.views.ScanQRView
import com.example.pmr.views.TransactionCreateView

@Composable
fun AppNavGraph(navController: NavHostController) {
    NavHost(navController = navController, startDestination = NavRoutes.Home.route) {
        composable(NavRoutes.Home.route) {
            // If your Home() doesn't need navController, you can omit it here
            Home()
        }
        composable(NavRoutes.TransactionMenu.route) {
            // Pass the navController to QRTransactionMenu
            QRTransactionMenu(navController = navController)
        }
        composable(NavRoutes.More.route) {
            MoreMenu()
        }
        composable(NavRoutes.Rentals.route) {
            // Here is the fix: pass navController to TransanctionView
            TransanctionView(navController = navController)
        }

        composable(NavRoutes.TransactionCreateView.route) {
            TransactionCreateView(navController = navController)
        }

        composable(NavRoutes.ScanQRView.route) {
            ScanQRView(navController = navController)
        }


        composable(NavRoutes.TransactionDetailView.route) { backStackEntry ->
            val palletCode = backStackEntry.arguments?.getString("palletCode") ?: ""
            // Look up the matching pallet from a local list or repository
            val pallet = MockPalletData.palletList.find { it.code == palletCode }

            if (pallet != null) {
                TransactionDetailView(navController = navController, pallet = pallet)
            } else {
                // Show error or fallback UI
            }
        }


    }
}

