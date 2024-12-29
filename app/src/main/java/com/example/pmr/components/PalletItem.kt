// components/PalletItem.kt
package com.example.pmr.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.pmr.data.Pallet
import com.example.pmr.R

@OptIn(ExperimentalMaterial3Api::class) // Opt-in to ExperimentalMaterial3Api if required
@Composable
fun PalletItem(
    pallet: Pallet,
    onItemClick: (Pallet) -> Unit = {}
) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 8.dp)
            .clickable { onItemClick(pallet) },
        shape = RoundedCornerShape(6.dp), // Changed border radius to 6.dp
        colors = CardDefaults.cardColors(containerColor = Color(0xFFF0F2F5)), // Changed background color to #717274
        elevation = CardDefaults.cardElevation(defaultElevation = 4.dp)
    ) {
        Column(
            modifier = Modifier
                .padding(16.dp),
            verticalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            // Pallet Details Row: Pallet Code (Left) & Transaction Code (Right)
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    text = pallet.code,
                    fontSize = 14.sp,
                    fontWeight = FontWeight.Medium,
                    color = Color(0xFF717274) // Changed to white for contrast
                )

                Text(
                    text = pallet.deliveryReceipt,
                    fontSize = 14.sp,
                    fontWeight = FontWeight.Medium,
                    color = Color(0xFF268AF5) // Corrected to Color with proper hex code
                )
            }

            // Source Row: Icon & Source Text
            Row(
                verticalAlignment = Alignment.CenterVertically
            ) {
                Icon(
                    painter = painterResource(id = R.drawable.source_icon), // Replace with actual drawable
                    contentDescription = "Source Icon",
                    tint = Color(0xFF268AF5), // Changed tint to #268AF5
                    modifier = Modifier.size(20.dp)
                )
                Spacer(modifier = Modifier.width(8.dp))
                Text(
                    text = pallet.source,
                    fontSize = 14.sp,
                    fontWeight = FontWeight.Medium,
                    color = Color.Black// Changed to white for contrast
                )
            }

            // Destination Row: Icon & Destination Text
            Row(
                verticalAlignment = Alignment.CenterVertically
            ) {
                Icon(
                    painter = painterResource(id = R.drawable.destination_icon), // Replace with actual drawable
                    contentDescription = "Destination Icon",
                    tint = Color(0xFF268AF5), // Changed tint to #268AF5
                    modifier = Modifier.size(20.dp)
                )
                Spacer(modifier = Modifier.width(8.dp))
                Text(
                    text = pallet.customer,
                    fontSize = 14.sp,
                    fontWeight = FontWeight.Medium,
                    color = Color.Black // Changed to white for contrast
                )
            }


        }
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewPalletItem() {
    MaterialTheme {
        PalletItem(
            pallet = com.example.pmr.data.Pallet(
                source = "PMR Pallet Ltd. Co.",
                customer = "Alaska Milk Corporation",
                code = "DR-AMC-LAG-001",
                deliveryReceipt = "#20691",
            )
        )
    }
}
