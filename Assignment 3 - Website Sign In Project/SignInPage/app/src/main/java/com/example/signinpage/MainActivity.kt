package com.example.signinpage

import android.annotation.SuppressLint
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
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
import androidx.compose.runtime.movableContentOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.signinpage.ui.theme.SignInPageTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            SignInPage()
        }
    }
}

@SuppressLint("SuspiciousIndentation")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SignInPage(){
    var username by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }
    val context = LocalContext.current

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
            .background(Color.Cyan),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        //Login Image
        Image(
            painter = painterResource(id = R.drawable.login),
            contentDescription = "Login Image",
            modifier = Modifier
                .size(120.dp)
                .padding(16.dp)
        )

        // Sign In Text
        Text(
            text = "SIGN IN",
            style = MaterialTheme.typography.headlineMedium.copy(color = Color.Blue)
        )

        // Username Input Field
        OutlinedTextField(
            value = username,
            onValueChange = {username = it },
            label = {Text("Username")},
            modifier = Modifier.padding(16.dp)
        )

        Spacer(modifier = Modifier.height(1.dp))

        // Password Input Field
        OutlinedTextField(
            value = password,
            onValueChange = {password = it },
            label = {Text("Password")},
            keyboardOptions = KeyboardOptions(
                    keyboardType = KeyboardType.Password,
                    imeAction = ImeAction.Done
            ),
            keyboardActions = KeyboardActions(
                onDone = {

                },
            ),
            visualTransformation = PasswordVisualTransformation(),
            modifier = Modifier.padding(16.dp)
        )
        
        Spacer(modifier = Modifier.height(1.dp))

        // Sign In Buttons for different Websites

        // Instagram
        Button(
            onClick = {
            val url = "https://www.instagram.com"
            val intent = Intent(Intent.ACTION_VIEW, Uri.parse(url))

                context.startActivity(intent)
            },
            modifier = Modifier.padding(12.dp)
        ) {
            Text(text = "Open Instagram Website")
        }

        // Amazon
        Button(
            onClick = {
                val url = "https://www.amazon.com"
                val intent = Intent(Intent.ACTION_VIEW, Uri.parse(url))

                context.startActivity(intent)
            },
            modifier = Modifier.padding(12.dp)
        ) {
            Text(text = "Open Amazon Website")
        }

        // Netflix
        Button(
            onClick = {
                val url = "https://www.netflix.com"
                val intent = Intent(Intent.ACTION_VIEW, Uri.parse(url))

                context.startActivity(intent)
            },
            modifier = Modifier.padding(12.dp)
        ) {
            Text(text = "Open Netflix Website")
        }

        Button(
            onClick = {
                val url = "https://www.zomato.com"
                val intent = Intent(Intent.ACTION_VIEW, Uri.parse(url))

                context.startActivity(intent)
            },
            modifier = Modifier.padding(12.dp)
        ) {
            Text(text = "Open Zomato Website")
        }
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    SignInPage()
}