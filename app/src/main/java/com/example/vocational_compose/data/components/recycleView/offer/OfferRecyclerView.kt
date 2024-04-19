package com.example.vocational_compose.data.components.recycleView.offer

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.vocational_compose.presentation.viewmodel.OfferViewModel

@Composable
fun OfferRecyclerView() {

//    val data = remember {
//        mutableListOf<UIOffer>()
//    }

    val offerViewModel: OfferViewModel = viewModel()
    val list = offerViewModel.offerList

    LazyColumn(modifier = Modifier) {

        items(count = 10) {
            list.forEach{
                OfferItem(offer = it)
            }
        }
    }


}