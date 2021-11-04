package com.imaginato.homeworkmvp.data.remote.demo

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn

class DemoDataRepository constructor(
    private var api: DemoApi
) : DemoRepository {
    companion object {
        private const val URL_GET_PUBLIC_IP = "https://ifconfig.me/all.json"
        private const val NOTHING_GET = "Nothing get!"
    }

    override suspend fun getDemoData() = flow {
        val response = api.getDemoDataAsync(URL_GET_PUBLIC_IP).await()
        emit(response.ipAddress ?: NOTHING_GET)
    }.flowOn(Dispatchers.IO).catch {
        // can handle exception here
//        it is SocketTimeoutException
//        it.message?.let {
//            emit(it)
//        }
    }
}