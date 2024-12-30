// /navigation/NavRoutes.kt
package com.example.pmr.navigation

sealed class NavRoutes(val route: String) {
    object Home : NavRoutes("home")
    object TransactionMenu : NavRoutes("transaction_menu")
    object More : NavRoutes("more")
    object GenerateQR : NavRoutes("generate_qr")

    //Delivery Route
    object Rentals : NavRoutes("rentals")
    object TransactionDetailView : NavRoutes("transaction_detail/{palletCode}")
    object TransactionCreateView : NavRoutes( "rentals/create")
    object ScanQRView : NavRoutes ( "rentals/scan")
}
