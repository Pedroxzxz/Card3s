@file:OptIn(ExperimentalMaterial3Api::class)

package com.example.jogosecartas

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.animation.AnimatedContentTransitionScope
import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.animation.core.tween
import androidx.compose.animation.fadeOut
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import com.example.jogosecartas.screens.CartasScreen
import com.example.jogosecartas.screens.LoginScreen
import com.example.jogosecartas.screens.MenuScreen
import com.example.jogosecartas.screens.RegisterScreen
import com.example.jogosecartas.ui.theme.JogosECartasTheme
import com.google.accompanist.navigation.animation.AnimatedNavHost
import com.google.accompanist.navigation.animation.composable
import com.google.accompanist.navigation.animation.rememberAnimatedNavController


/*------ Oiiiiii *-------*/



class MainActivity : ComponentActivity() {
    @OptIn(ExperimentalAnimationApi::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            JogosECartasTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    val navController = rememberAnimatedNavController()
                    AnimatedNavHost(
                        navController = navController,
                        startDestination = "login",
                        exitTransition = {
                            slideOutOfContainer(
                                towards = AnimatedContentTransitionScope.SlideDirection.Up, //Direcao da Animacao
                                animationSpec = tween(800) //Tempo da Animacao
                            ) + fadeOut(animationSpec = tween(600))
                        },
                        enterTransition = {
                            slideIntoContainer(
                                towards = AnimatedContentTransitionScope.SlideDirection.Down, //Direcao da Animacao
                                animationSpec = tween(800) //Tempo da Animacao
                            )
                        }

                    ) {
                        composable(route = "login") { LoginScreen(navController) }
                        composable(route = "menu") {MenuScreen(navController) }
                        composable(route = "cartas") { CartasScreen(navController) }
                        composable(route = "registro") { RegisterScreen(navController) }
                    }
                }
            }
        }
    }
}

