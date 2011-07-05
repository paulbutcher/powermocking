package com.example.warehouse

import scala.collection.mutable.Map

object Warehouse {
  val products = Map(("Talisker" -> 5), ("Lagavulin" -> 2))
  
  def hasInventory(product: String, quantity: Int) = inStock(product) >= quantity

  def remove(product: String, quantity: Int) = products += (product -> (inStock(product) - quantity))
  
  private def inStock(product: String) = products.get(product) match {
      case Some(quantity) => quantity
      case None => 0
    }
}

class Order(product: String, quantity: Int) {
  var filled = false
  
  def fill() {
    if (Warehouse.hasInventory(product, quantity)) {
      Warehouse.remove(product, quantity)
      filled = true
    }
  }
}