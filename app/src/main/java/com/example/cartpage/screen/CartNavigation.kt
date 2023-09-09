package com.example.cartpage.screen

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable

sealed class CartNavigation(val route: String) {
    object CartPage : CartNavigation("CartPage")
    object CouponCode : CartNavigation("CouponCode")
    object PlaceOrder : CartNavigation("PlaceOrder")
}

@Composable
fun NavigationBar1(
    navController: NavHostController
) {
    NavHost(
        navController = navController,
        startDestination = CartNavigation.CartPage.route
    ) {
        composable(CartNavigation.CartPage.route) { CartScreen(navController) }
        composable(CartNavigation.CouponCode.route) { SearchPage(navController) }
        composable(CartNavigation.PlaceOrder.route) { OrderPlaced(navController) }
    }
}
