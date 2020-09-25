package com.omsproj.oms.dblogic

import com.omsproj.oms.productmodel.OrderDetails
import com.omsproj.oms.productmodel.Transport
import com.omsproj.oms.repository.TransportRepository
import org.springframework.stereotype.Repository


@Repository
class Transportdb(private val transport: TransportRepository) {

    fun getTransportStatusByOrderID(order: OrderDetails): Transport {
        return transport.findByorder(order)
    }
    fun createNewOrder(order: Transport) =
            transport.save(order)
}