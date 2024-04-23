package com.example.vocational_compose.data.components.recycleView.offer

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.vocational_compose.presentation.viewmodel.OfferViewModel


@Composable
fun OfferRecyclerView() {

//    private val viewModel by viewModels<OffersViewModel>(factoryProducer = {
//        object : ViewModelProvider.Factory {
//            override fun <T : ViewModel> create(modelClass: Class<T>): T {
//                return OffersViewModel(OffersRepositoryImpl(RetrofitInstance.api))
//                        as T
//            }
//        }
//   })
//
//
//
//    val offerViewModelDELETE: OfferViewModelDELETE = viewModel()
//    val list = offerViewModelDELETE.offerList

    val viewModel = hiltViewModel<OfferViewModel>()
    val list = viewModel.products.value

    LazyColumn(modifier = Modifier) {

        items(count = 10) {
            list.forEach{
                OfferItem(offer = it)
            }
        }
    }


}