package com.omsproj.oms.productmodel

import javax.persistence.*
import javax.validation.constraints.NotBlank
import javax.validation.constraints.NotNull

@Entity
//@NamedQuery(name="ProductPrice.findAmtByProductId", query="SELECT p.AMOUNT FROM ProductPrice p WHERE p.PRODUCT_ID = :PRODUCT_ID")
data class ProductPrice (

        @Id @GeneratedValue(strategy = GenerationType.AUTO)
        var ID:Int = 0,
        @OneToOne(cascade= [CascadeType.ALL])
        @JoinColumn(name = "PRODUCT_ID")
        var prod:Product,

        @NotNull
        var AMOUNT: Double = 0.0,
        @get: NotBlank
        var CURRENCY: String = ""

)