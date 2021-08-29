package com.example.foodagmentbeta

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.foodagmentbeta.adapter.MainCategoryAdapter
import com.example.foodagmentbeta.adapter.SubCategoryAdapter
import com.example.foodagmentbeta.entities.Recipes
import kotlinx.android.synthetic.main.activity_home.*

class HomeActivity : AppCompatActivity() {
    var arrMainCategory = ArrayList<Recipes>()
    var arrSubCategory = ArrayList<Recipes>()
    var mainCategoryAdapter = MainCategoryAdapter()
    var subCategoryAdapter = SubCategoryAdapter()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

        //Temp data
        arrMainCategory.add(Recipes(1, "Beef"))
        arrMainCategory.add(Recipes(2, "Chicken"))
        arrMainCategory.add(Recipes(3, "Pork"))
        arrMainCategory.add(Recipes(4, "Seafood"))

        mainCategoryAdapter.setData(arrMainCategory)


        arrSubCategory.add(Recipes(1, "Seared Steak"))
        arrSubCategory.add(Recipes(2, "Chicken Parm"))
        arrSubCategory.add(Recipes(3, "Pork Ragu"))
        arrSubCategory.add(Recipes(4, "Seafood Stew"))

        subCategoryAdapter.setData(arrSubCategory)

        rv_main_category.layoutManager = LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL,false)
        rv_main_category.adapter = mainCategoryAdapter

        rv_sub_category.layoutManager = LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL,false)
        rv_sub_category.adapter = subCategoryAdapter

    }
}