package com.example.jogosecartas.components

import androidx.compose.foundation.layout.Row
import androidx.compose.material3.Checkbox
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.unit.sp
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.rememberNavController
import com.example.jogosecartas.screens.LoginScreen


@Composable
fun RememberAccountSelect() {
   Row(verticalAlignment = Alignment.CenterVertically) {
       Text(
           text = "Me mantenha logado ",
           fontSize = (14.sp)
       )

       var checkedState by remember { mutableStateOf(false) }

       Checkbox(
           checked = checkedState,
           onCheckedChange = { checkedState = it }
       )
   }


}

@Preview(showBackground = true, showSystemUi = true)
@Composable
private fun TelaLoginPreview() {
    LoginScreen(navController = rememberNavController())
}