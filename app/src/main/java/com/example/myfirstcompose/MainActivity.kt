package com.example.myfirstcompose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.FavoriteBorder
import androidx.compose.material3.Button
import androidx.compose.material3.Divider
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.compose.runtime.remember
import com.example.myfirstcompose.ui.theme.MyFirstComposeTheme

class MainActivity : ComponentActivity()
{
    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState)
        setContent {
            MyFirstComposeTheme {
                // A surface container using the 'background' color from the theme
//                    Greeting("Android")
//                    TryIcons()
                RecyclerCompose()


            }
        }
    }
}


@Composable fun Greeting(name: String, modifier: Modifier = Modifier)
{

    Box(modifier = Modifier.fillMaxSize()

    ) {
        Column(

            horizontalAlignment = Alignment.CenterHorizontally, verticalArrangement = Arrangement.Center,

            modifier = Modifier
                .padding(20.dp)
                .align(Alignment.BottomEnd)
                .fillMaxWidth()

        ) {
            Text(
                text = "Hello $name!",
                color = Color.Red,
                fontSize = 20.sp,
            )
            Text(
                text = "Hello Other guy!",
                color = Color.Red,
                fontSize = 20.sp,


                )

        }
        Row(

            verticalAlignment = Alignment.CenterVertically, horizontalArrangement = Arrangement.Center,
            modifier = Modifier
                .padding(20.dp)
                .align(Alignment.TopEnd)
                .fillMaxWidth()


        ) {
            Text(
                text = "Hello $name!",
                color = Color.Red,
                fontSize = 20.sp,
            )
            Text(
                text = "Hello Other guy!",
                color = Color.Red,
                fontSize = 20.sp,


                )

        }


    }


}

@Composable fun TryImages()
{
    Image(painter = painterResource(id = R.drawable.ic_launcher_foreground), contentDescription = null, modifier = Modifier.background(Color.Black))
}

@Composable fun TryIcons()
{
    LazyRow(modifier = Modifier.fillMaxSize()) {
        items(10) { i ->
            Icon(imageVector = Icons.Default.FavoriteBorder, contentDescription = null, Modifier.size(150.dp)

            )
        }
    }

}

@Composable fun Counter()
{
    var count by remember {
        mutableStateOf(0)
    }
    Column(horizontalAlignment = Alignment.CenterHorizontally, verticalArrangement = Arrangement.Center, modifier = Modifier.fillMaxSize()


    ) {
        Button(onClick = {
            count++
        }) {
            Text(text = "Click Me : $count")

        }
    }
}


@Composable fun RecyclerCompose()
{
    var name by remember {
        mutableStateOf("")
    }

    var namesList by remember {
        mutableStateOf(listOf<String>())
    }

    Column(modifier = Modifier
        .fillMaxSize()
        .padding(16.dp)

    ) {

        Row(modifier = Modifier.fillMaxWidth()


        ) {

            OutlinedTextField(value = name, onValueChange = { text ->
                name = text

            }, modifier = Modifier.weight(1F))

            Spacer(modifier = Modifier.width(16.dp))

            Button(

                onClick = {
                    if (name.isNotBlank())
                    {
                        namesList = namesList + name
                        name =""
                    }
                }) {
                Text(text = "Add")
            }
        }

        LazyColumn {
            items(namesList) { currentName ->
                Text(modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp)
                    ,
                    text = currentName)
                Divider()

            }
        }
    }
}

@Preview(showBackground = true) @Composable fun GreetingPreview()
{
    MyFirstComposeTheme {
//        Greeting("Ahmed")
//        TryIcons()
//        Counter()
        RecyclerCompose()

    }
}

