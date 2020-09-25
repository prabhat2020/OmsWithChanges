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
import org.springframework.transaction.annotation.Transactional

@Repository
interface ProductRepository : JpaRepository<Product, Int> {
    @Modifying
    @Transactional
    @Query(value="Update Product p set p.QTY = :Quantity WHERE p.PRODUCT_ID = :ID")
    fun updateQty(@Param("ID") prod_id:Int, @Param("Quantity") newQty:Int)
}
@Repository
interface ProductPriceRepository : JpaRepository<ProductPrice, Int> {
    fun findByprod(prod: Product): ProductPrice
}
@Repository
interface OrderDetailsRepository : JpaRepository<OrderDetails, Int>
@Repository
interface TransportRepository : JpaRepository<Transport, Int> {
    fun findByorder(order: OrderDetails): Transport

}