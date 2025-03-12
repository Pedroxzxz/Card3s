package com.example.jogosecartas

import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
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
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.ClickableText
import androidx.compose.material3.Button
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
import com.example.jogosecartas.ui.theme.JogosECartasTheme
import com.example.jogosecartas.ui.theme.Righteous


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            JogosECartasTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    TelaPrincipal(modifier = Modifier.padding(innerPadding))
                }
            }
        }
    }
}

@Composable
fun TelaPrincipal(modifier: Modifier = Modifier) {
    Column(
        modifier = modifier
            .fillMaxSize()
            .padding(16.dp), // Espaço ao redor da tela
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Titulo()
        Formulario()
    }
}

@Composable

fun Titulo() {

    Box {
        // Texto de contorno preto (leve deslocamento para cada direção)
        Text(
            text = "Card3sa",
            style = TextStyle(
                fontSize = 40.sp,
                fontWeight = FontWeight.Bold,
                fontFamily = Righteous,
                color = Color.Black // Cor do conto3rno

            ),
            modifier = Modifier.offset(2.dp, 2.dp)
        )

        // Texto branco por cima
        Text(
            text = "Card3s",
            style = TextStyle(
                fontSize = 40.sp,
                fontWeight = FontWeight.Bold,
                fontFamily = Righteous,
                color = Color(0xFFFFA500) // Cor principal do texto

            )
        )
    }
}





@Composable
fun Formulario(){
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp),

    ) {
        Column(
            modifier = Modifier
                .padding(16.dp)
                .fillMaxWidth(),
            verticalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            CampoTexto(label = "Nome")
            CampoTexto(label = "E-mail")

            val context = LocalContext.current // Obtém o contexto correto

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

            BotaoConfirmar()

        }




    }

}

@Composable
fun CampoTexto(label: String) {
    var texto by remember { mutableStateOf("") }

    Spacer(modifier = Modifier.height(8.dp))

    // Exibe o rótulo acima do campo
    Text(text = label, style = MaterialTheme.typography.titleMedium)

    Box(
        modifier = Modifier
            .fillMaxWidth()
            .height(56.dp) // Ajusta a altura do campo
            .padding(vertical = 4.dp)
    ) {
        OutlinedTextField(
            value = texto,
            onValueChange = { texto = it },
            shape = RoundedCornerShape(10.dp),
            modifier = Modifier.fillMaxSize(),
            colors = OutlinedTextFieldDefaults.colors(
                focusedBorderColor = Color(0xFFFFA500), // Borda ao focar
                unfocusedBorderColor = Color.Gray // Borda padrão
            )
        )
    }
}




@Composable
fun BotaoConfirmar() {

    Spacer(modifier = Modifier.height(16.dp))

    Button(
        onClick = { /* Ação do botão */ },
        modifier = Modifier
            .fillMaxWidth()
            .size(50.dp),
        shape = RoundedCornerShape(10.dp)


        ) {
        Text(text = "Confirmar")
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
private fun TelaInicialPreview() {
    TelaPrincipal()
}