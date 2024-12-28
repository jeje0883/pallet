// /app/src/main/java/com/example/pmr/data/Pallet.kt
package com.example.pmr.data

import androidx.annotation.DrawableRes

data class Pallet(
    val source: String,
    val customer: String,           // Changed from "destination" to "customer"
    val code: String,               // Changed from "palletCode" to "code"
    val deliveryReceipt: String,    // Changed from "transactionCode" to "deliveryReceipt"

    // Newly Added Fields
    val deliveryDate: String? = null,
    val heatTreatmentDate: String? = null,
    val chemicalTreatmentDate: String? = null,
    val driver: String? = null,
    val trucker: String? = null,
    val truckPlateNumber: String? = null,
    val returnDate: String? = null,          // Optional
    val isAdvanceReplacement: Boolean? = null, // Optional
    val notes: String? = null,               // Optional
    val typeOfActivity: String? = null,      // Optional

    @DrawableRes val imageRes: Int? = null // Optional image resource
)
