package com.example.empower

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import android.widget.*
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.drawerlayout.widget.DrawerLayout
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.navigation.NavigationView
import com.google.gson.Gson

class pay : AppCompatActivity() {

    lateinit var toggle: ActionBarDrawerToggle

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_pay)

        var drawerLayout = findViewById<DrawerLayout>(R.id.drawerLayout)
        toggle = ActionBarDrawerToggle(this, drawerLayout, R.string.open, R.string.close)
        drawerLayout.addDrawerListener(toggle)
        toggle.syncState()

        supportActionBar?.setDisplayHomeAsUpEnabled(true)

//-------------------------------    DRAWER NAVIGATION      ----------------------------------------

        var navView = findViewById<NavigationView>(R.id.navView)
        navView.setNavigationItemSelectedListener { menuItem ->
            when (menuItem.itemId) {
                R.id.menuHome -> {
                    Toast.makeText(applicationContext, "Home Clicked", Toast.LENGTH_SHORT).show()
                    val intent = Intent(this@pay, MainActivity::class.java)
                    startActivity(intent)
                }
                R.id.menuAbout -> {
                    Toast.makeText(applicationContext, "About Clicked", Toast.LENGTH_SHORT).show()
                    val intent = Intent(this@pay, about::class.java)
                    startActivity(intent)
                }

//-------------------------------    6 WEEK ACTIVITY SCREEN ----------------------------------------

                R.id.menuCourseCooking -> {
                    Toast.makeText(applicationContext, "Course clicked", Toast.LENGTH_SHORT).show()
                    val intent = Intent(this@pay, course::class.java)
                    startActivity(intent)
                }
                R.id.menuCourseChild -> {
                    Toast.makeText(applicationContext, "Course clicked", Toast.LENGTH_SHORT).show()
                    val intent = Intent(this@pay, childMinding::class.java)
                    startActivity(intent)
                }
                R.id.menuCourseGarden -> {
                    Toast.makeText(applicationContext, "Course clicked", Toast.LENGTH_SHORT).show()
                    val intent = Intent(this@pay, gardenMaintanance::class.java)
                    startActivity(intent)
                }

//-------------------------------    6 MONTH ACTIVITY SCREEN ----------------------------------------


                R.id.menuCourseSewing -> {
                    Toast.makeText(applicationContext, "Course clicked", Toast.LENGTH_SHORT).show()
                    val intent = Intent(this@pay, sewing::class.java)
                    startActivity(intent)
                }
                R.id.menuCourseSkills -> {
                    Toast.makeText(applicationContext, "Course clicked", Toast.LENGTH_SHORT).show()
                    val intent = Intent(this@pay, skills::class.java)
                    startActivity(intent)
                }
                R.id.menuCourseAid -> {
                    Toast.makeText(applicationContext, "Course clicked", Toast.LENGTH_SHORT).show()
                    val intent = Intent(this@pay, aid::class.java)
                    startActivity(intent)
                }
                R.id.menuCourseScaping -> {
                    Toast.makeText(applicationContext, "Course clicked", Toast.LENGTH_SHORT).show()
                    val intent = Intent(this@pay, scaping::class.java)
                    startActivity(intent)
                }

//-------------------------------    PAY AND CONTACT ACTIVITY SCREEN--------------------------------

                R.id.menuPay -> {
                    Toast.makeText(applicationContext, "Course clicked", Toast.LENGTH_SHORT).show()
                    val intent = Intent(this@pay, pay::class.java)
                    startActivity(intent)
                }
                R.id.menuContact -> {
                    Toast.makeText(applicationContext, "Course clicked", Toast.LENGTH_SHORT).show()
                    val intent = Intent(this@pay, contact::class.java)
                    startActivity(intent)
                }
            }
            true
        }

//-------------------------------    RECYCLER VIEW    ----------------------------------------------

         var cartList = mutableListOf(
             Cart("Cooking", 750, true),
             Cart("Child Minding", 750, true),
             Cart("Garden Maintanance", 750, false),
             Cart("Sewing", 1500, true),
             Cart("Life Skills", 1500, true),
             Cart("First-Aid", 1500, false),
             Cart("Landscaping", 1500, true),
         )


        val subtotal = cartList.sumByDouble { it.price.toDouble() }
        val tvSubTotal = findViewById<TextView>(R.id.tvSubTotal)
        tvSubTotal.text = "Subtotal: $subtotal"

        val discount = cartList.sumOf { it.price.toDouble() * 0.15}
        val tvDiscount = findViewById<TextView>(R.id.tvDiscount)
        tvDiscount.text = "Discount : $discount"

        val total = subtotal - discount
        val tvTotal = findViewById<TextView>(R.id.tvTotal)
        tvTotal.text = "Total : $total"

        val adapter =  CartAdapter(cartList)
        val rvItems = findViewById<RecyclerView>(R.id.rvItems)
        rvItems.adapter = adapter
        rvItems.layoutManager = LinearLayoutManager(this)


//-------------------------------    MANUAL ADD TO CART (DNT DELETE YET)----------------------------
// Dont forget to uncomment the button and edit text in pay XML

//        val etItem = findViewById<EditText>(R.id.etItem)
//        val btnAddItem = findViewById<Button>(R.id.btnAddItem)
//        btnAddItem.setOnClickListener {
//            val title = etItem.text.toString()
//            val item = Cart(title, 0, true)
//            cartList.add(item)
//            adapter.notifyItemInserted(cartList.size -1)
//        }

//-------------------------------    LIST VIEW      ------------------------------------------------

//        val listView = findViewById<ListView>(R.id.listView)
//
//        val courseList = mutableListOf<String>()
//
//        val arrayAdapter: ArrayAdapter<String> = ArrayAdapter(
//            this, android.R.layout.simple_list_item_1, courseList
//        )
//
//        listView.adapter = arrayAdapter
//
//        listView.setOnItemClickListener { adapterView, view, i, l ->
//            Toast.makeText(this, "Course clicked" + courseList[i], Toast.LENGTH_SHORT).show()
//        }
//
//        val name = intent.getStringExtra("EXTRA_NAME",)
//        val price = intent.getIntExtra("EXTRA_VALUE", 750)
//
//        val cookingCourse = "$name  R$price"
//
//        courseList.add(cookingCourse)




























    }
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (toggle.onOptionsItemSelected(item)) {
            return true
        }
        return super.onOptionsItemSelected(item)
    }









}