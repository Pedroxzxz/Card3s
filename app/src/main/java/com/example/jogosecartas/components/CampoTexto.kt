package com.example.jogosecartas.components

import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

@Composable
fun CampoTexto(label: String) {
    var texto by remember { mutableStateOf("") }

    Spacer(modifier = Modifier.height(8.dp))

    Text(text = label, style = MaterialTheme.typography.titleMedium)

    OutlinedTextField(
        value = texto,
        onValueChange = { texto = it },
        shape = RoundedCornerShape(10.dp),
        modifier = Modifier
            .fillMaxWidth()
            .height(56.dp)
            .padding(vertical = 4.dp),
        colors = OutlinedTextFieldDefaults.colors(

            focusedBorderColor = Color(0xFFFFA500),
            unfocusedBorderColor = Color.Gray
        )
    )
}
