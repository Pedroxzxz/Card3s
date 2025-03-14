package com.example.jogosecartas.components

import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun BotaoConfirmar() {

    Spacer(modifier = Modifier.height(16.dp))

    Button(
        onClick = { /* Ação do botão */ },
        modifier = Modifier
            .fillMaxWidth()
            .size(50.dp),
        shape = RoundedCornerShape(10.dp)


    ) {
        Text(text = "Confirmar")
    }
}