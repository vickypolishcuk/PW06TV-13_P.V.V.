package com.example.lab6.ui.firstScreen

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.lab6.ui.theme.PurpleGrey40


val buttonStyles = Modifier.padding(all = 30.dp)

@Composable
fun FirstScreen(
    onCalculator1Navigate: () -> Unit,
) {
    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center // Центрування вмісту
    ) {
        Column(
            modifier = buttonStyles,
        ) {
            // Кнопка 1
            Button(
                onClick = { onCalculator1Navigate() },
                colors = androidx.compose.material3.ButtonDefaults.buttonColors(
                    containerColor = PurpleGrey40
                )
            ) {
                Text(
                    text = "Перейти до обчислень"
                )
            }
        }
    }
}