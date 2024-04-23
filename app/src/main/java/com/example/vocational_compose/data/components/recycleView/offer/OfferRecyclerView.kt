package com.example.vocational_compose.data.components.recycleView.offer

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.vocational_compose.presentation.viewmodel.OfferViewModel


@Composable
fun OfferRecyclerView() {

    val viewModel = hiltViewModel<OfferViewModel>()
    val list = viewModel.products.collectAsState().value

    //si può dichiarare anche così
    val viewModelTest: OfferViewModel = hiltViewModel()
    val secondList= viewModelTest.products.collectAsState()

    LazyColumn(modifier = Modifier) {

        items(count = 10) {
            list.forEach{
                OfferItem(offer = it)
            }
        }
    }


}