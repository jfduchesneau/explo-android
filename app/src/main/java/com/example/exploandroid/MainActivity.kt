package com.example.exploandroid

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.exploandroid.helloworld.HelloWorldScreen
import com.example.exploandroid.ui.theme.ExploAndroidTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            ExploAndroidTheme {
                val viewModel: com.example.exploandroid.helloworld.HelloWorldViewModel = viewModel()
                val uiState by viewModel.uiState.collectAsStateWithLifecycle()
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    HelloWorldScreen(
                        uiState = uiState,
                        onEvent = viewModel::onEvent,
                        modifier = Modifier.padding(innerPadding),
                    )
                }
            }
        }
    }
}