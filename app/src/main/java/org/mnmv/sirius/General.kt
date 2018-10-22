package org.mnmv.sirius

import android.app.ActionBar
import android.content.Intent
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.view.animation.AnimationUtils
import android.widget.FrameLayout
import android.widget.ImageView
import android.widget.Toast

import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.bottomappbar.BottomAppBar
import com.google.android.material.bottomappbar.BottomAppBar.FAB_ALIGNMENT_MODE_CENTER
import com.google.android.material.bottomappbar.BottomAppBar.FAB_ALIGNMENT_MODE_END
import com.google.android.material.floatingactionbutton.FloatingActionButton

class General : AppCompatActivity() {

    private var currentFabAlignmentMode = FAB_ALIGNMENT_MODE_CENTER
    private var currentFabAlignmentMode2 = FAB_ALIGNMENT_MODE_END

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.general)

        //Верхняя
        val bar = findViewById<BottomAppBar>(R.id.bottom_app_bar)
        setSupportActionBar(bar)
        bar.fabAlignmentMode = currentFabAlignmentMode

        val fab_toMarks = findViewById<FloatingActionButton>(R.id.fab_marks)
        fab_toMarks.setOnClickListener {
            val go_toMarks = Intent(this@General, MM::class.java)
            startActivity(go_toMarks)
            overridePendingTransition(0, 0)
            finish()
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