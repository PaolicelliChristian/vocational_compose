package com.example.vocational_compose.presentation.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.CardColors
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.vocational_compose.R
import com.example.vocational_compose.data.components.ChoiceCard
import com.example.vocational_compose.data.components.NormalText
import com.example.vocational_compose.data.components.recycleView.offer.OfferRecyclerView
import com.example.vocational_compose.navigation.Routes

@Composable
fun HomeChoiceScreen(navController: NavController) {

    Surface(
        modifier = Modifier.fillMaxSize()
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(20.dp)
        ) {

            Image(
                painter = painterResource(id = R.drawable.logo_vt_landing),
                contentDescription = "Logo",
                modifier = Modifier
//                    .padding(start = 40.dp, bottom = 20.dp)
                    .size(width = 120.dp, height = 50.dp)
            )

            ChoiceCard(
                title = "Sono utente",
                subTitle = "Cerca e trova lavoro nelle avvicinanze o da remoto",
                textColor = colorResource(id = R.color.userBlue),
                buttonColor = ButtonDefaults.buttonColors(colorResource(id = R.color.userBlue)),
                cardColor = CardColors(
                    containerColor = colorResource(id = R.color.userBlueLow),
                    contentColor = colorResource(id = R.color.trasparent),
                    disabledContainerColor = colorResource(id = R.color.trasparent),
                    disabledContentColor = colorResource(id = R.color.trasparent),
                ),
                goTo = {
                    navController.navigate(Routes.LOGIN_USER_SCREEN)
                }
            )

            Spacer(modifier = Modifier.size(40.dp))

            ChoiceCard(
                title = "Sono azienda",
                subTitle = "Crea annunci di lavoro, gestisci i candidati e tanto altro",
                textColor = colorResource(id = R.color.companyRed),
                buttonColor = ButtonDefaults.buttonColors(colorResource(id = R.color.companyRed)),
                cardColor = CardColors(
                    containerColor = colorResource(id = R.color.companyRedLow),
                    contentColor = colorResource(id = R.color.trasparent),
                    disabledContainerColor = colorResource(id = R.color.trasparent),
                    disabledContentColor = colorResource(id = R.color.trasparent),
                ),
                goTo = {
                    navController.navigate(Routes.LOGIN_COMPANY_SCREEN)
                }
            )

            Spacer(modifier = Modifier.size(30.dp))

            NormalText(
                text = "Offerte di lavoro",
                fontSize = 28.sp,
                fontWeight = FontWeight.Bold,
                modifier = Modifier
                    .fillMaxWidth(),
                textAlign = TextAlign.Start
            )

            Spacer(modifier = Modifier.size(30.dp))

            OfferRecyclerView()

//            Button(
//                onClick = { /*TODO*/ },
//                Modifier
//                    .padding(horizontal = 20.dp)
//                    .fillMaxWidth(),
//            ) {
//                Text(
//                    text = "Vedi tutte le offerte"
//                )
//            }


        }

    }

}



