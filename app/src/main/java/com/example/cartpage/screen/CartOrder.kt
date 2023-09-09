package com.example.cartpage.screen

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.airbnb.lottie.compose.LottieAnimation
import com.airbnb.lottie.compose.LottieCompositionSpec
import com.airbnb.lottie.compose.rememberLottieComposition
import com.example.cartpage.R
import com.example.cartpage.ui.theme.CartPageTheme

@Composable
fun OrderPlaced(navController: NavHostController) {

    val check by rememberLottieComposition(LottieCompositionSpec.RawRes(R.raw.animation_lm6hncx9))

    Column(verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally) {
        Box(modifier = Modifier.padding(10.dp)
            .size(500.dp)) {
            LottieAnimation(composition = check)
        }
        Text(
            text = "Your Order is Placed",
            style = MaterialTheme.typography.titleLarge
        )
    }
    
}

@Preview(showSystemUi = true)
@Composable
fun OrderPlacedPreview() {
    CartPageTheme {

    }
}