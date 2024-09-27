package com.aminulrony.captaingame

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.aminulrony.captaingame.ui.theme.CaptainGameTheme
import kotlin.random.Random

class MainActivity : ComponentActivity() {
    @SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            CaptainGameTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) {
                    Aminul()
                }
            }
        }
    }
    @Composable
    fun Aminul() {
        val treasureFound = remember { mutableStateOf(0) }
        val direction = remember { mutableStateOf("North")}
        Column {

                Text(text = "Tresures found : ${treasureFound.value}")
                Text(text = "Current direction we are going : ${direction.value}")
                Button(onClick = {
                    direction.value = "East"
                    if(Random.nextBoolean())
                        treasureFound.value += 1
                }) {
                    Text("Sail East")
                }
        }
    }
    @Preview(showBackground = true)
    @Composable
    fun AminulPreview()
    {
        Aminul()
    }
}
