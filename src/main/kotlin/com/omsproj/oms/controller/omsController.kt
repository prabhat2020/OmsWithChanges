package com.omsproj.oms.controller

//import com.omsproj.oms.repository.OrderDetailsRepository
//import com.omsproj.oms.repository.ProductPriceRepository
//import com.omsproj.oms.repository.TransportRepository
import com.omsproj.oms.repository.ProductRepository
import com.omsproj.oms.productmodel.*
import com.omsproj.oms.repository.OrderDetailsRepository
import com.omsproj.oms.service.OrderService
import com.omsproj.oms.service.PriceService
import com.omsproj.oms.service.ProductService
import com.omsproj.oms.service.TransportService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import java.util.*
import javax.validation.Valid


    @RestController
    @RequestMapping("/api")
    class Controller(val productControl: ProductService, val orderRepository:OrderDetailsRepository,val priceControl: PriceService,
    val orderControl:OrderService,private val transportControl: TransportService) {

        //Product related

        @PostMapping("/product")
        fun createNewProduct(@Valid @RequestBody prod: Product): Product =
                productControl.createNewProduct(prod)

        @GetMapping("/product/{id}/{quantity}")
        fun getProduct(@PathVariable(value="id") id:Int,@PathVariable(value = "quantity") qty:Int) : ResponseEntity<String> {
            return  ResponseEntity.ok().body(productControl.getProduct(id,qty))
        }

        @GetMapping("/totalprice/{id}/{quantity}")
        fun getProductTotalPrice(@PathVariable(value = "id") id:Int,@PathVariable(value = "quantity") qty:Int): ResponseEntity<String>  {
            return ResponseEntity.ok().body(productControl.getTotalPrice(id,qty))
        }


   //Price Related
  //add Price
        @PostMapping("/price")
        fun createPrice(@Valid @RequestBody price:ProductPrice) : ResponseEntity<String> {
      priceControl.createPrice(price)
      return ResponseEntity.ok().body("Price details added")
  }
        //Get Price
        @GetMapping("/price/{id}/{productId}")
        fun getPrice(@PathVariable(value="id") id:Int,@PathVariable(value = "productId") productId:Int) : ResponseEntity<String> {
            return  ResponseEntity.ok().body(priceControl.getPrice(id,productId))
        }



        //orderrelated

        //insert order
        @PostMapping("/order/{id}/{quantity}")
        fun createOrder(@PathVariable(value = "id") id:Int,@PathVariable(value = "quantity") qty:Int) =
        ResponseEntity.ok().body(orderControl.createOrder(id,qty))

        @GetMapping("/order/{id}/")
        fun getOrder(@PathVariable(value = "id") id:Int): ResponseEntity<String>  {
            return ResponseEntity.ok().body(orderControl.getOrder(id))
        }

        //transport thing

        @GetMapping("/transport/{orderid}")
        fun getTransportByOrderId(@PathVariable(value = "orderid") id:Int): ResponseEntity<String>  {
            return ResponseEntity.ok().body(transportControl.getTransportByOrderId(id))
        }
    }


