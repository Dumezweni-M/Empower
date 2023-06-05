package com.example.empower

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.drawerlayout.widget.DrawerLayout
import com.google.android.material.navigation.NavigationView

class gardenMaintanance : AppCompatActivity() {

    lateinit var toggle: ActionBarDrawerToggle

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_garden_maintanance)
        var drawerLayout = findViewById<DrawerLayout>(R.id.drawerLayout)
        toggle = ActionBarDrawerToggle(this, drawerLayout, R.string.open, R.string.close)
        drawerLayout.addDrawerListener(toggle)
        toggle.syncState()

        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        var navView = findViewById<NavigationView>(R.id.navView)
        navView.setNavigationItemSelectedListener { menuItem ->
            when (menuItem.itemId) {
                R.id.menuHome -> {
                    Toast.makeText(applicationContext, "Home Clicked", Toast.LENGTH_SHORT).show()
                    val intent = Intent(this@gardenMaintanance, MainActivity::class.java)
                    startActivity(intent)
                }
                R.id.menuAbout -> {
                    Toast.makeText(applicationContext, "About Clicked", Toast.LENGTH_SHORT).show()
                    val intent = Intent(this@gardenMaintanance, about::class.java)
                    startActivity(intent)
                }


//-----------------------------    6 WEEK COURSE ACTIVITY SCREEN -----------------------------------

                R.id.menuCourseCooking -> {
                    Toast.makeText(applicationContext, "Course clicked", Toast.LENGTH_SHORT).show()
                    val intent = Intent(this@gardenMaintanance, course::class.java)
                    startActivity(intent)
                }
                R.id.menuCourseChild -> {
                    Toast.makeText(applicationContext, "Course clicked", Toast.LENGTH_SHORT).show()
                    val intent = Intent(this@gardenMaintanance, childMinding::class.java)
                    startActivity(intent)
                }
                R.id.menuCourseGarden -> {
                    Toast.makeText(applicationContext, "Course clicked", Toast.LENGTH_SHORT).show()
                    val intent = Intent(this@gardenMaintanance, gardenMaintanance::class.java)
                    startActivity(intent)
                }

//-----------------------------  PAY AND CONTACT ACTIVITY SCREEN -----------------------------------

                R.id.menuPay -> {
                    Toast.makeText(applicationContext, "Course clicked", Toast.LENGTH_SHORT).show()
                    val intent = Intent(this@gardenMaintanance, pay::class.java)
                    startActivity(intent)
                }
                R.id.menuContact -> {
                    Toast.makeText(applicationContext, "Course clicked", Toast.LENGTH_SHORT).show()
                    val intent = Intent(this@gardenMaintanance, contact::class.java)
                    startActivity(intent)
                }
            }
            true
        }



//-------------------------------------ADD TO CART BUTTON-------------------------------------------



        val enrollBtn = findViewById<Button>(R.id.enrollBtn)
        val priceView = findViewById<TextView>(R.id.priceView)
        val nameView = findViewById<TextView>(R.id.nameView)

        enrollBtn.setOnClickListener {
            val name = "Gardening"
            val price = 750

            Intent(this, pay::class.java).also {
                it.putExtra("EXTRA_NAME", name)
                it.putExtra("EXTRA_VALUE", price)
                startActivity(it)

            }
        }






//----------------------     END OF ON CREATE -------------------------------------------------------
    }
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (toggle.onOptionsItemSelected(item)) {
            return true
        }
        return super.onOptionsItemSelected(item)
    }
}