package com.example.exploandroid.main.poc

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.exploandroid.helloworld.HelloWorldScreen
import com.example.exploandroid.helloworld.HelloWorldViewModel
import com.example.exploandroid.ui.theme.ExploAndroidTheme

@Composable
fun PocScreen(
    modifier: Modifier = Modifier,
) {
    val viewModel: HelloWorldViewModel = viewModel()
    val uiState by viewModel.uiState.collectAsStateWithLifecycle()

    Column(
        modifier = modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.Top,
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        Text(
            text = "Proof of Concepts",
            style = MaterialTheme.typography.headlineMedium,
            modifier = Modifier.padding(bottom = 16.dp),
        )
        HelloWorldScreen(
            uiState = uiState,
            onEvent = viewModel::onEvent,
        )
    }
}

@Preview(showBackground = true)
@Composable
fun PocScreenPreview() {
    ExploAndroidTheme {
        PocScreen()
    }
}
