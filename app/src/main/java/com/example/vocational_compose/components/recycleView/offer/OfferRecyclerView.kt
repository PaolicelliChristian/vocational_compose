package com.example.vocational_compose.components.recycleView.offer

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.example.vocational_compose.viewmodel.OfferViewModel

@Composable
fun OfferRecyclerView(offerViewModel: OfferViewModel) {

//    val data = remember {
//        mutableListOf<UIOffer>()
//    }


    val list = offerViewModel.offerList



    LazyColumn(modifier = Modifier) {

        items(count = 10) {
            list.forEach{
                OfferItem(offer = it)
            }
        }
    }


}