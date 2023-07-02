package com.example.empower

import android.app.Dialog
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.system.Os.close
import android.view.MenuItem
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.drawerlayout.widget.DrawerLayout
import com.google.android.material.navigation.NavigationView

class MainActivity : AppCompatActivity() {

    lateinit var toggle: ActionBarDrawerToggle
    lateinit var weekDialog: Dialog
    lateinit var monthDialog: Dialog

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

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
                    val intent = Intent(this@MainActivity, MainActivity::class.java)
                    startActivity(intent)
                }
                R.id.menuAbout -> {
                    Toast.makeText(applicationContext, "About Clicked", Toast.LENGTH_SHORT).show()
                    val intent = Intent(this@MainActivity, about::class.java)
                    startActivity(intent)
                }

//-----------------------------    6 WEEK COURSE ACTIVITY SCREEN -----------------------------------

                R.id.menuCourseCooking -> {
                    Toast.makeText(applicationContext, "Course clicked", Toast.LENGTH_SHORT).show()
                    val intent = Intent(this@MainActivity, course::class.java)
                    startActivity(intent)
                }
                R.id.menuCourseChild -> {
                    Toast.makeText(applicationContext, "Course clicked", Toast.LENGTH_SHORT).show()
                    val intent = Intent(this@MainActivity, childMinding::class.java)
                    startActivity(intent)
                }
                R.id.menuCourseGarden -> {
                Toast.makeText(applicationContext, "Course clicked", Toast.LENGTH_SHORT).show()
                val intent = Intent(this@MainActivity, gardenMaintanance::class.java)
                startActivity(intent)
            }

//-----------------------------    6 MONTH COURSE ACTIVITY SCREEN ----------------------------------

                R.id.menuCourseSewing -> {
                    Toast.makeText(applicationContext, "Course clicked", Toast.LENGTH_SHORT).show()
                    val intent = Intent(this@MainActivity, sewing::class.java)
                    startActivity(intent)
                }
                R.id.menuCourseSkills -> {
                    Toast.makeText(applicationContext, "Course clicked", Toast.LENGTH_SHORT).show()
                    val intent = Intent(this@MainActivity, skills::class.java)
                    startActivity(intent)
                }
                R.id.menuCourseAid -> {
                    Toast.makeText(applicationContext, "Course clicked", Toast.LENGTH_SHORT).show()
                    val intent = Intent(this@MainActivity, aid::class.java)
                    startActivity(intent)
                }
                R.id.menuCourseScaping -> {
                    Toast.makeText(applicationContext, "Course clicked", Toast.LENGTH_SHORT).show()
                    val intent = Intent(this@MainActivity, scaping::class.java)
                    startActivity(intent)
                }


//-----------------------------    PAY AND CONTACT ACTIVITY SCREEN----------------------------------


                R.id.menuPay -> {
                    Toast.makeText(applicationContext, "Course clicked", Toast.LENGTH_SHORT).show()
                    val intent = Intent(this@MainActivity, pay::class.java)
                    startActivity(intent)
                }
                R.id.menuContact -> {
                    Toast.makeText(applicationContext, "Course clicked", Toast.LENGTH_SHORT).show()
                    val intent = Intent(this@MainActivity, contact::class.java)
                    startActivity(intent)
                }
            }
            true
        }

//-----------------------------    SUMMARY PAGES    ------------------------------------------------

    val btnWeeks = findViewById<Button>(R.id.btnWeeks)
        btnWeeks.setOnClickListener {
            val intent = Intent (this@MainActivity, weekSummary::class.java)
            startActivity(intent)
        }

    val btnMonths = findViewById<Button>(R.id.btnMonths)
        btnMonths.setOnClickListener {
            val intent = Intent (this@MainActivity, monthSummary::class.java)
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