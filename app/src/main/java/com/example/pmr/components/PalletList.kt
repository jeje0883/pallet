// /app/src/main/java/com/example/pmr/components/PalletList.kt
package com.example.pmr.components

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.pmr.data.MockPalletData
import com.example.pmr.data.Pallet

@Composable
fun PalletList(
    pallets: List<Pallet> = MockPalletData.palletList, // Default to the 10 mock entries
    onItemClick: (Pallet) -> Unit = {},
    onPalletClick: (Pallet) -> Unit
) {
    LazyColumn(
        modifier = Modifier.fillMaxSize(),
        contentPadding = PaddingValues(vertical = 8.dp)
    ) {
        items(pallets) { pallet ->
            PalletItem(
                pallet = pallet,
                onItemClick = { onItemClick(pallet) }
            )
        }
    }
}

@Composable
fun PalletListScreen(
    onItemClick: (Pallet) -> Unit = {},
    onPalletClick: (Pallet) -> Unit = {}
) {
    Column(
        modifier = Modifier.fillMaxSize()
    ) {
        // For example, you could add a header or search field here
        PalletList(onItemClick = onItemClick, onPalletClick = onPalletClick)
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewPalletList() {
    MaterialTheme {
        PalletListScreen()
    }
}
