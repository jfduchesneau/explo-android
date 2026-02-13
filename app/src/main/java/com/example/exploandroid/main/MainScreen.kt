package com.example.exploandroid.main

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.material3.Tab
import androidx.compose.material3.TabRow
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.snapshotFlow
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.exploandroid.main.poc.PocScreen
import com.example.exploandroid.main.tests.TestsScreen
import com.example.exploandroid.ui.theme.ExploAndroidTheme

@Composable
fun MainScreen(
    uiState: MainUiState,
    onEvent: (MainEvent) -> Unit,
    modifier: Modifier = Modifier,
) {
    val pagerState = rememberPagerState(
        initialPage = uiState.selectedTabIndex,
        pageCount = { MainTab.entries.size },
    )

    LaunchedEffect(pagerState) {
        snapshotFlow { pagerState.currentPage }.collect { page ->
            onEvent(MainEvent.OnTabSelected(page))
        }
    }

    LaunchedEffect(uiState.selectedTabIndex) {
        if (pagerState.currentPage != uiState.selectedTabIndex) {
            pagerState.animateScrollToPage(uiState.selectedTabIndex)
        }
    }

    Column(modifier = modifier.fillMaxSize()) {
        TabRow(
            selectedTabIndex = uiState.selectedTabIndex,
            modifier = Modifier.fillMaxWidth(),
        ) {
            MainTab.entries.forEachIndexed { index, tab ->
                Tab(
                    selected = uiState.selectedTabIndex == index,
                    onClick = { onEvent(MainEvent.OnTabSelected(index)) },
                    text = { Text(tab.title) },
                )
            }
        }

        HorizontalPager(
            state = pagerState,
            modifier = Modifier.fillMaxSize(),
        ) { page ->
            when (MainTab.entries[page]) {
                MainTab.POC -> PocScreen()
                MainTab.TESTS -> TestsScreen()
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun MainScreenPreview() {
    ExploAndroidTheme {
        MainScreen(
            uiState = MainUiState(),
            onEvent = {},
        )
    }
}

@Preview(showBackground = true)
@Composable
fun MainScreenTestsTabPreview() {
    ExploAndroidTheme {
        MainScreen(
            uiState = MainUiState(selectedTabIndex = 1),
            onEvent = {},
        )
    }
}
