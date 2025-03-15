package com.example.jogosecartas.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.Alignment
import androidx.compose.material3.Text
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.window.Dialog
import com.example.jogosecartas.R
import com.example.jogosecartas.ui.theme.Righteous

@Composable
fun CardZoomEffect(
    imageResId: Int,
    contentDescription: String,
    highlightedText: String
) {
    var isFullScreen by remember { mutableStateOf(false) }

    // Imagem normal
    Image(
        painter = painterResource(id = imageResId),
        contentDescription = contentDescription,
        modifier = Modifier
            .size(width = 120.dp, height = 200.dp)
            .clip(RoundedCornerShape(10.dp))
            .clickable { isFullScreen = true }
    )

    // Exibe a carta em tela cheia quando clicada
    if (isFullScreen) {
        Dialog(onDismissRequest = { isFullScreen = false }) {
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .clickable { isFullScreen = false },
                contentAlignment = Alignment.Center // Centraliza o conteúdo na tela
            ) {
                Column(
                    horizontalAlignment = Alignment.CenterHorizontally, // Centraliza horizontalmente
                    modifier = Modifier.padding(16.dp)
                ) {
                    // Imagem em tela cheia
                    Image(
                        painter = painterResource(id = imageResId),
                        contentDescription = "$contentDescription em Tela Cheia",
                        contentScale = ContentScale.Fit,
                        modifier = Modifier
                            .fillMaxWidth(0.8f) // Ocupa 80% da largura da tela
                            .clip(RoundedCornerShape(10.dp))
                    )

                    // Texto destacado
                    Spacer(modifier = Modifier.height(16.dp)) // Espaço entre a imagem e o texto
                    Text(
                        fontSize = 26.sp,
                        lineHeight = 32.sp,
                        fontFamily = Righteous,
                        text = highlightedText,
                        color = Color.White,
                        textAlign = TextAlign.Center, // Centraliza o texto
                        modifier = Modifier.fillMaxWidth(0.8f) // Ocupa 80% da largura da tela
                    )
                }
            }
        }
    }
}
