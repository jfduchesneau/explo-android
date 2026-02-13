package com.example.exploandroid

import com.example.exploandroid.main.MainEvent
import com.example.exploandroid.main.MainTab
import com.example.exploandroid.main.MainViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.UnconfinedTestDispatcher
import kotlinx.coroutines.test.resetMain
import kotlinx.coroutines.test.runTest
import kotlinx.coroutines.test.setMain
import org.junit.After
import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Test

@OptIn(ExperimentalCoroutinesApi::class)
class MainViewModelTest {

    private val testDispatcher = UnconfinedTestDispatcher()

    @Before
    fun setUp() {
        Dispatchers.setMain(testDispatcher)
    }

    @After
    fun tearDown() {
        Dispatchers.resetMain()
    }

    @Test
    fun initialState_hasFirstTabSelected() = runTest {
        val viewModel = MainViewModel()
        assertEquals(0, viewModel.uiState.value.selectedTabIndex)
    }

    @Test
    fun onTabSelected_withValidIndex_updatesSelectedTab() = runTest {
        val viewModel = MainViewModel()
        viewModel.onEvent(MainEvent.OnTabSelected(1))
        assertEquals(1, viewModel.uiState.value.selectedTabIndex)
    }

    @Test
    fun onTabSelected_withNegativeIndex_clampsToZero() = runTest {
        val viewModel = MainViewModel()
        viewModel.onEvent(MainEvent.OnTabSelected(-1))
        assertEquals(0, viewModel.uiState.value.selectedTabIndex)
    }

    @Test
    fun onTabSelected_withIndexExceedingTabCount_clampsToLastTab() = runTest {
        val viewModel = MainViewModel()
        val lastTabIndex = MainTab.entries.size - 1
        viewModel.onEvent(MainEvent.OnTabSelected(100))
        assertEquals(lastTabIndex, viewModel.uiState.value.selectedTabIndex)
    }

    @Test
    fun onTabSelected_switchingBetweenTabs_updatesCorrectly() = runTest {
        val viewModel = MainViewModel()

        viewModel.onEvent(MainEvent.OnTabSelected(1))
        assertEquals(1, viewModel.uiState.value.selectedTabIndex)

        viewModel.onEvent(MainEvent.OnTabSelected(0))
        assertEquals(0, viewModel.uiState.value.selectedTabIndex)
    }
}
