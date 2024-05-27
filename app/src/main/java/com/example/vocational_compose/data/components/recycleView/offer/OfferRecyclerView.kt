package com.example.vocational_compose.data.components.recycleView.offer

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import com.example.vocational_compose.presentation.viewmodel.OfferViewModel


@Composable
fun OfferRecyclerView(viewModel: OfferViewModel) {

    val list = viewModel.products.collectAsState().value

    LazyColumn(modifier = Modifier) {

        items(count = 20) {
            list.forEach{
                OfferItem(offer = it)
            }

        }
    }

}