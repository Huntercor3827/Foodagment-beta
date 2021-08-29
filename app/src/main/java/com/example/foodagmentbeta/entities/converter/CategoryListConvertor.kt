package com.example.foodagmentbeta.entities.converter

import androidx.room.TypeConverter
import com.example.foodagmentbeta.entities.Category
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken

class CategoryListConvertor {
    @TypeConverter
    fun fromCategoryList(category: List<Category>):String?{
        if(category == null){
            return (null)
        }
        else{
            val gson = Gson()
            val type = object : TypeToken<Category>(){

            }.type
            return gson.toJson(category,type)
        }
    }

    @TypeConverter
    fun toCategoryList ( categoryString: String):List<Category> {
        if (categoryString == null()) {
            return (null)
        } else {
            val gson = Gson()
            val type = object : TypeToken<Category>() {

            }.type
            return gson.fromJson(categoryString, type)
        }
    }
}