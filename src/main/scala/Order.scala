package com.example.warehouse

class Order(product: String, quantity: Int) {
  var filled = false
  
  def fill() {
    if (Warehouse.hasInventory(product, quantity)) {
      Warehouse.remove(product, quantity)
      filled = true
    }
  }
}

object Order {
  def apply(product: String, quantity: Int) = 
    new Order(product, quantity)
    
  def largestPossible(product: String) = {
    val quantity = Warehouse.inStock(product)
    new Order(product, quantity)
  }
}