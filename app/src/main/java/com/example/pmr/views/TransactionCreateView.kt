package com.example.pmr.views

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.pmr.components.Header
import com.example.pmr.components.InputType

@Composable
fun CreateScreen(
    modifier: Modifier = Modifier
) {
    val scrollState = rememberScrollState()

    Column(
        modifier = modifier
            .verticalScroll(scrollState)
    ) {
        var selectedOption by remember { mutableStateOf("") }

        InputType.Selection(
            value = selectedOption,
            onValueChange = { selectedOption = it },
            options = listOf("Option 1", "Option 2", "Option 3"),
            title = "Customer",
//            selectedOption = selectedItem
        )

        Spacer(modifier = Modifier.height(10.dp))
        InputType.Text(
            onValueChange = { selectedOption = it },
            title = "Delivery Receipt"
        )

        Spacer(modifier = Modifier.height(10.dp))
        InputType.Date(
            onValueChange = { selectedOption = it },
            title = "Delivery Date"
        )

        Spacer(modifier = Modifier.height(10.dp))
        InputType.Date(
            onValueChange = { selectedOption = it },
            title = "Heat Treatment Date"
        )

        Spacer(modifier = Modifier.height(10.dp))
        InputType.Date(
            onValueChange = { selectedOption = it },
            title = "Chemical Treatment Date"
        )

        Spacer(modifier = Modifier.height(10.dp))
        InputType.Text(
            onValueChange = { selectedOption = it },
            title = "Driver Name"
        )

        Spacer(modifier = Modifier.height(10.dp))
        InputType.Text(
            onValueChange = { selectedOption = it },
            title = "Trucker Name"
        )

        Spacer(modifier = Modifier.height(10.dp))
        InputType.Text(
            onValueChange = { selectedOption = it },
            title = "Plate Number"
        )

        Spacer(modifier = Modifier.height(10.dp))
        InputType.Text(
            onValueChange = { selectedOption = it },
            title = "Supporting Documents"
        )
    }
}

@Composable
fun TransactionCreateView() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        Header.Create(title = "Create Delivery - Rental")
        CreateScreen()
    }
}

@Preview(showSystemUi = true, showBackground = true)
@Composable
fun PreviewTransactionCreateView() {
    TransactionCreateView()
}
