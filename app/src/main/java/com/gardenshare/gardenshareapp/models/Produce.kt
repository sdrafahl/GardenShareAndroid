package com.gardenshare.gardenshareapp.models

import arrow.core.None
import arrow.core.Option
import arrow.core.Some
import arrow.core.getOrElse
import com.beust.klaxon.Converter
import com.beust.klaxon.JsonValue

sealed class Produce {
    object BrownOysterMushrooms : Produce()
    object InvalidProduce : Produce()


    companion object Comp {
        fun apply(str: String?): Option<Produce> = when(str) {
            "BrownOysterMushrooms" -> Some(BrownOysterMushrooms)
            else -> None
        }

        val produceCompanionObject = object: Converter {
            override fun canConvert(cls: Class<*>): Boolean {
                return cls == Produce::class.java
            }

            override fun fromJson(jv: JsonValue): Any? {
                return (apply(jv.string)).getOrElse { return InvalidProduce }
            }

            override fun toJson(value: Any): String {
                return value.toString()
            }
        }
    }

    override fun toString(): String {
        return when(this) {
            is BrownOysterMushrooms -> "BrownOysterMushrooms"
            is InvalidProduce -> "InvalidProduce"
        }
    }
}
