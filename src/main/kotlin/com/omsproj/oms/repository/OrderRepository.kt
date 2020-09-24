package com.omsproj.oms.repository

import com.omsproj.oms.productmodel.Product
import com.omsproj.oms.productmodel.ProductPrice
import com.omsproj.oms.productmodel.OrderDetails
import com.omsproj.oms.productmodel.Transport
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Modifying
import org.springframework.data.jpa.repository.Query
import org.springframework.data.repository.query.Param
import org.springframework.stereotype.Repository

@Repository
interface ProductRepository : JpaRepository<Product, Int> {
    @Modifying
    @Query(value="Update Product p set p.QTY = :Quantity WHERE p.PRODUCT_ID = :ID",nativeQuery = true)
    fun updateQuantity(@Param("ID") id: Int?,@Param("Quantity") quantity: Int?)
}
@Repository
interface ProductPriceRepository : JpaRepository<ProductPrice, Int> {
    fun findAmtByProductId(@Param("PRODUCT_ID") prodId: Int?): Double
}
@Repository
interface OrderDetailsRepository : JpaRepository<OrderDetails, Int>
@Repository
interface TransportRepository : JpaRepository<Transport, Int> {
    fun findByOrderID(@Param("ORDER_ID") orderid: Int?): Transport?

}