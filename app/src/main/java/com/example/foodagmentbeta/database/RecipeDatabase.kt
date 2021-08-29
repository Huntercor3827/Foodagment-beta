package com.codingwithme.recipeapp.database

import android.content.Context
import android.os.Parcel
import android.os.Parcelable
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.foodagmentbeta.dao.RecipeDao
import com.example.foodagmentbeta.entities.CategoryItems
import com.example.foodagmentbeta.entities.Recipes
import com.example.foodagmentbeta.entities.Category
import com.example.foodagmentbeta.entities.converter.CategoryListConvertor

@Database(entities = [Recipes::class, CategoryItems::class, Category::class, CategoryListConvertor::class],version = 1,exportSchema = false)

abstract class RecipeDatabase() : RoomDatabase(), Parcelable {

    companion object{

        var recipesDatabase:RecipeDatabase? = null

        @Synchronized
        fun getDatabase(context: Context): RecipeDatabase{
            if (recipesDatabase == null){
                recipesDatabase = Room.databaseBuilder(
                    context,
                    RecipeDatabase::class.java,
                    "recipe.db"
                ).build()
            }
            return recipesDatabase!!
        }
    }

    constructor(parcel: Parcel) : this() {
    }

    abstract fun recipeDao(): RecipeDao
    override fun writeToParcel(parcel: Parcel, flags: Int) {

    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<RecipeDatabase> {
        override fun createFromParcel(parcel: Parcel): RecipeDatabase {
            return RecipeDatabase(parcel)
        }

        override fun newArray(size: Int): Array<RecipeDatabase?> {
            return arrayOfNulls(size)
        }
    }
}