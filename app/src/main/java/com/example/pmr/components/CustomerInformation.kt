package com.example.pmr.components

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun CustomerInformation() {
    val scrollState = rememberScrollState() // Create a scroll state
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
            .verticalScroll(scrollState) // Enable vertical scrolling
    ) {

        InputType.Text(
            title = "Code",
            value = "DR-AMC-LAG-001",
            onValueChange = { },
        )
        Spacer(modifier = Modifier.padding(10.dp))
        InputType.Text(
            title = "Customer",
            value = "Alaska Milk Corporation",
            onValueChange = { },
        )
        Spacer(modifier = Modifier.padding(10.dp))
        InputType.Text(
            title = "Delivery Receipt",
            value = "20691",
            onValueChange = { },
        )
        Spacer(modifier = Modifier.padding(10.dp))
        InputType.Date(
            title = "Delivery Date",
            value = "12/01/2024",
            onValueChange = { },
        )
        Spacer(modifier = Modifier.padding(10.dp))
        InputType.Date(
            title = "Heat Treatment Date",
            value = "12/01/2024",
            onValueChange = { },
        )
        Spacer(modifier = Modifier.padding(10.dp))
        InputType.Date(
            title = "Chemical Treatment Date",
            value = "12/01/2024",
            onValueChange = { },
        )
        Spacer(modifier = Modifier.padding(10.dp))
        InputType.Text(
            title = "Driver name",
            value = "Juan Dela Cruz",
            onValueChange = { },
        )
        Spacer(modifier = Modifier.padding(10.dp))
        InputType.Text(
            title = "Trucker Name",
            value = "Juan Move",
            onValueChange = { },
        )
        Spacer(modifier = Modifier.padding(10.dp))
        InputType.Text(
            title = "Plate Number",
            value = "ATX5050",
            onValueChange = { },
        )
        Spacer(modifier = Modifier.padding(10.dp))
        InputType.Text(
            title = "Supporting Document",
            value = "Attached",
            onValueChange = { },
        )
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun PreviewCustomerInformation() {
    CustomerInformation()
}
