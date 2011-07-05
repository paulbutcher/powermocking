package com.example.warehouse

import scala.collection.mutable.Map

object Warehouse {
  val products = Map(("Talisker" -> 5), ("Lagavulin" -> 2))
  
  def hasInventory(product: String, quantity: Int) = 
    inStock(product) >= quantity

  def remove(product: String, quantity: Int) = 
    products += (product -> (inStock(product) - quantity))
  
  def inStock(product: String) = products.getOrElse(product, 0)
}
