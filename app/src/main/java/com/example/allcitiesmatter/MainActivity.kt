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
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
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
                availabilityPrev : Boolean,
                availabilityNext: Boolean
                ) {


                Column( //Главная общая колонка, в которую входит вообще весь этот сраный экран
                    modifier = Modifier.fillMaxSize(),verticalArrangement = Arrangement.Top,
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {


                  Box( //бокс для отступа картинки
                      Modifier
                          .heightIn(min = if (step == 2) 200.dp else 350.dp, max = 500.dp)
                          .padding(30.dp)
                          .border(1.dp, Color.Black)
                  ){
                    Image(painter = painterResource(id = IdCustom), contentDescription = contDescCustom, //Custom params!
                        modifier = Modifier
                            .padding(30.dp)
                            .heightIn(min = if (step == 2) 200.dp else 350.dp, max = 800.dp)
                            .widthIn(min = 300.dp, max = 800.dp),
                        contentScale = ContentScale.FillHeight
                        ) //Конец изображения
                  } //Конец бокса

                    Spacer(modifier = Modifier.size(10.dp)) //Пустых 40 дп между картинкой и блоком с текстом



                        //Тексты в рамке
                    Box(modifier = Modifier
                        .padding(16.dp) // отступы между рамкой и Column
                        .heightIn(min = 100.dp, max = 200.dp)
                        .widthIn(min = 250.dp, max = 500.dp),
                        contentAlignment = Alignment.Center) { //Бокс для текстов под картинкой
                        Surface(
                            shape = RoundedCornerShape(8.dp), // закруглить углы рамки
                            border = BorderStroke(1.dp, Color.Gray), // ширина и цвет границы рамки
                            elevation = 8.dp, // тень наружу
                            color = MaterialTheme.colors.background // цвет рамки
                        ) {
                    Column(modifier = Modifier.padding(20.dp), verticalArrangement = Arrangement.Center){
                    Text(text = firstTextCustom)
                    Text(text = secondTextCustom, style = TextStyle(fontWeight = FontWeight.Bold))}}}




                    Spacer(modifier = Modifier.size(50.dp)) //30 пустых dp между текстами и кнопками



                    Box(//Бокс для кнопок
                        modifier = Modifier.fillMaxWidth(),
                        contentAlignment = Alignment.BottomCenter
                    ) {
                        Row() {//Ряд с КНОПКАМИ
                            Button(
                                onClick = { //Кнопка назад
                                    if (step == 0) {
                                        step = 0
                                    } else {
                                        step--
                                    }
                                },
                                enabled = availabilityPrev,
                            ) {
                                Text(text = "Назад")
                            }

                            Spacer(modifier = Modifier.width(50.dp))

                            Button(onClick = { //Кнопка вперед
                                if (step == 3) {
                                    step = 0
                                } else {
                                    step++
                                }
                            }, enabled = availabilityNext) {
                                Text(text = "Вперёд")
                            }


                        } //Конец ряда с кнопками
                    }//Конец Бокса с кнопками
                  }//  Конец колонки
            }//Конец funreables



    when (step) {

        0 -> {
            funreables(R.drawable.msk, "msk", "Moscow calling",
                "Moscow is a capital of Russian Federation",
                "It's big and beautiful city",
                false, true
                )
        }

        1->{
            funreables(
                IdCustom = R.drawable.baku,
                contDescCustom = "baku",
                textCustom = "Adjara Gudzhu",
                firstTextCustom = "Baku is a capital of Azerbaijan",
                secondTextCustom = "In Baku u can buy a SberHleb",
                true, true
            )
        }

        2-> {
            funreables(
                IdCustom = R.drawable.lodz,
                contDescCustom = "lodz!!",
                textCustom = "Velikoe voevodztvo",
                firstTextCustom = "Lodz is subrb of Warsaw",
                secondTextCustom = "It's a place where your governor is a war-chief",
                true,
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
                true,
                false
            )
        }


    }//Конец when


} // Конец АППки