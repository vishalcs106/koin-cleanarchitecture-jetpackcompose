package com.android.feature_home.data

class NetworkDataSource(private val apiService: ApiService) {
    suspend fun getHtmlContent(url: String): Result<String> {
        return try{
            val response = apiService.getHtmlContent(url)
            if(response.isSuccessful){
                Result.success(response.body() ?: "")
            } else{
                Result.failure(Throwable("Unable to load html"))
            }
        } catch (e: Exception){
            Result.failure(Throwable(e))
        }
    }
}