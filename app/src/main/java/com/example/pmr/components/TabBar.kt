// /components/TabBar.kt
package com.example.pmr.components

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.example.pmr.R
import com.example.pmr.navigation.NavRoutes

@Composable
fun BottomNavigationBar(
    navController: NavHostController,
    items: List<NavRoutes>,
    currentRoute: String?
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .background(Color.White)
            .padding(vertical = 8.dp),
        horizontalArrangement = Arrangement.SpaceAround,
        verticalAlignment = Alignment.CenterVertically
    ) {
        items.forEach { item ->
            val isSelected = item.route == currentRoute
            NavigationItem(
                iconRes = when (item) {
                    NavRoutes.Home -> R.drawable.home_icon
                    NavRoutes.QR -> R.drawable.qr_icon
                    NavRoutes.More -> R.drawable.more_icon
                    else -> R.drawable.more_icon // fallback if needed
                },
                label = when (item) {
                    NavRoutes.Home -> "Home"
                    NavRoutes.QR -> "QR"
                    NavRoutes.More -> "More"
                    else -> "Unknown"
                },
                isHighlighted = isSelected,
                onClick = {
                    // Navigate only if it's not already selected
                    if (!isSelected) {
                        navController.navigate(item.route) {
                            // Avoid building up a large back stack
                            popUpTo(navController.graph.startDestinationId) {
                                saveState = true
                            }
                            // Avoid multiple copies of the same destination
                            launchSingleTop = true
                            // Restore state when reselecting a previously selected item
                            restoreState = true
                        }
                    }
                }
            )
        }
    }
}

@Composable
fun NavigationItem(
    iconRes: Int,
    label: String,
    isHighlighted: Boolean,
    onClick: () -> Unit
) {
    Column(
        modifier = Modifier
            .size(72.dp)
            .clickable { onClick() },
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        // The icon area with highlight effect
        Box(
            modifier = Modifier
                .size(if (isHighlighted) 52.dp else 24.dp)
                .offset(y = if (isHighlighted) 6.dp else 0.dp),
            contentAlignment = Alignment.Center
        ) {
            // Background Circle
            Box(
                modifier = Modifier
                    .size(40.dp)
                    .background(
                        color = if (isHighlighted) Color(0xFF268AF5) else Color.Transparent,
                        shape = CircleShape
                    )
            )
            // Highlight Overlay
            Box(
                modifier = Modifier
                    .size(if (isHighlighted) 52.dp else 24.dp)
                    .background(
                        color = if (isHighlighted) Color(0xFF268AF5).copy(alpha = 0.3f) else Color.Transparent,
                        shape = CircleShape
                    )
            )
            // Icon
            Icon(
                painter = painterResource(id = iconRes),
                contentDescription = label,
                tint = if (isHighlighted) Color.White else Color(0xFF268AF5),
                modifier = Modifier.size(if (isHighlighted) 28.dp else 24.dp)
            )
        }

        Spacer(modifier = Modifier.height(4.dp))

        // Show label only if it's not highlighted
        Text(
            text = if (isHighlighted) "" else label,
            fontSize = 12.sp,
            fontWeight = FontWeight.Medium,
            color = if (isHighlighted) Color(0xFF268AF5) else Color.Gray,
            textAlign = TextAlign.Center
        )
    }
}
