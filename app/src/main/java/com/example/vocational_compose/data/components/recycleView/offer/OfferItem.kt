package com.example.vocational_compose.data.components.recycleView.offer

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.Divider
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.vocational_compose.R
import com.example.vocational_compose.data.components.NormalText
import com.example.vocational_compose.data.model.UIOffer

//@Preview(showBackground = true)
@Composable
fun OfferItem(offer: UIOffer) {
    Box(
        Modifier
            .fillMaxWidth()
    ) {
        Column {

            Row(
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier.fillMaxWidth()
            ) {
                Column(
                    Modifier
                        .fillMaxWidth()
                        .weight(0.7f)
                ) {
                    NormalText(
                        text = offer.title,
                        fontSize = 14.sp,
                        fontWeight = FontWeight.SemiBold,
                        modifier = Modifier.fillMaxWidth(),
                        textColor = colorResource(id = R.color.userBlue),
                    )
                    NormalText(
                        text = offer.company.companyName,
                        fontSize = 12.sp,
                        fontWeight = FontWeight.Normal,
                        modifier = Modifier.fillMaxWidth(),
                        textColor = colorResource(id = R.color.grey)
                    )

                    Row {
                        Column(
                            Modifier
                                .fillMaxWidth()
                                .weight(0.5f)
                        ) {
                            NormalText(
                                text = offer.insertMode,
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
                        Column(
                            Modifier
                                .fillMaxWidth()
                                .weight(0.5f)
                        ) {
                            NormalText(
                                text = offer.impegnoRichiesto,
                                fontSize = 12.sp,
                                fontWeight = FontWeight.Normal,
                                modifier = Modifier
                            )
                            NormalText(
                                text = offer.workSector,
                                fontSize = 12.sp,
                                fontWeight = FontWeight.Normal,
                                modifier = Modifier
                            )
                        }
                    }
                }


                Image(
                    painter = painterResource(id = R.drawable.logo_vt_landing),
                    contentDescription = "Logo",
                    modifier = Modifier
                        .fillMaxWidth()
                        .weight(0.3f)
                )
            }
            Button(
                onClick = { /*TODO*/ },
                Modifier
                    .fillMaxWidth()
                    .padding(vertical = 10.dp),
                shape = RoundedCornerShape(1.dp)
            ) {
                Text(
                    text = "Candidati >"
                )

            }

            Divider(
                thickness = 1.dp,
                color = colorResource(id = R.color.deepBlue),
            )
        }


    }


}

