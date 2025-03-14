package com.example.jogosecartas.components

import androidx.compose.animation.core.LinearEasing
import androidx.compose.animation.core.RepeatMode
import androidx.compose.animation.core.animateFloat
import androidx.compose.animation.core.infiniteRepeatable
import androidx.compose.animation.core.rememberInfiniteTransition
import androidx.compose.animation.core.tween
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.offset
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.TileMode
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.jogosecartas.ui.theme.Righteous

@Composable
fun Titulo() {
    Box {
        // Texto de contorno preto (leve deslocamento para cada direção)

        Text(
            text = "Card3s",
            style = TextStyle(
                fontSize = 40.sp,
                fontWeight = FontWeight.Bold,
                fontFamily = Righteous,
                color = Color.Black
            ),
            modifier = Modifier.offset(2.dp, 2.dp)
        )



        val infiniteTransition = rememberInfiniteTransition()

        // Tamanho do padrão do gradiente (ajuste conforme necessário)
        val patternWidth = 500f

        // Animação que move o gradiente continuamente de 0 até patternWidth
        val offsetX by infiniteTransition.animateFloat(
            initialValue = 0f,
            targetValue = patternWidth,
            animationSpec = infiniteRepeatable(
                animation = tween(durationMillis = 6000, easing = LinearEasing),
                repeatMode = RepeatMode.Restart
            )
        )

        // Lista de cores cíclica: começa e termina com verde para transição suave
        val colors = listOf(
            Color.Green, Color.Blue, Color.Magenta, Color.Red, Color.Yellow, Color.Green
        )

        // Gradiente que se repete, usando tileMode = TileMode.Repeated
        val gradientBrush = Brush.linearGradient(
            colors = colors,
            start = Offset(-offsetX, 0f),
            end = Offset(-offsetX + patternWidth, 0f),
            tileMode = TileMode.Repeated
        )
        // Texto branco por cima

        Text(
            text = "Card3s",
            style = TextStyle(
                fontSize = 40.sp,
                fontWeight = FontWeight.Bold,
                fontFamily = Righteous,

                brush = gradientBrush// Cor principal do texto


            )
        )
    }
}