package com.omsproj.oms.service

import com.omsproj.oms.dblogic.Productdb
import com.omsproj.oms.dblogic.Pricedb
import com.omsproj.oms.productmodel.Product
import com.omsproj.oms.productmodel.ProductPrice
import org.springframework.stereotype.Service
import java.time.LocalDate

@Service
class PriceService(private val priceserv: Pricedb) {


    fun addProductPrice(prod: ProductPrice) {
        priceserv.createPrice(prod)
    }
//    fun createPrice( price: ProductPrice) = priceserv.createPrice(price)
//
//    fun getPrice(id:Int,productid:Int) : String {
//        var result = " "
//        result = when {
//            priceserv.getPrice(id) == null -> {
//                "Product with $id doesn't exist"
//            }
////            priceserv.getProduct(id).QTY < qty -> {
////                "Product with $id doesn't has sufficient quantity"
////            }
////            priceserv.getProduct(id).VALID_TO < java.sql.Date.valueOf(LocalDate.now())  -> {
////                "Product with $id is not valid"
////            }
//            else -> {
//                priceserv.getPrice(id).toString()
//            }
//        }
//        return result
//    }
}