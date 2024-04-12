package com.example.vocational_compose.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.vocational_compose.R

@Preview(showBackground = true)
@Composable
fun OfferItem() {

    Box(
        modifier = Modifier
            .fillMaxSize()
    ) {
        Row {

            Column {
                NormalText(
                    text = "Offer.Title",
                    fontSize = 14.sp,
                    fontWeight = FontWeight.SemiBold,
                    modifier = Modifier,
                    textColor = colorResource(id = R.color.userBlue),
                )
                NormalText(
                    text = "CompanyName",
                    fontSize = 12.sp,
                    fontWeight = FontWeight.Normal,
                    modifier = Modifier,
                    textColor = colorResource(id = R.color.grey)
                )
                NormalText(
                    text = "Offer.InsertMode",
                    fontSize = 12.sp,
                    fontWeight = FontWeight.Normal,
                    modifier = Modifier
                )
                NormalText(
                    text = "Location.City",
                    fontSize = 12.sp,
                    fontWeight = FontWeight.Normal,
                    modifier = Modifier
                )

            }

            Image(
                painter = painterResource(id = R.drawable.logo_vt_landing),
                contentDescription = "Logo",
                modifier = Modifier
//                    .padding(start = 40.dp, bottom = 20.dp)
                    .size(width = 120.dp, height = 50.dp)
            )


        }

    }


}

