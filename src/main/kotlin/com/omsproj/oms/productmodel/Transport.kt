package com.omsproj.oms.productmodel

import java.util.*
import javax.persistence.*
import javax.validation.constraints.NotBlank
import javax.validation.constraints.NotNull

@Entity

data class Transport(
        @Id @GeneratedValue(strategy = GenerationType.AUTO)
        val ID: Int = 0,

        @OneToOne(cascade= [CascadeType.ALL])
        @JoinColumn(name = "ORDER_ID")
        var order:OrderDetails,

        @NotNull
        val STAGE_ID: Int = 0,

        @get: NotBlank
        val STATUS: String = "",

        @NotNull
        val START_TIME: Date = Date(),


        val END_TIME: Date? = Date()

)