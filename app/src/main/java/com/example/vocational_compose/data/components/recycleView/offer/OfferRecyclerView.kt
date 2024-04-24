package com.example.vocational_compose.data.components.recycleView.offer

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import com.example.vocational_compose.presentation.viewmodel.OfferViewModel


@Composable
fun OfferRecyclerView(viewModel: OfferViewModel) {

    //https://youtu.be/LFlobqW8Sy8?t=4920
    val list = viewModel.products.collectAsState().value

    LazyColumn(modifier = Modifier) {

        items(count = 10) {
            list.forEach{
                OfferItem(offer = it)
            }

        }
    }

}