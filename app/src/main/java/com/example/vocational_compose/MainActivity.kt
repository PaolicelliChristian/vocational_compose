package com.example.vocational_compose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.Composable
import com.example.vocational_compose.navigation.NavigationGraph
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
//            val offerViewModel = hiltViewModel<OfferViewModel>()
            AppEntryPoint()
        }
    }
}


@Composable
fun AppEntryPoint() {
    NavigationGraph()
}
