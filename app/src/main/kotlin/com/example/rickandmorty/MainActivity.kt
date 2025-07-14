package com.example.rickandmorty

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.lifecycle.lifecycleScope
import com.example.rickandmorty.core.network.service.RickAndMortyApiService
import com.example.rickandmorty.feature.home.Home
import dagger.hilt.android.AndroidEntryPoint
import jakarta.inject.Inject
import kotlinx.coroutines.launch

@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    @Inject
    lateinit var apiService: RickAndMortyApiService

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        lifecycleScope.launch {
            try {
                val response = apiService.getAllCharacters()
                Log.d("API", "Result: ${response.info.count}")
                Log.d("API", "Result: ${response.info.pages}")
                Log.d("API", "Result: ${response.info.next}")
                Log.d("API", "Result: ${response.info.prev}")
                Log.d("API", "Result: ${response.results}")
            } catch (e: Exception) {
                Log.e("API", "Ошибка: ${e.message}", e)
            }
        }

        setContent {
            Text("Проверь логи Logcat")
        }
    }

//    override fun onCreate(savedInstanceState: Bundle?) {
//        super.onCreate(savedInstanceState)
//        enableEdgeToEdge()
//        setContent {
//            Hello()
//        }
//    }
}

@Composable
fun Hello() {
    Column {
        Text("Hello from app module")
        Home()
    }
}