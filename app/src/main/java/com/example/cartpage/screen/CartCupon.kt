package com.example.cartpage.screen

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Search
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.OutlinedTextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.example.cartpage.ui.theme.CartPageTheme

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SearchPage(navController: NavHostController) {

    var result by remember { mutableStateOf("") }

    Row(modifier = Modifier.padding(25.dp)) {
        OutlinedTextField(
            value = result,
            onValueChange = { result = it },
            label = {
                Image(
                    imageVector = Icons.Outlined.Search,
                    contentDescription = "",
                )
            },
            modifier = Modifier.fillMaxWidth()
        )

    }

}


@Preview(showSystemUi = true)
@Composable
fun SearchPagePreview() {
    CartPageTheme {

    }
}