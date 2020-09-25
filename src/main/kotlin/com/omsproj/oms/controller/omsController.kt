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

        @GetMapping("/product/{id}/{quantity}")
        fun getProductByQty(@PathVariable(value = "id") id: Int, @PathVariable(value = "quantity") qty: Int): ResponseEntity<String> {
            return ResponseEntity.ok().body(productControl.getProdByQty(id, qty))
        }
        @GetMapping("/totalprice/{id}/{quantity}")
        fun getProductTotalPrice(@PathVariable(value = "id") id:Int,@PathVariable(value = "quantity") qty:Int): ResponseEntity<String>  {
            return ResponseEntity.ok().body(productControl.getProdTotalPrice(id,qty))
        }


   //Price Related
  //add Price
   @PostMapping("/product")
   fun createNewProduct(@Valid @RequestBody prod: ProductPrice):ResponseEntity<String> {
       priceControl.addProductPrice(prod)
       return ResponseEntity.ok().body("Product Added Successfully")
   }
        //Get Price
//        @GetMapping("/price/{id}/{productId}")
//        fun getPrice(@PathVariable(value="id") id:Int,@PathVariable(value = "productId") productId:Int) : ResponseEntity<String> {
//            return  ResponseEntity.ok().body(priceControl.getPrice(id,productId))
//        }



        //orderrelated

        //insert order
//        @PostMapping("/order/{id}/{quantity}")
//        fun createOrder(@PathVariable(value = "id") id:Int,@PathVariable(value = "quantity") qty:Int) =
//        ResponseEntity.ok().body(orderControl.createOrder(id,qty))

        @GetMapping("/order/{id}/")
        fun getOrderStatusByOrderID(@PathVariable(value = "id") id:Int): ResponseEntity<String>  {
            return ResponseEntity.ok().body(orderControl.getOrderByID(id))
        }

        //transport thing

        @GetMapping("/transport/{orderId}")
        fun getTransportByOrderId(@PathVariable(value = "orderId") id:Int): ResponseEntity<String>  {
            return ResponseEntity.ok().body(transportControl.getTransportByOrderId(id))
        }
        @PostMapping("/placeorder/{quantity}")
        fun createNewOrder(@Valid @RequestBody order: Transport,@PathVariable(value = "quantity") qty:Int): ResponseEntity<String> {
            return ResponseEntity.ok().body(transportControl.createNewOrder(order,qty))
        }
    }


