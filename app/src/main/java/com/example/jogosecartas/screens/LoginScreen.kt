package com.example.jogosecartas.screens

import androidx.compose.animation.core.Animatable
import androidx.compose.animation.core.LinearEasing
import androidx.compose.animation.core.tween
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowDown
import androidx.compose.material3.Icon
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.jogosecartas.components.Formulario
import com.example.jogosecartas.components.Titulo
import kotlinx.coroutines.delay
import kotlin.math.abs
import kotlin.random.Random

@Composable
fun LoginScreen(navController: NavHostController) {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        // Coloca os 7 ícones animando ao fundo
        //FallingIcons()
        // Conteúdo principal
        Column(
            modifier = Modifier
                .fillMaxSize()
                .align(Alignment.Center),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Titulo()
            Formulario(navController)
        }
    }
}

// Dados para cada ícone, armazenando um id e a posição horizontal (em pixels)
//data class FallingIconData(val id: Int, val x: Float)
//
//@Composable
//fun FallingIcons() {
//    val density = LocalDensity.current
//    val configuration = LocalConfiguration.current
//
//    // Dimensões da tela em pixels
//    val screenWidthPx = with(density) { configuration.screenWidthDp.dp.toPx() }
//    val screenHeightPx = with(density) { configuration.screenHeightDp.dp.toPx() }
//    val iconSize = 50.dp
//    val iconSizePx = with(density) { iconSize.toPx() }
//    // Distância mínima para evitar sobreposição horizontal (aqui usamos o tamanho do ícone)
//    val safeDistance = iconSizePx
//
//    // Lista de ícones atualmente caindo
//    val fallingIcons = remember { mutableStateListOf<FallingIconData>() }
//    var iconId by remember { mutableStateOf(0) }
//
//    // Parâmetros da animação vertical
//    val animationDuration = 20000L // 20 segundos
//
//    // Laço global que gera ícones em momentos aleatórios
//    LaunchedEffect(Unit) {
//        while (true) {
//            // Gera uma posição horizontal aleatória e garante que não esteja muito próxima de algum ícone ativo
//            var candidateX: Float
//            var attempts = 0
//            do {
//                candidateX = Random.nextFloat() * (screenWidthPx - iconSizePx)
//                attempts++
//            } while (fallingIcons.any { abs(it.x - candidateX) < safeDistance } && attempts < 10)
//
//            // Adiciona o novo ícone à lista
//            fallingIcons.add(FallingIconData(id = iconId, x = candidateX))
//            iconId++
//
//            // Delay aleatório antes do próximo spawn (entre 1 e 3 segundos, por exemplo)
//            delay(Random.nextLong(1000, 3000))
//        }
//    }
//
//    Box(modifier = Modifier.fillMaxSize()) {
//        fallingIcons.forEach { iconData ->
//            key(iconData.id) {
//                AnimatedFallingIcon(
//                    xPos = iconData.x,
//                    iconSize = iconSize,
//                    animationDuration = animationDuration,
//                    onAnimationEnd = {
//                        fallingIcons.removeAll { it.id == iconData.id }
//                    }
//                )
//            }
//        }
//    }
//}
//
//@Composable
//fun AnimatedFallingIcon(
//    xPos: Float,
//    iconSize: Dp,
//    animationDuration: Long,
//    onAnimationEnd: () -> Unit
//) {
//    val density = LocalDensity.current
//    val configuration = LocalConfiguration.current
//
//    val iconSizePx = with(density) { iconSize.toPx() }
//    // Altura da tela em pixels
//    val screenHeightPx = with(density) { configuration.screenHeightDp.dp.toPx() }
//    // Posição inicial: acima da tela
//    val initialOffset = -iconSizePx * 2
//    // Posição final: abaixo da tela
//    val finalOffset = screenHeightPx + iconSizePx
//
//    val offsetY = remember { Animatable(initialOffset) }
//
//    LaunchedEffect(Unit) {
//        offsetY.animateTo(
//            targetValue = finalOffset,
//            animationSpec = tween(durationMillis = animationDuration.toInt(), easing = LinearEasing)
//        )
//        // Quando a animação termina, remove o ícone
//        onAnimationEnd()
//    }
//
//    Icon(
//        imageVector = Icons.Filled.KeyboardArrowDown,
//        contentDescription = "Falling Icon",
//        modifier = Modifier
//            .size(iconSize)
//            .offset(
//                x = with(density) { xPos.toDp() },
//                y = with(density) { offsetY.value.toDp() }
//            )
//            .background(Color.Red)
//    )
//}





@Preview(showBackground = true, showSystemUi = true)
@Composable
private fun TelaLoginPreview() {
    LoginScreen(navController = rememberNavController())
}
