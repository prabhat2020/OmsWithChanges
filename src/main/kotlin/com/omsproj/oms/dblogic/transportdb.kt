package com.omsproj.oms.dblogic

import com.omsproj.oms.productmodel.Transport
import com.omsproj.oms.repository.TransportRepository
import org.springframework.stereotype.Repository


@Repository
class Transportdb(private val transport: TransportRepository) {

    fun createNewTransportRequest(trans: Transport) {
        transport.save(trans)
    }
    fun getTransportByOrderId(id:Int): Transport? {
        var transport:Transport? = transport.findByOrderID(id)
        return transport
    }

}