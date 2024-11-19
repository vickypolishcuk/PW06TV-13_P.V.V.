package com.example.lab6

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.lab6.ui.theme.Lab6Theme

import androidx.navigation.compose.rememberNavController
import com.example.lab6.functions.CalculatorsFunctions
import com.example.lab6.ui.calculator.Calculator
import com.example.lab6.ui.firstScreen.FirstScreen

enum class Routes {
    MAIN_SCREEN,
    CALCULATOR,
}

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            Lab6Theme {
                val navController = rememberNavController()
                val calculatorsFunctions = CalculatorsFunctions()
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    Greeting(
                        name = "Android",
                        modifier = Modifier.padding(innerPadding)
                    )
                    NavHost(
                        navController = navController,
                        startDestination = Routes.MAIN_SCREEN.name,
                        modifier = Modifier.padding(innerPadding)
                    ) {
                        composable(route = Routes.MAIN_SCREEN.name) {
                            FirstScreen(
                                onCalculator1Navigate = { navController.navigate(route = Routes.CALCULATOR.name) },
                            )
                        }
                        composable(route = Routes.CALCULATOR.name) {
                            Calculator(
                                goBack = { navController.navigate(route = Routes.MAIN_SCREEN.name )},
                                calculatorsFunctions = calculatorsFunctions
                            )
                        }
                    }
                }
            }
        }
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = name,
        modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    Lab6Theme {
        Greeting("Android")
    }
}