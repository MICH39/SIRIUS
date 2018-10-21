package org.mnmv.sirius

import android.content.Intent
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast

import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import com.google.android.material.floatingactionbutton.FloatingActionButton

class General : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.genral)

        //Верхняя
        val myToolbar = findViewById<Toolbar>(R.id.bottom_app_bar)
        setSupportActionBar(myToolbar)

        val fab_toMarks = findViewById<FloatingActionButton>(R.id.fab_marks)
        fab_toMarks.setOnClickListener {
            val go_toMarks = Intent(this@General, MM::class.java)
            startActivity(go_toMarks)
            Toast.makeText(this, "Модуль оценок открыт", Toast.LENGTH_SHORT).show()
            overridePendingTransition(0, 0)
        }
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        val menuInflater = menuInflater
        menuInflater.inflate(R.menu.nav_menu, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.nav_sets -> {
                val go_to_sets = Intent(this, Settings::class.java)
                startActivity(go_to_sets)
            }
            android.R.id.home -> {
                val bndf = BottomNavigationDrawerFragment()
                bndf.show(supportFragmentManager, "dialog")
            }
            else -> return super.onOptionsItemSelected(item)
        }
        return super.onOptionsItemSelected(item)

    }
}