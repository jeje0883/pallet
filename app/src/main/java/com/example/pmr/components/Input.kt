package com.example.pmr.components

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
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
import com.example.pmr.R

enum class InputType(
    val defaultTitle: String,
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
        icon = R.drawable.calendar_icon,
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
        icon = R.drawable.dropdown_icon,
        keyboardType = KeyboardType.Text
    ),
    Boolean(
        defaultTitle = "Boolean Input",
        placeholderText = "Yes or No",
        icon = null,
        keyboardType = KeyboardType.Text
    );

    companion object {
        @Composable
        fun Text(
            value: String = "",
            onValueChange: (String) -> Unit,
            title: String? = null,
            placeholderText: String? = null
        ) {
            CustomInput(
                type = Text,
                value = value,
                onValueChange = onValueChange,
                title = title,
                placeholderText = placeholderText
            )
        }

        @Composable
        fun Date(
            value: String = "",
            onValueChange: (String) -> Unit,
            title: String? = null,
            placeholderText: String? = null
        ) {
            CustomInput(
                type = Date,
                value = value,
                onValueChange = onValueChange,
                title = title,
                placeholderText = placeholderText
            )
        }

        @Composable
        fun Number(
            value: String = "",
            onValueChange: (String) -> Unit,
            title: String? = null,
            placeholderText: String? = null
        ) {
            CustomInput(
                type = Number,
                value = value,
                onValueChange = onValueChange,
                title = title,
                placeholderText = placeholderText
            )
        }

        @Composable
        fun Selection(
            value: String = "",
            onValueChange: (String) -> Unit,
            options: List<String>,
            title: String? = null,
            placeholderText: String? = null,

        ) {
            CustomInput(
                type = Selection,
                value = value,
                onValueChange = onValueChange,
                options = options,
                title = title,
                placeholderText = placeholderText
            )
        }

        @Composable
        fun Boolean(
            value: String = "",
            onValueChange: (String) -> Unit,
            title: String? = null,
            placeholderText: String? = null
        ) {
            CustomInput(
                type = Boolean,
                value = value,
                onValueChange = onValueChange,
                title = title,
                placeholderText = placeholderText
            )
        }
    }
}

@Composable
fun CustomInput(
    type: InputType,
    value: String,
    onValueChange: (String) -> Unit,
    title: String? = null, // Customizable title
    options: List<String> = emptyList(), // Used for Selection type
    placeholderText: String? = null // Optional placeholderText with fallback
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

        Spacer(modifier = Modifier.height(8.dp))

        // Input Field
        when (type) {
            InputType.Selection -> {
                DropdownInput(
                    options = options,
                    selectedOption = value,
                    onOptionSelect = onValueChange,
                    placeholderText = placeholderText ?: "Choose option"
                )
            }
            InputType.Boolean -> {
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
                            shape = RoundedCornerShape(6.dp) // Consistent shape with the border
                        )
                        .padding(horizontal = 12.dp),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    type.icon?.let { icon ->
                        Icon(
                            painter = painterResource(id = icon),
                            contentDescription = type.defaultTitle,
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
                                    text = placeholderText ?: type.placeholderText,
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
    onOptionSelect: (String) -> Unit,
    placeholderText: String
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
                shape = RoundedCornerShape(6.dp) // Consistent shape with the border
            )
            .clickable { expanded = !expanded }
            .padding(horizontal = 12.dp),
        contentAlignment = Alignment.CenterStart
    ) {
        Text(
            text = if (selectedOption.isEmpty()) placeholderText else selectedOption,
            style = MaterialTheme.typography.bodyMedium,
            color = if (selectedOption.isEmpty()) Color.Gray else Color.Black
        )
        DropdownMenu(
            expanded = expanded,
            onDismissRequest = { expanded = false },
            modifier = Modifier.fillMaxWidth()
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

private fun Modifier.inputModifier(): Modifier = this
    .border(
        width = 1.dp,
        color = Color(0xFFDBE0E5),
        shape = RoundedCornerShape(6.dp)
    )
    .background(
        color = Color.White,
        shape = RoundedCornerShape(6.dp)
    )

object InputTypeHelper {
    @Composable
    fun Text(
        value: String = "",
        onValueChange: (String) -> Unit,
        title: String? = null,
        placeholderText: String? = null
    ) {
        InputType.Text(
            value = value,
            onValueChange = onValueChange,
            title = title,
            placeholderText = placeholderText
        )
    }

    @Composable
    fun Date(
        value: String = "",
        onValueChange: (String) -> Unit,
        title: String? = null,
        placeholderText: String? = null
    ) {
        InputType.Date(
            value = value,
            onValueChange = onValueChange,
            title = title,
            placeholderText = placeholderText
        )
    }

    @Composable
    fun Number(
        value: String = "",
        onValueChange: (String) -> Unit,
        title: String? = null,
        placeholderText: String? = null
    ) {
        InputType.Number(
            value = value,
            onValueChange = onValueChange,
            title = title,
            placeholderText = placeholderText
        )
    }

    @Composable
    fun Selection(
        value: String = "",
        onValueChange: (String) -> Unit,
        options: List<String>,
        title: String? = null,
        placeholderText: String? = null,
        selectedOption: String? = null

    ) {
        InputType.Selection(
            value = value,
            onValueChange = onValueChange,
            options = options,
            title = title,
            placeholderText = placeholderText,

        )
    }

    @Composable
    fun Boolean(
        value: String = "",
        onValueChange: (String) -> Unit,
        title: String? = null,
        placeholderText: String? = null
    ) {
        InputType.Boolean(
            value = value,
            onValueChange = onValueChange,
            title = title,
            placeholderText = placeholderText
        )
    }
}

@Preview(showSystemUi = true, showBackground = true)
@Composable
fun PreviewInputComponents() {
    var textValue by remember { mutableStateOf("") }
    var dateValue by remember { mutableStateOf("") }
    var numberValue by remember { mutableStateOf("") }
    var selectedOption by remember { mutableStateOf("") }
    var booleanValue by remember { mutableStateOf("") } // Use String for "Yes"/"No"

    Column() {
        // Text Input with Custom Title
        InputTypeHelper.Text(
            value = textValue,
            onValueChange = { textValue = it },
            title = "Custom Text Title"
        )
        Spacer(modifier = Modifier.height(16.dp))

        // Date Input with Default Title
        InputTypeHelper.Date(
            value = dateValue,
            onValueChange = { dateValue = it }
        )
        Spacer(modifier = Modifier.height(16.dp))

        // Number Input with Custom Title
        InputTypeHelper.Number(
            value = numberValue,
            onValueChange = { numberValue = it },
            title = "Custom Number Title"
        )
        Spacer(modifier = Modifier.height(16.dp))

        // Selection Input with Custom Title
        InputTypeHelper.Selection(
            value = selectedOption,
            onValueChange = { selectedOption = it },
            options = listOf("Option 1", "Option 2", "Option 3"),
            title = "Custom Selection Title",
            placeholderText = "Select customer"
        )
        Spacer(modifier = Modifier.height(16.dp))

        // Boolean Input with Default Title
        InputTypeHelper.Boolean(
            value = booleanValue,
            onValueChange = { newValue ->
                booleanValue = newValue
            }
        )
    }
}
