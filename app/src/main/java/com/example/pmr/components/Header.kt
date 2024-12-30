package com.example.pmr.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
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

// Define the types of headers with optional left and right icons
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
    ),
    GenerateQR(
        leftIcon = R.drawable.back_icon, // No left icon
        rightIcon = null
    ),
    Scan(
        leftIcon = R.drawable.back_icon, // No left icon
        rightIcon = R.drawable.scan_header_icon
    );

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
//            .padding(horizontal = 16.dp), // Added horizontal padding for better spacing
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
                    .clickable { onLeftClick() }
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

// Object to provide different Header variants
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

    @Composable
    fun GenerateQR(
        title: String,
        onLeftClick: () -> Unit = {},
        onRightClick: () -> Unit = {}
    ) {
        HeaderComposable(
            headerType = HeaderType.GenerateQR,
            title = title,
            onLeftClick = onLeftClick,
            onRightClick = onRightClick
        )
    }

    @Composable
    fun Scan(
        title: String,
        onLeftClick: () -> Unit = {},
        onRightClick: () -> Unit = {}
    ) {
        HeaderComposable(
            headerType = HeaderType.Scan,
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

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun PreviewHeaderEdit() {
    MaterialTheme {
        Header.Edit(
            title = "Edit Item",
            onLeftClick = { /* Handle back action */ },
            onRightClick = { /* Handle edit action */ }
        )
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun PreviewHeaderUpload() {
    MaterialTheme {
        Header.Upload(
            title = "Upload File",
            onLeftClick = { /* Handle back action */ },
            onRightClick = { /* Handle upload action */ }
        )
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun PreviewHeaderCreate() {
    MaterialTheme {
        Header.Create(
            title = "Create New",
            onLeftClick = { /* No left action */ },
            onRightClick = { /* Handle close action */ }
        )
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun PreviewGenerateQR() {
    MaterialTheme {
        Header.GenerateQR(
            title = "Generate QR Code",
            onLeftClick = { /* No left action */ },
            onRightClick = { /* Handle close action */ }
        )
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun PreviewScan() {
    MaterialTheme {
        Header.Scan(
            title = "Scan",
            onLeftClick = { /* No left action */ },
            onRightClick = { /* Handle close action */ }
        )
    }
}

