package org.mnmv.sirius

import android.content.Intent
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem

import com.google.android.material.tabs.TabLayout
import androidx.appcompat.app.AppCompatActivity
import androidx.viewpager.widget.ViewPager
import com.google.android.material.bottomappbar.BottomAppBar
import com.google.android.material.floatingactionbutton.FloatingActionButton

class MM : AppCompatActivity() {

    private var mSectionsPageAdapter: SectionsPageAdapter? = null
    private var mViewPager: ViewPager? = null
    private var currentFabAlignmentMode = BottomAppBar.FAB_ALIGNMENT_MODE_END

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.mm)

        mSectionsPageAdapter = SectionsPageAdapter(supportFragmentManager)

        // Set up the ViewPager with the sections adapter.
        mViewPager = findViewById(R.id.view_tabs)
        setupViewPager(mViewPager!!)

        val bar = findViewById<BottomAppBar>(R.id.bottom_app_bar)
        setSupportActionBar(bar)
        bar.fabAlignmentMode = currentFabAlignmentMode

        val tabLayout = findViewById<TabLayout>(R.id.tabs)
        tabLayout.setupWithViewPager(mViewPager)

        val fab_toGen = findViewById<FloatingActionButton>(R.id.fab_undogen)
        fab_toGen.setOnClickListener {
            val go_toGen = Intent(this@MM, General::class.java)
            startActivity(go_toGen)
            overridePendingTransition(0, 0)
            finish()
        }


    }

    private fun BottomAppBar.toggleFabAlignment() {
        currentFabAlignmentMode = fabAlignmentMode
        fabAlignmentMode = currentFabAlignmentMode.xor(1)
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

    private fun setupViewPager(viewPager: ViewPager) {
        val adapter = SectionsPageAdapter(supportFragmentManager)
        adapter.addFragment(Mm_marks(), getString(R.string.marks))
        adapter.addFragment(Mm_vedom(), getString(R.string.vedom))
        adapter.addFragment(Mm_ord(), getString(R.string.ord))
        viewPager.adapter = adapter
    }
}
