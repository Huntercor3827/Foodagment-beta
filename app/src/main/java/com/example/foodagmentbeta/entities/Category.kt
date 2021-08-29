package com.example.foodagmentbeta.entities
import androidx.room.*
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import androidx.room.TypeConverters
import com.example.foodagmentbeta.entities.converter.CategoryListConvertor
import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
@Entity(tableName = "Category")
data class Category(
        @PrimaryKey(autoGenerate = true)
        var id:Int,
        @ColumnInfo(name="categorieitems")
        @Expose
        @SerializedName("categories")
        @TypeConverters(CategoryListConvertor::class)
        var categorieitems: List<CategoryItems>? = null
)

