package com.example.vocational_compose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.vocational_compose.navigation.NavigationGraph
import com.example.vocational_compose.presentation.viewmodel.OfferViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val offerViewModel = hiltViewModel<OfferViewModel>()
            AppEntryPoint(offerViewModel)
        }
    }
}


@Composable
fun AppEntryPoint(viewModel: OfferViewModel) {
    NavigationGraph(viewModel)
}
