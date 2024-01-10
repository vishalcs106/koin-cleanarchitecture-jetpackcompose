package com.android.feature_home.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.android.core.ui.UIState
import com.android.feature_home.Constants
import com.android.feature_home.domain.usecases.GetHtmlContentUseCase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.SupervisorJob
import kotlinx.coroutines.async
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import java.util.Locale
import kotlin.coroutines.CoroutineContext

class HomeViewModel(private val getHtmlContentUseCase: GetHtmlContentUseCase): ViewModel() {

    private val _uiState = MutableStateFlow<UIState<HomeUiModel>>(UIState.Initial)
    val uiState: StateFlow<UIState<HomeUiModel>> = _uiState

    private val supervisorJob = SupervisorJob()
    private val coroutineContext: CoroutineContext
        get() = Dispatchers.Main + supervisorJob

    fun loadHtmlContent(){
        _uiState.value = UIState.Loading
        viewModelScope.launch(coroutineContext) {
            val result = getHtmlContentUseCase.execute(Constants.URL)
            result.onSuccess {content ->
                launch {
                    val task1 = async(Dispatchers.IO) { findFifteenthChar(content) }
                    val task2 = async(Dispatchers.IO) { findEveryFifteenthCharacter(content) }
                    val task3 = async(Dispatchers.IO) { findWordOccurrence(content) }
                    val result1 = task1.await()
                    val result2 = task2.await()
                    val result3 = task3.await()
                    _uiState.value = UIState.Success(HomeUiModel(result1, result2, result3))
                }
            }
            result.onFailure {
                _uiState.value = UIState.Error("Unable to load html")
            }
        }
    }

    private fun findFifteenthChar(input: String): String{
        return if (input.length >= 15) {
            input[14].toString()
        } else {
            "Error: The input string is too short."
        }
    }

    private fun findEveryFifteenthCharacter(input: String): List<String>{
        val resultList = mutableListOf<String>()
        try{
            for (i in 14 until input.length step 15) {
                resultList.add(input[i].toString())
            }
        }catch (e: Exception){
            e.printStackTrace()
        }
        return resultList
    }

    private fun findWordOccurrence(input: String): Map<String, Int> {
        val words = input.split("\\s+".toRegex()).map { it.trim().lowercase(Locale.ROOT) }
        return words.groupingBy { it }.eachCount()
    }

    override fun onCleared() {
        super.onCleared()
        supervisorJob.cancel()
    }
}