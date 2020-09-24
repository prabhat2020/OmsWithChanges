package com.omsproj.oms.service

import com.omsproj.oms.dblogic.Productdb
import com.omsproj.oms.productmodel.Product
import org.springframework.stereotype.Service
import java.time.LocalDate
import com.omsproj.oms.dblogic.Pricedb

@Service
class ProductService(private val prodserv: Productdb,private val priceserv: Pricedb) {

    fun createNewProduct( prod: Product) = prodserv.createNewProduct(prod)

    fun getProduct(id:Int,qty:Int) : String {
        var result = " "
        result = when {
            prodserv.getProduct(id) == null -> {
                "Product with $id doesn't exist"
            }
            prodserv.getProduct(id).QTY < qty -> {
                "Product with $id doesn't has sufficient quantity"
            }
            prodserv.getProduct(id).VALID_TO < java.sql.Date.valueOf(LocalDate.now())  -> {
                "Product with $id is not valid"
            }
            else -> {
                prodserv.getProduct(id).toString()
            }
        }
        return result
    }

    fun getTotalPrice(id:Int,qty:Int):String{
        var result = " "
        result = when {
            prodserv.getProduct(id) == null -> {
                "Product with $id doesn't exist"
            }
            prodserv.getProduct(id).QTY < qty -> {
                "Product with $id doesn't has sufficient quantity"
            }
            prodserv.getProduct(id).VALID_TO < java.sql.Date.valueOf(LocalDate.now())  -> {
                "Product with $id is not valid"
            }
            else -> {
                var totalPrice:Double = 0.0
                totalPrice = qty * priceserv.getPrice(id)
                totalPrice.toString()
            }
        }
        return result
    }
}


