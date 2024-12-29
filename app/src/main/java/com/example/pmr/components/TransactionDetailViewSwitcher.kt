package com.example.pmr.components

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp

/**
 * A simple tab-like row to switch between "Customer Information" and "Items".
 *
 * @param selectedTab An Int that denotes the currently selected tab (0 or 1).
 * @param onTabSelect Lambda triggered when a tab is selected, passing in the new tab index.
 */
@Composable
fun TransactionDetailViewSwitcher(
    selectedTab: Int = 0,
    onTabSelect: (Int) -> Unit = {}
) {
    // Define a RoundedCornerShape with 6.dp corner radius
    val switcherShape = RoundedCornerShape(6.dp)

    // Use a Row to hold both tabs side by side
    Row(
        modifier = Modifier
            .width(243.dp) // Total width of the row
            .height(37.dp) // Height of the row
            .clip(switcherShape) // Rounded corners for the whole switcher
            .background(Color(0xFFF0F2F5)), // Background color
        horizontalArrangement = Arrangement.Center,
        verticalAlignment = Alignment.CenterVertically
    ) {
        // First tab: Customer Information (width = 173.dp)
        TabItem(
            title = "Customer Information",
            isSelected = (selectedTab == 0),
            onClick = { onTabSelect(0) },
            textStyle = MaterialTheme.typography.titleMedium,
            width = 173.dp // Custom width for this tab
        )

        // Second tab: Items (width = 62.dp)
        TabItem(
            title = "Items",
            isSelected = (selectedTab == 1),
            onClick = { onTabSelect(1) },
            textStyle = MaterialTheme.typography.titleMedium,
            width = 62.dp // Custom width for this tab
        )
    }
}

/**
 * A reusable composable for a single tab item. It highlights itself when selected
 * and triggers [onClick] when tapped.
 *
 * @param width Custom width for the tab item.
 */
@Composable
private fun TabItem(
    title: String,
    isSelected: Boolean,
    onClick: () -> Unit,
    textStyle: TextStyle,
    width: Dp = 0.dp // Accepts a width parameter
) {
    val selectedColor = Color.Black
    val selectedBackgroundColor = Color.White
    val unselectedColor = Color.Gray

    Box(
        modifier = Modifier
            .width(width) // Apply the custom width
            .height(29.dp) // Match the height of the row
            .clip(RoundedCornerShape(6.dp)) // Rounded corners for the tab
            .background(if (isSelected) selectedBackgroundColor else Color.Transparent) // Background based on selection
            .clickable { onClick() }, // Make it clickable
        contentAlignment = Alignment.Center
    ) {
        Text(
            text = title,
            style = textStyle.copy(color = if (isSelected) selectedColor else unselectedColor)
        )
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun PreviewTransactionDetailViewSwitcher() {
    // Use a state in the preview to see the toggling effect
    var selectedTab by remember { mutableStateOf(0) }

    TransactionDetailViewSwitcher(
        selectedTab = selectedTab,
        onTabSelect = { newTab ->
            selectedTab = newTab
        }
    )
}
