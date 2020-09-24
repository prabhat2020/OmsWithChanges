package com.omsproj.oms.dblogic

import com.omsproj.oms.repository.OrderDetailsRepository
import com.omsproj.oms.repository.ProductRepository
import com.omsproj.oms.productmodel.Product
import com.omsproj.oms.productmodel.ProductPrice
import com.omsproj.oms.repository.ProductPriceRepository
import org.springframework.stereotype.Repository
import org.springframework.web.bind.annotation.RequestBody
import javax.validation.Valid

@Repository
class Pricedb(private val pricedcs: ProductPriceRepository) {

    fun createPrice(price: ProductPrice): ProductPrice =
            pricedcs.save(price)

    fun getPrice(id:Int): Double {
        return pricedcs.findAmtByProductId(id)
    }
}