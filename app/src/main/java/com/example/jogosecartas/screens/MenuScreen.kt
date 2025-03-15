package com.example.jogosecartas.screens

import androidx.compose.foundation.background
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
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.example.jogosecartas.components.Titulo
import com.example.jogosecartas.ui.theme.Righteous

@Composable
fun MenuScreen(navController: NavHostController) {
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
                        tint = Color(0xFFFFA500),
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
        bottomBar = {
            BottomAppBar { Text("Barra Inferior") }
        },
        floatingActionButton = {
            FloatingActionButton(onClick = { /* Ação */ }) {
                Icon(Icons.Default.Add, contentDescription = "Adicionar")
            }
        },
        //CONTEUDO DO MENU!!!
        // DEIXEI AS CORES ASSIM PRA SABER OS ESPACAMENTOS DE CADA ELEMENTO QUE EU COLOCAR
        // PODE FAZER A ESTILIZACAO DO JEITO QUE QUISER AI
        content = { paddingValues ->
            Column(modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues)
                .background(Color.Black) //Cor da Coluna Principal
            ) {

                Spacer(modifier = Modifier.height(64.dp) //ESPACO ENTRE A BARRA SUPERIOR E O BOTÃO JOGAR
                    .fillMaxWidth()
                    .background(Color.Red))

                Row(modifier = Modifier //PRIMEIRA ROW - BOTAO JOGAR
                    .fillMaxWidth()
                    .background(Color.Green)
                    .size(120.dp),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.Center
                ) {
                    Button(
                        modifier = Modifier
                            .width(240.dp) // Distribui espaço automaticamente
                            .height(80.dp), // Altura fixa, mas sem largura fixa
                        shape = RoundedCornerShape(10.dp),
                        onClick = { /* Ação */ }) {
                        Text(text = "JOGAR", fontSize = 32.sp, fontFamily = Righteous)
                    }
                }


                Spacer(modifier = Modifier.height(32.dp) //ESPACO ENTRE O BOTÃO JOGAR E OS OUTROS BOTOES
                    .fillMaxWidth()
                    .background(Color.Red))

                Row(    //SEGUNDA ROW
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(100.dp) // Melhor que size(100.dp)
                        .background(Color.Yellow)
                        .padding(horizontal = 16.dp), // Espaçamento lateral
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.SpaceEvenly // Distribuição mais equilibrada
                ) {
                    Button(
                        modifier = Modifier
                            .weight(1f) // Distribui espaço automaticamente
                            .height(60.dp), // Altura fixa, mas sem largura fixa
                        shape = RoundedCornerShape(10.dp),
                        onClick = { navController.navigate("cartas") }
                    ) {
                        Text(text = "CARTAS", fontSize = 28.sp, fontFamily = Righteous)
                    }

                    Spacer(modifier = Modifier.width(16.dp)) // Espaço entre os botões cartas e sair

                    Button(
                        modifier = Modifier
                            .weight(1f) // Mesmo peso para manter alinhado
                            .height(60.dp),
                        shape = RoundedCornerShape(10.dp),
                        onClick = { /* Ação */ }
                    ) {
                        Text(text = "SAIR", fontSize = 28.sp, fontFamily = Righteous)
                    }
                }
            }
        }
    )
}