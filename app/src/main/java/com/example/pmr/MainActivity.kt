// /MainActivity.kt
package com.example.pmr

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent

// Required for Jetpack Compose UI elements like Box, Column, etc.
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember

// For alignment and arrangement references
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier

// For composable calls like NavHost, currentBackStackEntryAsState, rememberNavController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import androidx.navigation.compose.composable

// Any other composables you use, e.g. from your codebase
import com.example.pmr.components.BottomNavigationBar
import com.example.pmr.navigation.AppNavGraph
import com.example.pmr.navigation.NavRoutes


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            // This is now a composable scope
            AppScreen()
        }
    }
}

@Composable
fun AppScreen() {
    val navController = rememberNavController()

    // Observe the current route
    val currentBackStackEntry by navController.currentBackStackEntryAsState()
    val currentRoute = currentBackStackEntry?.destination?.route

    // Define which top-level routes you want in the bottom nav
    val navigationItems = listOf(
        NavRoutes.Home,
        NavRoutes.QR,
        NavRoutes.More
    )

    // The overall layout
    Box(modifier = Modifier.fillMaxSize()) {
        // NavHost for your routes
        AppNavGraph(navController = navController)

        // Sticky Bottom Navigation at the bottom
        Box(modifier = Modifier.align(Alignment.BottomCenter)) {
            BottomNavigationBar(
                navController = navController,
                items = navigationItems,
                currentRoute = currentRoute
            )
        }
    }
}