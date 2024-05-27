package com.example.vocational_compose.presentation.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.vocational_compose.data.components.TopBar
import com.example.vocational_compose.data.components.recycleView.offer.OfferRecyclerView
import com.example.vocational_compose.presentation.viewmodel.OfferViewModel

@Composable
fun OfferShowcase(navController: NavController, viewModel: OfferViewModel) {

    Surface (
        Modifier
            .fillMaxSize()
            .padding(20.dp)
    ) {
        Column {

            TopBar(
                Modifier
                    .fillMaxWidth()
                    .padding(10.dp),
                navController,
                text= "Offerte di lavoro"
            )

            Spacer(modifier = Modifier.size(20.dp))

            OfferRecyclerView(viewModel)
        }

    }






}