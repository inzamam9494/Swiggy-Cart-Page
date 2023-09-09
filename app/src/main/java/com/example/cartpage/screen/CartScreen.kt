package com.example.cartpage.screen

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AddChart
import androidx.compose.material.icons.filled.ArrowRight
import androidx.compose.material.icons.filled.DeliveryDining
import androidx.compose.material.icons.filled.Percent
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.cartpage.R
import com.example.cartpage.ui.theme.CartPageTheme
import com.example.cartpage.ui.theme.CartViewModel
import com.example.cartpage.ui.theme.Orange


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CartScreen(navController: NavHostController) {

    val vm: CartViewModel = viewModel()

    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Column {
                        Text(
                            text = "Delivery in 12 Minutes",
                            fontSize = 20.sp,
                            style = MaterialTheme.typography.labelLarge
                        )

                        Text(
                            text = "Shipped items",
                            fontSize = 12.sp,
//                            fontWeight = FontWeight.Thin,
                            style = MaterialTheme.typography.labelMedium
                        )
                    }
                },
                navigationIcon = {
                    Box(
                        modifier = Modifier
                            .size(60.dp)
                            .padding(5.dp)
                            .clip(RoundedCornerShape(10.dp))
                            .background(MaterialTheme.colorScheme.secondaryContainer),
                        contentAlignment = Alignment.Center
                    ) {
                        Image(
                            painter = painterResource(id = R.drawable.clockgreen),
                            contentDescription = "green clock",
                            modifier = Modifier.size(30.dp)
                        )
                    }
                }
            )
        }
    ) { paddingValues ->
        val uiState = vm.uiState.collectAsState()
        Column(
            modifier = Modifier
                .padding(paddingValues)
                .verticalScroll(state = rememberScrollState())
        ) {

            Box(modifier = Modifier.padding(10.dp)) {
                Column {
//                    this is item 1
                    Row(
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.Center
                    ) {
                        Box(
                            modifier = Modifier
                                .border(
                                    width = 1.dp,
                                    color = Color.LightGray,
                                    shape = RoundedCornerShape(15.dp)
                                )
                                .padding(10.dp)
                        ) {
                            Image(
                                painter = painterResource(id = R.drawable.protien),
                                contentDescription = "Why Protein",
                                modifier = Modifier.size(50.dp)
                            )
                        }

                        Spacer(modifier = Modifier.padding(5.dp))

                        Column {
                            Text(
                                text = "Whey Protein (1 Kg)",
                                fontSize = 15.sp,
                                style = MaterialTheme.typography.labelLarge
                            )

                            Spacer(modifier = Modifier.padding(1.dp))

                            Text(
                                text = "₹ ${uiState.value.cartPrice1}",
                                style = MaterialTheme.typography.labelMedium
                            )
                        }

                        Spacer(modifier = Modifier.weight(0.2f))

                        Box(
                            modifier = Modifier
                                .height(30.dp)
                                .width(70.dp)
                                .clip(RoundedCornerShape(6.dp))
                                .background(MaterialTheme.colorScheme.primary),
                            contentAlignment = Alignment.Center
                        ) {
                            Row {

                                Text(
                                    text = "-",
                                    modifier = Modifier
                                        .clickable { vm.cartMinus1() },
                                    style = TextStyle(
                                        color = Color.White,
                                        fontWeight = FontWeight.Bold
                                    )
                                )

                                Spacer(modifier = Modifier.padding(8.dp))

                                Text(
                                    text = "${uiState.value.cartCount1}",
                                    color = Color.White,
                                    fontWeight = FontWeight.Bold
                                )

                                Spacer(modifier = Modifier.padding(8.dp))

                                Text(
                                    text = "+",
                                    modifier = Modifier
                                        .clickable { vm.cartPlus1() },
                                    style = TextStyle(
                                        color = Color.White,
                                        fontWeight = FontWeight.Bold
                                    )
                                )

                            }
                        }
                    }

                    Spacer(modifier = Modifier.padding(5.dp))

//                    this is item 2
                    Row(
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.Center
                    ) {
                        Box(
                            modifier = Modifier
                                .border(
                                    width = 1.dp,
                                    color = Color.LightGray,
                                    shape = RoundedCornerShape(15.dp)
                                )
                                .padding(10.dp)
                        ) {
                            Image(
                                painter = painterResource(id = R.drawable.amul),
                                contentDescription = "amul ide cream",
                                modifier = Modifier.size(50.dp)
                            )
                        }

                        Spacer(modifier = Modifier.padding(5.dp))

                        Column() {
                            Text(
                                text = "Amul Ice cream (150 gm)",
                                fontSize = 15.sp,
                                style = MaterialTheme.typography.labelLarge
                            )

                            Spacer(modifier = Modifier.padding(1.dp))

                            Text(
                                text = "₹ ${uiState.value.cartPrice2}",
                                style = MaterialTheme.typography.labelMedium
                            )
                        }

                        Spacer(modifier = Modifier.weight(0.2f))

                        Box(
                            modifier = Modifier
                                .height(30.dp)
                                .width(70.dp)
                                .clip(RoundedCornerShape(6.dp))
                                .background(MaterialTheme.colorScheme.primary),
                            contentAlignment = Alignment.Center
                        ) {
                            Row {

                                Text(
                                    text = "-",
                                    modifier = Modifier
                                        .clickable { vm.cartMinus2() },
                                    style = TextStyle(
                                        color = Color.White,
                                        fontWeight = FontWeight.Bold
                                    )
                                )

                                Spacer(modifier = Modifier.padding(8.dp))

                                Text(
                                    text = "${uiState.value.cartCount2}",
                                    color = Color.White,
                                    fontWeight = FontWeight.Bold
                                )

                                Spacer(modifier = Modifier.padding(8.dp))

                                Text(
                                    text = "+",
                                    modifier = Modifier
                                        .clickable { vm.cartPlus2() },
                                    style = TextStyle(
                                        color = Color.White,
                                        fontWeight = FontWeight.Bold
                                    )
                                )

                            }
                        }
                    }

                    Spacer(modifier = Modifier.padding(5.dp))

//                    this is item 3
                    Row(
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.Center
                    ) {
                        Box(
                            modifier = Modifier
                                .border(
                                    width = 1.dp,
                                    color = Color.LightGray,
                                    shape = RoundedCornerShape(15.dp)
                                )
                                .padding(10.dp)
                        ) {
                            Image(
                                painter = painterResource(id = R.drawable.oats),
                                contentDescription = "Oats",
                                modifier = Modifier.size(50.dp)
                            )
                        }

                        Spacer(modifier = Modifier.padding(5.dp))

                        Column() {
                            Text(
                                text = "Saffola Oats (500 gm)",
                                fontSize = 15.sp,
                                style = MaterialTheme.typography.labelLarge
                            )

                            Spacer(modifier = Modifier.padding(1.dp))

                            Text(
                                text = "₹ ${uiState.value.cartPrice3}",
                                style = MaterialTheme.typography.labelMedium
                            )
                        }

                        Spacer(modifier = Modifier.weight(0.2f))

                        Box(
                            modifier = Modifier
                                .height(30.dp)
                                .width(70.dp)
                                .clip(RoundedCornerShape(6.dp))
                                .background(MaterialTheme.colorScheme.primary),
                            contentAlignment = Alignment.Center
                        ) {
                            Row {

                                Text(
                                    text = "-",
                                    modifier = Modifier
                                        .clickable { vm.cartMinus3() },
                                    style = TextStyle(
                                        color = Color.White,
                                        fontWeight = FontWeight.Bold
                                    )
                                )

                                Spacer(modifier = Modifier.padding(8.dp))

                                Text(
                                    text = "${uiState.value.cartCount3}",
                                    color = Color.White,
                                    fontWeight = FontWeight.Bold
                                )

                                Spacer(modifier = Modifier.padding(8.dp))

                                Text(
                                    text = "+",
                                    modifier = Modifier
                                        .clickable { vm.cartPlus3() },
                                    style = TextStyle(
                                        color = Color.White,
                                        fontWeight = FontWeight.Bold
                                    )
                                )

                            }
                        }
                    }

                }
            }

            Box(modifier = Modifier.padding(10.dp)) {
                Column {
                    Text(
                        text = "Before You checkout",
                        fontWeight = FontWeight.Bold,
                        fontSize = 20.sp
                    )

                    Spacer(modifier = Modifier.padding(10.dp))

// Scrollable Row

                    Row(
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.Center,
                        modifier = Modifier.horizontalScroll(state = rememberScrollState())
                    ) {
                        Box(
                            modifier = Modifier
                                .width(200.dp)
                        ) {
                            Column {
                                Card {
                                    Column {
                                        Image(
                                            painter = painterResource(id = R.drawable.rakhi),
                                            contentDescription = "Rakhi"
                                        )
                                        Text(text = "FREE DELIVERY")
                                    }
                                }
                                Box() {
                                    Column {
                                        Text(
                                            text = "raksha bandhan special rakhi 50% OFF",
                                            fontWeight = FontWeight.Bold
                                        )
                                        Row(
                                            verticalAlignment = Alignment.CenterVertically,
                                            horizontalArrangement = Arrangement.Center
                                        ) {
                                            Text(
                                                text = "₹ 98",
                                                fontWeight = FontWeight.Bold
                                            )

                                            Spacer(modifier = Modifier.weight(0.2f))

                                            Button(
                                                onClick = { },
                                                shape = RoundedCornerShape(8.dp)
                                            )
                                            {
                                                Text(text = "ADD")
                                            }
                                        }
                                    }

                                }
                            }
                        }

                        Spacer(modifier = Modifier.padding(10.dp))

//                        item 2nd
                        Box(
                            modifier = Modifier
                                .width(200.dp)
                        ) {
                            Column {
                                Card {
                                    Column {
                                        Image(
                                            painter = painterResource(id = R.drawable.rakhi),
                                            contentDescription = "Rakhi"
                                        )
                                        Text(text = "FREE DELIVERY")
                                    }
                                }
                                Box() {
                                    Column {
                                        Text(
                                            text = "raksha bandhan special rakhi 50% OFF",
                                            fontWeight = FontWeight.Bold
                                        )
                                        Row(
                                            verticalAlignment = Alignment.CenterVertically,
                                            horizontalArrangement = Arrangement.Center
                                        ) {
                                            Text(
                                                text = "₹ 98",
                                                fontWeight = FontWeight.Bold
                                            )

                                            Spacer(modifier = Modifier.weight(0.2f))

                                            Button(
                                                onClick = { },
                                                shape = RoundedCornerShape(8.dp)
                                            )
                                            {
                                                Text(text = "ADD")
                                            }
                                        }
                                    }

                                }
                            }
                        }


                        Spacer(modifier = Modifier.padding(10.dp))

//                        item 3rd
                        Box(
                            modifier = Modifier
                                .width(200.dp)
                        ) {
                            Column {
                                Card {
                                    Column {
                                        Image(
                                            painter = painterResource(id = R.drawable.rakhi),
                                            contentDescription = "Rakhi"
                                        )
                                        Text(text = "FREE DELIVERY")
                                    }
                                }
                                Box() {
                                    Column {
                                        Text(
                                            text = "raksha bandhan special rakhi 50% OFF",
                                            fontWeight = FontWeight.Bold
                                        )
                                        Row(
                                            verticalAlignment = Alignment.CenterVertically,
                                            horizontalArrangement = Arrangement.Center
                                        ) {
                                            Text(
                                                text = "₹ 98",
                                                fontWeight = FontWeight.Bold
                                            )

                                            Spacer(modifier = Modifier.weight(0.2f))

                                            Button(
                                                onClick = { },
                                                shape = RoundedCornerShape(8.dp)
                                            )
                                            {
                                                Text(text = "ADD")
                                            }
                                        }
                                    }

                                }
                            }
                        }

                        Spacer(modifier = Modifier.padding(10.dp))

//                        item 4th
                        Box(
                            modifier = Modifier
                                .width(200.dp)
                        ) {
                            Column {
                                Card {
                                    Column {
                                        Image(
                                            painter = painterResource(id = R.drawable.rakhi),
                                            contentDescription = "Rakhi"
                                        )
                                        Text(text = "FREE DELIVERY")
                                    }
                                }
                                Box() {
                                    Column {
                                        Text(
                                            text = "raksha bandhan special rakhi 50% OFF",
                                            fontWeight = FontWeight.Bold
                                        )
                                        Row(
                                            verticalAlignment = Alignment.CenterVertically,
                                            horizontalArrangement = Arrangement.Center
                                        ) {
                                            Text(
                                                text = "₹ 98",
                                                fontWeight = FontWeight.Bold
                                            )

                                            Spacer(modifier = Modifier.weight(0.2f))

                                            Button(
                                                onClick = { },
                                                shape = RoundedCornerShape(8.dp)
                                            )
                                            {
                                                Text(text = "ADD")
                                            }
                                        }
                                    }

                                }
                            }
                        }
                    }

                }

            }
            Row(
                modifier = Modifier.padding(8.dp),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.Center
            ) {
                Image(
                    imageVector = Icons.Default.Percent,
                    contentDescription = ""
                )

                Spacer(modifier = Modifier.padding(10.dp))

                Text(
                    text = "Use Coupons Card",
                    fontWeight = FontWeight.Bold,
                    fontSize = 20.sp
                )

                Spacer(modifier = Modifier.weight(0.2f))

                Image(
                    imageVector = Icons.Default.ArrowRight,
                    contentDescription = "",
                    modifier = Modifier.clickable {
                        navController.navigate(CartNavigation.CouponCode.route) }
                )

            }

            Spacer(modifier = Modifier.padding(10.dp))

            Box(modifier = Modifier.padding(10.dp)) {
                Column {
                    Text(
                        text = "Bill details",
                        fontWeight = FontWeight.Bold,
                        fontSize = 20.sp
                    )

                    Spacer(modifier = Modifier.padding(8.dp))

                    Row(modifier = Modifier.padding(5.dp)) {
                        Image(
                            imageVector = Icons.Default.AddChart,
                            contentDescription = ""
                        )

                        Spacer(modifier = Modifier.padding(4.dp))

                        Text(
                            text = "item total",
                            fontStyle = FontStyle.Italic
                        )

                        Spacer(modifier = Modifier.weight(0.2f))

                        Text(text = "₹ ${vm.totalItem()}")

                    }
                    Row(modifier = Modifier.padding(5.dp)) {
                        Image(
                            imageVector = Icons.Default.DeliveryDining,
                            contentDescription = ""
                        )

                        Spacer(modifier = Modifier.padding(4.dp))

                        Text(
                            text = "Delivery Charges",
                            fontStyle = FontStyle.Italic
                        )
                        Spacer(modifier = Modifier.weight(0.2f))
                        Text(text = "₹ 15")

                    }

                    Row(modifier = Modifier.padding(5.dp)) {
                        Text(
                            text = "Grand Total",
                            fontWeight = FontWeight.Bold,
                            fontSize = 17.sp
                        )
                        Spacer(modifier = Modifier.weight(0.2f))
                        Text(
                            text = "₹ ${vm.grandTotal()}",
                            fontWeight = FontWeight.Bold
                        )

                    }
                }
            }

            Box(modifier = Modifier.padding(10.dp)) {
                Button(
                    onClick = {navController.navigate(CartNavigation.PlaceOrder.route)},
                    colors = ButtonDefaults.buttonColors(Orange),
                    shape = RoundedCornerShape(10.dp),
                    modifier = Modifier
                        .width(400.dp)
                        .height(60.dp)
                ) {
                    Text(
                        text = "Placed Your Order",
                        fontSize = 18.sp,
                        fontWeight = FontWeight.Bold
                    )
                }
            }
        }

    }
}




@Preview(showSystemUi = true)
@Composable
fun CartScreenPreview() {
    CartPageTheme {
        CartScreen(rememberNavController())
    }
}