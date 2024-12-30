// /components/CustomerInformation.kt

package com.example.pmr.components

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.pmr.data.Pallet

@Composable
fun CustomerInformation(
    pallet: Pallet
    ) {

    val scrollState = rememberScrollState() // Create a scroll state
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
            .verticalScroll(scrollState) // Enable vertical scrolling
    ) {

        InputType.Text(
            title = "Code",
            value = pallet.code,
            onValueChange = { },
        )
        Spacer(modifier = Modifier.padding(10.dp))
        InputType.Text(
            title = "Customer",
            value = pallet.customer,
            onValueChange = { },
        )
        Spacer(modifier = Modifier.padding(10.dp))
        InputType.Text(
            title = "Delivery Receipt",
            value = pallet.deliveryReceipt,
            onValueChange = { },
        )
        Spacer(modifier = Modifier.padding(10.dp))
        pallet.deliveryDate?.let {
            InputType.Date(
                title = "Delivery Date",
                value = it,
                onValueChange = { },
            )
        }
        Spacer(modifier = Modifier.padding(10.dp))
        pallet.heatTreatmentDate?.let {
            InputType.Date(
                title = "Heat Treatment Date",
                value = it,
                onValueChange = { },
            )
        }
        Spacer(modifier = Modifier.padding(10.dp))
        pallet.chemicalTreatmentDate?.let {
            InputType.Date(
                title = "Chemical Treatment Date",
                value = it,
                onValueChange = { },
            )
        }
        Spacer(modifier = Modifier.padding(10.dp))
        pallet.driver?.let {
            InputType.Text(
                title = "Driver name",
                value = it,
                onValueChange = { },
            )
        }
        Spacer(modifier = Modifier.padding(10.dp))
        pallet.truckPlateNumber?.let {
            InputType.Text(
                title = "Plate Number",
                value = it,
                onValueChange = { },
            )
        }

        Spacer(modifier = Modifier.padding(40.dp))

    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun PreviewCustomerInformation() {
    CustomerInformation(        pallet = Pallet(
        source = "PMR Pallet Ltd. Co.",
        customer = "Alaska Milk Corporation",
        code = "DR-AMC-LAG-001",
        deliveryReceipt = "#20691"
    ))
}
