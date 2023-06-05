package com.example.empower

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import android.widget.Toast
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.drawerlayout.widget.DrawerLayout
import com.google.android.material.navigation.NavigationView

class contact : AppCompatActivity() {

    lateinit var toggle: ActionBarDrawerToggle

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_contact)

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
                    val intent = Intent(this@contact, MainActivity::class.java)
                    startActivity(intent)
                }
                R.id.menuAbout -> {
                    Toast.makeText(applicationContext, "About Clicked", Toast.LENGTH_SHORT).show()
                    val intent = Intent(this@contact, about::class.java)
                    startActivity(intent)
                }


//-------------------------------    6 WEEK ACTIVITY SCREEN ----------------------------------------

                R.id.menuCourseCooking -> {
                    Toast.makeText(applicationContext, "Course clicked", Toast.LENGTH_SHORT).show()
                    val intent = Intent(this@contact, course::class.java)
                    startActivity(intent)
                }
                R.id.menuCourseChild -> {
                    Toast.makeText(applicationContext, "Course clicked", Toast.LENGTH_SHORT).show()
                    val intent = Intent(this@contact, childMinding::class.java)
                    startActivity(intent)
                }
                R.id.menuCourseGarden -> {
                    Toast.makeText(applicationContext, "Course clicked", Toast.LENGTH_SHORT).show()
                    val intent = Intent(this@contact, gardenMaintanance::class.java)
                    startActivity(intent)
                }

//-------------------------------    6 MONTH ACTIVITY SCREEN ----------------------------------------


                R.id.menuCourseSewing -> {
                    Toast.makeText(applicationContext, "Course clicked", Toast.LENGTH_SHORT).show()
                    val intent = Intent(this@contact, sewing::class.java)
                    startActivity(intent)
                }
                R.id.menuCourseSkills -> {
                    Toast.makeText(applicationContext, "Course clicked", Toast.LENGTH_SHORT).show()
                    val intent = Intent(this@contact, skills::class.java)
                    startActivity(intent)
                }
                R.id.menuCourseAid -> {
                    Toast.makeText(applicationContext, "Course clicked", Toast.LENGTH_SHORT).show()
                    val intent = Intent(this@contact, aid::class.java)
                    startActivity(intent)
                }
                R.id.menuCourseScaping -> {
                    Toast.makeText(applicationContext, "Course clicked", Toast.LENGTH_SHORT).show()
                    val intent = Intent(this@contact, scaping::class.java)
                    startActivity(intent)
                }


//-------------------------------    PAY AND CONTACT ACTIVITY SCREEN--------------------------------

                R.id.menuPay -> {
                    Toast.makeText(applicationContext, "Course clicked", Toast.LENGTH_SHORT).show()
                    val intent = Intent(this@contact, pay::class.java)
                    startActivity(intent)
                }
                R.id.menuContact -> {
                    Toast.makeText(applicationContext, "Course clicked", Toast.LENGTH_SHORT).show()
                    val intent = Intent(this@contact, contact::class.java)
                    startActivity(intent)
                }
            }
            true
        }

    }
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (toggle.onOptionsItemSelected(item)) {
            return true
        }
        return super.onOptionsItemSelected(item)
    }
}