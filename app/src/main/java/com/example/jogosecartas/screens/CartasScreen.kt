package com.example.jogosecartas.screens

import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.jogosecartas.R
import com.example.jogosecartas.components.CardZoomEffect
import com.example.jogosecartas.ui.theme.Righteous


@Composable
fun CartasScreen(navController: NavController){
    Column(modifier = Modifier
        .fillMaxSize()
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .height(200.dp),
            horizontalArrangement = Arrangement.Center,
            verticalAlignment = Alignment.CenterVertically)
        {
            Text(text = "Cartas", fontFamily = Righteous, fontSize = 48.sp, textAlign = TextAlign.Center)
        }
        Row(
            modifier = Modifier
                .fillMaxWidth() // Melhor que size(100.dp)
                .height(200.dp)
                .padding(horizontal = 16.dp), // Espaçamento lateral
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceEvenly
            ) {
            CardZoomEffect(
                imageResId = R.drawable.carta_defesa,
                contentDescription = "Carta de Defesa",
                highlightedText = "Defente-te por uno turno bb"
            )
            CardZoomEffect(
                imageResId = R.drawable.carta_ataque,
                contentDescription = "Carta de Ataque",
                highlightedText = "Dano facada dano dano dano"
            )
            CardZoomEffect(
                imageResId = R.drawable.carta_ataque,
                contentDescription = "Carta de Ataque",
                highlightedText = "Danodanodano"
            )
        }
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
private fun PreviewCartas() {
    CartasScreen(navController = NavController(context = LocalContext.current))
}