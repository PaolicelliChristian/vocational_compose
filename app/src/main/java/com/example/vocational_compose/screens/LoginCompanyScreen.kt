package com.example.vocational_compose.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Divider
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.vocational_compose.R
import com.example.vocational_compose.components.EmailFieldComponent
import com.example.vocational_compose.components.NormalText
import com.example.vocational_compose.components.PasswordFieldComponent
import com.example.vocational_compose.components.SwitchMinimal
import com.example.vocational_compose.components.TopBar

@Composable
fun LoginCompanyScreen(navController: NavController){
    Surface(
        modifier = Modifier.fillMaxSize()
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
        ) {
            TopBar(
                Modifier
                    .fillMaxWidth()
                    .padding(10.dp),
                navController
            )

            Divider(
                thickness = 1.dp
            )

            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .background(
                        colorResource(id = R.color.companyRedLow),
                    )
            ) {
                NormalText(
                    text = "Inserisci le tue credenziali per entrare",
                    fontSize = 16.sp,
                    fontWeight = FontWeight.Light,
                    modifier = Modifier
                        .padding(start = 15.dp, bottom = 20.dp, top = 20.dp)
                )

                Divider(
                    thickness = 1.dp,
                    color = colorResource(id = R.color.deepBlue)
                )

                NormalText(
                    text = "Non hai un account? Registrati>",
                    fontSize = 16.sp,
                    fontWeight = FontWeight.Light,
                    modifier = Modifier
                        .padding(start = 15.dp, bottom = 20.dp, top = 20.dp)
                )

                Divider(
                    thickness = 1.dp,
                    color = colorResource(id = R.color.deepBlue),
                    modifier = Modifier.padding(bottom = 20.dp)
                )

                EmailFieldComponent(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 15.dp)
                        .background(
                            colorResource(id = R.color.white),
                        )
                )


                PasswordFieldComponent(
                    modifier = Modifier
                        .padding(horizontal = 15.dp)
                        .fillMaxWidth()
                        .background(
                            colorResource(id = R.color.white)
                        )
                )


                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    modifier = Modifier
                        .padding(vertical = 10.dp, horizontal = 15.dp)
                        .fillMaxWidth()
                ) {
                    SwitchMinimal()
                    Text(text = "Ricorda sessione", Modifier.padding(start = 10.dp))
                }

                Button(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 15.dp),
                    colors = ButtonDefaults.buttonColors(colorResource(id = R.color.companyRed)),
                    shape = RoundedCornerShape(1.dp),
                    onClick = { /*TODO*/ }) {
                    Text(
                        text = "V Accedere"
                    )

                }

                NormalText( //da farlo link
                    text = "Non ricordi le tue credenziali?",
                    fontSize = 14.sp,
                    fontWeight = FontWeight.Light,
                    modifier = Modifier
                        .padding(15.dp)
                )

                Image(
                    painter = painterResource(id = R.drawable.vt_footerlogo),
                    contentDescription = "Logo",
                    modifier = Modifier
//                        .size(width = 100.dp, height = 40.dp)
                        .align(Alignment.CenterHorizontally)
                )

                NormalText(
                    text = "Vocational Training s.r.l.  ©",
                    fontSize = 14.sp,
                    fontWeight = FontWeight.Light,
                    modifier = Modifier
                        .align(Alignment.CenterHorizontally)
                        .padding(5.dp)
                )
            }
        }
    }

}