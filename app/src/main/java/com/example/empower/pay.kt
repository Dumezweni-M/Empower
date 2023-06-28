package com.example.empower

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

class pay : AppCompatActivity() {

    lateinit var toggle: ActionBarDrawerToggle
//    private lateinit var adapter: CartAdapter
    private val cartList = CartManager.cartList

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

//         var cartList = mutableListOf(
////             Cart("Cooking", 750, true),
////             Cart("Child Minding", 750, true),
////             Cart("Garden Maintenance", 750, true),
////             Cart("Sewing", 1500, true),
//             Cart("First-Aid (6 Months)" , 1500, true),
//             Cart("Life Skills (6 Months)", 1500, true),
//             Cart("Landscaping (6 Months)", 1500, true),
//         )

        val adapter =  CartAdapter(cartList)
        val rvItems = findViewById<RecyclerView>(R.id.rvItems)
        rvItems.adapter = adapter
        rvItems.layoutManager = LinearLayoutManager(this)



        val name = intent.getStringExtra("EXTRA_NAME")
        val price = intent.getIntExtra("EXTRA_VALUE", 750)
        val cartItem = name?.let { Cart(it, price, true) }

        if (cartItem != null) {
            CartManager.cartList.add (cartItem)
            adapter.notifyItemInserted(cartList.size)
        }

        val cartSize = cartList.size
        var discountPercentage = 0.0

        when (cartSize) {
            1 -> discountPercentage = 0.0
            2 -> discountPercentage = 0.05
            3 -> discountPercentage = 0.10
            else -> discountPercentage = 0.15
        }

        val subtotal = cartList.sumByDouble { it.price.toDouble() }
        val discount = subtotal * discountPercentage
        val total = subtotal - discount

        val tvSubTotal = findViewById<TextView>(R.id.tvSubTotal)
        tvSubTotal.text = "Subtotal: R $subtotal"

        val tvDiscount = findViewById<TextView>(R.id.tvDiscount)
        tvDiscount.text = "$discountPercentage% " + " Discount : R $discount"

        val tvTotal = findViewById<TextView>(R.id.tvTotal)
        tvTotal.text = "Total: R $total"

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

//        val name = intent.getStringExtra("EXTRA_NAME",)
//        val price = intent.getIntExtra("EXTRA_VALUE", 750)
//
//        val cookingCourse = "$name  R$price"
//
//        cartList.add(cookingCourse)




























    }
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (toggle.onOptionsItemSelected(item)) {
            return true
        }
        return super.onOptionsItemSelected(item)
    }









}

private operator fun Boolean.invoke(function: () -> Unit) {

}

private fun <E> MutableList<E>.add(element: String) {

}
