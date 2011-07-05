package com.example.warehouse

import org.scalatest.FunSuite
import com.borachio.generated.GeneratedMockFactory
import com.borachio.scalatest.MockFactory
import com.borachio.VerboseErrors
import java.net.URL

class WarehouseTest extends FunSuite with MockFactory with GeneratedMockFactory with VerboseErrors {
  
  def mockClassPath = new URL("file:target/scala_2.9.0/mock-classes/")
  
  test("Enough stock") {
    val mockWarehouse = mockObject(Warehouse)
    inSequence {
      mockWarehouse.expects.hasInventory("Talisker", 50) returning true once;
      mockWarehouse.expects.remove("Talisker", 50) once
    }
    
    val order = Order("Talisker", 50)
    order.fill
    
    assert(order.filled)
  }
  
  test("Not enough stock") {
    val mockWarehouse = mockObject(Warehouse)
    mockWarehouse.expects.hasInventory(*, *) returning false once
    
    val order = Order("Talisker", 50)
    order.fill
    
    assert(!order.filled)
  }
  
  test("Order everything") {
    val mockWarehouse = mockObject(Warehouse)
    val mockOrder = mock[Order]
    
    inSequence {
      mockWarehouse.expects.inStock("Laphroig") returning 10
      mockOrder.expects.newInstance("Laphroig", 10)
    }
    
    Order.largestPossible("Laphroig")
  }
}