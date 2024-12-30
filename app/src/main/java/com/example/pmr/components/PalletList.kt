
// /components/PalletList.kt
package com.example.pmr.components

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.pmr.data.Pallet


@Composable
fun PalletList(
    pallets: List<Pallet> , // Default to the 10 mock entries
    onItemClick: (Pallet) -> Unit,
) {
    LazyColumn(
        modifier = Modifier.fillMaxSize(),
        contentPadding = PaddingValues(
            top = 8.dp,
            bottom =90.dp
        )
    ) {
        items(pallets) { pallet ->
            PalletItem(
                pallet = pallet,
                onItemClick = onItemClick// link to TransactionDetailView will the pallet data
            )
        }
    }
}

@Composable
fun PalletListScreen(
    pallets: List<Pallet>,
    onItemClick: (Pallet) -> Unit,
    onPalletClick: (Pallet) -> Unit = {}
) {
    Column(
        modifier = Modifier.fillMaxSize()
    ) {
        // For example, you could add a header or search field here
//        PalletList(onItemClick = onItemClick, onPalletClick = onPalletClick)
        PalletList(
            pallets = pallets,
            onItemClick = onItemClick
        )
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewPalletList() {
    MaterialTheme {
        PalletListScreen(
            pallets = listOf(
                Pallet(
                    source = "PMR Pallet Ltd. Co.",
                    customer = "Alaska Milk Corporation",
                    code = "DR-AMC-LAG-001",
                    deliveryReceipt = "#20691"
                )
            ),
            onItemClick = {
                // do nothing or handle item click
            }
        )
    }
}