package am.android.composeloading.ui.loading
import android.content.Context
import android.graphics.Bitmap
import androidx.compose.animation.core.*
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.scale
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.graphics.StrokeCap
import androidx.compose.ui.graphics.asImageBitmap
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.graphics.drawscope.inset
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.core.content.ContextCompat

@Composable
fun ArcRotationWithScale() {
    val infiniteTransition = rememberInfiniteTransition()


    val arcColor = MaterialTheme.colorScheme.primary
    val arcAngle1 by infiniteTransition.animateFloat(
        initialValue = 0F,
        targetValue = 180F,
        animationSpec = infiniteRepeatable(
            animation = tween(500, easing = LinearEasing),
            repeatMode = RepeatMode.Restart
        )
    )

    val arcAngle2 by infiniteTransition.animateFloat(
        initialValue = 180F,
        targetValue = 360F,
        animationSpec = infiniteRepeatable(
            animation = tween(500, easing = LinearEasing),
            repeatMode = RepeatMode.Restart
        )
    )


    val arc by infiniteTransition.animateFloat(
        initialValue =0F,
        targetValue = 90F,
        animationSpec = infiniteRepeatable(
            animation = tween(2500, easing = LinearEasing),
            repeatMode = RepeatMode.Reverse
        )
    )
    val scale by infiniteTransition.animateFloat(
        initialValue =0.4F,
        targetValue = 1F,
        animationSpec = infiniteRepeatable(
            animation = tween(1250, easing = LinearEasing),
            repeatMode = RepeatMode.Reverse
        )
    )

    Box(
        modifier = Modifier.fillMaxSize().scale(scale),
        contentAlignment = Alignment.Center,
    ) {
        Canvas(
            modifier = Modifier
                .padding(12.dp)
                .size(50.dp)
        ) {
            drawArc(
                color = arcColor,
                startAngle = arcAngle1,
                sweepAngle = arc,
                useCenter = false,
                style = Stroke(width = 6f, cap = StrokeCap.Round),
            )

            drawArc(
                color = arcColor,
                startAngle = arcAngle2,
                sweepAngle = arc,
                useCenter = false,
                style = Stroke(width = 6f, cap = StrokeCap.Round),

            )
        }
    }
}
