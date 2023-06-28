package com.example.empower

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.system.Os.close
import android.view.MenuItem
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.drawerlayout.widget.DrawerLayout
import com.google.android.material.navigation.NavigationView

class sewing : AppCompatActivity() {

    lateinit var toggle: ActionBarDrawerToggle

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sewing)

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
                    val intent = Intent(this@sewing, MainActivity::class.java)
                    startActivity(intent)
                }
                R.id.menuAbout -> {
                    Toast.makeText(applicationContext, "About Clicked", Toast.LENGTH_SHORT).show()
                    val intent = Intent(this@sewing, about::class.java)
                    startActivity(intent)
                }

//-----------------------------    6 WEEK COURSE ACTIVITY SCREEN -----------------------------------

                R.id.menuCourseCooking -> {
                    Toast.makeText(applicationContext, "Course clicked", Toast.LENGTH_SHORT).show()
                    val intent = Intent(this@sewing, course::class.java)
                    startActivity(intent)
                }
                R.id.menuCourseChild -> {
                    Toast.makeText(applicationContext, "Course clicked", Toast.LENGTH_SHORT).show()
                    val intent = Intent(this@sewing, childMinding::class.java)
                    startActivity(intent)
                }
                R.id.menuCourseGarden -> {
                    Toast.makeText(applicationContext, "Course clicked", Toast.LENGTH_SHORT).show()
                    val intent = Intent(this@sewing, gardenMaintanance::class.java)
                    startActivity(intent)
                }

//-----------------------------    6 MONTH COURSE ACTIVITY SCREEN ----------------------------------

                R.id.menuCourseSewing -> {
                    Toast.makeText(applicationContext, "Course clicked", Toast.LENGTH_SHORT).show()
                    val intent = Intent(this@sewing, sewing::class.java)
                    startActivity(intent)
                }
                R.id.menuCourseSkills -> {
                    Toast.makeText(applicationContext, "Course clicked", Toast.LENGTH_SHORT).show()
                    val intent = Intent(this@sewing, skills::class.java)
                    startActivity(intent)
                }
                R.id.menuCourseAid -> {
                    Toast.makeText(applicationContext, "Course clicked", Toast.LENGTH_SHORT).show()
                    val intent = Intent(this@sewing, aid::class.java)
                    startActivity(intent)
                }
                R.id.menuCourseScaping -> {
                    Toast.makeText(applicationContext, "Course clicked", Toast.LENGTH_SHORT).show()
                    val intent = Intent(this@sewing, scaping::class.java)
                    startActivity(intent)
                }


//-----------------------------    PAY AND CONTACT ACTIVITY SCREEN----------------------------------


                R.id.menuPay -> {
                    Toast.makeText(applicationContext, "Course clicked", Toast.LENGTH_SHORT).show()
                    val intent = Intent(this@sewing, pay::class.java)
                    startActivity(intent)
                }
                R.id.menuContact -> {
                    Toast.makeText(applicationContext, "Course clicked", Toast.LENGTH_SHORT).show()
                    val intent = Intent(this@sewing, contact::class.java)
                    startActivity(intent)
                }
            }
            true
        }

//-------------------------------------ADD TO CART BUTTON-------------------------------------------

        val enrollBtn = findViewById<Button>(R.id.enrollBtn)


        enrollBtn.setOnClickListener {
            val name = "Sewing (6 Months)"
            val price = 1500

            Intent(this, pay::class.java).also {
                it.putExtra("EXTRA_NAME", name)
                it.putExtra("EXTRA_VALUE", price)
                startActivity(it)

            }
        }

//-----------------------------  BUTTON NAVIGATION BACK AND NEXT------------------------------------

        var btnBack = findViewById<Button>(R.id.btnBack)
        var btnNext = findViewById<Button>(R.id.btnNext)

        btnBack.setOnClickListener {
            val intent = Intent(this, gardenMaintanance::class.java)
            startActivity(intent)
        }

        btnNext.setOnClickListener {
            val intent = Intent(this, skills::class.java)
            startActivity(intent)
        }



    }
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (toggle.onOptionsItemSelected(item)) {
            return true
        }
        return super.onOptionsItemSelected(item)
    }
}