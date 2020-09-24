package com.omsproj.oms.productmodel

import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id
import javax.validation.constraints.NotBlank
import javax.validation.constraints.NotNull

@Entity
data class OrderDetails (
        @Id @GeneratedValue(strategy = GenerationType.AUTO)
        val ORDER_ID: Int ,

        @NotNull
        val PRODUCT_ID: Int ,

        @NotNull
        val TOTAL_PRICE: Double

)