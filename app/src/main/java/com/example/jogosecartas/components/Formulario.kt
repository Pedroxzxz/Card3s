package com.example.jogosecartas.components

import CampoTextoComum
import android.widget.Toast
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.ClickableText
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Visibility
import androidx.compose.material.icons.filled.VisibilityOff
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController


@Composable
fun Formulario(navController: NavHostController) {

    var nome by remember { mutableStateOf("") }
    var senha by remember { mutableStateOf("") }

    var error by remember { mutableStateOf(false) }

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

            // Campo para "Nome" (texto simples)
            CampoTextoComum(
                label = "Nome",
                placeholder = "Digite seu nome",
                isPassword = false,
                value = nome,
                onValueChange = { nome = it }
            )

            CampoTextoComum(
                label = "Senha",
                placeholder = "Digite sua senha",
                isPassword = true,
                value = senha,
                onValueChange = { senha = it }
            )

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
                onClick = { navController.navigate("registro") }
            )


            Spacer(modifier = Modifier.height(16.dp))

            Button(
                onClick = { navController.navigate("menu") },
                shape = RoundedCornerShape(10.dp),
                colors = ButtonDefaults.buttonColors(Color.White),

                elevation = ButtonDefaults.buttonElevation(
                    defaultElevation = 50.dp,
                    pressedElevation = 12.dp,  // Sombras diferentes para cada estado, se quiser
                    focusedElevation = 10.dp,
                    hoveredElevation = 10.dp,
                    disabledElevation = 0.dp
                ),
                modifier = Modifier
                    .fillMaxWidth()
                    .height(50.dp)
                    .border(4.dp, Color.Black, RoundedCornerShape(10.dp)),
            ) {
                Text(
                    text = "Confirmar",
                    color = Color.Black,
                    fontSize = 18.sp
                )
            }

        }
    }
}
