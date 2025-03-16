package com.example.jogosecartas.screens

import android.R.attr.onClick
import android.annotation.SuppressLint
import android.app.Activity
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.core.app.ActivityCompat.finishAffinity
import androidx.navigation.NavHostController
import com.example.jogosecartas.components.Titulo
import com.example.jogosecartas.ui.theme.Righteous

@SuppressLint("ContextCastToActivity")
@Composable
fun MenuScreen(navController: NavHostController) {

    val context = LocalContext.current as? Activity

    Scaffold(
        topBar = {
            Row(
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 42.dp),
            ){
                IconButton(
                    onClick = { navController.navigate("login") },
                    modifier = Modifier
                        .size(42.dp)
                        .offset(x = (8.dp), y = (2.dp))
                ) {
                    Icon(
                        imageVector = Icons.AutoMirrored.Filled.ArrowBack,
                        contentDescription = "Ícone de Casa",
                        tint = Color.Black,
                        modifier = Modifier.fillMaxSize()
                    )
                }
                Titulo()
                IconButton(
                    onClick = { /* Ação */ },
                    modifier = Modifier
                        .size(50.dp)
                ) {}
            }
        },
        content = { paddingValues ->
            Column(modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues)
            ) {

                Spacer(modifier = Modifier.height(162.dp) //ESPACO ENTRE A BARRA SUPERIOR E O BOTÃO JOGAR
                    .fillMaxWidth()
                )
                Column(modifier = Modifier //PRIMEIRA ROW - BOTAO JOGAR
                    .fillMaxWidth(),
                    verticalArrangement = Arrangement.Center,
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Button(
                        modifier = Modifier
                            .height(60.dp)
                            .width(160.dp)
                            .border(4.dp, Color.Black, RoundedCornerShape(10.dp)),
                        colors = ButtonDefaults.buttonColors(Color.White),
                        shape = RoundedCornerShape(12.dp),
                        onClick = { /* Ação */ }) {
                        Text(text = "JOGAR", fontSize = 24.sp, fontFamily = Righteous, color = Color.Black,)
                    }
                    Spacer(modifier = Modifier.height(16.dp)) //ESPACO ENTRE O BOTAO JOGAR E OS OUTROS BOTOES)
                    Button(
                        modifier = Modifier
                            .height(60.dp)
                            .width(160.dp)
                            .border(4.dp, Color.Black, RoundedCornerShape(10.dp)),
                        colors = ButtonDefaults.buttonColors(Color.White),
                        shape = RoundedCornerShape(12.dp),
                        onClick = { navController.navigate("cartas") }
                    ) {
                        Text(text = "CARTAS", fontSize = 24.sp, fontFamily = Righteous, color = Color.Black,)
                    }
                    Spacer(modifier = Modifier.height(16.dp)) //ESPACO ENTRE O BOTAO JOGAR E OS OUTROS BOTOES)
                    Button(
                        modifier = Modifier
                            .height(60.dp)
                            .width(160.dp)
                            .border(4.dp, Color.Black, RoundedCornerShape(10.dp)),
                        colors = ButtonDefaults.buttonColors(Color.White),
                        shape = RoundedCornerShape(12.dp),
                        onClick = {
                            context?.finishAffinity()
                        }
                    ) {
                        Text(text = "SAIR", fontSize = 24.sp, fontFamily = Righteous, color = Color.Black)
                    }

                }
                Spacer(modifier = Modifier.height(32.dp) //ESPACO ENTRE O BOTÃO JOGAR E OS OUTROS BOTOES
                    .fillMaxWidth()
                )
            }
        }
    )
}