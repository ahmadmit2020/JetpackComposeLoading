package am.android.composeloading

import am.android.composeloading.ui.loading.*
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import am.android.composeloading.ui.theme.ComposeLoadingTheme
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ComposeLoadingTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    HomeScreen()
                }
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeScreen() {
    Scaffold(
        bottomBar = {
            ElevatedCard(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(22.dp),
                colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.primary),
                shape = RoundedCornerShape(40),
            ){ Text(
                "Jetpack Compose Loading",
                fontWeight = FontWeight.Bold,
                color = MaterialTheme.colorScheme.onSecondary,
                modifier = Modifier
                    .padding(
                        top = 24.dp,
                        start = 16.dp,
                        end = 16.dp,
                        bottom = 24.dp
                    )
                    .fillMaxWidth()
            )}
        },
        content ={innerPadding ->
            Box(
                contentAlignment = Alignment.Center,
                modifier = Modifier.fillMaxSize().padding(innerPadding),
                ){
                Column {
                    Row (){
                        Column(
                            modifier = Modifier
                                .padding(4.dp)
                                .weight(1F, true)
                        ) {
                            Box(
                                modifier = Modifier.fillMaxSize(),
                                contentAlignment = Alignment.Center
                            ) {
                                Text("Arc =>" , fontWeight = FontWeight.Bold, color = MaterialTheme.colorScheme.primary)
                            }
                        }
                        Column(
                            modifier = Modifier
                                .padding(4.dp)
                                .weight(1F, true)
                        ) {
                            SimpleArcRotation()
                        }
                        Column(
                            modifier = Modifier
                                .padding(4.dp)
                                .weight(1F, true)
                        ) {
                            ArcRotationAnimation()
                        }
                        Column(
                            modifier = Modifier
                                .padding(4.dp)
                                .weight(1F, true)
                        ) {
                            ArcRotationWithLogo()
                        }
                        Column(
                            modifier = Modifier
                                .padding(4.dp)
                                .weight(1F, true)
                        ) {
                            ArcRotationWithScale()
                        }


                    }
                }

            }
        }
    )
}

