package com.example.sumador

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.graphics.Shadow
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.sumador.ui.theme.SumadorTheme
import java.util.*
import kotlin.math.absoluteValue

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            SumadorTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    PantallaPrincipal()
                }
            }
        }
    }
}

@Preview(showSystemUi = true)
@Composable
fun PantallaPrincipal() {

    var resultado by rememberSaveable {
        mutableStateOf("")
    }

    var calcular by rememberSaveable {
        mutableStateOf("")
    }

    var isEnabled by rememberSaveable {
        mutableStateOf(false)
    }

    var calcularActual by remember {
        mutableStateOf("")
    }



    Column(
        Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        Box(
            modifier = Modifier
                .fillMaxWidth()
                .weight(.3f)
                .background(Color.DarkGray)
        ) {

            Resultado(numero = calcular)
        }

        Box(
            modifier = Modifier
                .fillMaxWidth()
                .weight(1f)
                .background(
                    androidx.compose.ui.graphics.Color.White
                )
        ) {
            Column {

                Row(
                    Modifier
                        .fillMaxWidth()
                        .background(color = colorResource(id = R.color.Orange))
                        .weight(1f)
                ) {
                    Box(
                        modifier = Modifier
                            .fillMaxSize()
                            .weight(2f), contentAlignment = Alignment.Center

                    ) {
                        OperationButton("AC", isEnabled, {
                            calcular = ""
                        }, backgroundColor = colorResource(id = R.color.Orange), butColor = colorResource(id = R.color.Orange))
                    }

                    Box(
                        modifier = Modifier
                            .fillMaxSize()
                            .weight(1f), contentAlignment = Alignment.Center
                    ) {
                        OperationButton("⌫", isEnabled, {
                            if (calcular.length != 0) {
                                calcular = calcular.substring(0, calcular.length - 1)
                            }
                        })
                    }

                    Box(
                        modifier = Modifier
                            .fillMaxSize()
                            .weight(1f), contentAlignment = Alignment.Center
                    ) {
                        OperationButton("-", isEnabled, {
                            calcular += "-"
                        })
                    }
                }

                Row(
                    Modifier
                        .fillMaxWidth()
                        .background(color = Color.Black)
                        .weight(1f)
                ) {
                    Box(
                        modifier = Modifier
                            .fillMaxSize()
                            .weight(1f), contentAlignment = Alignment.Center

                    ) {
                        OperationButton("7", isEnabled, {
                            calcular += "7"
                        })
                    }

                    Box(
                        modifier = Modifier
                            .fillMaxSize()
                            .weight(1f), contentAlignment = Alignment.Center
                    ) {
                        OperationButton("8", isEnabled, {
                            calcular += "8"
                        })
                    }

                    Box(
                        modifier = Modifier
                            .fillMaxSize()
                            .weight(1f), contentAlignment = Alignment.Center
                    ) {
                        OperationButton("9", isEnabled, {
                            calcular += "9"
                        })
                    }

                    Box(
                        modifier = Modifier
                            .fillMaxSize()
                            .weight(1f), contentAlignment = Alignment.Center
                    ) {
                        OperationButton("+", isEnabled, {
                            calcular += "+"
                        })
                    }
                }

                Row(
                    Modifier
                        .fillMaxWidth()
                        .background(color = Color.Black)
                        .weight(1f)
                ) {
                    Box(
                        modifier = Modifier
                            .fillMaxSize()
                            .weight(1f), contentAlignment = Alignment.Center

                    ) {
                        OperationButton("4", isEnabled, {
                            calcular += "4"
                        })
                    }

                    Box(
                        modifier = Modifier
                            .fillMaxSize()
                            .weight(1f), contentAlignment = Alignment.Center
                    ) {
                        OperationButton("5", isEnabled, {
                            calcular += "5"
                        })
                    }

                    Box(
                        modifier = Modifier
                            .fillMaxSize()
                            .weight(1f), contentAlignment = Alignment.Center
                    ) {
                        OperationButton("6", isEnabled, {
                            calcular += "6"
                        })
                    }

                    Box(
                        modifier = Modifier
                            .fillMaxSize()
                            .weight(1f), contentAlignment = Alignment.Center
                    ) {
                        OperationButton("x", isEnabled, {
                            calcular += "*"
                        })
                    }
                }

                Row(
                    Modifier
                        .fillMaxWidth()
                        .background(color = Color.Black)
                        .weight(1f)
                ) {

                    Box(
                        modifier = Modifier
                            .fillMaxSize()
                            .weight(1f), contentAlignment = Alignment.Center

                    ) {
                        OperationButton("1", isEnabled, {
                            calcular += "1"
                        })
                    }
                    Box(
                        modifier = Modifier
                            .fillMaxSize()
                            .weight(1f), contentAlignment = Alignment.Center

                    ) {
                        OperationButton("2", isEnabled, {
                            calcular += "2"
                        })
                    }

                    Box(
                        modifier = Modifier
                            .fillMaxSize()
                            .weight(1f), contentAlignment = Alignment.Center
                    ) {
                        OperationButton("3", isEnabled, {
                            calcular += "3"
                        })
                    }

                    Box(
                        modifier = Modifier
                            .fillMaxSize()
                            .weight(1f), contentAlignment = Alignment.Center
                    ) {
                        OperationButton("/", isEnabled, {
                            calcular += "/"
                        })
                    }
                }

                Row(
                    Modifier
                        .fillMaxWidth()
                        .background(color = colorResource(id = R.color.Orange))
                        .weight(1f)
                ) {

                    Box(
                        modifier = Modifier
                            .fillMaxSize()
                            .weight(1f), contentAlignment = Alignment.Center

                    ) {
                        OperationButton(".", isEnabled, {
                            calcular += "."
                        })
                    }
                    Box(
                        modifier = Modifier
                            .fillMaxSize()
                            .weight(1f), contentAlignment = Alignment.Center

                    ) {
                        OperationButton("0", isEnabled, {
                            calcular += "0"
                        })
                    }

                    Box(
                        modifier = Modifier
                            .fillMaxSize()
                            .weight(2f), contentAlignment = Alignment.Center
                    ) {
                        OperationButton("=", isEnabled, {
                            if (calcular.length != 0) {
                                calcular = calcularOperaciones(calcular)
                            }
                        }, backgroundColor = colorResource(id = R.color.Orange), butColor = colorResource(id = R.color.Orange))
                    }
                }
            }
        }
    }
}



@Composable
fun OperationButton(operacion: String, isEnabled: Boolean, onKeyPresseded: () -> Unit, backgroundColor: Color = Color.Black, butColor : Color = Color.Black) {
    Button(
        modifier = Modifier
            .size(150.dp)
            .clip(RectangleShape)
            .background(color = backgroundColor),
        enabled = true,
        onClick = { onKeyPresseded() },
        colors = ButtonDefaults.buttonColors(butColor)) {
        Text(text = operacion,
            style = TextStyle(fontSize = 20.sp),
            color = Color.White)

    }
}


fun calcularOperaciones(cadena: String): String {
    val operadoresMultiplicativos = listOf('*', '/')
    val operadoresAditivos = listOf('+', '-')
    val operaciones = mutableListOf<Char>()
    val numeros = mutableListOf<Double>()
    var numero = StringBuilder()
    var puntoEnNumero = false

    // Separar operadores y números de la cadena
    for (caracter in cadena) {
        if (caracter.isDigit() || (caracter == '.' && !puntoEnNumero)) {
            if (caracter == '.') {
                puntoEnNumero = true
            }
            numero.append(caracter)
        } else if (operadoresMultiplicativos.contains(caracter) || operadoresAditivos.contains(caracter)) {
            if (numero.isNotEmpty()) {
                numeros.add(numero.toString().toDouble())
                numero = StringBuilder()
                puntoEnNumero = false
            }
            operaciones.add(caracter)
        } else {
            return "Error"
        }
    }

    if (numero.isNotEmpty()) {
        numeros.add(numero.toString().toDouble())
    }

    // Verificar si hay varios operadores seguidos sin números
    for (i in 0 until operaciones.size - 1) {
        if (operadoresMultiplicativos.contains(operaciones[i]) && operadoresMultiplicativos.contains(operaciones[i + 1])) {
            return "Error"
        }
        if (operadoresAditivos.contains(operaciones[i]) && operadoresAditivos.contains(operaciones[i + 1])) {
            return "Error"
        }
    }

    // Realizar multiplicaciones y divisiones primero
    var i = 0
    while (i < operaciones.size) {
        if (operaciones[i] in operadoresMultiplicativos) {
            when (operaciones[i]) {
                '*' -> {
                    numeros[i] *= numeros[i + 1]
                    numeros.removeAt(i + 1)
                }
                '/' -> {
                    if (numeros[i + 1] != 0.0) {
                        numeros[i] /= numeros[i + 1]
                        numeros.removeAt(i + 1)
                    } else {
                        return "Error"
                    }
                }
            }
            operaciones.removeAt(i)
        } else {
            i++
        }
    }

    // Luego, realizar sumas y restas
    i = 0
    var resultado = numeros[i]

    while (i < operaciones.size) {
        when (operaciones[i]) {
            '+' -> resultado += numeros[i + 1]
            '-' -> resultado -= numeros[i + 1]
        }
        i++
    }

    return resultado.toString()
}


@Composable
fun Resultado(numero: String) {
    Text(
        text = numero, Modifier.fillMaxWidth(),
        style = TextStyle(
            fontSize = 40.sp,
            shadow = Shadow(
                color = Color.Blue,
                blurRadius = 3f
            )
        ),
        textAlign = TextAlign.End,
    )
}


