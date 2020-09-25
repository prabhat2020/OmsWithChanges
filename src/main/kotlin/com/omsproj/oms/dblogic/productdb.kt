package com.omsproj.oms.dblogic

import com.omsproj.oms.repository.OrderDetailsRepository
import com.omsproj.oms.repository.ProductRepository
import com.omsproj.oms.productmodel.Product
import org.springframework.stereotype.Repository
import org.springframework.web.bind.annotation.RequestBody
import javax.validation.Valid


@Repository
class Productdb(private val prodcs: ProductRepository) {

//    fun createNewProduct(prod: Product): Product =
//            prodcs.save(prod)

    fun getProductByID(id:Int):Product{
        return prodcs.findById(id).orElse(null)
    }
    fun updateQuantity(id: Int, updatedQty: Int) {
        prodcs.updateQty(id,updatedQty)
    }
}