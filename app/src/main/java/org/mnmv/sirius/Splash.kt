package org.mnmv.sirius

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity

class Splash : AppCompatActivity() {

    //Загрузочный экран
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val intent = Intent(this, General::class.java)
        startActivity(intent)
        finish()
    }
}