package com.example.vocational_compose.retrofit

import com.example.vocational_compose.data.model.offer.UIOffer
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import okio.IOException
import retrofit2.HttpException
import javax.inject.Inject

class OffersRepositoryImpl @Inject constructor(
    private val offerApi: OfferApi
) : OffersRepository {
    override suspend fun getOffersList(): Flow<Result<List<UIOffer>>> {
        return flow {
            val offersFromApi = try {
                offerApi.getOfferList()

            } catch (e: IOException) {
                e.printStackTrace()
                emit(Result.Error(null, message = "Error loading offers"))
                return@flow
            } catch (e: HttpException) {
                e.printStackTrace()
                emit(Result.Error(null, message = "Error loading offers"))
                return@flow
            } catch (e: Exception) {
                e.printStackTrace()
                emit(Result.Error(null, message = "Error loading offers"))
                return@flow
            }

            emit(Result.Success(offersFromApi.elements))
        }

    }

}