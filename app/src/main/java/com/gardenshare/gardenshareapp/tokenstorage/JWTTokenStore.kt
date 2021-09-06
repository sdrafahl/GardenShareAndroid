package com.gardenshare.gardenshareapp.tokenstorage

import android.content.SharedPreferences
import arrow.core.Option
import com.gardenshare.gardenshareapp.models.JWTToken

abstract class JWTTokenStore {
    suspend abstract fun setToken(token: JWTToken): Unit
    suspend abstract fun getToken(): Option<JWTToken>
    companion object Impl {
        private val jwtTokenKey: String = "JWTToken"
         fun createStore(preference: SharedPreferences) = object : JWTTokenStore() {
             override suspend fun setToken(token: JWTToken): Unit {
                 preference.edit().putString(jwtTokenKey, token.value).commit()
             }

             override suspend fun getToken(): Option<JWTToken> {
                 val defaultValue = ""
                 val currentStoredValue = preference.getString(jwtTokenKey, null)
                 return Option.fromNullable(currentStoredValue).map { st -> JWTToken(st) }
             }
         }
    }
}