package com.omsproj.oms.productmodel

import javax.persistence.*
import javax.validation.constraints.NotBlank
import javax.validation.constraints.NotNull

@Entity
data class OrderDetails (
        @Column(name = "ORDER_ID")
        @Id @GeneratedValue(strategy = GenerationType.AUTO)
        val ORDER_ID: Int ,

        @NotNull
        val PRODUCT_ID: Int ,

        @NotNull
        var TOTAL_PRICE: Double

)