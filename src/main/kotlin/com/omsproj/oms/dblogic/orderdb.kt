package com.omsproj.oms.dblogic

import com.omsproj.oms.productmodel.OrderDetails
import com.omsproj.oms.repository.OrderDetailsRepository
import org.springframework.data.repository.findByIdOrNull
import org.springframework.stereotype.Repository


@Repository
class Orderdb(private val orderdet: OrderDetailsRepository) {

    fun createOrder(order: OrderDetails) :OrderDetails {
        var orderResp = orderdet.save(order)
        return orderResp
    }

    fun getOrderByOrderId(id:Int):OrderDetails? {
        return orderdet.findByIdOrNull(id)
    }
}