package com.example.vaccinationcontrol.data

import android.util.Base64
import org.json.JSONObject

fun getEmailFromToken(token: String): String {
    val json = StringBuilder()

    val parts = token.split(".")
    try {
        var index = 0
        for (part in parts) {
            if (index >= 2) break
            index++
            val decodedBytes: ByteArray =
                Base64.decode(part.toByteArray(charset("UTF-8")), Base64.URL_SAFE)
            json.append(String(decodedBytes, Charsets.UTF_8))
        }
    } catch (e: Exception) {
        e.printStackTrace()
        throw RuntimeException("Couldn't decode jwt", e)
    }

    val separatorIndex = json.indexOf("}{")
    val payloadJson = json.substring(separatorIndex + 1)
    val payloadObject = JSONObject(payloadJson)
    return payloadObject.getString("email")
}