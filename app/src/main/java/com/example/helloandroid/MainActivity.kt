package com.example.helloandroid

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.FilledTonalButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.helloandroid.ui.theme.HelloAndroidTheme
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            HelloAndroidApp()
        }
    }
}

@Composable
fun HelloAndroidApp (){
    var darkMode by remember { mutableStateOf(false) }

    HelloAndroidTheme (darkTheme = darkMode, true,
        // A surface container using the 'background' color from the theme
        {
            Surface(
                modifier = Modifier.fillMaxSize(),
                color = MaterialTheme.colorScheme.primary
            ) {
                Greeting("Android")
                DarkModeButton(darkMode) { newMode ->
                    darkMode = newMode
                }
            }

        }
    )
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}
@Composable
fun DarkModeButton(darkMode: Boolean,onDarkModeToggle: (Boolean)->Unit){

    if(darkMode){
        Button(onClick = { onDarkModeToggle(true) }) {
            Text("Dark Mode")
        }
    } else {
        FilledTonalButton(onClick = { onDarkModeToggle(false) }) {
            Text("Light Mode")
        }
    }

}

//@Preview(showBackground = true)
//@Composable
//fun GreetingPreview() {
//        Greeting("Android")
//}