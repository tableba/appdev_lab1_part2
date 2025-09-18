package com.example.lab1_part2

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.lab1_part2.data.Datasource
import com.example.lab1_part2.ui.theme.Lab1_part2Theme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            Lab1_part2Theme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    ApplePieRecipeApp()
                }
            }
        }
    }
}

@Composable
fun ApplePieRecipeApp() {
    ApplePieRecipeCard()
}

@Preview
@Composable
fun ApplePieRecipeAppPreview() {
    ApplePieRecipeCard()
}


@Composable
fun ApplePieRecipeCard(modifier: Modifier = Modifier) {
    var isVisible: Boolean by remember { mutableStateOf(true) }

    Box(
        modifier = Modifier
            .fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        Column (
            modifier = Modifier.padding(16.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ){
            ImageSlideShow(modifier = Modifier.padding(16.dp), images = Datasource().loadImages())

            Button(
                onClick = {isVisible = !isVisible},
                modifier = Modifier.padding(16.dp),
                colors = ButtonDefaults.buttonColors(
                    contentColor = MaterialTheme.colorScheme.onSurface,
                    containerColor = MaterialTheme.colorScheme.surface
                )

            ) {
                Text("Hide Text")
            }

            if (isVisible) {
                Text(
                    text = "Apple Pie recipe",
                    modifier = Modifier.padding(16.dp),
                    color = MaterialTheme.colorScheme.onBackground,
                    style = MaterialTheme.typography.headlineSmall
                )

                Text(
                    text = "Apple Pie: Mix 6 cups sliced apples with 3/4 cup sugar, 2 tbsp flour, 1 tsp cinnamon, 1/4 tsp nutmeg, 1/4 tsp salt, 1 tbsp lemon juice; place in 9-inch pie crust, dot with 2 tbsp butter, cover with second crust, bake 45-50 min at 425°F.",
                    modifier = Modifier.padding(16.dp),
                    color = MaterialTheme.colorScheme.onBackground,
                    style = MaterialTheme.typography.bodyMedium
                )
            }
        }

    }

}

@Composable
fun ImageSlideShow(modifier: Modifier = Modifier, images: List<Int>) {
    LazyRow (
        modifier = Modifier.fillMaxWidth()
    ) {
        items(images) { imageRes ->
            Image (
                painter = painterResource(imageRes),
                contentDescription = "Image of cake",
            )

        }
    }
}

