package com.example.exploandroid.helloworld

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.exploandroid.ui.theme.ActionBlue
import com.example.exploandroid.ui.theme.ExploAndroidTheme

@Composable
fun HelloWorldScreen(
    uiState: HelloWorldUiState,
    onEvent: (HelloWorldEvent) -> Unit,
    modifier: Modifier = Modifier,
) {
    Column(
        modifier = modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        Button(
            onClick = { onEvent(HelloWorldEvent.OnActionButtonClick) },
            colors = ButtonDefaults.buttonColors(containerColor = ActionBlue),
        ) {
            Text("Action")
        }
        uiState.message?.let { message ->
            Text(
                text = message,
                modifier = Modifier.padding(top = 16.dp),
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun HelloWorldScreenPreview() {
    ExploAndroidTheme {
        HelloWorldScreen(
            uiState = HelloWorldUiState(),
            onEvent = {},
        )
    }
}

@Preview(showBackground = true)
@Composable
fun HelloWorldScreenWithMessagePreview() {
    ExploAndroidTheme {
        HelloWorldScreen(
            uiState = HelloWorldUiState(message = "Hello World"),
            onEvent = {},
        )
    }
}
