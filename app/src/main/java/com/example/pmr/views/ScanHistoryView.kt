package com.example.pmr.views

import android.inputmethodservice.Keyboard
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.pmr.components.Header
import com.example.pmr.components.HeaderType
import com.example.pmr.components.ScannedListScreen
import com.example.pmr.components.SearchField


@Composable
fun ScanHistoryView() {
    Column (
            modifier = Modifier
                .fillMaxSize()
                .padding(horizontal = 16.dp, vertical = 8.dp),
            verticalArrangement = Arrangement.Top,
            horizontalAlignment = Alignment.Start
        ) {
        Header.Upload(
            title = "ECR T12 Rental",
            onLeftClick = { /* Handle back action */ },
            onRightClick = { /* Handle upload action */ }
         )
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
        Row(
            //font size 16
            //semi bold
            //typography Inter
        ) {
            ScannedListScreen()
        }


    }


}


@Preview(showSystemUi = true, showBackground = true)
@Composable
fun PreviewScanHistoryView () {
    ScanHistoryView()
}