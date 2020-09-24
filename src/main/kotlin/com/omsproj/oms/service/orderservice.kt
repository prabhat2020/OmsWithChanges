package com.omsproj.oms.service

import com.omsproj.oms.dblogic.Orderdb
import com.omsproj.oms.dblogic.Pricedb
import com.omsproj.oms.dblogic.Productdb
import com.omsproj.oms.dblogic.Transportdb
import com.omsproj.oms.productmodel.OrderDetails
import com.omsproj.oms.productmodel.Transport
import org.springframework.stereotype.Service
import java.sql.Date
import java.time.LocalDate


@Service
class OrderService(private val orddb: Orderdb,private val proddb: Productdb,private val pricdb: Pricedb,private val transdb:Transportdb) {

    fun createOrder(id: Int,qty:Int):String {
        var result = ""
        result = when {
            proddb.getProduct(id) == null -> {
                "Product with $id doesn't exist"
            }
            proddb.getProduct(id).QTY < qty -> {
                "Product with $id doesn't has sufficient quantity"
            }
            proddb.getProduct(id).VALID_TO < java.sql.Date.valueOf(LocalDate.now())  -> {
                "Product with $id is not valid"
            }
            else -> {
                var totalPrice:Double = 0.0
                totalPrice = qty * pricdb.getPrice(id)
                var order: OrderDetails = orddb.createOrder(OrderDetails(0,id,totalPrice))
                transdb.createNewTransportRequest(Transport(0,order.ORDER_ID,0,"Order Placed", Date.valueOf(LocalDate.now()),null))
                order.toString()
            }

        }
        return result
    }

    fun getOrder(id:Int):String{
        var result = " "
        result = when {
            orddb.getOrder(id) == null ->{
                "Order with $id not found"
            }
            else ->{
                orddb.getOrder(id).toString()
            }
        }
        return result
    }
}