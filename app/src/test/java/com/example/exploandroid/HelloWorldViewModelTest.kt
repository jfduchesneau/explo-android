package com.example.exploandroid

import com.example.exploandroid.helloworld.HelloWorldEvent
import com.example.exploandroid.helloworld.HelloWorldViewModel
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
class HelloWorldViewModelTest {

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
    fun initialState_hasNullMessage() = runTest {
        val viewModel = HelloWorldViewModel()
        assertEquals(null, viewModel.uiState.value.message)
    }

    @Test
    fun onActionButtonClick_setsMessageToHelloWorld() = runTest {
        val viewModel = HelloWorldViewModel()
        viewModel.onEvent(HelloWorldEvent.OnActionButtonClick)
        assertEquals("Hello World", viewModel.uiState.value.message)
    }
}
