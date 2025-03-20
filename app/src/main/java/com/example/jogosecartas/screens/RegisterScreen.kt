package com.example.jogosecartas.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowLeft
import androidx.compose.material.icons.filled.KeyboardDoubleArrowLeft
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.LineHeightStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.jogosecartas.components.FormularioRegistro
import com.example.jogosecartas.ui.theme.Righteous




@Composable
fun RegisterScreen (navController: NavHostController){



    Box(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),

    ) {
        Column (modifier = Modifier.height(80.dp), verticalArrangement = Arrangement.Bottom){
            IconButton(onClick = { navController.navigate("login")}) {
                Icon(
                    imageVector = Icons.Filled.KeyboardArrowLeft,
                    contentDescription = "Left Icon",
                    modifier = Modifier.size(30.dp)

                )
            }
        }


        Column(
            modifier = Modifier
                .fillMaxSize()
                .align(Alignment.Center),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.Start
        ) {



            Box {
                
                Text(
                    text = "Crie sua conta...",
                    style = TextStyle(
                        fontSize = 30.sp,
                        fontWeight = FontWeight.Bold,
                        fontFamily = Righteous,
                        color = Color.Black
                    ),
                    modifier = Modifier.offset(2.dp, 2.dp).padding(start = 10.dp)
                )
            }

            Spacer(modifier = Modifier.height(10.dp).fillMaxWidth())

            FormularioRegistro(navController)

        }
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun TelaRegisterPreview() {
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = "register_preview") {
        composable("register_preview") {
            RegisterScreen(navController = navController)
        }
    }
}
