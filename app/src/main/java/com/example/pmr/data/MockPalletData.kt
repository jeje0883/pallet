package com.example.pmr.data

object MockPalletData {
    val palletList = listOf(
        Pallet(
            source = "PMR Pallet Ltd. Co.",
            customer = "Alaska Milk Corporation",
            code = "DR-AMC-LAG-001",
            deliveryReceipt = "#20691",
            deliveryDate = "2023-09-01",
            heatTreatmentDate = "2023-08-25",
            chemicalTreatmentDate = "2023-08-28",
            driver = "John Doe",
            trucker = "XYZ Trucking",
            truckPlateNumber = "ABC-1234",
            returnDate = null,
            isAdvanceReplacement = false,
            notes = "Handle with care",
            typeOfActivity = null,
            scanIdentifier = "XWB241097",
            dateScanned = "Dec 09, 2024 12:53:07 PM"
        ),
        Pallet(
            source = "PMR Pallet Ltd. Co.",
            customer = "Nestle Philippines",
            code = "DR-NES-GEN-002",
            deliveryReceipt = "#20692",
            deliveryDate = "2023-09-02",
            heatTreatmentDate = "2023-08-25",
            chemicalTreatmentDate = "2023-08-29",
            driver = "Jane Smith",
            trucker = "ABC Logistics",
            truckPlateNumber = "XYZ-5678",
            returnDate = null,
            isAdvanceReplacement = false,
            notes = "Check expiry",
            typeOfActivity = "Export",
            scanIdentifier = "YTC341298",
            dateScanned = "Dec 10, 2024 09:15:03 AM"
        ),
        Pallet(
            source = "PMR Pallet Ltd. Co.",
            customer = "Coca-Cola Beverages",
            code = "DR-CCB-GEN-003",
            deliveryReceipt = "#20693",
            deliveryDate = "2023-09-03",
            heatTreatmentDate = "2023-08-26",
            chemicalTreatmentDate = "2023-08-29",
            driver = "Charlie Brown",
            trucker = "FastCargo",
            truckPlateNumber = "CCC-9087",
            returnDate = "2023-09-10",
            isAdvanceReplacement = false,
            notes = "Store upright",
            typeOfActivity = "Local Delivery",
            scanIdentifier = "ZRD452389",
            dateScanned = "Dec 11, 2024 03:22:05 PM"
        ),
        Pallet(
            source = "PMR Pallet Ltd. Co.",
            customer = "San Miguel Corp.",
            code = "DR-SMC-GEN-004",
            deliveryReceipt = "#20694",
            deliveryDate = "2023-09-04",
            heatTreatmentDate = "2023-08-27",
            chemicalTreatmentDate = "2023-08-30",
            driver = "Lucy Van Pelt",
            trucker = "Kargo Express",
            truckPlateNumber = "KEX-3456",
            returnDate = null,
            isAdvanceReplacement = true,
            notes = null,
            typeOfActivity = "Replacement",
            scanIdentifier = "ASD563480",
            dateScanned = "Dec 12, 2024 11:45:09 AM"
        ),
        Pallet(
            source = "PMR Pallet Ltd. Co.",
            customer = "Jollibee Foods Corp.",
            code = "DR-JFC-GEN-005",
            deliveryReceipt = "#20695",
            deliveryDate = "2023-09-05",
            heatTreatmentDate = "2023-08-28",
            chemicalTreatmentDate = "2023-08-30",
            driver = "Peppermint Patty",
            trucker = "CargoMate",
            truckPlateNumber = "XYZ-1235",
            returnDate = null,
            isAdvanceReplacement = false,
            notes = "Fragile items",
            typeOfActivity = "Local Delivery",
            scanIdentifier = "FGH674571",
            dateScanned = "Dec 13, 2024 07:30:02 PM"
        ),
        Pallet(
            source = "PMR Pallet Ltd. Co.",
            customer = "Unilever Philippines",
            code = "DR-ULP-GEN-006",
            deliveryReceipt = "#20696",
            deliveryDate = "2023-09-06",
            heatTreatmentDate = "2023-08-29",
            chemicalTreatmentDate = "2023-08-31",
            driver = "Marcie Johnson",
            trucker = "HaulIt",
            truckPlateNumber = "HUL-1111",
            returnDate = "2023-09-12",
            isAdvanceReplacement = false,
            notes = "Check for leaks",
            typeOfActivity = "Export",
            scanIdentifier = "JKL785662",
            dateScanned = "Dec 14, 2024 05:18:04 AM"
        ),
        Pallet(
            source = "PMR Pallet Ltd. Co.",
            customer = "Monde Nissin Corp.",
            code = "DR-MNC-GEN-007",
            deliveryReceipt = "#20697",
            deliveryDate = "2023-09-07",
            heatTreatmentDate = "2023-08-30",
            chemicalTreatmentDate = "2023-09-01",
            driver = "Franklin Lee",
            trucker = "SpeedyTrans",
            truckPlateNumber = "SPT-9090",
            returnDate = null,
            isAdvanceReplacement = false,
            notes = "Keep cool",
            typeOfActivity = "Local Delivery",
            scanIdentifier = "MNB896753",
            dateScanned = "Dec 15, 2024 02:50:06 PM"
        ),
        Pallet(
            source = "PMR Pallet Ltd. Co.",
            customer = "PepsiCo",
            code = "DR-PEP-GEN-008",
            deliveryReceipt = "#20698",
            deliveryDate = "2023-09-08",
            heatTreatmentDate = "2023-08-31",
            chemicalTreatmentDate = "2023-09-02",
            driver = "Linus van Pelt",
            trucker = "TruckerPro",
            truckPlateNumber = "TRP-2222",
            returnDate = null,
            isAdvanceReplacement = true,
            notes = "High priority",
            typeOfActivity = "Replacement",
            scanIdentifier = "QWE907844",
            dateScanned = "Dec 16, 2024 10:05:01 AM"
        ),
        Pallet(
            source = "PMR Pallet Ltd. Co.",
            customer = "URC (Universal Robina)",
            code = "DR-URC-GEN-009",
            deliveryReceipt = "#20699",
            deliveryDate = "2023-09-09",
            heatTreatmentDate = "2023-09-01",
            chemicalTreatmentDate = "2023-09-03",
            driver = "Schroeder Wilson",
            trucker = "LandFreight",
            truckPlateNumber = "LFT-6789",
            returnDate = null,
            isAdvanceReplacement = false,
            notes = "No stacking over 3 pallets",
            typeOfActivity = "Local Delivery",
            scanIdentifier = "RTY018935",
            dateScanned = "Dec 17, 2024 08:40:03 PM"
        ),
        Pallet(
            source = "PMR Pallet Ltd. Co.",
            customer = "Procter & Gamble",
            code = "DR-PG-GEN-010",
            deliveryReceipt = "#20700",
            deliveryDate = "2023-09-10",
            heatTreatmentDate = "2023-09-02",
            chemicalTreatmentDate = "2023-09-04",
            driver = "Sally Brown",
            trucker = "QuickHaul",
            truckPlateNumber = "QHL-7777",
            returnDate = "2023-09-15",
            isAdvanceReplacement = false,
            notes = "Keep upright",
            typeOfActivity = "Local Delivery",
            scanIdentifier = "UIO129026",
            dateScanned = "Dec 18, 2024 06:25:05 AM"
        )
    )
}
