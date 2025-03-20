package com.example.jogosecartas.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.defaultMinSize
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowLeft
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
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.jogosecartas.ui.theme.Righteous

@Composable
fun AccountRememberScreen (navController: NavHostController) {
    Box(modifier = Modifier.fillMaxSize().padding(16.dp)){

        Column (modifier = Modifier.height(80.dp), verticalArrangement = Arrangement.Center){
            IconButton(onClick = { navController.navigate("login")}) {
                Icon(
                    imageVector = Icons.Filled.KeyboardArrowLeft,
                    contentDescription = "Left Icon",
                    modifier = Modifier.size(50.dp)

                )
            }
        }

        Column(Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.Center


        ){

            Text(
                text = "Você talvez não tenha uma memoria muito boa, então deixe-nos" +
                        " refresca-la...",
                style = TextStyle(
                    fontSize = 35.sp,
                    fontWeight = FontWeight.Bold,
                    fontFamily = Righteous,
                    color = Color.Black
                ),
                modifier = Modifier.offset(2.dp, 2.dp)

            )

            Spacer(modifier = Modifier.height(70.dp))


            Column(Modifier.fillMaxWidth()){
                Text(
                    text = "Email: ",
                    fontSize = 25.sp
                )

                var email by remember { mutableStateOf("") }

                OutlinedTextField(

                    shape = RoundedCornerShape(16.dp),
                    modifier = Modifier
                        .fillMaxWidth()
                        .defaultMinSize(minHeight = 56.dp)
                        .padding(vertical = 4.dp),
                    value = email,
                    onValueChange = {email = it},
                    placeholder = {
                        Text(
                            text = "Digite o email da conta que quer recuperar!",
                            style = MaterialTheme.typography.bodyMedium
                        )
                    }

                )

                Spacer(modifier = Modifier.height(16.dp))


                Button(
                    onClick = { navController.navigate("menu") },
                    shape = RoundedCornerShape(10.dp),
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
                ){
                    Text(text = "Me manda ai esqueci memo")
                }
            }
        }
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun AccountRememberScreenPreview(){
    AccountRememberScreen(navController = rememberNavController())
}
