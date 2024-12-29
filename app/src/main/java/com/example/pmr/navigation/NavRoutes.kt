// /navigation/NavRoutes.kt
package com.example.pmr.navigation

sealed class NavRoutes(val route: String) {
    object Home : NavRoutes("home")
    object QR : NavRoutes("qr")
    object More : NavRoutes("more")
    object DeliveryRental : NavRoutes("delivery_rental")
    object Transaction
}
