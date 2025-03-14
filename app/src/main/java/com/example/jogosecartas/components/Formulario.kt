package com.example.jogosecartas.components

import android.widget.Toast
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
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController

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
                onClick = { navController.navigate("menu") },
                modifier = Modifier.fillMaxWidth().size(50.dp),
                shape = RoundedCornerShape(10.dp)
            ) {
                Text(text = "Confirmar")
            }
        }
    }
}