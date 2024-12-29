package com.example.pmr.components

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.selection.selectable
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.pmr.R // Replace with your actual drawable imports

// Renamed enum class to avoid confusion with android.text.InputType
enum class CustomInputType(
    val defaultTitle: String, // Default title for the input
    val placeholderText: String,
    val icon: Int? = null,
    val keyboardType: KeyboardType = KeyboardType.Text
) {
    Text(
        defaultTitle = "Text Input",
        placeholderText = "Enter text",
        icon = null,
        keyboardType = KeyboardType.Text
    ),
    Date(
        defaultTitle = "Date Input",
        placeholderText = "Select date",
        icon = R.drawable.calendar_icon, // Replace with your actual calendar icon
        keyboardType = KeyboardType.Number
    ),
    Number(
        defaultTitle = "Number Input",
        placeholderText = "Enter number",
        icon = null,
        keyboardType = KeyboardType.Number
    ),
    Selection(
        defaultTitle = "Selection Input",
        placeholderText = "Choose option",
        icon = R.drawable.dropdown_icon, // Replace with your actual dropdown icon
        keyboardType = KeyboardType.Text
    ),
    Boolean(
        defaultTitle = "Boolean Input",
        placeholderText = "Yes or No",
        icon = null,
        keyboardType = KeyboardType.Text
    )
}

@Composable
fun CustomInput(
    type: CustomInputType,
    value: String,
    onValueChange: (String) -> Unit,
    title: String? = null, // Customizable title
    options: List<String> = emptyList() // Used for Selection type
) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
//            .padding(16.dp)
    ) {
        // Title
        Text(
            text = title ?: type.defaultTitle, // Use custom title if provided
            style = MaterialTheme.typography.titleMedium
        )

//        Spacer(modifier = Modifier.height(8.dp))

        // Input Field
        when (type) {
            CustomInputType.Selection -> {
                DropdownInput(
                    options = options,
                    selectedOption = value,
                    onOptionSelect = onValueChange
                )
            }
            CustomInputType.Boolean -> {
                BooleanInput(
                    value = value,
                    onValueChange = onValueChange
                )
            }
            else -> {
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(48.dp)
                        .border(
                            width = 1.dp,
                            color = Color(0xFFDBE0E5), // Corrected color specification with alpha
                            shape = RoundedCornerShape(6.dp) // Ensure the border shape matches the background
                        )
                        .background(
                            color = Color.White,
                            shape = MaterialTheme.shapes.medium // Consistent shape with the border
                        )
//                        .clickable { expanded = !expanded }
                        .padding(horizontal = 12.dp),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    type.icon?.let { icon ->
                        Icon(
                            painter = painterResource(id = icon),
                            contentDescription = null,
                            modifier = Modifier.size(24.dp),
                            tint = Color.Gray
                        )
                        Spacer(modifier = Modifier.width(8.dp))
                    }

                    BasicTextField(
                        value = value,
                        onValueChange = onValueChange,
                        keyboardOptions = KeyboardOptions(keyboardType = type.keyboardType),
                        singleLine = true,
                        textStyle = MaterialTheme.typography.bodyMedium.copy(color = Color.Black),
                        decorationBox = { innerTextField ->
                            if (value.isEmpty()) {
                                Text(
                                    text = type.placeholderText,
                                    color = Color.Gray,
                                    style = MaterialTheme.typography.bodyMedium
                                )
                            }
                            innerTextField()
                        },
                        modifier = Modifier.fillMaxWidth()
                    )
                }
            }
        }
    }
}

@Composable
fun DropdownInput(
    options: List<String>,
    selectedOption: String,
    onOptionSelect: (String) -> Unit
) {
    var expanded by remember { mutableStateOf(false) }
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .height(48.dp)
            .border(
                width = 1.dp,
                color = Color(0xFFDBE0E5), // Corrected color specification with alpha
                shape = RoundedCornerShape(6.dp) // Ensure the border shape matches the background
            )
            .background(
                color = Color.White,
                shape = MaterialTheme.shapes.medium // Consistent shape with the border
            )
            .clickable { expanded = !expanded }
            .padding(horizontal = 12.dp),
        contentAlignment = Alignment.CenterStart

    ) {
        Text(
            text = if (selectedOption.isEmpty()) "Choose option" else selectedOption,
            style = MaterialTheme.typography.bodyMedium,
            color = if (selectedOption.isEmpty()) Color.Gray else Color.Black
        )
        DropdownMenu(
            expanded = expanded,
            onDismissRequest = { expanded = false }
        ) {
            options.forEach { option ->
                DropdownMenuItem(
                    onClick = {
                        onOptionSelect(option)
                        expanded = false
                    },
                    text = { Text(text = option, style = MaterialTheme.typography.bodyMedium) }
                )
            }
        }
    }
}

@Composable
fun BooleanInput(
    value: String,
    onValueChange: (String) -> Unit
) {
    // Convert string value to boolean
    val isYes = value.equals("Yes", ignoreCase = true)
    val isNo = value.equals("No", ignoreCase = true)

    Row(
        verticalAlignment = Alignment.CenterVertically
    ) {
        RadioButton(
            selected = isYes,
            onClick = { onValueChange("Yes") }
        )
        Text(
            text = "Yes",
            modifier = Modifier.padding(end = 16.dp),
            style = MaterialTheme.typography.bodyMedium
        )

        RadioButton(
            selected = isNo,
            onClick = { onValueChange("No") }
        )
        Text(
            text = "No",
            style = MaterialTheme.typography.bodyMedium
        )
    }
}

// Specific Composables for Direct Calls
object InputType {
    @Composable
    fun Text(
        value: String,
        onValueChange: (String) -> Unit,
        title: String? = null
    ) {
        CustomInput(
            type = CustomInputType.Text,
            value = value,
            onValueChange = onValueChange,
            title = title
        )
    }

    @Composable
    fun Date(
        value: String,
        onValueChange: (String) -> Unit,
        title: String? = null
    ) {
        CustomInput(
            type = CustomInputType.Date,
            value = value,
            onValueChange = onValueChange,
            title = title
        )
    }

    @Composable
    fun Number(
        value: String,
        onValueChange: (String) -> Unit,
        title: String? = null
    ) {
        CustomInput(
            type = CustomInputType.Number,
            value = value,
            onValueChange = onValueChange,
            title = title
        )
    }

    @Composable
    fun Selection(
        value: String,
        onValueChange: (String) -> Unit,
        options: List<String>,
        title: String? = null
    ) {
        CustomInput(
            type = CustomInputType.Selection,
            value = value,
            onValueChange = onValueChange,
            options = options,
            title = title
        )
    }

    @Composable
    fun Boolean(
        value: String,
        onValueChange: (String) -> Unit,
        title: String? = null
    ) {
        CustomInput(
            type = CustomInputType.Boolean,
            value = value,
            onValueChange = onValueChange,
            title = title
        )
    }
}

@Preview(showSystemUi = true, showBackground = true)
@Composable
fun PreviewInputType() {
    var textValue by remember { mutableStateOf("") }
    var dateValue by remember { mutableStateOf("") }
    var numberValue by remember { mutableStateOf("") }
    var selectedOption by remember { mutableStateOf("") }
    var booleanValue by remember { mutableStateOf("") } // Use String for "Yes"/"No"

    Column(modifier = Modifier.padding(16.dp)) {
        // Text Input with Custom Title
        InputType.Text(
            value = textValue,
            onValueChange = { textValue = it },
            title = "Custom Text Title"
        )
        Spacer(modifier = Modifier.height(16.dp))

        // Date Input with Default Title
        InputType.Date(
            value = dateValue,
            onValueChange = { dateValue = it }
        )
        Spacer(modifier = Modifier.height(16.dp))

        // Number Input with Custom Title
        InputType.Number(
            value = numberValue,
            onValueChange = { numberValue = it },
            title = "Custom Number Title"
        )
        Spacer(modifier = Modifier.height(16.dp))

        // Selection Input with Custom Title
        InputType.Selection(
            value = selectedOption,
            onValueChange = { selectedOption = it },
            options = listOf("Option 1", "Option 2", "Option 3"),
            title = "Custom Selection Title"
        )
        Spacer(modifier = Modifier.height(16.dp))

        // Boolean Input with Default Title
        InputType.Boolean(
            value = booleanValue,
            onValueChange = { newValue ->
                booleanValue = newValue
            }
        )
    }
}
