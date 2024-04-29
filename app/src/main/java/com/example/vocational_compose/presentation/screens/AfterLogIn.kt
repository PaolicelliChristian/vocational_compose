package com.example.vocational_compose.presentation.screens

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.vocational_compose.data.components.NormalText


//@Preview(showBackground = true)
@Composable
fun GeneralScreen (navController: NavController) {

    Surface(
        modifier = Modifier.fillMaxSize()
    ) {
        NormalText(text = "Dopo il login", fontSize = 18.sp, fontWeight = FontWeight.Bold , modifier = Modifier )
    }

}