package com.example.hippo

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.viewpager.widget.ViewPager
import com.example.hippo.ui.SecurePrefs
import com.example.hippo.ui.main.SectionsPagerAdapter
import com.google.android.material.tabs.TabLayout
import com.google.gson.Gson

data class TokenAuth(
    val token: String
)

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val sectionsPagerAdapter = SectionsPagerAdapter(this, supportFragmentManager)
        val viewPager: ViewPager = findViewById(R.id.view_pager)
        viewPager.adapter = sectionsPagerAdapter
        val tabs: TabLayout = findViewById(R.id.tabs)
        tabs.setupWithViewPager(viewPager)

        (application as App).socket.emit(
            "doAuth",
            Gson().toJson(TokenAuth(SecurePrefs.getToken()!!))
        )
    }
}
