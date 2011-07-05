package com.example.warehouse

import org.scalatest.WordSpec
import com.borachio.generated.GeneratedMockFactory
import com.borachio.scalatest.MockFactory
import com.borachio.VerboseErrors
import java.net.URL

class WarehouseTest extends WordSpec with MockFactory with GeneratedMockFactory with VerboseErrors {
  
  def mockClassPath = new URL("file:target/scala_2.9.0/mock-classes/")
  
  "An order" when {
    "in stock" should {
      "remove inventory" in {
        val mockWarehouse = mockObject(Warehouse)
        inSequence {
          mockWarehouse.expects.hasInventory("Talisker", 50) returning true once;
          mockWarehouse.expects.remove("Talisker", 50) once
        }
        
        val order = new Order("Talisker", 50)
        order.fill
        
        assert(order.filled)
      }
    }
  }
}