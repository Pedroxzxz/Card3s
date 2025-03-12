@file:OptIn(ExperimentalMaterial3Api::class)

package com.example.jogosecartas

import android.R.attr.onClick
import android.os.Bundle
import android.widget.Space
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
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
import androidx.compose.foundation.text.ClickableText
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.jogosecartas.ui.theme.JogosECartasTheme
import com.example.jogosecartas.ui.theme.Righteous
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            JogosECartasTheme {
                AppNavigation()
            }
        }
    }
}

@Composable
fun AppNavigation() {
    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = "tela_principal") {
        composable("tela_principal") { TelaPrincipal(navController) }
        composable("segunda_tela") { SegundaTela(navController) }
    }
}

@Composable
fun TelaPrincipal(navController: NavHostController) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Titulo()
        Formulario(navController)
    }
}

@ExperimentalMaterial3Api
@Composable
fun SegundaTela(navController: NavHostController) {
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
                    onClick = { navController.navigate("tela_principal") },
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
                        onClick = { /* Ação */ }
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

@Composable
fun Titulo() {
    Box {
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

        Text(
            text = "Card3s",
            style = TextStyle(
                fontSize = 40.sp,
                fontWeight = FontWeight.Bold,
                fontFamily = Righteous,
                color = Color(0xFFFFA500)
            )
        )
    }
}

@Composable
fun Formulario(navController: NavHostController) {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp)
    ) {
        Column(
            modifier = Modifier
                .padding(16.dp)
                .fillMaxWidth(),
            verticalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            CampoTexto(label = "Nome")
            CampoTexto(label = "E-mail")

            val context = LocalContext.current

            val annotatedString = buildAnnotatedString {
                append("Se não tiver uma conta ")
                pushStringAnnotation(tag = "link", annotation = "criar_conta")
                withStyle(
                    style = SpanStyle(
                        fontWeight = FontWeight.Bold,
                        color = Color.Blue,
                        textDecoration = TextDecoration.Underline
                    )
                ) {
                    append("crie uma!")
                }
                pop()
            }

            ClickableText(
                text = annotatedString,
                onClick = { offset ->
                    annotatedString.getStringAnnotations(tag = "link", start = offset, end = offset)
                        .firstOrNull()?.let {
                            Toast.makeText(context, "Você clicou em criar conta!", Toast.LENGTH_SHORT).show()
                        }
                }
            )

            Spacer(modifier = Modifier.height(16.dp))
            Button(
                onClick = { navController.navigate("segunda_tela") },
                modifier = Modifier.fillMaxWidth().size(50.dp),
                shape = RoundedCornerShape(10.dp)
            ) {
                Text(text = "Confirmar")
            }
        }
    }
}

@Composable
fun CampoTexto(label: String) {
    var texto by remember { mutableStateOf("") }

    Spacer(modifier = Modifier.height(8.dp))

    Text(text = label, style = MaterialTheme.typography.titleMedium)

    OutlinedTextField(
        value = texto,
        onValueChange = { texto = it },
        shape = RoundedCornerShape(10.dp),
        modifier = Modifier
            .fillMaxWidth()
            .height(56.dp)
            .padding(vertical = 4.dp),
        colors = OutlinedTextFieldDefaults.colors(
            focusedBorderColor = Color(0xFFFFA500),
            unfocusedBorderColor = Color.Gray
        )
    )
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
private fun TelaInicialPreview() {
    val navController = rememberNavController()
    SegundaTela(navController)
}
