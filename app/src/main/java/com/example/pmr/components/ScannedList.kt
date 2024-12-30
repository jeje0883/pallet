package com.example.pmr.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.pmr.data.MockScannedData
import com.example.pmr.data.ScannedEntry

@Composable
fun ScannedList(
    scannedEntries: List<ScannedEntry> = MockScannedData.scannedList, // Default to the mock entries
    onItemClick: ((ScannedEntry) -> Unit)? = null, // Default to null
    onActionClick: ((ScannedEntry) -> Unit)? = null // Default to null
) {
    LazyColumn(
        modifier = Modifier.fillMaxSize(),
//        contentPadding = PaddingValues(vertical = 8.dp)
    ) {
        items(scannedEntries) { scannedEntry ->
            ScannedItem(
                identifier = scannedEntry.identifier,
                timestamp = scannedEntry.timestamp,
                onItemClick = { onItemClick?.invoke(scannedEntry) }, // Invoke only if not null
                onActionClick = { onActionClick?.invoke(scannedEntry) }, // Invoke only if not null
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 8.dp)
            )
        }
    }
}

@Composable
fun ScannedListScreen(
    onItemClick: (ScannedEntry) -> Unit = {}, // Default to no-op
    onActionClick: (ScannedEntry) -> Unit = {} // Default to no-op
) {
    Column(
        modifier = Modifier.fillMaxSize()
    ) {
        // Optional: Add a header, search bar, or other UI elements here
        ScannedList(
            onItemClick = onItemClick,
            onActionClick = onActionClick
        )
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun PreviewScannedList() {
    MaterialTheme {
        ScannedListScreen()
    }
}
