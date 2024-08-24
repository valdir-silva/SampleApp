package com.example.valdirssampleapp.sdui

import com.squareup.moshi.JsonAdapter
import com.squareup.moshi.JsonReader
import com.squareup.moshi.JsonWriter
import com.squareup.moshi.Moshi
import com.squareup.moshi.Types
import java.lang.reflect.Type

class CustomPolymorphicJsonAdapterFactory<T>(
    private val baseType: Class<T>,
    private val labelKey: String,
    private val subtypes: Map<String, Class<*>>,
) : JsonAdapter.Factory {

    override fun create(type: Type, annotations: Set<Annotation>, moshi: Moshi): JsonAdapter<*>? {
        if (Types.getRawType(type) != baseType || annotations.isNotEmpty()) {
            return null
        }

        val labelAdapter = moshi.adapter(String::class.java)

        return object : JsonAdapter<T>() {
            override fun fromJson(reader: JsonReader): T? {
                val jsonObject = reader.readJsonValue() as? Map<*, *> ?: return null
                val label = labelAdapter.fromJsonValue(jsonObject[labelKey])?.lowercase() ?: return null
                val subtype = subtypes[label] ?: return null
                val adapter = moshi.adapter(subtype)
                return adapter.fromJsonValue(jsonObject) as T
            }

            override fun toJson(writer: JsonWriter, value: T?) {
                // Implementação para serialização, se necessário
            }
        }
    }

    class Builder<T>(private val baseType: Class<T>, private val labelKey: String) {
        private val subtypes = mutableMapOf<String, Class<*>>()

        fun addSubtype(subtype: Class<*>, label: String): Builder<T> {
            subtypes[label.lowercase()] = subtype
            return this
        }

        fun build(): CustomPolymorphicJsonAdapterFactory<T> {
            return CustomPolymorphicJsonAdapterFactory(baseType, labelKey, subtypes)
        }
    }
}