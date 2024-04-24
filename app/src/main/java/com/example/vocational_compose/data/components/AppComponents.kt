package com.example.vocational_compose.data.components


import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Lock
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.CardColors
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.OutlinedCard
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Switch
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.vocational_compose.R
import com.example.vocational_compose.navigation.Routes


@Composable
fun NormalText(
    text: String = "",
    fontSize: TextUnit,
    textColor: Color = Color.Black,
    fontWeight: FontWeight,
    modifier: Modifier,
    textAlign: TextAlign = TextAlign.Start
) {
    Text(
        text = text,
        fontWeight = fontWeight,
        color = textColor,
        fontSize = fontSize,
        modifier = modifier,
        textAlign = textAlign
    )
}

@Composable
fun NormalButton(color: ButtonColors, goTo: () -> Unit) {
    Button(
        modifier = Modifier
            .fillMaxWidth(),
        shape = RoundedCornerShape(1.dp),
        colors = color,

        onClick = {
            goTo()
        }) {
        Text(
            text = "Scegli >"
        )

    }
}

@Composable
fun ChoiceCard(
    title: String,
    subTitle: String,
    textColor: Color,
    buttonColor: ButtonColors,
    goTo: () -> Unit,
    cardColor: CardColors
) {
    OutlinedCard(
        border = BorderStroke(1.dp, Color.Gray),
        colors = cardColor,
        shape = RoundedCornerShape(0.dp),
    ) {

        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.spacedBy(20.dp),
            modifier = Modifier.padding(28.dp)
        ) {
            NormalText(
                text = title,
                fontSize = 24.sp,
                fontWeight = FontWeight.Bold,
                textColor = textColor,
                modifier = Modifier
                    .fillMaxWidth(),
                textAlign = TextAlign.Center
            )

            NormalText(
                text = subTitle,
                fontSize = 16.sp,
                fontWeight = FontWeight.Light,
                modifier = Modifier
                    .padding(start = 40.dp, end = 40.dp),
                textAlign = TextAlign.Center
            )

            NormalButton(
                color = buttonColor,
                goTo
            )
        }
    }
}

//@Composable
//fun ChoiceCompanyCard(
//    textColor: Color,
//    buttonColor: ButtonColors
//) {
//    OutlinedCard(
//        border = BorderStroke(1.dp, Color.Gray),
//        colors = CardDefaults.cardColors(
//            containerColor = MaterialTheme.colorScheme.surfaceVariant
//        ),
//        shape = RoundedCornerShape(0.dp),
//    ) {
//
//        Column(
//            horizontalAlignment = Alignment.CenterHorizontally,
//            verticalArrangement = Arrangement.spacedBy(20.dp),
//            modifier = Modifier.padding(28.dp)
//        ) {
//            NormalText(
//                text = "Sono utente",
//                fontSize = 24.sp,
//                fontWeight = FontWeight.Bold,
//                textColor = textColor,
//                modifier = Modifier
//                    .fillMaxWidth(),
//                textAlign = TextAlign.Center
//            )
//
//            NormalText(
//                text = "Cerca e trova lavoro nelle vicinanze o da remoto",
//                fontSize = 16.sp,
//                fontWeight = FontWeight.Light,
//                modifier = Modifier
//                    .padding(start = 40.dp, end = 40.dp),
//                textAlign = TextAlign.Center
//            )
//
//            NormalButton(
//                color = buttonColor
//            )
//        }
//    }
//}

@Composable
fun TopBar(
    modifier: Modifier,
    navController: NavController

) {
    Row(
        modifier = modifier,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Image(
            painter = painterResource(id = R.drawable.baseline_arrow_back_24),
            contentDescription = "GoBack arrow",
            Modifier.clickable(
                onClick = {
                    navController.navigate(Routes.HOME_CHIOCE_SCREEN)
                }
            )
        )

        Spacer(modifier = Modifier.weight(1f))

        NormalText(
            text = "Login",
            fontSize = 28.sp,
            fontWeight = FontWeight.Bold,
            modifier = Modifier
        )

        Spacer(modifier = Modifier.weight(0.5f))

        Image(
            painter = painterResource(id = R.drawable.vt_loginlogo),
            contentDescription = "Logo",
            modifier = Modifier
                .size(width = 100.dp, height = 40.dp)
                .padding(5.dp)
        )
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun EmailFieldComponent(modifier: Modifier) {
    var text by remember { mutableStateOf("") }

    Column() {
        Text(
            text = "Email",
            fontSize = 14.sp,
            fontWeight = FontWeight.Bold,
            modifier = Modifier
                .padding(start = 20.dp, bottom = 10.dp),
        )

        TextFieldComposable().OutlinedTextField(
            modifier = modifier,
            placeholderText = "Inserire l'email",
            imeAction = ImeAction.Next,
            colors = OutlinedTextFieldDefaults.colors(
                focusedBorderColor = Color.Transparent,
                unfocusedBorderColor = Color.Transparent,
                focusedContainerColor = Color.Transparent,
                cursorColor = colorResource(id = R.color.black),
            ),

            onValueChange = {
            },
            onErrorListener = {
            },
            startIcon = Icons.Filled.Email
        )
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun PasswordFieldComponent(modifier: Modifier) {
    var password by rememberSaveable { mutableStateOf("") }

    Column(
    ) {
        Text(
            text = "Password",
            fontSize = 14.sp,
            fontWeight = FontWeight.Bold,
            modifier = Modifier
                .padding(start = 20.dp, bottom = 10.dp, top = 10.dp),
        )

        TextFieldComposable().OutlinedPasswordTextField(
            modifier = modifier,
            placeholderText = "Inserire la password",
            imeAction = ImeAction.Next,
            colors = OutlinedTextFieldDefaults.colors(
                focusedBorderColor = Color.Transparent,
                unfocusedBorderColor = Color.Transparent,
                focusedContainerColor = Color.Transparent,
                cursorColor = colorResource(id = R.color.black),
            ),
//            visualTransformation = PasswordVisualTransformation(),
//            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password),

            onValueChange = {
            },
            onErrorListener = {
            },
            startIcon = Icons.Filled.Lock
        )

    }
}

@Composable
fun SwitchMinimal() {
    var checked by remember { mutableStateOf(true) }

    Switch(
        checked = checked,
        onCheckedChange = {
            checked = it
        },
//        colors = SwitchColors(colorResource(id = R.color.companyRed)),
    )
}


@Preview(showBackground = true)
@Composable
fun GeneralPreview() {

    SwitchMinimal()

}

