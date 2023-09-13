package com.example.guessthenumber

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCompositionContext
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.guessthenumber.ui.theme.GuessthenumberTheme
import java.lang.NumberFormatException

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            GuessthenumberTheme ()
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun GuessthenumberTheme(){
    var guess by remember { mutableStateOf("") }
    var message by remember { mutableStateOf("") }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ){
        Text(
            text = "Guess the Number",
            style = MaterialTheme.typography.headlineMedium
        )
        
        OutlinedTextField(value = guess,
            onValueChange = {guess = it},
            label = { Text("Enter your guess")},
            keyboardOptions = KeyboardOptions(
                keyboardType = KeyboardType.Number,
                imeAction = ImeAction.Done
            ),
            keyboardActions = KeyboardActions(
                onDone = {
                    // Check the guess and display the message
                    checkGuess(guess, 42)
                }
            ),
            modifier = Modifier.fillMaxWidth()
        )

        Text(
            text = message,
            color = Color.Red,
            style = MaterialTheme.typography.bodyMedium
        )
        
        Spacer(modifier = Modifier.height(16.dp))
        
        Button(onClick = {
            // Check the guess and display the message
            checkGuess(guess, 42)
        },
            modifier = Modifier.fillMaxWidth()
        ){
            Text(text = "Check Guess")
        }
    }
}

fun checkGuess(guess: String, targetNumber: Int){
    var message = ""

    if(guess.isEmpty()){
        message = "Please enter a number."
    }else{
        try {
            val userGuess = guess.toInt()
            when {
                userGuess == targetNumber -> {
                    message = "Congratulations! You guessed it."
                }
                userGuess < targetNumber -> {
                    message = "Try a higher number."
                }
                else -> {
                    message = "Try a lower number."
                }
            }
        }catch (e: NumberFormatException){
            message = "Invalid input. Please enter a valid number."
        }
    }
    println(message)
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    GuessthenumberTheme ()
}