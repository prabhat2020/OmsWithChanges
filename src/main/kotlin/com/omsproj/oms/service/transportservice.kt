package com.omsproj.oms.service

import com.omsproj.oms.dblogic.Orderdb
import com.omsproj.oms.dblogic.Pricedb
import com.omsproj.oms.dblogic.Productdb
import com.omsproj.oms.dblogic.Transportdb
import com.omsproj.oms.productmodel.Transport
import org.springframework.stereotype.Service


@Service

class TransportService(private val orddb: Orderdb, private val proddb: Productdb, private val pricdb: Pricedb, private val transdb:Transportdb) {

    fun getTransportByOrderId(id: Int):String {
        var order = orddb.getOrderByOrderId(id)
        return when {
            order != null ->  transdb.getTransportStatusByOrderID(order).toString()
            else ->  "Order ID doesn't exist"
        }
    }
    fun createNewOrder(order: Transport, qty:Int):String {
        var result = " "
        var prodID = order.order.PRODUCT_ID
        var prod = proddb.getProductByID(prodID)
        result = ProductService.productAvailability(prodID,qty,prod)
        return when(result) {
            "Available" -> {
                var totalPrice:Double = 0.0
                order.order.TOTAL_PRICE = qty * pricdb.getProductPriceByProductID(prod).AMOUNT
                transdb.createNewOrder(order)
                proddb.updateQuantity(prodID,prod.QTY - qty)
                order.toString()
            }
            else-> result.toString()
        }

    }
}