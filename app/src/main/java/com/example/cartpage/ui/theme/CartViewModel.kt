package com.example.cartpage.ui.theme

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow

class CartViewModel : ViewModel() {

    private val _uiState = MutableStateFlow(CartUiState())
    val uiState: StateFlow<CartUiState> = _uiState.asStateFlow()

    //    increase a number

   //  cart 1
    fun cartPlus1(){
        val count = uiState.value.cartCount1
        val price1 = uiState.value.cartPrice1
        val multiply1 = price1 + 1748
        if (count < 10){
            val updateState = uiState.value.copy(count + 1, cartPrice1 = multiply1,)
            _uiState.value = updateState
        }
    }

    //  cart 2
    fun cartPlus2(){
        val count = uiState.value.cartCount2
        val price2 = uiState.value.cartPrice2
        val multiply2 = price2 + 100
        if (count < 10){
            val updateState = uiState.value.copy(cartCount2 = count + 1, cartPrice2 = multiply2)
            _uiState.value = updateState
        }
    }

    //  cart 3
    fun cartPlus3(){
        val count = uiState.value.cartCount3
        val price3 = uiState.value.cartPrice3
        val multiply3 = price3 + 45
        if (count < 10){
            val updateState = uiState.value.copy(cartCount3 = count + 1, cartPrice3 = multiply3)
            _uiState.value = updateState
        }
    }

//    decreasing number

    // cart 1
    fun cartMinus1(){
        val count = uiState.value.cartCount1
        val price1 = uiState.value.cartPrice1
        val divide1 = price1 - 1748
        if (count > 1){
            val updateState = uiState.value.copy(count - 1, cartPrice1 = divide1)
            _uiState.value = updateState
        }
    }

    // cart 2
    fun cartMinus2(){
        val count = uiState.value.cartCount2
        val price2 = uiState.value.cartPrice2
        val divide2= price2 - 100
        if (count > 1){
            val updateState = uiState.value.copy(cartCount2 = count - 1, cartPrice2 = divide2)
            _uiState.value = updateState
        }
    }

    // cart 3
    fun cartMinus3(){
        val count = uiState.value.cartCount3
        val price3 = uiState.value.cartPrice3
        val divide3 = price3 - 45
        if (count > 1){
            val updateState = uiState.value.copy(cartCount3 = count - 1, cartPrice3 = divide3)
            _uiState.value = updateState
        }
    }


   // total item
   fun totalItem(): Int{
       val price1 = uiState.value.cartPrice1
       val price2 = uiState.value.cartPrice2
       val price3 = uiState.value.cartPrice3
      val total = price1 + price2 + price3
       return total

   }

  // Grand Total
  fun grandTotal(): Int{
      val price1 = uiState.value.cartPrice1
      val price2 = uiState.value.cartPrice2
      val price3 = uiState.value.cartPrice3
      val grandTotal = price1 + price2 + price3 + 15
      return grandTotal
  }


}





