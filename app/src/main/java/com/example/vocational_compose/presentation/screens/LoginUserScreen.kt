package com.example.vocational_compose.presentation.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.IntrinsicSize
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Divider
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Alignment.Companion.CenterHorizontally
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.vocational_compose.MainActivity
import com.example.vocational_compose.R
import com.example.vocational_compose.data.components.EmailFieldComponent
import com.example.vocational_compose.data.components.NormalText
import com.example.vocational_compose.data.components.PasswordFieldComponent
import com.example.vocational_compose.data.components.SwitchMinimal
import com.example.vocational_compose.data.components.TopBar
import com.example.vocational_compose.navigation.Routes
import com.example.vocational_compose.presentation.viewmodel.LoginViewModel

@Composable
fun LoginUserScreen(
    navController: NavController,
    loginViewModel: LoginViewModel,
    mainActivity: MainActivity
) {
    val context = LocalContext.current

    loginViewModel.state.observe(mainActivity) {
        navController.navigate(Routes.AFTER_SCREEN)
    }


    val email = remember {
        mutableStateOf("")
    }


    val password = remember {
        mutableStateOf("")
    }

    Surface(
        modifier = Modifier
            .fillMaxSize()
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .verticalScroll(rememberScrollState())
                .height(IntrinsicSize.Max)
        ) {
            TopBar(
                Modifier
                    .fillMaxWidth()
                    .padding(10.dp),
                navController,
                text = "Login"
            )

            Divider(
                thickness = 1.dp
            )

            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .background(
                        colorResource(id = R.color.userBlueLow),
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
                        ),
                    onValueChange = {
                        email.value = it
                    }
                )


                PasswordFieldComponent(
                    modifier = Modifier
                        .padding(horizontal = 15.dp)
                        .fillMaxWidth()
                        .background(
                            colorResource(id = R.color.white)
                        ),
                    onValueChange = {
                        password.value = it
                    }
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
                    colors = ButtonDefaults.buttonColors(colorResource(id = R.color.userBlue)),
                    shape = RoundedCornerShape(1.dp),
                    onClick = {
                        loginViewModel.getUserLogin(
                            email.value,
                            password.value,
                            "user"
                        )


                    }) {
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

                //Spinge giu
                Spacer(modifier = Modifier.weight(1f))

                Image(
                    painter = painterResource(id = R.drawable.vt_footerlogo),
                    contentDescription = "Logo",
                    modifier = Modifier
//                        .size(width = 100.dp, height = 40.dp)
                        .align(CenterHorizontally)
                )

                NormalText(
                    text = "Vocational Training s.r.l.  ©",
                    fontSize = 18.sp,
                    fontWeight = FontWeight.Light,
                    modifier = Modifier
                        .align(CenterHorizontally)
                        .padding(5.dp)
                )

                NormalText(
                    text = "· IVA 01091950772 · CCIAA Matera REA n°71990 del 10/12/2003 · Privacy",
                    fontSize = 14.sp,
                    fontWeight = FontWeight.Light,
                    textColor = colorResource(id = R.color.greyText),
                    textAlign = TextAlign.Center,
                    modifier = Modifier
                        .align(CenterHorizontally)
                        .padding(5.dp, bottom = 5.dp)

                )
            }
        }
    }
}

//Column(
//modifier = Modifier
//.fillMaxWidth()
//.weight(0.9f),
//verticalArrangement = Arrangement.Center,
//horizontalAlignment = Alignment.CenterHorizontally
//) {
//    TextFieldComposable().OutlinedTextField(
//        modifier = Modifier
//            .fillMaxWidth()
//            .background(
//                colorResource(id = R.color.teal_200),
//                shape = MaterialTheme.shapes.small
//            ),
//        initText = "deviceName",
//        placeholderText = "stringResource(id = R.string.insert_device_name)",
//        placeholderTextStyle = TextStyle(
//            fontSize = 16.sp,
////                            fontFamily = FontFamily(Font(R.font.roboto)),
//            fontWeight = FontWeight.W400,
//            color = colorResource(id = R.color.white),
//        ),
//        imeAction = ImeAction.Next,
//        colors = OutlinedTextFieldDefaults.colors(
//            focusedBorderColor = Color.Transparent,
//            unfocusedBorderColor = Color.Transparent,
//            focusedContainerColor = Color.Transparent,
//            cursorColor = colorResource(id = R.color.black),
//        ),
//        shape = MaterialTheme.shapes.small,
//        textStyle = TextStyle(
//            fontSize = 16.sp,
////                            fontFamily = FontFamily(Font(R.font.roboto)),
//            fontWeight = FontWeight.W400,
//            color = colorResource(id = R.color.purple_200),
//        ),
//        onValueChange = {
////                            saveButtonEnable.value = true
////                            deviceName = it
//        },
//        onErrorListener = {
////                            if (it) {
////                                saveButtonEnable.value = false
////                            }
//        }
//    )
//}


