package com.omsproj.oms.service

import com.omsproj.oms.dblogic.Productdb
import com.omsproj.oms.productmodel.Product
import org.springframework.stereotype.Service
import java.time.LocalDate
import com.omsproj.oms.dblogic.Pricedb

@Service
class ProductService(private val prodserv: Productdb,private val priceserv: Pricedb) {

    companion object {
        fun productAvailability(id: Int,qty:Int,prod: Product): String {
            var result = " "
            result = when {
                prod == null -> {
                    "Product with $id doesn't exist"
                }
                prod.QTY < qty -> {
                    "Product with $id doesn't has sufficient quantity"
                }
                prod.VALID_TO < java.sql.Date.valueOf(LocalDate.now()) && prod.VALID_FROM > java.sql.Date.valueOf(LocalDate.now()) -> {
                    "Product with $id is not valid"
                }
                else -> {
                    "Available"
                }
            }
            return  result.toString()
        }
    }

    fun getProdByQty(id:Int,qty:Int):String{
        var prod = prodserv.getProductByID(id)
        var result = productAvailability(id,qty,prod)
        return when (result) {
            "Available" -> prod.toString()
            else -> result.toString()
        }
    }
    fun getProdTotalPrice(id:Int,qty:Int):String{
        var result = " "
        var prod = prodserv.getProductByID(id)
        result = when {
            prod == null -> {
                "Product with $id doesn't exist"
            }
            prod.QTY < qty -> {
                "Product with $id doesn't has sufficient quantity"
            }
            prod.VALID_TO < java.sql.Date.valueOf(LocalDate.now()) && prod.VALID_FROM > java.sql.Date.valueOf(LocalDate.now())  -> {
                "Product with $id is not valid"
            }
            else -> {
                var totalPrice:Double = 0.0
                totalPrice = qty * priceserv.getProductPriceByProductID(prod).AMOUNT
                totalPrice.toString()
            }
        }
        return result
    }
}


