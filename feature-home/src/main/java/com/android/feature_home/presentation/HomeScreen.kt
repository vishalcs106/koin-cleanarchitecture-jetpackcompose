package com.android.feature_home.presentation


import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.android.core.ui.UIState
import org.koin.androidx.compose.koinViewModel


@Composable
fun HomeScreen(viewModel: HomeViewModel = koinViewModel()) {

    val uiState by viewModel.uiState.collectAsState(
        initial = HomeUiModel("", emptyList(), emptyMap())
    )

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Spacer(modifier = Modifier.height(16.dp))
        Button(onClick = {
            viewModel.loadHtmlContent()
        }) {
            Text(text = "Load Html")
        }
        when(uiState){
            is UIState.Loading -> {
                Text(text = "Loading...")
            }
            is UIState.Success<*> -> {
                val homeUiModel = (uiState as UIState.Success<*>).data as HomeUiModel
                LazyColumn(modifier = Modifier.padding(all = 16.dp)) {
                    item{
                        Spacer(modifier = Modifier.height(16.dp))
                        Text(
                            text = "Fifteenth Character: ",
                            fontWeight = FontWeight.Bold,
                            fontSize = 24.sp,
                            color = Color.Red
                        )
                        Text(text = homeUiModel.fifteenthCharacter)
                        Spacer(modifier = Modifier.height(16.dp))
                        Text(
                            text = "EveryFifteenth Character: ",
                            fontWeight = FontWeight.Bold,
                            fontSize = 24.sp,
                            color = Color.Red
                        )
                        Text(text = homeUiModel.everyFifteenthCharacter.joinToString(","))
                        Spacer(modifier = Modifier.height(16.dp))
                        Text(
                            text = "WordCount: ",
                            fontWeight = FontWeight.Bold,
                            fontSize = 24.sp,
                            color = Color.Red
                        )
                        Text(text = "${homeUiModel.wordCount}")
                    }
                }
            }
            is UIState.Error -> {
                Text(text = "Error: ${(uiState as UIState.Error).error}")
            }
        }
    }
}

@Preview
@Composable
fun PreviewHomeScreen() {
    HomeScreen()
}