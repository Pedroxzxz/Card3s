package com.example.jogosecartas.components

import CampoTextoComum
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.jogosecartas.screens.RegisterScreen

@Composable
fun FormularioRegistro(navController: NavHostController){

    var nome by remember {mutableStateOf("")}
    var senha by remember { mutableStateOf("") }
    var confirmarSenha by remember { mutableStateOf("") }
    var email by remember {mutableStateOf("")}

    Box(
        modifier = Modifier.fillMaxWidth()
            .padding(16.dp)
    ){
        Column(
            modifier = Modifier
                .padding(16.dp)
                .fillMaxWidth()
        ) {
            CampoTextoComum (
                label = "Nome",
                placeholder = "Digite seu nome...",
                isPassword = false,
                value = nome,
                onValueChange = { nome = it }
            )

            CampoTextoComum (
                label = "Email",
                placeholder = "Quem sabe não te mandemos umas mensagens?",
                isPassword = false,
                value = email,
                onValueChange = { email = it }
            )

            Spacer(modifier = Modifier.height(15.dp).fillMaxWidth())

            CampoTextoComum (
                label = "Senha",
                placeholder = "Digite sua senha...",
                isPassword = true,
                value = senha,
                onValueChange = { senha = it }
            )

            Spacer(modifier = Modifier.height(15.dp).fillMaxWidth())


            CampoTextoComum (
                label = "É essa senha mesmo?",
                placeholder = "Digite sua senha...",
                isPassword = true,
                passwordIcon = false,
                value = confirmarSenha,
                onValueChange = { confirmarSenha = it }
            )

            Spacer(modifier = Modifier.height(15.dp).fillMaxWidth())


            Button(
                onClick = { navController.navigate("login")},
                shape = RoundedCornerShape(14.dp),
                elevation = ButtonDefaults.elevatedButtonElevation(
                    defaultElevation = 50.dp,
                    pressedElevation = 12.dp,  // Sombras diferentes para cada estado, se quiser
                    focusedElevation = 10.dp,
                    hoveredElevation = 10.dp,
                    disabledElevation = 0.dp
                ),
                modifier = Modifier
                    .fillMaxWidth()
                    .height(50.dp)

                ) {
                Text("Tudo Pronto!")
            }
        }


    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
private fun TelaRegisterPreview() {
    RegisterScreen(navController = rememberNavController())
}