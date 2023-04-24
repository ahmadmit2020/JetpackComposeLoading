package am.android.composeloading.ui.loading

import androidx.compose.animation.core.*
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.graphics.TransformOrigin
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp

@Composable
fun RotateBasket(){
    val infiniteTransition = rememberInfiniteTransition()
    val rotation by infiniteTransition.animateFloat(
        initialValue = -20f,
        targetValue = 20f,
        animationSpec = infiniteRepeatable(
            animation = tween<Float>(
                durationMillis = 1000,
                easing = LinearEasing,
            ),
            repeatMode = RepeatMode.Reverse
        )
    )

    Box(
        contentAlignment = Alignment.Center,
        modifier = Modifier
            .fillMaxSize()
        ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally

        ) {
            val colorFilter = ColorFilter.tint( Color(0XFF1A237E))

            Image(
                modifier = Modifier
                    .size(56.dp)
                    .graphicsLayer(
                        transformOrigin = TransformOrigin(
                            pivotFractionX = 0.5f,
                            pivotFractionY = 0.1f,
                        ),
                        rotationZ = rotation,
                    ),
                painter = painterResource(id = am.android.composeloading.R.drawable.logo),
                contentDescription = "Logo",
                colorFilter = colorFilter,
                contentScale = ContentScale.Fit

            )
        }

    }
}