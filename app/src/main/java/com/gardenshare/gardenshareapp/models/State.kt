package com.gardenshare.gardenshareapp.models

import arrow.core.None
import arrow.core.Option
import arrow.core.Some
import arrow.core.getOrElse
import com.beust.klaxon.Converter
import com.beust.klaxon.JsonValue

sealed class State {
    object AL  : State()
    object AK  : State()
    object AZ  : State()
    object AR  : State()
    object CA  : State()
    object CO  : State()
    object CT  : State()
    object DE  : State()
    object DC  : State()
    object FL  : State()
    object GA  : State()
    object HI  : State()
    object ID  : State()
    object IL  : State()
    object IN  : State()
    object IA  : State()
    object KS  : State()
    object KY  : State()
    object LA  : State()
    object ME  : State()
    object MD  : State()
    object MA  : State()
    object MI  : State()
    object MN  : State()
    object MS  : State()
    object MO  : State()
    object MT  : State()
    object NE  : State()
    object NV  : State()
    object NH  : State()
    object NJ  : State()
    object NM  : State()
    object NY  : State()
    object NC  : State()
    object ND  : State()
    object OH  : State()
    object OK  : State()
    object OR  : State()
    object PA  : State()
    object RI  : State()
    object SC  : State()
    object SD  : State()
    object TN  : State()
    object TX  : State()
    object UT  : State()
    object VT  : State()
    object VA  : State()
    object WA  : State()
    object WV  : State()
    object WI  : State()
    object WY  : State()
    object InvalidState : State()

    override fun toString(): String {
        return when(this) {
            is AL -> "AL"
            is AK -> "AK"
            is AZ -> "AZ"
            is AR -> "AR"
            is CA -> "CA"
            is CO -> "CO"
            is CT -> "CT"
            is DE -> "DE"
            is DC -> "DC"
            is FL -> "FL"
            is GA -> "GA"
            is HI -> "HI"
            is ID -> "ID"
            is IL -> "IL"
            is IN -> "IN"
            is IA -> "IA"
            is KS -> "KS"
            is KY -> "KY"
            is LA -> "LA"
            is ME -> "ME"
            is MD -> "MD"
            is MA -> "MA"
            is MI -> "MI"
            is MN -> "MN"
            is MS -> "MS"
            is MO -> "MO"
            is MT -> "MT"
            is NE -> "NE"
            is NV -> "NV"
            is NH -> "NH"
            is NJ -> "NJ"
            is NM -> "NM"
            is NY -> "NY"
            is NC -> "NC"
            is ND -> "ND"
            is OH -> "OH"
            is OK -> "OK"
            is OR -> "OR"
            is PA -> "PA"
            is RI -> "RI"
            is SC -> "SC"
            is SD -> "SD"
            is TN -> "TN"
            is TX -> "TX"
            is UT -> "UT"
            is VT -> "VT"
            is VA -> "VA"
            is WA -> "WA"
            is WV -> "WV"
            is WI -> "WI"
            is WY -> "WY"
            is InvalidState -> "InvalidState"
        }
    }

    companion object Comp {
        fun apply(str: String?): Option<State> = when(str) {
            "AL" -> Some(AL)
            "AK" -> Some(AK)
            "AZ" -> Some(AZ)
            "AR" -> Some(AR)
            "CA" -> Some(CA)
            "CO" -> Some(CO)
            "CT" -> Some(CT)
            "DE" -> Some(DE)
            "DC" -> Some(DC)
            "FL" -> Some(FL)
            "GA" -> Some(GA)
            "HI" -> Some(HI)
            "ID" -> Some(ID)
            "IL" -> Some(IL)
            "IN" -> Some(IN)
            "IA" -> Some(IA)
            "KS" -> Some(KS)
            "KY" -> Some(KY)
            "LA" -> Some(LA)
            "ME" -> Some(ME)
            "MD" -> Some(MD)
            "MA" -> Some(MA)
            "MI" -> Some(MI)
            "MN" -> Some(MN)
            "MS" -> Some(MS)
            "MO" -> Some(MO)
            "MT" -> Some(MT)
            "NE" -> Some(NE)
            "NV" -> Some(NV)
            "NH" -> Some(NH)
            "NJ" -> Some(NJ)
            "NM" -> Some(NM)
            "NY" -> Some(NY)
            "NC" -> Some(NC)
            "ND" -> Some(ND)
            "OH" -> Some(OH)
            "OK" -> Some(OK)
            "OR" -> Some(OR)
            "PA" -> Some(PA)
            "RI" -> Some(RI)
            "SC" -> Some(SC)
            "SD" -> Some(SD)
            "TN" -> Some(TN)
            "TX" -> Some(TX)
            "UT" -> Some(UT)
            "VT" -> Some(VT)
            "VA" -> Some(VA)
            "WA" -> Some(WA)
            "MV" -> Some(WV)
            "WI" -> Some(WI)
            "WY" -> Some(WY)
            else -> None
        }

        val codec = object: Converter {
            override fun canConvert(cls: Class<*>): Boolean {
                return cls == State::class.java
            }

            override fun fromJson(jv: JsonValue): Any? {
                return (apply(jv.string)).getOrElse { return InvalidState }
            }

            override fun toJson(value: Any): String {
                return value.toString()
            }
        }

    }
}
