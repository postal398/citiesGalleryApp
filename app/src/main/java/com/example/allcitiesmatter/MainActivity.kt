package com.example.allcitiesmatter

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.allcitiesmatter.ui.theme.AllCitiesMatterTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            AllCitiesMatterTheme {
                    citiesGalleryApp()
            }
        }
    }
}


@Composable
fun citiesGalleryApp() {
    var step by remember { mutableStateOf(0) }

            @Composable
            fun funreables(
                IdCustom : Int,
                contDescCustom : String,
                textCustom : String,
                firstTextCustom : String,
                secondTextCustom : String,
                availability : Boolean,
                ) {


                Column(
                    modifier = Modifier.fillMaxSize(),verticalArrangement = Arrangement.Top,
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {

                    Spacer(modifier = Modifier.size(100.dp))

                    Image(painter = painterResource(id = IdCustom) , contentDescription = contDescCustom)

                    Spacer(modifier = Modifier.size(50.dp))

                    Column(modifier = Modifier
                        .border(
                            BorderStroke(2.dp, Color(105, 205, 216)),
                            shape = RoundedCornerShape(4.dp)
                        )){
                    Text(text = firstTextCustom)
                    Text(text = secondTextCustom)}

                    Spacer(modifier = Modifier.size(30.dp))

                    Row() {
                        Button(onClick = { //Кнопка назад
                            if (step == 0) {
                                step = 0
                            }
                            else {step--}
                             },  enabled = availability,) {
                            Text(text = "Назад")
                        }

                        Spacer(modifier = Modifier.size(50.dp))

                        Button(onClick = { //Кнопка вперед
                            if (step == 3) {
                                step = 0
                            }
                            else {step++}
                             }) {
                            Text(text = "Вперёд")
                        }


                    } //Конец ряда с кнопками
                }//  Конец колонки
            }



    when (step) {

        0 -> {
            funreables(R.drawable.msk, "msk", "Moscow calling",
                "Moscow is a capital of Russian Federation",
                "It's big and beautiful city",
                false
                )
        }

        1->{
            funreables(
                IdCustom = R.drawable.baku,
                contDescCustom = "baku",
                textCustom = "Adjara Gudzhu",
                firstTextCustom = "Baku is a capital of Azerbaijan",
                secondTextCustom = "In Baku u can buy a SberHleb",
                true
            )
        }

        2-> {
            funreables(
                IdCustom = R.drawable.lodz,
                contDescCustom = "lodz!!",
                textCustom = "Velikoe voevodztvo",
                firstTextCustom = "Lodz is subrb of Warsaw",
                secondTextCustom = "It's a place where you governor is a war-chief",
                true
            )
        }

        3-> {
            funreables(
                IdCustom = R.drawable.rnd,
                contDescCustom = "rnd",
                textCustom = "Rostov-gorod-rostov-don!",
                firstTextCustom = "Rostov is a capital of the south RF",
                secondTextCustom = "Home...whatever",
                true
            )
        }


    }//Конец when


} // Конец АППки