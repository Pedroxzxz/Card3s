@file:OptIn(ExperimentalMaterial3Api::class)

package com.example.jogosecartas


import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.jogosecartas.screens.LoginScreen
import com.example.jogosecartas.screens.MenuScreen
import com.example.jogosecartas.ui.theme.JogosECartasTheme

//Alteracao
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            JogosECartasTheme {

                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    val navController = rememberNavController()
                    NavHost(
                        navController = navController,
                        startDestination = "login"
                    ) {
                        composable(route = "login") { LoginScreen(navController) }
                        composable(route = "menu") { MenuScreen(navController) }
                    }
                }
            }
        }
    }






@Preview(showBackground = true, showSystemUi = true)
@Composable
private fun TelaInicialPreview() {
    val navController = rememberNavController()
    JogosECartasTheme {
        LoginScreen(navController)
    }
}}