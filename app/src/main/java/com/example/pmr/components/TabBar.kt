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
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.pmr.R

@Composable
fun BottomNavigationBar(
    onItemClicked: (String) -> Unit // Pass the clicked item's label for linking to other views
) {
    // State to track the currently highlighted item
    var highlightedItem by remember { mutableStateOf("QR") } // Default to "QR"

    Row(
        modifier = Modifier
            .fillMaxWidth()
            .background(Color.White) // Background color for the navigation bar
            .padding(vertical = 8.dp),
        horizontalArrangement = Arrangement.SpaceAround,
        verticalAlignment = Alignment.CenterVertically
    ) {
        // Home Button
        NavigationItem(
            iconRes = R.drawable.home_icon, // Replace with your Home icon resource
            label = "Home",
            isHighlighted = highlightedItem == "Home",
            onClick = {
                highlightedItem = "Home"
                onItemClicked("Home") // Notify parent of the click
            }
        )

        // Center Button (QR Code)
        NavigationItem(
            iconRes = R.drawable.qr_icon, // Replace with your QR Code icon resource
            label = "QR",
            isHighlighted = highlightedItem == "QR",
            onClick = {
                highlightedItem = "QR"
                onItemClicked("QR") // Notify parent of the click
            }
        )

        // More Button
        NavigationItem(
            iconRes = R.drawable.more_icon, // Replace with your More icon resource
            label = "More",
            isHighlighted = highlightedItem == "More",
            onClick = {
                highlightedItem = "More"
                onItemClicked("More") // Notify parent of the click
            }
        )
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
            .clickable { onClick() }, // Handle item click
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Box(
            modifier = Modifier
                .size(if (isHighlighted) 56.dp else 24.dp)
                .background(
                    color = if (isHighlighted) Color(0xFF268AF5) else Color.Transparent,
                    shape = CircleShape
                ),
            contentAlignment = Alignment.Center
        ) {
            Icon(
                painter = painterResource(id = iconRes),
                contentDescription = label,
                tint = if (isHighlighted) Color.White else Color(0xFF268AF5),
                modifier = Modifier.size(if (isHighlighted) 28.dp else 24.dp)
            )
        }

        Spacer(modifier = Modifier.height(4.dp))

        Text(
            text = label,
            fontSize = 12.sp,
            fontWeight = FontWeight.Medium,
            color = if (isHighlighted) Color(0xFF268AF5) else Color.Gray,
            textAlign = TextAlign.Center
        )
    }
}

@Composable
fun StickyBottomNavigationBarScreen() {
    Box(
        modifier = Modifier
            .fillMaxSize() // Fill the entire screen
    ) {
        // Add your main content here
        Column(
            modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(text = "Main Content", fontSize = 24.sp, fontWeight = FontWeight.Bold)
        }

        // BottomNavigationBar is sticky at the bottom
        Box(
            modifier = Modifier
                .align(Alignment.BottomCenter) // Stick to the bottom
        ) {
            BottomNavigationBar(
                onItemClicked = { label ->
                    // Placeholder for navigation logic
                    println("$label clicked!")
                }
            )
        }
    }
}

@Composable
@Preview(showSystemUi = true, showBackground = true)
fun PreviewStickyBottomNavigationBarScreen() {
    StickyBottomNavigationBarScreen()
}
