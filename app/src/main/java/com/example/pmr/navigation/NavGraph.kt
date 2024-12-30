// /navigation/AppNavGraph.kt
package com.example.pmr.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.pmr.views.TransanctionView
import com.example.pmr.views.QRTransactionMenu
import com.example.pmr.views.MoreMenu
import com.example.pmr.views.Home

@Composable
fun AppNavGraph(navController: NavHostController) {
    NavHost(navController = navController, startDestination = NavRoutes.Home.route) {
        composable(NavRoutes.Home.route) {
            // If your Home() doesn't need navController, you can omit it here
            Home()
        }
        composable(NavRoutes.QR.route) {
            // Pass the navController to QRTransactionMenu
            QRTransactionMenu(navController = navController)
        }
        composable(NavRoutes.More.route) {
            MoreMenu()
        }
        composable(NavRoutes.DeliveryRental.route) {
            // Here is the fix: pass navController to TransanctionView
            TransanctionView(navController = navController)
        }
//        composable("transaction_detail/{palletCode}") { backStackEntry ->
//            val palletCode = backStackEntry.arguments?.getString("palletCode") ?: ""
//            TransactionDetailView(palletCode)
//        }
    }
}
