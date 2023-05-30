package am.android.composeloading

import am.android.composeloading.ui.loading.*
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import am.android.composeloading.ui.theme.ComposeLoadingTheme
import android.widget.GridLayout
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.Layout
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

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
        topBar = {
            ElevatedCard(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(22.dp),
                colors = CardDefaults.cardColors(containerColor = Color(0xFF37474F)),
                shape = RoundedCornerShape(30),
            ) {
                Text(
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
                )
            }
        },
        content = { innerPadding ->
            Box(modifier = Modifier.padding(innerPadding)) {
                LazyVerticalGrid(
                    columns = GridCells.Adaptive(minSize = 128.dp)
                ) {
                    items(4) { photo ->
                        when (photo) {
                            0 -> SimpleArcRotation()
                            1 -> ArcRotationAnimation()
                            2 -> ArcRotationWithLogo()
//                            3 -> RotateBasket()
                        }
                    }
                }
            }
        }
    )
}
