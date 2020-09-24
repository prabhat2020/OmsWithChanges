package com.omsproj.oms.productmodel

import java.util.*
import javax.persistence.*
import javax.validation.constraints.NotBlank
import javax.validation.constraints.NotNull

@Entity
@NamedQuery(name="Transport.findByOrderID", query="SELECT p FROM Transport p WHERE p.ORDER_ID = :ORDER_ID")
data class Transport(
        @Id @GeneratedValue(strategy = GenerationType.AUTO)
        val ID: Int = 0,

        @NotNull
        val ORDER_ID: Int = 0,

        @NotNull
        val STAGE_ID: Int = 0,

        @get: NotBlank
        val STATUS: String = "",

        @NotNull
        val START_TIME: Date = Date(),


        val END_TIME: Date? = Date()

)