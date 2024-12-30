// /components/SearchField.kt
package com.example.pmr.components

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.pmr.R
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.material3.TextField
import androidx.compose.material3.ExperimentalMaterial3Api


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SearchField(
    modifier: Modifier = Modifier,
    onSearch: (String) -> Unit = {},
    onClear: () -> Unit = {}
) {
    var textState by remember { mutableStateOf(TextFieldValue("")) }

    TextField(
        value = textState,
        onValueChange = { newValue ->
            textState = newValue
            onSearch(newValue.text)
        },
        modifier = modifier
            .fillMaxWidth()
            .height(56.dp)
            .clip(RoundedCornerShape(12.dp))
            .background(Color(0xFFF0F2F5)), // Set the background color to #717274
        placeholder = {
            Text(
                text = "Search...",
                style = MaterialTheme.typography.bodyMedium.copy(color = Color.Gray)
            )
        },
        leadingIcon = {
            Icon(
                painter = painterResource(id = R.drawable.search_icon), // Ensure this drawable exists
                contentDescription = "Search Icon",
                tint = Color.Gray,
                modifier = Modifier.size(20.dp)
            )
        },
        trailingIcon = {
            if (textState.text.isNotEmpty()) {
                IconButton(onClick = {
                    textState = TextFieldValue("")
                    onClear()
                }) {
                    Icon(
                        painter = painterResource(id = R.drawable.search_icon), // Use a clear icon
                        contentDescription = "Clear Text",
                        tint = Color.Gray,
                        modifier = Modifier.size(20.dp)
                    )
                }
            }
        },
        singleLine = true,
        // Customize the TextField colors correctly using TextFieldDefaults
//        colors = TextFieldDefaults.textFieldColors(
//            containerColor = Color(0xFFF0F2F5), // Match the background color
//            cursorColor = Color(0xFF268AF5), // Example cursor color
//            focusedIndicatorColor = Color.Transparent,
//            unfocusedIndicatorColor = Color.Transparent,
//            disabledIndicatorColor = Color.Transparent,
//        ),
        textStyle = MaterialTheme.typography.bodyMedium.copy(color = Color.Black) // Text color matches the container
    )
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun PreviewSearchField() {
    MaterialTheme {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp),
            verticalArrangement = Arrangement.Top
        ) {
            SearchField(
                onSearch = { query ->
                    // Handle search action
                    println("Searching for: $query")
                },
                onClear = {
                    // Handle clear action
                    println("Search cleared")
                }
            )
        }
    }
}
