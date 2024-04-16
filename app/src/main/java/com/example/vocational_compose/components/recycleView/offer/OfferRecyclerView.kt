package com.example.vocational_compose.components.recycleView.offer

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

@Composable
fun OfferRecyclerView(names: List<String> = List(10) { "$it" }) {

//    val data = remember {
//        mutableListOf<UIOffer>()
//    }

    LazyColumn(modifier = Modifier) {

        items(count = 10) {
            OfferItem()
        }
    }


}