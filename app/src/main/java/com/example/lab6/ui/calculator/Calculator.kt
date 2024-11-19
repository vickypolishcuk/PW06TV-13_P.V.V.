package com.example.lab6.ui.calculator

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.lab6.functions.CalculatorsFunctions
import com.example.lab6.models.OutputDataShr
import com.example.lab6.models.InputDataShr
import com.example.lab6.models.InputDataTotal
import com.example.lab6.models.OutputDataTotal
import com.example.lab6.models.TotalShr

@Composable
fun Calculator(
    goBack: () -> Unit,
    calculatorsFunctions: CalculatorsFunctions
) {

    // Оголошення змінних для результатів
    val results = remember { mutableStateOf<List<OutputDataShr>>(emptyList()) }
    val totalShrResult = remember { mutableStateOf<TotalShr?>(null) }
    val totalResult = remember { mutableStateOf<OutputDataTotal?>(null) }
    val result1 = remember { mutableStateOf<OutputDataShr?>(null) }
    val result2 = remember { mutableStateOf<OutputDataShr?>(null) }

    // Функція для відображення результатів кожного ЕП
    @Composable
    fun ResultsShr(shr: OutputDataShr) {
        Column {
            Text("Компонент ${shr.name}")
            Text("n * P = ${shr.nP}")
            Text("n * P * K = ${shr.nPK}")
            Text("n * P * K * tg= ${shr.nPKtg}")
            Text("n * P^2 = ${shr.nP2}")
            Text("Розрахунковий струм I = ${shr.I}")
        }
    }

    // Функція для відображення загальних результатів ШР
    @Composable
    fun ResultsTotalShr(totalShr: TotalShr) {
        Column {
            Text("Назва ${totalShr.name}")
            Text("Кількість = ${totalShr.n}")
            Text("n * P = ${totalShr.nP}")
            Text("Коефіцієнт використання = ${totalShr.K}")
            Text("n * P * K = ${totalShr.nPK}")
            Text("n * P * K * tg= ${totalShr.nPKtg}")
            Text("n * P^2 = ${totalShr.nP2}")
            Text("Ефективна кількість ЕП = ${totalShr.nEf}")
            Text("Розрахунковий коефіцієнт активної потужності = ${totalShr.Ka}")
            Text("Розрахункове активне навантаження = ${totalShr.Ra}")
            Text("Розрахункове реактивне навантаження = ${totalShr.Rr}")
            Text("Повна потужність = ${totalShr.S}")
            Text("Розрахунковий струм I = ${totalShr.I}")
        }
    }

    // Функція для відображення загальних результатів цеху
    @Composable
    fun ResultsTotal(total: OutputDataTotal) {
        Column {
            Text("Коефіцієнт використання = ${total.K}")
            Text("Ефективна кількість ЕП = ${total.nEf}")
            Text("Розрахунковий коефіцієнт активної потужності = ${total.Ka}")
            Text("Розрахункове активне навантаження = ${total.Ra}")
            Text("Розрахункове реактивне навантаження = ${total.Rr}")
            Text("Повна потужність = ${total.S}")
            Text("Розрахунковий струм I = ${total.I}")
        }
    }

    // Початкові значення кожного ЕП у формі списку
    val listOfInputData: List<InputDataShr> = listOf(
        InputDataShr("Шліфувальний верстат",
            0.92, 0.9, 0.38, 4, 21, 0.15, 1.33),
        InputDataShr("Свердлильний верстат",
            0.92, 0.9, 0.38, 2, 14, 0.12, 1.0),
        InputDataShr("Фугувальний верстат",
            0.92, 0.9, 0.38, 4, 42, 0.15, 1.33),
        InputDataShr("Циркулярна пила",
            0.92, 0.9, 0.38, 1, 36, 0.3, 1.56),
        InputDataShr("Прес",
            0.92, 0.9, 0.38, 1, 20, 0.5, 0.75),
        InputDataShr("Полірувальний верстат",
            0.92, 0.9, 0.38, 1, 40, 0.22, 1.0),
        InputDataShr("Фрезерний верстат",
            0.92, 0.9, 0.38, 2, 32, 0.2, 1.0),
        InputDataShr("Вентилятор",
            0.92, 0.9, 0.38, 1, 20, 0.65, 0.75)
    )

    // Початкові значення крупних ЕП
    val shr1 = InputDataShr("Зварювальний трансформатор",
        0.92, 0.9, 0.38, 2, 100, 0.2, 3.0)
    val shr2 = InputDataShr("Сушильна шафа",
        0.92, 0.9, 0.38, 2, 120, 0.8, 0.0)

    // Початкові значення для всього цеху
    val inputDataTotal = InputDataTotal(81, 2330, 752, 657, 96399)

    // Інтерфейс сторінки
    Column(
        modifier = Modifier
            .padding(all = 15.dp)
    ) {
        // Кнопка для запуску обчислень
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 50.dp)
        ) {
            Button(
                onClick = { // Виклик обчислень і оновлення стану
                    // Обчислення кожного елементу ЕП в ШР
                    val listOfOutputData = listOfInputData.map { calculatorsFunctions.calculateShr(it) }

                    // Обчислення всього ШР
                    val calculatedTotalShr = calculatorsFunctions.calculateTotalShr(listOfInputData, listOfOutputData)

                    // Обчислення всього цеху
                    val calculatedTotal = calculatorsFunctions.calculateTotal(inputDataTotal)

                    // Обчислення крупних ЕП, що живляться від ТП
                    val shr1Res = calculatorsFunctions.calculateShr(shr1)
                    val shr2Res = calculatorsFunctions.calculateShr(shr2)

                    // Збереження результатів у попередньо визначені змінні
                    results.value = listOfOutputData
                    totalShrResult.value = calculatedTotalShr
                    totalResult.value = calculatedTotal
                    result1.value = shr1Res
                    result2.value = shr2Res
                }
            ) {
                Text("Обчислити")
            }
        }

        // Відображення результатів
        LazyColumn(
            modifier = Modifier
                .weight(1.2f) // Розмір колонки з результатами займатиме 1.2f висоти
                .padding(16.dp)
        ) {
            // Виведення кожного ЕП
            items(results.value) { result ->
                ResultsShr(result)
            }
            // Виведення трьох ШР (оскільки за умовою вони однакові)
            item {
                totalShrResult.value?.let { ResultsTotalShr(it) }
            }
            item {
                totalShrResult.value?.let { ResultsTotalShr(it) }
            }
            item {
                totalShrResult.value?.let { ResultsTotalShr(it) }
            }
            // Виведення крупних ЕП, що живляться від ТП
            item {
                result1.value?.let { ResultsShr(it) }
            }
            item {
                result2.value?.let { ResultsShr(it) }
            }
            // Виведення загального результату по цеху
            item {
                totalResult.value?.let { ResultsTotal(it) }
            }
        }
        // Кнопка для повернення на головний екран
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 100.dp) // Відступ
        ) {
            Button(
                onClick = goBack,
                modifier = Modifier.align(Alignment.Center) // Розміщення кнопки в центрі
            ) {
                Text("На головну")
            }
        }
    }
}
