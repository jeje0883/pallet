// /components/Header.kt
package com.example.pmr.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.pmr.R

enum class HeaderType(
    val leftIcon: Int?, // Resource ID for the left icon (nullable)
    val rightIcon: Int? // Resource ID for the right icon (nullable)
) {
    Edit(
        leftIcon = R.drawable.back_icon,
        rightIcon = R.drawable.edit_icon
    ),
    Add(
        leftIcon = R.drawable.back_icon,
        rightIcon = R.drawable.add_icon
    ),
    Upload(
        leftIcon = R.drawable.back_icon,
        rightIcon = R.drawable.upload_header_icon
    ),
    Create(
        leftIcon = null, // No left icon
        rightIcon = R.drawable.close_icon
    )
}

@Composable
fun HeaderComposable(
    headerType: HeaderType,
    title: String,
    onLeftClick: () -> Unit = {},
    onRightClick: () -> Unit = {}
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .height(56.dp),
//            .padding(horizontal = 16.dp),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.Start // Align items to the start
    ) {
        // Left Icon
        if (headerType.leftIcon != null) {
            Icon(
                painter = painterResource(id = headerType.leftIcon),
                contentDescription = "Left Icon",
                modifier = Modifier
                    .size(24.dp)
                    .clickable {
                        // The parent composable decides what happens here.
                        // By default, onLeftClick = {} is empty,
                        // but typically you'd pass navController.popBackStack() or similar.
                        onLeftClick()
                    }
            )
        } else {
            Spacer(modifier = Modifier.size(24.dp)) // Placeholder for alignment
        }

        Spacer(modifier = Modifier.width(16.dp)) // Spacing between icon and title

        // Title with weight to push the right icon to the end
        Text(
            text = title,
            fontSize = 18.sp,
            fontWeight = FontWeight.SemiBold,
            color = MaterialTheme.colorScheme.onBackground,
            modifier = Modifier.weight(1f) // Occupies remaining space
        )

        // Right Icon
        if (headerType.rightIcon != null) {
            Icon(
                painter = painterResource(id = headerType.rightIcon),
                contentDescription = "Right Icon",
                modifier = Modifier
                    .size(24.dp)
                    .clickable { onRightClick() }
            )
        } else {
            Spacer(modifier = Modifier.size(24.dp)) // Placeholder for alignment
        }
    }
}

object Header {
    @Composable
    fun Add(
        title: String,
        onLeftClick: () -> Unit = {},
        onRightClick: () -> Unit = {}
    ) {
        HeaderComposable(
            headerType = HeaderType.Add,
            title = title,
            onLeftClick = onLeftClick,
            onRightClick = onRightClick
        )
    }

    @Composable
    fun Edit(
        title: String,
        onLeftClick: () -> Unit = {},
        onRightClick: () -> Unit = {}
    ) {
        HeaderComposable(
            headerType = HeaderType.Edit,
            title = title,
            onLeftClick = onLeftClick,
            onRightClick = onRightClick
        )
    }

    @Composable
    fun Upload(
        title: String,
        onLeftClick: () -> Unit = {},
        onRightClick: () -> Unit = {}
    ) {
        HeaderComposable(
            headerType = HeaderType.Upload,
            title = title,
            onLeftClick = onLeftClick,
            onRightClick = onRightClick
        )
    }

    @Composable
    fun Create(
        title: String,
        onLeftClick: () -> Unit = {},
        onRightClick: () -> Unit = {}
    ) {
        HeaderComposable(
            headerType = HeaderType.Create,
            title = title,
            onLeftClick = onLeftClick,
            onRightClick = onRightClick
        )
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun PreviewHeaderAdd() {
    MaterialTheme {
        Header.Add(
            title = "Delivery - Rental",
            // Example onLeftClick logic
            onLeftClick = { /* e.g. navController.popBackStack() */ },
            onRightClick = { /* Handle add action */ }
        )
    }
}
