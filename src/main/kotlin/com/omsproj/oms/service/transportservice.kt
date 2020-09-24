package com.omsproj.oms.service

import com.omsproj.oms.dblogic.Transportdb
import org.springframework.stereotype.Service


@Service

class TransportService(private val transportserv: Transportdb) {

    fun getTransportByOrderId(id: Int):String {
        var response = transportserv.getTransportByOrderId(id)
        return response.toString()
    }
}