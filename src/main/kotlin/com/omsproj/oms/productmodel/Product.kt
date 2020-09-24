package com.omsproj.oms.productmodel

import org.jetbrains.annotations.NotNull
import java.util.*
import javax.persistence.*
import javax.validation.constraints.NotBlank

@Entity
data class Product (
        @Id
        val PRODUCT_ID: Int = 0,

        @get: NotBlank
        val NAME : String = "",

        @get: NotBlank
        val DESCR: String = "",

        @get: NotBlank
        val CATEGORY: String = "",

        @NotNull
        val VALID_FROM: Date = Date(),

        @NotNull
        val VALID_TO: Date = Date(),

       @NotNull
        val QTY: Int = 0


//        @OneToOne(fetch=FetchType.LAZY,cascade = [CascadeType.ALL])
//@JoinColumn(name = "PRODUCT_ID")
//val price:ProductPrice? = null
)